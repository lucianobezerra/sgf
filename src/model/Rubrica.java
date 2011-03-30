package model;

import java.sql.Date;

/**
 * @author luciano
 */
public class Rubrica {

  private static int id;
  private static String codigo;
  private static String descricao;
  private static String conta;
  private static Date cadastro;
  private static boolean ativo;
  private static int operador_id;

  public static int getId() {
    return id;
  }

  public static void setId(int aId) {
    id = aId;
  }

  public static String getCodigo() {
    return codigo;
  }

  public static void setCodigo(String aCodigo) {
    codigo = aCodigo;
  }

  public static String getDescricao() {
    return descricao;
  }

  public static void setDescricao(String aDescricao) {
    descricao = aDescricao;
  }

  public static String getConta() {
    return conta;
  }

  public static void setConta(String aConta) {
    conta = aConta;
  }

  public static boolean isAtivo() {
    return ativo;
  }

  public static void setAtivo(boolean aAtivo) {
    ativo = aAtivo;
  }

  public static Date getCadastro() {
    return cadastro;
  }

  public static void setCadastro(Date aCadastro) {
    cadastro = aCadastro;
  }

  public static int getOperador_id() {
    return operador_id;
  }

  public static void setOperador_id(int aOperador_id) {
    operador_id = aOperador_id;
  }
}
