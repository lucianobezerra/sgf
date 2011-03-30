package model;

/**
 * @author luciano
 */
public class OperadorLogado {

  private String nome;
  private Integer ID;
  private Integer nivel;

  private OperadorLogado() {
  }

  private static class OperadorLogadoHolder {

    private final static OperadorLogado instance = new OperadorLogado();
  }

  public static Boolean isLogged() {
    if (OperadorLogadoHolder.instance != null) {
      return true;
    }
    return false;
  }

  public static Boolean isAdmin() {
    if (isLogged()) {
      if (getInstance().getNivel() == 0) {
        return true;
      }
    }
    return false;
  }

  public static Boolean isGerente(){
    if(isLogged()){
      if(getInstance().getNivel() == 1){
        return true;
      }
    }
    return false;
  }

  public static OperadorLogado getInstance() {
    return OperadorLogadoHolder.instance;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getID() {
    return ID;
  }

  public void setID(Integer id) {
    ID = id;
  }

  public Integer getNivel() {
    return nivel;
  }

  public void setNivel(Integer nivel) {
    this.nivel = nivel;
  }
}
