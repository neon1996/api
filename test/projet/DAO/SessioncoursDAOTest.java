package projet.DAO;

import java.sql.Connection;
import myconnections.DBConnection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projet.metier.Sessioncours;

public class SessioncoursDAOTest {

    static Connection dbConnect;

    public SessioncoursDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.out.println("connection invalide");
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
     * Test of create method, of class SessioncoursDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Sessioncours obj = null;
        SessioncoursDAO instance = new SessioncoursDAO();
        Sessioncours expResult = null;
        Sessioncours result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class SessioncoursDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idsesscours = 0;
        SessioncoursDAO instance = new SessioncoursDAO();
        Sessioncours expResult = null;
        Sessioncours result = instance.read(idsesscours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SessioncoursDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Sessioncours obj = null;
        SessioncoursDAO instance = new SessioncoursDAO();
        Sessioncours expResult = null;
        Sessioncours result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SessioncoursDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Sessioncours obj = null;
        SessioncoursDAO instance = new SessioncoursDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
