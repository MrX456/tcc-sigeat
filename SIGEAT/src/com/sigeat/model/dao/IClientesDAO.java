/*
 * Interface responsavel pelos métodos CRUD de Clientes
 */

package com.sigeat.model.dao;

import com.sigeat.model.bean.Clientes;
import java.util.List;

/*
 * SIGEAT/ Model / DAO / IClientes
 * @author Junior
 * Version : 1.0.0
 */

public interface IClientesDAO {
    
    public abstract Clientes save(Clientes cliente);
    
    public abstract Clientes findById(Integer id);

    public abstract List<Clientes> findAll();

    public abstract Clientes remove(Integer id);

    public abstract List<Clientes> findByNomeLike(String nome);
    
}
