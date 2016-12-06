/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controller.EquipeController;
import controller.FuncaoController;
import controller.PessoaController;
import controller.RequisitoController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import model.rel_pessoa_equipe;
import model.rel_pessoa_requisito;
import model.requisito;

/**
 *
 * @author matheus
 */
public class TelaGerenciarRelacionamentoReq extends CriadorInternalFrame {

    /**
     * Creates new form TelaGerenciarRelacionamentoReq
     */
    private static TelaGerenciarRelacionamentoReq instance;
    protected DefaultListModel<rel_pessoa_requisito> jListModelPessoas = new DefaultListModel<rel_pessoa_requisito>();
    private List<rel_pessoa_requisito> listaPessoas = new ArrayList<rel_pessoa_requisito>();
    private rel_pessoa_requisito rel;

    private TelaGerenciarRelacionamentoReq() {
        initComponents();
    }

    public static synchronized TelaGerenciarRelacionamentoReq getInstance() {
        if (instance == null) {
            instance = new TelaGerenciarRelacionamentoReq();
        }
        return instance;
    }

    @Override
    public void initialize() {
        jLabel6.setText("");
        jLabel7.setText("");
        jLabel12.setText("");
        jLabel13.setText("");
        jLabel14.setText("");
        jButton4.setEnabled(false);
        jButton1.setEnabled(false);
        jTextArea1.setEnabled(false);
        jTextArea2.setEnabled(false);
        jButton2.setEnabled(false);
        jListModelRequisito.removeAllElements();
        jListModelPessoas.removeAllElements();
        List<requisito> listReq = RequisitoController.getInstance().retornaListaRequisitosByIdprojeto(Projeto.getIdprojeto());
        if (listReq != null) {
            for (requisito object : listReq) {
                System.out.println(object);
                jListModelRequisito.addElement(object);
            }
            jList1.setModel(jListModelRequisito);
        }
        adicionarEventoClick();
        adicionarEventoClickPessoa();
    }

    public void adicionarEventoClick() {
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    jButton1.setEnabled(true);
                    jTextArea1.setEnabled(false);
                    jTextArea2.setEnabled(false);
                    jButton2.setEnabled(false);
                    jListModelPessoas.removeAllElements();
                    int index = jList1.locationToIndex(e.getPoint());
                    //requisito da lista central
                    requisito req = jListModelRequisito.getElementAt(index);

                    listaPessoas = RequisitoController.getInstance().retornaListPesReqByIDReq(req.getIdrequisito());
                    if (listaPessoas != null && !listaPessoas.isEmpty()) {
                        for (rel_pessoa_requisito object : listaPessoas) {
                            jListModelPessoas.addElement(object);
                        }
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(null, "Nenhum pessoa relacionada a este requisito!");
                    }

                    jList3.setModel(jListModelPessoas);

                }
            }
        };
        jList1.addMouseListener(mouseListener);
    }

    public void adicionarEventoClickPessoa() {
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    jTextArea1.setEnabled(false);
                    jTextArea2.setEnabled(false);
                    jButton2.setEnabled(false);
                    int index = jList3.locationToIndex(e.getPoint());
                    //requisito da lista central
                    rel = jListModelPessoas.getElementAt(index);
                    jLabel6.setText(PessoaController.getInstance().retornaPessoaById(rel.getIdpessoa()).getNome());
                    jLabel7.setText(FuncaoController.getInstance().retornaFuncaoById(EquipeController.getInstance().retornaRelPessoaEqpByIdpessoa(rel.getIdpessoa()).getIdfuncao()).getDescricao());
                    jLabel12.setText(rel.getData_inicio().toString());
                    if (rel.isFinalizado()) {
                        jLabel13.setText("Sim");
                        jLabel14.setText(rel.getData_termino().toString());
                        jButton1.setEnabled(false);
                        jButton4.setEnabled(false);
                    } else {
                        jLabel13.setText("Não");
                        jLabel14.setText("Não finalizado");
                        jButton1.setEnabled(true);
                        jButton4.setEnabled(true);
                    }

                    jTextArea1.setText(rel.getDescricao_atividade());

                }
            }
        };
        jList3.addMouseListener(mouseListener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jScrollPane1.setViewportView(jList1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "RF", "RFN", "RP", "RO", "RE" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(jList3);

        jLabel1.setText("Selecione o requisito");

        jLabel2.setText("Selectione pessoa");

        jLabel3.setText("Nome:");

        jLabel4.setText("Funçao:");

        jLabel5.setText("Descriçao atividade:");

        jScrollPane3.setEnabled(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane3.setViewportView(jTextArea1);

        jButton1.setText("Editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gravar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Comentario(editar):");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setEnabled(false);
        jScrollPane4.setViewportView(jTextArea2);

        jButton4.setText("Finalizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Data início:");

        jLabel10.setText("Finalizado?");

        jLabel11.setText("Data término:");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(69, 69, 69))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(273, 273, 273)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(79, 79, 79))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        instance = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String tipo_req = (String) jComboBox1.getSelectedItem();
        filtrarListRequisito(tipo_req);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jButton1.setEnabled(false);
        jTextArea1.setEnabled(true);
        jTextArea2.setEnabled(true);
        jButton2.setEnabled(true);
        jButton4.setEnabled(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        boolean atualiza;
        if (!jTextArea1.getText().equals(rel.getDescricao_atividade()) && !jTextArea2.getText().isEmpty()) {
            rel.setDescricao_atividade(jTextArea1.getText());
            atualiza = RequisitoController.getInstance().AtualizaRelPessoaRequisito(rel, jTextArea2.getText());
            if (atualiza) {
                jButton1.setEnabled(true);
                jTextArea1.setEnabled(false);
                jTextArea2.setEnabled(false);
                jButton2.setEnabled(false);
                jButton4.setEnabled(true);
                jLabel6.setText("");
                jLabel7.setText("");
                jLabel12.setText("");
                jLabel13.setText("");
                jLabel14.setText("");
                jTextArea1.setText("");
                jTextArea2.setText("");
                javax.swing.JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
            }

        } else if (jTextArea1.getText().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Nenhum alteraçao a ser gravada!");
            jButton1.setEnabled(true);
            jTextArea1.setEnabled(false);
            jTextArea2.setEnabled(false);
            jButton2.setEnabled(false);
        } else if (jTextArea2.getText().isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, "Forneça um comentário de atualização!");
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Nenhum alteraçao a ser gravada!");
            jButton1.setEnabled(true);
            jTextArea1.setEnabled(false);
            jTextArea2.setEnabled(false);
            jButton2.setEnabled(false);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        rel.setFinalizado(true);
        rel.setData_termino(new Date(System.currentTimeMillis()));
        if(RequisitoController.getInstance().AtualizaRelPessoaRequisito(rel, "Finalizado!")){
            javax.swing.JOptionPane.showMessageDialog(null, "Atividade finalizada!");
            initialize();
        }
    }//GEN-LAST:event_jButton4ActionPerformed
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<requisito> jList1;
    private javax.swing.JList<rel_pessoa_requisito> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
