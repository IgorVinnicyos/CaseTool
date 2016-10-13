/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ILogController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.log;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author igor-vinicyos
 */
public class LogController implements ILogController{
    private static LogController instance;
    
    public static synchronized LogController getInstance(){
        if(instance == null){
            instance = new LogController();
        }
        return instance;
    }

    @Override
    public boolean inserir(int idrequisito, int idpessoa, String alteracoes) {
        try {
           if (RequisitoController.getInstance().verificaRequisitoById(idrequisito) && PessoaController.getInstance().verificaPessoaById(idpessoa)) {
               
                log log = new log(idrequisito, idpessoa, alteracoes);
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                session.save(log);
                session.getTransaction().commit();
                session.close();
                return true;
                
            } else {
                if (!RequisitoController.getInstance().verificaRequisitoById(idrequisito)) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique id de requisito!");
                }
                if (!PessoaController.getInstance().verificaPessoaById(idpessoa)) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique id de pessoa!");
                }
            }
                     
        } catch (Exception ex) {
            Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean novaVersaoRequsitoLog(log log, String alteracoes, int idpessoa) {
        try {
           if (PessoaController.getInstance().verificaPessoaById(idpessoa)) {
            log newlog = log.clone();
            newlog.setAlteracoes(alteracoes);
            newlog.setIdpessoa(idpessoa);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(log);
            session.close();
            return true;
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique id de pessoa!");
        }          
        } catch (Exception ex) {
            Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<log> retornaListaLogByIdrequisito(int idrequisito) {
        try {
           List<log> logs = new ArrayList<log>();
           if (RequisitoController.getInstance().verificaRequisitoById(idrequisito)) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                logs = session.createQuery("from requisito where idrequisito = :idrequisito").setParameter("idrequisito", idrequisito).list();
                session.close();
                if (!logs.isEmpty()) {
                    return logs;
                }
           } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique se este requisito existe!");
           }       
        } catch (Exception ex) {
            Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<log> retornaListaLogByIdpessoa(int idpessoa) {
       
        try {
           List<log> logs = new ArrayList<log>();
           List<log> listaRetorno = new ArrayList<log>();
           if (PessoaController.getInstance().verificaPessoaById(idpessoa)) {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                logs = session.createQuery("from log where idpessoa = :idpessoa").setParameter("idpessoa", idpessoa).list();
                session.close();
                if (!logs.isEmpty()) {
                    for (log log1 : logs) {
                        if (log1.getIdpessoa() == idpessoa) {
                            listaRetorno.add(log1);
                        }
                    }
                }
                if (!listaRetorno.isEmpty()) {
                    return listaRetorno;
                }
           }else {
                javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique se este id existe!");
           }
                     
        } catch (Exception ex) {
            Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
}
/*
try {
           
                     
        } catch (Exception ex) {
            Logger.getLogger(LogController.class.getName()).log(Level.SEVERE, null, ex);
        }
*/


