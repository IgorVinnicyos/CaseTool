/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controller.RastreamentoController;
import controller.RequisitoController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import model.projeto;
import model.requisito;

/**
 *
 * @author matheus
 */
public class TelaSelecionarRequisitoEditar extends CriadorInternalFrame {

    /**
     * Creates new form TelaSelecionarRequisito
     */
    private projeto Projeto;
    private DefaultListModel<requisito> jListModelRequisito = new DefaultListModel<requisito>();
    private static TelaSelecionarRequisitoEditar instance;

    
    private TelaSelecionarRequisitoEditar() {
        initComponents();
    }

    public static synchronized TelaSelecionarRequisitoEditar getInstance() {
        if (instance == null) {
            instance = new TelaSelecionarRequisitoEditar();
        }
        return instance;
    }

    @Override
    public void initialize() {
        List<requisito> listReq = RequisitoController.getInstance().retornaListaRequisitosByIdprojeto(Projeto.getIdprojeto());

        if (listReq != null) {
            for (requisito object : listReq) {
                System.out.println(object);
                jListModelRequisito.addElement(object);
            }
            jList1.setModel(jListModelRequisito);
        }
        adicionarEventoClick();
    }


    
    public void setProjeto(projeto Projeto) {
        this.Projeto = Projeto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "RF", "RFN", "RP", "RO", "RE" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jLabel1.setText("Selecionar Requisito Para Editar");

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String tipo_req = (String) jComboBox1.getSelectedItem();
        filtrarListRequisito(tipo_req);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        instance = null;
    }//GEN-LAST:event_formInternalFrameClosing
    public void adicionarEventoClick() {
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = jList1.locationToIndex(e.getPoint());
                    //requisito da lista central
                    requisito req = jListModelRequisito.getElementAt(index);
                    TelaAlterarRequisito.getInstance().setProjeto(Projeto);
                    TelaAlterarRequisito.getInstance().setRequisito(req);
                    TelaAlterarRequisito.getInstance().initialize();
                    TelaAlterarRequisito.getInstance().setVisible(true);
                    pane.remove(instance);
                    pane.add(TelaAlterarRequisito.getInstance());
                    instance.formInternalFrameClosing(null);
                }
            }
        };
        jList1.addMouseListener(mouseListener);
    }

    public void filtrarListRequisito(String tipo_requisito) {
        List<requisito> listReq;
        jListModelRequisito.removeAllElements();
        if (tipo_requisito == "Todos") {
            listReq = RequisitoController.getInstance().retornaListaRequisitosByIdprojeto(Projeto.getIdprojeto());

        } else {

            listReq = RequisitoController.getInstance().retornaListRequisitoByTipo(tipo_requisito, Projeto.getIdprojeto());
        }
        if (listReq != null) {
            for (requisito object : listReq) {
                jListModelRequisito.addElement(object);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<requisito> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}