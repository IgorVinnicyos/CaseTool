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
    private JDesktopPane panel;
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
    
    public static synchronized TelaCadastrarRequisito getInstance(){
        if(instance == null){
            instance = new TelaCadastrarRequisito();
        }
        return instance;
    }

    @Override
    public void initialize() {
        List<rel_pessoa_equipe> listPess_Eqp = EquipeController.getInstance().retornaListaDeRelPessoasEquipeByIdequipe(Projeto.getIdequipe());
        if(listPess_Eqp  != null){
            for (rel_pessoa_equipe object : listPess_Eqp) {
                jComboBox2Pessoa.addItem(object);
            }
        }else{
            JOptionPane.showMessageDialog(null,"Erro, verifique se há uma pessoa cadastrada na Equipe");
        }
    }
    public void setPanel(JDesktopPane DeskPanel){
        this.panel = DeskPanel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserTermino = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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

        jLabel2.setText("Inicio:");

        jLabel3.setText("Termino:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RF", "RFN", "RP", "RO", "RE" }));

        jLabel4.setText("Tipo de requisito:");

        jLabel5.setText("Codigo:");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jDateChooserTermino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooserInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(jComboBox2Pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1TempoEstimado, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooserInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jDateChooserTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2Pessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(4, 4, 4)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        retornaTelaAnterior();
        instance = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jTextPane1Desc.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Erro, escreva uma descrição para o requisito!");
        }else if(jDateChooserInicio.getDate() == null){
            JOptionPane.showMessageDialog(null, "Erro, escolha uma data de inicio!");
        }else if(jDateChooserTermino.getDate() == null){
            JOptionPane.showMessageDialog(null, "Erro, escolha uma data de termino!");
        }else if(jTextFieldCodigo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Erro,escreva um código para o requisito!");
        }else if(jTextField1TempoEstimado.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Erro, escreva um tempo estimado para conclusão do requisito!");
        }else if(jTextPaneAtividade.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Erro, escreva uma descrição da atividade que a pessoa realizará!");
        }
        
        String Descricao = jTextPane1Desc.getText();
        String Atividade = jTextPaneAtividade.getText();
        int tempoEstimado = Integer.parseInt(jTextField1TempoEstimado.getText());
        int codigo = Integer.parseInt(jTextFieldCodigo.getText());
        Date inicio = jDateChooserInicio.getDate();
        Date termino = jDateChooserTermino.getDate();
        String tipoRequisito = (String)jComboBox1.getSelectedItem();
        rel_pessoa_equipe rel_pes = (rel_pessoa_equipe)jComboBox2Pessoa.getSelectedItem();
       
        int idPes = rel_pes.getIdpessoa();

        if(!RequisitoController.getInstance().verificaRequisitoByCod(tipoRequisito, codigo)){
           
            boolean insert = RequisitoController.getInstance().inserir(tempoEstimado,Descricao,Projeto.getIdprojeto(),inicio,termino,tipoRequisito,codigo,idPes,Atividade);
            List<requisito> listR = RequisitoController.getInstance().retornaListaRequisitosByIdprojeto(Projeto.getIdprojeto());
            if(insert){
                    if(listR.size() > 1){
                        TelaRelacionarRequisito.getInstance().setInterceptor(TelaGerenciarProjeto.getInstance());
                        TelaRelacionarRequisito.getInstance().setProjeto(Projeto);
                        TelaRelacionarRequisito.getInstance().setRequisito(RequisitoController.getInstance().getReqInserido());
                        TelaRelacionarRequisito.getInstance().initialize();
                        TelaRelacionarRequisito.getInstance().setVisible(true);
                        panel.add(TelaRelacionarRequisito.getInstance());
                    }
                    this.formInternalFrameClosing(null);
                    this.dispose();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro, Já existe um requisito cadastrado com esse código: "+tipoRequisito+codigo);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<rel_pessoa_equipe> jComboBox2Pessoa;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private com.toedter.calendar.JDateChooser jDateChooserTermino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1TempoEstimado;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextPane jTextPane1Desc;
    private javax.swing.JTextPane jTextPaneAtividade;
    // End of variables declaration//GEN-END:variables
}
