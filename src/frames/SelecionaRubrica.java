package frames;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import model.Conexao;
import model.Rubrica;
import util.Funcoes;

/**
 * @author luciano
 */
public class SelecionaRubrica extends javax.swing.JDialog {

  class CenterRenderer extends DefaultTableCellRenderer {

    public CenterRenderer() {
      setHorizontalAlignment(CENTER);
    }
  }
  String sql = null;
  Statement stmt = null;
  ResultSet result = null;
  DefaultTableModel model = null;
  Connection conexao = null;

  public SelecionaRubrica(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    conexao = Conexao.getConexao();
    model = (DefaultTableModel) jTable1.getModel();
    TableCellRenderer centerRenderer = new CenterRenderer();
    TableColumn col_id = jTable1.getColumnModel().getColumn(0);
    TableColumn col_cod = jTable1.getColumnModel().getColumn(1);
    col_id.setCellRenderer(centerRenderer);
    col_cod.setCellRenderer(centerRenderer);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    editPesquisar = new javax.swing.JTextField();
    btFiltrar = new javax.swing.JButton();
    btConfirmar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Selecionar Rubrica");
    setResizable(false);
    addWindowFocusListener(new java.awt.event.WindowFocusListener() {
      public void windowGainedFocus(java.awt.event.WindowEvent evt) {
        formWindowGainedFocus(evt);
      }
      public void windowLostFocus(java.awt.event.WindowEvent evt) {
      }
    });
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Localizar"));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    editPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        editPesquisarKeyPressed(evt);
      }
    });
    jPanel1.add(editPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 290, 30));

    btFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/filtrar.gif"))); // NOI18N
    btFiltrar.setText("Filtrar");
    btFiltrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btFiltrarActionPerformed(evt);
      }
    });
    jPanel1.add(btFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 140, 30));

    btConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
    btConfirmar.setText("Confirmar");
    btConfirmar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btConfirmarActionPerformed(evt);
      }
    });
    jPanel1.add(btConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 140, 30));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 600, 60));

    jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null}
      },
      new String [] {
        "Id", "Código", "Descrição"
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
    jTable1.getColumnModel().getColumn(1).setPreferredWidth(12);
    jTable1.getColumnModel().getColumn(2).setResizable(false);
    jTable1.getColumnModel().getColumn(2).setPreferredWidth(400);

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, 595, 217));

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-600)/2, (screenSize.height-311)/2, 600, 311);
  }// </editor-fold>//GEN-END:initComponents

  private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
    try {
      Funcoes.removeLinha(model);
      stmt = this.conexao.createStatement();
      sql = "select id, codigo, descricao from rubricas where upper(descricao) like '%" + editPesquisar.getText().toUpperCase() + "%' order by descricao";
      result = stmt.executeQuery(sql);
      while (result.next()) {
        model.addRow(new Object[]{
                  result.getInt("id"),
                  result.getString("codigo"),
                  result.getString("descricao")
                });
      }
      jTable1.setModel(model);
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }//GEN-LAST:event_btFiltrarActionPerformed

  private void btConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmarActionPerformed
    int linha = -1;
    linha = jTable1.getSelectedRow();
    String id = model.getValueAt(linha, 0).toString();
    String cod = model.getValueAt(linha, 1).toString();
    String desc = model.getValueAt(linha, 2).toString();
    if (linha == -1) {
      Funcoes.informacao("Nenhuma Rubrica Selecionada");
    } else {
      Rubrica.setId(Integer.parseInt(id));
      Rubrica.setCodigo(cod);
      Rubrica.setDescricao(desc);
      this.dispose();
    }
  }//GEN-LAST:event_btConfirmarActionPerformed

  private void editPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editPesquisarKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
      btFiltrar.doClick();
    }
  }//GEN-LAST:event_editPesquisarKeyPressed

  private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
    editPesquisar.requestFocusInWindow();
  }//GEN-LAST:event_formWindowGainedFocus

  private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    if(evt.getClickCount() == 2){
      btConfirmar.doClick();
    }
  }//GEN-LAST:event_jTable1MouseClicked

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        SelecionaRubrica dialog = new SelecionaRubrica(new javax.swing.JFrame(), true);
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
  private javax.swing.JButton btConfirmar;
  private javax.swing.JButton btFiltrar;
  private javax.swing.JTextField editPesquisar;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;
  // End of variables declaration//GEN-END:variables
}
