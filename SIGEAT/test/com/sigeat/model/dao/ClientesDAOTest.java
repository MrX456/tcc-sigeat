/*
 * Classe de teste unitário de CRUD de Clientes
 */
package com.sigeat.model.dao;

import com.sigeat.connection.ConnectionFactory;
import com.sigeat.controller.ControllerClientes;
import com.sigeat.model.bean.Clientes;
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
 * SIGEAT/ Tests / Model / DAO / Clientes
 * @author Junior
 * Version : 1.0.0
 */
public class ClientesDAOTest {

    private static EntityManager em;

    public ClientesDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando testes da entidade Clientes");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Encerrando testes da entidade Clientes");
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
        System.out.println("Criando instancias de Clientes...\n");
        Clientes c1 = new Clientes();
        Clientes c2 = new Clientes();
        Clientes c3 = new Clientes();
        Clientes c4 = new Clientes();

        System.out.println("Criando atributos cliente 1...\n");
        c1.setNome("Marcos Antônio");
        c1.setEndereco("Rua Maria Shinneider Britto 89");
        c1.setTelefone("3333-4444");
        c1.setEmail("mc123@email.com.br");

        System.out.println("Criando atributos cliente 2...\n");
        c2.setNome("Ana Paula de Oliveira");
        c2.setEndereco("Rua Philadelpho de Paula Pinto 10135");
        c2.setTelefone("3544-5555");
        c2.setEmail("anapaula555@email.com");

        System.out.println("Criando atributos cliente 3...\n");
        c3.setNome("Ulisses Passos");
        c3.setEndereco("Rua Adelina Carvalho 13107");
        c3.setTelefone("3210-4455");
        c3.setEmail("");

        System.out.println("Criando atributos cliente 4...\n");
        c4.setNome("Pamela Silva");
        c4.setEndereco("Rua Hilário Bergami 1839");
        c4.setTelefone("3655-0020");
        c4.setEmail("pamsilva098@email.com");

        // Criar lista
        List<Clientes> clientes = new ArrayList<Clientes>();
        System.out.println("Adicionando clientes a lista...\n");
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);

        // Persistindo dados
        ClientesDAO dao = new ClientesDAO();
        ControllerClientes control = new ControllerClientes();

        // Salvar dados
        System.out.println("Inserindo usuarios na base de dados...\n");

        Integer id = 1;

        for (Clientes c : clientes) {

            // Validar dados
            System.out.println("Validando dados...\n");
            if (control.validate(c)) {

                dao.save(c);

                // Executando teste
                assertEquals(id, c.getId());
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

        ClientesDAO dao = new ClientesDAO();

        System.out.println("Procurando pelo id " + id + "...\n");
        Clientes c = dao.findById(id);

        // Verificando acertos
        assertEquals(id, c.getId());

        // Mostrando dados
        System.out.println("\nID : " + c.getId());
        System.out.println("\nNome : " + c.getNome());
        System.out.println("\nEndereco : " + c.getEndereco());
        System.out.println("\nTelefone : " + c.getTelefone());
        System.out.println("\nEmail : " + c.getEmail());

        System.out.println("\nPassou\n");

        System.out.println("testFindById() concluido.\n");

    }

    public void stage3_testFindByIdNotFound() {
        System.out.println("\ntestFindByIdNotFound() rodando...\n");

        System.out.println("Gerando id aleatório...\n");
        // Id ainda não registrado
        Integer id = 12;

        ClientesDAO dao = new ClientesDAO();

        System.out.println("Procurando pelo id " + id + "...\n");
        Clientes c = dao.findById(id);
        Clientes exp = null;

        // Verificando acertos
        assertEquals(exp, c);

        System.out.println("\nDados não encontrados");

        System.out.println("\nPassou\n");

        System.out.println("\ntestFindByIdNotFound() concluido...\n");
    }

    public void stage4_testFindAll() {
        System.out.println("\ntestFindAll() rodando...\n");

        ClientesDAO dao = new ClientesDAO();

        System.out.println("Procurando...\n");
        List<Clientes> clientes = dao.findAll();

        // Verificando acertos
        assertFalse(clientes.isEmpty());

        System.out.println("\nTodos os dados encontrados\n");

        // Mostrando dados
        for (Clientes c : clientes) {
            System.out.println("\nID : " + c.getId());
            System.out.println("\nNome : " + c.getNome());
            System.out.println("\nEndereco : " + c.getEndereco());
            System.out.println("\nTelefone : " + c.getTelefone());
            System.out.println("\nEmail : " + c.getEmail());
            System.out.println("--------------------------------");
        }

        System.out.println("\nPassou\n");

        System.out.println("testFindAll() concluido.\n");

    }

    public void stage5_testUpdate() {
        System.out.println("\ntestUpdate() rodando...\n");

        System.out.println("Cliente de id 4 escolhido");

        System.out.println("Criando instancia de cliente...\n");
        Clientes c = new Clientes();

        // Precisamos do id para atualizar
        System.out.println("Inserindo atributos de cliente...\n");
        c.setId(4);
        c.setNome("Pamela Silva");
        c.setEndereco("Rua Oito 1650"); //Novo endereço
        c.setTelefone("95255-0222"); //Novo telefone
        c.setEmail("pamsilva098@email.com");

        System.out.println("Validando e atualizando dados...\n");
        ClientesDAO dao = new ClientesDAO();
        ControllerClientes ctr = new ControllerClientes();

        if (ctr.validate(c)) {
            dao.save(c);
        }

        // Buscando novos dados
        Clientes cs = dao.findById(4);

        // testando retorno(verificar alteração)
        assertEquals((Integer) 4, cs.getId());
        assertEquals("95255-0222", cs.getTelefone());

        // Mostrando dados
        System.out.println("\nID : " + cs.getId());
        System.out.println("\nNome : " + cs.getNome());
            System.out.println("\nEndereco : " + cs.getEndereco());
            System.out.println("\nTelefone : " + cs.getTelefone());
            System.out.println("\nEmail : " + cs.getEmail());

        System.out.println("\nPassou\n");

        System.out.println("testUpdate() concluido.\n");
    }

    public void stage6_testfindByNomeLike() {
        System.out.println("\ntestfindByNomeLike() rodando...\n");

        System.out.println("Selecionando letra ...\n");

        char letter = 'p';

        ClientesDAO dao = new ClientesDAO();

        System.out.println("Procurando 'p'...\n");
        List<Clientes> clientes = dao.findByNomeLike(String.valueOf(letter));

        // Verificando acertos
        assertFalse(clientes.isEmpty());

        System.out.println("\nTodos os dados encontrados\n");

        // Mostrando dados
        for (Clientes c : clientes) {

            System.out.println("\nID : " + c.getId());
            System.out.println("\nNome : " + c.getNome());
            System.out.println("\nEndereco : " + c.getEndereco());
            System.out.println("\nTelefone : " + c.getTelefone());
            System.out.println("\nEmail : " + c.getEmail());
            System.out.println("--------------------------------");
        }

        System.out.println("\nPassou\n");

        System.out.println("testfindByNomeLike() concluido.\n");
    }

    public void stage7_testfindByNomeLikeNotFound() {
        System.out.println("\ntestfindByNomeLikeNotFound() rodando...\n");

        System.out.println("Selecionando letra ...\n");

        char letter = 'z';

        ClientesDAO dao = new ClientesDAO();

        System.out.println("Procurando 'z'...\n");
        List<Clientes> clientes = dao.findByNomeLike(String.valueOf(letter));

        // Verificando acertos
        assertTrue(clientes.isEmpty());

        System.out.println("\nDados não encontrados");

        System.out.println("\nPassou\n");

        System.out.println("testfindByNomeLikeNotFound() concluido.\n");

    }

    public void stage8_testRemove() {
        System.out.println("\ntestRemove() rodando...\n");

        System.out.println("Gerando numero de id...\n");
        Integer id = 4;

        System.out.println("Removendo cliente com id 4...\n");

        ClientesDAO dao = new ClientesDAO();
        dao.remove(id);

        // Verificar se foi removido
        System.out.println("Procurando...\n");
        Clientes cs = dao.findById(id);

        // Não deve retornar nada pois foi excluido
        assertNull(cs);

        System.out.println("Nada encontrado");

        System.out.println("\nPassou\n");

        System.out.println("testRemove() concluido.\n");

    }

}
