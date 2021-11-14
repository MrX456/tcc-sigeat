/*
 * Classe responsavel pela implementação dos métodos de controle gerais
 */

package com.sigeat.controller;

/*
 * SIGEAT/ Controller
 * @author Junior
 * Version : 1.0.0
 */

public class Controller implements IController {

    @Override
    public boolean reachMaxLength(int maxLength, String text) {
        
        //Limitar o numero de caracteres em cada caixa de texto
        if (text.trim().length() > maxLength) {
            return true;
        } else {
            return false;
        }
        
    }

    @Override
    public boolean isNumber(String text) {
        try {
            Integer.parseInt(text);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean isDouble(String text) {
         try {
            Double.parseDouble(text);
            return true;
        }
        catch(NumberFormatException e) {
            return false;
        }
    }
    
}
