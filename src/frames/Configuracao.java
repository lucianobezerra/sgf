package frames;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import security.Criptografia;
import model.ReadWritePropertiesFile;

/**
 *
 * @author Luciano
 */
public class Configuracao extends javax.swing.JDialog {

  ArrayList<String> configuracao = new ArrayList<String>();

  public void gravaConfiguracao() {
    int resposta = JOptionPane.showConfirmDialog(this, "Atenção:\n Confirma a alteração da configuração do Sistema?", "Confirmação", 2);
    if (resposta == 0) {
      ReadWritePropertiesFile.WriteProperty("database.properties", "Protocolo", Criptografia.CriptaBase64("jdbc:postgresql://"));
      ReadWritePropertiesFile.WriteProperty("database.properties", "Host", Criptografia.CriptaBase64(editServidor.getText()));
      ReadWritePropertiesFile.WriteProperty("database.properties", "Banco", Criptografia.CriptaBase64(editBanco.getText()));
      ReadWritePropertiesFile.WriteProperty("database.properties", "Usuario", Criptografia.CriptaBase64(editUsuario.getText()));
      ReadWritePropertiesFile.WriteProperty("database.properties", "Senha", Criptografia.CriptaBase64(new String(editSenha.getPassword())));
      ReadWritePropertiesFile.WriteProperty("config.properties", "PastaBpa", Criptografia.CriptaBase64(editPastaBpa.getText()));
      ReadWritePropertiesFile.WriteProperty("config.properties", "PastaLog", Criptografia.CriptaBase64(editPastaLog.getText()));
      JOptionPane.showMessageDialog(this, "O Sistema será reiniciado para efetivar a alteração", "Atenção", JOptionPane.INFORMATION_MESSAGE);
      System.exit(0);
    }
  }

  private void preencheForm() {
    lerConfiguracao();
    editServidor.setText(configuracao.get(1));
    editBanco.setText(configuracao.get(2));
    editUsuario.setText(configuracao.get(3));
    editSenha.setText(configuracao.get(4));
    editPastaBpa.setText(configuracao.get(5));
    editPastaLog.setText(configuracao.get(6));
  }

  private void lerConfiguracao() {
    configuracao.clear();
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Protocolo")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Host")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Banco")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Usuario")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("database.properties", "Senha")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("config.properties", "PastaBpa")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("config.properties", "PastaLog")));
    configuracao.add(Criptografia.DecriptaBase64(ReadWritePropertiesFile.ReadProperty("config.properties", "SerialHd")));
  }

  public Configuracao(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    preencheForm();
    editServidor.requestFocus();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    editServidor = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    editBanco = new javax.swing.JTextField();
    editUsuario = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    editSenha = new javax.swing.JPasswordField();
    btCancelar = new javax.swing.JButton();
    btGravar = new javax.swing.JButton();
    btTestar = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    editPastaBpa = new javax.swing.JTextField();
    editPastaLog = new javax.swing.JTextField();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    editServidor.setFont(new java.awt.Font("Tahoma", 0, 12));
    editServidor.setName("editServidor"); // NOI18N

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
    jLabel1.setText("Host:");

    editBanco.setFont(new java.awt.Font("Tahoma", 0, 12));
    editBanco.setName("editBanco"); // NOI18N

    editUsuario.setFont(new java.awt.Font("Tahoma", 0, 12));

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12));
    jLabel4.setText("Senha:");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12));
    jLabel2.setText("Banco:");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
    jLabel3.setText("Usuário:");

    editSenha.setFont(new java.awt.Font("Tahoma", 0, 12));
    editSenha.setMaximumSize(new java.awt.Dimension(50, 21));
    editSenha.setMinimumSize(new java.awt.Dimension(50, 21));
    editSenha.setPreferredSize(new java.awt.Dimension(50, 21));

    btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancelar.png"))); // NOI18N
    btCancelar.setText("Cancelar");
    btCancelar.setMaximumSize(new java.awt.Dimension(124, 30));
    btCancelar.setMinimumSize(new java.awt.Dimension(80, 30));
    btCancelar.setPreferredSize(new java.awt.Dimension(80, 30));
    btCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btCancelarActionPerformed(evt);
      }
    });

    btGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salvar.png"))); // NOI18N
    btGravar.setText("Gravar");
    btGravar.setMaximumSize(new java.awt.Dimension(123, 30));
    btGravar.setMinimumSize(new java.awt.Dimension(80, 30));
    btGravar.setPreferredSize(new java.awt.Dimension(80, 30));
    btGravar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btGravarActionPerformed(evt);
      }
    });

    btTestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/conexao.png"))); // NOI18N
    btTestar.setText("Testar");
    btTestar.setAlignmentX(0.5F);
    btTestar.setMaximumSize(new java.awt.Dimension(125, 30));
    btTestar.setMinimumSize(new java.awt.Dimension(80, 30));
    btTestar.setPreferredSize(new java.awt.Dimension(80, 30));
    btTestar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btTestarActionPerformed(evt);
      }
    });

    jLabel6.setText("Pasta de BPA:");

    jLabel7.setText("Pasta de Log:");

    jButton1.setText("...");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText("...");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel3)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(28, 28, 28)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(editUsuario, javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(editServidor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel4)
              .addComponent(jLabel2))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(editBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
              .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)))
            .addGap(16, 16, 16))
          .addGroup(layout.createSequentialGroup()
            .addComponent(btTestar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editPastaLog))
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editPastaBpa, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jButton2, 0, 0, Short.MAX_VALUE)
              .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(editServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1)
          .addComponent(jLabel2)
          .addComponent(editBanco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(editUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4)
          .addComponent(editSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(editPastaBpa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel6)
          .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel7)
          .addComponent(editPastaLog, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(27, 27, 27)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btTestar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-465)/2, (screenSize.height-255)/2, 465, 255);
  }// </editor-fold>//GEN-END:initComponents

    private void btTestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTestarActionPerformed
      this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
      Connection conexao = null;
      String url = "jdbc:postgresql://" + editServidor.getText() + "/" + editBanco.getText();
      String nomeUsuario = editUsuario.getText();
      String passUsuario = new String(editSenha.getPassword());
      try {
        Class.forName("org.postgresql.Driver");
        try {
          conexao = DriverManager.getConnection(url, nomeUsuario, passUsuario);
        } catch (SQLException erro) {
          JOptionPane.showMessageDialog(this, "Erro: " + erro);
        }
        if (conexao != null) {
          JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
        } else {
          JOptionPane.showMessageDialog(this, "Conexão NÃO realizada!");
        }
      } catch (ClassNotFoundException erro) {
        JOptionPane.showMessageDialog(this, "Erro: " + erro);
      }
      this.setCursor(null);

    }//GEN-LAST:event_btTestarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
      this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGravarActionPerformed
      gravaConfiguracao();
    }//GEN-LAST:event_btGravarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      JFileChooser local = new JFileChooser();
      local.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      local.setMultiSelectionEnabled(false);
      if (local.showSaveDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
        String pasta = local.getSelectedFile().getPath();
        editPastaBpa.setText(pasta);
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      JFileChooser local = new JFileChooser();
      local.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      local.setMultiSelectionEnabled(false);
      if (local.showSaveDialog(this) == javax.swing.JFileChooser.APPROVE_OPTION) {
        String pasta = local.getSelectedFile().getPath();
        editPastaLog.setText(pasta);
      }
    }//GEN-LAST:event_jButton2ActionPerformed
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        Configuracao dialog = new Configuracao(new javax.swing.JFrame(), true);
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
  private javax.swing.JButton btCancelar;
  private javax.swing.JButton btGravar;
  private javax.swing.JButton btTestar;
  private javax.swing.JTextField editBanco;
  private javax.swing.JTextField editPastaBpa;
  private javax.swing.JTextField editPastaLog;
  private javax.swing.JPasswordField editSenha;
  private javax.swing.JTextField editServidor;
  private javax.swing.JTextField editUsuario;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  // End of variables declaration//GEN-END:variables
}
