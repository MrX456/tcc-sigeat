/*
 * Classe de teste unitário de conexão
 */
package com.sigeat.connection;

import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * SIGEAT/ Tests / ConnectionFactory
 * @author Junior
 * Version : 1.0.0
 */

public class ConnectionFactoryTest {
    
    public ConnectionFactoryTest() {
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
     * Test of getConnection method, of class ConnectionFactory.
     */
    @Test
    public void testGetConnection() {
        System.out.println("Teste getConnection");
        EntityManager expResult = null;
        System.out.println("Criando objeto de conexao...");
        EntityManager result = ConnectionFactory.getConnection();
        assertNotSame(expResult, result);
        System.out.println("Passou");
    }
    
}
