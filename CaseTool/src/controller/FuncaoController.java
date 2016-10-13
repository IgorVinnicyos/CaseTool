/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.IFuncaoController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.funcao;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author igor-vinicyos
 */
public class FuncaoController implements IFuncaoController{

    private static FuncaoController instance;
    
    public static synchronized FuncaoController getInstance(){
        if(instance == null){
            instance = new FuncaoController();
        }
        return instance;
    }
    
    @Override
    public boolean inserir(String descricao) {
        try {
            
            funcao funcao  = new funcao(descricao);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(funcao);
            session.getTransaction().commit();
            session.close();
            javax.swing.JOptionPane.showMessageDialog(null, "Função salva com sucesso!");
            return true;
            
        }catch(Exception ex) {
             Logger.getLogger(FuncaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void atualizar(int idfuncao, String descricao) {
        try {
            funcao funcao = this.retornaFuncaoById(idfuncao);
            funcao.setDescricao(descricao);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(funcao);
            session.getTransaction().commit();
            session.close();
        }catch(Exception ex) {
             Logger.getLogger(FuncaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(int idfuncao) {
        try {
            
        }catch(Exception ex) {
             Logger.getLogger(FuncaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<funcao> retornaListaFuncoes() {
        List<funcao> funcoes = new ArrayList<funcao>();
        
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            funcoes = session.createQuery("from funcao").list();
            session.close();
       
        }catch(Exception ex) {
             Logger.getLogger(FuncaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!funcoes.isEmpty()) {
            return funcoes;
        }
        return null;
    }

    @Override
    public boolean verificaFuncaoById(int idfuncao) {
        List<funcao> funcoes = new ArrayList<funcao>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getSessionFactory().openSession();
            funcoes = session.createQuery("from funcao where idfuncao = :idfuncao").setParameter("idfuncao", idfuncao).list();
            session.close();
        
        }catch(Exception ex) {
             Logger.getLogger(FuncaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!funcoes.isEmpty()) {
            return true;
        }
        return false; 
    }

    @Override
    public funcao retornaFuncaoById(int idfuncao) {
       List<funcao> funcoes = this.retornaListaFuncoes();
        try {
            if (this.verificaFuncaoById(idfuncao)) {
                if (!funcoes.isEmpty()) {
                    for (funcao funcao1 : funcoes) {
                        if (funcao1.getIdfuncao() == idfuncao) {
                            return funcao1;
                        }
                    }
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique se o id de funcao: " + idfuncao + " existe!");
            }
        }catch(Exception ex) {
             Logger.getLogger(FuncaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;        
    } 
    
    
}
