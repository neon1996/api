package projet.graph;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import projet.DAO.CoursDAO;

import projet.DAO.SessioncoursDAO;
import projet.DAO.LocalDAO;
import projet.metier.Local;
import projet.metier.Cours;
import projet.metier.Sessioncours;

public class CreateSessioncours extends javax.swing.JPanel {

    SessioncoursDAO sessioncoursDAO = null;

    LocalDAO localDAO = null;
    CoursDAO coursDAO = null;
    List<Local> loc1;

    List<Cours> co1;

    DefaultComboBoxModel dlm = new DefaultComboBoxModel();
    
    DefaultComboBoxModel dlm1 = new DefaultComboBoxModel();

    public CreateSessioncours() {
        initComponents();
        comboLocal();
        comboCours();
    }

    public void comboLocal() {
        try {
            loc1 = (List<Local>) localDAO.aff_comboLocal();

           // System.out.println(loc1); // affic controle output
            for (int i = 0; i < loc1.size(); i++) {
                dlm.addElement(loc1.get(i).getIdlocal());

            }
            comboIdlocal.setModel(dlm); // modifie le model du combo box afin d'afficher la liste

        } catch (Exception e) {
            System.out.println("Exception" + e);
        }

    }
    
     public void comboCours(){
         try {
            co1 = (List<Cours>) coursDAO.aff_comboCours();

            // System.out.println(co1); // affic controle output
            for (int i = 0; i < co1.size(); i++) {
                dlm1.addElement(co1.get(i).getIdcours());

            }
            comboIdcours.setModel(dlm1); // modifie le model du combo box afin d'afficher la liste

        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
            
        }

    public void setSessioncoursDAO(SessioncoursDAO sessioncoursDAO) {
        this.sessioncoursDAO = sessioncoursDAO;
    }

    public void setLocalDAO(LocalDAO localDAO) {
        this.localDAO = localDAO;
    }

    public void setCoursDAO(CoursDAO coursDAO) {
        this.coursDAO = coursDAO;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1 = new javax.swing.JLabel();
        lbDatedebut = new javax.swing.JLabel();
        lbDatefin = new javax.swing.JLabel();
        lbNbreinscrits = new javax.swing.JLabel();
        lbIdlocal = new javax.swing.JLabel();
        lbIdcours = new javax.swing.JLabel();
        lbIdform = new javax.swing.JLabel();
        butCreationSessioncours = new javax.swing.JButton();
        txtNbreinscrits = new javax.swing.JTextField();
        txtIdsesscours = new javax.swing.JTextField();
        txtDatedebut = new com.toedter.calendar.JDateChooser();
        txtDatefin = new com.toedter.calendar.JDateChooser();
        comboIdlocal = new javax.swing.JComboBox<>();
        comboIdcours = new javax.swing.JComboBox<>();

        lb1.setText("Création d'une session de cours :");

        lbDatedebut.setText("Date Debut");

        lbDatefin.setText("Date Fin");

        lbNbreinscrits.setText("Nbr Etudiant ");

        lbIdlocal.setText("ID Local");

        lbIdcours.setText("ID Cours");

        lbIdform.setText("ID Session Cours");

        butCreationSessioncours.setText("Création");
        butCreationSessioncours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCreationSessioncoursActionPerformed(evt);
            }
        });

        txtIdsesscours.setEditable(false);

        txtDatedebut.setDateFormatString("dd-MM-yyyy");

        txtDatefin.setDateFormatString("dd-MM-yyyy");

        comboIdlocal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboIdcours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtDatefin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbIdform)
                                        .addComponent(lbDatedebut, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(28, 28, 28)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtDatedebut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtIdsesscours, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbDatefin)
                                    .addComponent(lbNbreinscrits)
                                    .addComponent(lbIdlocal)
                                    .addComponent(lbIdcours))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(butCreationSessioncours)
                                    .addComponent(txtNbreinscrits, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboIdlocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb1)))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdform)
                    .addComponent(txtIdsesscours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDatedebut)
                    .addComponent(txtDatedebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbDatefin)
                    .addComponent(txtDatefin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNbreinscrits)
                    .addComponent(txtNbreinscrits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdlocal)
                    .addComponent(comboIdlocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdcours)
                    .addComponent(comboIdcours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(butCreationSessioncours)
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void butCreationSessioncoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCreationSessioncoursActionPerformed

        try {
            String datedeb = ((JTextField) txtDatedebut.getDateEditor().getUiComponent()).getText();
            int jourd = Integer.parseInt(datedeb.substring(0, 2)); //substring permet de délimiter les nombres que l'on prend de la chaine de caract
            int moisd = Integer.parseInt(datedeb.substring(4, 5));
            int and = Integer.parseInt(datedeb.substring(6));

            LocalDate datedebut = LocalDate.of(and, moisd, jourd);

            String datef = ((JTextField) txtDatefin.getDateEditor().getUiComponent()).getText();
            int jourf = Integer.parseInt(datef.substring(0, 2)); //substring permet de délimiter les nombres que l'on prend de la chaine de caract
            int moisf = Integer.parseInt(datef.substring(4, 5));
            int anf = Integer.parseInt(datef.substring(6));

            LocalDate datefin = LocalDate.of(anf, moisf, jourf);

            int nbreinscrits = Integer.parseInt(txtNbreinscrits.getText());
            
            //int idlocal = Integer.parseInt(txtIdlocal.getText());

            int pos = comboIdlocal.getSelectedIndex();
            Local loc = loc1.get(pos);
            System.out.println(loc.getIdlocal());

            //int idcours = Integer.parseInt(txtIdcours.getText());
            int pos1 = comboIdcours.getSelectedIndex();
            Cours co = co1.get(pos1);
            System.out.println(co.getIdcours());

            Sessioncours ssc = new Sessioncours(0, datedebut, datefin, nbreinscrits, loc.getIdlocal(), co.getIdcours());

            ssc = sessioncoursDAO.create(ssc);
            txtIdsesscours.setText("" + ssc.getIdsesscours());

            JOptionPane.showMessageDialog(this, "Session de cours créée", "succès", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "ERREUR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_butCreationSessioncoursActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCreationSessioncours;
    private javax.swing.JComboBox<String> comboIdcours;
    private javax.swing.JComboBox<String> comboIdlocal;
    private javax.swing.JLabel lb1;
    private javax.swing.JLabel lbDatedebut;
    private javax.swing.JLabel lbDatefin;
    private javax.swing.JLabel lbIdcours;
    private javax.swing.JLabel lbIdform;
    private javax.swing.JLabel lbIdlocal;
    private javax.swing.JLabel lbNbreinscrits;
    private com.toedter.calendar.JDateChooser txtDatedebut;
    private com.toedter.calendar.JDateChooser txtDatefin;
    private javax.swing.JTextField txtIdsesscours;
    private javax.swing.JTextField txtNbreinscrits;
    // End of variables declaration//GEN-END:variables
}
