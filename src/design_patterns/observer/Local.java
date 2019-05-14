
package design_patterns.observer;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Local extends Subject {
    
    protected int idlocal;
    protected String sigle;
    protected int places;
    protected String description;
    
    protected Set <Sessioncours> maSession = new HashSet<>();

    public Local() {
    }

    public Local(int idlocal, String sigle, int places, String description) {
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
        notifyObservers(); // permet de notifier le formateur lors du changement de local 
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Sessioncours> getMaSession() {
        return maSession;
    }

    @Override
    public String toString() {
        return "Local{" + "idlocal=" + idlocal + ", sigle=" + sigle + ", places=" + places + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.sigle);
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
        final Local other = (Local) obj;
        if (!Objects.equals(this.sigle, other.sigle)) {
            return false;
        }
        return true;
    }

    
    

   
    
    
    
    @Override
    public String getNotification() {
        return "Nouveau local : "+ idlocal + " = " +sigle; 
    }
    
    
}
