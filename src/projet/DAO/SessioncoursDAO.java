package projet.DAO;

import java.sql.Connection;
import java.util.*;
import java.sql.*;
import projet.metier.Sessioncours;
import java.time.LocalDate;
import myconnections.DBConnection;

public class SessioncoursDAO extends DAO<Sessioncours> {

    Connection dbConnect = DBConnection.getConnection();

    @Override
    public Sessioncours create(Sessioncours obj) throws SQLException {

        String req1 = "insert into pro_sessioncours(datedebut,datefin,nbreinscrits,idlocal,idcours) values(?,?,?,?,?)";
        String req2 = "select idsesscours from pro_sessioncours where datedebut=? and datefin=? and idcours=? ";

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
           // pstm2.setInt(4, obj.getIdlocal());
            pstm2.setInt(4, obj.getIdcours());

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
        String req = "select * from pro_sesscours where idsesscours = ?";

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
        String req = "update pro_sesscours set datedebut=?,datefin=?,nbreinscrits=?,idlocal=?,idcours=?"
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
        String req = "delete from pro_sesscours where idsesscours= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdsesscours());
            int n = pstm.executeUpdate();

            System.out.println("La session de cours a été correctement supprimée de la base de données ! ");

        } catch (SQLException e) {
            System.out.println("Aucune ligne effacée : la session de cours n'existe pas dans la BDD !");
        }
    }

}
