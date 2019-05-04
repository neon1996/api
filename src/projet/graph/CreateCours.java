
package projet.graph;
import javax.swing.JOptionPane;
import projet.DAO.CoursDAO;
import projet.metier.Cours;

public class CreateCours extends javax.swing.JPanel {

    CoursDAO coursDAO = null;
    public CreateCours() {
        initComponents();
    }

    public void setCoursDAO(CoursDAO coursDAO) {
        this.coursDAO = coursDAO;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lbIdcours = new javax.swing.JLabel();
        lbMatiere = new javax.swing.JLabel();
        lbHeures = new javax.swing.JLabel();
        txtHeures = new javax.swing.JTextField();
        txtMatiere = new javax.swing.JTextField();
        txtIdcours = new javax.swing.JTextField();
        butCreateCours = new javax.swing.JButton();

        lb1.setText("Création d'un cours :");

        lbIdcours.setText("Id cours");

        lbMatiere.setText("Matière");

        lbHeures.setText("Heures ");

        txtIdcours.setEditable(false);
        txtIdcours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdcoursActionPerformed(evt);
            }
        });

        butCreateCours.setText("Créer un cours");
        butCreateCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCreateCoursActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHeures)
                            .addComponent(lbMatiere)
                            .addComponent(lbIdcours))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(butCreateCours)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIdcours, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                .addComponent(txtMatiere)
                                .addComponent(txtHeures)))))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lb1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdcours)
                    .addComponent(txtIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMatiere)
                    .addComponent(txtMatiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHeures)
                    .addComponent(txtHeures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(butCreateCours)
                .addContainerGap(64, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdcoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdcoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdcoursActionPerformed

    private void butCreateCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCreateCoursActionPerformed
        try{  
       String matiere=txtMatiere.getText();
       int heures=Integer.parseInt(txtHeures.getText());
       
       
       Cours co = new Cours(0,matiere,heures);
       co=coursDAO.create(co);
       txtIdcours.setText(""+co.getIdcours());
       JOptionPane.showMessageDialog(this,"Cours créé","succès",JOptionPane.INFORMATION_MESSAGE);
       
     }
     catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_butCreateCoursActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCreateCours;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lbHeures;
    private javax.swing.JLabel lbIdcours;
    private javax.swing.JLabel lbMatiere;
    private javax.swing.JTextField txtHeures;
    private javax.swing.JTextField txtIdcours;
    private javax.swing.JTextField txtMatiere;
    // End of variables declaration//GEN-END:variables
}
