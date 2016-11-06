/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.PessoaController;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author matheus
 */
@Entity
public class rel_pessoa_requisito {

    @Id
    @GeneratedValue
    private int id_rel_pes_req;
    private int idrequisito;
    private int idpessoa;
    private String descricao_atividade;
    private Date data_inicio;
    private Date data_termino;
    private Date tempo;
    private double custo;
    
    private rel_pessoa_requisito(){
        
    }

    public rel_pessoa_requisito(int idrequisito, int idpessoa, String descricao_atividade, Date tempo, double custo) {
        this.idrequisito = idrequisito;
        this.idpessoa = idpessoa;
        this.descricao_atividade = descricao_atividade;
        this.tempo = tempo;
        this.custo = custo;
    
    }
    public rel_pessoa_requisito(int idrequisito, int idpessoa, String descricao_atividade) {
        this.idrequisito = idrequisito;
        this.idpessoa = idpessoa;
        this.descricao_atividade = descricao_atividade;
        
       
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

    public String getDescricao_atividade() {
        return descricao_atividade;
    }

    public void setDescricao_atividade(String descricao_atividade) {
        this.descricao_atividade = descricao_atividade;
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

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getId_rel_pes_req() {
        return id_rel_pes_req;
    }

    @Override
    public String toString(){
        return PessoaController.getInstance().retornaPessoaById(idpessoa).getNome();
    }
    
    
    
}
