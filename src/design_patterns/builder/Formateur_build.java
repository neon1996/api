package design_patterns.builder;

import java.util.HashSet;
import java.util.Set;
import projet.metier.Infos;

public class Formateur_build {

    /**
     * identifiant unique du formateur
     */
    protected int idform;

    /**
     * matricule unique du formateur
     */
    protected String matricule;

    /**
     * nom du formateur
     */
    protected String nom;

    /**
     * nom du formateur
     */
    protected String prenom;

    /**
     * numéro d'habitation du formateur
     */
    protected String numero;

    /**
     * adresse du formateur
     */
    protected String rue;

    /**
     * ville du formateur
     */
    protected String localite;

    /**
     * code postale de la ville du formateur
     */
    protected int cp;

    /**
     * numéro de téléphone du formateur
     */
    protected String tel;


    /**
     * @param idform identifiant unique du formateur, affecté par la base de données
     * @param nom nom du formateur
     * @param prenom prenom du formateur
     * @param numero numero d'habitation du formateur
     * @param rue rue du formateur
     * @param localite ville du formateur
     * @param cp code postal de la ville du formateur
     * @param tel telephone du formateur
     * 
     * @param fb 
     */
    
    
    private Formateur_build(FormateurBuilder fb) {

        this.idform = fb.idform;
        this.nom = fb.nom;
        this.prenom = fb.prenom;
        this.numero = fb.numero;
        this.rue = fb.rue;
        this.localite = fb.localite;
        this.cp = fb.cp;
        this.tel = fb.tel;

    }

    public int getIdform() {
        return idform;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getLocalite() {
        return localite;
    }

    public int getCp() {
        return cp;
    }

    public String getTel() {
        return tel;
    }


    @Override
    public String toString() {
        return "Formateur{" + "idform=" + idform + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + ", rue=" + rue + ", localite=" + localite + ", cp=" + cp + ", tel=" + tel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.idform;
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
        final Formateur_build other = (Formateur_build) obj;
        if (this.idform != other.idform) {
            return false;
        }
        return true;
    }
    
    

    public static class FormateurBuilder {

        /**
         * identifiant unique du formateur
         */
        protected int idform;

        /**
         * matricule unique du formateur
         */
        protected String matricule;

        /**
         * nom du formateur
         */
        protected String nom;

        /**
         * nom du formateur
         */
        protected String prenom;

        /**
         * numéro d'habitation du formateur
         */
        protected String numero;

        /**
         * adresse du formateur
         */
        protected String rue;

        /**
         * ville du formateur
         */
        protected String localite;

        /**
         * code postale de la ville du formateur
         */
        protected int cp;

        /**
         * numéro de téléphone du formateur
         */
        protected String tel;

        public FormateurBuilder(int idform, String matricule, String nom, String prenom) throws Exception {

            if (idform <= 0 || matricule == null || nom == null || prenom == null) {
                throw new Exception("Informations incomplètes");
            }
        }

        public FormateurBuilder setIdform(int idform) {
            this.idform = idform;
            return this;
        }

        public FormateurBuilder setMatricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public FormateurBuilder setPrenom(String prenom) {
            this.prenom = prenom;
            return this;
        }

        
        public Formateur_build build() throws Exception {
            return new Formateur_build(this);
        }

    }

}
