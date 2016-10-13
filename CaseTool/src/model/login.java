/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author matheus
 */
@Entity
public class login {
    @Id
    @GeneratedValue
    private int idlogin;
    private int idpessoa;
    private String email;
    private String senha;
    private static login uniqueInstance;

    public login(login login) {
        uniqueInstance = login;
    }
    public login(int idpessoa, String email, String senha){
    
    }
    private login(){
        
    }
    
    
    public static synchronized login getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new login();
        }
        return uniqueInstance;
    }
    
    public int getIdpessoa() {
        return idpessoa;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
