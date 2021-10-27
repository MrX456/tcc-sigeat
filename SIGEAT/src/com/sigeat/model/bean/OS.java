/*
 * Classe responsavel pelo mapeamento da tabela OS
 */

package com.sigeat.model.bean;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * SIGEAT/ Model / Bean / OS
 * @author Junior
 * Version : 1.0.0
 */

@Entity
public class OS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nmr_os;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dt_os;
    
    @Column(length = 15)
    private String tipo;
    
    @Column(length = 25)
    private String situacao;
    
    @Column(nullable = false, length = 50)
    private String equipamento;
    
    @Column(nullable = false, length = 100)
    private String defeito;
    
    @Column(length = 100)
    private String observacao;
    
    @Column(length = 100)
    private String servico;
    
    @Column(length = 50)
    private String tecnico;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal valor;
    
    @ManyToOne
    private Clientes cliente;

    public Integer getNmr_os() {
        return nmr_os;
    }

    public void setNmr_os(Integer nmr_os) {
        this.nmr_os = nmr_os;
    }

    public Date getDt_os() {
        return dt_os;
    }

    public void setDt_os(Date dt_os) {
        this.dt_os = dt_os;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

}   
