package util;

import java.awt.Dimension;
import javax.swing.JLabel;

/**
 * @author luciano
 */
public class StatusBar extends JLabel {

  public StatusBar() {
    super();
    super.setPreferredSize(new Dimension(100, 16));
  }

  public void setMessage(String Mensagem){
    setText(" " + Mensagem);
  }
}
