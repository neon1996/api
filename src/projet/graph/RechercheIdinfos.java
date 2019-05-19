
package projet.graph;

import javax.swing.JOptionPane;
import projet.DAO.InfosDAO;
import projet.metier.Infos;

public class RechercheIdinfos extends javax.swing.JPanel {

    InfosDAO infosDAO = null;
    Infos inf = null;
    
    public RechercheIdinfos() {
        initComponents();
    }

    public void setInfosDAO(InfosDAO infosDAO) {
        this.infosDAO = infosDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbIdinfos = new javax.swing.JLabel();
        lbIdform = new javax.swing.JLabel();
        lbIdsesscours = new javax.swing.JLabel();
        lbNbrheure = new javax.swing.JLabel();
        txtIdinfos = new javax.swing.JTextField();
        txtIdform = new javax.swing.JTextField();
        txtIdsesscours = new javax.swing.JTextField();
        txtNbrheure = new javax.swing.JTextField();
        butRechIdinfos = new javax.swing.JButton();
        butSupInfos = new javax.swing.JButton();

        jLabel1.setText("Recherche via ID Infos :");

        lbIdinfos.setText("ID Infos");

        lbIdform.setText("ID Formateur");

        lbIdsesscours.setText("ID Session de cours");

        lbNbrheure.setText("Nbr heure");

        txtNbrheure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNbrheureActionPerformed(evt);
            }
        });

        butRechIdinfos.setText("Chercher");
        butRechIdinfos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRechIdinfosActionPerformed(evt);
            }
        });

        butSupInfos.setText("Supprimer");
        butSupInfos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSupInfosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(butRechIdinfos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(butSupInfos))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lbIdform)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdform, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbIdsesscours)
                                .addComponent(lbNbrheure))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdsesscours, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNbrheure, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lbIdinfos)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdinfos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdinfos)
                    .addComponent(txtIdinfos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdform)
                    .addComponent(txtIdform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdsesscours)
                    .addComponent(txtIdsesscours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNbrheure)
                    .addComponent(txtNbrheure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butRechIdinfos)
                    .addComponent(butSupInfos))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butRechIdinfosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRechIdinfosActionPerformed
        try{
              int idinfos= Integer.parseInt(txtIdinfos.getText());
             inf=infosDAO.read(idinfos);
             
             txtIdform.setText(""+inf.getIdform());
             txtIdsesscours.setText(""+inf.getIdsesscours());
             txtNbrheure.setText(""+inf.getNbrheure());
             
             JOptionPane.showMessageDialog(this,"Informations trouvée dans la table Infos","succès",JOptionPane.INFORMATION_MESSAGE);
              
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_butRechIdinfosActionPerformed

    private void butSupInfosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSupInfosActionPerformed
        try {
            int idinfos= Integer.parseInt(txtIdinfos.getText());

            infosDAO.delete(inf);
            txtIdinfos.setText("");
            txtIdform.setText("");
            
            txtIdsesscours.setText("");
            txtNbrheure.setText("");
           

            JOptionPane.showMessageDialog(this, "Formateur effacé", "succès", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butSupInfosActionPerformed

    private void txtNbrheureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNbrheureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNbrheureActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butRechIdinfos;
    private javax.swing.JButton butSupInfos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbIdform;
    private javax.swing.JLabel lbIdinfos;
    private javax.swing.JLabel lbIdsesscours;
    private javax.swing.JLabel lbNbrheure;
    private javax.swing.JTextField txtIdform;
    private javax.swing.JTextField txtIdinfos;
    private javax.swing.JTextField txtIdsesscours;
    private javax.swing.JTextField txtNbrheure;
    // End of variables declaration//GEN-END:variables
}
