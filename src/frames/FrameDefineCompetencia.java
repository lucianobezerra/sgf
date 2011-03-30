package frames;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Competencia;
import model.Conexao;
import util.Funcoes;

/**
 * @author luciano
 */
public class FrameDefineCompetencia extends javax.swing.JDialog {

  String sql = null;
  Statement stmt = null;
  ResultSet result = null;
  Competencia cmpt = new Competencia();
  Connection conexao = null;

  public FrameDefineCompetencia(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    conexao = Conexao.getConexao();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    comboMes = new javax.swing.JComboBox();
    comboAno = new javax.swing.JComboBox();
    btSeleciona = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Competência");
    setModal(true);
    setResizable(false);

    jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Definir competência de trabalho");

    jLabel2.setText("Mês:");

    jLabel3.setText("Ano:");

    comboMes.setMaximumRowCount(5);
    comboMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

    comboAno.setMaximumRowCount(5);
    comboAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Ano", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012" }));

    btSeleciona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
    btSeleciona.setText("Seleciona");
    btSeleciona.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btSelecionaActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addGap(43, 43, 43)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(btSeleciona, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(27, 27, 27)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(comboMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(38, 38, 38)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(comboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(36, 36, 36)
        .addComponent(btSeleciona, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(28, Short.MAX_VALUE))
    );

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-331)/2, (screenSize.height-277)/2, 331, 277);
  }// </editor-fold>//GEN-END:initComponents

    private void btSelecionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionaActionPerformed
      try {
        String mes = String.valueOf(comboMes.getSelectedIndex());
        String ano = String.valueOf(comboAno.getSelectedItem().toString());
        mes = String.format("%02d", Integer.parseInt(mes));
        sql = "select id, mes, ano from competencias where ano='" + ano + "' and mes='" + mes + "'";
        stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        result = stmt.executeQuery(sql);
        while (result.next()) {
          Competencia.setCodCompetencia(result.getInt("id"));
          Competencia.setMesCompetencia(result.getString("mes"));
          Competencia.setAnoCompetencia(result.getString("ano"));
        }
        Funcoes.informacao("Competência Definida.");
        this.dispose();
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    }//GEN-LAST:event_btSelecionaActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        FrameDefineCompetencia dialog = new FrameDefineCompetencia(new javax.swing.JFrame(), true);
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
  private javax.swing.JButton btSeleciona;
  private javax.swing.JComboBox comboAno;
  private javax.swing.JComboBox comboMes;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  // End of variables declaration//GEN-END:variables
}

