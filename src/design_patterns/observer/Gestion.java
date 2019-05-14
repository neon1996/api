
package design_patterns.observer;


public class Gestion {
    
    public static void main(String[] args) {
        
        Local l1 = new Local(1,"LOC1",25,"Description local1");
        Local l2 = new Local (2,"LOC2",30,"Description local2");
         
        Formateur f1= new Formateur(1,"Form1","Form1","Form1","16","rue form1","fr1",7156,"4652457");
        Formateur f2= new Formateur(2,"Form2","Form2","Form2","69","rue form2","fr2",7000,"5643145");
         
         l1.addObserver(f1);
         l1.addObserver(f2);
         l2.addObserver(f1);
         
         l1.setSigle("LOC1");
         l2.setSigle("LOC2");
    }
    
}
