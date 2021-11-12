/*
 * Classe responsavel pelo acesso e CRUD de Usuarios
 */
package com.sigeat.model.dao;

import com.sigeat.connection.ConnectionFactory;
import com.sigeat.model.bean.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/*
 * SIGEAT/ Model / DAO / Usuarios
 * @author Junior
 * Version : 1.0.0
 */
public class UsuariosDAO implements IUsuariosDAO {

    @Override
    public Usuarios save(Usuarios usuario) {

        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();

            //Se o usuario ja possui um id
            if (usuario.getId() != null) {

                em.merge(usuario);

            } else {

                em.persist(usuario);

            }

            em.getTransaction().commit();

        } catch (Exception e) {
            //Desfazer alterações
            em.getTransaction().rollback();
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar usuário!"
                    + "\nVerifique se o banco de dados está em execução!",
                    "Operação não concluída", JOptionPane.ERROR_MESSAGE);
        } finally {
            em.close();
        }

        return usuario;
    }

    @Override
    public Usuarios findById(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();

        Usuarios usuario = null;

        try {

            usuario = em.find(Usuarios.class, id);

        } catch (Exception e) {

            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Dados não encontrados!"
                    + "\nVerifique se o banco de dados está em execução!",
                    "Operação não concluída", JOptionPane.ERROR_MESSAGE);
          

        } finally {

            em.close();

        }

        return usuario;

    }

    @Override
    public List<Usuarios> findAll() {

        EntityManager em = new ConnectionFactory().getConnection();

        List<Usuarios> usuarios = null;

        try {

            usuarios = em.createQuery("from Usuarios usu").getResultList();

        } catch (Exception e) {

            e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Dados não encontrados!"
                    + "\nVerifique se o banco de dados está em execução!",
                    "Operação não concluída", JOptionPane.ERROR_MESSAGE);

        } finally {

            em.close();

        }

        return usuarios;
    }

    @Override
    public Usuarios remove(Integer id) {

        EntityManager em = new ConnectionFactory().getConnection();

        Usuarios usuario = null;

        try {

            //Buscar usuario para deletar
            usuario = em.find(Usuarios.class, id);

            em.getTransaction().begin();
            em.remove(usuario);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Erro ao remover usuário!"
                    + "\nVerifique se o banco de dados está em execução!",
                    "Operação não concluída", JOptionPane.ERROR_MESSAGE);

        } finally {

            em.close();

        }

        return usuario;
    }

    @Override
    public List<Usuarios> findByNomeLike(String nome) {

        //Entity manager e conexão
        EntityManager em = new ConnectionFactory().getConnection();

        List<Usuarios> usuarios = null;

        try {

            //Query com clausula like. Wildcard %param%
            Query q = em.createQuery("from Usuarios usu where usu.nome like '%' || :nomeUsu");
            q.setParameter("nomeUsu", nome + "%");
            usuarios = q.getResultList();

        } catch (Exception e) {

            e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Dados não encontrados!"
                    + "\nVerifique se o banco de dados está em execução!",
                    "Operação não concluída", JOptionPane.ERROR_MESSAGE);

        } finally {

            em.close();

        }

        return usuarios;
    }

    @Override
    public Usuarios login(String login, String senha) throws NoResultException {

        EntityManager em = new ConnectionFactory().getConnection();

        Usuarios usuario = null;

        Query q = em.createQuery("from Usuarios usu where usu.login in :login and usu.senha in :senha");
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        usuario = (Usuarios) q.getSingleResult();

        em.close();

        return usuario;

    }

}
