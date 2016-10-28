/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author matheus
 */
@Entity
public class projeto {
    @Id
    @GeneratedValue
    private int idprojeto;
    private Date data_entrada;
    private String descricao;
    private String nome;
    private boolean concluido;
    private Date data_inicio;
    private Date data_termino;
    private Date data_prazo;
    private int idequipe;

    private projeto(){
        
    }

    public projeto(String descricao, Date data_prazo, int idequipe, String nome) {
        this.descricao = descricao;
        this.data_prazo = data_prazo;
        this.idequipe = idequipe;
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_termino() {
        return data_termino;
    }

    public void setData_termino(Date data_termino) {
        this.data_termino = data_termino;
    }

    public Date getData_prazo() {
        return data_prazo;
    }

    public void setData_prazo(Date data_prazo) {
        this.data_prazo = data_prazo;
    }

    public int getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(int idequipe) {
        this.idequipe = idequipe;
    }

    public int getIdprojeto() {
        return idprojeto;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  this.nome;
    }
    
    
}
