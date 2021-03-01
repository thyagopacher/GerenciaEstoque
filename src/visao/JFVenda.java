/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.DescontoRN;
import negocio.EnderecoRN;
import negocio.EstadoVendaRN;
import negocio.FormaPagamentoRN;
import negocio.ItemVendaRN;
import negocio.PessoaRN;
import negocio.ProdutoRN;
import negocio.UsuarioRN;
import negocio.VendaRN;
import negocio.VendedorRN;
import persistencia.Conexao;
import recursos.utilitarios.Frete;
import recursos.utilitarios.Mascara;
import recursos.utilitarios.TableModel;
import vo.Desconto;
import vo.Endereco;
import vo.EstadoVenda;
import vo.FormaPagamento;
import vo.FreteServicoVO;
import vo.ItemVenda;
import vo.Pessoa;
import vo.Produto;
import vo.ServicosFrete;
import vo.Usuario;
import vo.Venda;
import vo.Vendedor;

/**
 *
 * @author ThyagoHenrique
 */
public class JFVenda extends javax.swing.JFrame {

     Conexao                  cx;
     Mascara                  mas                 = new Mascara();
     String                   titulo_endereco[]   = new String[]{"Código", "CEP", "Endereço", "Estado"};
     TableModel               tm_endereco         = new TableModel(titulo_endereco, 1, titulo_endereco.length);      
     String                   titulo_ivenda[]     = new String[]{"Produto", "Preço", "Quantidade", "Desconto"};
     TableModel               tm_ivenda           = new TableModel(titulo_ivenda, 1, titulo_ivenda.length);      
     String                   titulo_pessoa[]     = new String[]{"Código", "Nome", "CPF", "Telefone"};
     TableModel               tm                  = new TableModel(titulo_pessoa, 1, titulo_pessoa.length);         
     String                   titulo_venda[]      = new String[]{"Código", "Data", "Cliente", "Valor"};
     TableModel               tm_venda            = new TableModel(titulo_venda, 1, titulo_venda.length);         
     Venda                    venda               = new Venda();
     VendaRN                  vrn                 = new VendaRN();
     ItemVendaRN              ivrn                = new ItemVendaRN();
     List<Venda>              obj_venda           = new ArrayList();
     List<Produto>            obj_produto         = new ArrayList();
     ProdutoRN                prn                 = new ProdutoRN();
     PessoaRN                 pern                = new PessoaRN();
     List<Pessoa>             obj_pessoa          = new ArrayList();
     Pessoa                   pessoa              = new Pessoa();
     Produto                  produto             = new Produto();
     List<ItemVenda>          obj_ivenda          = new ArrayList();
     ItemVenda                ivenda              = new ItemVenda();
     DescontoRN               drn                 = new DescontoRN();
     Desconto                 desconto            = new Desconto();
     List<FormaPagamento>     obj_forma           = new ArrayList();
     FormaPagamentoRN         frn                 = new FormaPagamentoRN();
     FormaPagamento           forma               = new FormaPagamento();
     EstadoVendaRN            ern                 = new EstadoVendaRN();
     EstadoVenda              estado_venda        = new EstadoVenda();
     List<EstadoVenda>        obj_estadov         = new ArrayList();
     EnderecoRN               enrn                = new EnderecoRN();
     Endereco                 endereco            = new Endereco();
     List<Endereco>           obj_endereco        = new ArrayList();
     Frete                    frete               = new Frete();
     ServicosFrete            sfrete              = new ServicosFrete();
     FreteServicoVO           fvo                 = new FreteServicoVO();
     Vendedor                 vendedor            = new Vendedor();
     VendedorRN               vern                = new VendedorRN();
     Usuario                  usuario             = new Usuario();
     UsuarioRN                urn                 = new UsuarioRN();
     List<Vendedor>           obj_vendedor        = new ArrayList();
     private boolean          novaforma           = false;
     private boolean          atualizavendedor    = false;
     /**
      * Creates new form JFVenda
      */
     public JFVenda() {
          initComponents();
     }


     public JFVenda(Conexao cx, Usuario usuario) {
          initComponents();
          this.cx = cx;
          dcdtvenda.setDate(new Date());
          tabela_venda.setModel(tm_venda);
          tabela_cliente.setModel(tm);
          tabela_endereco.setModel(tm_endereco);
          dcdtvenda.setDate(new Date());
          informacoesVendedor();
     }    
     
     public JFVenda(Conexao cx) {
          initComponents();
          this.cx = cx;
          dcdtvenda.setDate(new Date());
          tabela_venda.setModel(tm_venda);
          tabela_cliente.setModel(tm);
          tabela_endereco.setModel(tm_endereco);
          dcdtvenda.setDate(new Date());
     }       
     
     /**
      * This method is called from within the constructor to initialize the
      * form. WARNING: Do NOT modify this code. The content of this method is
      * always regenerated by the Form Editor.
      */
     @SuppressWarnings("unchecked")
     // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
     private void initComponents() {

          jTabbedPane1 = new javax.swing.JTabbedPane();
          jPanel1 = new javax.swing.JPanel();
          jLabel1 = new javax.swing.JLabel();
          jLabel2 = new javax.swing.JLabel();
          jLabel3 = new javax.swing.JLabel();
          tpreco = new javax.swing.JTextField();
          tquantidade = new javax.swing.JTextField();
          bsair = new javax.swing.JButton();
          botao_excluir = new javax.swing.JButton();
          botao_update = new javax.swing.JButton();
          botao_inserir = new javax.swing.JButton();
          jLabel9 = new javax.swing.JLabel();
          tcliente = new javax.swing.JTextField();
          jLabel10 = new javax.swing.JLabel();
          tcpf = new javax.swing.JTextField();
          jLabel11 = new javax.swing.JLabel();
          ttelefone = new javax.swing.JTextField();
          jLabel12 = new javax.swing.JLabel();
          tcodigobarra = new javax.swing.JTextField();
          tnome_produto = new javax.swing.JTextField();
          blimpar = new javax.swing.JButton();
          jLabel5 = new javax.swing.JLabel();
          dcdtvenda = new com.toedter.calendar.JDateChooser("dd/MM/yyyy", "##/##/#####", '_');
          jScrollPane = new javax.swing.JScrollPane();
          tabela_item_venda = new javax.swing.JTable();
          jLabel13 = new javax.swing.JLabel();
          ltotalgasto = new javax.swing.JLabel();
          jLabel4 = new javax.swing.JLabel();
          dcvencimento = new com.toedter.calendar.JDateChooser();
          jLabel7 = new javax.swing.JLabel();
          jTextField1 = new javax.swing.JTextField();
          jLabel14 = new javax.swing.JLabel();
          cformapagamento = new javax.swing.JComboBox();
          jLabel15 = new javax.swing.JLabel();
          cestadovenda = new javax.swing.JComboBox();
          jLabel16 = new javax.swing.JLabel();
          cenvio = new javax.swing.JComboBox();
          bconsfrete = new javax.swing.JButton();
          badicionar_fpagamento = new javax.swing.JButton();
          badicionar_vendedor = new javax.swing.JButton();
          cvendedor = new javax.swing.JComboBox();
          jLabel6 = new javax.swing.JLabel();
          jPanel3 = new javax.swing.JPanel();
          bprocura_venda = new javax.swing.JButton();
          tnomeproc = new javax.swing.JTextField();
          jScrollPane2 = new javax.swing.JScrollPane();
          tabela_venda = new javax.swing.JTable();
          jPanel4 = new javax.swing.JPanel();
          jLabel8 = new javax.swing.JLabel();
          tnome_cliente = new javax.swing.JTextField();
          botao_proc_cliente = new javax.swing.JButton();
          jScrollPane4 = new javax.swing.JScrollPane();
          tabela_cliente = new javax.swing.JTable();
          jPanel2 = new javax.swing.JPanel();
          jScrollPane1 = new javax.swing.JScrollPane();
          tabela_endereco = new javax.swing.JTable();

          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setTitle("Vendas de produto");
          addWindowListener(new java.awt.event.WindowAdapter() {
               public void windowOpened(java.awt.event.WindowEvent evt) {
                    formWindowOpened(evt);
               }
          });

          jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
               public void focusGained(java.awt.event.FocusEvent evt) {
                    jTabbedPane1FocusGained(evt);
               }
          });

          jLabel1.setText("Produto");

          jLabel2.setText("Preço");

          jLabel3.setText("Quantidade");

          tquantidade.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyReleased(java.awt.event.KeyEvent evt) {
                    tquantidadeKeyReleased(evt);
               }
               public void keyTyped(java.awt.event.KeyEvent evt) {
                    tquantidadeKeyTyped(evt);
               }
          });

          bsair.setText("Sair");
          bsair.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bsairActionPerformed(evt);
               }
          });

          botao_excluir.setText("Excluir");
          botao_excluir.setToolTipText("Excluir Venda procurada");
          botao_excluir.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botao_excluirActionPerformed(evt);
               }
          });

          botao_update.setText("update");
          botao_update.setToolTipText("update Venda");
          botao_update.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botao_updateActionPerformed(evt);
               }
          });

          botao_inserir.setText("Finalizar");
          botao_inserir.setToolTipText("<html>\n<div style=\"text-align:justify; width: 150px\">\nFinalizando a compra poderá clicar sobre este botão\n</div>\n</html>");
          botao_inserir.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botao_inserirActionPerformed(evt);
               }
          });

          jLabel9.setText("Cliente");

          tcliente.setEditable(false);
          tcliente.setBackground(new java.awt.Color(255, 255, 255));
          tcliente.setToolTipText("Campo só para mostrar o cliente pesquisado");

          jLabel10.setText("CPF");

          tcpf.setEditable(false);
          tcpf.setBackground(new java.awt.Color(255, 255, 255));
          tcpf.setToolTipText("Campo só para mostrar o cliente pesquisado");
          tcpf.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyTyped(java.awt.event.KeyEvent evt) {
                    tcpfKeyTyped(evt);
               }
          });

          jLabel11.setText("Telefone");

          ttelefone.setEditable(false);
          ttelefone.setBackground(new java.awt.Color(255, 255, 255));
          ttelefone.setToolTipText("Campo só para mostrar o cliente pesquisado");
          ttelefone.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyTyped(java.awt.event.KeyEvent evt) {
                    ttelefoneKeyTyped(evt);
               }
          });

          jLabel12.setText("Cód. Barra");

          tcodigobarra.addKeyListener(new java.awt.event.KeyAdapter() {
               public void keyPressed(java.awt.event.KeyEvent evt) {
                    tcodigobarraKeyPressed(evt);
               }
               public void keyReleased(java.awt.event.KeyEvent evt) {
                    tcodigobarraKeyReleased(evt);
               }
          });

          blimpar.setText("Limpar");
          blimpar.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    blimparActionPerformed(evt);
               }
          });

          jLabel5.setText("Data");

          dcdtvenda.setToolTipText("Data da venda, o sistema sempre trara a data de hoje");

          tabela_item_venda.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                    {null, null, null},
                    {null, null, null},
                    {null, null, null},
                    {null, null, null}
               },
               new String [] {
                    "Produto", "Preço", "Quantidade"
               }
          ) {
               Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
               };

               public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
               }
          });
          tabela_item_venda.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tabela_item_vendaMouseClicked(evt);
               }
          });
          jScrollPane.setViewportView(tabela_item_venda);

          jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
          jLabel13.setForeground(new java.awt.Color(255, 0, 0));
          jLabel13.setText("Valor Total:");

          ltotalgasto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
          ltotalgasto.setForeground(new java.awt.Color(255, 0, 0));
          ltotalgasto.setText("Total gasto");

          jLabel4.setText("Vencimento");

          dcvencimento.setToolTipText("Data de vencimento da venda");

          jLabel7.setText("Parcelas");

          jLabel14.setText("Forma Pag.");

          cformapagamento.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    cformapagamentoMouseClicked(evt);
               }
          });
          cformapagamento.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cformapagamentoActionPerformed(evt);
               }
          });

          jLabel15.setText("Estado Venda");

          cestadovenda.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cestadovendaActionPerformed(evt);
               }
          });

          jLabel16.setText("Envio");

          cenvio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Retirada", "PAC", "Sedex" }));

          bconsfrete.setText("Cons. Frete");
          bconsfrete.setToolTipText("<html>\n<div style=\"text-align:justify; width: 150px\">\nConsulta frete via internet com conexão aos correios, \ncertifique-se de que tem internet para essa operação caso \ncontrário seu prorgrama poderá travar.\n</div>\n</html>");
          bconsfrete.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bconsfreteActionPerformed(evt);
               }
          });

          badicionar_fpagamento.setText("+");
          badicionar_fpagamento.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    badicionar_fpagamentoActionPerformed(evt);
               }
          });

          badicionar_vendedor.setText("+");
          badicionar_vendedor.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    badicionar_vendedorActionPerformed(evt);
               }
          });

          cvendedor.setToolTipText("Vendedores cadastrados, define o vendedor opcionalmente só para o site");
          cvendedor.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    cvendedorActionPerformed(evt);
               }
          });

          jLabel6.setText("Vendedor");

          javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
          jPanel1.setLayout(jPanel1Layout);
          jPanel1Layout.setHorizontalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(jLabel13)
                              .addGap(18, 18, 18)
                              .addComponent(ltotalgasto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(dcvencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dcdtvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(cformapagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(badicionar_fpagamento)
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cestadovenda, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(127, 127, 127))
                                   .addComponent(jScrollPane)
                                   .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addComponent(jLabel9)
                                             .addComponent(jLabel10)
                                             .addComponent(jLabel12))
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addComponent(tcliente)
                                             .addGroup(jPanel1Layout.createSequentialGroup()
                                                  .addComponent(tcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18, 18, 18)
                                                  .addComponent(jLabel11)
                                                  .addGap(18, 18, 18)
                                                  .addComponent(ttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                  .addGap(18, 18, 18)
                                                  .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                  .addComponent(cenvio, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                             .addComponent(tcodigobarra)))
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(blimpar)
                                        .addGap(18, 18, 18)
                                        .addComponent(bconsfrete)
                                        .addGap(18, 18, 18)
                                        .addComponent(botao_inserir)
                                        .addGap(18, 18, 18)
                                        .addComponent(botao_update)
                                        .addGap(18, 18, 18)
                                        .addComponent(botao_excluir)
                                        .addGap(18, 18, 18)
                                        .addComponent(bsair))
                                   .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(35, 35, 35)
                                        .addComponent(tnome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(tpreco, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(35, 35, 35)
                                        .addComponent(tquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                              .addGap(31, 31, 31))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addComponent(jLabel6)
                              .addGap(27, 27, 27)
                              .addComponent(cvendedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(badicionar_vendedor)
                              .addGap(282, 282, 282))))
          );
          jPanel1Layout.setVerticalGroup(
               jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel9)
                         .addComponent(tcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                         .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                              .addComponent(jLabel10)
                              .addComponent(tcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(ttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addComponent(cenvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addComponent(jLabel12)
                         .addComponent(tcodigobarra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(tnome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                   .addComponent(dcdtvenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(dcvencimento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                   .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                         .addGroup(jPanel1Layout.createSequentialGroup()
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                   .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tpreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tquantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                   .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)))
                              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                   .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                   .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel14)
                         .addComponent(cformapagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(jLabel15)
                         .addComponent(cestadovenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(badicionar_fpagamento))
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel6)
                         .addComponent(cvendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(badicionar_vendedor))
                    .addGap(7, 7, 7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(bsair)
                         .addComponent(botao_excluir)
                         .addComponent(botao_update)
                         .addComponent(botao_inserir)
                         .addComponent(blimpar)
                         .addComponent(bconsfrete))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                         .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(ltotalgasto, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
          );

          jTabbedPane1.addTab("Cadastro Venda", jPanel1);

          bprocura_venda.setText("Procurar");
          bprocura_venda.setToolTipText("Procurar pelo nome do cliente");
          bprocura_venda.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    bprocura_vendaActionPerformed(evt);
               }
          });

          tnomeproc.setToolTipText("Procura por nome do cliente");

          tabela_venda.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
               },
               new String [] {
                    "Código", "Data", "Cliente", "Valor"
               }
          ));
          tabela_venda.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tabela_vendaMouseClicked(evt);
               }
          });
          jScrollPane2.setViewportView(tabela_venda);

          javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
          jPanel3.setLayout(jPanel3Layout);
          jPanel3Layout.setHorizontalGroup(
               jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(38, Short.MAX_VALUE)
                    .addComponent(tnomeproc, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bprocura_venda)
                    .addGap(22, 22, 22))
               .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                         .addGap(27, 27, 27)
                         .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addContainerGap(21, Short.MAX_VALUE)))
          );
          jPanel3Layout.setVerticalGroup(
               jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(bprocura_venda)
                         .addComponent(tnomeproc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(454, Short.MAX_VALUE))
               .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                         .addContainerGap(55, Short.MAX_VALUE)
                         .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(37, 37, 37)))
          );

          jTabbedPane1.addTab("Procura Venda", jPanel3);

          jLabel8.setText("Cliente");

          botao_proc_cliente.setText("Procurar");
          botao_proc_cliente.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                    botao_proc_clienteActionPerformed(evt);
               }
          });

          tabela_cliente.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
               },
               new String [] {
                    "Código", "Nome", "CPF", "Telefone"
               }
          ));
          tabela_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tabela_clienteMouseClicked(evt);
               }
          });
          jScrollPane4.setViewportView(tabela_cliente);

          jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Endereços do cliente para entrega"));

          tabela_endereco.setModel(new javax.swing.table.DefaultTableModel(
               new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
               },
               new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
               }
          ));
          tabela_endereco.addMouseListener(new java.awt.event.MouseAdapter() {
               public void mouseClicked(java.awt.event.MouseEvent evt) {
                    tabela_enderecoMouseClicked(evt);
               }
          });
          jScrollPane1.setViewportView(tabela_endereco);

          javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
          jPanel2.setLayout(jPanel2Layout);
          jPanel2Layout.setHorizontalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap())
          );
          jPanel2Layout.setVerticalGroup(
               jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addContainerGap())
          );

          javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
          jPanel4.setLayout(jPanel4Layout);
          jPanel4Layout.setHorizontalGroup(
               jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                         .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jScrollPane4)
                         .addGroup(jPanel4Layout.createSequentialGroup()
                              .addGap(0, 20, Short.MAX_VALUE)
                              .addComponent(jLabel8)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(tnome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                              .addComponent(botao_proc_cliente)))
                    .addGap(43, 43, 43))
          );
          jPanel4Layout.setVerticalGroup(
               jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                         .addComponent(jLabel8)
                         .addComponent(tnome_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addComponent(botao_proc_cliente))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(25, 25, 25))
          );

          jTabbedPane1.addTab("Procura Cliente", jPanel4);

          javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
          getContentPane().setLayout(layout);
          layout.setHorizontalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jTabbedPane1)
          );
          layout.setVerticalGroup(
               layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
          );

          pack();
     }// </editor-fold>//GEN-END:initComponents

     private void tquantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tquantidadeKeyReleased
          int qtd_digitada = Integer.valueOf(tquantidade.getText());
          if((produto.getQuantidade() > 0  && produto.getEstoquebaixo() > 0) && (produto != null && produto.getCodigo() != null)){
               if((produto.getQuantidade() < qtd_digitada)){
                    JOptionPane.showMessageDialog(null, "Não pode inserir quantidade maiores do que há em estoque");
                    tquantidade.setText(String.valueOf(produto.getQuantidade()));
               }
          }
          if(tquantidade.getText() != null && qtd_digitada != ivenda.getQuantidade() && qtd_digitada > 0){
               for(int i = 0; i < obj_ivenda.size(); i++){
                    if(ivenda.getProduto().getCodigo() == produto.getCodigo()){
                         ivenda.setQuantidade(qtd_digitada);
                         obj_ivenda.set(i, ivenda);
                         listar_ivenda();
                         break;
                    }
               }
          }
     }//GEN-LAST:event_tquantidadeKeyReleased

     private void tquantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tquantidadeKeyTyped
          mas.mascaraInteiro(evt);
     }//GEN-LAST:event_tquantidadeKeyTyped

     private void bsairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsairActionPerformed
          this.dispose();
     }//GEN-LAST:event_bsairActionPerformed

     private void botao_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluirActionPerformed
          String msg      = "";
          int    response = JOptionPane.showConfirmDialog(null, "Tem certeza disso,\n"
               + "Você quer excluir?", "Confirmação de excluir:",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
          if (response == JOptionPane.YES_OPTION) {
               if(venda != null && venda.getCodigo() != null){
                    msg = vrn.excluirVenda(cx, venda);
               }else{
                    JOptionPane.showMessageDialog(null, "Para excluir escolha antes uma venda que tenha sido gravada no banco");
               }
          }
          if(msg != null && !msg.isEmpty()){
               JOptionPane.showMessageDialog(null, msg);
          }else{
               obj_venda.remove(venda);
               listar_venda();
               JOptionPane.showMessageDialog(null, "Excluido com sucesso");
          }
     }//GEN-LAST:event_botao_excluirActionPerformed

     private void botao_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_updateActionPerformed
          setaVenda();
          String msg = vrn.updateVenda(cx, venda);
          if(msg != null && !msg.isEmpty()){
               JOptionPane.showMessageDialog(null, msg);
          }else{
               for(int i = 0; i < obj_venda.size(); i++){
                    if(obj_venda.get(i).getCodigo() == venda.getCodigo()){
                         obj_venda.set(i, venda);
                         listar_venda();
                         break;
                    }
               }
               JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
          }
     }//GEN-LAST:event_botao_updateActionPerformed

     private void botao_inserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_inserirActionPerformed
          String msg = "";
          venda = new Venda();
          setaVenda();
          if(venda.getParcela() > 1){
               int dia        = venda.getVencimento().getDay();
               int mes        = venda.getVencimento().getMonth();
               int ano        = venda.getVencimento().getYear() + 1900;
               int parcela    = venda.getParcela();
               for(int i = 0; i < venda.getParcela(); i++){
                    venda.setVencimento(mas.convertePDate(dia + "/" + mes + "/" + ano));
                    venda.setParcela(parcela);
                    mes++;
                    parcela--;
                    if(mes == 12){
                         mes = 1;
                         ano++;
                    }
                    msg = vrn.inserirVenda(cx, venda);
                    if(msg != null && !msg.isEmpty()){
                         break;
                    }
               }
          }else{
               msg = vrn.inserirVenda(cx, venda);
          }
          if(msg != null && !msg.isEmpty()){
               JOptionPane.showMessageDialog(null, msg);
          }else{
               obj_venda.add(venda);
               listar_venda();
               JOptionPane.showMessageDialog(null, "Inserido com sucesso");
          }
     }//GEN-LAST:event_botao_inserirActionPerformed

     private void tcpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcpfKeyTyped
          mas.mascaraInteiro(evt);
     }//GEN-LAST:event_tcpfKeyTyped

     private void ttelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ttelefoneKeyTyped
          mas.mascaraInteiro(evt);
     }//GEN-LAST:event_ttelefoneKeyTyped

     private void tcodigobarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcodigobarraKeyPressed
          limpar();
     }//GEN-LAST:event_tcodigobarraKeyPressed

     private void tcodigobarraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcodigobarraKeyReleased
          String msg = "";
          try{
               produto = prn.procuraCodigoBarra(cx, tcodigobarra.getText());
               if(produto != null && produto.getCategoria() != null && produto.getNome() != null){
                    if(produto.getQuantidade() > 0 && produto.getEstoquebaixo() > 0){
                         for(int i = 0; i < obj_ivenda.size(); i++){
                              if(obj_ivenda.get(i).getCodigo() == produto.getCodigo() && obj_ivenda.get(i).getQuantidade() >= produto.getQuantidade()){
                                   msg = "Não pode inserir este produto, o estoque dele já foi utilizado";
                                   limpar();
                                   break;
                              }
                         }
                    }
                    if(msg.isEmpty()){
                         desconto = drn.procuraCodProduto(cx, produto.getCodigo());
                         if((desconto != null && desconto.getCodigo() != null && desconto.getProduto() != null)
                              && (produto.getQuantidade() >= desconto.getQtdmin() && produto.getQuantidade() <= desconto.getQtdmax())){
                              double res = produto.getPrecovenda() - desconto.getValor();
                              tpreco.setText(Mascara.formatMoeda(res));
                         }else{
                              tpreco.setText(Mascara.formatMoeda(produto.getPrecovenda()));
                         }

                         tnome_produto.setText(produto.getNome());
                         if(produto.getQuantidade() > 0){
                              tquantidade.setText(String.valueOf(produto.getQuantidade()));
                         }else{
                              tquantidade.setToolTipText("Produto sem controle de estoque pode pedir quantos quiser");
                         }

                         ivenda = new ItemVenda();
                         if(tquantidade.getText() != null){
                              ivenda.setQuantidade(Integer.valueOf(tquantidade.getText()));
                         }
                         ivenda.setProduto(produto);

                         venda.setValor(venda.getValor() + produto.getPrecovenda());
                         ivenda.setVenda(venda);
                         ivenda.setValor(produto.getPrecovenda());

                         obj_ivenda.add(ivenda);
                         listar_ivenda();
                         ltotalgasto.setText(Mascara.formatMoeda(venda.getValor()));

                         int       num       = tabela_item_venda.getHeight() + 1;
                         Point     ponto     = new Point((int) jScrollPane.getViewport().getViewPosition().getX(), (int) num);
                         jScrollPane.getViewport().setViewPosition(ponto);
                    }
               }
          }catch(Exception ex){
               msg = "Erro causado por\n" + ex;
          }
          if(msg != null && !msg.isEmpty()){
               JOptionPane.showMessageDialog(null, msg);
          }
     }//GEN-LAST:event_tcodigobarraKeyReleased

     private void blimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blimparActionPerformed
          limpar();
          ltotalgasto.setText("");
          obj_ivenda = new ArrayList();
          listar_ivenda();
     }//GEN-LAST:event_blimparActionPerformed

     private void tabela_item_vendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_item_vendaMouseClicked
          ivenda = obj_ivenda.get(tabela_item_venda.getSelectedRow());
          setaTelaItemVenda();
     }//GEN-LAST:event_tabela_item_vendaMouseClicked

     private void cformapagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cformapagamentoActionPerformed
          if(obj_forma != null && !obj_forma.isEmpty() && cformapagamento.getSelectedIndex() != -1){
               forma = obj_forma.get(cformapagamento.getSelectedIndex());
          }
     }//GEN-LAST:event_cformapagamentoActionPerformed

     private void cestadovendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cestadovendaActionPerformed
          if(obj_estadov != null && !obj_estadov.isEmpty() && cestadovenda.getSelectedIndex() != -1){
               estado_venda = obj_estadov.get(cestadovenda.getSelectedIndex());
          }
     }//GEN-LAST:event_cestadovendaActionPerformed

     private void bconsfreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bconsfreteActionPerformed
          String servico = "";
          String msg     = "";
          if(!"Retirada".equals(cenvio.getSelectedItem().toString())){
               if(cenvio.getSelectedItem().toString().equals("PAC")){
                    servico = "41106";
               }else{
                    if(cenvio.getSelectedItem().toString().equals("Sedex")){
                         servico = "40010";
                    }
               }
               String cep_origem   = "84010-110";
               sfrete              = frete.procuraFrete(cep_origem, endereco.getCep(), servico);
               if(sfrete != null){
                    FreteServicoVO fsvo =  sfrete.getFrete();
                    if(fsvo.getErro() == 1){
                         msg = fsvo.getMsgErro();
                    }else{
                         msg += "\nPrazo de Entrega:"             + fsvo.getPrazoEntrega()          +
                         "\nValor:"                        + fsvo.getValor()                 +
                         "\nValor para aviso recebimento:" + fsvo.getValorAvisoRecebimento() +
                         "\nValor para mão própria:"       + fsvo.getValorMaoPropria()       +
                         "\nEntrega Domiciliar:"           + fsvo.getEntregaDomiciliar()     +
                         "\nEntrega Sabádo:"               + fsvo.getEntregaSabado();
                    }
               }
          }else{
               msg = "Retirada na loja são com frete 0 e prazo 0 de entrega";
          }
          if(msg != null && !msg.isEmpty()){
               JOptionPane.showMessageDialog(null, msg);
          }
     }//GEN-LAST:event_bconsfreteActionPerformed

     private void bprocura_vendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprocura_vendaActionPerformed
          obj_venda = vrn.procuraNomeParcial(cx, tnomeproc.getText());
          if(obj_venda != null && !obj_venda.isEmpty()){
               listar_venda();
          }else{
               JOptionPane.showMessageDialog(null, "Nada encontrado");
          }
     }//GEN-LAST:event_bprocura_vendaActionPerformed

     private void tabela_vendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_vendaMouseClicked
          venda = obj_venda.get(tabela_venda.getSelectedRow());
          SetaTelaVenda();
     }//GEN-LAST:event_tabela_vendaMouseClicked

     private void botao_proc_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_proc_clienteActionPerformed
          obj_pessoa = pern.procuraNomeParcial(cx, tnome_cliente.getText());
          if(obj_pessoa != null && !obj_pessoa.isEmpty()){
               listar_pessoa();
          }else{
               JOptionPane.showMessageDialog(null, "Nada encontrado");
          }
     }//GEN-LAST:event_botao_proc_clienteActionPerformed

     private void tabela_clienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_clienteMouseClicked
          pessoa = obj_pessoa.get(tabela_cliente.getSelectedRow());
          SetaTelaCliente();
     }//GEN-LAST:event_tabela_clienteMouseClicked

     private void tabela_enderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_enderecoMouseClicked
          if(obj_endereco != null && !obj_endereco.isEmpty()){
               endereco = obj_endereco.get(tabela_endereco.getSelectedRow());
          }
     }//GEN-LAST:event_tabela_enderecoMouseClicked

     private void badicionar_fpagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badicionar_fpagamentoActionPerformed
          novaforma = true;
          new JFFormaPagamento(cx).setVisible(true);
     }//GEN-LAST:event_badicionar_fpagamentoActionPerformed

     private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
          if(novaforma == true){
               carregaFormaPagamento();
          }
          if(atualizavendedor  == true){
               carregaVendedor();
               atualizavendedor = false;
          }            
     }//GEN-LAST:event_jTabbedPane1FocusGained

     private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
          carregaFormaPagamento();
          carregaVendedor();
     }//GEN-LAST:event_formWindowOpened

     private void cformapagamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cformapagamentoMouseClicked
          if(novaforma == true){
               carregaFormaPagamento();
               novaforma = false;
          }
     }//GEN-LAST:event_cformapagamentoMouseClicked

     private void badicionar_vendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_badicionar_vendedorActionPerformed
          atualizavendedor = true;
          new JFGerenciaVendedor(cx).setVisible(true);
     }//GEN-LAST:event_badicionar_vendedorActionPerformed

     private void cvendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cvendedorActionPerformed
          try{
               if(vendedor == null || vendedor.getNome() == null){
                    if((obj_vendedor != null && !obj_vendedor.isEmpty() && !"Nenhuma".equals(cvendedor.getSelectedItem().toString())) && cvendedor.getSelectedIndex() != -1){
                         vendedor = obj_vendedor.get(cvendedor.getSelectedIndex() - 1);
                    }
               }
          }catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Erro causado por:\n" + ex);
          }
     }//GEN-LAST:event_cvendedorActionPerformed

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
          } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Erro causado por:\n" + ex);
          }
          //</editor-fold>

          /* Create and display the form */
          java.awt.EventQueue.invokeLater(new Runnable() {
               @Override
               public void run() {
                    new JFVenda().setVisible(true);
               }
          });
     }
     // Variables declaration - do not modify//GEN-BEGIN:variables
     private javax.swing.JButton badicionar_fpagamento;
     private javax.swing.JButton badicionar_vendedor;
     private javax.swing.JButton bconsfrete;
     private javax.swing.JButton blimpar;
     private javax.swing.JButton botao_update;
     private javax.swing.JButton botao_excluir;
     private javax.swing.JButton botao_inserir;
     private javax.swing.JButton botao_proc_cliente;
     private javax.swing.JButton bprocura_venda;
     private javax.swing.JButton bsair;
     private javax.swing.JComboBox cenvio;
     private javax.swing.JComboBox cestadovenda;
     private javax.swing.JComboBox cformapagamento;
     private javax.swing.JComboBox cvendedor;
     private com.toedter.calendar.JDateChooser dcdtvenda;
     private com.toedter.calendar.JDateChooser dcvencimento;
     private javax.swing.JLabel jLabel1;
     private javax.swing.JLabel jLabel10;
     private javax.swing.JLabel jLabel11;
     private javax.swing.JLabel jLabel12;
     private javax.swing.JLabel jLabel13;
     private javax.swing.JLabel jLabel14;
     private javax.swing.JLabel jLabel15;
     private javax.swing.JLabel jLabel16;
     private javax.swing.JLabel jLabel2;
     private javax.swing.JLabel jLabel3;
     private javax.swing.JLabel jLabel4;
     private javax.swing.JLabel jLabel5;
     private javax.swing.JLabel jLabel6;
     private javax.swing.JLabel jLabel7;
     private javax.swing.JLabel jLabel8;
     private javax.swing.JLabel jLabel9;
     private javax.swing.JPanel jPanel1;
     private javax.swing.JPanel jPanel2;
     private javax.swing.JPanel jPanel3;
     private javax.swing.JPanel jPanel4;
     private javax.swing.JScrollPane jScrollPane;
     private javax.swing.JScrollPane jScrollPane1;
     private javax.swing.JScrollPane jScrollPane2;
     private javax.swing.JScrollPane jScrollPane4;
     private javax.swing.JTabbedPane jTabbedPane1;
     private javax.swing.JTextField jTextField1;
     private javax.swing.JLabel ltotalgasto;
     private javax.swing.JTable tabela_cliente;
     private javax.swing.JTable tabela_endereco;
     private javax.swing.JTable tabela_item_venda;
     private javax.swing.JTable tabela_venda;
     private javax.swing.JTextField tcliente;
     private javax.swing.JTextField tcodigobarra;
     private javax.swing.JTextField tcpf;
     private javax.swing.JTextField tnome_cliente;
     private javax.swing.JTextField tnome_produto;
     private javax.swing.JTextField tnomeproc;
     private javax.swing.JTextField tpreco;
     private javax.swing.JTextField tquantidade;
     private javax.swing.JTextField ttelefone;
     // End of variables declaration//GEN-END:variables

     private void listar_endereco() {
            tabela_endereco.setModel(new TableModel(titulo_endereco, obj_endereco.size(), titulo_endereco.length));
            for(int i = 0; i < obj_endereco.size(); i++){
                    tabela_endereco.setValueAt(obj_endereco.get(i).getCodigo(), i, 0);
                    tabela_endereco.setValueAt(obj_endereco.get(i).getCep(), i, 1);
                    tabela_endereco.setValueAt(obj_endereco.get(i).getEndereco(), i, 2);
                    tabela_endereco.setValueAt(obj_endereco.get(i).getEstado().getNome(), i, 3);
            }
            tabela_endereco.setAutoCreateRowSorter(true); 
     }     
     
     private void setaVenda() {
          venda.setData(dcdtvenda.getDate());
          venda.setVencimento(dcvencimento.getDate());
          if(!"Retirada".equals(cenvio.getSelectedItem().toString())){
               venda.setEnvio("Correios(" + cenvio.getSelectedItem().toString() + ")");
          }else{
               venda.setEnvio(cenvio.getSelectedItem().toString());
          }
          
          venda.setEstadovenda(estado_venda);
          venda.setFrete(0);
          venda.setPessoa(pessoa);
          if(vendedor != null && vendedor.getCodigo() != null){
               venda.setCodvendedor(vendedor.getCodigo());
          }
          String preco = ltotalgasto.getText();
          preco        = preco.replace("R$ ", "");
          venda.setValor(Mascara.formatToDouble(preco));  
     }

     private void SetaTelaVenda() {
          vendedor = vern.procuraCodVendedor(cx, venda.getCodvendedor());
          if(vendedor != null && vendedor.getCodigo() != null){
               cvendedor.setSelectedItem(vendedor.getNome().toUpperCase());
          }
          dcdtvenda.setDate(venda.getData());
          dcvencimento.setDate(venda.getVencimento());
          estado_venda = venda.getEstadovenda();
          cestadovenda.setSelectedItem(estado_venda.getNome());
          ltotalgasto.setText(Mascara.formatMoeda(venda.getValor()));
          
          pessoa = venda.getPessoa();
          SetaTelaCliente();
          obj_ivenda = ivrn.procuraVenda(cx, venda.getCodigo());
          if(obj_ivenda != null && !obj_ivenda.isEmpty()){
               listar_ivenda();
          }
     }     
     
     /**Lista clientes ao se pesquisar**/
     private void listar_pessoa() {
            tabela_cliente.setModel(new TableModel(titulo_pessoa, obj_pessoa.size(), titulo_pessoa.length));
            for(int i = 0; i < obj_pessoa.size(); i++){
                    tabela_cliente.setValueAt(obj_pessoa.get(i).getCodigo(), i, 0);
                    tabela_cliente.setValueAt(obj_pessoa.get(i).getNome() + " " + obj_pessoa.get(i).getSobrenome(), i, 1);
                    tabela_cliente.setValueAt(obj_pessoa.get(i).getCpf(), i, 2);
                    tabela_cliente.setValueAt(obj_pessoa.get(i).getTelefone(), i, 3);
            }
            tabela_cliente.setAutoCreateRowSorter(true);   
     }

     private void SetaTelaCliente() {
          tcliente.setText(pessoa.getNome() + " " + pessoa.getSobrenome());
          tcpf.setText(pessoa.getCpf());
          ttelefone.setText(pessoa.getTelefone());
          obj_endereco = enrn.procuraCodPessoa(cx, pessoa.getCodigo());
          listar_endereco();
     }

     private void listar_venda() {
            tabela_venda.setModel(new TableModel(titulo_venda, obj_venda.size(), titulo_venda.length));
            for(int i = 0; i < obj_venda.size(); i++){
                    tabela_venda.setValueAt(obj_venda.get(i).getCodigo(), i, 0);
                    if(obj_venda.get(i).getData() != null){
                         tabela_venda.setValueAt(mas.mascaraData("dd/MM/yyyy", obj_venda.get(i).getData()), i, 1);
                    }else{
                         tabela_venda.setValueAt("Sem data", i, 1);
                    }
                    tabela_venda.setValueAt(obj_venda.get(i).getPessoa().getNome().toUpperCase() + " " + obj_venda.get(i).getPessoa().getSobrenome().toUpperCase(), i, 2);
                    tabela_venda.setValueAt(Mascara.formatMoeda(obj_venda.get(i).getValor()), i, 3);
            }
            tabela_venda.setAutoCreateRowSorter(true);   
     }

     private void listar_ivenda() {
            tabela_item_venda.setModel(new TableModel(titulo_ivenda, obj_ivenda.size(), titulo_ivenda.length));
            for(int i = 0; i < obj_ivenda.size(); i++){
                    tabela_item_venda.setValueAt(obj_ivenda.get(i).getProduto().getNome(), i, 0);
                    tabela_item_venda.setValueAt(Mascara.formatMoeda(obj_ivenda.get(i).getValor()), i, 1);
                    tabela_item_venda.setValueAt(obj_ivenda.get(i).getQuantidade(), i, 2);
                    desconto = drn.procuraCodProduto(cx, obj_ivenda.get(i).getProduto().getCodigo());
                    tabela_item_venda.setValueAt(Mascara.formatMoeda(desconto.getValor()), i, 2);
            }
            tabela_item_venda.setAutoCreateRowSorter(true); 
     }

     private void limpar() {
          tcodigobarra.setText("");
          tnome_produto.setText("");
          tpreco.setText("");
          tquantidade.setText("");
     }

     private void setaTelaItemVenda() {
          tcodigobarra.setText(ivenda.getProduto().getCodigobarra());
          tnome_produto.setText(ivenda.getProduto().getNome());
          tpreco.setText(Mascara.formatMoeda(ivenda.getValor()));
          tquantidade.setText(String.valueOf(ivenda.getQuantidade()));
          if(ivenda.getVenda() != null && ivenda.getVenda().getData() != null){
               dcdtvenda.setDate(ivenda.getVenda().getData());
          }
          if(ivenda.getVenda() != null && ivenda.getVenda().getVencimento() != null){
               dcvencimento.setDate(ivenda.getVenda().getVencimento());
          }
     }

     private void carregaFormaPagamento() {
          obj_forma = frn.procuraTodos(cx);
          if(obj_forma != null && !obj_forma.isEmpty()){
               cformapagamento.removeAllItems();
               for (FormaPagamento fp : obj_forma) {
                    cformapagamento.addItem(fp.getNome().toUpperCase());
               }
          }
     }
     
     private void carregaVendedor() {
          if(vendedor == null || vendedor.getNome() == null || vendedor.getCodigo() == null){
               obj_vendedor = vern.procuraTodos(cx);
               if(obj_vendedor != null && !obj_vendedor.isEmpty()){
                    cvendedor.removeAllItems();
                    cvendedor.addItem("Nenhuma");
                    for (Vendedor v : obj_vendedor) {
                         cvendedor.addItem(v.getNome().toUpperCase());
                    }               
               }else{
                    cvendedor.setToolTipText("Nenhum vendedor cadastrado");
               }
          }
     }       

     private void informacoesVendedor() {
          if(usuario != null && usuario.getCodvendedor() != 0){
               vendedor = vern.procuraCodVendedor(cx, usuario.getCodvendedor());
               cvendedor.addItem(vendedor.getNome().toUpperCase());
          }
     }
}
