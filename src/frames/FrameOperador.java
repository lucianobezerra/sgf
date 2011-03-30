package frames;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import model.Conexao;
import model.Operador;
import model.OperadorDao;
import security.Criptografia;
import util.Funcoes;

/**
 * @author luciano
 */
public final class FrameOperador extends javax.swing.JDialog {

  Statement stmt = null;
  ResultSet result = null;
  DefaultTableModel model = null;
  int opcao = 0;

  public FrameOperador(java.awt.Frame parent, boolean modal) {
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
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    comboNivel = new javax.swing.JComboBox();
    checkAtivo = new javax.swing.JCheckBox();
    editLogin = new javax.swing.JTextField();
    editNome = new javax.swing.JTextField();
    editEmail = new javax.swing.JTextField();
    editSenha = new javax.swing.JPasswordField();
    btExcluir = new javax.swing.JButton();
    btAlterar = new javax.swing.JButton();
    btGravar = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    lblCodigo = new javax.swing.JLabel();
    btNovo = new javax.swing.JButton();
    btCancelar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Manutenção de Operadores");
    setModal(true);
    setResizable(false);
    addWindowFocusListener(new java.awt.event.WindowFocusListener() {
      public void windowGainedFocus(java.awt.event.WindowEvent evt) {
        formWindowGainedFocus(evt);
      }
      public void windowLostFocus(java.awt.event.WindowEvent evt) {
      }
    });
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setMaximumSize(new java.awt.Dimension(620, 200));
    jPanel1.setMinimumSize(new java.awt.Dimension(620, 200));
    jPanel1.setPreferredSize(new java.awt.Dimension(620, 200));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jScrollPane1.setPreferredSize(new java.awt.Dimension(620, 275));

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Cód", "Login", "Nome", "Email", "Ativo"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jTable1.setColumnSelectionAllowed(true);
    jTable1.setMaximumSize(new java.awt.Dimension(600, 0));
    jTable1.setRowHeight(22);
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
    jTable1.getColumnModel().getColumn(2).setPreferredWidth(160);
    jTable1.getColumnModel().getColumn(3).setResizable(false);
    jTable1.getColumnModel().getColumn(3).setPreferredWidth(160);
    jTable1.getColumnModel().getColumn(4).setResizable(false);
    jTable1.getColumnModel().getColumn(4).setPreferredWidth(20);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 618, 190));

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Ação")));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    editPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        editPesquisaKeyPressed(evt);
      }
    });
    jPanel3.add(editPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 440, 30));

    btPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filtrar.gif"))); // NOI18N
    btPesquisar.setMnemonic('P');
    btPesquisar.setText("Pesquisar");
    btPesquisar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btPesquisarActionPerformed(evt);
      }
    });
    jPanel3.add(btPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 140, 30));

    jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 620, 60));

    jTabbedPane1.addTab("Dados", jPanel1);

    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setText("Login:");
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

    jLabel2.setText("Senha:");
    jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

    jLabel3.setText("Nome:");
    jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

    jLabel4.setText("Email:");
    jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

    jLabel5.setText("Nível:");
    jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

    comboNivel.setFont(new java.awt.Font("Andale Mono", 0, 14));
    comboNivel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Gerente", "Operador" }));
    jPanel2.add(comboNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 140, 171, 30));

    checkAtivo.setText("Ativo?");
    checkAtivo.setContentAreaFilled(false);
    jPanel2.add(checkAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 87, 30));

    editLogin.setFont(new java.awt.Font("Andale Mono", 0, 14));
    jPanel2.add(editLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 140, 30));

    editNome.setFont(new java.awt.Font("Andale Mono", 0, 14));
    jPanel2.add(editNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 50, 520, 30));

    editEmail.setFont(new java.awt.Font("Andale Mono", 0, 14));
    jPanel2.add(editEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 90, 520, 30));

    editSenha.setFont(new java.awt.Font("Andale Mono", 0, 14));
    jPanel2.add(editSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 180, 30));

    btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excluir.png"))); // NOI18N
    btExcluir.setMnemonic('x');
    btExcluir.setText("Excluir");
    btExcluir.setEnabled(false);
    btExcluir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btExcluirActionPerformed(evt);
      }
    });
    jPanel2.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 115, 30));

    btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alterar.png"))); // NOI18N
    btAlterar.setMnemonic('A');
    btAlterar.setText("Alterar");
    btAlterar.setEnabled(false);
    btAlterar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btAlterarActionPerformed(evt);
      }
    });
    jPanel2.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 200, 115, 30));

    btGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
    btGravar.setMnemonic('S');
    btGravar.setText("Salvar");
    btGravar.setEnabled(false);
    btGravar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btGravarActionPerformed(evt);
      }
    });
    jPanel2.add(btGravar, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 200, 115, 30));

    jLabel6.setText("Cód:");
    jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

    lblCodigo.setText(" ");
    lblCodigo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    jPanel2.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 20, 60, -1));

    btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novo.png"))); // NOI18N
    btNovo.setMnemonic('N');
    btNovo.setText("Novo");
    btNovo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btNovoActionPerformed(evt);
      }
    });
    jPanel2.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 115, 30));

    btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
    btCancelar.setMnemonic('C');
    btCancelar.setText("Cancelar");
    btCancelar.setEnabled(false);
    btCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCancelarActionPerformed(evt);
      }
    });
    jPanel2.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 200, 119, 30));

    jTabbedPane1.addTab("Detalhes", jPanel2);

    getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 626, 300));

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-632)/2, (screenSize.height-336)/2, 632, 336);
  }// </editor-fold>//GEN-END:initComponents

  private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    editLogin.requestFocus();
  }//GEN-LAST:event_formWindowGainedFocus

  private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
    if (Funcoes.checaForm(editLogin, editEmail, editNome, editSenha)) {
      try {
        Operador operador = new Operador();
        OperadorDao dao = null;
        String senha = new String(editSenha.getPassword());
        dao = new OperadorDao();
        operador.setLogin(editLogin.getText());
        operador.setNome(editNome.getText());
        operador.setEmail(editEmail.getText());
        operador.setSenha(Criptografia.CriptaBase64(senha));
        operador.setNivel(comboNivel.getSelectedIndex());
        operador.setAtivo(checkAtivo.isSelected());
        if (opcao == 0) {
          try {
            dao.addOperador(operador);
            Funcoes.informacao("Registro Inserido!");
          } catch (SQLException erro) {
            Funcoes.erro(erro.getLocalizedMessage());
          }
        } else if (opcao == 1) {
          operador.setId(Integer.parseInt(lblCodigo.getText()));
          try {
            dao.alterOperador(operador);
            Funcoes.informacao("Registro Alterado!");
          } catch (SQLException erro) {
            Funcoes.erro(erro.getLocalizedMessage());
          }
        }
        Funcoes.limpaEdits(editEmail, editLogin, editNome, editSenha);
        editLogin.requestFocus();
        Funcoes.desabilitaBotoes(btGravar, btCancelar);
        Funcoes.habilitaBotoes(btNovo, btExcluir, btAlterar);
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    }
  }//GEN-LAST:event_btGravarActionPerformed

  private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
    opcao = 1;
    int linha = jTable1.getModel().getRowCount();
    if (linha > 0) {
      Funcoes.habilitaEdits(editEmail, editLogin, editNome, editSenha);
      Funcoes.habilitaBotoes(btGravar, btCancelar);
      Funcoes.desabilitaBotoes(btNovo, btExcluir, btAlterar);
      editLogin.requestFocus();
    } else {
      Funcoes.informacao("Selecione um Registro para Alterar");
    }

  }//GEN-LAST:event_btAlterarActionPerformed

  private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
    int linha = jTable1.getModel().getRowCount();
    if (linha > 0) {
      Operador operador = new Operador();
      OperadorDao dao = null;

      operador.setId(Integer.parseInt(lblCodigo.getText()));
      try {
        dao = new OperadorDao();
        dao.excluiOperador(operador);
        Funcoes.informacao("Registro Excluido!");
        Funcoes.limpaEdits(editEmail, editLogin, editNome, editSenha);
        Funcoes.limpaLabel(lblCodigo);
        Funcoes.desabilitaEdits(editEmail, editLogin, editNome, editSenha);
        Funcoes.desabilitaBotoes(btAlterar, btCancelar, btExcluir, btGravar);
        editLogin.requestFocus();
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    } else {
      Funcoes.informacao("Selecione o Registro para Excluir");
    }
  }//GEN-LAST:event_btExcluirActionPerformed

  private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    if (evt.getClickCount() == 2) {
      try {
        model = (DefaultTableModel) jTable1.getModel();
        int linha = jTable1.getSelectedRow();
        String codigo = model.getValueAt(linha, 0).toString();
        String sql = "select * from operadores where id= " + codigo;
        result = stmt.executeQuery(sql);
        while (result.next()) {
          lblCodigo.setText(String.format("%04d", result.getInt("id")));
          editLogin.setText(result.getString("nome"));
          editNome.setText(result.getString("nome_completo"));
          editEmail.setText(result.getString("email"));
          editSenha.setText(Criptografia.DecriptaBase64(result.getString("senha")));
          comboNivel.setSelectedIndex(result.getInt("nivel"));
          checkAtivo.setSelected(result.getBoolean("ativo"));
          Funcoes.desabilitaBotoes(btGravar, btCancelar);
          Funcoes.habilitaBotoes(btNovo, btExcluir, btAlterar);
          Funcoes.desabilitaEdits(editEmail, editLogin, editNome, editSenha);
        }
        jTabbedPane1.setSelectedIndex(1);
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    }
  }//GEN-LAST:event_jTable1MouseClicked

  private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
    try {
      Funcoes.removeLinha(model);
      String sql = "select * from operadores where upper(nome) like upper('%" + editPesquisa.getText() + "%') order by id";
      result = stmt.executeQuery(sql);
      while (result.next()) {
        model.addRow(new Object[]{
                  result.getInt("id"),
                  result.getString("nome"),
                  result.getString("nome_completo"),
                  result.getString("email"),
                  result.getBoolean("ativo")
                });
      }
      jTable1.setModel(model);
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }//GEN-LAST:event_btPesquisarActionPerformed

  private void editPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editPesquisaKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      btPesquisar.doClick();
    }
  }//GEN-LAST:event_editPesquisaKeyPressed

  private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
    opcao = 0;
    Funcoes.habilitaEdits(editEmail, editLogin, editNome, editSenha);
    Funcoes.limpaEdits(editEmail, editLogin, editNome, editSenha);
    editLogin.requestFocus();
    Funcoes.habilitaBotoes(btGravar, btCancelar);
    Funcoes.desabilitaBotoes(btNovo, btExcluir, btAlterar);
    editLogin.requestFocus();
  }//GEN-LAST:event_btNovoActionPerformed

  private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
    Funcoes.limpaEdits(editEmail, editLogin, editNome, editSenha);
    editLogin.requestFocus();
    int linha = jTable1.getModel().getRowCount();
    if (linha > 0) {
      try {
        result.beforeFirst();
        while (result.next()) {
          editNome.setText(result.getString("nome_completo"));
          editLogin.setText(result.getString("nome"));
          editEmail.setText(result.getString("email"));
          editSenha.setText(Criptografia.DecriptaBase64(result.getString("senha")));
          comboNivel.setSelectedIndex(result.getInt("nivel"));
          checkAtivo.setSelected(result.getBoolean("ativo"));
        }
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    }
    Funcoes.desabilitaBotoes(btGravar, btCancelar);
    Funcoes.habilitaBotoes(btNovo, btExcluir, btAlterar);
    Funcoes.desabilitaEdits(editEmail, editLogin, editNome, editSenha);
  }//GEN-LAST:event_btCancelarActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        FrameOperador dialog = new FrameOperador(new javax.swing.JFrame(), true);
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
  private javax.swing.JButton btGravar;
  private javax.swing.JButton btNovo;
  private javax.swing.JButton btPesquisar;
  private javax.swing.JCheckBox checkAtivo;
  private javax.swing.JComboBox comboNivel;
  private javax.swing.JTextField editEmail;
  private javax.swing.JTextField editLogin;
  private javax.swing.JTextField editNome;
  private javax.swing.JTextField editPesquisa;
  private javax.swing.JPasswordField editSenha;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JLabel lblCodigo;
  // End of variables declaration//GEN-END:variables
}
