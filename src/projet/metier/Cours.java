
package projet.metier;


public class Cours {
    
    /*Classe métier correspondant à la table cours dans la BDD */
    
    protected int idcours;
    protected String matiere; 
    protected int heures; 

    @Override
    public String toString() {
        return "Cours{" + "idcours=" + idcours + ", matiere=" + matiere + ", heures=" + heures + '}';
    }

    public Cours() {
    }

    public Cours(int idcours, String matiere, int heures) {
        this.idcours = idcours;
        this.matiere = matiere;
        this.heures = heures;
    }

    public int getIdcours() {
        return idcours;
    }

    public void setIdcours(int idcours) {
        this.idcours = idcours;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }
    
    
    
}
