package projet.graph;

import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import projet.DAO.LocalDAO;
import projet.DAO.CoursDAO;
import projet.DAO.FormateurDAO;
import projet.DAO.SessioncoursDAO;

import myconnections.DBConnection;
import projet.DAO.InfosDAO;
import projet.DAO.Vue_FormateurDAO;
import projet.DAO.Vue_SessionHeuresDAO;

public class GestionGraph extends javax.swing.JFrame {

    CardLayout cardl;

    public GestionGraph() {
        initComponents();

        cardl = (CardLayout) this.getContentPane().getLayout();
        
        Connection dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connexion invalide");
            JOptionPane.showMessageDialog(this, "connexion invalide", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

        LocalDAO localDAO = new LocalDAO();
        localDAO.setConnection(dbConnect);
        
        CoursDAO coursDAO = new CoursDAO();
        coursDAO.setConnection(dbConnect);
        
        FormateurDAO formateurDAO = new FormateurDAO();
        formateurDAO.setConnection(dbConnect);
        
        SessioncoursDAO sessioncoursDAO = new SessioncoursDAO();
        sessioncoursDAO.setConnection(dbConnect);
        
        InfosDAO infosDAO = new InfosDAO();
        infosDAO.setConnection(dbConnect);
        
        Vue_FormateurDAO vue_formateurDAO = new Vue_FormateurDAO();
        vue_formateurDAO.setConnection(dbConnect);
        
        Vue_SessionHeuresDAO vue_sessionheuresDAO = new Vue_SessionHeuresDAO();
        vue_sessionheuresDAO.setConnection(dbConnect);

        createLocal.setLocalDAO(localDAO);
        rechercheSigleLoc.setLocalDAO(localDAO);
        rechercheDescriptionLocal.setLocalDAO(localDAO);
        
        createCours.setCoursDAO(coursDAO);
        rechercheIDCours.setCoursDAO(coursDAO);
        rechercheMatiereCours.setCoursDAO(coursDAO);
        
        createFormateur.setFormateurDAO(formateurDAO);
        rechercheMatriculeFormateur.setFormateurDAO(formateurDAO);
        
        createSessioncours.setSessioncoursDAO(sessioncoursDAO);
        rechercheIDCours.setSessioncoursDAO(sessioncoursDAO); /*Permet la seconde recherche afin d'afficher les sessions de cours lors de la recherche d'un cours (selon son id)*/
        rechercheIdformSessioncours.setSessioncoursDAO(sessioncoursDAO);
        
        createInfos.setInfosDAO(infosDAO);
        rechercheIdinfos.setInfosDAO(infosDAO);
        
        affVue_Formateur.setVue_formateurDAO(vue_formateurDAO);
        affVue_SessionHeures.setVue_sessionheuresDAO(vue_sessionheuresDAO);
        
        //combo box local dans create session cours: 
        
        createSessioncours.setLocalDAO(localDAO);
        createSessioncours.comboLocal();
        
        // combo box cours dans create session cours: 
        
        createSessioncours.setCoursDAO(coursDAO);
        createSessioncours.comboCours();
        
        // combo box formateur dans create infos : 
        
        createInfos.setFormateurDAO(formateurDAO);
        createInfos.comboFormateur();
        
        // combo box sessioncours dans create infos: 
        createInfos.setSessioncoursDAO(sessioncoursDAO);
        createInfos.comboSessioncours();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accueil_fond = new projet.graph.accueil_fond();
        rechercheDescriptionLocal = new projet.graph.RechercheDescriptionLocal();
        rechercheSigleLoc = new projet.graph.RechercheSigleLocal();
        createFormateur = new projet.graph.CreateFormateur();
        createCours = new projet.graph.CreateCours();
        rechercheMatriculeFormateur = new projet.graph.RechercheMatriculeFormateur();
        createLocal = new projet.graph.CreateLocal();
        rechercheIDCours = new projet.graph.RechercheIDCours();
        createSessioncours = new projet.graph.CreateSessioncours();
        rechercheIdformSessioncours = new projet.graph.RechercheIdformSessioncours();
        affVue_Formateur = new projet.graph.AffVue_Formateur();
        affVue_SessionHeures = new projet.graph.AffVue_SessionHeures();
        rechercheMatiereCours = new projet.graph.RechercheMatiereCours();
        createInfos = new projet.graph.CreateInfos();
        rechercheIdinfos = new projet.graph.RechercheIdinfos();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAccueil = new javax.swing.JMenu();
        menuLocal = new javax.swing.JMenu();
        itemCreateLoc = new javax.swing.JMenuItem();
        itemRechSigleLoc = new javax.swing.JMenuItem();
        itemRechDescLoc = new javax.swing.JMenuItem();
        menuCours = new javax.swing.JMenu();
        itemCreateCours = new javax.swing.JMenuItem();
        itemRechIdCours = new javax.swing.JMenuItem();
        itemRechPartMatCours = new javax.swing.JMenuItem();
        menuFormateur = new javax.swing.JMenu();
        itemCreateForm = new javax.swing.JMenuItem();
        itemRechMatriculeForm = new javax.swing.JMenuItem();
        menuInfos = new javax.swing.JMenu();
        itemInfos = new javax.swing.JMenuItem();
        itemRechInfos = new javax.swing.JMenuItem();
        menuSessioncours = new javax.swing.JMenu();
        itemCreateSessioncours = new javax.swing.JMenuItem();
        itemRechIdformSessioncours = new javax.swing.JMenuItem();
        menuVue = new javax.swing.JMenu();
        itemVueForm = new javax.swing.JMenuItem();
        itemVueSessHeures = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(accueil_fond, "cardAccueil");
        getContentPane().add(rechercheDescriptionLocal, "cardRechDescLoc");
        getContentPane().add(rechercheSigleLoc, "cardRechSigleLoc");
        getContentPane().add(createFormateur, "cardCreaForm");
        getContentPane().add(createCours, "cardCreaCours");
        getContentPane().add(rechercheMatriculeFormateur, "cardRechMatriculeForm");
        getContentPane().add(createLocal, "cardCreaLoc");
        getContentPane().add(rechercheIDCours, "cardRechIDCours");
        getContentPane().add(createSessioncours, "cardCreaSessioncours");
        getContentPane().add(rechercheIdformSessioncours, "cardRechIdSesscours");
        getContentPane().add(affVue_Formateur, "cardAffVueForm");
        getContentPane().add(affVue_SessionHeures, "cardAffSessHeures");
        getContentPane().add(rechercheMatiereCours, "carRechPartCours");
        getContentPane().add(createInfos, "cardCreateInfos");
        getContentPane().add(rechercheIdinfos, "cardRechInfos");

        menuAccueil.setText("Accueil");
        menuAccueil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAccueilMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuAccueil);

        menuLocal.setText("Local");

        itemCreateLoc.setText("Creation local");
        itemCreateLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreateLocActionPerformed(evt);
            }
        });
        menuLocal.add(itemCreateLoc);

        itemRechSigleLoc.setText("Recherche Sigle");
        itemRechSigleLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechSigleLocActionPerformed(evt);
            }
        });
        menuLocal.add(itemRechSigleLoc);

        itemRechDescLoc.setText("Recherche Desc");
        itemRechDescLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechDescLocActionPerformed(evt);
            }
        });
        menuLocal.add(itemRechDescLoc);

        jMenuBar1.add(menuLocal);

        menuCours.setText("Cours");

        itemCreateCours.setText("Creation Cours");
        itemCreateCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreateCoursActionPerformed(evt);
            }
        });
        menuCours.add(itemCreateCours);

        itemRechIdCours.setText("Recherche IDCours");
        itemRechIdCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechIdCoursActionPerformed(evt);
            }
        });
        menuCours.add(itemRechIdCours);

        itemRechPartMatCours.setText("Recherche Part. Matiere");
        itemRechPartMatCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechPartMatCoursActionPerformed(evt);
            }
        });
        menuCours.add(itemRechPartMatCours);

        jMenuBar1.add(menuCours);

        menuFormateur.setText("Formateur");

        itemCreateForm.setText("Creation Formateur");
        itemCreateForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreateFormActionPerformed(evt);
            }
        });
        menuFormateur.add(itemCreateForm);

        itemRechMatriculeForm.setText("Recherche par matricule");
        itemRechMatriculeForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechMatriculeFormActionPerformed(evt);
            }
        });
        menuFormateur.add(itemRechMatriculeForm);

        jMenuBar1.add(menuFormateur);

        menuInfos.setText("Infos");
        menuInfos.setToolTipText("");

        itemInfos.setText("Creation Infos");
        itemInfos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemInfosActionPerformed(evt);
            }
        });
        menuInfos.add(itemInfos);

        itemRechInfos.setText("Recherche Infos");
        itemRechInfos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechInfosActionPerformed(evt);
            }
        });
        menuInfos.add(itemRechInfos);

        jMenuBar1.add(menuInfos);

        menuSessioncours.setText("SessionCours");

        itemCreateSessioncours.setText("Creation SessionCours");
        itemCreateSessioncours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreateSessioncoursActionPerformed(evt);
            }
        });
        menuSessioncours.add(itemCreateSessioncours);

        itemRechIdformSessioncours.setText("Recherche Idform");
        itemRechIdformSessioncours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechIdformSessioncoursActionPerformed(evt);
            }
        });
        menuSessioncours.add(itemRechIdformSessioncours);

        jMenuBar1.add(menuSessioncours);

        menuVue.setText("Vue");

        itemVueForm.setText("Formateur");
        itemVueForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVueFormActionPerformed(evt);
            }
        });
        menuVue.add(itemVueForm);

        itemVueSessHeures.setText("Heures totales / Session");
        itemVueSessHeures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVueSessHeuresActionPerformed(evt);
            }
        });
        menuVue.add(itemVueSessHeures);

        jMenuBar1.add(menuVue);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCreateLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreateLocActionPerformed
        cardl.show(this.getContentPane(), "cardCreaLoc");
        
    }//GEN-LAST:event_itemCreateLocActionPerformed

    private void itemRechDescLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechDescLocActionPerformed
        cardl.show(this.getContentPane(), "cardRechDescLoc");
        
    }//GEN-LAST:event_itemRechDescLocActionPerformed

    private void itemCreateCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreateCoursActionPerformed
        cardl.show(this.getContentPane(), "cardCreaCours");
    }//GEN-LAST:event_itemCreateCoursActionPerformed

    private void itemRechMatriculeFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechMatriculeFormActionPerformed
        cardl.show(this.getContentPane(), "cardRechMatriculeForm");
    }//GEN-LAST:event_itemRechMatriculeFormActionPerformed

    private void itemRechSigleLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechSigleLocActionPerformed
        cardl.show(this.getContentPane(), "cardRechSigleLoc");
        
    }//GEN-LAST:event_itemRechSigleLocActionPerformed

    private void itemCreateFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreateFormActionPerformed
       cardl.show(this.getContentPane(), "cardCreaForm");
    }//GEN-LAST:event_itemCreateFormActionPerformed

    private void itemRechIdformSessioncoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechIdformSessioncoursActionPerformed
        cardl.show(this.getContentPane(), "cardRechIdSesscours");
    }//GEN-LAST:event_itemRechIdformSessioncoursActionPerformed

    private void itemCreateSessioncoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCreateSessioncoursActionPerformed
        cardl.show(this.getContentPane(), "cardCreaSessioncours");
    }//GEN-LAST:event_itemCreateSessioncoursActionPerformed

    private void itemRechIdCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechIdCoursActionPerformed
       cardl.show(this.getContentPane(), "cardRechIDCours");
    }//GEN-LAST:event_itemRechIdCoursActionPerformed

    private void menuAccueilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAccueilMouseClicked
       cardl.show(this.getContentPane(), "cardAccueil");
    }//GEN-LAST:event_menuAccueilMouseClicked

    private void itemVueFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVueFormActionPerformed
       cardl.show(this.getContentPane(), "cardAffVueForm");
    }//GEN-LAST:event_itemVueFormActionPerformed

    private void itemVueSessHeuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVueSessHeuresActionPerformed
       cardl.show(this.getContentPane(), "cardAffSessHeures");
    }//GEN-LAST:event_itemVueSessHeuresActionPerformed

    private void itemRechPartMatCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechPartMatCoursActionPerformed
        cardl.show(this.getContentPane(), "carRechPartCours");
    }//GEN-LAST:event_itemRechPartMatCoursActionPerformed

    private void itemInfosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemInfosActionPerformed
       cardl.show(this.getContentPane(), "cardCreateInfos");
    }//GEN-LAST:event_itemInfosActionPerformed

    private void itemRechInfosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechInfosActionPerformed
              cardl.show(this.getContentPane(), "cardRechInfos");
    }//GEN-LAST:event_itemRechInfosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionGraph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private projet.graph.accueil_fond accueil_fond;
    private projet.graph.AffVue_Formateur affVue_Formateur;
    private projet.graph.AffVue_SessionHeures affVue_SessionHeures;
    private projet.graph.CreateCours createCours;
    private projet.graph.CreateFormateur createFormateur;
    private projet.graph.CreateInfos createInfos;
    private projet.graph.CreateLocal createLocal;
    private projet.graph.CreateSessioncours createSessioncours;
    private javax.swing.JMenuItem itemCreateCours;
    private javax.swing.JMenuItem itemCreateForm;
    private javax.swing.JMenuItem itemCreateLoc;
    private javax.swing.JMenuItem itemCreateSessioncours;
    private javax.swing.JMenuItem itemInfos;
    private javax.swing.JMenuItem itemRechDescLoc;
    private javax.swing.JMenuItem itemRechIdCours;
    private javax.swing.JMenuItem itemRechIdformSessioncours;
    private javax.swing.JMenuItem itemRechInfos;
    private javax.swing.JMenuItem itemRechMatriculeForm;
    private javax.swing.JMenuItem itemRechPartMatCours;
    private javax.swing.JMenuItem itemRechSigleLoc;
    private javax.swing.JMenuItem itemVueForm;
    private javax.swing.JMenuItem itemVueSessHeures;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAccueil;
    private javax.swing.JMenu menuCours;
    private javax.swing.JMenu menuFormateur;
    private javax.swing.JMenu menuInfos;
    private javax.swing.JMenu menuLocal;
    private javax.swing.JMenu menuSessioncours;
    private javax.swing.JMenu menuVue;
    private projet.graph.RechercheDescriptionLocal rechercheDescriptionLocal;
    private projet.graph.RechercheIDCours rechercheIDCours;
    private projet.graph.RechercheIdformSessioncours rechercheIdformSessioncours;
    private projet.graph.RechercheIdinfos rechercheIdinfos;
    private projet.graph.RechercheMatiereCours rechercheMatiereCours;
    private projet.graph.RechercheMatriculeFormateur rechercheMatriculeFormateur;
    private projet.graph.RechercheSigleLocal rechercheSigleLoc;
    // End of variables declaration//GEN-END:variables
}
