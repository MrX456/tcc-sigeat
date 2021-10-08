/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigeat.model.dao;

import com.sigeat.connection.ConnectionFactory;
import com.sigeat.model.bean.Usuarios;
import javax.persistence.EntityManager;

/**
 *
 * @author Workstation
 */
public class UsuariosDAO implements IUsuariosDAO {

    @Override
    public Usuarios save(Usuarios usuario) {
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            //Desfazer alterações
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        
        return usuario;
    }
    
}
