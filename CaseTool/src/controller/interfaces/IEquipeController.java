/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaces;
import java.util.List;
import model.equipe;
import model.rel_pessoa_equipe;
/**
 *
 * @author igor-vinicyos
 */
public interface IEquipeController {
    boolean inserir(String nome);
    void atualizarNome(int idequipe, String nome);
    void deletar(int idequipe);
    equipe retornaEquipeById(int idequipe);
    boolean verificaEquipeById(int idequipe);
    List<equipe> retornaListaEquipes();
    boolean inserirRelPessoasEquipe(int idpessoa, int idfuncao, int idequipe);
    List<rel_pessoa_equipe> retornaListaDeRelPessoasEquipeByIdequipe(int idequipe);
    rel_pessoa_equipe retornaRelPessoaEqpByIdpessoa(int idpessoa);
}
