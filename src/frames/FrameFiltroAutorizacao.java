package frames;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import model.Competencia;
import model.Conexao;
import model.OperadorLogado;
import net.sf.jasperreports.engine.JRException;
import util.Funcoes;
import util.Relatorio;

public class FrameFiltroAutorizacao extends javax.swing.JDialog {

  private String operador = OperadorLogado.getInstance().getNome();
  String aMes = null;
  String aAno = null;
  Map param = new HashMap();
  Connection conexao = Conexao.getConexao();
  InputStream inputStream = null;
  String titulo = null;
  InetAddress addr = null;

  public FrameFiltroAutorizacao(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    jPanel2 = new javax.swing.JPanel();
    radioCompetencia = new javax.swing.JRadioButton();
    radioRubrica = new javax.swing.JRadioButton();
    radioEstabelecimento = new javax.swing.JRadioButton();
    jPanel3 = new javax.swing.JPanel();
    editCompetencia = new javax.swing.JFormattedTextField();
    jPanel4 = new javax.swing.JPanel();
    editRubrica = new javax.swing.JTextField();
    jPanel5 = new javax.swing.JPanel();
    editUnidade = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    checkSerieAnual = new javax.swing.JCheckBox();
    checkAtual = new javax.swing.JCheckBox();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Escolha o Filtro para o Relatório");
    setModalExclusionType(null);
    setModalityType(null);
    setResizable(false);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecione uma Opção"));
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    buttonGroup1.add(radioCompetencia);
    radioCompetencia.setMnemonic('C');
    radioCompetencia.setText("Competência");
    radioCompetencia.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        radioCompetenciaActionPerformed(evt);
      }
    });
    jPanel2.add(radioCompetencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 150, -1));

    buttonGroup1.add(radioRubrica);
    radioRubrica.setMnemonic('R');
    radioRubrica.setText("Rubrica");
    radioRubrica.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        radioRubricaActionPerformed(evt);
      }
    });
    jPanel2.add(radioRubrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 150, -1));

    buttonGroup1.add(radioEstabelecimento);
    radioEstabelecimento.setMnemonic('E');
    radioEstabelecimento.setText("Estabelecimento");
    radioEstabelecimento.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        radioEstabelecimentoActionPerformed(evt);
      }
    });
    jPanel2.add(radioEstabelecimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 150, -1));

    getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 530, 60));

    jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Competência"));

    try {
      editCompetencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
    } catch (java.text.ParseException ex) {
      ex.printStackTrace();
    }
    editCompetencia.setFont(new java.awt.Font("Andale Mono", 0, 14));

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(editCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(30, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addComponent(editCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(13, Short.MAX_VALUE))
    );

    getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 80, 170, 70));

    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Rubrica"));

    editRubrica.setFont(new java.awt.Font("Andale Mono", 0, 14));

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(editRubrica, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(21, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addComponent(editRubrica, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(13, Short.MAX_VALUE))
    );

    getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 170, 70));

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Estabelecimento"));

    editUnidade.setFont(new java.awt.Font("Andale Mono", 0, 14));

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(editUnidade, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel5Layout.setVerticalGroup(
      jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel5Layout.createSequentialGroup()
        .addComponent(editUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(13, Short.MAX_VALUE))
    );

    getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 80, 170, 70));

    jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imprimir.gif"))); // NOI18N
    jButton1.setMnemonic('I');
    jButton1.setText("Imprimir");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });
    getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 170, 150, 30));

    checkSerieAnual.setText("Série Anual");
    checkSerieAnual.setEnabled(false);
    getContentPane().add(checkSerieAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 175, -1, -1));

    checkAtual.setSelected(true);
    checkAtual.setText("Competência Atual");
    getContentPane().add(checkAtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 175, 170, -1));

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-551)/2, (screenSize.height-252)/2, 551, 252);
  }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      aMes = Competencia.getMesCompetencia();
      aAno = Competencia.getAnoCompetencia();
      if (!checkAtual.isSelected()) {
        aMes = editCompetencia.getText().substring(0, 2);
        aAno = editCompetencia.getText().substring(3, 7);
      }
      
      param.put("mes", aMes);
      param.put("ano", aAno);
      param.put("operador", operador);
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
          inputStream = getClass().getResourceAsStream("/lista_autorizacao_competencia.jasper");
          titulo = "Autorizações por Competência";
        } else if (radioRubrica.isSelected()) {
          inputStream = getClass().getResourceAsStream("/lista_autorizacao_rubrica.jasper");
          param.put("rubrica", editRubrica.getText());
          titulo = "Autorizações por Rubrica";
        } else if (radioEstabelecimento.isSelected()) {
          if (checkSerieAnual.isSelected()) {
            inputStream = getClass().getResourceAsStream("/serie_anual.jasper");
            param.put("cnes", editUnidade.getText());
            titulo = "Série Histórica de Pagamentos";
          } else {
            inputStream = getClass().getResourceAsStream("/lista_autorizacao_unidade.jasper");
            param.put("cnes", editUnidade.getText());
            titulo = "Autorizações por Estabelecimento";
          }
        }
        Relatorio.openReport(titulo, inputStream, param, conexao);
      } catch (JRException erro) {
        erro.getLocalizedMessage();
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void radioEstabelecimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEstabelecimentoActionPerformed
      editRubrica.setEnabled(false);
      editUnidade.setEnabled(true);
      editUnidade.requestFocusInWindow();
      checkSerieAnual.setEnabled(true);
    }//GEN-LAST:event_radioEstabelecimentoActionPerformed

    private void radioRubricaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioRubricaActionPerformed
      editUnidade.setEnabled(false);
      editRubrica.setEnabled(true);
      editRubrica.requestFocusInWindow();
      checkSerieAnual.setEnabled(false);
    }//GEN-LAST:event_radioRubricaActionPerformed

    private void radioCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCompetenciaActionPerformed
      editUnidade.setEnabled(false);
      editRubrica.setEnabled(false);
      editCompetencia.setText(Competencia.getMesCompetencia() + Competencia.getAnoCompetencia());
      editCompetencia.requestFocusInWindow();
      checkSerieAnual.setEnabled(false);
    }//GEN-LAST:event_radioCompetenciaActionPerformed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        FrameFiltroAutorizacao dialog = new FrameFiltroAutorizacao(new javax.swing.JFrame(), true);
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
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JCheckBox checkAtual;
  private javax.swing.JCheckBox checkSerieAnual;
  private javax.swing.JFormattedTextField editCompetencia;
  private javax.swing.JTextField editRubrica;
  private javax.swing.JTextField editUnidade;
  private javax.swing.JButton jButton1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JPanel jPanel5;
  private javax.swing.JRadioButton radioCompetencia;
  private javax.swing.JRadioButton radioEstabelecimento;
  private javax.swing.JRadioButton radioRubrica;
  // End of variables declaration//GEN-END:variables
}
