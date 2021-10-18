/*
 * Interface responsavel pelos métodos de controle de Clientes
 */

package com.sigeat.controller;

import com.sigeat.model.bean.Clientes;

/*
 * SIGEAT/ Controller / IClientes
 * @author Junior
 * Version : 1.0.0
 */

public interface IControllerClientes {
    
    public abstract boolean validate(Clientes cliente);
    
}
