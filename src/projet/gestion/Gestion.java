package projet.gestion;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import myconnections.*;
import java.util.*;
import myconnections.DBConnection;
import projet.menu.CoursMenu;
import projet.menu.FormateurMenu;
import projet.menu.LocalMenu;
import projet.menu.SessioncoursMenu;
import projet.menu.VueSessionMenu;

public class Gestion {

    Scanner sc = new Scanner(System.in);

    public Gestion() {
    }
//================================= PARTIE GESTION  =================================

    public void GestionPrincipale() throws SQLException {
        /**
         * Démarre le programme et permet d'appeler les méthodes
         */
        Connection dbConnect = DBConnection.getConnection();

        if (dbConnect == null) {
            System.out.println("Erreur de connexion, invalide");
            System.exit(0);
        }
        System.out.println("La connexion est établie");

        int choix = 0;
        do {
            System.out.println("***======== Menu Principal du Programme : ========*** "
                    + "\n 1- Cours."
                    + "\n 2- Formateur."
                    + "\n 3- Local."
                    + "\n 4- Session de cours"
                    + "\n 5- Vues des sessions."
                    + "\n 6- Sortie du programme.");
            System.out.println("\n Entrer votre choix : ");
            choix = sc.nextInt();
            sc.skip("\n");
            switch (choix) {
                case 1:
                    CallCours();
                    break;
                case 2:
                    CallFormateur();
                    break;
                case 3:
                    CallLocal();
                    break;
                case 4:
                    CallSessionCours();
                    break;
                case 5:
                    CallSessionVue();
                    break;
                case 6:
                    System.out.println("End");
                    break;

                default:
                    System.out.println("Erreur");
                    break;
            }
        } while (choix != 6);
        DBConnection.closeConnection();
    }

    public void CallCours() throws SQLException {

        CoursMenu CM = new CoursMenu();
        CM.GestionCours();

    }

    public void CallFormateur() throws SQLException {

        FormateurMenu FM = new FormateurMenu();
        FM.GestionFormateur();

    }

    public void CallLocal() throws SQLException {

        LocalMenu LM = new LocalMenu();
        LM.GestionLocal();
    }

    public void CallSessionCours() throws SQLException {

        SessioncoursMenu SCM = new SessioncoursMenu();
        SCM.GestionSessionCours();
    }

    public void CallSessionVue() throws SQLException {

        VueSessionMenu VSM = new VueSessionMenu();
        VSM.GestionSessionVue();

    }

//================================= PARTIE MAIN  =================================
    public static void main(String[] args) throws SQLException {
        Gestion g = new Gestion(); //nom de la classe de gestion

        g.GestionPrincipale();// appelle de la fonction afin de lancer le menu de départ.

    }

}
