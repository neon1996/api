/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static projet.DAO.LocalDAOTest.dbConnect;
import projet.metier.Formateur;

/**
 *
 * @author Florence
 */
public class FormateurDAOTest {

    static Connection dbConnect;

    public FormateurDAOTest() {
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
     * Test of create method, of class FormateurDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Formateur obj = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite", 7000, "TestTel");
        FormateurDAO instance = new FormateurDAO();

        instance.setConnection(dbConnect);

        Formateur expResult = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite", 7000, "TestTel");
        Formateur result = instance.create(obj);

        assertEquals("Matricules différents", expResult.getMatricule(), result.getMatricule());
        assertEquals("Nom différents", expResult.getNom(), result.getNom());
        assertEquals("Prenom différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("Numero différents", expResult.getNumero(), result.getNumero());
        assertEquals("Rue différentes", expResult.getRue(), result.getRue());
        assertEquals("Localite différentes", expResult.getLocalite(), result.getLocalite());
        assertEquals("CP différents", expResult.getCp(), result.getCp());
        assertEquals("Tel différentes", expResult.getTelephone(), result.getTelephone());

        assertNotEquals("Identifiant non généré", expResult.getIdform(), result.getIdform());
        int idform = result.getIdform();

        obj = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero2", "TestRue2", "TestLocalite2", 5000, "TestTel");

        try {
            obj = instance.create(obj);
            fail("exception de doublon non générée");
            instance.delete(obj);

        } catch (SQLException e) {
        }

        obj = new Formateur(0, "TestMatricule2", "TestNom2", "TestPrenom2", "TestNumero2", "TestRue2", "TestLocalite2", 489, "TestTel2");

        try {
            obj = instance.create(obj);
            fail("exception de code postal non générée");
            instance.delete(obj);

        } catch (Exception e) {
        }

        instance.delete(result);
    }

    /**
     * Test of read method, of class FormateurDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idform = 0;
        FormateurDAO instance = new FormateurDAO();
        instance.setConnection(dbConnect);
        Formateur obj = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite", 7000, "TestTel");
        Formateur expResult = instance.create(obj);
        idform = expResult.getIdform();
        Formateur result = instance.read(idform);

        assertEquals("Matricules différents", expResult.getMatricule(), result.getMatricule());
        assertEquals("Nom différents", expResult.getNom(), result.getNom());
        assertEquals("Prenom différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("Numero différents", expResult.getNumero(), result.getNumero());
        assertEquals("Rue différentes", expResult.getRue(), result.getRue());
        assertEquals("Localite différentes", expResult.getLocalite(), result.getLocalite());
        assertEquals("CP différents", expResult.getCp(), result.getCp());
        assertEquals("Tel différentes", expResult.getTelephone(), result.getTelephone());

        assertEquals("id différents", expResult.getIdform(), result.getIdform());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    /**
     * Test of readMatricule method, of class FormateurDAO.
     * @throws java.lang.Exception
     */
     @Test
    public void testReadMatricule() throws Exception {
        System.out.println("readMatricule");
        String matricule = "";
        
         FormateurDAO instance = new FormateurDAO();
        instance.setConnection(dbConnect);
        Formateur obj = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite", 7000, "TestTel");
        Formateur expResult = instance.create(obj);
        matricule = expResult.getMatricule();
        Formateur result = instance.readMatricule(matricule);

        assertEquals("Matricules differents", expResult.getMatricule(), result.getMatricule());

        try {
            result = instance.read(0);
            fail("Exception d'un code inconnu non géneré");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }
     
    /**
     * Test of update method, of class FormateurDAO.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");

        FormateurDAO instance = new FormateurDAO();
        Formateur obj = new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite", 7000, "TestTel");
        instance.setConnection(dbConnect);

        obj = instance.create(obj);
      // obj.setMatricule("TestUpdateMatricule"); Matricule doit être unique = si je lupdate = new formateur != du formateur instancier au début du test update
        obj.setNom("TestUpdateNom");
        obj.setPrenom("TestUpdatePrenom");

        obj.setNumero("TestUpdateNum");
        obj.setRue("TestUpdateRue");
        obj.setLocalite("TestUpdateLoc");
        obj.setCp(1111);
        obj.setTelephone("TestUpdateTel");

        Formateur expResult = obj;
        Formateur result = instance.update(obj);
     //   assertEquals("Matricules différents", expResult.getMatricule(), result.getMatricule());
        assertEquals("Nom différents", expResult.getNom(), result.getNom());
        assertEquals("Prenom différents", expResult.getPrenom(), result.getPrenom());
        assertEquals("Numero différents", expResult.getNumero(), result.getNumero());
        assertEquals("Rue différentes", expResult.getRue(), result.getRue());
        assertEquals("Localite différentes", expResult.getLocalite(), result.getLocalite());
        assertEquals("CP différents", expResult.getCp(), result.getCp());
        assertEquals("Tel différentes", expResult.getTelephone(), result.getTelephone());

        instance.delete(obj);
    }

    /**
     * Test of delete method, of class FormateurDAO.
     * @throws java.lang.Exception
     */
     @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
     Formateur obj =  new Formateur(0, "TestMatricule", "TestNom", "TestPrenom", "TestNumero", "TestRue", "TestLocalite", 7000, "TestTel");
        FormateurDAO instance = new FormateurDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdform());
            fail("exception de record introuvable non générée");
        } catch (SQLException e) {
        }
    }
}
