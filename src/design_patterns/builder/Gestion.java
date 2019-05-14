package design_patterns.builder;

public class Gestion {

    public static void main(String[] args) {

        // identifiant = 0 ==> le formateur ne va pas se créer car condition de construction, l'id doit être > 0 !
        try {
            Formateur f1 = new Formateur.FormateurBuilder(0, "Form", "Form", "Form").setLocalite("Mons").build();
            System.out.println(f1);

        } catch (Exception e) {
            System.out.println("erreur f1 : " + e);
        }

        try {
            Formateur f2 = new Formateur.FormateurBuilder(1, "Form", "Form", "Form").setLocalite("Mons").build();
            System.out.println(f2);

        } catch (Exception e) {
            System.out.println("erreur f2 :" + e);
        }

    }

}
