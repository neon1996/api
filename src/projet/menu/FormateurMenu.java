
package projet.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import myconnections.DBConnection;
import projet.DAO.FormateurDAO;
import projet.metier.Formateur;

public class FormateurMenu {

    Scanner sc = new Scanner(System.in);
    Formateur formateurActuel = null;
    private FormateurDAO formateurDAO;

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

}
