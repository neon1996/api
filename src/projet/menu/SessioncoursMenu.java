package projet.menu;

import java.sql.Connection;

import java.sql.Date;
import java.sql.SQLException;
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
import java.util.List;
import java.util.Locale;
import projet.DAO.InfosDAO;
import projet.metier.Infos;
import projet.metier.Vue_Formateur;

/**
 *
 * @author Florence
 */
public class SessioncoursMenu {

    Scanner sc = new Scanner(System.in);

    Sessioncours sessioncoursActuel = null;
    private SessioncoursDAO sessioncoursDAO;
    
   
    private InfosDAO infosDAO;

    public void GestionSessionCours() throws SQLException {

        Connection dbConnect = DBConnection.getConnection();
        sessioncoursDAO = new SessioncoursDAO();
        sessioncoursDAO.setConnection(dbConnect);
        
        infosDAO = new InfosDAO();
        infosDAO.setConnection(dbConnect);

        int choix = 0;

        do {
            System.out.println("Menu de Gestion des Session de Cours : "
                    + "\n 1- Création d'un nouvelle session de cours."
                    + "\n 2- Recherche d'une session de cours d'un formateur (idform)."
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
        System.out.println("Entrer l'année : ");
        int annee = sc.nextInt();
        sc.skip("\n");
        System.out.println("Entrer le Mois : ");
        int mois = sc.nextInt();
        sc.skip("\n");
        System.out.println("Entrer le jour : ");
        int jour = sc.nextInt();
        sc.skip("\n");

        LocalDate dateDebut = LocalDate.of(annee, mois, jour);
        System.out.println(dateDebut);
        
        

        ////////////////////Date fin
        System.out.println("Entrer la date de fin de la session : \n");

        System.out.println("Entrer l'année : ");
        int annee1 = sc.nextInt();
        sc.skip("\n");
        System.out.println("Entrer le Mois : ");
        int mois1 = sc.nextInt();
        sc.skip("\n");
        System.out.println("Entrer le jour : ");
        int jour1 = sc.nextInt();
        sc.skip("\n");

        LocalDate dateFin = LocalDate.of(annee1, mois1, jour1);

        System.out.println(dateFin);

        
        System.out.println("Nombre d'étudiants inscrits : ");
        int nbreinscrits = sc.nextInt();
        sc.skip("\n");

        System.out.println("Identifiant du local : ");
        int idlocal = sc.nextInt();
        sc.skip("\n");

        System.out.println("Identifiant du cours : ");
        int idcours = sc.nextInt();
        sc.skip("\n");

        sessioncoursActuel = new Sessioncours(0, dateDebut, dateFin, nbreinscrits, idlocal, idcours);

              
        try {

            sessioncoursActuel = sessioncoursDAO.create(sessioncoursActuel);
            System.out.println("Session cours actuelle : " + sessioncoursActuel);

        } catch (SQLException e) {
            System.out.println("Erreur (création session cours) : identifiant local ou cours non valide!  : " + e);
        }
        
        System.out.println("Entrer l'id formateur  responsable de la session de cours :");
        int idform = sc.nextInt();
        sc.skip("\n");
        
        System.out.println("Entrer le nombre d'heures de cours données par le formateur : ");
        int nbrheure = sc.nextInt();
        sc.skip("\n");
        
        Infos infos = new Infos(0,idform,sessioncoursActuel.getIdsesscours(),nbrheure);
        InfosDAO infod = new InfosDAO();
        try {

            infos = infod.create(infos);
            System.out.println("Session cours actuelle : " + infos);

        } catch (SQLException e) {
            System.out.println("Erreur (création infos) : " + e);
        }
      

    }

    public void rechercheSession() throws SQLException {
        
        System.out.println("Session d'un formateur recherché (Entrer son id) : ");
       
        int idform = sc.nextInt();sc.skip("\n");
        try {
            List<Vue_Formateur> loc = sessioncoursDAO.rechSessionF(idform);

            for (Vue_Formateur sc : loc) { // boucle for afin d'afficher l'ArrayList
                System.out.println(sc);
            }
        } catch (SQLException e) {
            System.out.println("Erreur (recherche session ) : " + e.getMessage());
        }
        

    }
}
