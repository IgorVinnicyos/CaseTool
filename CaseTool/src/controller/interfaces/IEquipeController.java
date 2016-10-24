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
    List<rel_pessoa_equipe> retornaListaDeRelPessoasEquipeByIdfuncao(int idfuncao);
    rel_pessoa_equipe retornaRelPessoaEqpByIdpessoa(int idpessoa);
    boolean verificaPessoaOcupada(int idpessoa, int idequipe);
    boolean verificaEquipeByNome(String nome);
    boolean verificaFuncaoEmUso(int idfuncao);
}
