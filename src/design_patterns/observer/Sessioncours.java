
package design_patterns.observer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Sessioncours {

    protected int idsesscours;
    protected java.util.Date dateDebut;
    protected java.util.Date dateFin;
    protected int nbreinscrits;
    protected int idlocal;
    protected int idcours;
    
    protected Set<Local> monLocal = new HashSet<>();
    protected Set<Formateur> monFormateur = new HashSet<>();
    
  
    
     public Sessioncours() {
    }

    public Sessioncours(int idsesscours, java.util.Date dateDebut, java.util.Date dateFin, int nbreinscrits, int idlocal, int idcours) {
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

    public java.util.Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(java.util.Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public java.util.Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(java.util.Date dateFin) {
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

    public Set<Local> getMonLocal() {
        return monLocal;
    }

    public void setMonLocal(Set<Local> monLocal) {
        this.monLocal = monLocal;
    }

    public Set<Formateur> getMonFormateur() {
        return monFormateur;
    }

    public void setMonFormateur(Set<Formateur> monFormateur) {
        this.monFormateur = monFormateur;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.idsesscours;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sessioncours other = (Sessioncours) obj;
        if (this.idsesscours != other.idsesscours) {
            return false;
        }
        return true;
    }

   
    
    
}
