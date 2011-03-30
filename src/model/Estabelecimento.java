package model;

import java.util.Date;

/**
 * @author luciano
 */
public class Estabelecimento {
private static int id;
private static String cnes;
private static String nome;
private static String nome_completo;
private static String tipo;
private static String cpf_cnpj;
private static int operador_id;
private static Date data_cadastro;
private static boolean ativo;

  public static int getId() {
    return id;
  }

  public static void setId(int aId) {
    id = aId;
  }

  public static String getCnes() {
    return cnes;
  }

  public static void setCnes(String aCnes) {
    cnes = aCnes;
  }

  public static String getNome() {
    return nome;
  }

  public static void setNome(String aNome) {
    nome = aNome;
  }

  public static String getNome_completo() {
    return nome_completo;
  }

  public static void setNome_completo(String aNome_completo) {
    nome_completo = aNome_completo;
  }

  public static String getTipo() {
    return tipo;
  }

  public static void setTipo(String aTipo) {
    tipo = aTipo;
  }

  public static String getCpf_cnpj() {
    return cpf_cnpj;
  }

  public static void setCpf_cnpj(String aCpf_cnpj) {
    cpf_cnpj = aCpf_cnpj;
  }

  public static int getOperador_id() {
    return operador_id;
  }

  public static void setOperador_id(int aOperador_id) {
    operador_id = aOperador_id;
  }

  public static Date getData_cadastro() {
    return data_cadastro;
  }

  public static void setData_cadastro(Date aData_cadastro) {
    data_cadastro = aData_cadastro;
  }

  public static boolean isAtivo() {
    return ativo;
  }

  public static void setAtivo(boolean aAtivo) {
    ativo = aAtivo;
  }

}
