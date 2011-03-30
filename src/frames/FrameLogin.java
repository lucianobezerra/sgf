package frames;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Competencia;
import model.Conexao;
import model.OperadorLogado;
import security.Criptografia;
import util.Funcoes;

/**
 * @author luciano
 */
public class FrameLogin extends javax.swing.JDialog {

  private int conta = 0;
  Statement stmt = null;
  ResultSet result = null;
  Connection conexao = Conexao.getConexao();

  public FrameLogin(java.awt.Frame parent, boolean modal) throws SQLException {
    super(parent, modal);
    initComponents();
    editUser.requestFocusInWindow();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    btAcesso = new javax.swing.JButton();
    editSenha = new javax.swing.JPasswordField();
    jLabel4 = new javax.swing.JLabel();
    editUser = new javax.swing.JTextField();
    editCompetencia = new javax.swing.JFormattedTextField();
    jLabel5 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jLabel3 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Acesso ao Sistema");
    setResizable(false);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acesso"));
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setText("Login:");
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

    jLabel2.setText("Senha:");
    jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

    btAcesso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
    btAcesso.setText("Login");
    btAcesso.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btAcessoActionPerformed(evt);
      }
    });
    jPanel2.add(btAcesso, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 120, 30));

    editSenha.setFont(new java.awt.Font("Andale Mono", 0, 14));
    jPanel2.add(editSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 140, 30));

    jLabel4.setFont(new java.awt.Font("Andale Mono", 0, 14));
    jLabel4.setForeground(new java.awt.Color(248, 28, 28));
    jLabel4.setText(" ");
    jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 191, -1, -1));

    editUser.setFont(new java.awt.Font("Andale Mono", 0, 14));
    jPanel2.add(editUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 180, 30));

    try {
      editCompetencia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/####")));
    } catch (java.text.ParseException ex) {
      ex.printStackTrace();
    }
    editCompetencia.setFont(new java.awt.Font("Andale Mono", 0, 14));
    editCompetencia.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyPressed(java.awt.event.KeyEvent evt) {
        editCompetenciaKeyPressed(evt);
      }
    });
    jPanel2.add(editCompetencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 110, 30));

    jLabel5.setText("Competência:");
    jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

    getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 5, 360, 250));

    jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
    jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

    jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login.gif"))); // NOI18N
    jScrollPane1.setViewportView(jLabel3);

    getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-560)/2, (screenSize.height-293)/2, 560, 293);
  }// </editor-fold>//GEN-END:initComponents

    private void btAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAcessoActionPerformed
      String user = editUser.getText().toUpperCase();
      String pass = String.valueOf(editSenha.getPassword());
      String mes = editCompetencia.getText().substring(0, 2);
      String ano = editCompetencia.getText().substring(3, 7);
      pass = Criptografia.CriptaBase64(pass);
      if (conta <= 2) {
        String sql = "select * from operadores where upper(nome)= '" + user + "' and senha='" + pass + "' and ativo=true";
        try {
          stmt = this.conexao.createStatement();
          result = stmt.executeQuery(sql);
          if (result.next()) {
            OperadorLogado.getInstance().setID(result.getInt("id"));
            OperadorLogado.getInstance().setNome(result.getString("nome_completo"));
            OperadorLogado.getInstance().setNivel(result.getInt("nivel"));

            sql = "select id, mes, ano from competencias where ano='" + ano + "' and mes='" + mes + "'";
            stmt = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            result = stmt.executeQuery(sql);
            while (result.next()) {
              Competencia.setCodCompetencia(result.getInt("id"));
              Competencia.setMesCompetencia(result.getString("mes"));
              Competencia.setAnoCompetencia(result.getString("ano"));
            }
            Menu menu = new Menu();
            menu.setVisible(true);
            this.dispose();
          } else {
            conta++;
            if (conta <= 2) {
              jLabel4.setText("<html>Usuário e/ou Senha Incorretos,<br> tentativa " + conta + " de 3!</html>");
            } else {
              Funcoes.informacao("Número de tentativas excedidas.\n\nO Sistema será finalizado");
              System.exit(0);
            }
          }
        } catch (SQLException erro) {
          Funcoes.erro(erro.getLocalizedMessage());
        }
      }
    }//GEN-LAST:event_btAcessoActionPerformed

      private void editCompetenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editCompetenciaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          btAcesso.doClick();
        }
      }//GEN-LAST:event_editCompetenciaKeyPressed

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        FrameLogin dialog = null;
        try {
          dialog = new FrameLogin(new javax.swing.JFrame(), true);
        } catch (SQLException ex) {
          System.out.println(ex.getLocalizedMessage());
        }
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
  private javax.swing.JButton btAcesso;
  public javax.swing.JFormattedTextField editCompetencia;
  private javax.swing.JPasswordField editSenha;
  private javax.swing.JTextField editUser;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration//GEN-END:variables
}
