package projet.metier;


import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;

public class Sessioncours {

    protected int idsesscours;
    protected LocalDate dateDebut;
    protected LocalDate dateFin;
    protected int nbreinscrits;
    protected int idlocal;
    protected int idcours;
    
   

    public Sessioncours() {
    }

    public Sessioncours(int idsesscours, LocalDate dateDebut, LocalDate dateFin, int nbreinscrits, int idlocal, int idcours) {
        this.idsesscours = idsesscours;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbreinscrits = nbreinscrits;
        this.idlocal = idlocal;
        this.idcours = idcours;
    }

   
    public int getIdsesscours() {
        return idsesscours;
    }

    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
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

    public int getNbreinscrits() {
        return nbreinscrits;
    }

    public void setNbreinscrits(int nbreinscrits) {
        this.nbreinscrits = nbreinscrits;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    @Override
    public String toString() {
        return "Sessioncours{" + "idsesscours=" + idsesscours + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", nbreinscrits=" + nbreinscrits + ", idlocal=" + idlocal + ", idcours=" + idcours + '}';
    }

   public String toStringComboSess() {
        return "Sessioncours{" + "idsesscours=" + idsesscours + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin +'}';
    }


    
    
    
}
