/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import model.projeto;
import model.requisito;


/**
 *
 * @author igor-vinicyos
 */
// a herança do internalFrame é diferente do Jframe, por isso criei outro criador de telas
// que herda o JInternalFrame pra não da erro, nos metodos nativos da internalFrame como fechar por exemplo.
abstract class CriadorInternalFrame extends javax.swing.JInternalFrame {

    protected CriadorInternalFrame frame;
    protected JDesktopPane pane;
    protected projeto Projeto;
    protected requisito req;
    protected DefaultListModel<requisito> jListModelRequisito = new DefaultListModel<requisito>();

    public void initialize() {

    }

    public void setInterceptor(CriadorInternalFrame frame) {
        this.frame = frame;
    }

    public void retornaTelaAnterior() {
        if (frame != null) {
            frame.setVisible(true);
            frame = null;
            this.dispose();
        }
    }

    public void setPane(JDesktopPane pane) {
        this.pane = pane;
    }

    public void setProjeto(projeto Projeto) {
        this.Projeto = Projeto;
    }

    public void setRequisito(requisito req) {
        this.req = req;
    }

}
