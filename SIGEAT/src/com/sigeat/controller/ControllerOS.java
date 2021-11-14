/*
 * Classe responsavel pela implementação dos métodos de controle de OS
 */
package com.sigeat.controller;

import com.sigeat.model.bean.OS;
import javax.swing.JOptionPane;

/*
 * SIGEAT/ Controller / OS
 * @author Junior
 * Version : 1.0.0
 */
public class ControllerOS extends Controller implements IControllerOS {

    @Override
    public boolean validate(OS os) {
        if (os.getEquipamento().trim().isEmpty() || os.getEquipamento().length() > 50) {

            JOptionPane.showMessageDialog(null, "Preencha o campo equipamento corretamente! Máximo 50 caracteres",
                    "Equipamento inválido", JOptionPane.ERROR_MESSAGE);
            return false;

        }
        
        if (os.getDefeito().trim().isEmpty() || os.getDefeito().length() > 100) {

            JOptionPane.showMessageDialog(null, "Preencha o campo defeito corretamente! Máximo 100 caracteres",
                    "Defeito inválido", JOptionPane.ERROR_MESSAGE);
            return false;

        }
        
        if(os.getCliente().getId().toString().trim().isEmpty()) {
            
             JOptionPane.showMessageDialog(null, "Selecione um cliente para vincular a OS!",
                    "Cliente inválido", JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        
        return true;
    }

}
