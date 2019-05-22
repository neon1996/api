/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.graph;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import projet.DAO.FormateurDAO;
import projet.DAO.InfosDAO;
import projet.DAO.SessioncoursDAO;
import projet.metier.Infos;
import projet.metier.Sessioncours;
import projet.metier.Formateur;
import projet.metier.Local;

/**
 *
 * @author Florence
 */
public class CreateInfos extends javax.swing.JPanel {

    InfosDAO infosDAO = null;
    FormateurDAO formateurDAO = null;
    SessioncoursDAO sessioncoursDAO = null;

    List<Formateur> fo1;
    List<Sessioncours> sco1;

    DefaultComboBoxModel dlm = new DefaultComboBoxModel();

    DefaultComboBoxModel dlm1 = new DefaultComboBoxModel();

    public void comboFormateur() {
       
        try {
            fo1 = formateurDAO.aff_comboFormateur();
            if (comboIdform != null) {
                comboIdform.removeAllItems();
            }
            Iterator<Formateur> itform = fo1.iterator();
            while (itform.hasNext()) {
                Formateur fo = itform.next();
                dlm.addElement(fo.toStringComboForm());
            }
            
            comboIdform.setModel(dlm);

        } catch (SQLException e) {
            System.out.println("Exception" + e);
        }


    }

    public void comboSessioncours() {
     
     
     try {
            sco1 = sessioncoursDAO.aff_comboSessioncours();
            if (comboIdsesscours != null) {
                comboIdsesscours.removeAllItems();
            }
            Iterator<Sessioncours> itseccs = sco1.iterator();
            while (itseccs.hasNext()) {
                Sessioncours sco = itseccs.next();
                dlm1.addElement(sco.toStringComboSess());
            }
            
            comboIdsesscours.setModel(dlm1);

        } catch (SQLException e) {
            System.out.println("Exception" + e);
        }

    }

    public CreateInfos() {
        initComponents();
        
    }

    public void setInfosDAO(InfosDAO infosDAO) {
        this.infosDAO = infosDAO;
    }

    public void setFormateurDAO(FormateurDAO formateurDAO) {
        this.formateurDAO = formateurDAO;
    }
    
    public void setSessioncoursDAO(SessioncoursDAO sessioncoursDAO) {
        this.sessioncoursDAO = sessioncoursDAO;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lbIdinfos = new javax.swing.JLabel();
        lbIdform = new javax.swing.JLabel();
        lbIdsesscours = new javax.swing.JLabel();
        lbNbrheure = new javax.swing.JLabel();
        butCreateInfos = new javax.swing.JButton();
        comboIdform = new javax.swing.JComboBox<>();
        comboIdsesscours = new javax.swing.JComboBox<>();
        txtIdinfos = new javax.swing.JTextField();
        txtNbrheure = new javax.swing.JTextField();

        jLabel1.setText("Lier formateur et sessions cours :");

        lbIdinfos.setText("ID Infos");

        lbIdform.setText("ID Formateur");

        lbIdsesscours.setText("ID Session cours");

        lbNbrheure.setText("Nbr heure");

        butCreateInfos.setText("Créer");
        butCreateInfos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCreateInfosActionPerformed(evt);
            }
        });

        comboIdform.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboIdsesscours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtIdinfos.setEditable(false);

        txtNbrheure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNbrheureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNbrheure, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(butCreateInfos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNbrheure, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbIdsesscours)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboIdsesscours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbIdform)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboIdform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbIdinfos)
                        .addGap(136, 136, 136)
                        .addComponent(txtIdinfos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIdinfos)
                            .addComponent(txtIdinfos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIdform)
                            .addComponent(comboIdform, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbIdsesscours)
                            .addComponent(comboIdsesscours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(lbNbrheure))
                    .addComponent(txtNbrheure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(butCreateInfos)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butCreateInfosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCreateInfosActionPerformed
        try {

            int pos = comboIdform.getSelectedIndex();
            Formateur fo = fo1.get(pos);
            System.out.println(fo.getIdform());

            int pos1 = comboIdsesscours.getSelectedIndex();
            Sessioncours sco = sco1.get(pos1);
            System.out.println(sco.getIdsesscours());

            int nbrheure = Integer.parseInt(txtNbrheure.getText());

            Infos inf = new Infos(0, fo.getIdform(), sco.getIdsesscours(), nbrheure);

            inf = infosDAO.create(inf);
            txtIdinfos.setText("" + inf.getIdinfos());

            JOptionPane.showMessageDialog(this, "Données infos créée", "succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_butCreateInfosActionPerformed

    private void txtNbrheureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNbrheureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNbrheureActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCreateInfos;
    private javax.swing.JComboBox<String> comboIdform;
    private javax.swing.JComboBox<String> comboIdsesscours;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbIdform;
    private javax.swing.JLabel lbIdinfos;
    private javax.swing.JLabel lbIdsesscours;
    private javax.swing.JLabel lbNbrheure;
    private javax.swing.JTextField txtIdinfos;
    private javax.swing.JTextField txtNbrheure;
    // End of variables declaration//GEN-END:variables
}
