/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import controller.interfaces.iNiveisController;
import java.util.ArrayList;
import java.util.List;
import model.niveis_acesso;
import util.HibernateUtil;
import org.hibernate.Session;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author matheus
 */
public class NiveisController implements iNiveisController{

    private static NiveisController instance;
    
    public static synchronized NiveisController getInstance(){
        if(instance == null){
            instance = new NiveisController();
        }
        return instance;
    } 
    
    private NiveisController(){
        
    }
    
    
    
    @Override
    public boolean cadastraNivel(String descricao) {
        try{
            
            niveis_acesso nivel = new niveis_acesso(descricao);
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(nivel);
            session.getTransaction().commit();
            session.close();
            
            javax.swing.JOptionPane.showMessageDialog(null, "Nivel de acesso cadastrado com sucesso!");
            return true;
            
      }catch(Exception ex){
         Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
      }
      return false;
    }

    @Override
    public List<niveis_acesso> retornaNiveis() {
       List<niveis_acesso> niveis = new ArrayList<niveis_acesso>();
        try {
              Session session = HibernateUtil.getSessionFactory().openSession();
              session.beginTransaction();
              niveis = session.createQuery("from niveis_acesso").list();
              session.close();
             
        } catch (Exception ex) {
            Logger.getLogger(PessoaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if (!niveis.isEmpty()) {
                  return niveis;
              }
         return null;
    }
    
}
