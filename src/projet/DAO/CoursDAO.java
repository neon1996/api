package projet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import myconnections.DBConnection;
import projet.metier.Cours;
import projet.metier.Sessioncours;

public class CoursDAO extends DAO<Cours> {

    Connection dbConnect = DBConnection.getConnection();

    /**
     * création d'un cours sur base de son identifiant dans la bdd.
     *
     * @throws SQLException erreur de création
     * @param obj cours à créer
     * @return cours créé
     */
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

    /**
     * récupération des données d'un cours sur base de son identifiant
     * cours@throws SQLException local inconnu
     *
     * @param idcours
     * @return cours trouvé
     * @throws java.sql.SQLException
     */
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

    /**
     * mise à jour des données d'un Cours sur base de sa matiere
     *
     * @return Cours
     * @param obj Cours à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Cours update(Cours obj) throws SQLException {

        String req = "update pro_cours set heures=?, matiere=? where idcours=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(3, obj.getIdcours());
            pstm.setString(2, obj.getMatiere());
            pstm.setInt(1, obj.getHeures());

            int n = pstm.executeUpdate();

            System.out.println("Informations mise à jour !");

        } catch (SQLException e) {
            System.out.println("Aucune ligne cours a été mise à jour");
        }

        return obj;

    }

    /**
     * effacement d'un cours sur base de sa matiere
     *
     * @throws SQLException erreur d'effacement
     * @param obj cours à effacer
     */
    @Override
    public void delete(Cours obj) throws SQLException {
        String req = "delete from pro_cours where idcours= ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdcours());
            int n = pstm.executeUpdate();

            System.out.println("Le cours a été correctement supprimé de la base de données ! ");

        } catch (SQLIntegrityConstraintViolationException custom) {
            throw new SQLException("Impossible de supprimer car le cours est dans une session cours");
        }

    }

    public List<Cours> rechMatiere(String descriptionmat) throws SQLException {

        List<Cours> searchmat = new ArrayList<>();

        String req = "select * from pro_cours where lower(matiere) like ? ";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%" + descriptionmat + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {

                    trouve = true;

                    int idcours = rs.getInt("IDCOURS");
                    String matiere = rs.getString("MATIERE");
                    int heures = rs.getInt("HEURES");

                    searchmat.add(new Cours(idcours, matiere, heures));
                }

            } catch (SQLException e) {
                System.out.println("Erreur affichage (recherche cours - matiere) : " + e);
            }
        } catch (SQLException e) {
            System.out.println("Erreur requete cours (recherche cours - matiere)" + e);

        }
        return searchmat;
    }
    
    public List<Cours> aff_comboCours() throws SQLException{
        List<Cours> co = new ArrayList();
        String req = "select * from pro_cours";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int idcours = rs.getInt("IDCOURS");
                    String matiere = rs.getString("MATIERE");
                    int heures = rs.getInt("HEURES");
                    
                    co.add(new Cours(idcours,matiere,heures));
                }
            }
        }
        return co;
}

}
