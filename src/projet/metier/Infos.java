package projet.metier;

public class Infos {

    protected int idinfos;
    protected int idform;
    protected int idsesscours;
    protected int nbrheure;

    public Infos() {
    }

    public Infos(int idinfos, int idform, int idsesscours, int nbrheure) {
        this.idinfos = idinfos;
        this.idform = idform;
        this.idsesscours = idsesscours;
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
        return "Infos{" + "idinfos=" + idinfos + ", idform=" + idform + ", idsesscours=" + idsesscours + ", nbrheure=" + nbrheure + '}';
    }
    
    
    

}
