package model;

import java.sql.Date;

/**
 * @author luciano
 */
public class Competencia {

  private int id;
  private String mes;
  private String ano;
  private Date data_cadastro;
  private int operador_id;
  private Boolean ativo;
  public static int codCompetencia;
  public static String mesCompetencia;
  public static String anoCompetencia;

  public static String mesExtenso(int mes) {
    String extenso = null;
    switch (mes) {
      case 1:
        extenso = "Janeiro";
        break;
      case 2:
        extenso = "Fevereiro";
        break;
      case 3:
        extenso = "Março";
        break;
      case 4:
        extenso = "Abril";
        break;
      case 5:
        extenso = "Maio";
        break;
      case 6:
        extenso = "Junho";
        break;
      case 7:
        extenso = "Julho";
        break;
      case 8:
        extenso = "Agosto";
        break;
      case 9:
        extenso = "Setembro";
        break;
      case 10:
        extenso = "Outubro";
        break;
      case 11:
        extenso = "Novembro";
        break;
      case 12:
        extenso = "Dezembro";
        break;
    }
    return extenso;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMes() {
    return mes;
  }

  public void setMes(String mes) {
    this.mes = mes;
  }

  public String getAno() {
    return ano;
  }

  public void setAno(String ano) {
    this.ano = ano;
  }

  public Date getData_cadastro() {
    return data_cadastro;
  }

  public void setData_cadastro(Date data_cadastro) {
    this.data_cadastro = data_cadastro;
  }

  public int getOperador_id() {
    return operador_id;
  }

  public void setOperador_id(int operador_id) {
    this.operador_id = operador_id;
  }

  public Boolean isAtivo() {
    return getAtivo();
  }

  public void setAtivo(Boolean ativo) {
    this.ativo = ativo;
  }

  public static int getCodCompetencia() {
    return codCompetencia;
  }

  public static void setCodCompetencia(int aCodCompetencia) {
    codCompetencia = aCodCompetencia;
  }

  public Boolean getAtivo() {
    return ativo;
  }

  public static String getMesCompetencia() {
    return mesCompetencia;
  }

  public static void setMesCompetencia(String aMesCompetencia) {
    mesCompetencia = aMesCompetencia;
  }

  public static String getAnoCompetencia() {
    return anoCompetencia;
  }

  public static void setAnoCompetencia(String aAnoCompetencia) {
    anoCompetencia = aAnoCompetencia;
  }
}
