
package design_patterns.observer;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Sessioncours extends Subject{

    protected int idsesscours;
  /*  protected java.util.Date dateDebut;
    protected java.util.Date dateFin;*/
    protected int nbreinscrits;
    protected int idlocal;
    protected int idcours;
    
    protected Set<Infos> mesInfosSess = new HashSet<>();
    
    public Set<Infos> getMesInfosSess(){
        return mesInfosSess;
    }
    
     public Sessioncours() {
    }

    public Sessioncours(int idsesscours, int nbreinscrits, int idlocal, int idcours) {
        this.idsesscours = idsesscours;
      /*  this.dateDebut = dateDebut;
        this.dateFin = dateFin;*/
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
/*
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
*/
   

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
        return "Sessioncours{" + "idsesscours=" + idsesscours + ", nbreinscrits=" + nbreinscrits + ", idlocal=" + idlocal + ", idcours=" + idcours + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idsesscours;
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
    
    
    
    @Override
    public String getNotification() {
        return "Nouveau local : "+idlocal; 
    }
    
}
