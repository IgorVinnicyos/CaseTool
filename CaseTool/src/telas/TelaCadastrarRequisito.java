/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controller.EquipeController;
import controller.PessoaController;
import controller.RastreamentoController;
import controller.RequisitoController;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.projeto;
import model.pessoa;
import model.rel_pessoa_equipe;
import javax.swing.JDesktopPane;
import model.requisito;

/**
 *
 * @author igor-vinicyos
 */
public class TelaCadastrarRequisito extends CriadorInternalFrame {

    private projeto Projeto;
    private static TelaCadastrarRequisito instance;

    /**
     * Creates new form TelaCadastrarRequisito
     */
    public TelaCadastrarRequisito() {
        initComponents();
        this.Projeto = TelaGerenciarProjeto.getInstance().getProjeto();
        initialize();
    }

    public static synchronized TelaCadastrarRequisito getInstance() {
        if (instance == null) {
            instance = new TelaCadastrarRequisito();
        }
        return instance;
    }

    @Override
    public void initialize() {
        List<rel_pessoa_equipe> listPess_Eqp = EquipeController.getInstance().retornaListaDeRelPessoasEquipeByIdequipe(Projeto.getIdequipe());
        if (listPess_Eqp != null) {
            for (rel_pessoa_equipe object : listPess_Eqp) {
                jComboBox2Pessoa.addItem(object);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Erro, verifique se há uma pessoa cadastrada na Equipe");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1Desc = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jComboBox2Pessoa = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneAtividade = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jTextField1TempoEstimado = new javax.swing.JTextField();

        setBorder(null);
        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(710, 380));
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

        jButton1.setText("Gravar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Descrição:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RF", "RFN", "RP", "RO", "RE" }));

        jLabel4.setText("Tipo de requisito:");

        jScrollPane1.setViewportView(jTextPane1Desc);

        jLabel6.setText("Pessoa:");

        jLabel7.setText("Atividade:");

        jScrollPane2.setViewportView(jTextPaneAtividade);

        jLabel8.setText("Tempo estimado:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jComboBox2Pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1TempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(287, 287, 287))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jTextField1TempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2Pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        instance = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTextPane1Desc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro, escreva uma descrição para o requisito!");
        } else if (jTextField1TempoEstimado.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro, escreva um tempo estimado para conclusão do requisito!");
        } else if (jTextPaneAtividade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro, escreva uma descrição da atividade que a pessoa realizará!");
        } else {
            String Descricao = jTextPane1Desc.getText();
            String Atividade = jTextPaneAtividade.getText();
            int tempoEstimado = Integer.parseInt(jTextField1TempoEstimado.getText());
            String tipoRequisito = (String) jComboBox1.getSelectedItem();
            rel_pessoa_equipe rel_pes = (rel_pessoa_equipe) jComboBox2Pessoa.getSelectedItem();

            int idPes = rel_pes.getIdpessoa();

            boolean insert = RequisitoController.getInstance().inserir(tempoEstimado, Descricao, Projeto.getIdprojeto(), tipoRequisito, idPes, Atividade);
//            List<requisito> listR = RequisitoController.getInstance().retornaListaRequisitosByIdprojeto(Projeto.getIdprojeto());
            if (insert) {
//                if (listR.size() > 1) {
//                    
//                }
                TelaRelacionarRequisito.getInstance().setProjeto(Projeto);
                TelaRelacionarRequisito.getInstance().setRequisito(RequisitoController.getInstance().getReqInserido());
                TelaRelacionarRequisito.getInstance().initialize();
                TelaRelacionarRequisito.getInstance().setVisible(true);
                this.setVisible(true);
                this.getContentPane().remove(this);
                this.getContentPane().add(TelaRelacionarRequisito.getInstance());
                this.formInternalFrameClosing(null);
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<rel_pessoa_equipe> jComboBox2Pessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1TempoEstimado;
    private javax.swing.JTextPane jTextPane1Desc;
    private javax.swing.JTextPane jTextPaneAtividade;
    // End of variables declaration//GEN-END:variables
}
