/*
 * Classe responsavel pela implementação dos métodos de controle de Clientes
 */

package com.sigeat.controller;

import com.sigeat.model.bean.Clientes;
import javax.swing.JOptionPane;

/*
 * SIGEAT/ Controller / Clientes
 * @author Junior
 * Version : 1.0.0
 */

public class ControllerClientes extends Controller implements IControllerClientes {

    @Override
    public boolean validate(Clientes cliente) {
        
        if (cliente.getNome().trim().isEmpty() || cliente.getNome().length() > 80) {

            JOptionPane.showMessageDialog(null, "Preencha o campo nome corretamente! Máximo 80 caracteres",
                    "Nome inválido", JOptionPane.ERROR_MESSAGE);
            return false;

        }
        
        if (cliente.getEndereco().trim().isEmpty() || cliente.getEndereco().length() > 150) {

            JOptionPane.showMessageDialog(null, "Preencha o campo endereço corretamente! Máximo 150 caracteres",
                    "Endereço inválido", JOptionPane.ERROR_MESSAGE);
            return false;

        }
        
        if (cliente.getTelefone().trim().isEmpty() || cliente.getTelefone().length() > 15) {

            JOptionPane.showMessageDialog(null, "Preencha o campo telefone corretamente! Máximo 15 caracteres",
                    "Telefone inválido", JOptionPane.ERROR_MESSAGE);
            return false;

        }

        return true;
    }

}
