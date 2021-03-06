package projet.DAO;

import java.sql.Connection;
import java.util.*;
import java.sql.*;
import projet.metier.Sessioncours;
import java.time.LocalDate;
import myconnections.DBConnection;
import projet.metier.Vue_Formateur;

public class SessioncoursDAO extends DAO<Sessioncours> {

    Connection dbConnect = DBConnection.getConnection();

    @Override
    public Sessioncours create(Sessioncours obj) throws SQLException {

        String req1 = "insert into pro_sessioncours(datedebut,datefin,nbreinscrits,idlocal,idcours) values(?,?,?,?,?)";
        String req2 = "select idsesscours from pro_sessioncours where datedebut=? and datefin=? and nbreinscrits=? and idlocal=? and idcours=? ";

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {
 
            pstm1.setDate(1, java.sql.Date.valueOf(obj.getDateDebut()));
            pstm1.setDate(2, java.sql.Date.valueOf(obj.getDateFin()));
            pstm1.setInt(3, obj.getNbreinscrits());
            pstm1.setInt(4, obj.getIdlocal());
            pstm1.setInt(5, obj.getIdcours());

            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation (session cours), aucune ligne n'a été créée");
            }

            pstm2.setDate(1, java.sql.Date.valueOf(obj.getDateDebut()));
            pstm2.setDate(2, java.sql.Date.valueOf(obj.getDateFin()));
            pstm2.setInt(3, obj.getNbreinscrits());
            pstm2.setInt(4, obj.getIdlocal());
            pstm2.setInt(5, obj.getIdcours());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idsesscours = rs.getInt(1);
                    obj.setIdsesscours(idsesscours);
                    return read(idsesscours);
                } else {
                    throw new SQLException("Erreur de création d'une nouvelle session de cours, introuvable");
                }
            }
        }
    }

    @Override
    public Sessioncours read(int idsesscours) throws SQLException {
        String req = "select * from pro_sessioncours where idsesscours = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idsesscours);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    LocalDate datedebut = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate datefin = rs.getDate("DATEFIN").toLocalDate();
                    int nbreinscrits = rs.getInt("NBREINSCRITS");
                    int idlocal = rs.getInt("IDLOCAL");
                    int idcours = rs.getInt("IDCOURS");
                   

                    return new Sessioncours(idsesscours, datedebut, datefin, nbreinscrits, idlocal, idcours);
                } else {
                    throw new SQLException("Session de cours inconnue");
                }

            }
        }
    }
    
    

    @Override
    public Sessioncours update(Sessioncours obj) throws SQLException {
        String req = "update pro_sessioncours set datedebut=?,datefin=?,nbreinscrits=?,idlocal=?,idcours=?"
                + "where idsesscours=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(6, obj.getIdsesscours());
            pstm.setDate(1, java.sql.Date.valueOf(obj.getDateDebut()));
            pstm.setDate(2, java.sql.Date.valueOf(obj.getDateFin()));
            pstm.setInt(3, obj.getNbreinscrits());
            pstm.setInt(4, obj.getIdlocal());
            pstm.setInt(5, obj.getIdcours());
            
            

            int n = pstm.executeUpdate();

            System.out.println("Informations mise à jour !");

        } catch (SQLException e) {
            System.out.println("Aucune ligne session cours n'a été mise à jour");
        }
        return obj;
    }

    @Override
    public void delete(Sessioncours obj) throws SQLException {
        String req = "delete from pro_sessioncours where idsesscours= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdsesscours());
            int n = pstm.executeUpdate();

            System.out.println("La session de cours a été correctement supprimée de la base de données ! ");

        } catch (SQLIntegrityConstraintViolationException custom) {
            throw new SQLException("Impossible de supprimer - idsesscours lié à la table infos !");
        }
    }
    
    public List<Vue_Formateur> rechSessionF(int idform) throws SQLException {
        List<Vue_Formateur> vueF = new ArrayList<>();
        String req = "select * from sess_formateur where idform= ?";
        dbConnect = DBConnection.getConnection();
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idform);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    
                    String nom = rs.getString("NOM");
                    String prenom = rs.getString("PRENOM");
                    String matiere = rs.getString("MATIERE");
                    int idsesscours = rs.getInt("IDSESSCOURS");
                    LocalDate datedebut = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate datefin = rs.getDate("DATEFIN").toLocalDate();

                    vueF.add(new Vue_Formateur(idform, nom, prenom, matiere, idsesscours, datedebut, datefin));
                }

                if (!trouve) {
                    throw new SQLException("Element inconnu");
                } else {
                    return vueF;
                }
            }
        }
    }
    
    /* Méthode servent dans le SWING afin d'afficher la session_cours d'un cours recherché*/
    public List<Sessioncours> RechCours_Sesscours(int idsesscoursrech) throws SQLException {
        List<Sessioncours> rechsess = new ArrayList<>();
        String req = "select * from pro_sessioncours where idcours = ? ";
     

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            pstm.setInt(1, idsesscoursrech);
            try (ResultSet rs = pstm.executeQuery()) {
                boolean trouve = false;
                while (rs.next()) {
                    trouve = true;
                    int idsesscours = rs.getInt("IDSESSCOURS");
                    LocalDate datedebut = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate datefin = rs.getDate("DATEFIN").toLocalDate();
                    int nbreinscrits = rs.getInt("NBREINSCRITS");
                    int idlocal = rs.getInt("IDLOCAL");
                    int idcours = rs.getInt("IDCOURS");

                    rechsess.add(new Sessioncours(idsesscours, datedebut, datefin, nbreinscrits, idlocal, idcours));
                }

                if (!trouve) {
                    throw new SQLException("Identifiant de cours inconnu dans les sessions cours");
                } else {
                    return rechsess;
                }
            }
        }

    }
    
    public List<Sessioncours> aff_comboSessioncours() throws SQLException{
        List<Sessioncours> ssc = new ArrayList();
        String req = "select * from pro_sessioncours";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {
            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    int idsesscours = rs.getInt("IDSESSCOURS");
                    LocalDate datedebut = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate datefin = rs.getDate("DATEFIN").toLocalDate();
                    int nbreinscrits = rs.getInt("NBREINSCRITS");
                    int idlocal = rs.getInt("IDLOCAL");
                    int idcours = rs.getInt("IDCOURS");
                    
                    ssc.add(new Sessioncours(idsesscours, datedebut, datefin, nbreinscrits, idlocal, idcours));
                }
            }
        }
        return ssc;
}
    
}
