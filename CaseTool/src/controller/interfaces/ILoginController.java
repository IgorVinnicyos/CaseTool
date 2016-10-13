/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.interfaces;

/**
 *
 * @author igor-vinicyos
 */
public interface ILoginController {
    
    boolean inserir(int idpessoa, String email, String senha);
    void atualizar(int idpessoa, String email, String senha);
    void deletar(int idpessoa);
    boolean autenticar(String email, String senha);
}
