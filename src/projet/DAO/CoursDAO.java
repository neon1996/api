/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.description.Cours;

/**
 *
 * @author Florence
 */
public class CoursDAO extends DAO<Cours> {

    @Override
    public Cours create(Cours obj) throws SQLException {
        String req1 = "insert into pro_cours(matiere,heures) values(?,?)";
        String req2 = "select idcours from pro_cours where matiere = ? and heures=? ";

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {

            pstm1.setString(1, obj.getMatiere());
            pstm1.setInt(2, obj.getHeures());

            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation (cours), aucune ligne n'a été créée");
            }

            pstm2.setString(1, obj.getMatiere());
            pstm2.setInt(2, obj.getHeures());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idcours = rs.getInt(1);
                    obj.setIdcours(idcours);
                    return read(idcours);
                } else {
                    throw new SQLException("Erreur de création d'un nouveau cours, introuvable");
                }
            }
        }
    }

    @Override
    public Cours read(int idcours) throws SQLException {
        String req = "select * from pro_cours where idcours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idcours);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    String matiere = rs.getString("MATIERE");
                    int heures = rs.getInt("HEURES");

                    return new Cours(idcours, matiere, heures);

                } else {
                    throw new SQLException("Cours inconnu");
                }

            }
        }
    }

    public Cours readMatiere(String matiere) throws SQLException {
        String req = "select * from pro_cours where lower(matiere) = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, matiere);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    int idcours = rs.getInt("IDCOURS");
                    int heures = rs.getInt("HEURES");

                    return new Cours(idcours, matiere, heures);

                } else {
                    throw new SQLException("Cours inconnu");
                }

            }
        }
    }

    @Override
    public Cours update(Cours obj) throws SQLException {

        String req = "update pro_cours set heures=? where matiere=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(2, obj.getMatiere());
            pstm.setInt(1, obj.getHeures());

            int n = pstm.executeUpdate();

            System.out.println("Informations mise à jour !");
            
        } catch (SQLException e) {
            System.out.println("Aucune ligne cours a été mise à jour");
        }

        return obj;

    }

    @Override
    public void delete(Cours obj) throws SQLException {
        String req = "delete from pro_cours where matiere= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getMatiere());
            int n = pstm.executeUpdate();

            System.out.println("Le cours a été correctement supprimé de la base de données ! ");

        } catch (SQLException e) {
            System.out.println("Aucune ligne effacée : le cours n'existe pas dans la BDD ! ");
        }
    }

}
