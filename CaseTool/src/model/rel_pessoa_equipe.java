/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.PessoaController;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author matheus
 */
@Entity
public class rel_pessoa_equipe {
    @Id
    @GeneratedValue
    private int id_rel_pes_eqp;
    private int idpessoa;
    private int idequipe;
    private int idfuncao;

    private rel_pessoa_equipe(){
        
    }
    
    public rel_pessoa_equipe(int idpessoa, int idequipe, int idfuncao) {
        this.idpessoa = idpessoa;
        this.idequipe = idequipe;
        this.idfuncao = idfuncao;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public int getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(int idquipe) {
        this.idequipe = idquipe;
    }

    public int getIdfuncao() {
        return idfuncao;
    }

    public void setIdfuncao(int idfuncao) {
        this.idfuncao = idfuncao;
    }

    @Override
    public String toString() {
        return PessoaController.getInstance().retornaPessoaById(idpessoa).getNome();
    }
    
    
}
