
package projet.graph;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projet.DAO.Vue_FormateurDAO;
import projet.metier.Vue_Formateur;

public class AffVue_Formateur extends javax.swing.JPanel {
    
    Vue_FormateurDAO vue_formateurDAO = null;
    DefaultTableModel dft1 = new DefaultTableModel();
    
    public AffVue_Formateur() {
        initComponents();
        dft1.addColumn("nom");
        dft1.addColumn("prenom");
        dft1.addColumn("matiere");
        dft1.addColumn("idsesscours");
        tableVueForm.setModel(dft1);
    }

    public void setVue_formateurDAO(Vue_FormateurDAO vue_formateurDAO) {
        this.vue_formateurDAO = vue_formateurDAO;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableVueForm = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbIdform = new javax.swing.JLabel();
        btChercher = new javax.swing.JButton();
        txtIdform = new javax.swing.JTextField();

        tableVueForm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "nom", "prenom", "matiere", "idsesscours"
            }
        ));
        jScrollPane1.setViewportView(tableVueForm);

        jLabel1.setText("Formateur - matière - session ");

        lbIdform.setText("ID Formateur :");

        btChercher.setText("Chercher");
        btChercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChercherActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbIdform)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdform, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btChercher))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdform)
                    .addComponent(txtIdform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btChercher))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btChercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChercherActionPerformed
         try {
            int idform= Integer.parseInt(txtIdform.getText());
            System.out.println("idform");
            
            List<Vue_Formateur> vff = vue_formateurDAO.SessionFormateur(idform);
            int nr = dft1.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dft1.removeRow(i);
            }
            for (Vue_Formateur vf : vff) {

                Vector v = new Vector();
                
                v.add(vf.getNom());
                v.add(vf.getPrenom());
                v.add(vf.getMatiere());
                v.add(vf.getSesscours());
                dft1.addRow(v);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btChercherActionPerformed

    private void txtIdformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdformActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdformActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChercher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIdform;
    private javax.swing.JTable tableVueForm;
    private javax.swing.JTextField txtIdform;
    // End of variables declaration//GEN-END:variables
}
