/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.IPessoaController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.pessoa;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author igor-vinicyos
 */
public class PessoaController implements IPessoaController{
   
    private static PessoaController instance;
  
    public static synchronized PessoaController getInstance(){
        if(instance == null){
            instance = new PessoaController();
        }
        return instance;
    }

    @Override
    public boolean inserir(String nome, boolean sexo) {
      try{
            
            pessoa pessoa = new pessoa(nome, sexo);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(pessoa);
            session.getTransaction().commit();
            session.close();
            
            JOptionPane.showMessageDialog(null, "Pessoa salva com sucesso!");
            return true;
            
      }catch(Exception ex){
         Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
      }
      return false;
    }

    @Override
    public void deletar(int idpessoa) {
      try{
          pessoa pessoa = this.retornaPessoaById(idpessoa);
          Session session = HibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          session.delete(pessoa);
          session.close();
      }catch(Exception ex){
         Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
      }
    }

    @Override
    public void atualizar(int idpessoa,String nome, boolean sexo) {
      try{
          pessoa pessoa = this.retornaPessoaById(idpessoa);
          pessoa.setNome(nome);
          pessoa.setSexo(sexo);
          Session session = HibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();
          session.update(pessoa);
          session.close();
      }catch(Exception ex){
         Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
      }  
    }

    @Override
    public pessoa retornaPessoaById(int idpessoa) {
      pessoa pessoa = new pessoa();
      try{
         
           if (this.verificaPessoaById(idpessoa)) {
                List<pessoa> pessoas = this.retornaListaPessoas();
                if (!pessoas.isEmpty()) {
                    for (pessoa pessoa1 : pessoas) {
                        if (pessoa1.getIdpessoa() == idpessoa) {
                            return pessoa1;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Erro, verifique id de pessoa!");
            }

            return null;
          
      }catch(Exception ex){
         Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
      }
      return pessoa;
    }


    @Override
    public boolean verificaPessoaById(int idpessoa) {
        List<pessoa> pessoas = new ArrayList<pessoa>();
        try{
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getSessionFactory().openSession();
            pessoas = session.createQuery("from pessoa where idpessoa = :idpessoa").setParameter("idpessoa", idpessoa).list();
            session.close();
        
        }catch(Exception ex){
            Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!pessoas.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public List<pessoa> retornaListaPessoas() {
         List<pessoa> pessoas = new ArrayList<pessoa>();
        try {
              Session session = HibernateUtil.getSessionFactory().openSession();
              session.beginTransaction();
              pessoas = session.createQuery("from pessoa").list();
              session.close();
             
        } catch (Exception ex) {
            Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if (!pessoas.isEmpty()) {
                  return pessoas;
              }
         return null;
    }

  
    
}
