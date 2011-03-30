package frames;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import model.Conexao;
import model.OperadorLogado;
import model.Rubrica;
import model.RubricaDao;
import util.Funcoes;

/**
 * @author luciano
 */
public class FrameRubrica extends javax.swing.JDialog {

  private int operador_id = OperadorLogado.getInstance().getID();
  String sql = null;
  Statement stmt = null;
  ResultSet result = null;
  DefaultTableModel model = null;
  int opcao = 0;
  RubricaDao dao = null;

  public FrameRubrica(java.awt.Frame parent, boolean modal) {
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
    btPesquisa = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    checkAtivo = new javax.swing.JCheckBox();
    lblCodigo = new javax.swing.JLabel();
    editCodigo = new javax.swing.JTextField();
    editDescricao = new javax.swing.JTextField();
    editConta = new javax.swing.JTextField();
    btNovo = new javax.swing.JButton();
    btAlterar = new javax.swing.JButton();
    btSalvar = new javax.swing.JButton();
    btCancelar = new javax.swing.JButton();
    btExcluir = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null}
      },
      new String [] {
        "Id", "Cód", "Descrição", "Ativo"
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
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(8);
    jTable1.getColumnModel().getColumn(1).setResizable(false);
    jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
    jTable1.getColumnModel().getColumn(2).setResizable(false);
    jTable1.getColumnModel().getColumn(2).setPreferredWidth(390);
    jTable1.getColumnModel().getColumn(3).setResizable(false);
    jTable1.getColumnModel().getColumn(3).setPreferredWidth(15);

    jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 190));

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    jPanel3.add(editPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 21, 430, 30));

    btPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filtrar.gif"))); // NOI18N
    btPesquisa.setText("Localizar");
    btPesquisa.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btPesquisaActionPerformed(evt);
      }
    });
    jPanel3.add(btPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 120, 30));

    jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 192, 580, 60));

    jTabbedPane1.addTab("Listagem", jPanel1);

    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setText("Id:");
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

    jLabel2.setText("Código:");
    jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 50, -1, -1));

    jLabel3.setText("Descrição:");
    jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 92, -1, -1));

    jLabel4.setText("Conta:");
    jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 134, -1, -1));

    checkAtivo.setText("Ativo");
    jPanel2.add(checkAtivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 176, -1, -1));

    lblCodigo.setText(" ");
    jPanel2.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 12, 78, -1));
    jPanel2.add(editCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 42, 80, 30));
    jPanel2.add(editDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 84, 447, 30));
    jPanel2.add(editConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 126, 100, 30));

    btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/novo.png"))); // NOI18N
    btNovo.setText("Novo");
    btNovo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btNovoActionPerformed(evt);
      }
    });
    jPanel2.add(btNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 110, 30));

    btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alterar.png"))); // NOI18N
    btAlterar.setText("Alterar");
    btAlterar.setEnabled(false);
    btAlterar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btAlterarActionPerformed(evt);
      }
    });
    jPanel2.add(btAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 210, 110, 30));

    btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
    btSalvar.setText("Salvar");
    btSalvar.setEnabled(false);
    btSalvar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btSalvarActionPerformed(evt);
      }
    });
    jPanel2.add(btSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 210, 110, 30));

    btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
    btCancelar.setText("Cancelar");
    btCancelar.setEnabled(false);
    btCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCancelarActionPerformed(evt);
      }
    });
    jPanel2.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 210, 120, 30));

    btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excluir.png"))); // NOI18N
    btExcluir.setText("Excluir");
    btExcluir.setEnabled(false);
    btExcluir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btExcluirActionPerformed(evt);
      }
    });
    jPanel2.add(btExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 210, 110, 30));

    jTabbedPane1.addTab("Detalhes", jPanel2);

    getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 290));

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-595)/2, (screenSize.height-322)/2, 595, 322);
  }// </editor-fold>//GEN-END:initComponents

    private void btPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaActionPerformed
      try {
        Funcoes.removeLinha(model);
        dao = new RubricaDao();
        sql = "select * from rubricas where upper(descricao) like upper('%" + editPesquisa.getText() + "%') order by id";
        result = stmt.executeQuery(sql);
        while (result.next()) {
          model.addRow(new Object[]{
                    result.getInt("id"),
                    result.getString("codigo"),
                    result.getString("descricao"),
                    result.getBoolean("ativo")
                  });
        }
        jTable1.setModel(model);
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    }//GEN-LAST:event_btPesquisaActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      if (evt.getClickCount() == 2) {
        try {
          model = (DefaultTableModel) jTable1.getModel();
          int linha = jTable1.getSelectedRow();
          String codigo = model.getValueAt(linha, 0).toString();
          sql = "select * from rubricas where id= " + codigo;
          result = stmt.executeQuery(sql);
          while (result.next()) {
            lblCodigo.setText(String.format("%04d", result.getInt("id")));
            editCodigo.setText(result.getString("codigo"));
            editDescricao.setText(result.getString("descricao"));
            editConta.setText(result.getString("conta"));
            checkAtivo.setSelected(result.getBoolean("ativo"));
            Funcoes.habilitaBotoes(btAlterar, btExcluir, btNovo);
            Funcoes.desabilitaBotoes(btCancelar, btSalvar);
            Funcoes.desabilitaEdits(editCodigo, editDescricao, editConta);
            checkAtivo.setEnabled(false);
          }
          jTabbedPane1.setSelectedIndex(1);
        } catch (SQLException erro) {
          Funcoes.erro(erro.getLocalizedMessage());
        }
      }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
      opcao = 0;
      Funcoes.habilitaBotoes(btCancelar, btSalvar);
      Funcoes.desabilitaBotoes(btAlterar, btExcluir, btNovo);
      Funcoes.habilitaEdits(editCodigo, editConta, editDescricao);
      Funcoes.limpaEdits(editCodigo, editConta, editDescricao);
      checkAtivo.setEnabled(true);
      checkAtivo.setSelected(false);
      lblCodigo.setText(null);
      editCodigo.requestFocusInWindow();
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
      Funcoes.habilitaBotoes(btNovo);
      Funcoes.desabilitaBotoes(btAlterar, btExcluir, btSalvar, btCancelar);
      Funcoes.limpaEdits(editCodigo, editConta, editDescricao);
      Funcoes.desabilitaEdits(editCodigo, editConta, editDescricao);
      checkAtivo.setSelected(false);
      checkAtivo.setEnabled(false);
      jTabbedPane1.setSelectedIndex(0);
      editPesquisa.requestFocusInWindow();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
      opcao = 1;
      Funcoes.habilitaBotoes(btCancelar, btSalvar);
      Funcoes.desabilitaBotoes(btAlterar, btExcluir, btNovo);
      Funcoes.habilitaEdits(editCodigo, editConta, editDescricao);
      checkAtivo.setEnabled(true);
      editCodigo.requestFocusInWindow();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
      java.util.Date utilDate = new java.util.Date();
      java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
      try {
        Rubrica rubrica = new Rubrica();
        dao = new RubricaDao();
        rubrica.setCodigo(editCodigo.getText());
        rubrica.setDescricao(editDescricao.getText());
        rubrica.setConta(editConta.getText());
        rubrica.setAtivo(checkAtivo.isSelected());
        rubrica.setCadastro(sqlDate);
        rubrica.setOperador_id(operador_id);
        if (opcao == 0) {
          dao.novaRubrica(rubrica);
        } else if (opcao == 1) {
          rubrica.setId(Integer.parseInt(lblCodigo.getText()));
          dao.alteraRubrica(rubrica);
        }
        Funcoes.desabilitaBotoes(btSalvar, btCancelar);
        Funcoes.habilitaBotoes(btNovo, btAlterar, btExcluir);
        Funcoes.desabilitaEdits(editCodigo, editConta, editDescricao);
        jTabbedPane1.setSelectedIndex(0);
        btPesquisa.doClick();
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
      int linha = jTable1.getModel().getRowCount();
      if (linha > 0) {
        Rubrica rubrica = new Rubrica();
        rubrica.setId(Integer.parseInt(lblCodigo.getText()));
        try {
          dao = new RubricaDao();
          dao.excluiRubrica(rubrica);
          Funcoes.informacao("Registro Excluido!");
          Funcoes.limpaEdits(editCodigo, editConta, editDescricao);
          Funcoes.desabilitaEdits(editCodigo, editConta, editDescricao);
          Funcoes.limpaLabel(lblCodigo);
          Funcoes.desabilitaBotoes(btAlterar, btCancelar, btExcluir, btSalvar);
          jTabbedPane1.setSelectedIndex(0);
          btPesquisa.doClick();
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
        FrameRubrica dialog = new FrameRubrica(new javax.swing.JFrame(), true);
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
  private javax.swing.JButton btPesquisa;
  private javax.swing.JButton btSalvar;
  private javax.swing.JCheckBox checkAtivo;
  private javax.swing.JTextField editCodigo;
  private javax.swing.JTextField editConta;
  private javax.swing.JTextField editDescricao;
  private javax.swing.JTextField editPesquisa;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTabbedPane jTabbedPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JLabel lblCodigo;
  // End of variables declaration//GEN-END:variables
}
