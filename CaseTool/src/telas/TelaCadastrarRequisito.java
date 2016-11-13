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

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPaneRestri = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPaneExpect = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jRadioButtonEssencial = new javax.swing.JRadioButton();
        jRadioButtonImportante = new javax.swing.JRadioButton();
        jRadioButtonDesejavel = new javax.swing.JRadioButton();

        setClosable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(800, 380));
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

        jLabel2.setText("Restrições:");

        jScrollPane3.setViewportView(jTextPaneRestri);

        jLabel3.setText("Expectativas:");

        jScrollPane4.setViewportView(jTextPaneExpect);

        jLabel5.setText("Prioridade:");

        buttonGroup1.add(jRadioButtonEssencial);
        jRadioButtonEssencial.setText("Essencial");

        buttonGroup1.add(jRadioButtonImportante);
        jRadioButtonImportante.setText("Importante");

        buttonGroup1.add(jRadioButtonDesejavel);
        jRadioButtonDesejavel.setText("Desejável");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonEssencial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonImportante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonDesejavel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1TempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(21, 21, 21)
                                .addComponent(jComboBox2Pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jButton1)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField1TempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jRadioButtonEssencial)
                            .addComponent(jRadioButtonImportante)
                            .addComponent(jRadioButtonDesejavel))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6))
                            .addComponent(jComboBox2Pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7)
                                .addGap(47, 47, 47))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap(41, Short.MAX_VALUE))
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
        } else if(jTextPaneExpect.getText().isEmpty()){
             JOptionPane.showMessageDialog(null, "Erro, escreva uma Expectativa para o requisito!");
        } else if(jTextPaneRestri.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Erro, escreva uma Restrição para o requisito!");
        } else if(!jRadioButtonDesejavel.isSelected() && !jRadioButtonEssencial.isSelected() && !jRadioButtonImportante.isSelected()){ 
            JOptionPane.showMessageDialog(null, "Erro, escolha uma Prioridade para o requisito!");
        } else {
            String Descricao = jTextPane1Desc.getText();
            String Atividade = jTextPaneAtividade.getText();
            String Restricoes = jTextPaneRestri.getText();
            String Expectativas = jTextPaneExpect.getText();
            int tempoEstimado = Integer.parseInt(jTextField1TempoEstimado.getText());
            String tipoRequisito = (String) jComboBox1.getSelectedItem();
            rel_pessoa_equipe rel_pes = (rel_pessoa_equipe) jComboBox2Pessoa.getSelectedItem();
            int idPes = rel_pes.getIdpessoa();
            int prioridade = 0;
            if(jRadioButtonEssencial.isSelected()){
                prioridade = 1;
            }else if(jRadioButtonImportante.isSelected()){
                prioridade = 2;
            } else if(jRadioButtonDesejavel.isSelected()){
                prioridade = 3;
            }
            
            boolean insert = RequisitoController.getInstance().inserir(tempoEstimado, Descricao, Projeto.getIdprojeto(), tipoRequisito, idPes, Atividade,Restricoes,Expectativas,prioridade);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<rel_pessoa_equipe> jComboBox2Pessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButtonDesejavel;
    private javax.swing.JRadioButton jRadioButtonEssencial;
    private javax.swing.JRadioButton jRadioButtonImportante;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1TempoEstimado;
    private javax.swing.JTextPane jTextPane1Desc;
    private javax.swing.JTextPane jTextPaneAtividade;
    private javax.swing.JTextPane jTextPaneExpect;
    private javax.swing.JTextPane jTextPaneRestri;
    // End of variables declaration//GEN-END:variables
}
