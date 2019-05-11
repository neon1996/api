
package projet.graph;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projet.DAO.Vue_SessionHeuresDAO;
import projet.metier.Vue_SessionHeures;

public class AffVue_SessionHeures extends javax.swing.JPanel {

    Vue_SessionHeuresDAO vue_sessionheuresDAO = null;
    DefaultTableModel dft1 = new DefaultTableModel();
    
    public AffVue_SessionHeures() {
        initComponents();
        dft1.addColumn("idsesscours");
        dft1.addColumn("totalheures");
        
        tableVueTotalHeures.setModel(dft1);
    }

    public void setVue_sessionheuresDAO(Vue_SessionHeuresDAO vue_sessionheuresDAO) {
        this.vue_sessionheuresDAO = vue_sessionheuresDAO;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableVueTotalHeures = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbSesscours = new javax.swing.JLabel();
        txtIdsess = new javax.swing.JTextField();
        btChercher = new javax.swing.JButton();

        tableVueTotalHeures.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "idsesscours", "totalheures"
            }
        ));
        jScrollPane1.setViewportView(tableVueTotalHeures);

        jLabel1.setText("Total heures d'une session");

        lbSesscours.setText("ID Session cours");

        btChercher.setText("Chercher");
        btChercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChercherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSesscours)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIdsess, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(btChercher)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSesscours)
                    .addComponent(txtIdsess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btChercher))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btChercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChercherActionPerformed
         try {
            int idsesscours = Integer.parseInt(txtIdsess.getText());
            System.out.println("idsesscours");
            
            List<Vue_SessionHeures> vs = vue_sessionheuresDAO.SessionHeures(idsesscours);
            int nr = dft1.getRowCount();
            for (int i = nr - 1; i >= 0; i--) {
                dft1.removeRow(i);
            }
            for (Vue_SessionHeures vsh : vs) {

                Vector v = new Vector();
                v.add(vsh.getIdsesscours());
                v.add(vsh.getTotalHeures());
                
                dft1.addRow(v);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btChercherActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChercher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSesscours;
    private javax.swing.JTable tableVueTotalHeures;
    private javax.swing.JTextField txtIdsess;
    // End of variables declaration//GEN-END:variables
}
