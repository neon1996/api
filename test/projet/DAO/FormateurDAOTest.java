/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.DAO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import projet.metier.Formateur;

/**
 *
 * @author Florence
 */
public class FormateurDAOTest {
    
    public FormateurDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
        Formateur obj = null;
        FormateurDAO instance = new FormateurDAO();
        Formateur expResult = null;
        Formateur result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class FormateurDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idform = 0;
        FormateurDAO instance = new FormateurDAO();
        Formateur expResult = null;
        Formateur result = instance.read(idform);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readMatricule method, of class FormateurDAO.
     */
    @Test
    public void testReadMatricule() throws Exception {
        System.out.println("readMatricule");
        String matricule = "";
        FormateurDAO instance = new FormateurDAO();
        Formateur expResult = null;
        Formateur result = instance.readMatricule(matricule);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class FormateurDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Formateur obj = null;
        FormateurDAO instance = new FormateurDAO();
        Formateur expResult = null;
        Formateur result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class FormateurDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Formateur obj = null;
        FormateurDAO instance = new FormateurDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
