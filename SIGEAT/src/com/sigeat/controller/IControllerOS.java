/*
 * Interface responsavel pelos métodos de controle de OS
 */

package com.sigeat.controller;

import com.sigeat.model.bean.OS;

/*
 * SIGEAT/ Controller / IOS
 * @author Junior
 * Version : 1.0.0
 */

public interface IControllerOS {
    
    public abstract boolean validate(OS os);
    
}
