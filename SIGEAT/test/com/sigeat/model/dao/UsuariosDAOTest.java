/*
 * Classe de teste unitário de CRUD de Usuarios
 */
package com.sigeat.model.dao;

import com.sigeat.connection.ConnectionFactory;
import com.sigeat.controller.ControllerUsuarios;
import com.sigeat.model.bean.Usuarios;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * SIGEAT/ Tests / Model / DAO / Usuarios
 * @author Junior
 * Version : 1.0.0
 */

public class UsuariosDAOTest {

    private static EntityManager em;

    public UsuariosDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando testes da entidade Usuarios");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Encerrando testes da entidade Usuarios");
    }

    @Before
    public void setUp() {
        System.out.println("Conectando ao banco de dados...");
        em = new ConnectionFactory().getConnection();
    }

    @After
    public void tearDown() {
        System.out.println("Encerrando conexão ao banco de dados...");
        em.close();
    }

    /**
     * Ordem dos testes
     */
    @Test
    public void testMethodOrder() {
        stage1_testSave();
        stage2_testFindById();
        stage3_testFindByIdNotFound();
        stage4_testFindAll();
        stage5_testUpdate();
        stage6_testfindByNomeLike();
        stage7_testfindByNomeLikeNotFound();
        stage8_testRemove();
    }

    public void stage1_testSave() {
        System.out.println("testSave() rodando...\n");

        // Criar algumas categorias
        System.out.println("Criando instancias de Usuarios...\n");
        Usuarios u1 = new Usuarios();
        Usuarios u2 = new Usuarios();
        Usuarios u3 = new Usuarios();
        Usuarios u4 = new Usuarios();

        System.out.println("Criando atributos usuario 1...\n");
        u1.setNome("Marcos Antônio");
        u1.setLogin("marcos123");
        u1.setSenha("12345");
        u1.setPerfil("usuario");

        System.out.println("Criando atributos usuario 2...\n");
        u2.setNome("Ana Paula");
        u2.setLogin("ap123");
        u2.setSenha("11111");
        u2.setPerfil("administrador");

        System.out.println("Criando atributos usuario 3...\n");
        u3.setNome("Ulisses Passos");
        u3.setLogin("ulisses34");
        u3.setSenha("55555");
        u3.setPerfil("usuario");

        System.out.println("Criando atributos usuario 4...\n");
        u4.setNome("Pamela Silva");
        u4.setLogin("pam123");
        u4.setSenha("44444");
        u4.setPerfil("usuario");

        // Criar lista
        List<Usuarios> usuarios = new ArrayList<Usuarios>();
        System.out.println("Adicionando usuarios a lista...\n");
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);
        usuarios.add(u4);

        // Persistindo dados
        UsuariosDAO dao = new UsuariosDAO();
        ControllerUsuarios control = new ControllerUsuarios();

        // Salvar dados
        System.out.println("Inserindo usuarios na base de dados...\n");

        Integer id = 1;

        for (Usuarios u : usuarios) {

            // Validar dados
            System.out.println("Validando dados...\n");
            if (control.validate(u)) {

                dao.save(u);

                // Executando teste
                assertEquals(id, u.getId());
                System.out.println("\nDados inseridos com sucesso.\n");

                id++;

            }
        }

        System.out.println("\nPassou\n");

        System.out.println("testSave() concluido.\n");

    }

    public void stage2_testFindById() {
        System.out.println("\ntestFindById() rodando...\n");

        System.out.println("Gerando id...\n");
        // Valor deve ser entre 1 e 4
        Integer id = (int) (Math.random() * 4) + 1;

        UsuariosDAO dao = new UsuariosDAO();

        System.out.println("Procurando pelo id " + id + "...\n");
        Usuarios u = dao.findById(id);

        // Verificando acertos
        assertEquals(id, u.getId());

        // Mostrando dados
        System.out.println("\nID : " + u.getId());
        System.out.println("\nNome : " + u.getNome());
        System.out.println("\nLogin : " + u.getLogin());
        System.out.println("\nSenha : " + u.getSenha());
        System.out.println("\nPerfil : " + u.getPerfil());

        System.out.println("\nPassou\n");

        System.out.println("testFindById() concluido.\n");

    }

    public void stage3_testFindByIdNotFound() {
        System.out.println("\ntestFindByIdNotFound() rodando...\n");

        System.out.println("Gerando id aleatório...\n");
        // Id ainda não registrado
        Integer id = 12;

        UsuariosDAO dao = new UsuariosDAO();

        System.out.println("Procurando pelo id " + id + "...\n");
        Usuarios u = dao.findById(id);
        Usuarios exp = null;

        // Verificando acertos
        assertEquals(exp, u);

        System.out.println("\nDados não encontrados");

        System.out.println("\nPassou\n");

        System.out.println("\ntestFindByIdNotFound() concluido...\n");
    }

    public void stage4_testFindAll() {
        System.out.println("\ntestFindAll() rodando...\n");

        UsuariosDAO dao = new UsuariosDAO();

        System.out.println("Procurando...\n");
        List<Usuarios> usuarios = dao.findAll();

        // Verificando acertos
        assertFalse(usuarios.isEmpty());

        System.out.println("\nTodos os dados encontrados\n");

        // Mostrando dados
        for (Usuarios u : usuarios) {
            System.out.println("\nID : " + u.getId());
            System.out.println("\nNome : " + u.getNome());
            System.out.println("\nLogin : " + u.getLogin());
            System.out.println("\nSenha : " + u.getSenha());
            System.out.println("\nPerfil : " + u.getPerfil());
            System.out.println("--------------------------------");
        }

        System.out.println("\nPassou\n");

        System.out.println("testFindAll() concluido.\n");

    }

    public void stage5_testUpdate() {
        System.out.println("\ntestUpdate() rodando...\n");

        System.out.println("Usuario de id 4 escolhido");

        System.out.println("Criando instancia de usuario...\n");
        Usuarios u = new Usuarios();

        // Precisamos do id para atualizar
        System.out.println("Inserindo atributos de usuario...\n");
        u.setId(4);
        u.setNome("Pamela Silva");
        u.setLogin("pamelasilva");
        u.setSenha("silva45$");
        u.setPerfil("administrador");

        System.out.println("Validando e atualizando dados...\n");
        UsuariosDAO dao = new UsuariosDAO();
        ControllerUsuarios ctr = new ControllerUsuarios();

        if (ctr.validate(u)) {
            dao.save(u);
        }

        // Buscando novos dados
        Usuarios us = dao.findById(4);

        // testando retorno(verificar alteração do login)
        assertEquals((Integer) 4, us.getId());
        assertEquals("pamelasilva", us.getLogin());

        // Mostrando dados
        System.out.println("\nID : " + us.getId());
        System.out.println("\nNome : " + us.getNome());
        System.out.println("\nLogin : " + us.getLogin());
        System.out.println("\nSenha : " + us.getSenha());
        System.out.println("\nPerfil : " + us.getPerfil());

        System.out.println("\nPassou\n");

        System.out.println("testUpdate() concluido.\n");
    }

    public void stage6_testfindByNomeLike() {
        System.out.println("\ntestfindByNomeLike() rodando...\n");

        System.out.println("Selecionando letra ...\n");

        char letter = 'p';

        UsuariosDAO dao = new UsuariosDAO();

        System.out.println("Procurando 'p'...\n");
        List<Usuarios> usuarios = dao.findByNomeLike(String.valueOf(letter));

        // Verificando acertos
        assertFalse(usuarios.isEmpty());

        System.out.println("\nTodos os dados encontrados\n");

        // Mostrando dados
        for (Usuarios u : usuarios) {

            System.out.println("\nID : " + u.getId());
            System.out.println("\nNome : " + u.getNome());
            System.out.println("\nLogin : " + u.getLogin());
            System.out.println("\nSenha : " + u.getSenha());
            System.out.println("\nPerfil : " + u.getPerfil());
            System.out.println("--------------------------------");
        }

        System.out.println("\nPassou\n");

        System.out.println("testfindByDescricaoLike() concluido.\n");
    }

    public void stage7_testfindByNomeLikeNotFound() {
        System.out.println("\ntestfindByNomeLikeNotFound() rodando...\n");

        System.out.println("Selecionando letra ...\n");

        char letter = 'z';

        UsuariosDAO dao = new UsuariosDAO();

        System.out.println("Procurando 'z'...\n");
        List<Usuarios> usuarios = dao.findByNomeLike(String.valueOf(letter));

        // Verificando acertos
        assertTrue(usuarios.isEmpty());

        System.out.println("\nDados não encontrados");

        System.out.println("\nPassou\n");

        System.out.println("testfindByNomeLikeNotFound() concluido.\n");

    }

    public void stage8_testRemove() {
        System.out.println("\ntestRemove() rodando...\n");

        System.out.println("Gerando numero de id...\n");
        Integer id = 3;

        System.out.println("Removendo usuario com id 3...\n");

        UsuariosDAO dao = new UsuariosDAO();
        dao.remove(id);

        // Verificar se foi removido
        System.out.println("Procurando...\n");
        Usuarios us = dao.findById(id);

        // Não deve retornar nada pois foi excluido
        assertNull(us);

        System.out.println("Nada encontrado");

        System.out.println("\nPassou\n");

        System.out.println("testRemove() concluido.\n");

    }

}
