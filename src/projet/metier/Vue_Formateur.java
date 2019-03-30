package projet.metier;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Vue_Formateur {
    
    /**
     * Classe métier correspond à la vue "SESS_FORMATEUR" dans la BDD.
     */
    protected int idform;
    protected String nom; //formateur
    protected String prenom; //formateur
    protected String matiere; //donné par le formateur
    protected int sesscours;
    protected LocalDate dateDebut;
    protected LocalDate dateFin;

    public Vue_Formateur() {
    }

    public Vue_Formateur(int idform, String nom, String prenom, String matiere, int sesscours, LocalDate dateDebut, LocalDate dateFin) {
        this.idform = idform;
        this.nom = nom;
        this.prenom = prenom;
        this.matiere = matiere;
        this.sesscours = sesscours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getIdform() {
        return idform;
    }

    public void setIdform(int idform) {
        this.idform = idform;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getSesscours() {
        return sesscours;
    }

    public void setSesscours(int sesscours) {
        this.sesscours = sesscours;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "\nVue_FormateurDAO{" + "idform=" + idform + ", nom=" + nom + ", prenom=" + prenom + ", matiere=" + matiere + ", sesscours=" + sesscours + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }
    
    
       
    
}
