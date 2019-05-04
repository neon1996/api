
package projet.graph;
import javax.swing.JOptionPane;
import projet.DAO.FormateurDAO;
import projet.metier.Formateur;

public class RechercheMatriculeFormateur extends javax.swing.JPanel {

    FormateurDAO formateurDAO = null;
    Formateur fr = null;
    public RechercheMatriculeFormateur() {
        initComponents();
    }

    public void setFormateurDAO(FormateurDAO formateurDAO) {
        this.formateurDAO = formateurDAO;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        butRechMatriculeForm = new javax.swing.JButton();
        butMajForm = new javax.swing.JButton();
        butSupForm = new javax.swing.JButton();
        txtMatricule = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbRue = new javax.swing.JLabel();
        lbLocalite = new javax.swing.JLabel();
        lbCp = new javax.swing.JLabel();
        lbTel = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtRue = new javax.swing.JTextField();
        txtLocalite = new javax.swing.JTextField();
        txtCp = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        lbIdform = new javax.swing.JLabel();
        txtIdform = new javax.swing.JTextField();

        jLabel1.setText("Recherche formateur via matricule");

        jLabel2.setText("Matricule");

        jLabel3.setText("Nom");

        jLabel4.setText("Prenom");

        butRechMatriculeForm.setText("Rechercher");
        butRechMatriculeForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRechMatriculeFormActionPerformed(evt);
            }
        });

        butMajForm.setText("MAJ");
        butMajForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMajFormActionPerformed(evt);
            }
        });

        butSupForm.setText("Supprimer");
        butSupForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSupFormActionPerformed(evt);
            }
        });

        txtMatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculeActionPerformed(evt);
            }
        });

        jLabel5.setText("Numero");

        lbRue.setText("Rue");

        lbLocalite.setText("Localite");

        lbCp.setText("CP");

        lbTel.setText("Telephone");

        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        lbIdform.setText("ID Form");

        txtIdform.setEditable(false);
        txtIdform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdformActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(lbCp)
                                .addComponent(lbTel)
                                .addComponent(butRechMatriculeForm))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbIdform)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbRue)
                                        .addComponent(jLabel5)
                                        .addComponent(lbLocalite)))
                                .addGap(51, 51, 51)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMatricule, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txtIdform)
                                    .addComponent(txtNom)
                                    .addComponent(txtPrenom)
                                    .addComponent(txtNumero)
                                    .addComponent(txtRue)
                                    .addComponent(txtLocalite)
                                    .addComponent(txtCp)
                                    .addComponent(txtTel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(butMajForm)
                                .addGap(33, 33, 33)
                                .addComponent(butSupForm)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIdform)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRue)
                    .addComponent(txtRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLocalite)
                    .addComponent(txtLocalite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butRechMatriculeForm)
                    .addComponent(butMajForm)
                    .addComponent(butSupForm))
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butRechMatriculeFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRechMatriculeFormActionPerformed
        try {
            String matricule = txtMatricule.getText();

            fr = formateurDAO.readMatricule(matricule);

            txtIdform.setText("" + fr.getIdform());
            txtNom.setText(fr.getNom());
            txtPrenom.setText(fr.getPrenom());
            txtNumero.setText(fr.getNumero());
            txtRue.setText(fr.getRue());
            txtLocalite.setText(fr.getLocalite());
            txtCp.setText("" + fr.getCp());
            txtTel.setText(fr.getTelephone());
            

            JOptionPane.showMessageDialog(this, "Formateur trouvé", "succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butRechMatriculeFormActionPerformed

    private void butMajFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butMajFormActionPerformed
        try {

            int idform = Integer.parseInt(txtIdform.getText());
            String matricule = txtMatricule.getText();

            String nom = txtNom.getText();
            String prenom = txtPrenom.getText();
            String numero = txtNumero.getText();
            String rue = txtRue.getText();
            String localite = txtLocalite.getText();
            int cp = Integer.parseInt(txtCp.getText());
            String tel = txtTel.getText();

            Formateur loc = new Formateur(idform,matricule,nom,prenom,numero,rue,localite,cp,tel);
            formateurDAO.update(loc);
            JOptionPane.showMessageDialog(this, "Formateur mis à jour", "succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butMajFormActionPerformed

    private void txtMatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculeActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed

    private void txtIdformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdformActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdformActionPerformed

    private void butSupFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSupFormActionPerformed
         try {
            String matricule = txtMatricule.getText();

            formateurDAO.delete(fr);
            txtIdform.setText("");
            txtMatricule.setText("");
            txtNom.setText("");
            txtPrenom.setText("");
            txtNumero.setText("");
            txtRue.setText("");
            txtLocalite.setText("");
            txtCp.setText("");
            txtTel.setText("");

            JOptionPane.showMessageDialog(this, "Formateur effacé", "succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butSupFormActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butMajForm;
    private javax.swing.JButton butRechMatriculeForm;
    private javax.swing.JButton butSupForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbCp;
    private javax.swing.JLabel lbIdform;
    private javax.swing.JLabel lbLocalite;
    private javax.swing.JLabel lbRue;
    private javax.swing.JLabel lbTel;
    private javax.swing.JTextField txtCp;
    private javax.swing.JTextField txtIdform;
    private javax.swing.JTextField txtLocalite;
    private javax.swing.JTextField txtMatricule;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPrenom;
    private javax.swing.JTextField txtRue;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
