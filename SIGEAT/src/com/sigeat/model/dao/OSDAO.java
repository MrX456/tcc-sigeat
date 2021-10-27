/*
 * Classe responsavel pelo acesso e CRUD de OS
 */
package com.sigeat.model.dao;

import com.sigeat.connection.ConnectionFactory;
import com.sigeat.model.bean.OS;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/*
 * SIGEAT/ Model / DAO / OS
 * @author Junior
 * Version : 1.0.0
 */
public class OSDAO implements IOSDAO {

    @Override
    public OS save(OS os) {
        EntityManager em = new ConnectionFactory().getConnection();

        try {
            em.getTransaction().begin();

            //Se o os ja possui um id
            if (os.getNmr_os()!= null) {

                em.merge(os);

            } else {

                em.persist(os);

            }

            em.getTransaction().commit();

        } catch (Exception e) {
            //Desfazer alterações
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        return os;
    }

    @Override
    public OS findById(Integer nmrOS) {
        EntityManager em = new ConnectionFactory().getConnection();

        OS os = null;

        try {

            os = em.find(OS.class, nmrOS);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            em.close();

        }

        return os;
    }

    @Override
    public List<OS> findAll() {
         EntityManager em = new ConnectionFactory().getConnection();

        List<OS> os = null;

        try {

            os = em.createQuery("from OS os").getResultList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            em.close();

        }

        return os;
    }

    @Override
    public OS remove(Integer nmrOS) {
        EntityManager em = new ConnectionFactory().getConnection();

        OS os = null;

        try {

            //Buscar os para deletar
            os = em.find(OS.class, nmrOS);

            em.getTransaction().begin();
            em.remove(os);
            em.getTransaction().commit();

        } catch (Exception e) {

            em.getTransaction().rollback();
            e.printStackTrace();

        } finally {

            em.close();

        }

        return os;
    }

    @Override
    public List<OS> findByEquipamentoLike(String equipamento) {
         //Entity manager e conexão
        EntityManager em = new ConnectionFactory().getConnection();

        List<OS> os = null;

        try {

            //Query com clausula like. Wildcard %param%
            Query q = em.createQuery("from OS os where os.equipamento like '%' || :equipCli");
            q.setParameter("equipCli", equipamento + "%");
            os = q.getResultList();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            em.close();

        }

        return os;
    }
    
}
