/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.graph;

import javax.swing.JOptionPane;
import projet.DAO.LocalDAO;
import projet.metier.Local;

/**
 *
 * @author Florence
 */
public class RechercheSigleLoc extends javax.swing.JPanel {

    LocalDAO localDAO = null;
    Local loc = null;

    public RechercheSigleLoc() {
        initComponents();
    }

    public void setLocalDAO(LocalDAO localDAO) {
        this.localDAO = localDAO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labIdlocal = new javax.swing.JLabel();
        labSigle = new javax.swing.JLabel();
        labPlaces = new javax.swing.JLabel();
        labDescription = new javax.swing.JLabel();
        txtIdlocal = new javax.swing.JTextField();
        txtSigle = new javax.swing.JTextField();
        txtPlaces = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        butRechercherLocal = new javax.swing.JButton();
        butMajLocal = new javax.swing.JButton();
        butSupLocal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        labIdlocal.setText("Id local");

        labSigle.setText("Sigle");

        labPlaces.setText("Places");

        labDescription.setText("Description");

        txtIdlocal.setEditable(false);
        txtIdlocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdlocalActionPerformed(evt);
            }
        });

        txtSigle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSigleActionPerformed(evt);
            }
        });

        txtPlaces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacesActionPerformed(evt);
            }
        });

        butRechercherLocal.setText("Rechercher Local");
        butRechercherLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butRechercherLocalMouseClicked(evt);
            }
        });
        butRechercherLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRechercherLocalActionPerformed(evt);
            }
        });

        butMajLocal.setText("MAJ Local");
        butMajLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMajLocalActionPerformed(evt);
            }
        });

        butSupLocal.setText("Supprimer Local");
        butSupLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSupLocalActionPerformed(evt);
            }
        });

        jLabel1.setText("Recherche d'un local par le sigle :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(butRechercherLocal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(butMajLocal))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labSigle, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labPlaces)
                                    .addComponent(labIdlocal)
                                    .addComponent(labDescription))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(txtSigle, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                    .addComponent(txtPlaces)
                                    .addComponent(txtIdlocal))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(butSupLocal)
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labSigle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSigle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labIdlocal))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtIdlocal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labPlaces)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtPlaces, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labDescription, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDescription, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butRechercherLocal)
                    .addComponent(butMajLocal)
                    .addComponent(butSupLocal))
                .addGap(44, 44, 44))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdlocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdlocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdlocalActionPerformed

    private void txtSigleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSigleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSigleActionPerformed

    private void txtPlacesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacesActionPerformed

    private void butRechercherLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRechercherLocalActionPerformed
        try {
            String sigle = txtSigle.getText();

            loc = localDAO.readSigle(sigle);

            txtIdlocal.setText("" + loc.getIdlocal());
            txtPlaces.setText("" + loc.getPlaces());
            txtDescription.setText(loc.getDescription());

            JOptionPane.showMessageDialog(this, "Local trouvé", "succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butRechercherLocalActionPerformed

    private void butMajLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butMajLocalActionPerformed

        try {

            int idlocal = Integer.parseInt(txtIdlocal.getText());
            String sigle = txtSigle.getText();

            String description = txtDescription.getText();
            int places = Integer.parseInt(txtPlaces.getText());

            Local loc = new Local(idlocal, sigle, places, description);
            localDAO.update(loc);
            JOptionPane.showMessageDialog(this, "Local mis à jour", "succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_butMajLocalActionPerformed

    private void butSupLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSupLocalActionPerformed

        try {
            String sigle = txtSigle.getText();

            localDAO.delete(loc);
            txtIdlocal.setText("");
            txtSigle.setText("");
            txtPlaces.setText("");
            txtDescription.setText("");

            JOptionPane.showMessageDialog(this, "Local effacé", "succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_butSupLocalActionPerformed

    private void butRechercherLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butRechercherLocalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_butRechercherLocalMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butMajLocal;
    private javax.swing.JButton butRechercherLocal;
    private javax.swing.JButton butSupLocal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labDescription;
    private javax.swing.JLabel labIdlocal;
    private javax.swing.JLabel labPlaces;
    private javax.swing.JLabel labSigle;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtIdlocal;
    private javax.swing.JTextField txtPlaces;
    private javax.swing.JTextField txtSigle;
    // End of variables declaration//GEN-END:variables
}
