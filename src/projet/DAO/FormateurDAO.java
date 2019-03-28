package projet.DAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import projet.description.Formateur;

public class FormateurDAO extends DAO<Formateur> {

    @Override
    public Formateur create(Formateur obj) throws SQLException {
        String req1 = "insert into pro_formateur(matricule,nom,prenom,numero,rue,localite,cp,tel) values(?,?,?,?,?,?,?,?)";
        String req2 = "select idform from pro_formateur where matricule =? and nom =? and prenom =? " /* + "and numero =? and rue =? and localite =? and cp =? and tel =?"*/;

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {

            pstm1.setString(1, obj.getMatricule());
            pstm1.setString(2, obj.getNom());
            pstm1.setString(3, obj.getPrenom());
            pstm1.setString(4, obj.getNumero());
            pstm1.setString(5, obj.getRue());
            pstm1.setString(6, obj.getLocalite());
            pstm1.setInt(7, obj.getCp());
            pstm1.setString(8, obj.getTelephone());

            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation (cours), aucune ligne n'a été créée");
            }

            pstm2.setString(1, obj.getMatricule());
            pstm2.setString(2, obj.getNom());
            pstm2.setString(3, obj.getPrenom());
            /* pstm2.setString(4, obj.getNumero());
            pstm2.setString(5, obj.getRue());
            pstm2.setString(6, obj.getLocalite());
            pstm2.setInt(7, obj.getCp());
            pstm2.setString(8, obj.getTelephone());*/

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idcours = rs.getInt(1);
                    obj.setIdform(idcours);
                    return read(idcours);
                } else {
                    throw new SQLException("Erreur de création d'un nouveau cours, introuvable");
                }
            }
        }
    }

    @Override
    public Formateur read(int idform) throws SQLException {
        String req = "select * from pro_formateur where idform = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idform);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    String matricule = rs.getString("MATRICULE");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String numero = rs.getString("NUMERO");
                    String rue = rs.getString("RUE");
                    String localite = rs.getString("LOCALITE");
                    int cp = rs.getInt("CP");
                    String tel = rs.getString("TEL");

                    return new Formateur(idform, matricule, nom, prenom, numero, rue, localite, cp, tel);
                } else {
                    throw new SQLException("Formateur inconnu");
                }

            }
        }
    }

    public Formateur readMatricule(String matricule) throws SQLException {
        String req = "select * from pro_formateur where matricule = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, matricule);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    int idform = rs.getInt("IDFORM");
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String numero = rs.getString("NUMERO");
                    String rue = rs.getString("RUE");
                    String localite = rs.getString("LOCALITE");
                    int cp = rs.getInt("CP");
                    String tel = rs.getString("TEL");

                    return new Formateur(idform, matricule, nom, prenom, numero, rue, localite, cp, tel);
                } else {
                    throw new SQLException("Formateur inconnu");
                }

            }
        }
    }

    @Override
    public Formateur update(Formateur obj) throws SQLException {
        String req = "update pro_formateur set nom=?,prenom=?,"
                + "numero=?,rue=?,localite=?,cp=?,tel=? where matricule=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(8, obj.getMatricule());
            pstm.setString(1, obj.getNom());
            pstm.setString(2, obj.getPrenom());
            pstm.setString(3, obj.getNumero());
            pstm.setString(4, obj.getRue());
            pstm.setString(5, obj.getLocalite());
            pstm.setInt(6, obj.getCp());
            pstm.setString(7, obj.getTelephone());

            int n = pstm.executeUpdate();

            System.out.println("Informations mise à jour !");

        } catch (SQLException e) {
            System.out.println("Aucune ligne formateur a été mise à jour");
        }
        return obj;
    }

    @Override
    public void delete(Formateur obj) throws SQLException {
        String req = "delete from pro_formateur where nom= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getNom());
            int n = pstm.executeUpdate();

            System.out.println("Le formateur a été correctement supprimé de la base de données ! ");

        } catch (SQLException e) {
            System.out.println("Aucune ligne effacée : le formateur n'existe pas dans la BDD !");
        }
    }

}
