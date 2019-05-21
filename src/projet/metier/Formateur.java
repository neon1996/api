
package projet.metier;

public class Formateur {
    
    /*Classe métier correspondant à la table formateur dans la BDD */
    
    protected int idform;
    protected String matricule;
    protected String nom;
    protected String prenom;
    protected String rue;
    protected String numero;
    protected String localite;
    protected int cp;
    protected String telephone;

    public Formateur() {
    }

    public Formateur(int idform, String matricule, String nom, String prenom,  String numero,String rue, String localite, int cp, String telephone) {
        this.idform = idform;
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.numero = numero; 
        this.rue = rue;
        this.localite = localite;
        this.cp = cp;
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Formateur{" + "idform=" + idform + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", numero=" + numero + ", localite=" + localite + ", cp=" + cp + ", telephone=" + telephone + '}';
    }
    
    public String toStringComboForm() {
        return "Formateur{" + "idform=" + idform + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
    
    

    public int getIdform() {
        return idform;
    }

    public void setIdform(int idform) {
        this.idform = idform;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
    
    
}
