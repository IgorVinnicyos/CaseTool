/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casetool;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import model.*;
import org.hibernate.Session;
import controller.*;
import javax.swing.JOptionPane;
import telas.TelaLogin;
import util.HibernateUtil;

/**
 *
 * @author matheus
 */
public class CaseTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     //List<requisito> req= RequisitoController.getInstance().retornaListRequisitoByTipo("R", 1);
      //  System.out.println(req.get(0));
     
      TelaLogin login = TelaLogin.getInstance();
      login.setVisible(true);
     

    }
}
