package projet.menu;

import java.sql.Connection;
import .java.sql.SQLException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import myconnections.DBConnection;
import projet.DAO.SessioncoursDAO;
import projet.metier.Sessioncours;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Florence
 */
public class SessioncoursMenu {

    Scanner sc = new Scanner(System.in);

    Sessioncours sessioncoursActuel = null;
    private SessioncoursDAO sessioncoursDAO;

    public void GestionSessionCours() {

        Connection dbConnect = DBConnection.getConnection();
        sessioncoursDAO = new SessioncoursDAO();
        sessioncoursDAO.setConnection(dbConnect);

        int choix = 0;

        do {
            System.out.println("Menu de Gestion des Session de Cours : "
                    + "\n 1- Création d'un nouvelle session de cours."
                    + "\n 2- Recherche d'une session de cours (id de la session)."
                    + "\n 3- Retour au menu principal.");

            System.out.println("\n Entrer votre choix : ");
            choix = sc.nextInt();
            sc.skip("\n");

            switch (choix) {
                case 1:
                    creationSession();
                    break;
                case 2:
                    rechercheSession();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erreur");
                    break;
            }
        } while (choix != 3);

    }

    public void creationSession() {
        
        /////////////////////Date Debut

        System.out.println("Entrer la date de debut de la session : \n");
        System.out.println("Entrer le jour : ");
        int jour = sc.nextInt();
        sc.skip("\n");
        System.out.println("Entrer le jour : ");
        int mois = sc.nextInt();
        sc.skip("\n");
        System.out.println("Entrer le jour : ");
        int annee = sc.nextInt();
        sc.skip("\n");
       
        LocalDate unJour = LocalDate.of(jour, mois, annee);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("JJ/MM/AAAA", Locale.FRENCH);
        String aff = unJour.format(dtf);
        
        
        ////////////////////Date fin
       
        System.out.println("Entrer la date de fin de la session : \n");
        System.out.println("Entrer le jour : ");
        int jour1 = sc.nextInt();
        sc.skip("\n");
        System.out.println("Entrer le jour : ");
        int mois1 = sc.nextInt();
        sc.skip("\n");
        System.out.println("Entrer le jour : ");
        int annee1 = sc.nextInt();
        sc.skip("\n");

      
        LocalDate unJour1 = LocalDate.of(jour1, mois1, annee1);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("JJ/MM/AAAA", Locale.FRENCH);
        String aff1 = unJour1.format(dtf1);
       
        System.out.println(" Nombre d'étudiants inscrits : ");
        int nbreinscrits = sc.nextInt();
        sc.skip("\n");

        System.out.println(" Identifiant du local : ");
        int idlocal = sc.nextInt();
        sc.skip("\n");

        System.out.println(" Identifiant du cours : ");
        int idcours = sc.nextInt();
        sc.skip("\n");

        sessioncoursActuel = new Sessioncours(0, aff, aff1, nbreinscrits, idlocal, idcours);

        try {

            sessioncoursActuel = sessioncoursDAO.create(sessioncoursActuel);
            System.out.println("Session cours actuelle : " + sessioncoursActuel);

        } catch (SQLException e) {
            System.out.println("Erreur (création session cours) : " + e);
        }  

    }

    public void rechercheSession() throws SQLException {

    }
}
