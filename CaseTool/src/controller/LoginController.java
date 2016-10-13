/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ILoginController;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.login;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author igor-vinicyos
 */
public class LoginController implements ILoginController {

    private static LoginController instance;
    
    public static synchronized LoginController getInstance(){
        if(instance == null){
            instance = new LoginController();
        }
        return instance;
    }
    
    @Override
    public boolean inserir(int idpessoa, String email, String senha) {
        try {
           login login = new login(idpessoa,email,senha);
           Session session = HibernateUtil.getSessionFactory().openSession();
           session.beginTransaction();
           session.save(login);
           session.getTransaction().commit();
           session.close();
           return true;
            
        } catch (Exception ex) {
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
     }

    @Override
    public void atualizar(int idpessoa, String email, String senha) {
        login loginUPD = login.getInstance();
        try{
            loginUPD.setEmail(email);
            loginUPD.setSenha(senha);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(loginUPD);
            session.getTransaction().commit();
            session.close();
            
        }catch(Exception ex){
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(int idpessoa) {
        try{
            
            
        }catch(Exception ex){
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean autenticar(String email, String senha) {
        List<login> listaLogin = new ArrayList<login>();
        try{
             Session session = HibernateUtil.getSessionFactory().openSession();
             session.beginTransaction();
             listaLogin = session.createQuery("from login where email = :email and senha = :senha").setParameter("email", email).setParameter("senha", senha).list();
             session.close();
                           
        }catch(Exception ex){
           Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!listaLogin.isEmpty()) {
            login login = listaLogin.get(0);
            return true;
        }       
        return false;
    }
    
}
