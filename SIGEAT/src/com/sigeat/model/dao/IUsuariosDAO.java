/*
 * Interface responsavel pelos métodos CRUD de Usuarios
 */

package com.sigeat.model.dao;

import com.sigeat.model.bean.Usuarios;
import java.util.List;

/*
 * SIGEAT/ Model / DAO / IUsuarios
 * @author Junior
 * Version : 1.0.0
 */

public interface IUsuariosDAO {
    
    public abstract Usuarios save(Usuarios usuario);
    
    public abstract Usuarios findById(Integer id);

    public abstract List<Usuarios> findAll();

    public abstract Usuarios remove(Integer id);

    public abstract List<Usuarios> findByNomeLike(String nome);
}
