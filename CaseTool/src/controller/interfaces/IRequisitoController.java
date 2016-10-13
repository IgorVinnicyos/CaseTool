/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaces;

import java.util.Date;
import java.util.List;
import model.rel_pessoa_requisito;
import model.requisito;

/**
 *
 * @author igor-vinicyos
 */
public interface IRequisitoController {
    boolean inserir(String tempo_estimado, String descricao, int idprojeto);
    void deletar(int idrequisito);
    boolean verificaRequisitoById(int idrequisito);
    requisito retornaRequisitoById(int idrequisito);
    List<requisito> retornaListaRequisitosByIdprojeto(int idprojeto);
    boolean InserirRelPessoaRequisito(int idrequisito, int idpessoa, String descricao_atividade, Date tempo, double custo);
    List<rel_pessoa_requisito> retornaListPesReqByIDpes(int idpessoa);
    List<rel_pessoa_requisito> retornaListPesReqByIDProj(int idprojeto);
    rel_pessoa_requisito retornaRelPesReqByIdRel(int id_rel_pes_req);
}
