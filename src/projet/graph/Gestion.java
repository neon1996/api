package projet.graph;

import java.awt.CardLayout;
import java.sql.Connection;
import javax.swing.JOptionPane;
import projet.DAO.LocalDAO;
import projet.DAO.CoursDAO;
import projet.DAO.FormateurDAO;



import myconnections.DBConnection;

public class Gestion extends javax.swing.JFrame {

    CardLayout cardl;

    public Gestion() {
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

        createLocal.setLocalDAO(localDAO);
        rechercheSigleLoc.setLocalDAO(localDAO);
        rechercheDescriptionLocal.setLocalDAO(localDAO);
        
        createCours.setCoursDAO(coursDAO);
        rechercheNomCours.setCoursDAO(coursDAO);
        
        createFormateur.setFormateurDAO(formateurDAO);
        rechercheMatriculeFormateur.setFormateurDAO(formateurDAO);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rechercheDescriptionLocal = new projet.graph.RechercheDescriptionLocal();
        rechercheSigleLoc = new projet.graph.RechercheSigleLocal();
        createFormateur = new projet.graph.CreateFormateur();
        createCours = new projet.graph.CreateCours();
        rechercheMatriculeFormateur = new projet.graph.RechercheMatriculeFormateur();
        rechercheNomCours = new projet.graph.RechercheNomCours();
        createLocal = new projet.graph.CreateLocal();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuLocal = new javax.swing.JMenu();
        itemCreateLoc = new javax.swing.JMenuItem();
        itemRechSigleLoc = new javax.swing.JMenuItem();
        itemRechDescLoc = new javax.swing.JMenuItem();
        menuFormateur = new javax.swing.JMenu();
        itemCreateForm = new javax.swing.JMenuItem();
        itemRechMatriculeForm = new javax.swing.JMenuItem();
        menuCours = new javax.swing.JMenu();
        itemCreateCours = new javax.swing.JMenuItem();
        itemRechMatiereCours = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());
        getContentPane().add(rechercheDescriptionLocal, "cardRechDescLoc");
        getContentPane().add(rechercheSigleLoc, "cardRechSigleLoc");
        getContentPane().add(createFormateur, "cardCreaForm");
        getContentPane().add(createCours, "cardCreaCours");
        getContentPane().add(rechercheMatriculeFormateur, "cardRechMatriculeForm");
        getContentPane().add(rechercheNomCours, "cardRechCours");
        getContentPane().add(createLocal, "cardCreaLoc");

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

        menuCours.setText("Cours");

        itemCreateCours.setText("Creation Cours");
        itemCreateCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCreateCoursActionPerformed(evt);
            }
        });
        menuCours.add(itemCreateCours);

        itemRechMatiereCours.setText("Recherche Nom");
        itemRechMatiereCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRechMatiereCoursActionPerformed(evt);
            }
        });
        menuCours.add(itemRechMatiereCours);

        jMenuBar1.add(menuCours);

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

    private void itemRechMatiereCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRechMatiereCoursActionPerformed
        cardl.show(this.getContentPane(), "cardRechCours");
    }//GEN-LAST:event_itemRechMatiereCoursActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private projet.graph.CreateCours createCours;
    private projet.graph.CreateFormateur createFormateur;
    private projet.graph.CreateLocal createLocal;
    private javax.swing.JMenuItem itemCreateCours;
    private javax.swing.JMenuItem itemCreateForm;
    private javax.swing.JMenuItem itemCreateLoc;
    private javax.swing.JMenuItem itemRechDescLoc;
    private javax.swing.JMenuItem itemRechMatiereCours;
    private javax.swing.JMenuItem itemRechMatriculeForm;
    private javax.swing.JMenuItem itemRechSigleLoc;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCours;
    private javax.swing.JMenu menuFormateur;
    private javax.swing.JMenu menuLocal;
    private projet.graph.RechercheDescriptionLocal rechercheDescriptionLocal;
    private projet.graph.RechercheMatriculeFormateur rechercheMatriculeFormateur;
    private projet.graph.RechercheNomCours rechercheNomCours;
    private projet.graph.RechercheSigleLocal rechercheSigleLoc;
    // End of variables declaration//GEN-END:variables
}
