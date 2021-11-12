/*
 * Classe responsavel pela implementação dos métodos de controle de Usuarios
 */
package com.sigeat.controller;

import com.sigeat.model.bean.Usuarios;
import javax.swing.JOptionPane;

/*
 * SIGEAT/ Controller / Usuarios
 * @author Junior
 * Version : 1.0.0
 */
public class ControllerUsuarios extends Controller implements IControllerUsuarios {

    @Override
    public boolean validate(Usuarios usuario) {

        if (usuario.getNome().trim().isEmpty() || usuario.getNome().length() > 80) {

            JOptionPane.showMessageDialog(null, "Preencha o campo nome corretamente! Máximo 80 caracteres",
                    "Nome inválido", JOptionPane.ERROR_MESSAGE);
            return false;

        }

        if (usuario.getLogin().trim().isEmpty() || usuario.getLogin().length() > 15) {

            JOptionPane.showMessageDialog(null, "Preencha o campo login corretamente! Máximo 15 caracteres",
                    "Login inválido", JOptionPane.ERROR_MESSAGE);
            return false;

        }

        if (usuario.getSenha().trim().isEmpty() || usuario.getSenha().length() > 15) {

            JOptionPane.showMessageDialog(null, "Preencha o campo senha corretamente! Máximo 15 caracteres",
                    "Senha inválida", JOptionPane.ERROR_MESSAGE);
            return false;

        }

        return true;
    }

}
