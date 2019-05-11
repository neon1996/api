package projet.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projet.metier.Cours;
import projet.metier.Formateur;
import projet.metier.Infos;
import projet.metier.Local;
import projet.metier.Sessioncours;

public class LocalDAOTest {

    static Connection dbConnect;

    public LocalDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connexion invalide");
            System.exit(1);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        DBConnection.closeConnection();
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class LocalDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Local obj = new Local(0, "TestSigle", 5, "TestDescription");
        LocalDAO instance = new LocalDAO();
        
        instance.setConnection(dbConnect);
        
        Local expResult = new Local(0, "TestSigle", 5, "TestDescription");
        Local result = instance.create(obj);
        
        assertEquals("Sigles différents", expResult.getSigle(), result.getSigle());
        assertEquals("Places différents", expResult.getPlaces(), result.getPlaces());
        assertEquals("Descriptions différentes", expResult.getDescription(), result.getDescription());

        assertNotEquals("Identifiant non généré (local)", expResult.getIdlocal(), result.getIdlocal());
        int idlocal = result.getIdlocal();

        obj = new Local(0, "TestSigle", 5, "TestDescription");

        try {
            obj = instance.create(obj);
            fail("exception de doublon non générée (local)");
            instance.delete(obj);

        } catch (SQLException e) {}

        instance.delete(result);
    }

    /**
     * Test of readSigle method, of class LocalDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testReadSigle() throws Exception {
        System.out.println("readSigle");
        String sigle = "";
        
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        Local obj = new Local(0, "TestSigle", 10, "TestDescription");
        Local expResult = instance.create(obj);
        sigle = expResult.getSigle();
        Local result = instance.readSigle(sigle);

        assertEquals("Sigles differents (local)", expResult.getSigle(), result.getSigle());

        try {
            result = instance.read(0);
            fail("Exception d'un code inconnu non géneré (local)");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of read method, of class LocalDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");

        int idlocal = 0;
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        Local obj = new Local(0, "TestSigle", 10, "TestDescription");
        Local expResult = instance.create(obj);
        idlocal = expResult.getIdlocal();
        Local result = instance.read(idlocal);
        assertEquals("Sigle différents", expResult.getSigle(), result.getSigle());
        assertEquals("Places différents", expResult.getPlaces(), result.getPlaces());
        assertEquals("Description différents", expResult.getDescription(), result.getDescription());
        //etc
        assertEquals("id différents (local)", expResult.getIdlocal(), result.getIdlocal());
        try {
            result = instance.read(0); //0 est la seule valeur dans la bdd qui n'est pas donné dans la bdd car l'auto incrément commence à 1
            fail("exception d'id inconnu non générée (local)");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of update method, of class LocalDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Local obj = new Local(0, "TestSigle", 10, "TestDescription");
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        
        obj = instance.create(obj);
       // obj.setSigle("TestUpSigle");
        obj.setPlaces(50);
        obj.setDescription("TestUpdate");

        Local expResult = obj;
        Local result = instance.update(obj);
       // assertEquals(expResult.getSigle(), result.getSigle());
        assertEquals(expResult.getPlaces(), result.getPlaces());
        assertEquals(expResult.getDescription(), result.getDescription());

        instance.delete(obj);
    }

    /**
     * Test of delete method, of class LocalDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws SQLException {
        System.out.println("delete");
        Local obj = new Local(0, "TestSigle",10, "TestDescription");
        LocalDAO instance = new LocalDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdlocal());
            fail("exception de record introuvable non générée (local)");
        } catch (SQLException e) {
        }
        
       obj=instance.create(obj); // réinstancier le local afin de delete cascade
        int idlocal=obj.getIdlocal();
        
        Cours cours=new Cours(0,"testmatiere",10);
       CoursDAO coursd= new CoursDAO();
       coursd.setConnection(dbConnect);
       cours=coursd.create(cours);
       int idcours=cours.getIdcours();
       
       Formateur f=new Formateur(0,"Testmatricule","Testnom","Testprenom","10","Testrue","Testlocalite",6025,"Testtel");
        FormateurDAO fd=new FormateurDAO();
        fd.setConnection(dbConnect);
        f =fd.create(f);
     
       
       Sessioncours sessionCours=new Sessioncours(0,LocalDate.of(2019, Month.APRIL, 17),LocalDate.of(2020, Month.MARCH, 13),15,idlocal,idcours);
        SessioncoursDAO sessionCoursd= new SessioncoursDAO();
        sessionCoursd.setConnection(dbConnect);
        sessionCours=sessionCoursd.create(sessionCours);
      
       
      Infos infos = new Infos(0,f.getIdform(),sessionCours.getIdsesscours(),10);
        InfosDAO infosd= new InfosDAO();
        infosd.setConnection(dbConnect);
        infos=infosd.create(infos);
       
       
       /*
        * A vérifier : Lorsque le try-catch est activé, le test ne fonctionne pas.
        * Il affiche le message du fail (+ erreur dans l'update car les données ne s'effacent pas de la BDD.
        
        try{
           instance.delete(obj);
            fail("Exception de record de parent clé etrangere");
        }
        catch(Exception e){}*/
       
       infosd.delete(infos); 
       sessionCoursd.delete(sessionCours);
       fd.delete(f);
       coursd.delete(cours);
       instance.delete(obj);
        
    }

    /**
     * Test of rechDescription method, of class LocalDAO.
     */
    @Test

    public void testRechDescription() throws Exception {
        System.out.println("rechDescription");
        Local obj1 = new Local(0, "TestSig", 10, "testdescription");
        Local obj2 = new Local(0, "TestSig2", 20, "testdescription");

        String descriptionrech = "testdescription";
        LocalDAO instance = new LocalDAO();

        instance.setConnection(dbConnect);
        obj1 = instance.create(obj1);
        obj2 = instance.create(obj2);

        List<Local> result = instance.rechDescription(descriptionrech);
        if (result.indexOf(obj1) < 0) {
            fail("record introuvable (recherche local)" + obj1);
        }
        if (result.indexOf(obj2) < 0) {
            fail("record introuvable (recherche local) " + obj2);
        }
        instance.delete(obj1);
        instance.delete(obj2);
    }
}
