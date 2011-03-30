package util;

import java.awt.BorderLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Map;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {

  public static void openReport(String titulo, InputStream inputStream, Map parametros, Connection conexao) throws JRException {
    JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, conexao);
    JasperViewer jrViewer = new JasperViewer(print, false);
    jrViewer.setExtendedState(JFrame.MAXIMIZED_BOTH);
    jrViewer.setTitle(titulo);
    jrViewer.setVisible(true);
//    viewReportFrame(titulo, print);
  }

  public static void openReport(String titulo, InputStream inputStream, Map parametros, JRDataSource dataSource) throws JRException {
    JasperPrint print = JasperFillManager.fillReport(inputStream, parametros, dataSource);
    viewReportFrame(titulo, print);
  }

  private static void viewReportFrame(String titulo, JasperPrint print) {
    JRViewer viewer = new JRViewer(print);
    JFrame frameRelatorio = new JFrame(titulo);
    frameRelatorio.add(viewer, BorderLayout.CENTER);
    frameRelatorio.setSize(500, 500);
    frameRelatorio.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frameRelatorio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frameRelatorio.setVisible(true);
  }
}
