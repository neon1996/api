/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.menu;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import myconnections.DBConnection;
import projet.DAO.Vue_FormateurDAO;
import projet.DAO.Vue_SessionHeuresDAO;
import projet.metier.Vue_Formateur;
import projet.metier.Vue_SessionHeures;

/**
 *
 * @author Florence
 */
public class VueSessionMenu {

    Scanner sc = new Scanner(System.in);
    Vue_SessionHeures Vue_SessionHeuresActuel = null;
    private Vue_SessionHeuresDAO Vue_SessionHeuresDAO;

    Vue_Formateur Vue_FormateurActuel = null;
    private Vue_FormateurDAO Vue_FormateurDAO;

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

}
