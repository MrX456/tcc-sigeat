/*
 * Interface responsavel pelos métodos de controle de Usuarios
 */

package com.sigeat.controller;

import com.sigeat.model.bean.Usuarios;

/*
 * SIGEAT/ Controller / IUsuario
 * @author Junior
 * Version : 1.0.0
 */

public interface IControllerUsuarios {

    public abstract boolean validate(Usuarios usuario);

}
