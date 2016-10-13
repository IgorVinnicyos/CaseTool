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
public class log {
    @Id
    @GeneratedValue
    private int idlog;
    private int idrequisito;
    private int idpessoa;
    private int versao;
    private String alteracoes;
    private Date data_modificacao;
    
    private log(){
        
    }

    public log(int idrequisito, int idpessoa, String alteracoes) {
        this.idrequisito = idrequisito;
        this.idpessoa = idpessoa;
        this.versao = 1;
        this.alteracoes = alteracoes;
    }
    
    public log clone(){
        log log = new log();
        log.setIdrequisito(this.idrequisito);
        log.setVersao(versao+1);
        return log;
    }

    public int getIdrequisito() {
        return idrequisito;
    }

    public void setIdrequisito(int idrequisito) {
        this.idrequisito = idrequisito;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public int getVersao() {
        return versao;
    }

    public void setVersao(int versao) {
        this.versao = versao;
    }

    public String getAlteracoes() {
        return alteracoes;
    }

    public void setAlteracoes(String alteracoes) {
        this.alteracoes = alteracoes;
    }
    
    
}
