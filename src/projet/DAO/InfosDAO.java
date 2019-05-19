package projet.DAO;

import java.sql.Connection;
import java.sql.*;
import java.util.*;
import projet.metier.Infos;
import java.time.LocalDate;
import myconnections.DBConnection;

public class InfosDAO extends DAO<Infos> {

    Connection dbConnect = DBConnection.getConnection();

    @Override
    public Infos create(Infos obj) throws SQLException {
        String req1 = "insert into pro_infos(idform,idsesscours,nbrheure) values(?,?,?)";
        String req2 = "select idinfos from pro_infos where idform =? and idsesscours =?";

        try (PreparedStatement pstm1 = dbConnect.prepareStatement(req1);
                PreparedStatement pstm2 = dbConnect.prepareStatement(req2)) {

            pstm1.setInt(1, obj.getIdform());
            pstm1.setInt(2, obj.getIdsesscours());
            pstm1.setInt(3, obj.getNbrheure());

            int n = pstm1.executeUpdate();
            if (n == 0) {
                throw new SQLException("erreur de creation (infos), aucune ligne n'a été créée");
            }

            pstm2.setInt(1, obj.getIdform());
            pstm2.setInt(2, obj.getIdsesscours());

            try (ResultSet rs = pstm2.executeQuery()) {
                if (rs.next()) {
                    int idinfos = rs.getInt(1);
                    obj.setIdinfos(idinfos);
                    return read(idinfos);
                } else {
                    throw new SQLException("Erreur de création dans la table infos, introuvable");
                }
            }
        }
    }

    @Override
    public Infos read(int idinfos) throws SQLException {
        String req = "select * from pro_infos where idinfos = ?";

        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, idinfos);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {

                    int idform = rs.getInt("IDFORM");
                    int idsesscours = rs.getInt("IDSESSCOURS");
                    int nbrheure = rs.getInt("NBRHEURE");

                    return new Infos(idinfos, idform, idsesscours, nbrheure);
                } else {
                    throw new SQLException("Formateur inconnu");
                }

            }
        }
    }

    @Override
    public Infos update(Infos obj) throws SQLException {
        String req = "update pro_infos set idform=?,idsesscours=?,nbrheure=?"
                + " where idinfos=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(4, obj.getIdinfos());
            pstm.setInt(1, obj.getIdform());
            pstm.setInt(2, obj.getIdsesscours());
            pstm.setInt(3, obj.getNbrheure());

            int n = pstm.executeUpdate();

            System.out.println("Informations mise à jour !");

        } catch (SQLException e) {
            System.out.println("Aucune ligne infos a été mise à jour");
        }
        return obj;
    }

    @Override
    public void delete(Infos obj) throws SQLException {
        String req = "delete from pro_infos where idinfos= ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req)) {

            pstm.setInt(1, obj.getIdinfos());
            int n = pstm.executeUpdate();

            System.out.println("Ligne de la table infos a été correctement supprimé de la base de données ! ");

        } catch (SQLIntegrityConstraintViolationException custom) {
            throw new SQLException("Impossible de supprimer - données liées à d'autre(s) table(s) ");
        }
    }

}
