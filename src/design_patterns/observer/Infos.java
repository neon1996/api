
package design_patterns.observer;

import java.util.Objects;

public class Infos {
    protected int idinfos;
    protected int idform;
    protected Sessioncours maSessioncours;
    protected int nbrheure;
   
    public Infos() {
    }

    public Infos(int idinfos, int idform, Sessioncours maSessioncours, int nbrheure) {
        this.idinfos = idinfos;
        this.idform = idform;
        this.maSessioncours = maSessioncours;
        this.nbrheure = nbrheure;
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
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.maSessioncours);
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
        if (!Objects.equals(this.maSessioncours, other.maSessioncours)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Infos{" + "idinfos=" + idinfos + ", idform=" + idform + ", maSessioncours=" + maSessioncours + ", nbrheure=" + nbrheure + '}';
    }

    
    
}
