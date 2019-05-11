
package design_patterns.observer;

import java.util.Objects;

public class Infos {
    protected int idinfos;
    protected int idform;
    protected int idsesscours;
    protected int nbrheure;
    
    protected Formateur formateur;
    protected Sessioncours sessioncours;

    public Infos() {
    }

    public Infos(int idinfos, int idform, int idsesscours, int nbrheure,Formateur formateur, Sessioncours sessioncours) {
        this.idinfos = idinfos;
        this.idform = idform;
        this.idsesscours = idsesscours;
        this.nbrheure = nbrheure;
        this.formateur = formateur;
        this.sessioncours = sessioncours;
    }

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public Sessioncours getSessioncours() {
        return sessioncours;
    }

    public void setSessioncours(Sessioncours sessioncours) {
        this.sessioncours = sessioncours;
    }


    public int getIdinfos() {
        return idinfos;
    }

    public void setIdinfos(int idinfos) {
        this.idinfos = idinfos;
    }

    public int getIdform() {
        return idform;
    }

    public void setIdform(int idform) {
        this.idform = idform;
    }

    public int getIdsesscours() {
        return idsesscours;
    }

    public void setIdsesscours(int idsesscours) {
        this.idsesscours = idsesscours;
    }

    public int getNbrheure() {
        return nbrheure;
    }

    public void setNbrheure(int nbrheure) {
        this.nbrheure = nbrheure;
    }

    @Override
    public String toString() {
        return "Infos{" + "idinfos=" + idinfos + ", idform=" + idform + ", idsesscours=" + idsesscours + ", nbrheure=" + nbrheure + ", formateur=" + formateur + ", sessioncours=" + sessioncours + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.formateur);
        hash = 17 * hash + Objects.hashCode(this.sessioncours);
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
        final Infos other = (Infos) obj;
        if (!Objects.equals(this.formateur, other.formateur)) {
            return false;
        }
        if (!Objects.equals(this.sessioncours, other.sessioncours)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
