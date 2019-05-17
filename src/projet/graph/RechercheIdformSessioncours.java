
package projet.graph;
import javax.swing.JOptionPane;
import projet.DAO.SessioncoursDAO;
import projet.metier.Sessioncours;

public class RechercheIdformSessioncours extends javax.swing.JPanel {

    SessioncoursDAO sessioncoursDAO = null;
    Sessioncours sc = null;

    
    
    public RechercheIdformSessioncours() {
        initComponents();
    }

    public void setSessioncoursDAO(SessioncoursDAO sessioncoursDAO) {
        this.sessioncoursDAO = sessioncoursDAO;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        butRechIdSesscours = new javax.swing.JButton();
        lbIdsesscours = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdsesscours = new javax.swing.JTextField();
        txtDatedebut = new javax.swing.JTextField();
        txtDatefin = new javax.swing.JTextField();
        txtNbreinscrits = new javax.swing.JTextField();
        txtIdlocal = new javax.swing.JTextField();
        txtIdcours = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btMaj = new javax.swing.JButton();
        btSupprimer = new javax.swing.JButton();

        jLabel1.setText("Recherche Session Cours via ID Sess :");

        butRechIdSesscours.setText("Rechercher");
        butRechIdSesscours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRechIdSesscoursActionPerformed(evt);
            }
        });

        lbIdsesscours.setText("ID Session Cours");

        jLabel3.setText("Date debut");

        jLabel4.setText("Date fin");

        txtIdsesscours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdsesscoursActionPerformed(evt);
            }
        });

        txtDatedebut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatedebutActionPerformed(evt);
            }
        });

        txtDatefin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatefinActionPerformed(evt);
            }
        });

        txtNbreinscrits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNbreinscritsActionPerformed(evt);
            }
        });

        txtIdlocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdlocalActionPerformed(evt);
            }
        });

        txtIdcours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdcoursActionPerformed(evt);
            }
        });

        jLabel2.setText("Nbre Inscrits");

        jLabel5.setText("ID Cours");

        jLabel6.setText("ID Local");

        btMaj.setText("MAJ");
        btMaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMajActionPerformed(evt);
            }
        });

        btSupprimer.setText("Supprimer");
        btSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIdsesscours)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdlocal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNbreinscrits, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btSupprimer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtIdsesscours, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDatefin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btMaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtDatedebut, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(butRechIdSesscours)))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIdsesscours)
                    .addComponent(txtIdsesscours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDatedebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(butRechIdSesscours)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDatefin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMaj))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNbreinscrits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btSupprimer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdlocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(113, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butRechIdSesscoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRechIdSesscoursActionPerformed
       try{
              int idsesscours= Integer.parseInt(txtIdsesscours.getText());
             sc = sessioncoursDAO.read(idsesscours);
             
             txtDatedebut.setText(""+sc.getDateDebut());
             txtDatefin.setText(""+sc.getDateFin());
             
             txtNbreinscrits.setText(""+sc.getNbreinscrits());
             txtIdcours.setText(""+sc.getIdcours());
             txtIdlocal.setText(""+sc.getIdlocal());
             
             JOptionPane.showMessageDialog(this,"Session cours trouvée","succès",JOptionPane.INFORMATION_MESSAGE);
             
             
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_butRechIdSesscoursActionPerformed

    private void txtIdsesscoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdsesscoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdsesscoursActionPerformed

    private void txtDatedebutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatedebutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatedebutActionPerformed

    private void txtDatefinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatefinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatefinActionPerformed

    private void txtNbreinscritsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNbreinscritsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNbreinscritsActionPerformed

    private void txtIdlocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdlocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdlocalActionPerformed

    private void txtIdcoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdcoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdcoursActionPerformed

    private void btSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSupprimerActionPerformed
      try {
                int idsesscours = Integer.parseInt(txtIdsesscours.getText());

                sessioncoursDAO.delete(sc);
                txtDatedebut.setText("");
                txtDatefin.setText("");
                txtNbreinscrits.setText("");
                txtIdcours.setText("");
                txtIdlocal.setText("");
                

                JOptionPane.showMessageDialog(this, "Cours effacé", "succès", JOptionPane.INFORMATION_MESSAGE);
             
       
         } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"ERREUR", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btSupprimerActionPerformed

    private void btMajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMajActionPerformed
        try {

            int idsesscours = Integer.parseInt(txtIdsesscours.getText());
            int nbreinscrits = Integer.parseInt(txtNbreinscrits.getText());
            
            
            
            int idlocal = Integer.parseInt(txtIdlocal.getText());
            int idcours = Integer.parseInt(txtIdcours.getText());
            
            Sessioncours ssc = new Sessioncours(idsesscours,datedebut,datefin,nbreinscrits,idlocal,idcours);
            sessioncoursDAO.update(ssc);
            JOptionPane.showMessageDialog(this, "Cours mis à jour", "succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btMajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMaj;
    private javax.swing.JButton btSupprimer;
    private javax.swing.JButton butRechIdSesscours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbIdsesscours;
    private javax.swing.JTextField txtDatedebut;
    private javax.swing.JTextField txtDatefin;
    private javax.swing.JTextField txtIdcours;
    private javax.swing.JTextField txtIdlocal;
    private javax.swing.JTextField txtIdsesscours;
    private javax.swing.JTextField txtNbreinscrits;
    // End of variables declaration//GEN-END:variables
}
