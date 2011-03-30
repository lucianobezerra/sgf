package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import util.Funcoes;

/**
 * @author luciano
 */
public class RubricaDao {

  public Connection conexao;
  PreparedStatement pstmt = null;
  Statement stmt = null;
  String sql = null;
  ResultSet result = null;

  public RubricaDao() throws SQLException {
    this.conexao = Conexao.getConexao();
  }

  public void novaRubrica(Rubrica rubrica) throws SQLException {
    try {
      sql = "INSERT INTO rubricas (codigo, descricao, conta, cadastro, operador_id, ativo) VALUES (?, ?, ?, ?, ?, ?)";
      pstmt = this.conexao.prepareStatement(sql);
      pstmt.setString(1, Rubrica.getCodigo());
      pstmt.setString(2, Rubrica.getDescricao());
      pstmt.setString(3, Rubrica.getConta());
      pstmt.setDate(4, Rubrica.getCadastro());
      pstmt.setInt(5, Rubrica.getOperador_id());
      pstmt.setBoolean(6, Rubrica.isAtivo());
      pstmt.execute();
      pstmt.close();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }

  public void alteraRubrica(Rubrica rubrica) throws SQLException {
    try {
      sql = "update rubricas"
              + " set codigo   = '" + Rubrica.getCodigo()
              + "', descricao = '" + Rubrica.getDescricao()
              + "', conta     = '" + Rubrica.getConta()
              + "', ativo     = " + Rubrica.isAtivo()
              + " where id    = " + Rubrica.getId();
      System.out.println(sql);
      pstmt = this.conexao.prepareStatement(sql);
      pstmt.executeUpdate();
      pstmt.close();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }

  public void excluiRubrica(Rubrica rubrica) throws SQLException {
    try {
      sql = "delete from rubricas where id = " + Rubrica.getId();
      pstmt = this.conexao.prepareStatement(sql);
      pstmt.executeUpdate();
      pstmt.close();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }
}
