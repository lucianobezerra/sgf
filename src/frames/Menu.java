package frames;

import model.Competencia;
import model.OperadorLogado;
import util.Funcoes;

/**
 * @author luciano
 */
public class Menu extends javax.swing.JFrame {

  private String user = OperadorLogado.getInstance().getNome();
  private boolean admin = OperadorLogado.isAdmin();
  private boolean gerente = OperadorLogado.isGerente();
  public String cmpt = null;

  private void mostraCompetencia() {
    String mesCompetencia = null;
    String anoCompetencia = null;
    mesCompetencia = Competencia.getMesCompetencia();
    anoCompetencia = Competencia.getAnoCompetencia();
    jLabel2.setText("Competência: " + mesCompetencia + "/" + anoCompetencia);
  }

  public Menu() {
    initComponents();
    jLabel1.setText("Usuário: " + user);
    mostraCompetencia();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    jMenuItem1 = new javax.swing.JMenuItem();
    jMenuItem2 = new javax.swing.JMenuItem();
    jMenuItem3 = new javax.swing.JMenuItem();
    jMenuItem4 = new javax.swing.JMenuItem();
    jMenu2 = new javax.swing.JMenu();
    jMenuItem5 = new javax.swing.JMenuItem();
    jMenu3 = new javax.swing.JMenu();
    jMenuItem6 = new javax.swing.JMenuItem();
    jMenuItem7 = new javax.swing.JMenuItem();
    jMenu4 = new javax.swing.JMenu();
    jMenuItem8 = new javax.swing.JMenuItem();
    jMenu5 = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle(null);
    setFont(new java.awt.Font("Andale Mono", 0, 14));
    setResizable(false);

    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setText(null);
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, -1, -1));

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel2.setText(null);
    jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 5, 230, -1));

    jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 367, 836, 28));

    getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

    jMenuBar1.setFont(new java.awt.Font("Andale Mono", 0, 18));

    jMenu1.setMnemonic('T');
    jMenu1.setText("Tabelas");
    jMenu1.setPreferredSize(new java.awt.Dimension(120, 25));

    jMenuItem1.setText("Estabelecimentos");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem1ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem1);

    jMenuItem2.setText("Competências");
    jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem2ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem2);

    jMenuItem3.setText("Rubricas");
    jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem3ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem3);

    jMenuItem4.setText("Operadores");
    jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem4ActionPerformed(evt);
      }
    });
    jMenu1.add(jMenuItem4);

    jMenuBar1.add(jMenu1);

    jMenu2.setMnemonic('E');
    jMenu2.setText("Emissão");
    jMenu2.setPreferredSize(new java.awt.Dimension(120, 25));

    jMenuItem5.setMnemonic('A');
    jMenuItem5.setText("Autorização");
    jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem5ActionPerformed1(evt);
      }
    });
    jMenu2.add(jMenuItem5);

    jMenuBar1.add(jMenu2);

    jMenu3.setMnemonic('M');
    jMenu3.setText("Manutenção");
    jMenu3.setName("jMenu3"); // NOI18N

    jMenuItem6.setText("Configuração");
    jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem6ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem6);

    jMenuItem7.setText("Competência");
    jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem7ActionPerformed(evt);
      }
    });
    jMenu3.add(jMenuItem7);

    jMenuBar1.add(jMenu3);

    jMenu4.setText("Relatórios");
    jMenu4.setMinimumSize(new java.awt.Dimension(120, 25));

    jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
    jMenuItem8.setText("Autorização");
    jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItem8ActionPerformed(evt);
      }
    });
    jMenu4.add(jMenuItem8);

    jMenuBar1.add(jMenu4);

    jMenu5.setMnemonic('S');
    jMenu5.setText("Sair");
    jMenu5.setPreferredSize(new java.awt.Dimension(120, 23));
    jMenu5.addChangeListener(new javax.swing.event.ChangeListener() {
      public void stateChanged(javax.swing.event.ChangeEvent evt) {
        jMenu5StateChanged(evt);
      }
    });
    jMenuBar1.add(jMenu5);

    setJMenuBar(jMenuBar1);

    java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    setBounds((screenSize.width-839)/2, (screenSize.height-454)/2, 839, 454);
  }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
      if (admin) {
        Configuracao configura = new Configuracao(this, true);
        configura.setVisible(true);
      } else {
        Funcoes.informacao("Usuário sem Permissão!");
      }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
      if (admin || gerente) {
        FrameOperador operador = new FrameOperador(this, true);
        operador.setVisible(true);
      } else {
        Funcoes.informacao("Usuário sem Permissão!");
      }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      if (admin || gerente) {
        FrameEstabelecimento estabelecimento = new FrameEstabelecimento(this, true);
        estabelecimento.setVisible(true);
      } else {
        Funcoes.informacao("Usuário sem Permissão!");
      }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jMenu5StateChanged
      System.exit(0);
    }//GEN-LAST:event_jMenu5StateChanged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      if (admin || gerente) {
        FrameCompetencia competencia = new FrameCompetencia(this, true);
        competencia.setVisible(true);
      } else {
        Funcoes.informacao("Usuário sem Permissão!");
      }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      if (admin || gerente) {
        FrameRubrica rubrica = new FrameRubrica(this, true);
        rubrica.setVisible(true);
      } else {
        Funcoes.informacao("Usuário sem Permissão!");
      }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
      FrameAutorizacao aut = new FrameAutorizacao(null, true);
      aut.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
      FrameDefineCompetencia defineCmpt = new FrameDefineCompetencia(this, true);
      defineCmpt.setVisible(true);
      mostraCompetencia();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
      FrameFiltroAutorizacao filtro = new FrameFiltroAutorizacao(this, true);
      filtro.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem5ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed1
      FrameAutorizacao autoriza = new FrameAutorizacao(this, false);
      autoriza.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed1

  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new Menu().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JMenu jMenu1;
  private javax.swing.JMenu jMenu2;
  private javax.swing.JMenu jMenu3;
  private javax.swing.JMenu jMenu4;
  private javax.swing.JMenu jMenu5;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem1;
  private javax.swing.JMenuItem jMenuItem2;
  private javax.swing.JMenuItem jMenuItem3;
  private javax.swing.JMenuItem jMenuItem4;
  private javax.swing.JMenuItem jMenuItem5;
  private javax.swing.JMenuItem jMenuItem6;
  private javax.swing.JMenuItem jMenuItem7;
  private javax.swing.JMenuItem jMenuItem8;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  // End of variables declaration//GEN-END:variables
}
