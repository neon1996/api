
package design_patterns.observer;

import java.util.Objects;

public class Infos {
    protected int idinfos;
    protected Formateur monFormateur;
    protected Sessioncours maSessioncours;
    protected int nbrheure;
   
    public Infos() {
    }

    public Infos(int idinfos, Formateur monFormateur, Sessioncours maSessioncours, int nbrheure) {
        this.idinfos = idinfos;
        this.monFormateur = monFormateur;
        this.maSessioncours = maSessioncours;
        this.nbrheure = nbrheure;
    }

    public int getIdinfos() {
        return idinfos;
    }

    public void setIdinfos(int idinfos) {
        this.idinfos = idinfos;
    }

    public Formateur getMonFormateur() {
        return monFormateur;
    }

    public void setMonFormateur(Formateur monFormateur) {
        this.monFormateur = monFormateur;
    }

    public Sessioncours getMaSessioncours() {
        return maSessioncours;
    }

    public void setMaSessioncours(Sessioncours maSessioncours) {
        this.maSessioncours = maSessioncours;
    }

    public int getNbrheure() {
        return nbrheure;
    }

    public void setNbrheure(int nbrheure) {
        this.nbrheure = nbrheure;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.monFormateur);
        hash = 61 * hash + Objects.hashCode(this.maSessioncours);
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
        if (!Objects.equals(this.monFormateur, other.monFormateur)) {
            return false;
        }
        if (!Objects.equals(this.maSessioncours, other.maSessioncours)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Infos{" + "idinfos=" + idinfos + ", monFormateur=" + monFormateur + ", maSessioncours=" + maSessioncours + ", nbrheure=" + nbrheure + '}';
    }

    
    
}
