package frames;

import frames.FrameAutorizacao.CenterRenderer;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.Autorizacao;
import model.AutorizacaoDao;
import model.Competencia;
import model.Conexao;
import model.Estabelecimento;
import model.OperadorLogado;
import model.Rubrica;
import net.sf.jasperreports.engine.JRException;
import util.CurrencyWriter;
import util.Funcoes;
import util.Relatorio;

/**
 * @author luciano
 */
public class FrameAutorizacao extends javax.swing.JDialog {

  Connection conexao = Conexao.getConexao();
  InputStream inputStream = null;
  String titulo = null;
  InetAddress addr = null;
  String arquivo = null;
  Map param = new HashMap();
  CurrencyWriter cw = new CurrencyWriter();

  class CenterRenderer extends DefaultTableCellRenderer {

    public CenterRenderer() {
      setHorizontalAlignment(CENTER);
    }
  }
  private int operador_id = OperadorLogado.getInstance().getID();
  String sql = null;
  Statement stmt = null;
  ResultSet result = null;
  DefaultTableModel model = null;
  int opcao = 0;
  AutorizacaoDao dao = null;

  public FrameAutorizacao(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    model = (DefaultTableModel) jTable1.getModel();
    try {
      stmt = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
    jTabbedPane1.setSelectedIndex(0);
    TableCellRenderer centerRenderer = new CenterRenderer();
    TableColumn col_id = jTable1.getColumnModel().getColumn(0);
    TableColumn col_cnes = jTable1.getColumnModel().getColumn(1);
    col_id.setCellRenderer(centerRenderer);
    col_cnes.setCellRenderer(centerRenderer);
    editPesquisar.requestFocus();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    btPesquisar = new javax.swing.JButton();
    editPesquisar = new javax.swing.JTextField();
    jPanel4 = new javax.swing.JPanel();
    radioCompetencia = new javax.swing.JRadioButton();
    radioEstabelecimento = new javax.swing.JRadioButton();
    radioRubrica = new javax.swing.JRadioButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    lblCodigo = new javax.swing.JLabel();
    editUnidade = new javax.swing.JTextField();
    editRubrica = new javax.swing.JTextField();
    editData = new javax.swing.JFormattedTextField();
    jScrollPane2 = new javax.swing.JScrollPane();
    editObservacao = new javax.swing.JTextArea();
    btNovo = new javax.swing.JButton();
    btAlterar = new javax.swing.JButton();
    btSalvar = new javax.swing.JButton();
    btCancelar = new javax.swing.JButton();
    btExcluir = new javax.swing.JButton();
    lblUnidade = new javax.swing.JLabel();
    lblRubrica = new javax.swing.JLabel();
    lblValor = new javax.swing.JLabel();
    idUnidade = new javax.swing.JLabel();
    idRubrica = new javax.swing.JLabel();
    editValor = new javax.swing.JTextField();
    btImprimir = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Autorização");
    setBounds(new java.awt.Rectangle(0, 0, 830, 410));
    setModalExclusionType(null);
    setModalityType(null);
    setResizable(false);
    addWindowFocusListener(new java.awt.event.WindowFocusListener() {
      public void windowGainedFocus(java.awt.event.WindowEvent evt) {
        formWindowGainedFocus(evt);
      }
      public void windowLostFocus(java.awt.event.WindowEvent evt) {
      }
    });
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filtrar.gif"))); // NOI18N
    btPesquisar.setText("Pesquisar");
    btPesquisar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btPesquisarActionPerformed(evt);
      }
    });
    jPanel3.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 130, 30));

    editPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        editPesquisarKeyPressed(evt);
      }
    });
    jPanel3.add(editPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 310, 30));

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));
    jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    buttonGroup1.add(radioCompetencia);
    radioCompetencia.setSelected(true);
    radioCompetencia.setText("Competência");
    radioCompetencia.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        radioCompetenciaActionPerformed(evt);
      }
    });
    jPanel4.add(radioCompetencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

    buttonGroup1.add(radioEstabelecimento);
    radioEstabelecimento.setText("Estabelecimento");
    radioEstabelecimento.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        radioEstabelecimentoActionPerformed(evt);
      }
    });
    jPanel4.add(radioEstabelecimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, 30));

    buttonGroup1.add(radioRubrica);
    radioRubrica.setText("Rubrica");
    radioRubrica.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        radioRubricaActionPerformed(evt);
      }
    });
    jPanel4.add(radioRubrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, 30));

    jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 5, 360, 55));

    jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 820, 70));

    jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null}
      },
      new String [] {
        "Cód", "Cnes", "Estabelecimento", "Valor"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jTable1.setColumnSelectionAllowed(true);
    jTable1.setRowHeight(22);
    jTable1.getTableHeader().setReorderingAllowed(false);
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTable1MouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jTable1);
    jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jTable1.getColumnModel().getColumn(0).setResizable(false);
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(6);
    jTable1.getColumnModel().getColumn(1).setResizable(false);
    jTable1.getColumnModel().getColumn(1).setPreferredWidth(15);
    jTable1.getColumnModel().getColumn(2).setResizable(false);
    jTable1.getColumnModel().getColumn(2).setPreferredWidth(430);
    jTable1.getColumnModel().getColumn(3).setResizable(false);
    jTable1.getColumnModel().getColumn(3).setPreferredWidth(40);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 290));

    jTabbedPane1.addTab("Listagem", jPanel1);

    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setText("Autorização:");
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 24, -1, -1));

    jLabel2.setText("Unidade:");
    jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 60, -1, -1));

    jLabel3.setText("Rubrica:");
    jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 100, -1, -1));

    jLabel4.setText("Valor:");
    jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 140, -1, -1));

    jLabel5.setText("Data:");
    jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 180, -1, -1));

    jLabel6.setText("Observação:");
    jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 220, -1, -1));

    lblCodigo.setText(" ");
    jPanel2.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 24, 50, -1));

    editUnidade.setFont(new java.awt.Font("Andale Mono", 0, 14));
    editUnidade.setEnabled(false);
    editUnidade.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        editUnidadeKeyPressed(evt);
      }
    });
    jPanel2.add(editUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 50, 80, 30));

    editRubrica.setFont(new java.awt.Font("Andale Mono", 0, 14));
    editRubrica.setEnabled(false);
    editRubrica.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        editRubricaKeyPressed(evt);
      }
    });
    jPanel2.add(editRubrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 90, 80, 30));

    editData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
    editData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    editData.setEnabled(false);
    jPanel2.add(editData, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 170, 80, 30));

    editObservacao.setColumns(20);
    editObservacao.setRows(5);
    editObservacao.setEnabled(false);
    jScrollPane2.setViewportView(editObservacao);

    jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 220, 700, 100));

    btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novo.png"))); // NOI18N
    btNovo.setText("Novo");
    btNovo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btNovoActionPerformed(evt);
      }
    });
    jPanel2.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 130, 30));

    btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alterar.png"))); // NOI18N
    btAlterar.setText("Alterar");
    btAlterar.setEnabled(false);
    btAlterar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btAlterarActionPerformed(evt);
      }
    });
    jPanel2.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 340, 130, 30));

    btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
    btSalvar.setText("Salvar");
    btSalvar.setEnabled(false);
    btSalvar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btSalvarActionPerformed(evt);
      }
    });
    jPanel2.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 340, 130, 30));

    btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
    btCancelar.setText("Cancelar");
    btCancelar.setEnabled(false);
    btCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCancelarActionPerformed(evt);
      }
    });
    jPanel2.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 340, 130, 30));

    btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excluir.png"))); // NOI18N
    btExcluir.setText("Excluir");
    btExcluir.setEnabled(false);
    btExcluir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btExcluirActionPerformed(evt);
      }
    });
    jPanel2.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(538, 340, 130, 30));

    lblUnidade.setFont(new java.awt.Font("Andale Mono", 0, 14));
    lblUnidade.setText(" ");
    jPanel2.add(lblUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 610, 30));

    lblRubrica.setFont(new java.awt.Font("Andale Mono", 0, 14));
    lblRubrica.setText(" ");
    jPanel2.add(lblRubrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 610, 30));

    lblValor.setFont(new java.awt.Font("Andale Mono", 0, 12));
    lblValor.setText(" ");
    jPanel2.add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 610, 40));
    jPanel2.add(idUnidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 57, -1, -1));
    jPanel2.add(idRubrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 95, -1, -1));

    editValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
    editValor.setEnabled(false);
    editValor.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        editValorFocusLost(evt);
      }
    });
    jPanel2.add(editValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 130, 80, 30));

    btImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imprimir.gif"))); // NOI18N
    btImprimir.setText("Imprimir");
    btImprimir.setEnabled(false);
    btImprimir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btImprimirActionPerformed(evt);
      }
    });
    jPanel2.add(btImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 130, 30));

    jTabbedPane1.addTab("Emissão", jPanel2);

    getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 410));

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-835)/2, (screenSize.height-441)/2, 835, 441);
  }// </editor-fold>//GEN-END:initComponents

  private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
    Funcoes.removeLinha(model);
    if (!radioCompetencia.isSelected() && editPesquisar.getText().equals("")) {
      Funcoes.informacao("Valor da Pesquisa não pode ser vazio!");
      editPesquisar.requestFocusInWindow();
    } else {
      try {
        dao = new AutorizacaoDao();
        String where = null;
        if (radioCompetencia.isSelected()) {
          where = "where a.competencia_id=" + Competencia.getCodCompetencia();
        } else if (radioEstabelecimento.isSelected()) {
          where = "where b.cnes='" + editPesquisar.getText() + "'";
        } else {
          where = "where c.codigo='" + editPesquisar.getText() + "'";
        }
        sql = "select a.id, b.cnes, b.nome, c.codigo as cod_rubrica, c.descricao as descricao_rubrica, c.conta, d.mes, d.ano, a.valor "
                + "from autorizacoes a "
                + "inner join estabelecimentos b on a.estabelecimento_id=b.id "
                + "inner join rubricas c on a.rubrica_id=c.id "
                + "inner join competencias d on a.competencia_id=d.id " + where + " order by a.id";
        result = stmt.executeQuery(sql);
        while (result.next()) {
          model.addRow(new Object[]{
                    result.getInt("id"),
                    result.getString("cnes"),
                    result.getString("nome"),
                    result.getDouble("valor")
                  });
        }
        jTable1.setModel(model);
      } catch (SQLException erro) {
        Funcoes.erro(erro.getMessage());
      }
    }
  }//GEN-LAST:event_btPesquisarActionPerformed

  private void editPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editPesquisarKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      btPesquisar.doClick();
    }
  }//GEN-LAST:event_editPesquisarKeyPressed

  private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    editPesquisar.requestFocus();
  }//GEN-LAST:event_formWindowGainedFocus

  private void radioCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCompetenciaActionPerformed
    editPesquisar.requestFocus();
  }//GEN-LAST:event_radioCompetenciaActionPerformed

  private void radioEstabelecimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEstabelecimentoActionPerformed
    editPesquisar.requestFocus();
  }//GEN-LAST:event_radioEstabelecimentoActionPerformed

  private void radioRubricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRubricaActionPerformed
    editPesquisar.requestFocus();
  }//GEN-LAST:event_radioRubricaActionPerformed

  private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    if (evt.getClickCount() == 2) {
      try {
        jTabbedPane1.setSelectedIndex(1);
        int linha = jTable1.getSelectedRow();
        String codigo = model.getValueAt(linha, 0).toString();
        sql = "select a.id, b.cnes, b.nome, c.codigo as cod_rubrica, c.descricao as descricao_rubrica, c.conta, d.mes, d.ano, a.valor, "
                + "to_char(a.data, 'dd/mm/yyyy') as data, a.observacoes, a.rubrica_id as id_rub, a.estabelecimento_id as id_estab "
                + "from autorizacoes a "
                + "inner join estabelecimentos b on a.estabelecimento_id=b.id "
                + "inner join rubricas c on a.rubrica_id=c.id "
                + "inner join competencias d on a.competencia_id=d.id where a.id=" + codigo + " order by a.id";
        result = stmt.executeQuery(sql);
        while (result.next()) {
          lblCodigo.setText(String.format("%04d", result.getInt("id")));
          editUnidade.setText(result.getString("cnes"));
          editRubrica.setText(result.getString("cod_rubrica"));
          editValor.setText(String.valueOf(result.getDouble("valor")));
          editData.setText(result.getString("data"));
          editObservacao.setText(result.getString("observacoes"));
          lblUnidade.setText(result.getString("nome"));
          lblRubrica.setText(result.getString("descricao_rubrica"));
          idUnidade.setText(String.valueOf(result.getInt("id_estab")));
          idRubrica.setText(String.valueOf(result.getInt("id_rub")));
          lblValor.setText(cw.write(new BigDecimal(editValor.getText())));
        }
        Funcoes.desabilitaBotoes(btCancelar, btSalvar);
        Funcoes.habilitaBotoes(btAlterar, btExcluir, btNovo, btImprimir);
        Funcoes.desabilitaEdits(editUnidade, editRubrica, editValor, editData);
        editObservacao.setEnabled(false);
        btNovo.requestFocusInWindow();
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    }
  }//GEN-LAST:event_jTable1MouseClicked

  private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
    opcao = 0;
    Funcoes.desabilitaBotoes(btNovo, btAlterar, btExcluir, btImprimir);
    Funcoes.habilitaBotoes(btSalvar, btCancelar);
    Funcoes.habilitaEdits(editUnidade, editRubrica, editValor, editData);
    Funcoes.limpaEdits(editUnidade, editRubrica, editValor, editData);
    Funcoes.limpaLabel(lblRubrica, lblCodigo, lblUnidade, lblValor);
    editObservacao.setEnabled(true);
    editData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
    editObservacao.setText(null);
    editUnidade.requestFocusInWindow();
  }//GEN-LAST:event_btNovoActionPerformed

  private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    Funcoes.habilitaBotoes(btNovo, btAlterar, btExcluir, btImprimir);
    Funcoes.desabilitaBotoes(btSalvar, btCancelar);
    Funcoes.desabilitaEdits(editUnidade, editRubrica, editValor, editData);
    Funcoes.limpaEdits(editUnidade, editRubrica, editValor, editData);
    editObservacao.setText(null);
    editObservacao.setEnabled(false);
    jTabbedPane1.setSelectedIndex(0);
    editPesquisar.requestFocusInWindow();
  }//GEN-LAST:event_btCancelarActionPerformed

  private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
    opcao = 1;
    Funcoes.desabilitaBotoes(btNovo, btAlterar, btExcluir, btImprimir);
    Funcoes.habilitaBotoes(btSalvar, btCancelar);
    Funcoes.habilitaEdits(editUnidade, editRubrica, editValor, editData);
    editObservacao.setEnabled(true);
    editUnidade.requestFocusInWindow();
  }//GEN-LAST:event_btAlterarActionPerformed

  private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
    int linha = jTable1.getModel().getRowCount();
    if (linha > 0) {
      try {
        Autorizacao aut = new Autorizacao();
        aut.setId(Integer.parseInt(lblCodigo.getText()));
        dao = new AutorizacaoDao();
        dao.excluiAutorizacao(aut);
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    }
    Funcoes.habilitaBotoes(btNovo);
    Funcoes.desabilitaBotoes(btSalvar, btCancelar, btAlterar, btExcluir, btImprimir);
    Funcoes.limpaEdits(editUnidade, editRubrica, editValor, editData);
    Funcoes.desabilitaEdits(editUnidade, editRubrica, editValor, editData);
    editObservacao.setText(null);
    editObservacao.setEnabled(false);
    btNovo.requestFocusInWindow();
  }//GEN-LAST:event_btExcluirActionPerformed

  private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    try {
      Autorizacao aut = new Autorizacao();
      dao = new AutorizacaoDao();
      aut.setCompetencia_id(Competencia.getCodCompetencia());
      aut.setData(Funcoes.formataData(editData.getText()));
      aut.setEstabelecimento_id(Integer.parseInt(idUnidade.getText()));
      aut.setRubrica_id(Integer.parseInt(idRubrica.getText()));
      aut.setOperador_id(operador_id);
      aut.setValor(Double.parseDouble(editValor.getText()));
      aut.setObservacao(editObservacao.getText());
      System.out.println(editObservacao.getText());
      aut.setImpressa(false);
      if (opcao == 0) {
        dao.addAutorizacao(aut);
      } else if (opcao == 1) {
        aut.setId(Integer.parseInt(lblCodigo.getText()));
        dao.alterAutorizacao(aut);
      }
      Funcoes.desabilitaEdits(editUnidade, editRubrica, editData, editValor);
      editObservacao.setEnabled(false);
      Funcoes.desabilitaBotoes(btSalvar, btCancelar);
      Funcoes.habilitaBotoes(btNovo, btAlterar, btExcluir, btImprimir);
    } catch (Exception erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }//GEN-LAST:event_btSalvarActionPerformed

  private void editUnidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editUnidadeKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_F2) {
      SelecionaUnidade unidade = new SelecionaUnidade(null, true);
      unidade.setVisible(true);
      lblUnidade.setText(Estabelecimento.getNome());
      idUnidade.setText(String.valueOf(Estabelecimento.getId()));
      editUnidade.setText(Estabelecimento.getCnes());
    }
  }//GEN-LAST:event_editUnidadeKeyPressed

  private void editRubricaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editRubricaKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_F2) {
      SelecionaRubrica rubrica = new SelecionaRubrica(null, true);
      rubrica.setVisible(true);
      lblRubrica.setText(Rubrica.getDescricao());
      idRubrica.setText(String.valueOf(Rubrica.getId()));
      editRubrica.setText(Rubrica.getCodigo());
    }
  }//GEN-LAST:event_editRubricaKeyPressed

  private void editValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_editValorFocusLost
    lblValor.setText(cw.write(new BigDecimal(editValor.getText())));
  }//GEN-LAST:event_editValorFocusLost

  private void btImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btImprimirActionPerformed
    param.put("extenso", cw.write(new BigDecimal(editValor.getText())));
    param.put("codigo", lblCodigo.getText());
    try {
      addr = InetAddress.getLocalHost();
    } catch (UnknownHostException ex) {
      Funcoes.erro(ex.getLocalizedMessage());
    }
    byte[] ipAddr = addr.getAddress();
    String hostaddress = addr.getHostAddress();
    param.put("myip", hostaddress);
    try {
      if (radioCompetencia.isSelected()) {
        inputStream = getClass().getResourceAsStream("/autorizacao.jasper");
        titulo = "Espelho de Autorização";
      }
      Relatorio.openReport(titulo, inputStream, param, conexao);
    } catch (JRException erro) {
      erro.getLocalizedMessage();
    }
  }//GEN-LAST:event_btImprimirActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        FrameAutorizacao dialog = new FrameAutorizacao(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {

          @Override
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btAlterar;
  private javax.swing.JButton btCancelar;
  private javax.swing.JButton btExcluir;
  private javax.swing.JButton btImprimir;
  private javax.swing.JButton btNovo;
  private javax.swing.JButton btPesquisar;
  private javax.swing.JButton btSalvar;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JFormattedTextField editData;
  private javax.swing.JTextArea editObservacao;
  private javax.swing.JTextField editPesquisar;
  private javax.swing.JTextField editRubrica;
  private javax.swing.JTextField editUnidade;
  private javax.swing.JTextField editValor;
  private javax.swing.JLabel idRubrica;
  private javax.swing.JLabel idUnidade;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JLabel lblCodigo;
  private javax.swing.JLabel lblRubrica;
  private javax.swing.JLabel lblUnidade;
  private javax.swing.JLabel lblValor;
  private javax.swing.JRadioButton radioCompetencia;
  private javax.swing.JRadioButton radioEstabelecimento;
  private javax.swing.JRadioButton radioRubrica;
  // End of variables declaration//GEN-END:variables
}

