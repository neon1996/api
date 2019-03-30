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
import projet.DAO.Vue_FormateurDAO;
import projet.DAO.Vue_SessionHeuresDAO;
import projet.DAO.DAO;

import projet.metier.Local;
import projet.metier.Cours;
import projet.metier.Formateur;
import projet.metier.Vue_Formateur;
import projet.metier.Vue_SessionHeures;

import myconnections.DBConnection;

public class Gestion {

    Scanner sc = new Scanner(System.in);

    Cours coursActuel = null;
    Formateur formateurActuel = null;
    Local localActuel = null;
    Vue_Formateur Vue_FormateurActuel = null;
    Vue_SessionHeures Vue_SessionHeuresActuel = null;

    // Permet de me donner l'accès au(x) méthode(s) ajoutée(s) dans les classes métiers
    private CoursDAO coursDAO;
    private FormateurDAO formateurDAO;
    private LocalDAO localDAO;
    private Vue_FormateurDAO Vue_FormateurDAO;
    private Vue_SessionHeuresDAO Vue_SessionHeuresDAO;

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
                    GestionCours();
                    break;
                case 2:
                    GestionFormateur();
                    break;
                case 3:
                    GestionLocal();
                    break;
                case 4:
                    GestionSession();

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

    public void GestionCours() throws SQLException {
        /**
         * Mon menu "Gestion des cours" permet de créer/chercher/modifier les
         * informations d'un cours. La création est basée sur l'identifiant
         * auto-increment dans la BDD.
         *
         * La recherche d'un local s'effectue avec le nom du cours, ce qui
         * permet de trouver le local et ensuite d'y apporter des modifications.
         * Je ne peux modifier que le nbr d'heures des cours.
         *
         *
         */

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
                    break;
                default:
                    System.out.println("Erreur");
                    break;
            }
        } while (choix != 3);

    }

    public void GestionFormateur() throws SQLException {

        /**
         * Mon menu "Gestion des Formateurs " permet de créer/chercher/modifier
         * les informations d'un formateur. La création est basée sur
         * l'identifiant (auto-increment) dans la BDD.
         *
         * La recherche d'un formateur s'effectue avec le matricule, ce qui
         * permet de trouver le local et ensuite d'y apporter des modifications.
         *
         */
        Connection dbConnect = DBConnection.getConnection();
        formateurDAO = new FormateurDAO();
        formateurDAO.setConnection(dbConnect);

        int choix = 0;
        do {
            System.out.println("Menu de Gestion des Formateurs : "
                    + "\n 1- Création d'un nouveau formateur."
                    + "\n 2- Recherche d'un formateur (via matricule)."
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
                    break;
                default:
                    System.out.println("Erreur");
                    break;
            }
        } while (choix != 3);

    }

    public void GestionLocal() throws SQLException {

        /**
         * Mon menu "Gestion des locaux" permet de créer/chercher/modifier les
         * informations d'un local. La création est basée sur l'identifiant
         * auto-increment dans la BDD.
         *
         * La recherche d'un local s'effectue avec le SIGLE, ce qui permet de
         * trouver le local et ensuite d'y apporter des modifications. ==> Je
         * peux modifier le nombre de places disponibles et la description.
         *
         * La recherche grâce à la description (like) dans la colonne
         * description de ma BDD. Elle permet l'affichage du/des local/locaux
         * recherché(s), dans une ArrayList.
         */
        Connection dbConnect = DBConnection.getConnection();
        localDAO = new LocalDAO();
        localDAO.setConnection(dbConnect);

        int choix = 0;
        do {

            System.out.println("Menu de Gestion des locaux : "
                    + "\n 1- Création d'un local."
                    + "\n 2- Recherche local (sigle)."
                    + "\n 3- Recherche local (description)."
                    + "\n 4- Retour au menu principal.");

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
                    break;

                default:
                    System.out.println("Erreur");
                    break;
            }
        } while (choix != 4);

    }

    public void GestionSession() throws SQLException {
        /**
         * Permet l'affichage des vues créées dans la BDD : 1) Afficher toutes
         * les sessions d'un formateur en fonction de son identifiant dans la
         * BDD. 2) Afficher le nombre total d'heures par session en fonction de
         * l'identifiant de la session.
         *
         * @throws SQLException
         */
        Connection dbConnect = DBConnection.getConnection();
        Vue_FormateurDAO = new Vue_FormateurDAO();
        Vue_SessionHeuresDAO = new Vue_SessionHeuresDAO();

        Vue_FormateurDAO.setConnection(dbConnect);
        Vue_SessionHeuresDAO.setConnection(dbConnect);

        int choix = 0;
        do {
            System.out.println("Menu de Gestion des Sessions :"
                    + "\n 1- Afficher les sessions d'un formateur (ID)."
                    + "\n 2- Afficher le total d'heures d'une session."
                    + "\n 3- Retour au menu principal");
            System.out.println("\n Entrer votre choix : ");
            choix = sc.nextInt();
            sc.skip("\n");

            switch (choix) {
                case 1:
                    SessionForm();
                    break;
                case 2:
                    SessionHeures();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Erreur");
                    break;
            }

        } while (choix != 3);

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
            System.out.println("Erreur (création local) : " + e);
        }

    }

    public void rechercheSigleLocal() throws SQLException {

        System.out.println("Sigle (exact) recherché :");
        String sig = sc.nextLine();
        localActuel = localDAO.readSigle(sig);
        System.out.println("Local recherché : " + localActuel);
        int choix = 0;
        do {

            System.out.println(" Que souhaitez-vous faire ? : "
                    + "\n 1- Modification des infos du local :"
                    + "\n 2- Supprimer le local :"
                    + "\n 3- Retour ");

            System.out.println("\nEntrer votre choix : ");
            choix = sc.nextInt();
            sc.skip("\n");

            switch (choix) {

                case 1:
                    modifLocal();
                    break;
                case 2:
                    deleteLocal();
                    GestionLocal();
                case 3:
                    break;

                default:
                    System.out.println("Erreur");
            }
        } while (choix != 3);

    }

    public void modifLocal() {

        int choix;

        try {

            do {
                System.out.println("\n Que voulez-vous modifier?:"
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

                        //Appel de la méthode update afin d'opérer les changements dans la bdd
                        localDAO.update(localActuel);
                        break;

                    case 2:
                        System.out.println("Entrez la nouvelle description du local: ");
                        String description = sc.nextLine();
                        localActuel.setDescription(description);

                        //Appel de la méthode update afin d'opérer les changements dans la bdd
                        localDAO.update(localActuel);
                        break;

                    case 3:
                        break;// retour au menu précédent
                }
            } while (choix != 3);

        } catch (SQLException e) {
            System.out.println("Erreur (update local) : " + e.getMessage());
        }

    }

    public void deleteLocal() throws SQLException {

        try {
            localDAO.delete(localActuel);
        } catch (SQLException e) {
            System.out.println("Erreur (suppression local) : " + e.getMessage());
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
            System.out.println("Erreur (recherche description local) : " + e.getMessage());
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
            System.out.println("Erreur (création cours): " + e);
        }

    }

    public void rechercheCours() throws SQLException {

        System.out.println("Entrer le nom du cours recherché :");
        String matiere = sc.nextLine().toLowerCase();
        coursActuel = coursDAO.readMatiere(matiere);
        System.out.println("Cours recherché : " + coursActuel);
        int choix = 0;
        do {

            System.out.println("\n Que souhaitez-vous faire ? : "
                    + "\n 1- Modification des infos du Cours :"
                    + "\n 2- Supprimer le cours :"
                    + "\n 3- Retour ");

            System.out.println("\n Entrer votre choix : ");
            choix = sc.nextInt();
            sc.skip("\n");

            switch (choix) {

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
                    System.out.println("Erreur.");
            }
        } while (choix != 3);

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

                        //Appel de la méthode update afin d'opérer les changements dans la bdd
                        coursDAO.update(coursActuel);
                        break;

                    case 2:
                        break;// retour au menu précédent
                    default:
                        System.out.println("Erreur (update cours).");
                }
            } while (choix != 2);

        } catch (SQLException e) {
            System.out.println("Erreur (update cours)" + e.getMessage());
        }

    }

    public void deleteCours() throws SQLException {
        try {
            coursDAO.delete(coursActuel);
        } catch (SQLException e) {
            System.out.println("Erreur (suppression cours) " + e.getMessage());
        }
        GestionCours(); // mettre le gestion dans un if, afin qu'il renvoie au menu si il y a eu suppression.
    }

//================================= PARTIE FORMATEUR  =================================
    public void creationFormateur() {
        System.out.println("Matricule : ");
        String matricule = sc.nextLine();

        System.out.println("Nom du formateur : ");
        String nom = sc.nextLine();

        System.out.println("Prénom du formateur : ");
        String prenom = sc.nextLine();

        System.out.println("Numero (adresse) : ");
        String numero = sc.nextLine();

        System.out.println("Rue : ");
        String rue = sc.nextLine();

        System.out.println("Localite : ");
        String localite = sc.nextLine();

        System.out.println("Code postal : ");
        int cp = sc.nextInt();
        sc.skip("\n");

        System.out.println("Numero de téléphone: ");
        String tel = sc.nextLine();

        formateurActuel = new Formateur(0, matricule, nom, prenom, numero, rue, localite, cp, tel);

        try {
            formateurActuel = formateurDAO.create(formateurActuel);
            System.out.println("Formateur actuel : " + formateurActuel);

        } catch (SQLException e) {
            System.out.println("Erreur (création formateur): " + e);
        }

    }

    public void rechercheFormateur() throws SQLException {

        System.out.println("Entrer le matricule du formateur :");
        String matricule = sc.nextLine();
        formateurActuel = formateurDAO.readMatricule(matricule);
        System.out.println("Formateur recherché : " + formateurActuel);
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
                    break;

                default:
                    System.out.println("Erreur (recherche formateur).");
            }
        } while (choix != 3);

    }

    public void modifFormateur() {
        int choix;

        try {

            do {
                System.out.println("\n Modifier :"
                        + "\n 1- Nom et prenom. "
                        + "\n 2- Adresse (complete)."
                        + "\n 3- Telephone"
                        + "\n 4- Retour au menu précédent. "
                        + "\n Votre choix : ");
                choix = sc.nextInt();
                sc.skip("\n");

                switch (choix) {
                    case 1:
                        System.out.println("Entrez le nouveau nom : ");
                        String nom = sc.nextLine();
                        formateurActuel.setNom(nom);

                        System.out.println("Entrez le nouveau prenom : ");
                        String prenom = sc.nextLine();
                        formateurActuel.setPrenom(prenom);

                        //Appel de la méthode update afin d'opérer les changements dans la bdd
                        formateurDAO.update(formateurActuel);

                        break;

                    case 2:
                        System.out.println("Entrez le nouveau numero : ");
                        String numero = sc.nextLine();
                        formateurActuel.setNumero(numero);

                        System.out.println("Entrez la nouvelle rue : ");
                        String rue = sc.nextLine();
                        formateurActuel.setRue(rue);

                        System.out.println("Entrez la nouvelle localite : ");
                        String localite = sc.nextLine();
                        formateurActuel.setLocalite(localite);

                        System.out.println("Entrez le nouveau code postal : ");
                        int cp = sc.nextInt();
                        sc.skip("\n");
                        formateurActuel.setCp(cp);

                        //Appel de la méthode update afin d'opérer les changements dans la bdd
                        formateurDAO.update(formateurActuel);
                        break;

                    case 3:
                        System.out.println("Entrez le nouveau numéro de téléphone : ");
                        String tel = sc.nextLine();
                        formateurActuel.setTelephone(tel);

                        //Appel de la méthode update afin d'opérer les changements dans la bdd
                        formateurDAO.update(formateurActuel);
                        break;
                    case 4:
                        break;// retour au menu précédent

                    default:
                        System.out.println("Erreur(update formateur).");
                }
            } while (choix != 4);

        } catch (SQLException e) {
            System.out.println("Erreur (update formateur) : " + e.getMessage());
        }

    }

    public void deleteFormateur() throws SQLException {
        try {
            formateurDAO.delete(formateurActuel);
        } catch (SQLException e) {
            System.out.println("Erreur (suppression formateur) " + e.getMessage());
        }
        GestionFormateur(); // mettre le gestion dans un if, afin qu'il renvoie au menu si il y a eu suppression.

    }

//================================= PARTIE SESSION  =================================
    public void SessionForm() {

        Vue_FormateurDAO vueForm = new Vue_FormateurDAO();
        System.out.println("\n Afficher la/les session(s) d'un formateur");
        System.out.println("\n Entrer l'identifiant du formateur : ");
        int idform = sc.nextInt();
        sc.skip("\n");
        try {
            System.out.println(vueForm.SessionFormateur(idform));
        } catch (SQLException e) {
            System.out.println("Erreur (Session formateur) : " + e);
        }

    }

    public void SessionHeures() {

        Vue_SessionHeuresDAO vueHeures = new Vue_SessionHeuresDAO();
        System.out.println("\n Afficher le nbr d'heures total d'une session :");
        System.out.println("\n Entrer l'identifiant de la session : ");
        int idsesscours = sc.nextInt();
        sc.skip("\n");
        try {
            System.out.println(vueHeures.SessionHeures(idsesscours));
        } catch (SQLException e) {
            System.out.println("Erreur (Session heures) : " + e);
        }

    }
//================================= PARTIE MAIN  =================================

    public static void main(String[] args) throws SQLException {
        Gestion g = new Gestion(); //nom de la classe de gestion

        // appelle de la fonction afin de lancer le menu de départ.
        g.GestionPrincipal();

    }

}
