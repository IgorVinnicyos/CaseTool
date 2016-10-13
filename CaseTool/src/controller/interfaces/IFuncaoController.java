/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaces;

import java.util.List;
import model.funcao;

/**
 *
 * @author igor-vinicyos
 */
public interface IFuncaoController {
    
    boolean inserir(String descricao);
    void atualizar(int idfuncao, String descricao);
    void deletar(int idfuncao);
    List<funcao> retornaListaFuncoes();
    boolean verificaFuncaoById(int idfuncao);
    funcao retornaFuncaoById(int idfuncao);
    
    
}
