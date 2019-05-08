
package projet.graph;

import javax.swing.JOptionPane;
import projet.DAO.LocalDAO;
import projet.metier.Local;

public class CreateLocal extends javax.swing.JPanel {

    LocalDAO localDAO=null;
    
    public CreateLocal() {
        initComponents();
    }
    
     public void setLocalDAO(LocalDAO localDAO){
        this.localDAO=localDAO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIdlocal = new javax.swing.JLabel();
        txtIdlocal = new javax.swing.JTextField();
        butCreateLocal = new javax.swing.JButton();
        lbSigle = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();
        lbPlaces = new javax.swing.JLabel();
        txtSigle = new javax.swing.JTextField();
        txtPlaces = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        lb1 = new javax.swing.JLabel();

        lbIdlocal.setText("Id local");

        txtIdlocal.setEditable(false);
        txtIdlocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdlocalActionPerformed(evt);
            }
        });

        butCreateLocal.setText("Créer un local");
        butCreateLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCreateLocalActionPerformed(evt);
            }
        });

        lbSigle.setText("Sigle");

        lbDescription.setText("Description");

        lbPlaces.setText("Places");

        txtSigle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSigleActionPerformed(evt);
            }
        });

        txtDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescriptionActionPerformed(evt);
            }
        });

        lb1.setText("Création d'un local :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbSigle)
                        .addComponent(lb1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbIdlocal))
                    .addComponent(lbPlaces)
                    .addComponent(lbDescription))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butCreateLocal)
                    .addComponent(txtSigle, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdlocal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lb1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdlocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIdlocal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSigle)
                    .addComponent(txtSigle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPlaces))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDescription)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(butCreateLocal)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdlocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdlocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdlocalActionPerformed

    private void butCreateLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCreateLocalActionPerformed
       try{  
       String sigle=txtSigle.getText();
       int places=Integer.parseInt(txtPlaces.getText());
       String description= txtDescription.getText();
       
       Local loc = new Local(0,sigle,places,description);
       loc=localDAO.create(loc);
       txtIdlocal.setText(""+loc.getIdlocal());
       JOptionPane.showMessageDialog(this,"Local créé","succès",JOptionPane.INFORMATION_MESSAGE);
       
     }
     catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_butCreateLocalActionPerformed

    private void txtSigleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSigleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSigleActionPerformed

    private void txtDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescriptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCreateLocal;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbIdlocal;
    private javax.swing.JLabel lbPlaces;
    private javax.swing.JLabel lbSigle;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtIdlocal;
    private javax.swing.JTextField txtPlaces;
    private javax.swing.JTextField txtSigle;
    // End of variables declaration//GEN-END:variables
}
