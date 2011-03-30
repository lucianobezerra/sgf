package sgf;

import frames.FrameLogin;
import java.sql.SQLException;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author luciano
 */
public class Main {

  public static void main(String... args) throws SQLException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
//    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.windowsLookAndFeel");
    FrameLogin login = new FrameLogin(null, true);
    login.setVisible(true);
  }
}
