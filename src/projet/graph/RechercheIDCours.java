
package projet.graph;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projet.DAO.CoursDAO;
import projet.DAO.SessioncoursDAO;
import projet.metier.Sessioncours;
import projet.metier.Cours;

public class RechercheIDCours extends javax.swing.JPanel {

    CoursDAO coursDAO =null;
    SessioncoursDAO sessioncoursDAO=null;
    
    Cours co= null; 
  
    
    DefaultTableModel dft1 = new DefaultTableModel();
    
    
    public RechercheIDCours() {
        initComponents();
        dft1.addColumn("idsesscours");
        dft1.addColumn("datedebut");
        dft1.addColumn("datefin");
        dft1.addColumn("nbreinscrits");
        dft1.addColumn("idlocal");
        
       // dft1.addColumn("idcours");
        tableRechSesscours.setModel(dft1);
    }

    public void setCoursDAO(CoursDAO coursDAO) {
        this.coursDAO = coursDAO;
    }

    public void setSessioncoursDAO(SessioncoursDAO sessioncoursDAO) {
        this.sessioncoursDAO = sessioncoursDAO;
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbMatiere = new javax.swing.JLabel();
        lbIdcours = new javax.swing.JLabel();
        lbHeures = new javax.swing.JLabel();
        butRechMatiereCours = new javax.swing.JButton();
        txtMatiere = new javax.swing.JTextField();
        txtIdcours = new javax.swing.JTextField();
        txtHeures = new javax.swing.JTextField();
        butMajCours = new javax.swing.JButton();
        butSupCours = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRechSesscours = new javax.swing.JTable();

        jLabel1.setText("Recherche cours via IDCOURS");

        lbMatiere.setText("Matiere");

        lbIdcours.setText("ID Cours");

        lbHeures.setText("Heures");

        butRechMatiereCours.setText("Rechercher");
        butRechMatiereCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRechMatiereCoursActionPerformed(evt);
            }
        });

        txtMatiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatiereActionPerformed(evt);
            }
        });

        txtIdcours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdcoursActionPerformed(evt);
            }
        });

        txtHeures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHeuresActionPerformed(evt);
            }
        });

        butMajCours.setText("MAJ");
        butMajCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMajCoursActionPerformed(evt);
            }
        });

        butSupCours.setText("Supprimer");
        butSupCours.setToolTipText("");
        butSupCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSupCoursActionPerformed(evt);
            }
        });

        jLabel2.setText("Session Cours :");

        tableRechSesscours.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idsesscours", "datedebut", "datefin", "nbreinscrits", "idlocal"
            }
        ));
        jScrollPane2.setViewportView(tableRechSesscours);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(325, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbIdcours)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbHeures)
                                        .addComponent(lbMatiere)))
                                .addGap(119, 119, 119)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtMatiere, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(txtHeures))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(butRechMatiereCours, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(butMajCours)
                                .addGap(41, 41, 41)
                                .addComponent(butSupCours)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbIdcours)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMatiere)
                            .addComponent(txtMatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHeures)
                    .addComponent(txtHeures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butRechMatiereCours, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butMajCours)
                    .addComponent(butSupCours))
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butRechMatiereCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRechMatiereCoursActionPerformed
        
         try{
              int idcours= Integer.parseInt(txtIdcours.getText());
             co=coursDAO.read(idcours);
             txtMatiere.setText(co.getMatiere());
             txtHeures.setText(""+co.getHeures());
             JOptionPane.showMessageDialog(this,"Cours trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
             
              
                List<Sessioncours> ssc= sessioncoursDAO.RechCours_Sesscours(idcours);
                int nr = dft1.getRowCount();
                for(int i=nr-1;i>=0;i--)dft1.removeRow(i);
                for(Sessioncours sc :ssc){
                    Vector v = new Vector();
                    v.add(sc.getIdsesscours());
                    v.add(sc.getDateDebut());
                    v.add(sc.getDateFin());
                    v.add(sc.getNbreinscrits());
                    v.add(sc.getIdlocal());
                    dft1.addRow(v);
 
                    }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_butRechMatiereCoursActionPerformed

    private void txtHeuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHeuresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHeuresActionPerformed

    private void butMajCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butMajCoursActionPerformed
        try {

            int idcours = Integer.parseInt(txtIdcours.getText());
            String matiere = txtMatiere.getText();
            int heures = Integer.parseInt(txtHeures.getText());
            
            Cours co = new Cours(idcours,matiere,heures);
            coursDAO.update(co);
            JOptionPane.showMessageDialog(this, "Cours mis à jour", "succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butMajCoursActionPerformed

    private void butSupCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSupCoursActionPerformed
      
       
                try {
                int idcours = Integer.parseInt(txtIdcours.getText());

                coursDAO.delete(co);
                txtIdcours.setText("");
                txtMatiere.setText("");
                txtHeures.setText("");

                JOptionPane.showMessageDialog(this, "Cours effacé", "succès", JOptionPane.INFORMATION_MESSAGE);
             
       
         } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"ERREUR", JOptionPane.ERROR_MESSAGE);
        }
          
    }//GEN-LAST:event_butSupCoursActionPerformed

    private void txtMatiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatiereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatiereActionPerformed

    private void txtIdcoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdcoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdcoursActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butMajCours;
    private javax.swing.JButton butRechMatiereCours;
    private javax.swing.JButton butSupCours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbHeures;
    private javax.swing.JLabel lbIdcours;
    private javax.swing.JLabel lbMatiere;
    private javax.swing.JTable tableRechSesscours;
    private javax.swing.JTextField txtHeures;
    private javax.swing.JTextField txtIdcours;
    private javax.swing.JTextField txtMatiere;
    // End of variables declaration//GEN-END:variables
}
