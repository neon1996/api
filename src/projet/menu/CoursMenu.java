
package projet.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import myconnections.DBConnection;
import projet.DAO.CoursDAO;
import projet.DAO.SessioncoursDAO;
import projet.metier.Cours;
import projet.metier.Sessioncours;

public class CoursMenu {

    Scanner sc = new Scanner(System.in);

    Cours coursActuel = null;
    
    private CoursDAO coursDAO=null;
    
    Sessioncours sessionActuel= null;
    private SessioncoursDAO sessioncoursDAO=null;

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
                    + "\n 2- Recherche exacte (idcours)."
                    + "\n 3- Recherche partielle (matiere)"
                    
                    + "\n 4- Retour au menu principal.");

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
                    
                case 3: rechercheMatCours();
                        break;
                default:
                    System.out.println("Erreur");
                    break;
            }
        } while (choix != 4);

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

        System.out.println("Entrer l'id du cours recherché :");
        int idcours = sc.nextInt();
        sc.skip("\n");
        coursActuel = coursDAO.read(idcours);
        
        System.out.println("Cours recherché : " + coursActuel);
        int choix = 0;
        do {

            System.out.println("\n Que souhaitez-vous faire ? : "
                    + "\n 1- Modification des infos du Cours :"
                    + "\n 2- Supprimer le cours :"
                    + "\n 3- Afficher la session cours"
                    
                    + "\n 4- Retour ");

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
                case 3 :
                    rechercheSessCours();
                case 4:
                    System.out.println("Retour au menu précédent ! ");
                    break;

                default:
                    System.out.println("Erreur.");
            }
        } while (choix != 4);

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
    
    public void rechercheMatCours(){
        
        System.out.println("Cours recherché (Matiere) : ");
        /* respecter les majs et les minuscules pour trouver le local */

        String matcours = sc.nextLine().toLowerCase();
        try {
            List<Cours> cours = coursDAO.rechMatiere(matcours);

            for (Cours co : cours) { // boucle for afin d'afficher l'ArrayList
                System.out.println(co);
            }
        } catch (SQLException e) {
            System.out.println("Erreur (recherche partielle matiere cours) : " + e.getMessage());
        }
        
    }

    public void rechercheSessCours(){
        
        
        try {
            List<Sessioncours> loc = ((SessioncoursDAO) sessioncoursDAO).RechCours_Sesscours(coursActuel.getIdcours());

            for (Sessioncours scc : loc) { // boucle for afin d'afficher l'ArrayList
                System.out.println(scc);
            }
        } catch (SQLException e) {
            System.out.println("Erreur (recherche session cours d'un cours) : " + e.getMessage());
        }
        
    }
}
