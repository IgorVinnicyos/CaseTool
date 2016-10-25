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
public class pessoa {
    @Id
    @GeneratedValue
    private int idpessoa;
    private String nome;
    private boolean sexo;
    private int nivel_acesso;
    

    public pessoa(String nome, boolean sexo, int nivel_acesso) {
        this.nome = nome;
        this.sexo = sexo;
        this.nivel_acesso = nivel_acesso;
    }
    public pessoa(){
        
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public int getNivel_acesso() {
        return nivel_acesso;
    }

    public void setNivel_acesso(int nivel_acesso) {
        this.nivel_acesso = nivel_acesso;
    }
    
     @Override
    public String toString(){
        return this.getNome();
    }
}
