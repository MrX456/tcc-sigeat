/*
 * Classe responsavel pela implementação dos métodos de controle de OS
 */
package com.sigeat.controller;

import com.sigeat.model.bean.OS;

/*
 * SIGEAT/ Controller / OS
 * @author Junior
 * Version : 1.0.0
 */
public class ControllerOS extends Controller implements IControllerOS {

    @Override
    public boolean validate(OS os) {
        if (os.getEquipamento().trim().isEmpty() || os.getEquipamento().length() > 50) {

            //MESSAGE HERE
            return false;

        }
        
        if (os.getDefeito().trim().isEmpty() || os.getDefeito().length() > 100) {

            //MESSAGE HERE
            return false;

        }
        
        if(os.getCliente().getId().toString().trim().isEmpty()) {
            
             //MESSAGE HERE
            return false;
            
        }
        
        return true;
    }

}
