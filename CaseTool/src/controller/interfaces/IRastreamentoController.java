/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaces;

import java.util.List;
import model.rastreamento_requisitos;
import model.requisito;

/**
 *
 * @author matheus
 */
public interface IRastreamentoController {
    boolean gravarDependente(int idprojeto, int idrequisito, List<requisito> listaRequisitos);
    List<requisito> retornarAnteriores (int idprojeto, int idrequisito);
    List<requisito> retornarPosteriores (int idprojeto, int id_dep_req);
    boolean apagarDependente(int idprojeto, int idrequisito, int id_req_dep);
    boolean verificaPermissao(int idprojeto, int idpessoa, int idfuncao);
}
