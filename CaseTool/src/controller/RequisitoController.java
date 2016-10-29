/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.IRequisitoController;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.log;
import model.rel_pessoa_requisito;
import model.requisito;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author igor-vinicyos
 */
public class RequisitoController implements IRequisitoController{
    private static requisito requisitoInserido;
    private static RequisitoController instance;
    
    public static synchronized RequisitoController getInstance(){
        if(instance == null){
            instance = new RequisitoController();
        }
        return instance;
    }
    
    @Override
    public boolean inserir(int tempo_estimado, String descricao, int idprojeto, Date data_inicio, Date data_termino, String tipo_requisito, int cod_requisito,
    int idpessoa, String desc_Atividade
    ){
        try {
           if (ProjetoController.getInstance().verificaProjetoById(idprojeto)) {
               
                requisito requisito = new requisito(tempo_estimado, descricao, idprojeto, data_inicio, data_termino, tipo_requisito, cod_requisito);
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(requisito);
                session.getTransaction().commit();
                session.close();
                this.InserirRelPessoaRequisito(requisito.getIdrequisito(),idpessoa,desc_Atividade);
                this.requisitoInserido = requisito;
                javax.swing.JOptionPane.showMessageDialog(null, "Requisito salvo com sucesso!");
              
                return true;
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique ID de projeto!");
            }
                     
        } catch (Exception ex) {
            Logger.getLogger(RequisitoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void deletar(int idrequisito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificaRequisitoById(int idrequisito) {
        List<requisito> requisito = new ArrayList<requisito>();
        try {
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            requisito = session.createQuery("from requisito where idrequisito = :idrequisito").setParameter("idrequisito", idrequisito).list();
            session.close();
                      
        } catch (Exception ex) {
            Logger.getLogger(RequisitoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!requisito.isEmpty()) {
             return true;
         }   
        return false;
    }

    @Override
    public requisito retornaRequisitoById(int idrequisito) {
        List<requisito> requisitos = new ArrayList<requisito>();
        try {
            
            requisito requisito;
            if (this.verificaRequisitoById(idrequisito)) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                requisitos = session.createQuery("from requisito where idrequisito = :idrequisito").list();
                session.close();
                if (!requisitos.isEmpty()) {
                    requisito = requisitos.get(0);
                    return requisito;
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum requisito para este ID!");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(RequisitoController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }

    @Override
    public List<requisito> retornaListaRequisitosByIdprojeto(int idprojeto) {
        List<requisito> requisitos = new ArrayList<requisito>();
        try {
            
          if (ProjetoController.getInstance().verificaProjetoById(idprojeto)) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                requisitos = session.createQuery("from requisito where idprojeto = :idprojeto").setParameter("idprojeto", idprojeto).list();
                session.close();
                if (!requisitos.isEmpty()) {
                    return requisitos;
                }
          } else {
             javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique o id de projeto!");
          }   
                     
        } catch (Exception ex) {
            Logger.getLogger(RequisitoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }

    @Override
    public boolean InserirRelPessoaRequisito(int idrequisito, int idpessoa, String descricao_atividade ) {
        try {
            
            if (this.verificaRequisitoById(idrequisito) && PessoaController.getInstance().verificaPessoaById(idpessoa)) {
             
                rel_pessoa_requisito rel1 = new rel_pessoa_requisito(idrequisito, idpessoa, descricao_atividade);
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(rel1);
                session.getTransaction().commit();
                session.close();
                return true;
             
             } else {
                 if (!this.verificaRequisitoById(idrequisito)) {
                     javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique id de requisito!");
                 }
                 if (!PessoaController.getInstance().verificaPessoaById(idpessoa)) {
                     javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique id de pessoa!");
                 }
             }
                
        } catch (Exception ex) {
            Logger.getLogger(RequisitoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<rel_pessoa_requisito> retornaListPesReqByIDpes(int idpessoa) {
        
        try {
            List<rel_pessoa_requisito> rel1 = new ArrayList<rel_pessoa_requisito>();
            if (PessoaController.getInstance().verificaPessoaById(idpessoa)) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                rel1 = session.createQuery("from rel_pessoa_requisito where idpessoa = :idpessoa").setParameter("idpessoa", idpessoa).list();
                session.close();
                if (!rel1.isEmpty()) {
                    return rel1;
                }
            } else if (!PessoaController.getInstance().verificaPessoaById(idpessoa)) {
                javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique id de pessoa!");
            }
                     
        } catch (Exception ex) {
            Logger.getLogger(RequisitoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<rel_pessoa_requisito> retornaListPesReqByIDProj(int idprojeto) {
        try {
            List<rel_pessoa_requisito> rel1 = new ArrayList<rel_pessoa_requisito>();
            if (ProjetoController.getInstance().verificaProjetoById(idprojeto)) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                rel1 = session.createQuery("from requisito where idprojeto = :idprojeto").setParameter("idprojeto", idprojeto).list();
                session.close();
                if (!rel1.isEmpty()) {
                    return rel1;
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Erro, verfique o id de projeto!");
            }             
        } catch (Exception ex) {
            Logger.getLogger(RequisitoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public rel_pessoa_requisito retornaRelPesReqByIdRel(int id_rel_pes_req) {
        try {
            List<rel_pessoa_requisito> lista = new ArrayList<rel_pessoa_requisito>();
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            lista = session.createQuery("from rel_pessoa_requisito where id_rel_pes_req = :id_rel_pes_req").setParameter("id_rel_pes_req", id_rel_pes_req).list();
            session.close();
            if (!lista.isEmpty()) {
                return lista.get(0);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Erro, relacionamento não encontrado, verifique ID!");
            }           
        } catch (Exception ex) {
            Logger.getLogger(RequisitoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public requisito getReqInserido() {
        return this.requisitoInserido;
    }
    
}


/*
try {
           
                     
        } catch (Exception ex) {
            Logger.getLogger(RequisitoController.class.getName()).log(Level.SEVERE, null, ex);
        }
*/  

