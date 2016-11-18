/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.util.List;
import model.log;
import model.requisito;

/**
 *
 * @author igor-vinicyos
 */
public interface IRelatorio {
  void gerarRelatorio(List<requisito> requisitos, List<log> logs);  
}
