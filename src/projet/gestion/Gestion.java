package projet.gestion;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import myconnections.*;
import java.util.*;
import projet.DAO.LocalDAO;
import projet.DAO.CoursDAO;
import projet.DAO.FormateurDAO;
import projet.DAO.Vue_FormateurDAO;
import projet.DAO.Vue_SessionHeuresDAO;
import projet.DAO.DAO;

import projet.metier.Local;
import projet.metier.Cours;
import projet.metier.Formateur;
import projet.metier.Vue_Formateur;
import projet.metier.Vue_SessionHeures;

import myconnections.DBConnection;
import projet.menu.CoursMenu;
import projet.menu.FormateurMenu;
import projet.menu.LocalMenu;
import projet.menu.VueSessionMenu;

public class Gestion {

    Scanner sc = new Scanner(System.in);

    public Gestion() {
    }
//================================= PARTIE GESTION  =================================

    public void GestionPrincipal() throws SQLException {
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
                    + "\n 4- Session. (Vue)"
                    + "\n 5- Sortie du programme.");
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
                    CallSession();

                    break;
                case 5:
                    System.out.println("End");
                    break;

                default:
                    System.out.println("Erreur");
                    break;
            }
        } while (choix != 5);
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

    public void CallSession() throws SQLException {

        VueSessionMenu VSM = new VueSessionMenu();
        VSM.GestionSession();

    }

//================================= PARTIE MAIN  =================================
    public static void main(String[] args) throws SQLException {
        Gestion g = new Gestion(); //nom de la classe de gestion

        // appelle de la fonction afin de lancer le menu de départ.
        g.GestionPrincipal();

    }

}
