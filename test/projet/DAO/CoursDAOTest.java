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
import projet.metier.Cours;

/**
 *
 * @author Florence
 */
public class CoursDAOTest {

    static Connection dbConnect;

    public CoursDAOTest() {
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
     * Test of create method, of class CoursDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");

        Cours obj = new Cours(0, "TestMatiere", 5);
        CoursDAO instance = new CoursDAO();

        instance.setConnection(dbConnect);

        Cours expResult = new Cours(0, "TestMatiere", 5);
        Cours result = instance.create(obj);

        assertEquals("Matieres différentes", expResult.getMatiere(), result.getMatiere());
        assertEquals("Heures différentes", expResult.getHeures(), result.getHeures());

        assertNotEquals("Identifiant non généré (cours)", expResult.getIdcours(), result.getIdcours());
        int idcours = result.getIdcours();

        obj = new Cours(0, "TestMatiere", 5);

        try {
            obj = instance.create(obj);
            fail("exception de doublon non générée");
            instance.delete(obj);

        } catch (SQLException e) {
        }

        instance.delete(result);
    }

    /**
     * Test of read method, of class CoursDAO.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idcours = 0;
        CoursDAO instance = new CoursDAO();
        instance.setConnection(dbConnect);
        Cours obj = new Cours(0, "TestMatiere", 10);
        Cours expResult = instance.create(obj);
        idcours = expResult.getIdcours();
        Cours result = instance.read(idcours);
        assertEquals("Matiere différentes", expResult.getMatiere(), result.getMatiere());
        assertEquals("Heures différentes", expResult.getHeures(), result.getHeures());

        assertEquals("id différents (cours)", expResult.getIdcours(), result.getIdcours());
        try {
            result = instance.read(0);
            fail("exception d'id inconnu non générée (cours)");
        } catch (SQLException e) {
        }
        instance.delete(result);
    }

    
     
    /**
     * Test of update method, of class CoursDAO.
     * @throws java.lang.Exception
     
     */
    
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");

        CoursDAO instance = new CoursDAO();
        Cours obj = new Cours(0, "TestMatiere", 10);
        instance.setConnection(dbConnect);

        obj = instance.create(obj);
      //  obj.setMatiere("TestUpdateMatiere");
        obj.setHeures(50);

        Cours expResult = obj;
        Cours result = instance.update(obj);
       // assertEquals(expResult.getMatiere(), result.getMatiere());
        assertEquals(expResult.getHeures(), result.getHeures());

        instance.delete(obj);
    }

    /**
     * Test of delete method, of class CoursDAO.
     * @throws java.lang.Exception
     */
     @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Cours obj = new Cours(0, "TestMatiere", 10);
        CoursDAO instance = new CoursDAO();
        instance.setConnection(dbConnect);
        obj = instance.create(obj);
        instance.delete(obj);
        try {
            instance.read(obj.getIdcours());
            fail("exception de record introuvable non générée (cours)");
        } catch (SQLException e) {
        }
    }
}
