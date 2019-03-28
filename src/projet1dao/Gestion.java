package projet1dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.*;
import myconnections.*;
import java.util.*;
import projet.DAO.LocalDAO;
import projet.DAO.CoursDAO;
import projet.DAO.FormateurDAO;
import projet.DAO.DAO;
import projet.description.Local;
import projet.description.Cours;
import projet.description.Formateur;

import myconnections.DBConnection;

public class Gestion {

    Scanner sc = new Scanner(System.in);

    Cours coursActuel = null;
    Formateur formateurActuel = null;
    Local localActuel = null;

    private CoursDAO coursDAO;
    private FormateurDAO formateurDAO;
    private LocalDAO localDAO;

    public Gestion() {
    }

    public void GestionPrincipal() throws SQLException {
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("Erreur de connexion, invalide");
            System.exit(0);
        }
        System.out.println("La connexion est établie");

        int choix = 0;
        do {
            System.out.println("Menu Principal du Programme : "
                    + "\n 1- Cours."
                    + "\n 2- Formateur."
                    + "\n 3- Local."
                    + "\n 4- Sortie du programme.");
            System.out.println("\n Entrer votre choix : ");
            choix = sc.nextInt();
            sc.skip("\n");
            switch (choix) {
                case 1:
                    GestionCours();
                    break;
                case 2:
                    GestionFormateur();
                    break;
                case 3:
                    GestionLocal();
                    break;
                case 4:
                    System.out.println("End");
                    break;

                default:
                    System.out.println("Erreur");
            }
        } while (choix != 4);
        DBConnection.closeConnection();
    }

    public void GestionCours() throws SQLException {
        Connection dbConnect = DBConnection.getConnection();
        coursDAO = new CoursDAO();
        coursDAO.setConnection(dbConnect);

        int choix = 0;

        do {
            System.out.println("Menu de Gestion des Cours : "
                    + "\n 1- Création d'un nouveau cours."
                    + "\n 2- Recherche d'un cours (nom du cours)."
                    + "\n 3- Retour au menu principal.");

            System.out.println("\n Entrer votre choix : ");
            choix = sc.nextInt();
            sc.skip("\n");

            switch (choix) {
                case 1:
                    creationCours();
                    break;
                case 2:
                    rechercheCours();
                    break;
                case 3:
                    System.out.println("Retour au programme principal");
                    break;
                default:
                    System.out.println("Erreur");
            }
        } while (choix != 3);
        DBConnection.closeConnection();
    }

    public void GestionFormateur() throws SQLException {

        Connection dbConnect = DBConnection.getConnection();
        formateurDAO = new FormateurDAO();
        formateurDAO.setConnection(dbConnect);

        int choix = 0;
        do {
            System.out.println("Menu de Gestion des Formateurs : "
                    + "\n 1- Création d'un nouveau formateur."
                    + "\n 2- Recherche d'un formateur (nom)."
                    + "\n 3- Retour au menu principal.");
            System.out.println("\n Entrer votre choix : ");
            choix = sc.nextInt();
            sc.skip("\n");
            switch (choix) {
                case 1:
                    creationFormateur();
                    break;
                case 2:
                    rechercheFormateur();
                    break;
                case 3:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Erreur");
            }
        } while (choix != 3);

    }

    public void GestionLocal() throws SQLException {

        Connection dbConnect = DBConnection.getConnection();
        localDAO = new LocalDAO();
        localDAO.setConnection(dbConnect);

        int choix = 0;
        do {
            /**
             * Mon menu "Gestion des locaux" permet de créer un nouveau local.
             * La création est basée sur l'identifiant auto-increment dans la
             * BDD.
             *
             * La recherche d'un local avec le SIGLE permet de trouver le local
             * et ensuite d'y apporter des modifications. ==> Je peux modifier
             * le nombre de places disponibles et la description.
             *
             * La recherche grâce à la description (requête avec un like) dans
             * la colonne description de ma BDD. Elle permet juste l'affichage
             * des locaux dans une ArrayList.
             */
            System.out.println("Menu de Gestion des locaux : "
                    + "\n 1- Création d'un local."
                    + "\n 2- Recherche local (sigle)."
                    + "\n 3- Recherche local (description)."
                    + "\n 4- Retour sur le menu principal.");

            System.out.println("\n Entrer votre choix : ");
            choix = sc.nextInt();
            sc.skip("\n");

            switch (choix) {
                case 1:
                    creationLocal();
                    break;
                case 2:
                    rechercheSigleLocal();
                    break;
                case 3:
                    rechercheDescLocal();
                    break;

                case 4:
                    System.out.println("Retour au menu principal ! ");
                    break;

                default:
                    System.out.println("Erreur");
            }
        } while (choix != 4);

    }

//================================= PARTIE LOCAL  =================================
    public void creationLocal() {

        System.out.println("Référence du local : ");
        String sigle = sc.nextLine();
        System.out.println("Nombre de places disponibles : ");
        String places = sc.nextLine();
        System.out.println("Description : ");
        String description = sc.nextLine();

        localActuel = new Local(0, sigle, places, description);

        try {
            localActuel = localDAO.create(localActuel);
            System.out.println("Local actuel : " + localActuel);

        } catch (SQLException e) {
            System.out.println("Erreur : " + e);
        }

    }

    public void rechercheSigleLocal() throws SQLException {

        System.out.println("Sigle recherché :");
        String sig = sc.nextLine();
        localActuel = localDAO.readSigle(sig);
        System.out.println("Local recherché : " + localActuel);
        int choix1 = 0;
        do {

            System.out.println(" Que souhaitez-vous faire ? : "
                    + "\n\n1.Modification des infos du local :"
                    + "\n2.Supprimer le local :"
                    + "\n3.Retour ");

            System.out.println("\nEntrer votre choix : ");
            choix1 = sc.nextInt();
            sc.skip("\n");

            switch (choix1) {

                case 1:
                    modifLocal();
                    break;
                case 2:
                    deleteLocal();
                    GestionLocal();
                case 3:
                    System.out.println("Retour au menu précédent ! ");
                    break;

                default:
                    System.out.println("Erreur");
            }
        } while (choix1 != 3);

    }

    public void modifLocal() {

        int choix;

        try {

            do {
                System.out.println("\nQue voulez-vous modifier?:"
                        + "\n 1- Nombre de places. "
                        + "\n 2- Description. "
                        + "\n 3- Retour au menu précédent."
                        + "\n Votre choix : ");
                choix = sc.nextInt();
                sc.skip("\n");

                switch (choix) {
                    case 1:
                        System.out.println("Entrez le nombre de place disponible : ");
                        String places = sc.nextLine();
                        localActuel.setPlaces(places);
                        localDAO.update(localActuel);
                        break;

                    case 2:
                        System.out.println("Entrez la nouvelle description du local: ");
                        String description = sc.nextLine();
                        localActuel.setDescription(description);
                        localDAO.update(localActuel);
                        break;

                    case 3:
                        break;// retour au menu précédent
                }
            } while (choix != 3);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void deleteLocal() throws SQLException {

        try {
            localDAO.delete(localActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
        GestionLocal(); // mettre le gestion dans un if, afin qu'il renvoie au menu si il y a eu suppression.

    }

    public void rechercheDescLocal() {

        System.out.println("Local recherché (Entrer la description) : ");
        /* respecter les majs et les minuscules pour trouver le local */

        String desclocal = sc.nextLine().toLowerCase();
        try {
            List<Local> loc = localDAO.rechDescription(desclocal);

            for (Local lcl : loc) { // boucle for afin d'afficher l'ArrayList
                System.out.println(lcl);
            }
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

//================================= PARTIE COURS  =================================
    public void creationCours() {

        System.out.println("Nom du cours : ");
        String matiere = sc.nextLine();
        System.out.println("Nombre d'heures : ");
        int heures = sc.nextInt();
        sc.skip("\n");

        coursActuel = new Cours(0, matiere, heures);

        try {
            coursActuel = coursDAO.create(coursActuel);
            System.out.println("Cours actuel : " + coursActuel);

        } catch (SQLException e) {
            System.out.println("Erreur : " + e);
        }

    }

    public void rechercheCours() throws SQLException {

        System.out.println("Entrer le nom du cours recherché :");
        String matiere = sc.nextLine().toLowerCase();
        coursActuel = coursDAO.readMatiere(matiere);
        System.out.println("Cours recherché : " + coursActuel);
        int choix1 = 0;
        do {

            System.out.println("\nQue souhaitez-vous faire ? : "
                    + "\n\n 1- Modification des infos du Cours :"
                    + "\n 2- Supprimer le cours :"
                    + "\n 3- Retour ");

            System.out.println("\nEntrer votre choix : ");
            choix1 = sc.nextInt();
            sc.skip("\n");

            switch (choix1) {

                case 1:
                    modifCours();
                    break;
                case 2:
                    deleteCours();
                    GestionCours();
                case 3:
                    System.out.println("Retour au menu précédent ! ");
                    break;

                default:
                    System.out.println("Erreur");
            }
        } while (choix1 != 3);

    }

    public void modifCours() {

        int choix;

        try {

            do {
                System.out.println("\n Modifier :"
                        + "\n 1- Nombre d'heures. "
                        + "\n 2- Retour au menu précédent. "
                        + "\n Votre choix : ");
                choix = sc.nextInt();
                sc.skip("\n");

                switch (choix) {
                    case 1:
                        System.out.println("Entrez le nombre d'heures : ");
                        int heures = sc.nextInt();
                        sc.skip("\n");
                        coursActuel.setHeures(heures);
                        coursDAO.update(coursActuel);
                        break;

                    case 2:
                        break;// retour au menu précédent
                    default:
                        System.out.println("Erreur");
                }
            } while (choix != 3);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void deleteCours() throws SQLException {
        try {
            coursDAO.delete(coursActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
        GestionCours(); // mettre le gestion dans un if, afin qu'il renvoie au menu si il y a eu suppression.
    }

//================================= PARTIE FORMATEUR  =================================
    public void creationFormateur() {
        System.out.println("Matricule : ");
        String matricule = sc.nextLine();

        System.out.println("Nom du formateur : ");
        String nom = sc.nextLine();

        System.out.println("Prenom du formateur : ");
        String prenom = sc.nextLine();

        System.out.println("Numero (adresse) : ");
        String numero = sc.nextLine();

        System.out.println("Rue : ");
        String rue = sc.nextLine();

        System.out.println("Localite : ");
        String localite = sc.nextLine();

        System.out.println("Code postale : ");
        int cp = sc.nextInt();
        sc.skip("\n");
        
        System.out.println("Numero de téléphone: ");
        String tel = sc.nextLine();

        formateurActuel = new Formateur(0, matricule, nom, prenom, numero, rue, localite, cp, tel);

        try {
            formateurActuel = formateurDAO.create(formateurActuel);
            System.out.println("Cours actuel : " + formateurActuel);

        } catch (SQLException e) {
            System.out.println("Erreur : " + e);
        }

    }

    public void rechercheFormateur() throws SQLException {

        System.out.println("Entrer le nom du formateur :");
        String nom = sc.nextLine().toLowerCase();
        formateurActuel = formateurDAO.readNom(nom);
        System.out.println("Cours recherché : " + formateurActuel);
        int choix = 0;
        do {

            System.out.println("\nQue souhaitez-vous faire ? : "
                    + "\n 1- Modification des infos du Formateur:"
                    + "\n 2- Supprimer le formateur :"
                    + "\n 3- Retour ");

            System.out.println("\nEntrer votre choix : ");
            choix = sc.nextInt();
            sc.skip("\n");

            switch (choix) {

                case 1:
                    modifFormateur();
                    break;
                case 2:
                    deleteFormateur();
                    GestionFormateur();
                case 3:
                    System.out.println("Retour au menu précédent ! ");
                    break;

                default:
                    System.out.println("Erreur");
            }
        } while (choix != 3);

    }

    public void modifFormateur() {
        int choix;

        try {

            do {
                System.out.println("\n Modifier :"
                        + "\n 1- Matricule. "
                        + "\n 2- Adresse (complete)."
                        + "\n 3- Telephone"
                        + "\n 4- Retour au menu précédent. "
                        + "\n Votre choix : ");
                choix = sc.nextInt();
                sc.skip("\n");

                switch (choix) {
                    case 1:
                        System.out.println("Entrez le nouveau matricule : ");
                        String matricule = sc.nextLine();
                        formateurActuel.setMatricule(matricule);
                        formateurDAO.update(formateurActuel);
                        break;

                    case 2:
                        System.out.println("Entrez le nouveau numero : ");
                        String numero  = sc.nextLine();
                        formateurActuel.setNumero(numero);
                        formateurDAO.update(formateurActuel);
                        
                        System.out.println("Entrez la nouvelle rue : ");
                        String rue = sc.nextLine();
                        formateurActuel.setRue(rue);
                        formateurDAO.update(formateurActuel);
                        
                        System.out.println("Entrez la nouvelle localite : ");
                        String localite = sc.nextLine();
                        formateurActuel.setLocalite(localite);
                        formateurDAO.update(formateurActuel);
                        
                        System.out.println("Entrez le nouveau code postal : ");
                        int cp = sc.nextInt();
                        sc.skip("\n");
                        formateurActuel.setCp(cp);
                        formateurDAO.update(formateurActuel);
                        break;
                        
                    case 3:
                        System.out.println("Entrez le nouveau numéro de téléphone : ");
                        String tel = sc.nextLine();
                        formateurActuel.setTelephone(tel);
                        formateurDAO.update(formateurActuel);
                        break;
                    case 4:
                        break;// retour au menu précédent

                    default:
                        System.out.println("Erreur");
                }
            } while (choix != 4);

        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }

    }

    public void deleteFormateur() throws SQLException {
        try {
            formateurDAO.delete(formateurActuel);
        } catch (SQLException e) {
            System.out.println("erreur " + e.getMessage());
        }
        GestionFormateur(); // mettre le gestion dans un if, afin qu'il renvoie au menu si il y a eu suppression.

    }
//================================= PARTIE MAIN  =================================

    public static void main(String[] args) throws SQLException {

        LocalDAO ld = new LocalDAO(); // permet d'appeler la méthode readSigle dans LocalDAO afin de ne pas faire une surcharge des méthodes CRUD.
        FormateurDAO fd = new FormateurDAO();
        CoursDAO cd = new CoursDAO();

        Gestion g = new Gestion(); //nom du fichier de gestion

        // appelle de la fonction afin de lancer le menu de départ.
        g.GestionPrincipal();

    }

}