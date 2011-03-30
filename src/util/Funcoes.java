package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author luciano
 */
public class Funcoes {

  public static boolean removeLinha(DefaultTableModel model) {
    int linha = model.getRowCount();
    for (int i = linha - 1; i >= 0; --i) {
      model.removeRow(i);
    }
    return false;
  }

  public static boolean checaForm(JTextField... edits) {
    for (int i = 0; i < edits.length; i++) {
      if (edits[i].getText().equals("")) {
        informacao("Preencha todos os campos");
        return false;
      }
    }
    return true;
  }

  public static void informacao(String msg) {
    JOptionPane.showMessageDialog(null, msg, "Atenção", JOptionPane.INFORMATION_MESSAGE);
  }

  public static void erro(String msg) {
    JOptionPane.showMessageDialog(null, msg, "Atenção", JOptionPane.ERROR_MESSAGE);
  }

  public static void cuidado(String msg) {
    JOptionPane.showMessageDialog(null, msg, "Atenção", JOptionPane.WARNING_MESSAGE);
  }

  public static void limpaLabel(JLabel... label) {
    for (int i = 0; i < label.length; i++) {
      label[i].setText(null);
    }
  }

  public static void habilitaCombo(JComboBox... combos) {
    for (int i = 0; i < combos.length; i++) {
      combos[i].setEnabled(true);
    }
  }

  public static void desabilitaCombo(JComboBox... combos) {
    for (int i = 0; i < combos.length; i++) {
      combos[i].setEnabled(false);
    }
  }

  public static void limpaCombo(JComboBox... combos) {
    for (int i = 0; i < combos.length; i++) {
      combos[i].setSelectedIndex(-1);
    }
  }

  public static void habilitaCheck(JCheckBox... checks) {
    for (int i = 0; i < checks.length; i++) {
      checks[i].setEnabled(true);
    }
  }

  public static void desabilitaCheck(JCheckBox... checks) {
    for (int i = 0; i < checks.length; i++) {
      checks[i].setEnabled(false);
    }
  }

  public static void limpaCheck(JCheckBox... checks) {
    for (int i = 0; i < checks.length; i++) {
      checks[i].setSelected(false);
    }
  }

  public static void habilitaBotoes(JButton... botoes) {
    for (int i = 0; i < botoes.length; i++) {
      botoes[i].setEnabled(true);
    }
  }

  public static void desabilitaBotoes(JButton... botoes) {
    for (int i = 0; i < botoes.length; i++) {
      botoes[i].setEnabled(false);
    }
  }

  public static void limpaEdits(JTextField... edits) {
    for (int i = 0; i < edits.length; i++) {
      edits[i].setText(null);
    }
  }

  public static void habilitaEdits(JTextField... edits) {
    for (int i = 0; i < edits.length; i++) {
      edits[i].setEnabled(true);
    }
  }

  public static void desabilitaEdits(JTextField... edits) {
    for (int i = 0; i < edits.length; i++) {
      edits[i].setEnabled(false);
    }
  }

  public static java.sql.Date formataData(String data) throws Exception {
    if (data == null || data.equals("")) {
      return null;
    }
    java.sql.Date date = null;
    try {
      DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      date = new java.sql.Date(((java.util.Date) formatter.parse(data)).getTime());
    } catch (ParseException e) {
      erro(e.getLocalizedMessage());
    }
    return date;
  }
}
