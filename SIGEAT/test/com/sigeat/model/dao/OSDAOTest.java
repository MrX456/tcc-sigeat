/*
 * Classe de teste unitário de CRUD de OS
 */
package com.sigeat.model.dao;

import com.sigeat.connection.ConnectionFactory;
import com.sigeat.controller.ControllerOS;
import com.sigeat.model.bean.Clientes;
import com.sigeat.model.bean.OS;
import java.math.BigDecimal;
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
 * SIGEAT/ Tests / Model / DAO / OS
 * @author Junior
 * Version : 1.0.0
 */
public class OSDAOTest {

    private static EntityManager em;

    public OSDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Iniciando testes da entidade OS");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Encerrando testes da entidade OS");
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
        stage2_testFindByNmrOS();
        stage3_testFindByNmrOSNotFound();
        stage4_testFindAll();
        stage5_testUpdate();
        stage6_tesfindByEquipamentoLike();
        stage7_testfindByEquipamentoLikeNotFound();
        stage8_testRemove();
    }

    public void stage1_testSave() {
        System.out.println("testSave() rodando...\n");

        // Criar algumas os
        System.out.println("Criando instancias de OS...\n");
        OS o1 = new OS();
        OS o2 = new OS();
        OS o3 = new OS();

        System.out.println("Criando atributos OS 1...\n");
        o1.setEquipamento("Notebook Acer");
        o1.setDefeito("Teclado não funciona");
        Clientes c1 = new Clientes();
        c1.setId(1);
        o1.setCliente(c1);

        System.out.println("Criando atributos OS 2...\n");
        o2.setEquipamento("Desktop Positivo");
        o2.setDefeito("Não liga");
        Clientes c2 = new Clientes();
        c2.setId(2);
        o2.setCliente(c2);

        System.out.println("Criando atributos OS 3...\n");
        o3.setEquipamento("Impressora HP");
        o3.setDefeito("Não puxa papel");
        Clientes c3 = new Clientes();
        c3.setId(3);
        o3.setCliente(c3);

        // Criar lista
        List<OS> oss = new ArrayList<OS>();
        System.out.println("Adicionando OSs a lista...\n");
        oss.add(o1);
        oss.add(o2);
        oss.add(o3);

        // Persistindo dados
        OSDAO dao = new OSDAO();
        ControllerOS control = new ControllerOS();

        // Salvar dados
        System.out.println("Inserindo OSs na base de dados...\n");

        Integer id = 1;

        for (OS o : oss) {

            // Validar dados
            System.out.println("Validando dados...\n");
            if (control.validate(o)) {

                dao.save(o);

                // Executando teste
                assertEquals(id, o.getNmr_os());
                System.out.println("\nDados inseridos com sucesso.\n");

                id++;

            }
        }

        System.out.println("\nPassou\n");

        System.out.println("testSave() concluido.\n");
    }

    public void stage2_testFindByNmrOS() {
        System.out.println("\ntestFindByNmrOS() rodando...\n");

        System.out.println("Gerando id...\n");
        // Valor deve ser entre 1 e 3
        Integer id = (int) (Math.random() * 3) + 1;

        OSDAO dao = new OSDAO();

        System.out.println("Procurando pelo numero " + id + "...\n");
        OS o = dao.findById(id);

        // Verificando acertos
        assertEquals(id, o.getNmr_os());

        // Mostrando dados
        System.out.println("\nNmr OS : " + o.getNmr_os());
        System.out.println("\nEquipamento : " + o.getEquipamento());
        System.out.println("\nDefeito : " + o.getDefeito());
        System.out.println("\nData OS : " + o.getDt_os());
        System.out.println("\nCliente : " + o.getCliente().getNome());
        System.out.println("\nTelefone : " + o.getCliente().getTelefone());

        System.out.println("\nPassou\n");

        System.out.println("testFindByNmrOS() concluido.\n");

    }

    public void stage3_testFindByNmrOSNotFound() {
        System.out.println("\ntestFindByNmrOSNotFound() rodando...\n");

        System.out.println("Gerando id aleatório...\n");
        // Id ainda não registrado
        Integer id = 12;

        OSDAO dao = new OSDAO();

        System.out.println("Procurando pela os " + id + "...\n");
        OS o = dao.findById(id);
        OS exp = null;

        // Verificando acertos
        assertEquals(exp, o);

        System.out.println("\nDados não encontrados");

        System.out.println("\nPassou\n");

        System.out.println("\ntestFindByNmrOSNotFound() concluido...\n");
    }

    public void stage4_testFindAll() {
        System.out.println("\ntestFindAll() rodando...\n");

        OSDAO dao = new OSDAO();

        System.out.println("Procurando...\n");
        List<OS> oss = dao.findAll();

        // Verificando acertos
        assertFalse(oss.isEmpty());

        System.out.println("\nTodos os dados encontrados\n");

        // Mostrando dados
        for (OS o : oss) {
            System.out.println("\nNmr OS : " + o.getNmr_os());
            System.out.println("\nEquipamento : " + o.getEquipamento());
            System.out.println("\nDefeito : " + o.getDefeito());
            System.out.println("\nData OS : " + o.getDt_os());
            System.out.println("\nCliente : " + o.getCliente().getNome());
            System.out.println("\nTelefone : " + o.getCliente().getTelefone());
            System.out.println("--------------------------------");
        }

        System.out.println("\nPassou\n");

        System.out.println("testFindAll() concluido.\n");

    }

    public void stage5_testUpdate() {
        System.out.println("\ntestUpdate() rodando...\n");

        System.out.println("Atualizar OS numero 1");

        System.out.println("Criando instancia de cliente...\n");
        OS o = new OS();

        // Precisamos do id para atualizar
        System.out.println("Inserindo atributos de os...\n");
        o.setNmr_os(1);
        o.setEquipamento("Notebook Acer");
        o.setDefeito("Teclado não funciona");
        Clientes c1 = new Clientes();
        c1.setId(1);
        o.setCliente(c1);
        
        o.setTipo("OS");
        o.setSituacao("Aguardando retirada");
        o.setServico("Troca do teclado");
        o.setTecnico("José de Assis");
        o.setValor(new BigDecimal(190.00));

        System.out.println("Validando e atualizando dados...\n");
        OSDAO dao = new OSDAO();
        ControllerOS ctr = new ControllerOS();

        if (ctr.validate(o)) {
            dao.save(o);
        }

        // Buscando novos dados
        OS os = dao.findById(1);

        // testando retorno(verificar alteração)
        assertEquals((Integer) 1, os.getNmr_os());

        // Mostrando dados
        System.out.println("\nNmr OS : " + o.getNmr_os());
        System.out.println("\nEquipamento : " + os.getEquipamento());
        System.out.println("\nDefeito : " + os.getDefeito());
        System.out.println("\nData OS : " + os.getDt_os());
        System.out.println("\nTipo OS : " + os.getTipo());
        System.out.println("\nSituacao : " + os.getSituacao());
        System.out.println("\nServiço : " + os.getServico());
        System.out.println("\nTécnico : " + os.getTecnico());
        System.out.println("\nValor : " + os.getValor());
        System.out.println("\nCliente : " + os.getCliente().getNome());
        System.out.println("\nTelefone : " + os.getCliente().getTelefone());

        System.out.println("\nPassou\n");

        System.out.println("testUpdate() concluido.\n");
    }

    public void stage6_tesfindByEquipamentoLike() {
        System.out.println("\ntesfindByEquipamentoLike() rodando...\n");

        System.out.println("Selecionando equipamento ...\n");

        String letter = "acer";

        OSDAO dao = new OSDAO();

        System.out.println("Procurando 'acer'...\n");
        List<OS> os = dao.findByEquipamentoLike(String.valueOf(letter));

        // Verificando acertos
        assertFalse(os.isEmpty());

        System.out.println("\nTodos os dados encontrados\n");

        // Mostrando dados
        for (OS o : os) {

            System.out.println("\nNmr OS : " + o.getNmr_os());
            System.out.println("\nEquipamento : " + o.getEquipamento());
            System.out.println("\nDefeito : " + o.getDefeito());
            System.out.println("\nData OS : " + o.getDt_os());
            System.out.println("\nCliente : " + o.getCliente().getNome());
            System.out.println("\nTelefone : " + o.getCliente().getTelefone());
            System.out.println("--------------------------------");
        }

        System.out.println("\nPassou\n");

        System.out.println("tesfindByEquipamentoLike() concluido.\n");
    }

    public void stage7_testfindByEquipamentoLikeNotFound() {
        System.out.println("\ntesfindByEquipamentoLikeNotFound() rodando...\n");

        System.out.println("Selecionando equipamento...\n");

        String letter = "asus";

        OSDAO dao = new OSDAO();

        System.out.println("Procurando 'asus'...\n");
        List<OS> os = dao.findByEquipamentoLike(String.valueOf(letter));

        // Verificando acertos
        assertTrue(os.isEmpty());

        System.out.println("\nDados não encontrados");

        System.out.println("\nPassou\n");

        System.out.println("tesfindByEquipamentoLikeNotFound() concluido.\n");

    }

    public void stage8_testRemove() {
        System.out.println("\ntestRemove() rodando...\n");

        System.out.println("Gerando numero de id...\n");
        Integer id = 3;

        System.out.println("Removendo os numero 3...\n");

        OSDAO dao = new OSDAO();
        dao.remove(id);

        // Verificar se foi removido
        System.out.println("Procurando...\n");
        OS os = dao.findById(id);

        // Não deve retornar nada pois foi excluido
        assertNull(os);

        System.out.println("Nada encontrado");

        System.out.println("\nPassou\n");

        System.out.println("testRemove() concluido.\n");

    }
}
