/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author matheus
 */
@Entity
public class funcao {
    @Id
    @GeneratedValue
    private int idfuncao;
    private String descricao;

    public funcao(String descricao) {
        this.descricao = descricao;
    }
    
    private funcao(){
        
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdfuncao() {
        return idfuncao;
    }
    
    
    
}
