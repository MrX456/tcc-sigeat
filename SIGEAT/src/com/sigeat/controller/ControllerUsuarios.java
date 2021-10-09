/*
 * Classe responsavel pela implementação dos métodos de controle de Usuarios
 */

package com.sigeat.controller;

import com.sigeat.model.bean.Usuarios;

/*
 * SIGEAT/ Controller / Usuarios
 * @author Junior
 * Version : 1.0.0
 */

public class ControllerUsuarios extends Controller implements IControllerUsuarios {

    @Override
    public boolean validate(Usuarios usuario) {
        
        if (usuario.getNome().trim().isEmpty() || usuario.getNome().length() > 80) {
            
            //MESSAGE HERE
            return false;
            
        }
        
        if (usuario.getLogin().trim().isEmpty() || usuario.getLogin().length() > 15) {
            
            //MESSAGE HERE
            return false;
            
        }
        
        if (usuario.getSenha().trim().isEmpty() || usuario.getSenha().length() > 15) {
            
            //MESSAGE HERE
            return false;
            
        }
        
        return true;
    }
    
}
