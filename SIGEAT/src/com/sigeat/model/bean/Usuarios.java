/*
 * Classe responsavel pelo mapeamento da tabela Usuarios
 * Subclasse de Pessoas
 */

package com.sigeat.model.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/*
 * SIGEAT/ Model / Bean / Usuarios
 * @author Junior
 * Version : 1.0.0
 */

@Entity
public class Usuarios extends Pessoas implements Serializable {
    
    @Column(nullable = false, length = 15)
    private String login;
    
    @Column(nullable = false, length = 15)
    private String senha;
    
    @Column(length = 20)
    private String perfil;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
}
