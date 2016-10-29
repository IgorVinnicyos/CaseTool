/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author igor-vinicyos
 */
// a herança do internalFrame é diferente do Jframe, por isso criei outro criador de telas
// que herda o JInternalFrame pra não da erro, nos metodos nativos da internalFrame como fechar por exemplo.
abstract class CriadorInternalFrame extends javax.swing.JInternalFrame{
    
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
