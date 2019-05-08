
package projet.graph;
import javax.swing.JOptionPane;
import projet.DAO.FormateurDAO;
import projet.metier.Formateur;

public class CreateFormateur extends javax.swing.JPanel {

    FormateurDAO formateurDAO = null;
    
    public CreateFormateur() {
        initComponents();
    }

    public void setFormateurDAO(FormateurDAO formateurDAO) {
        this.formateurDAO = formateurDAO;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbIdform = new javax.swing.JLabel();
        lbMatricule = new javax.swing.JLabel();
        lbNom = new javax.swing.JLabel();
        lbPrenom = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        lbRue = new javax.swing.JLabel();
        lbLocalite = new javax.swing.JLabel();
        lbCp = new javax.swing.JLabel();
        lbTel = new javax.swing.JLabel();
        butCreateForm = new javax.swing.JButton();
        txtIdform = new javax.swing.JTextField();
        txtMatricule = new javax.swing.JTextField();
        txtNom = new javax.swing.JTextField();
        txtPrenom = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtRue = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtCp = new javax.swing.JTextField();
        txtLocalite = new javax.swing.JTextField();

        jLabel1.setText("Création d'un formateur :");

        lbIdform.setText("Id formateur");

        lbMatricule.setText("Matricule");

        lbNom.setText("Nom");

        lbPrenom.setText("Prenom");

        lbNumero.setText("Numero");

        lbRue.setText("Rue");

        lbLocalite.setText("Localite");

        lbCp.setText("CP");

        lbTel.setText("Telephone");

        butCreateForm.setText("Créer un formateur");
        butCreateForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCreateFormActionPerformed(evt);
            }
        });

        txtIdform.setEditable(false);
        txtIdform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdformActionPerformed(evt);
            }
        });

        txtMatricule.setToolTipText("");
        txtMatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculeActionPerformed(evt);
            }
        });

        txtPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrenomActionPerformed(evt);
            }
        });

        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbIdform)
                            .addComponent(lbMatricule)
                            .addComponent(lbNom)
                            .addComponent(lbPrenom)
                            .addComponent(lbNumero)
                            .addComponent(lbRue)
                            .addComponent(lbLocalite)
                            .addComponent(lbCp)
                            .addComponent(lbTel))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(butCreateForm)
                                .addGap(186, 186, 186))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtIdform, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                        .addComponent(txtMatricule)
                                        .addComponent(txtNom)
                                        .addComponent(txtPrenom)
                                        .addComponent(txtNumero)
                                        .addComponent(txtRue)
                                        .addComponent(txtLocalite))
                                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdform)
                    .addComponent(txtIdform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMatricule)
                    .addComponent(txtMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNom)
                    .addComponent(txtNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPrenom))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRue)
                    .addComponent(txtRue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocalite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLocalite, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCp))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(butCreateForm)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butCreateFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCreateFormActionPerformed
         try{  
       String matricule=txtMatricule.getText();
       String nom=txtNom.getText();
       String prenom=txtPrenom.getText();
       String numero=txtNumero.getText();
       String rue=txtRue.getText();
       String localite=txtLocalite.getText();
       int cp=Integer.parseInt(txtCp.getText());
       String tel=txtTel.getText();
       
       
       Formateur fr= new Formateur(0,matricule,nom,prenom,numero,rue,localite,cp,tel);
       fr=formateurDAO.create(fr);
       txtIdform.setText(""+fr.getIdform());
       JOptionPane.showMessageDialog(this,"Formateur créé","succès",JOptionPane.INFORMATION_MESSAGE);
       
     }
     catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_butCreateFormActionPerformed

    private void txtMatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculeActionPerformed

    private void txtPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrenomActionPerformed

    private void txtIdformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdformActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdformActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCreateForm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbCp;
    private javax.swing.JLabel lbIdform;
    private javax.swing.JLabel lbLocalite;
    private javax.swing.JLabel lbMatricule;
    private javax.swing.JLabel lbNom;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbPrenom;
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