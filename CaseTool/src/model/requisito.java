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
public class requisito {
    @Id
    @GeneratedValue
    private int idrequisito;
    private boolean concluido;
    private int tempo_estimado;
    private String descricao;
    private Date data_inicio;
    private Date data_termino;
    private int idprojeto;
    private String tipo_requisito;
    private int cod_req;

    public requisito(int tempo_estimado, String descricao, int idprojeto, String tipo_requisito) {
        this.tempo_estimado = tempo_estimado;
        this.descricao = descricao;
        this.idprojeto = idprojeto;
        this.data_inicio = data_inicio;
        this.data_termino = data_termino;
        this.tipo_requisito = tipo_requisito;
        this.cod_req = cod_req;
    }
    
    private requisito(){
        
    }

    public void setCod_req(int cod_req) {
        this.cod_req = cod_req;
    }
    
    

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }

    public int getTempo_estimado() {
        return tempo_estimado;
    }

    public void setTempo_estimado(int tempo_estimado) {
        this.tempo_estimado = tempo_estimado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public int getIdprojeto() {
        return idprojeto;
    }

    public void setIdprojeto(int idprojeto) {
        this.idprojeto = idprojeto;
    }

    public int getIdrequisito() {
        return idrequisito;
    }

    public int getCod_req() {
        return cod_req;
    }

    public String getTipo_requisito() {
        return tipo_requisito;
    }
    
    public String getCodigoFormatado(){
        String cod_formatado = "";
        if(this.cod_req < 10){
            cod_formatado = this.tipo_requisito+" 00"+cod_req;
        }else if(this.cod_req >=10 && this.cod_req < 100){
            cod_formatado = this.tipo_requisito+" 0"+cod_req;
        }
        return cod_formatado;
    }
    @Override
    public String toString() {
        return getCodigoFormatado(); 
    }
    
    
    
}
