/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controller.EquipeController;
import controller.PessoaController;
import controller.ProjetoController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.equipe;
import model.projeto;

/**
 *
 * @author matheus
 */
public class TelaProjetos extends CriadorTelas{

    /**
     * Creates new form TelaProjetos
     */
    private static TelaProjetos instance;

    public static synchronized TelaProjetos getInstance() {
        if (instance == null) {
            instance = new TelaProjetos();
        }
        return instance;
    }

    private TelaProjetos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("Novo projeto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gerenciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        jLabel1.setText("Projetos ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        retornaTelaAnterior();
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (PessoaController.getInstance().returnPesLogin().getNivel_acesso() != 1) {
            javax.swing.JOptionPane.showMessageDialog(null, "Erro, você não possui nível de acesso suficiente para esta operação!");
        } else {
            List<equipe> listae = new ArrayList<equipe>();
            listae = EquipeController.getInstance().retornaListaEquipes();
            if (listae == null) {
                int cadastro = javax.swing.JOptionPane.showConfirmDialog(null, "Você não possui nenhuma equipe cadastrada, deseja fazer agora?", "Equipe", JOptionPane.YES_NO_OPTION);
                if (cadastro == 0) {
                    TelaCadastraEquipe.getInstance().setInterceptor(this);
                    TelaCadastraEquipe.getInstance().setVisible(true);
                    this.setVisible(false);
                } else {
                    this.dispose();
                }

            } else {
                TelaNovoProjeto.getInstance().setInterceptor(this);
                TelaNovoProjeto.getInstance().setVisible(true);
                this.setVisible(false);
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        List<projeto> listProj= new ArrayList<projeto>();
        listProj = ProjetoController.getInstance().retornaListaProjetos();
        if(listProj != null){
            if(PessoaController.getInstance().returnPesLogin().getNivel_acesso() != 1){
                JOptionPane.showMessageDialog(null, "Erro, você não possui nível de acesso suficiente para esta operação!");
            }else{
                List<equipe> listEqp = new ArrayList<equipe>();
                listEqp = EquipeController.getInstance().retornaListaEquipes();
                if(listEqp == null){
                    int cadastro = JOptionPane.showConfirmDialog(null, "Você não possui nenhuma equipe cadastrada, deseja fazer agora?","Equipe" ,JOptionPane.YES_NO_OPTION);                                                  
                    if(cadastro == 0){
                        TelaCadastraEquipe.getInstance().setInterceptor(this);
                        TelaCadastraEquipe.getInstance().setVisible(true);
                        this.setVisible(false);
                    }else{
                        this.dispose();
                    }
                }else{
                    TelaSelecionarProjeto.getInstance().setInterceptor(this);
                    TelaSelecionarProjeto.getInstance().setVisible(true);
                    this.setVisible(false);
                }
            }
        }else{
           int cadastroProjeto = JOptionPane.showConfirmDialog(null, "Você não possui nenhum projeto cadastrado, deseja fazer isso agora?","Projeto",JOptionPane.YES_NO_OPTION);
           if(cadastroProjeto == 0){
               TelaNovoProjeto.getInstance().setInterceptor(this);
               TelaNovoProjeto.getInstance().setVisible(true);
               this.setVisible(false);
           }else{
               this.dispose();
           }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProjetos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProjetos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
