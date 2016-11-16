/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaces;

import java.util.Date;
import java.util.List;
import model.pessoa;
import model.rel_pessoa_requisito;
import model.requisito;

/**
 *
 * @author igor-vinicyos
 */
public interface IRequisitoController {

    boolean inserir(int tempo_estimado, String descricao, int idprojeto, String tipo_requisito, String restricoes, String Expectativas, int prioridade);

    void deletar(int idrequisito);

    boolean verificaRequisitoById(int idrequisito);

    requisito retornaRequisitoById(int idrequisito);

    List<requisito> retornaListaRequisitosByIdprojeto(int idprojeto);

    boolean InserirRelPessoaRequisito(int idrequisito, int idpessoa, String descricao_atividade);

    List<rel_pessoa_requisito> retornaListPesReqByIDpes(int idpessoa);

    List<rel_pessoa_requisito> retornaListPesReqByIDProj(int idprojeto);

    rel_pessoa_requisito retornaRelPesReqByIdRel(int id_rel_pes_req);

    requisito getReqInserido();

    requisito retornaRequisitoByCod(String tipo, int cod);

    boolean verificaRequisitoByCod(String tipo_requisito, int cod_req);

    List<requisito> retornaListRequisitoByTipo(String tipo_requisito, int idprojeto);

    boolean atualizarRequisito(requisito req, String comentario);

    int geraNovoCodigo(String tipo_requisito, int idprojeto);

    List<rel_pessoa_requisito> retornaListPesReqByIDReq(int idrequisito);
    
    boolean AtualizaRelPessoaRequisito(rel_pessoa_requisito rel, String comentario);

}
