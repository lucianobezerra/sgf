package frames;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Conexao;
import model.Estabelecimento;
import model.EstabelecimentoDao;
import model.OperadorLogado;
import util.Formatacao;
import util.Funcoes;

/**
 * @author luciano
 */
public class FrameEstabelecimento extends javax.swing.JDialog {

  private int operador_id = OperadorLogado.getInstance().getID();
  String sql = null;
  Statement stmt = null;
  ResultSet result = null;
  DefaultTableModel model = null;
  int opcao = 0;
  EstabelecimentoDao dao = null;

  public FrameEstabelecimento(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    Connection conexao = Conexao.getConexao();
    model = (DefaultTableModel) jTable1.getModel();
    try {
      stmt = (Statement) conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    } catch (SQLException erro) {
      JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + erro);
    }
    jTabbedPane1.setSelectedIndex(0);
    editPesquisa.requestFocus();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jTabbedPane1 = new javax.swing.JTabbedPane();
    jPanel1 = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jPanel3 = new javax.swing.JPanel();
    editPesquisa = new javax.swing.JTextField();
    btPesquisar = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    editCnes = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    editCpfcnpj = new javax.swing.JTextField();
    jLabel3 = new javax.swing.JLabel();
    lblCodigo = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    editNome = new javax.swing.JTextField();
    jLabel6 = new javax.swing.JLabel();
    editNomecompleto = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    comboTipo = new javax.swing.JComboBox();
    checkAtivo = new javax.swing.JCheckBox();
    btNovo = new javax.swing.JButton();
    btAlterar = new javax.swing.JButton();
    btSalvar = new javax.swing.JButton();
    btCancelar = new javax.swing.JButton();
    btExcluir = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Estabelecimentos de Saúde");
    setMinimumSize(new java.awt.Dimension(700, 310));
    setModal(true);
    setResizable(false);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Cód", "Cnes", "Fantasia"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jTable1.setColumnSelectionAllowed(true);
    jTable1.setMaximumSize(new java.awt.Dimension(275, 72));
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
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(15);
    jTable1.getColumnModel().getColumn(1).setResizable(false);
    jTable1.getColumnModel().getColumn(1).setPreferredWidth(60);
    jTable1.getColumnModel().getColumn(2).setResizable(false);
    jTable1.getColumnModel().getColumn(2).setPreferredWidth(400);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 240));

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ação"));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    editPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        editPesquisaKeyPressed(evt);
      }
    });
    jPanel3.add(editPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 20, 535, 30));

    btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filtrar.gif"))); // NOI18N
    btPesquisar.setMnemonic('P');
    btPesquisar.setText("Pesquisar");
    btPesquisar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btPesquisarActionPerformed(evt);
      }
    });
    jPanel3.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 18, 140, 30));

    jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 245, 695, 55));

    jTabbedPane1.addTab("Listagem", jPanel1);

    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setText("Código:");
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

    editCnes.setEnabled(false);
    jPanel2.add(editCnes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 141, 30));

    jLabel2.setText("CNES:");
    jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

    editCpfcnpj.setEnabled(false);
    jPanel2.add(editCpfcnpj, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 240, 30));

    jLabel3.setText("CPF/CNPJ:");
    jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, -1, -1));

    lblCodigo.setText(" ");
    jPanel2.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 20, 80, -1));

    jLabel5.setText("Fantasia:");
    jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

    editNome.setEnabled(false);
    jPanel2.add(editNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 570, 30));

    jLabel6.setText("Razão Social:");
    jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

    editNomecompleto.setEnabled(false);
    jPanel2.add(editNomecompleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 570, 30));

    jLabel7.setText("Tipo:");
    jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

    comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Física", "Jurídica" }));
    comboTipo.setSelectedIndex(-1);
    comboTipo.setEnabled(false);
    jPanel2.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 146, 30));

    checkAtivo.setText("Ativo");
    checkAtivo.setEnabled(false);
    jPanel2.add(checkAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 104, -1));

    btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novo.png"))); // NOI18N
    btNovo.setMnemonic('N');
    btNovo.setText("Novo");
    btNovo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btNovoActionPerformed(evt);
      }
    });
    jPanel2.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 120, -1));

    btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alterar.png"))); // NOI18N
    btAlterar.setMnemonic('A');
    btAlterar.setText("Alterar");
    btAlterar.setEnabled(false);
    btAlterar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btAlterarActionPerformed(evt);
      }
    });
    jPanel2.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 120, -1));

    btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
    btSalvar.setMnemonic('S');
    btSalvar.setText("Salvar");
    btSalvar.setEnabled(false);
    btSalvar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btSalvarActionPerformed(evt);
      }
    });
    jPanel2.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 260, 120, -1));

    btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
    btCancelar.setMnemonic('C');
    btCancelar.setText("Cancelar");
    btCancelar.setEnabled(false);
    btCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCancelarActionPerformed(evt);
      }
    });
    jPanel2.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 120, -1));

    btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excluir.png"))); // NOI18N
    btExcluir.setMnemonic('E');
    btExcluir.setText("Excluir");
    btExcluir.setEnabled(false);
    btExcluir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btExcluirActionPerformed(evt);
      }
    });
    jPanel2.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 120, -1));

    jTabbedPane1.addTab("Detalhes", jPanel2);

    getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 710, 338));

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-719)/2, (screenSize.height-378)/2, 719, 378);
  }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
      java.util.Date utilDate = new java.util.Date();
      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
      try {
        String tipo = comboTipo.getSelectedItem().toString().substring(0, 1);
        String cpf_cnpj = editCpfcnpj.getText().replaceAll("\\.", "");
        cpf_cnpj = cpf_cnpj.replaceAll("\\/", "");
        cpf_cnpj = cpf_cnpj.replaceAll("\\-", "");
        Estabelecimento ups = new Estabelecimento();
        dao = new EstabelecimentoDao();
        Estabelecimento.setCnes(editCnes.getText());
        Estabelecimento.setNome(editNome.getText());
        Estabelecimento.setNome_completo(editNomecompleto.getText());
        Estabelecimento.setCpf_cnpj(cpf_cnpj);
        Estabelecimento.setData_cadastro(sqlDate);
        Estabelecimento.setTipo(tipo);
        Estabelecimento.setOperador_id(operador_id);
        Estabelecimento.setAtivo(checkAtivo.isSelected());
        if (opcao == 0) {
          dao.addEstabelecimento(ups);
        } else if (opcao == 1) {
          Estabelecimento.setId(Integer.parseInt(lblCodigo.getText()));
          dao.alteraEstabelecimento(ups);
        }
        Funcoes.desabilitaBotoes(btSalvar, btCancelar);
        Funcoes.habilitaBotoes(btNovo, btAlterar, btExcluir);
        Funcoes.desabilitaEdits(editCnes, editCpfcnpj, editNome, editNomecompleto);
        Funcoes.desabilitaCheck(checkAtivo);
        Funcoes.desabilitaCombo(comboTipo);
        btNovo.requestFocusInWindow();
      } catch (SQLException erro) {
        System.out.println("Erro: " + erro.getMessage());
      }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
      try {
        Funcoes.removeLinha(model);
        dao = new EstabelecimentoDao();
        if (!EstabelecimentoDao.existemRegistros(editPesquisa.getText())) {
          Funcoes.informacao("Estabelecimento não Localizado!");
          editPesquisa.requestFocusInWindow();
        } else {
          sql = "select * from estabelecimentos where upper(nome) like upper('%" + editPesquisa.getText() + "%') order by id";
          result = stmt.executeQuery(sql);
          while (result.next()) {
            model.addRow(new Object[]{
                      result.getInt("id"),
                      result.getString("cnes"),
                      result.getString("nome"),});
          }
          jTable1.setModel(model);
        }
      } catch (SQLException erro) {
        Funcoes.erro(erro.getMessage());
      }
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      if (evt.getClickCount() == 2) {
        try {
          int linha = jTable1.getSelectedRow();
          String codigo = model.getValueAt(linha, 0).toString();
          sql = "select * from estabelecimentos where id= " + codigo;
          result = stmt.executeQuery(sql);
          while (result.next()) {
            String tipo = result.getString("tipo");
            String cpf_cnpj = result.getString("cpf_cnpj");
            lblCodigo.setText(String.format("%04d", result.getInt("id")));
            editCnes.setText(result.getString("cnes"));
            editNome.setText(result.getString("nome"));
            editNomecompleto.setText(result.getString("nome_completo"));
            editCpfcnpj.setText(cpf_cnpj);
            if (tipo.equals("F")) {
              editCpfcnpj.setText(Formatacao.formatarCpf(cpf_cnpj));
              comboTipo.setSelectedIndex(0);
            } else {
              editCpfcnpj.setText(Formatacao.formatarCnpj(cpf_cnpj));
              comboTipo.setSelectedIndex(1);
            }
            checkAtivo.setSelected(result.getBoolean("ativo"));
            Funcoes.habilitaBotoes(btAlterar, btExcluir, btNovo);
            Funcoes.desabilitaBotoes(btCancelar, btSalvar);
            Funcoes.desabilitaEdits(editCnes, editCpfcnpj, editNome, editNomecompleto);
          }
          jTabbedPane1.setSelectedIndex(1);
        } catch (SQLException erro) {
          Funcoes.erro(erro.getMessage());
        }
      }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
      opcao = 0;
      Funcoes.desabilitaBotoes(btNovo, btAlterar, btExcluir);
      Funcoes.habilitaCombo(comboTipo);
      Funcoes.habilitaCheck(checkAtivo);
      Funcoes.habilitaBotoes(btSalvar, btCancelar);
      Funcoes.habilitaEdits(editCnes, editCpfcnpj, editNome, editNomecompleto);
      Funcoes.limpaEdits(editCnes, editCpfcnpj, editNome, editNomecompleto);
      Funcoes.limpaLabel(lblCodigo);
      Funcoes.limpaCheck(checkAtivo);
      Funcoes.limpaCombo(comboTipo);
      editCnes.requestFocus();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
      opcao = 1;
      int linha = jTable1.getModel().getRowCount();
      if (linha > 0) {
        Funcoes.habilitaEdits(editCnes, editCpfcnpj, editNome, editNomecompleto);
        Funcoes.habilitaCheck(checkAtivo);
        Funcoes.habilitaCombo(comboTipo);
        Funcoes.habilitaBotoes(btSalvar, btCancelar);
        Funcoes.desabilitaBotoes(btAlterar, btExcluir, btNovo);
        editCnes.requestFocus();
      } else {
        Funcoes.informacao("Selecione um Registro para Alterar");
      }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
      Funcoes.desabilitaBotoes(btCancelar, btSalvar);
      Funcoes.habilitaBotoes(btNovo,btExcluir, btAlterar);
      Funcoes.desabilitaEdits(editCnes, editCpfcnpj, editNome, editNomecompleto);
      Funcoes.desabilitaCheck(checkAtivo);
      Funcoes.desabilitaCombo(comboTipo);
      jTabbedPane1.setSelectedIndex(0);
      btPesquisar.doClick();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
      int linha = jTable1.getModel().getRowCount();
      if (linha > 0) {
        Estabelecimento ups = new Estabelecimento();
        Estabelecimento.setId(Integer.parseInt(lblCodigo.getText()));
        try {
          dao = new EstabelecimentoDao();
          dao.excluiEstabelecimento(ups);
          Funcoes.informacao("Registro Excluido!");
          Funcoes.limpaEdits(editCnes, editCpfcnpj, editNome, editNomecompleto);
          Funcoes.limpaLabel(lblCodigo);
          Funcoes.limpaCheck(checkAtivo);
          Funcoes.limpaCombo(comboTipo);
          Funcoes.desabilitaCheck(checkAtivo);
          Funcoes.desabilitaCombo(comboTipo);
          Funcoes.desabilitaEdits(editCnes, editCpfcnpj, editNome, editNomecompleto);
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

    private void editPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editPesquisaKeyPressed
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        btPesquisar.doClick();
      }
    }//GEN-LAST:event_editPesquisaKeyPressed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        FrameEstabelecimento dialog = new FrameEstabelecimento(new javax.swing.JFrame(), true);
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
  private javax.swing.JComboBox comboTipo;
  private javax.swing.JTextField editCnes;
  private javax.swing.JTextField editCpfcnpj;
  private javax.swing.JTextField editNome;
  private javax.swing.JTextField editNomecompleto;
  private javax.swing.JTextField editPesquisa;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JLabel lblCodigo;
  // End of variables declaration//GEN-END:variables
}
