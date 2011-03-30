package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.Funcoes;

/**
 * @author luciano
 */
public class AutorizacaoDao {

  public Connection conexao;
  PreparedStatement pstmt = null;
  String sql = null;
  ResultSet result = null;

  public AutorizacaoDao() throws SQLException {
    this.conexao = Conexao.getConexao();
  }

  public void addAutorizacao(Autorizacao aut) throws SQLException {
    try {
      sql = "INSERT INTO autorizacoes (competencia_id, estabelecimento_id, rubrica_id, operador_id, valor, data, observacoes) VALUES (?, ?, ?, ?, ?, ?, ?)";
      pstmt = this.conexao.prepareStatement(sql);
      pstmt.setInt(1, aut.getCompetencia_id());
      pstmt.setInt(2, aut.getEstabelecimento_id());
      pstmt.setInt(3, aut.getRubrica_id());
      pstmt.setInt(4, aut.getOperador_id());
      pstmt.setDouble(5, aut.getValor());
      pstmt.setDate(6, aut.getData());
      pstmt.setString(7, aut.getObservacao());
      pstmt.execute();
      pstmt.close();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }

  public void alterAutorizacao(Autorizacao aut) throws SQLException {
    try {
      int id = aut.getId();
      int cmpt = aut.getId();
      int ups = aut.getEstabelecimento_id();
      int rub = aut.getRubrica_id();
      double valor = aut.getValor();
      String obs = aut.getObservacao();
      sql = "update autorizacoes "
              + "set competencia_id=" + cmpt + ", "
              + "estabelecimento_id=" + ups + ", "
              + "rubrica_id=" + rub + ", "
              + "valor=" + valor + ", "
              + "observacoes='" + obs + "' where id=" + id;
      pstmt = this.conexao.prepareStatement(sql);
      pstmt.executeUpdate();
      pstmt.close();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }

  public void excluiAutorizacao(Autorizacao aut) throws SQLException {
    try {
      int id = aut.getId();
      sql = "delete from autorizacoes where id=" + id;
      pstmt = this.conexao.prepareStatement(sql);
      pstmt.executeUpdate();
    } catch (SQLException erro){
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }
}
