/*
 * Classe de teste unitário dos métodos de controle de OS
 */
package com.sigeat.controller;

import com.sigeat.model.bean.Clientes;
import com.sigeat.model.bean.OS;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * SIGEAT/ Tests / Controller / OS
 * @author Junior
 * Version : 1.0.0
 */
public class ControllerOSTest {
    
    public ControllerOSTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando testes de controle de OS\n");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("\nEncerrando testes de controle de OS");
    }
    
    @Before
    public void setUp() {
        System.out.println("Proximo teste\n");
    }
    
    @After
    public void tearDown() {
        System.out.println("Encerrando teste\n");
    }

    /**
     * Test of validate method, of class ControllerOS.
     */
    @Test
    public void testValidate() {
        System.out.println("Teste validate");
        System.out.println("Criando instância de OS");
        OS os = new OS();
        os.setEquipamento("Notebook Asus X44C");
        os.setDefeito("Teclado não funciona.");
        System.out.println("Criando instância de Cliente");
        Clientes c = new Clientes();
        c.setId(1);
        os.setCliente(c);

        ControllerOS instance = new ControllerOS();
        boolean expResult = true;
        boolean result = instance.validate(os);
        assertEquals(expResult, result);
        System.out.println("Passou");
    }
    
    @Test
    public void testValidateNullEquipamento() {
        System.out.println("Teste testValidateNullEquipamento()");
        System.out.println("Criando instância de OS(Campo equipamento nulo)");
        OS os = new OS();
        os.setEquipamento("");
        os.setDefeito("Teclado não funciona.");
        System.out.println("Criando instância de Cliente");
        Clientes c = new Clientes();
        c.setId(1);
        os.setCliente(c);

        ControllerOS instance = new ControllerOS();
        boolean expResult = false;
        boolean result = instance.validate(os);
        assertEquals(expResult, result);
        System.out.println("Passou");
    }
    
    @Test
    public void testValidateNullDefeito() {
        System.out.println("Teste testValidateNullDefeito()");
        System.out.println("Criando instância de OS(Campo equipamento nulo)");
        OS os = new OS();
        os.setEquipamento("Notebook Asus X44C");
        os.setDefeito("");
        System.out.println("Criando instância de Cliente");
        Clientes c = new Clientes();
        c.setId(2);
        os.setCliente(c);

        ControllerOS instance = new ControllerOS();
        boolean expResult = false;
        boolean result = instance.validate(os);
        assertEquals(expResult, result);
        System.out.println("Passou");
    }
    
}
