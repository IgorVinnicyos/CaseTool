/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.IEquipeController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.equipe;
import model.rel_pessoa_equipe;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author igor-vinicyos
 */
public class EquipeController implements IEquipeController{

    private static EquipeController instance;
    
    public static synchronized EquipeController getInstance(){
        if(instance == null){
            instance = new EquipeController();
        }
        return instance;
    }
    
    @Override
    public boolean inserir(String nome) {
        try {
            
            equipe equipe = new equipe(nome);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(equipe);
            session.getTransaction().commit();
            session.close();
            javax.swing.JOptionPane.showMessageDialog(null, "Equipe salva com sucesso!");  
            return true;
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void atualizarNome(int idequipe, String nome) {
        try {
            
            equipe equipe = this.retornaEquipeById(idequipe);
            equipe.setNome_equipe(nome);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(equipe);
            session.getTransaction().commit();
            session.close();
          
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(int idequipe) {
        try {
           
                     
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @Override
    public equipe retornaEquipeById(int idequipe) {
        List<equipe> equipes = new ArrayList<equipe>();
        try {
      
            if (this.verificaEquipeById(idequipe)) {
                equipes = this.retornaListaEquipes();
                if (!equipes.isEmpty()) {
                    for (equipe equipe1 : equipes) {
                        if (equipe1.getIdequipe() == idequipe) {
                            System.out.println(equipe1.getNome_equipe());
                            return equipe1;
                        }
                    }
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique se o id de equipe: " + idequipe + " existe!");
            }
                     
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean verificaEquipeById(int idequipe) {
        List<equipe> equipes = new ArrayList<equipe>();
        try {
    
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getSessionFactory().openSession();
            equipes = session.createQuery("from equipe where idequipe = :idequipe").setParameter("idequipe", idequipe).list();
            session.close();
    
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (!equipes.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public List<equipe> retornaListaEquipes() {
        List<equipe> equipes = new ArrayList<equipe>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            equipes = session.createQuery("from equipe eqp order by eqp.nome_equipe asc").list();
            session.close();
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (!equipes.isEmpty()) {
            return equipes;
        }
        return null;
    }

    @Override
    public boolean inserirRelPessoasEquipe(int idpessoa, int idfuncao, int idequipe) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            boolean existeEqp = this.verificaEquipeById(idequipe);
            boolean existePes = PessoaController.getInstance().verificaPessoaById(idpessoa);
            boolean existeFun = FuncaoController.getInstance().verificaFuncaoById(idfuncao);

            if (existeEqp && existePes && existeFun) {
                rel_pessoa_equipe rel1 = new rel_pessoa_equipe(idpessoa, idequipe, idfuncao);
                session.beginTransaction();
                session.save(rel1);
                session.getTransaction().commit();
                session.close();
                return true;
            } else {
                if (!existeEqp) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique se o id de equipe: " + idequipe + " existe!");
                }
                if (!existeFun) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique se o id de funcao: " + idfuncao + " existe!");
                }
                if (!existePes) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique se o id de equipe: " + idequipe + " existe!");
                }
            }
                     
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<rel_pessoa_equipe> retornaListaDeRelPessoasEquipeByIdequipe(int idequipe) {
       try {
            if(this.verificaEquipeById(idequipe)){
                Session session = HibernateUtil.getSessionFactory().openSession();
                List<rel_pessoa_equipe> rel1 = new ArrayList<rel_pessoa_equipe>();
                session.beginTransaction();
                rel1 = session.createQuery("from rel_pessoa_equipe where idequipe = :idequipe").setParameter("idequipe", idequipe).list();
                session.close();
                if (!rel1.isEmpty()) {
                    return rel1;
                }
            }else{
                if(!this.verificaEquipeById(idequipe)){
                    javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique se o id de equipe: " + idequipe + " existe!");
                }
            }
                     
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }

    @Override
    public rel_pessoa_equipe retornaRelPessoaEqpByIdpessoa(int idpessoa) {
        try {
           if(PessoaController.getInstance().verificaPessoaById(idpessoa)){
                List<rel_pessoa_equipe> lista = new ArrayList<rel_pessoa_equipe>();
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                lista = session.createQuery("from rel_pessoa_equipe where idpessoa = :idpessoa").setParameter("idpessoa", idpessoa).list();
                session.close();
                
                if (!lista.isEmpty()) {
                    return lista.get(0);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Erro, relacionamento não encontrado, verifique ID!");
                }  
               
           }else if(!PessoaController.getInstance().verificaPessoaById(idpessoa)){
               javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique se o id da pessoa: " + idpessoa + " existe!");
           }
                     
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean verificaEquipeByNome(String nome) {
       List<equipe> equipes = new ArrayList<equipe>();
        try {
    
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.getSessionFactory().openSession();
            equipes = session.createQuery("from equipe where nome_equipe = :nome_equipe").setParameter("nome_equipe", nome).list();
            session.close();
    
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
         if (!equipes.isEmpty()) {
            return true;
        }
        return false;
    }
    
}
/*
 try {
           
                     
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }

*/