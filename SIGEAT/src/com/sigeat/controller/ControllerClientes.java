/*
 * Classe responsavel pela implementação dos métodos de controle de Clientes
 */

package com.sigeat.controller;

import com.sigeat.model.bean.Clientes;

/*
 * SIGEAT/ Controller / Clientes
 * @author Junior
 * Version : 1.0.0
 */

public class ControllerClientes implements IControllerClientes {

    @Override
    public boolean validate(Clientes cliente) {
        
        if (cliente.getNome().trim().isEmpty() || cliente.getNome().length() > 80) {

            //MESSAGE HERE
            return false;

        }
        
        if (cliente.getEndereco().trim().isEmpty() || cliente.getEndereco().length() > 80) {

            //MESSAGE HERE
            return false;

        }
        
        if (cliente.getTelefone().trim().isEmpty() || cliente.getTelefone().length() > 15) {

            //MESSAGE HERE
            return false;

        }

        return true;
    }

}
