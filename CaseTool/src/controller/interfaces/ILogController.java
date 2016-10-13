/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaces;

import java.util.List;
import model.log;

/**
 *
 * @author igor-vinicyos
 */
public interface ILogController {
    boolean inserir(int idrequisito, int idpessoa, String alteracoes);
    boolean novaVersaoRequsitoLog(log log, String alteracoes, int idpessoa);
    List<log> retornaListaLogByIdrequisito(int idrequisito);
    List<log> retornaListaLogByIdpessoa(int idpessoa);
}