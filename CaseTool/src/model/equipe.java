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
public class equipe {
    @Id
    @GeneratedValue
    private int idequipe;
    private String nome_equipe;
    private Date data_criacao;

    public equipe(String nome_equipe) {
        this.nome_equipe = nome_equipe;
    }
    
    private equipe(){
        
    }

    public String getNome_equipe() {
        return nome_equipe;
    }

    public void setNome_equipe(String nome_equipe) {
        this.nome_equipe = nome_equipe;
    }

    
    public int getIdequipe() {
        return idequipe;
    }

    @Override
    public String toString() {
        return getNome_equipe();
    }

    public Date getData_criacao() {
        return data_criacao;
    }
    
    
    
}
