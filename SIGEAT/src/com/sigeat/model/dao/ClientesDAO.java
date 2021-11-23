/*
 * Classe responsavel pelo acesso e CRUD de Clientes
 */
package com.sigeat.model.dao;

import com.sigeat.connection.ConnectionFactory;
import com.sigeat.model.bean.Clientes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/*
 * SIGEAT/ Model / DAO / Clientes
 * @author Junior
 * Version : 1.0.0
 */
public class ClientesDAO implements IClientesDAO {

    @Override
    public Clientes save(Clientes cliente) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();

            //Se o cliente ja possui um id
            if (cliente.getId() != null) {

                em.merge(cliente);

            } else {

                em.persist(cliente);

            }

            em.getTransaction().commit();

        } catch (Exception e) {
            //Desfazer alterações
            em.getTransaction().rollback();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente!"
                    + "\nVerifique se o banco de dados está em execução!",
                    "Operação não concluída", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }

        return cliente;
    }

    @Override
    public Clientes findById(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();

        Clientes cliente = null;

        try {

            cliente = em.find(Clientes.class, id);

        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dados não encontrados!"
                    + "\nVerifique se o banco de dados está em execução!",
                    "Operação não concluída", JOptionPane.ERROR_MESSAGE);

        } finally {

            em.close();

        }

        return cliente;
    }

    @Override
    public List<Clientes> findAll() {
        EntityManager em = new ConnectionFactory().getConnection();

        List<Clientes> clientes = null;

        try {

            clientes = em.createQuery("from Clientes cli").getResultList();

        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dados não encontrados!"
                    + "\nVerifique se o banco de dados está em execução!",
                    "Operação não concluída", JOptionPane.ERROR_MESSAGE);

        } finally {

            em.close();

        }

        return clientes;
    }

    @Override
    public Clientes remove(Integer id) {
        EntityManager em = new ConnectionFactory().getConnection();

        Clientes cliente = null;

        try {

            //Buscar usuario para deletar
            cliente = em.find(Clientes.class, id);

            em.getTransaction().begin();
            em.remove(cliente);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!",
                        "Exclusão confirmada", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {

            em.getTransaction().rollback();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente!"
                    + "\nEste cliente está vinculado à uma ou mais OS!",
                    "Operação não concluída", JOptionPane.ERROR_MESSAGE);

        } finally {

            em.close();
            
        }

        return cliente;
    }

    @Override
    public List<Clientes> findByNomeLike(String nome) {
        //Entity manager e conexão
        EntityManager em = new ConnectionFactory().getConnection();

        List<Clientes> clientes = null;

        try {

            //Query com clausula like. Wildcard %param%
            Query q = em.createQuery("from Clientes cli where cli.nome like '%' || :nomeCli");
            q.setParameter("nomeCli", nome + "%");
            clientes = q.getResultList();

        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dados não encontrados!"
                    + "\nVerifique se o banco de dados está em execução!",
                    "Operação não concluída", JOptionPane.ERROR_MESSAGE);

        } finally {

            em.close();

        }

        return clientes;
    }

}
