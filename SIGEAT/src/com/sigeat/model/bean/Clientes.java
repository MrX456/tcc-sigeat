/*
 * Classe responsavel pelo mapeamento da tabela Clientes
 * Subclasse de Pessoas
 */

package com.sigeat.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;

/*
 * SIGEAT/ Model / Bean / Clientes
 * @author Junior
 * Version : 1.0.0
 */

@Entity
public class Clientes extends Pessoas {
    
    @Column(nullable = false, length = 150)
    private String endereco;
    
    @Column(nullable = false, length = 15)
    private String telefone;
    
    @Column(length = 50)
    private String email;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
       
}
