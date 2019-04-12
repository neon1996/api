package projet.DAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import myconnections.DBConnection;
import projet.metier.Local;

public class LocalDAO extends DAO<Local> {

    Connection dbConnect = DBConnection.getConnection();

    /**
     * création d'un local sur base des valeurs de son objet métier
     * (projet.metier)
     *
     * @throws SQLException erreur de création
     * @param obj local à créer
     * @return local créé
     */
    @Override
    public Local create(Local obj) throws SQLException {
        String req1 = "insert into pro_local(sigle,places,description) values(?,?,?)";
        String req2 = "select idlocal from pro_local where sigle = ? and places=? and description=? ";

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {

            pstm1.setString(1, obj.getSigle());
            pstm1.setInt(2, obj.getPlaces());
            pstm1.setString(3, obj.getDescription());

            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("Erreur de creation (local), aucune ligne n'a été créée");
            }

            pstm2.setString(1, obj.getSigle());
            pstm2.setInt(2, obj.getPlaces());
            pstm2.setString(3, obj.getDescription());
            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idlocal = rs.getInt(1);
                    obj.setIdlocal(idlocal);
                    return read(idlocal);
                } else {
                    throw new SQLException("Erreur de création d'un nouveau local, introuvable");
                }
            }
        }

    }

    /**
     * récupération des données d'un local sur base de son sigle. local@throws
     * SQLException local inconnu
     *
     * @param sigle
     * @return local trouvé
     * @throws java.sql.SQLException
     */
    public Local readSigle(String sigle) throws SQLException {

        String req = "select * from pro_local where sigle = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, sigle);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    int idlocal = rs.getInt("IDLOCAL");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");

                    return new Local(idlocal, sigle, places, description);

                } else {
                    throw new SQLException("Sigle du local inconnu");
                }

            }
        }

    }

    /**
     * récupération des données d'un local sur base de son identifiant
     * local@throws SQLException local inconnu
     *
     * @param idlocal
     * @return local trouvé
     * @throws java.sql.SQLException
     */
    @Override
    public Local read(int idlocal) throws SQLException {

        String req = "select * from pro_local where idlocal = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idlocal);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    String sigle = rs.getString("SIGLE");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");

                    return new Local(idlocal, sigle, places, description);

                } else {
                    throw new SQLException("Sigle du local inconnu");
                }

            }
        }

    }

    /**
     * mise à jour des données d'un local sur base de son identifiant
     *
     * @return Local
     * @param obj Local à mettre à jour
     * @throws SQLException erreur de mise à jour
     */
    @Override
    public Local update(Local obj) throws SQLException {

        String req = "update pro_local set places=?, description=? where sigle=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(3, obj.getSigle());
            pstm.setInt(1, obj.getPlaces());
            pstm.setString(2, obj.getDescription());

            int n = pstm.executeUpdate();
            System.out.println("Les données du local ont été correctement mise à jour");

        } catch (SQLException e) {
            System.out.println("Erreur lors de la MAJ du local");
        }
        return obj;
    }

    /**
     * effacement d'un local sur base de son sigle
     *
     * @throws SQLException erreur d'effacement
     * @param obj local à effacer
     */
    @Override
    public void delete(Local obj) throws SQLException {
        String req = "delete from pro_local where sigle= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setString(1, obj.getSigle());
            int n = pstm.executeUpdate();

            System.out.println("Le local a été correctement supprimé de la base de données ! ");

        } catch (SQLException e) {
            System.out.println("Aucune ligne effacée : le local n'existe pas dans la BDD !");
        }
    }

    /**
     * méthode permettant de récupérer tous les locaux ayant une certaine
     * description
     *
     * @param descriptionrech = description recherchée
     * @return liste de locaux
     * @throws SQLException local inconnu
     */
    public List<Local> rechDescription(String descriptionrech) throws SQLException {

        List<Local> searchdesc = new ArrayList<>();

        String req = "select * from pro_local where lower(description) like ? ";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setString(1, "%" + descriptionrech + "%");
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {

                    trouve = true;

                    int idlocal = rs.getInt("IDLOCAL");
                    String sigle = rs.getString("SIGLE");
                    int places = rs.getInt("PLACES");
                    String description = rs.getString("DESCRIPTION");

                    searchdesc.add(new Local(idlocal, sigle, places, description));
                }

            } catch (SQLException e) {
                System.out.println("Erreur affichage (recherche local - description) : " + e);
            }
        } catch (SQLException e) {
            System.out.println("Erreur requete local (recherche local - description)" + e);

        }
        return searchdesc;
    }
}
