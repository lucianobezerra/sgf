package frames;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import model.Competencia;
import model.CompetenciaDao;
import model.Conexao;
import model.OperadorLogado;
import util.Funcoes;

/**
 * @author luciano
 */
public class FrameCompetencia extends javax.swing.JDialog {

  private int operador_id = OperadorLogado.getInstance().getID();
  CompetenciaDao dao = null;
  String sql = null;
  Statement stmt = null;
  ResultSet result = null;
  DefaultTableModel model = null;
  int opcao = 0;

  public FrameCompetencia(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    Connection conexao = Conexao.getConexao();
    model = (DefaultTableModel) jTable1.getModel();
    try {
      stmt = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
    jTabbedPane1.setSelectedIndex(0);
    editPesquisar.requestFocusInWindow();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    jPanel3 = new javax.swing.JPanel();
    editPesquisar = new javax.swing.JTextField();
    btPesquisar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    comboMes = new javax.swing.JComboBox();
    comboAno = new javax.swing.JComboBox();
    checkAtivo = new javax.swing.JCheckBox();
    btNovo = new javax.swing.JButton();
    btAlterar = new javax.swing.JButton();
    btCancelar = new javax.swing.JButton();
    btExcluir = new javax.swing.JButton();
    btSalvar = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    lblCodigo = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Manutenção de Competências");
    setResizable(false);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusGained(java.awt.event.FocusEvent evt) {
        jPanel1FocusGained(evt);
      }
    });
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Localizar"));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    editPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        editPesquisarKeyPressed(evt);
      }
    });
    jPanel3.add(editPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, 30));

    btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filtrar.gif"))); // NOI18N
    btPesquisar.setText("Pesquisar");
    btPesquisar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btPesquisarActionPerformed(evt);
      }
    });
    jPanel3.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 20, 130, 30));

    jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 370, 60));

    jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null}
      },
      new String [] {
        "Cód", "Mês", "Ano", "Ativo"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
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
    jTable1.setRowHeight(20);
    jTable1.getTableHeader().setReorderingAllowed(false);
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTable1MouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(jTable1);
    jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jTable1.getColumnModel().getColumn(0).setResizable(false);
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
    jTable1.getColumnModel().getColumn(1).setResizable(false);
    jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
    jTable1.getColumnModel().getColumn(2).setResizable(false);
    jTable1.getColumnModel().getColumn(2).setPreferredWidth(60);
    jTable1.getColumnModel().getColumn(3).setResizable(false);
    jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 160));

    jTabbedPane1.addTab("Listagem", jPanel1);

    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setText("Mes:");
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

    jLabel2.setText("Ano:");
    jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, 30));

    comboMes.setMaximumRowCount(6);
    comboMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione ...", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
    comboMes.setEnabled(false);
    jPanel2.add(comboMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 160, 30));

    comboAno.setMaximumRowCount(4);
    comboAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione ...", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));
    comboAno.setEnabled(false);
    jPanel2.add(comboAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 160, 30));

    checkAtivo.setText("Ativo");
    checkAtivo.setEnabled(false);
    jPanel2.add(checkAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

    btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novo.png"))); // NOI18N
    btNovo.setMnemonic('N');
    btNovo.setText("Novo");
    btNovo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btNovoActionPerformed(evt);
      }
    });
    jPanel2.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 120, 30));

    btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alterar.png"))); // NOI18N
    btAlterar.setMnemonic('A');
    btAlterar.setText("Alterar");
    btAlterar.setEnabled(false);
    btAlterar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btAlterarActionPerformed(evt);
      }
    });
    jPanel2.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 45, 120, 30));

    btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
    btCancelar.setMnemonic('C');
    btCancelar.setText("Cancelar");
    btCancelar.setEnabled(false);
    btCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCancelarActionPerformed(evt);
      }
    });
    jPanel2.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 115, 120, 30));

    btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excluir.png"))); // NOI18N
    btExcluir.setMnemonic('E');
    btExcluir.setText("Excluir");
    btExcluir.setEnabled(false);
    btExcluir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btExcluirActionPerformed(evt);
      }
    });
    jPanel2.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 120, 30));

    btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
    btSalvar.setMnemonic('S');
    btSalvar.setText("Salvar");
    btSalvar.setEnabled(false);
    btSalvar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btSalvarActionPerformed(evt);
      }
    });
    jPanel2.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 120, 30));

    jLabel3.setText("Cód:");
    jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

    lblCodigo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lblCodigo.setText(" ");
    jPanel2.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 70, -1));

    jTabbedPane1.addTab("Detalhes", jPanel2);

    getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 250));

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-380)/2, (screenSize.height-295)/2, 380, 295);
  }// </editor-fold>//GEN-END:initComponents

  private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
    opcao = 1;
    Funcoes.habilitaCombo(comboAno, comboMes);
    Funcoes.habilitaCheck(checkAtivo);
    Funcoes.desabilitaBotoes(btNovo, btAlterar, btExcluir);
    Funcoes.habilitaBotoes(btSalvar, btCancelar);
    comboMes.requestFocusInWindow();
  }//GEN-LAST:event_btAlterarActionPerformed

  private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    Funcoes.desabilitaBotoes(btCancelar, btSalvar);
    Funcoes.habilitaBotoes(btNovo, btAlterar, btExcluir);
    Funcoes.limpaCombo(comboAno, comboMes);
    Funcoes.desabilitaCheck(checkAtivo);
    btNovo.requestFocusInWindow();
  }//GEN-LAST:event_btCancelarActionPerformed

  private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    try {
      String ano = comboAno.getSelectedItem().toString();
      int mes = comboMes.getSelectedIndex();
      String str_mes = String.format("%02d", mes);
      Competencia cmpt = new Competencia();
      cmpt.setAno(ano);
      cmpt.setMes(str_mes);
      cmpt.setData_cadastro(sqlDate);
      cmpt.setAtivo(checkAtivo.isSelected());
      cmpt.setOperador_id(operador_id);
      if (opcao == 0) {
        dao.novaCompetencia(cmpt);
      } else if (opcao == 1) {
        cmpt.setId(Integer.parseInt(lblCodigo.getText()));
        dao.alteraCompetencia(cmpt);
      }
      Funcoes.desabilitaBotoes(btSalvar, btCancelar);
      Funcoes.habilitaBotoes(btAlterar, btExcluir, btNovo);
      comboAno.setEnabled(false);
      comboMes.setEnabled(false);
      checkAtivo.setEnabled(false);
      btPesquisar.doClick();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }//GEN-LAST:event_btSalvarActionPerformed

  private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
    if (!editPesquisar.getText().equals("")) {
      try {
        Funcoes.removeLinha(model);
        dao = new CompetenciaDao();
        sql = "select * from competencias where ano = '" + editPesquisar.getText() + "' order by mes";
        result = stmt.executeQuery(sql);
        while (result.next()) {
          model.addRow(new Object[]{
                    result.getInt("id"),
                    Competencia.mesExtenso(Integer.parseInt(result.getString("mes"))),
                    result.getString("ano"),
                    result.getBoolean("ativo")
                  });
        }
        jTable1.setModel(model);
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    } else {
      Funcoes.informacao("Informe um Ano para pesquisa!");
      editPesquisar.requestFocusInWindow();
    }

  }//GEN-LAST:event_btPesquisarActionPerformed

  private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    if (evt.getClickCount() == 2) {
      model = (DefaultTableModel) jTable1.getModel();
      int linha = jTable1.getSelectedRow();
      int codigo = Integer.parseInt(model.getValueAt(linha, 0).toString());
      String mes = model.getValueAt(linha, 1).toString();
      String ano = model.getValueAt(linha, 2).toString();
      boolean ativo = Boolean.parseBoolean(model.getValueAt(linha, 3).toString());
      comboMes.setSelectedItem(mes);
      comboAno.setSelectedItem(ano);
      checkAtivo.setSelected(ativo);
      lblCodigo.setText(String.format("%04d", codigo));
      jTabbedPane1.setSelectedIndex(1);
      Funcoes.habilitaBotoes(btNovo, btAlterar, btExcluir);
      Funcoes.desabilitaBotoes(btCancelar, btSalvar);
      btNovo.requestFocusInWindow();
      Funcoes.desabilitaCombo(comboAno, comboMes);
      Funcoes.desabilitaCheck(checkAtivo);
    }
  }//GEN-LAST:event_jTable1MouseClicked

  private void editPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editPesquisarKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      btPesquisar.doClick();
    }
  }//GEN-LAST:event_editPesquisarKeyPressed

  private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
    editPesquisar.requestFocusInWindow();
  }//GEN-LAST:event_jPanel1FocusGained

  private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
    opcao = 0;
    Funcoes.habilitaCombo(comboAno, comboMes);
    Funcoes.habilitaCheck(checkAtivo);
    comboAno.setSelectedIndex(0);
    comboMes.setSelectedIndex(0);
    checkAtivo.setSelected(false);
    comboMes.requestFocusInWindow();
    Funcoes.desabilitaBotoes(btNovo, btAlterar, btExcluir);
    Funcoes.habilitaBotoes(btSalvar, btCancelar);
  }//GEN-LAST:event_btNovoActionPerformed

  private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
    int linha = jTable1.getModel().getRowCount();
    if (linha > 0) {
      Competencia cmpt = new Competencia();
      cmpt.setId(Integer.parseInt(lblCodigo.getText()));
      try {
        dao = new CompetenciaDao();
        dao.excluiCompetencia(cmpt);
        Funcoes.informacao("Registro Excluido!");
        Funcoes.limpaCombo(comboAno, comboMes);
        Funcoes.desabilitaCombo(comboAno, comboMes);
        Funcoes.desabilitaCheck(checkAtivo);
        lblCodigo.setText(null);
        Funcoes.desabilitaBotoes(btAlterar, btCancelar, btExcluir, btSalvar);
        jTabbedPane1.setSelectedIndex(0);
        btPesquisar.doClick();
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    } else {
      Funcoes.informacao("Selecione o Registro para Excluir");
    }
  }//GEN-LAST:event_btExcluirActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        FrameCompetencia dialog = new FrameCompetencia(new javax.swing.JFrame(), true);
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
  private javax.swing.JButton btNovo;
  private javax.swing.JButton btPesquisar;
  private javax.swing.JButton btSalvar;
  private javax.swing.JCheckBox checkAtivo;
  private javax.swing.JComboBox comboAno;
  private javax.swing.JComboBox comboMes;
  private javax.swing.JTextField editPesquisar;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JLabel lblCodigo;
  // End of variables declaration//GEN-END:variables
}
