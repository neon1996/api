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
import projet.metier.Cours;

/**
 *
 * @author Florence
 */
public class CoursDAOTest {
    
    public CoursDAOTest() {
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
     * Test of create method, of class CoursDAO.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Cours obj = null;
        CoursDAO instance = new CoursDAO();
        Cours expResult = null;
        Cours result = instance.create(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class CoursDAO.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        int idcours = 0;
        CoursDAO instance = new CoursDAO();
        Cours expResult = null;
        Cours result = instance.read(idcours);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readMatiere method, of class CoursDAO.
     */
    @Test
    public void testReadMatiere() throws Exception {
        System.out.println("readMatiere");
        String matiere = "";
        CoursDAO instance = new CoursDAO();
        Cours expResult = null;
        Cours result = instance.readMatiere(matiere);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CoursDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Cours obj = null;
        CoursDAO instance = new CoursDAO();
        Cours expResult = null;
        Cours result = instance.update(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CoursDAO.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Cours obj = null;
        CoursDAO instance = new CoursDAO();
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
