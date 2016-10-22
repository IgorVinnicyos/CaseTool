/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.IProjetoController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.projeto;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author igor-vinicyos
 */
public class ProjetoController implements IProjetoController{
    
    private static ProjetoController instance;
    
    public static synchronized ProjetoController getInstance(){
        if(instance == null){
            instance = new ProjetoController();
        }
        return instance;
    }
    
    @Override
    public boolean inserir(String descricao, Date data_prazo, int idequipe, String nome) {
        try {
            if (EquipeController.getInstance().verificaEquipeById(idequipe)) {
                if (!descricao.isEmpty()) {
                    projeto projeto = new projeto(descricao, data_prazo, idequipe, nome);
                    Session session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    session.save(projeto);
                    session.getTransaction().commit();
                    session.close();
                    javax.swing.JOptionPane.showMessageDialog(null, "Projeto salvo com sucesso! ID de projeto: " + projeto.getIdprojeto());
                    return true;
                }
            }else {
                if (!EquipeController.getInstance().verificaEquipeById(idequipe)) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique se a equipe existe!");
                }
                if (descricao.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Forneça uma descrição!");
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void atualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(int idprojeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificaProjetoById(int idprojeto) {
        List<projeto> projetos = new ArrayList<projeto>();
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            projetos = session.createQuery("from projeto where idprojeto = :idprojeto").setParameter("idprojeto", idprojeto).list();
            session.close();
           
        } catch (Exception ex) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       if (!projetos.isEmpty()) {
            return true;
       }
       return false; 
    }

    @Override
    public projeto retornaProjetoById(int idprojeto) {
        List<projeto> projetos;
        try {
            
            if (this.verificaProjetoById(idprojeto)) {
                projetos = this.retornaListaProjetos();
                if (!projetos.isEmpty()) {
                    for (projeto projeto1 : projetos) {
                        if (projeto1.getIdprojeto() == idprojeto) {
                            return projeto1;
                        }
                    }
                }
                
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Nenhum projeto encontrado para este ID!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<projeto> retornaListaProjetos() {
        List<projeto> projetos = new ArrayList<projeto>();
        try {
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            projetos = session.createQuery("from projeto").list();
            session.close();
            
        } catch (Exception ex) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (!projetos.isEmpty()) {
            return projetos;
        }
        return null;
    }

    @Override
    public List<projeto> retornaListaProjetosByIdEquipe(int idequipe) {
        List<projeto> listaRetorno = new ArrayList<projeto>();
        List<projeto> projetos;
        try {
            
            if (EquipeController.getInstance().verificaEquipeById(idequipe)) {
                projetos = this.retornaListaProjetos();
                if (!projetos.isEmpty()) {
                    for (projeto projeto1 : projetos) {
                        if (projeto1.getIdequipe() == idequipe) {
                            listaRetorno.add(projeto1);
                        }
                    }
                }
                if (!listaRetorno.isEmpty()) {
                    return listaRetorno;
                }

            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Nenhum projeto encontrado para este ID de equipe!");
            }
        } catch (Exception ex) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }

    @Override
    public boolean verificaProjetoByNome(String nome) {
       List<projeto> projetos = new ArrayList<projeto>();
        try {

            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            projetos = session.createQuery("from projeto where nome = :nome").setParameter("nome", nome).list();
            session.close();
           
        } catch (Exception ex) {
            Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       if (!projetos.isEmpty()) {
            return true;
       }
       return false; 
    }
    
}
/*

try {
            
} catch (Exception ex) {
    Logger.getLogger(ProjetoController.class.getName()).log(Level.SEVERE, null, ex);
}
*/

       