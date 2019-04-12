
package projet.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import myconnections.DBConnection;
import projet.DAO.LocalDAO;
import projet.metier.Local;

public class LocalMenu {
    Scanner sc = new Scanner(System.in);
    
   Local localActuel = null;
   private LocalDAO localDAO;
   
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
    
    //================================= PARTIE LOCAL  =================================
    public void creationLocal() {

        System.out.println("Référence du local : ");
        String sigle = sc.nextLine();
        System.out.println("Nombre de places disponibles : ");
        int places = sc.nextInt();
        sc.skip("\n");
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
                        int places = sc.nextInt();
                        sc.skip("\n");
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
    
}
