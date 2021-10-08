/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigeat.model.dao;

import com.sigeat.model.bean.Usuarios;

/**
 *
 * @author Workstation
 */
public interface IUsuariosDAO {
    
    public abstract Usuarios save(Usuarios usuario);
    
}
