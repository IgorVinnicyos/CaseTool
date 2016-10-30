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
import javax.swing.JOptionPane;
import model.projeto;
import model.requisito;
/**
 *
 * @author igor-vinicyos
 */
public class TelaRastrearRequisito extends CriadorInternalFrame{
    private static TelaRastrearRequisito instance;
    private DefaultListModel<requisito> jListModelRequisito = new DefaultListModel<requisito>();
     private DefaultListModel<requisito> jListModelPosteriores = new DefaultListModel<requisito>();
      private DefaultListModel<requisito> jListModelAnteriores = new DefaultListModel<requisito>();
    private projeto Projeto;
    private int indexRequisitoPrincipal;
    /**
     * Creates new form TelaRastrearRequisito
     */
    public TelaRastrearRequisito() {
        initComponents();
        Projeto = TelaGerenciarProjeto.getInstance().getProjeto();
        initialize();
        adicionarEventoClickFiltrar();
        adicionarEventoClickRemoverPosterior();
        adicionarEventoClickRemoverAnterior();
    }
    public static synchronized  TelaRastrearRequisito getInstance(){
        if(instance == null){
            instance = new TelaRastrearRequisito();
        }
        return instance;
    }

    @Override
    public void initialize() {
        
        List<requisito> listReq = RequisitoController.getInstance().retornaListaRequisitosByIdprojeto(Projeto.getIdprojeto());
        
        if(listReq != null){
            for (requisito object : listReq) {
                System.out.println(object);
                jListModelRequisito.addElement(object);
            }
            jList1Requisito.setModel(jListModelRequisito);
        }
    }
    
    public void adicionarEventoClickFiltrar(){
          MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    int index = jList1Requisito.locationToIndex(e.getPoint());
                    indexRequisitoPrincipal = index;
                    requisito req = jListModelRequisito.getElementAt(index);
                    listarRelações(req);
                }
            }
        };
        jList1Requisito.addMouseListener(mouseListener);
    }
     public void adicionarEventoClickRemoverPosterior(){
          MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    int index = jList1Posteriores.locationToIndex(e.getPoint());
                    //requisito da lista central
                    requisito req = jListModelRequisito.getElementAt(indexRequisitoPrincipal);
                    requisito posterior = jListModelPosteriores.getElementAt(index);
                    int remover = JOptionPane.showConfirmDialog(null, "Deseja remover a relação de dependência entre "+req+" e "+posterior+"?", "Desfazer dependência", JOptionPane.YES_NO_OPTION);
                    if(remover == 0){
                       RastreamentoController.getInstance().apagarDependente(Projeto.getIdprojeto(), req.getIdrequisito(),posterior.getIdrequisito());
                       jListModelPosteriores.removeElement(posterior);
                    }
                }
            }
        };
        jList1Posteriores.addMouseListener(mouseListener);
    }
     public void adicionarEventoClickRemoverAnterior(){
          MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount() == 2){
                    int index = jList1Anteriores.locationToIndex(e.getPoint());
                    //requisito da lista central
                    requisito req = jListModelRequisito.getElementAt(indexRequisitoPrincipal);
                    requisito anterior = jListModelAnteriores.getElementAt(index);
                    int remover = JOptionPane.showConfirmDialog(null, "Deseja remover a relação de dependência entre "+anterior+" e "+req+"?", "Desfazer dependência", JOptionPane.YES_NO_OPTION);
                    if(remover == 0){
                       RastreamentoController.getInstance().apagarDependente(Projeto.getIdprojeto(), anterior.getIdrequisito(),req.getIdrequisito());
                       jListModelAnteriores.removeElement(anterior);
                    }
                }
            }
        };
        jList1Anteriores.addMouseListener(mouseListener);
    }
    
    public void filtrarListRequisito(String tipo_requisito){
        List<requisito> listReq ;
        jListModelAnteriores.removeAllElements();
        jListModelPosteriores.removeAllElements();
        jListModelRequisito.removeAllElements();
        if(tipo_requisito =="Todos"){  
            listReq = RequisitoController.getInstance().retornaListaRequisitosByIdprojeto(Projeto.getIdprojeto());
           
        }else{
           
           listReq = RequisitoController.getInstance().retornaListRequisitoByTipo(tipo_requisito,Projeto.getIdprojeto());
        }
        if(listReq != null){
            for (requisito object : listReq) {
                jListModelRequisito.addElement(object);
            }
        }
    }
    
    public void listarRelações(requisito req){
      
        List<requisito> posteriores = RastreamentoController.getInstance().retornarPosteriores(Projeto.getIdprojeto(), req.getIdrequisito());
        List<requisito> anteriores = RastreamentoController.getInstance().retornarAnteriores(Projeto.getIdprojeto(), req.getIdrequisito());
        
        jListModelAnteriores.removeAllElements();
        jListModelPosteriores.removeAllElements();
        if(posteriores != null){
            for (requisito posterior : posteriores) {
                jListModelPosteriores.addElement(posterior);
            }
            jList1Posteriores.setModel(jListModelPosteriores);
        }
        if(anteriores != null){
            for (requisito anterior : anteriores) {
                jListModelAnteriores.addElement(anterior);
            }
            jList1Anteriores.setModel(jListModelAnteriores);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxTipoReq = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1Requisito = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1Posteriores = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1Anteriores = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();

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

        jComboBoxTipoReq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "RF", "RFN", "RP", "RO", "RE" }));
        jComboBoxTipoReq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoReqActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1Requisito);

        jLabel1.setText("Filtrar:");

        jScrollPane2.setViewportView(jList1Posteriores);

        jLabel2.setText("Requisitos posteriores");

        jScrollPane3.setViewportView(jList1Anteriores);

        jLabel3.setText("Requisitos anteriores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoReq, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipoReq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3))
                .addGap(41, 41, 41))
        );

        setBounds(0, 0, 710, 380);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here
        retornaTelaAnterior();
        instance = null;
    }//GEN-LAST:event_formInternalFrameClosing

    private void jComboBoxTipoReqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoReqActionPerformed
        // TODO add your handling code here:
       String tipo_req = (String)jComboBoxTipoReq.getSelectedItem();
        filtrarListRequisito(tipo_req);
    }//GEN-LAST:event_jComboBoxTipoReqActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBoxTipoReq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<requisito> jList1Anteriores;
    private javax.swing.JList<requisito> jList1Posteriores;
    private javax.swing.JList<requisito> jList1Requisito;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
