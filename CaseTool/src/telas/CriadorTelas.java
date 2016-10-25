/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author matheus
 */
abstract class CriadorTelas extends javax.swing.JFrame{
    protected CriadorTelas frame;
    public void initialize(){
        
    }
    public void setInterceptor(CriadorTelas frame){
        this.frame = frame;
    }
    public void retornaTelaAnterior(){
        if (frame != null) {
            frame.setVisible(true);
            frame = null;
            this.dispose();
        }
    }
    
}
