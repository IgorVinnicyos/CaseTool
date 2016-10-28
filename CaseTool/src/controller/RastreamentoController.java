/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.rastreamento_requisitos;
import model.requisito;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author matheus
 */
public class RastreamentoController implements controller.interfaces.IRastreamentoController {

    private static RastreamentoController instance;

    private RastreamentoController() {

    }

    public static synchronized RastreamentoController getInstance() {
        if (instance == null) {
            instance = new RastreamentoController();
        }
        return instance;
    }

    @Override
    public boolean gravarDependente(int idprojeto, int idrequisito, List<rastreamento_requisitos> listaRequisitos) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        rastreamento_requisitos rast;
        try {
            if (ProjetoController.getInstance().verificaProjetoById(idprojeto)) {
                if (RequisitoController.getInstance().verificaRequisitoById(idrequisito)) {
                    if (listaRequisitos.isEmpty() || listaRequisitos == null) {
                        javax.swing.JOptionPane.showMessageDialog(null, "Erro, espeficique os requisitos dos quais este depente!");
                    } else {
                        session.beginTransaction();
                        for (rastreamento_requisitos atual : listaRequisitos) {
                            rast = atual;
                            session.save(atual);
                        }
                        session.getTransaction().commit();
                        session.close();
                        return true;
                    }
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique id de requisito!");
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique id de projeto!");
            }
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }


    @Override
    public boolean apagarDependente(int idprojeto, int idrequisito, int id_req_dep) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificaPermissao(int idprojeto, int idpessoa, int idfuncao) {
        if (ProjetoController.getInstance().verificaProjetoById(idprojeto)) {
            if (EquipeController.getInstance().verificaPessoaExisteEmEQP(idpessoa, ProjetoController.getInstance().retornaProjetoById(idprojeto).getIdequipe())) {
                if (EquipeController.getInstance().verificaFuncao(idfuncao, idpessoa, idprojeto)) {
                    return true;
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "Esta pessoa não esta inclusa na equipe!");
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro, verifique id de projeto!");
        }
        return false;
    }

    @Override
    public List<requisito> retornarAnteriores(int idprojeto, int idrequisito) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<rastreamento_requisitos> listarast = new ArrayList<rastreamento_requisitos>();
            List<requisito> listareq = new ArrayList<requisito>();
            session.beginTransaction();
            listarast = session.createQuery("from rastreamento_requisitos where idprojeto = :idprojeto and idrequisito = :idrequisito").setParameter("idprojeto", idprojeto).setParameter("idrequisito", idrequisito).list();
            if(listarast != null || !listarast.isEmpty()){
                for (rastreamento_requisitos object : listarast) {
                    listareq.add(RequisitoController.getInstance().retornaRequisitoById(object.getId_dep_req()));
                }
                return listareq;
            }
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<requisito> retornarPosteriores(int idprojeto, int id_dep_req) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<rastreamento_requisitos> listarast = new ArrayList<rastreamento_requisitos>();
            List<requisito> listareq = new ArrayList<requisito>();
            session.beginTransaction();
            listarast = session.createQuery("from rastreamento_requisitos where idprojeto = :idprojeto and id_dep_req = :id_dep_req").setParameter("idprojeto", idprojeto).setParameter("id_dep_req", id_dep_req).list();
            if(listarast != null || !listarast.isEmpty()){
                for (rastreamento_requisitos object : listarast) {
                    listareq.add(RequisitoController.getInstance().retornaRequisitoById(object.getIdrequisito()));
                }
                return listareq;
            }
        } catch (Exception ex) {
            Logger.getLogger(EquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
