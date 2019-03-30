package projet.DAO;

import projet.metier.Vue_Formateur;
import myconnections.DBConnection;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.*;
import java.sql.*;

public class Vue_FormateurDAO extends DAO<Vue_Formateur> {

    /**
     * récupération des données de la vue SESS_FORMATEUR sur base de son
     * identifiant.      *
     * @param idform
     *
     * @throws java.sql.SQLException
     */
    Connection dbConnect = DBConnection.getConnection();

    public List<Vue_Formateur> SessionFormateur(int idform) throws SQLException {

        List<Vue_Formateur> VueForm = new ArrayList<>();

        String req = "select * from SESS_FORMATEUR where idform=?";

        try (PreparedStatement p = dbConnect.prepareStatement(req)) {

            p.setInt(1, idform);

            try (ResultSet rs = p.executeQuery()) {
                while (rs.next()) {

                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String matiere = rs.getString("MATIERE");
                    int idsesscours = rs.getInt("IDSESSCOURS");
                    LocalDate datedebut = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate datefin = rs.getDate("DATEFIN").toLocalDate();

                    VueForm.add(new Vue_Formateur(idform, nom, prenom, matiere, idsesscours, datedebut, datefin));
                }
            } catch (SQLException e) {
                System.out.println("Erreur affichage vue formateur " + e);
            }
        } catch (SQLException e) {
            System.out.println("Erreur vue formateur " + e);
        }
        return VueForm;
    }

    @Override
    public Vue_Formateur create(Vue_Formateur obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vue_Formateur read(int idform) throws SQLException {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Vue_Formateur update(Vue_Formateur obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Vue_Formateur obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
