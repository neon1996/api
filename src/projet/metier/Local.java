
package projet.metier;

public class Local {
    
    /*Classe métier correspondant à la table local dans la BDD */
    
    protected int idlocal;
    protected String sigle;
    protected String places;
    protected String description;
    
    public Local(){
        
    }

    public Local(int idlocal, String sigle, String places, String description) {
        this.idlocal = idlocal;
        this.sigle = sigle;
        this.places = places;
        this.description = description;
    }
    

   public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Local{" + "idlocal=" + idlocal + ", sigle=" + sigle + ", places=" + places + ", description=" + description + '}';
    }
    
    
    
}
