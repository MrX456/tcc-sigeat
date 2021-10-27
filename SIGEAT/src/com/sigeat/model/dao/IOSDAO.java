/*
 * Interface responsavel pelos métodos CRUD de OS
 */
package com.sigeat.model.dao;

import com.sigeat.model.bean.OS;
import java.util.List;

/*
 * SIGEAT/ Model / DAO / IOS
 * @author Junior
 * Version : 1.0.0
 */
public interface IOSDAO {
    
    public abstract OS save(OS os);
    
    public abstract OS findById(Integer nmrOS);

    public abstract List<OS> findAll();

    public abstract OS remove(Integer nmrOS);

    public abstract List<OS> findByEquipamentoLike(String equipamento);
    
}
