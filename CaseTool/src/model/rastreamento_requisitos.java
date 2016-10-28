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
public class rastreamento_requisitos {
    @Id
    @GeneratedValue
    private int idtupla;
    private int idprojeto;
    private int idrequisito;
    private int id_dep_req;
    
    private rastreamento_requisitos(){
        
    }
    
    public rastreamento_requisitos(int idprojeto, int idrequisito, int id_dep_req){
        this.idprojeto = idprojeto;
        this.idrequisito = idrequisito;
        this.id_dep_req = id_dep_req;
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

    public void setIdrequisito(int idrequisito) {
        this.idrequisito = idrequisito;
    }

    public int getId_dep_req() {
        return id_dep_req;
    }

    public void setId_dep_req(int id_dep_req) {
        this.id_dep_req = id_dep_req;
    }

    public int getIdtupla() {
        return idtupla;
    }
    
    
}
