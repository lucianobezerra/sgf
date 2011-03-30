package model;

import java.sql.Date;

/**
 * @author luciano
 */
public class Autorizacao {

  private int id;
  private int competencia_id;
  private int estabelecimento_id;
  private int rubrica_id;
  private int operador_id;
  private double valor;
  private Date data;
  private boolean impressa;
  private String observacao;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCompetencia_id() {
    return competencia_id;
  }

  public void setCompetencia_id(int competencia_id) {
    this.competencia_id = competencia_id;
  }

  public int getEstabelecimento_id() {
    return estabelecimento_id;
  }

  public void setEstabelecimento_id(int estabelecimento_id) {
    this.estabelecimento_id = estabelecimento_id;
  }

  public int getRubrica_id() {
    return rubrica_id;
  }

  public void setRubrica_id(int rubrica_id) {
    this.rubrica_id = rubrica_id;
  }

  public int getOperador_id() {
    return operador_id;
  }

  public void setOperador_id(int operador_id) {
    this.operador_id = operador_id;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public boolean isImpressa() {
    return impressa;
  }

  public void setImpressa(boolean impressa) {
    this.impressa = impressa;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }
}
