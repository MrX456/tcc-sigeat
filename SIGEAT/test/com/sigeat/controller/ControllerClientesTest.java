/*
 * Classe de teste unitário dos métodos de controle de Clientes
 */
package com.sigeat.controller;

import com.sigeat.model.bean.Clientes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * SIGEAT/ Tests / Controller / Clientes
 * @author Junior
 * Version : 1.0.0
 */

public class ControllerClientesTest {

    public ControllerClientesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando testes de controle de Clientes\n");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("\nEncerrando testes de controle de Clientes");
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
     * Test of validate method, of class ControllerClientes.
     */
    @Test
    public void testValidate() {
        System.out.println("Teste validate");
        System.out.println("Criando instância de Clientes");
        Clientes cliente = new Clientes();
        cliente.setNome("Marcos Antônio");
        cliente.setEndereco("Rua Vila Bom Jesus III 700 - Belém  - Pará");
        cliente.setTelefone("3456-5578");

        ControllerClientes instance = new ControllerClientes();
        boolean expResult = true;
        boolean result = instance.validate(cliente);
        assertEquals(expResult, result);
        System.out.println("Passou");
    }

    @Test
    public void testValidateFailNome() {

        System.out.println("Teste ValidateFailNome()");
        System.out.println("Criando instância de Clientes");
        Clientes cliente = new Clientes();
        System.out.println("Nome em branco...");
        cliente.setNome("");
        cliente.setEndereco("Rua Vila Bom Jesus III 700 - Belém  - Pará");
        cliente.setTelefone("3456-5578");

        ControllerClientes instance = new ControllerClientes();
        boolean expResult = false;
        boolean result = instance.validate(cliente);
        assertEquals(expResult, result);
        System.out.println("Passou");

    }

    @Test
    public void testValidateFailEndereco() {

        System.out.println("Teste ValidateFailEndereco()");
        System.out.println("Criando instância de Clientes");
        Clientes cliente = new Clientes();
        System.out.println("Endereco em branco...");
        cliente.setNome("Marcos Antônio");
        cliente.setEndereco("");
        cliente.setTelefone("3456-5578");

        ControllerClientes instance = new ControllerClientes();
        boolean expResult = false;
        boolean result = instance.validate(cliente);
        assertEquals(expResult, result);
        System.out.println("Passou");

    }

    @Test
    public void testValidateFailTelefone() {

        System.out.println("Teste testValidateFailTelefone()");
        System.out.println("Criando instância de Clientes");
        Clientes cliente = new Clientes();
        System.out.println("Telefone em branco...");
        cliente.setNome("Marcos Antônio");
        cliente.setEndereco("Rua Vila Bom Jesus III 700 - Belém  - Pará");
        cliente.setTelefone("");

        ControllerClientes instance = new ControllerClientes();
        boolean expResult = false;
        boolean result = instance.validate(cliente);
        assertEquals(expResult, result);
        System.out.println("Passou");

    }

}
