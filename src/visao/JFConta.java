/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.ContaRN;
import persistencia.Conexao;
import recursos.utilitarios.Mascara;
import recursos.utilitarios.TableModel;
import vo.Conta;

/**
 *
 * @author ThyagoHenrique
 */
public class JFConta extends javax.swing.JFrame {

     String              titulo[]            = new String[]{"Código", "Tipo", "Vencimento", "Valor", "Estado"};
     TableModel          tm                  = new TableModel(titulo, 1, titulo.length);            
     ContaRN             crn                 = new ContaRN();
     Conta               conta               = new Conta();
     List<Conta>         obj                 = new ArrayList();
     Conexao             cx;
     /**
      * Creates new form JFConta
      */
     public JFConta() {
          initComponents();
     }

     public JFConta(Conexao cx) {
          initComponents();
          this.cx = cx;
          tabela.setModel(tm);
     }  
     
     /**
      * This method is called from within the constructor to initialize the
      * form. WARNING: Do NOT modify this code. The content of this method is
      * always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jTabbedPane3 = new javax.swing.JTabbedPane();
          jPanel3 = new javax.swing.JPanel();
          jLabel7 = new javax.swing.JLabel();
          jLabel8 = new javax.swing.JLabel();
          jLabel9 = new javax.swing.JLabel();
          ttipoconta = new javax.swing.JTextField();
          tpreco = new javax.swing.JTextField();
          bsair2 = new javax.swing.JButton();
          botao_excluir = new javax.swing.JButton();
          botao_update = new javax.swing.JButton();
          botao_inserir = new javax.swing.JButton();
          dcvencimento = new com.toedter.calendar.JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
          jLabel10 = new javax.swing.JLabel();
          cbestado = new javax.swing.JComboBox();
          jPanel4 = new javax.swing.JPanel();
          botao_procurar = new javax.swing.JButton();
          tnomeproc = new javax.swing.JTextField();
          jScrollPane2 = new javax.swing.JScrollPane();
          tabela = new javax.swing.JTable();
          jLabel11 = new javax.swing.JLabel();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setTitle("Contas da loja");

          jLabel7.setText("Tipo Conta");

          jLabel8.setText("Preço");

          jLabel9.setText("Vencimento");

          bsair2.setText("Sair");
          bsair2.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bsair2ActionPerformed(evt);
               }
          });

          botao_excluir.setText("Excluir");
          botao_excluir.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botao_excluirActionPerformed(evt);
               }
          });

          botao_update.setText("update");
          botao_update.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botao_updateActionPerformed(evt);
               }
          });

          botao_inserir.setText("Inserir");
          botao_inserir.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botao_inserirActionPerformed(evt);
               }
          });

          jLabel10.setText("Estado");

          cbestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pago", "Não-Pago" }));

          javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
          jPanel3.setLayout(jPanel3Layout);
          jPanel3Layout.setHorizontalGroup(
               jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addGroup(jPanel3Layout.createSequentialGroup()
                              .addGap(0, 214, Short.MAX_VALUE)
                              .addComponent(botao_inserir)
                              .addGap(18, 18, 18)
                              .addComponent(botao_update)
                              .addGap(18, 18, 18)
                              .addComponent(botao_excluir)
                              .addGap(18, 18, 18)
                              .addComponent(bsair2))
                         .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                              .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(jLabel7)
                                   .addComponent(jLabel8)
                                   .addComponent(jLabel10))
                              .addGap(29, 29, 29)
                              .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                   .addComponent(ttipoconta)
                                   .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                             .addComponent(tpreco)
                                             .addComponent(cbestado, 0, 126, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(dcvencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                    .addGap(31, 31, 31))
          );
          jPanel3Layout.setVerticalGroup(
               jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel7)
                         .addComponent(ttipoconta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel8)
                              .addComponent(jLabel9)
                              .addComponent(tpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addComponent(dcvencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel10)
                         .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(65, 65, 65)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(bsair2)
                         .addComponent(botao_excluir)
                         .addComponent(botao_update)
                         .addComponent(botao_inserir))
                    .addContainerGap(152, Short.MAX_VALUE))
          );

          jTabbedPane3.addTab("Inserir Conta", jPanel3);

          botao_procurar.setText("Procurar");
          botao_procurar.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botao_procurarActionPerformed(evt);
               }
          });

          tabela.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
               },
               new String [] {
                    "Código", "Tipo Conta", "Vencimento", "Valor", "Estado"
               }
          ) {
               Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
               };

               public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
               }
          });
          tabela.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tabelaMouseClicked(evt);
               }
          });
          jScrollPane2.setViewportView(tabela);

          jLabel11.setText("Tipo");

          javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
          jPanel4.setLayout(jPanel4Layout);
          jPanel4Layout.setHorizontalGroup(
               jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel11)
                    .addGap(18, 18, 18)
                    .addComponent(tnomeproc, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(botao_procurar)
                    .addContainerGap())
               .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                         .addContainerGap()))
          );
          jPanel4Layout.setVerticalGroup(
               jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(botao_procurar)
                         .addComponent(tnomeproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel11))
                    .addContainerGap(328, Short.MAX_VALUE))
               .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                         .addContainerGap(50, Short.MAX_VALUE)
                         .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addContainerGap()))
          );

          jTabbedPane3.addTab("Procura Conta", jPanel4);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jTabbedPane3)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jTabbedPane3)
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void bsair2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsair2ActionPerformed
          this.dispose();
     }//GEN-LAST:event_bsair2ActionPerformed

     private void botao_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluirActionPerformed
          String msg      = "";
          int    response = JOptionPane.showConfirmDialog(null, "Tem certeza disso,\n"
               + "Você quer excluir?", "Confirmação de excluir:",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          if (response == JOptionPane.YES_OPTION) {
               if(conta != null && conta.getCodigo() != null){
                    msg = crn.excluirConta(cx, conta);
               }else{
                    msg = "Para excluir escolha antes uma conta que tenha sido gravada no banco";
               }
          }
          if(msg != null && !msg.isEmpty()){
               JOptionPane.showMessageDialog(null, msg);
          }else{
               obj.remove(conta);
               listar();
               JOptionPane.showMessageDialog(null, "Excluido com sucesso");
          }
     }//GEN-LAST:event_botao_excluirActionPerformed

     private void botao_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_updateActionPerformed
          setaConta();
          String msg = crn.updateConta(cx, conta);
          if(msg != null && !msg.isEmpty()){
               JOptionPane.showMessageDialog(null, msg);
          }else{
               for(int i = 0; i < obj.size(); i++){
                    if(obj.get(i).getCodigo() == conta.getCodigo()){
                         obj.set(i, conta);
                         listar();
                         break;
                    }
               }
               JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
          }
     }//GEN-LAST:event_botao_updateActionPerformed

     private void botao_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_inserirActionPerformed
          conta = new Conta();
          setaConta();
          String msg = crn.inserirConta(cx, conta);
          if(msg != null && !msg.isEmpty()){
               JOptionPane.showMessageDialog(null, msg);
          }else{
               obj.add(conta);
               listar();
               JOptionPane.showMessageDialog(null, "Inserido com sucesso");
          }
     }//GEN-LAST:event_botao_inserirActionPerformed

     private void botao_procurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_procurarActionPerformed
          obj = crn.procuraTodos(cx);
          if(obj != null && !obj.isEmpty()){
               listar();
          }else{
               JOptionPane.showMessageDialog(null, "Nada encontrado");
          }
     }//GEN-LAST:event_botao_procurarActionPerformed

     private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
          conta = obj.get(tabela.getSelectedRow());
          SetaTelaConta();
     }//GEN-LAST:event_tabelaMouseClicked

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
               java.util.logging.Logger.getLogger(JFConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
               java.util.logging.Logger.getLogger(JFConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
               java.util.logging.Logger.getLogger(JFConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          } catch (javax.swing.UnsupportedLookAndFeelException ex) {
               java.util.logging.Logger.getLogger(JFConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
                    new JFConta().setVisible(true);
               }
          });
     }
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton botao_update;
     private javax.swing.JButton botao_excluir;
     private javax.swing.JButton botao_inserir;
     private javax.swing.JButton botao_procurar;
     private javax.swing.JButton bsair2;
     private javax.swing.JComboBox cbestado;
     private com.toedter.calendar.JDateChooser dcvencimento;
     private javax.swing.JLabel jLabel10;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel7;
     private javax.swing.JLabel jLabel8;
     private javax.swing.JLabel jLabel9;
     private javax.swing.JPanel jPanel3;
     private javax.swing.JPanel jPanel4;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JTabbedPane jTabbedPane3;
     private javax.swing.JTable tabela;
     private javax.swing.JTextField tnomeproc;
     private javax.swing.JTextField tpreco;
     private javax.swing.JTextField ttipoconta;
     // End of variables declaration//GEN-END:variables

     private void setaConta() {
          conta.setTipo(ttipoconta.getText());
          String preco = tpreco.getText();
          preco        = preco.replace("R$ ", "");
          conta.setValor(Mascara.formatToDouble(preco));
          conta.setVencimento(dcvencimento.getDate());
          conta.setEstado(cbestado.getSelectedItem().toString());
     }
     
   /**lista tudo o que está na tabela**/  
    private void listar() {
            Mascara mas = new Mascara();
            tabela.setModel(new TableModel(titulo, obj.size(), titulo.length));
            for(int i=0; i < obj.size(); i++){
                    tabela.setValueAt(obj.get(i).getCodigo(), i, 0);
                    tabela.setValueAt(obj.get(i).getTipo().toUpperCase(), i, 1);
                    tabela.setValueAt(mas.mascaraData("dd/MM/yyyy", obj.get(i).getVencimento()), i, 2);
                    tabela.setValueAt(Mascara.formatMoeda(obj.get(i).getValor()), i, 3);
                    tabela.setValueAt(obj.get(i).getEstado(), i, 4);
            }
            tabela.setAutoCreateRowSorter(true);    
    }       

     private void SetaTelaConta() {
          ttipoconta.setText(conta.getTipo().toUpperCase());
          tpreco.setText(Mascara.formatMoeda(conta.getValor()));
          dcvencimento.setDate(conta.getVencimento());
          cbestado.setSelectedItem(conta.getEstado());
     }
}