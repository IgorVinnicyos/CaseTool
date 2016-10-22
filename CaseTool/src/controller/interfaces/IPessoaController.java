/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaces;

import java.util.List;
import model.pessoa;

/**
 *
 * @author igor-vinicyos
 */
public interface IPessoaController {
    
     boolean inserir(String nome, boolean sexo, int nivel_acesso);
     void deletar(int idpessoa);
     void atualizar(int idpessoa, String nome, boolean sexo);
     pessoa retornaPessoaById(int idpessoa);
     boolean verificaPessoaById(int idpessoa);
     List<pessoa> retornaListaPessoas();
}
