
package design_patterns.observer;


public class Gestion {
    
    public static void main(String[] args) {
        
        Sessioncours sc1 = new Sessioncours(1,35,441,399);
        Sessioncours sc2 = new Sessioncours(2,25,451,400);
         
         Formateur f1= new Formateur(1,"MAT12","kherbache","walid","16","rue test","charleroi",7156,"4653312457");
         Formateur f2= new Formateur(2,"MAT14","ndzie","therese","69","rue therese","mons",7000,"5643146645");
         
         sc1.addObserver(f1);
         sc1.addObserver(f2);
         sc2.addObserver(f1);
    }
    
}
