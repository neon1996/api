package projet.graph;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projet.DAO.CoursDAO;

import projet.metier.Cours;

public class RechercheNomCours extends javax.swing.JPanel {

    CoursDAO coursDAO = null;

    Cours co = null;

    DefaultTableModel dft1 = new DefaultTableModel();

    public RechercheNomCours() {
        initComponents();

    }

    public void setCoursDAO(CoursDAO coursDAO) {
        this.coursDAO = coursDAO;
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

        jLabel1.setText("Recherche cours via matiere");

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

        txtIdcours.setEditable(false);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butRechMatiereCours, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(butMajCours)
                        .addGap(32, 32, 32)
                        .addComponent(butSupCours))
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHeures)
                            .addComponent(lbIdcours)
                            .addComponent(lbMatiere))
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtIdcours, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(txtMatiere, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHeures))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbMatiere)
                        .addGap(18, 18, 18)
                        .addComponent(lbIdcours))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtMatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHeures)
                    .addComponent(txtHeures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butRechMatiereCours, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butMajCours)
                    .addComponent(butSupCours))
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butRechMatiereCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRechMatiereCoursActionPerformed

        try {
            String matiere = txtMatiere.getText();

            co = coursDAO.readMatiere(matiere);

            txtIdcours.setText("" + co.getIdcours());
            txtHeures.setText("" + co.getHeures());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_butRechMatiereCoursActionPerformed

    private void txtHeuresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHeuresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHeuresActionPerformed

    private void txtMatiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatiereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatiereActionPerformed

    private void butSupCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSupCoursActionPerformed
        try {
            String matiere = txtMatiere.getText();

            coursDAO.delete(co);
            txtIdcours.setText("");
            txtMatiere.setText("");
            txtHeures.setText("");

            JOptionPane.showMessageDialog(this, "Cours effacé", "succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butSupCoursActionPerformed

    private void butMajCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butMajCoursActionPerformed
        try {

            int idcours = Integer.parseInt(txtIdcours.getText());
            String matiere = txtMatiere.getText();
            int heures = Integer.parseInt(txtHeures.getText());

            Cours co = new Cours(idcours, matiere, heures);
            coursDAO.update(co);
            JOptionPane.showMessageDialog(this, "Cours mis à jour", "succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butMajCoursActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butMajCours;
    private javax.swing.JButton butRechMatiereCours;
    private javax.swing.JButton butSupCours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbHeures;
    private javax.swing.JLabel lbIdcours;
    private javax.swing.JLabel lbMatiere;
    private javax.swing.JTextField txtHeures;
    private javax.swing.JTextField txtIdcours;
    private javax.swing.JTextField txtMatiere;
    // End of variables declaration//GEN-END:variables
}
