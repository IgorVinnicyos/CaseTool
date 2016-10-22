/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaces;

import java.util.List;
import model.niveis_acesso;

/**
 *
 * @author matheus
 */
public interface iNiveisController {
    boolean cadastraNivel(String descricao);
    List<niveis_acesso> retornaNiveis();
    
}
