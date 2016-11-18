/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.log;
import model.requisito;

/**
 *
 * @author igor-vinicyos
 */
public class Relatorio implements IRelatorio{

    @Override
    public void gerarRelatorio(List<requisito> requisitos, List<log> logs) {
        try {
   
            
        } catch (Exception e) {
             Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
