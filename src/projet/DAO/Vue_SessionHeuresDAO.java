package projet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import myconnections.DBConnection;
import projet.metier.Vue_SessionHeures;

public class Vue_SessionHeuresDAO extends DAO<Vue_SessionHeures> {

    Connection dbConnect = DBConnection.getConnection();

    public List<Vue_SessionHeures> SessionHeures(int idsesscours) throws SQLException {
        /**
         * récupération des données de la vue SESSIONS_HEURE sur base de son
         * identifiant.
         *
         *
         * @param idsesscours
         *
         * @throws java.sql.SQLException
         */
        List<Vue_SessionHeures> VueHeures = new ArrayList<>();

        String req = "select * from HEURES_SESSION where idsesscours=?";

        try (PreparedStatement p = dbConnect.prepareStatement(req)) {

            p.setInt(1, idsesscours);

            try (ResultSet rs = p.executeQuery()) {
                while (rs.next()) {

                    int TotalHeures = rs.getInt("TotalHeures");
                    VueHeures.add(new Vue_SessionHeures(idsesscours, TotalHeures));
                }
            } catch (SQLException e) {
                System.out.println("Erreur affichage vue heures " + e);
            }
        } catch (SQLException e) {
            System.out.println("Erreur vue heures " + e);
        }
        return VueHeures;
    }

    @Override
    public Vue_SessionHeures create(Vue_SessionHeures obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vue_SessionHeures read(int idsesscours) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vue_SessionHeures update(Vue_SessionHeures obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Vue_SessionHeures obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
