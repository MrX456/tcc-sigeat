/*
 * Interface responsavel pelos métodos de controle aplicáveis a todos objetos
 */

package com.sigeat.controller;

/*
 * SIGEAT/ IController
 * @author Junior
 * Version : 1.0.0
 */

public interface IController {
    
    public abstract boolean reachMaxLength(int maxLength, String text);
    
}
