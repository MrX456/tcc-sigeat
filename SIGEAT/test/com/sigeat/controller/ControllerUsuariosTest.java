/*
 * Classe de teste unitário dos métodos de controle de Usuarios
 */
package com.sigeat.controller;

import com.sigeat.model.bean.Usuarios;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/*
 * SIGEAT/ Tests / Controller / Usuarios
 * @author Junior
 * Version : 1.0.0
 */

public class ControllerUsuariosTest {
    
    public ControllerUsuariosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando testes de controle de Usuarios\n");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("\nEncerrando testes de controle de Usuarios");
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
     * Test of validate method, of class ControllerUsuarios.
     */
    @Test
    public void testValidate() {
        
        System.out.println("Teste validate");
        System.out.println("Criando instância de Usuarios");
        Usuarios usuario = new Usuarios();
        usuario.setNome("Marcos Antônio");
        usuario.setLogin("marcos123");
        usuario.setSenha("12345");
        usuario.setPerfil("usuario");
        
        ControllerUsuarios instance = new ControllerUsuarios();
        boolean expResult = true;
        boolean result = instance.validate(usuario);
        assertEquals(expResult, result);
        System.out.println("Passou");

    }
    
    @Test
    public void testValidateFailNome() {
        
        System.out.println("Teste ValidateFailNome()");
        System.out.println("Criando instância de Usuarios");
        Usuarios usuario = new Usuarios();
        System.out.println("Nome em branco...");
        usuario.setNome("");
        usuario.setLogin("marcos123");
        usuario.setSenha("12345");
        usuario.setPerfil("usuario");
        
        ControllerUsuarios instance = new ControllerUsuarios();
        boolean expResult = false;
        boolean result = instance.validate(usuario);
        assertEquals(expResult, result);
        System.out.println("Passou");
        
    }
    
    @Test
    public void testValidateFailLogin() {
        
        System.out.println("Teste ValidateFailLogin()");
        System.out.println("Criando instância de Usuarios");
        Usuarios usuario = new Usuarios();
        System.out.println("Login de tamanho 16...");
        usuario.setNome("Marcos Antônio");
        usuario.setLogin("marcos1234567890123456");
        usuario.setSenha("12345");
        usuario.setPerfil("usuario");
        
        ControllerUsuarios instance = new ControllerUsuarios();
        boolean expResult = false;
        boolean result = instance.validate(usuario);
        assertEquals(expResult, result);
        System.out.println("Passou");
        
    }
    
    @Test
    public void testValidateFailSenha() {
        
        System.out.println("Teste ValidateFailSenha()");
        System.out.println("Criando instância de Usuarios");
        Usuarios usuario = new Usuarios();
        System.out.println("Senha de tamanho 16...");
        usuario.setNome("Marcos Antônio");
        usuario.setLogin("marcos123");
        usuario.setSenha("1234567890123456");
        usuario.setPerfil("usuario");
        
        ControllerUsuarios instance = new ControllerUsuarios();
        boolean expResult = false;
        boolean result = instance.validate(usuario);
        assertEquals(expResult, result);
        System.out.println("Passou");
        
    }
}
