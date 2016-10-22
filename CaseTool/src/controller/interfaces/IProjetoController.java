/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaces;

import java.util.Date;
import java.util.List;
import model.projeto;

/**
 *
 * @author igor-vinicyos
 */
public interface IProjetoController {
    
    boolean inserir(String descricao, Date data_prazo, int idequipe, String nome);
    void atualizar();
    void deletar(int idprojeto);
    boolean verificaProjetoById(int idprojeto);
    projeto retornaProjetoById(int idprojeto);
    List<projeto> retornaListaProjetos();
    List<projeto> retornaListaProjetosByIdEquipe(int idequipe);
    boolean verificaProjetoByNome(String nome);
        
}
