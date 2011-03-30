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
public class CompetenciaDao {

  public Connection conexao;
  PreparedStatement pstmt = null;
  Statement stmt = null;
  String sql = null;
  ResultSet result = null;

  public CompetenciaDao() throws SQLException {
    this.conexao = Conexao.getConexao();
  }

  public void novaCompetencia(Competencia cmpt) throws SQLException {
    try {
      sql = "insert into competencias (ano, mes, operador_id, cadastro, ativo) values (?, ?, ?, ?, ?)";
      pstmt = this.conexao.prepareStatement(sql);
      pstmt.setString(1, cmpt.getAno());
      pstmt.setString(2, cmpt.getMes());
      pstmt.setInt(3, cmpt.getOperador_id());
      pstmt.setDate(4, cmpt.getData_cadastro());
      pstmt.setBoolean(5, cmpt.isAtivo());
      pstmt.execute();
      pstmt.close();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }

  public void alteraCompetencia(Competencia cmpt) throws SQLException {
    try {
      String mes = cmpt.getMes();
      String ano = cmpt.getAno();
      Boolean ativo = cmpt.isAtivo();
      sql = "update competencias "
              + "set mes='" + mes + "', ano = '" + ano + "', ativo = " + ativo + " where id=" + cmpt.getId();
      pstmt = this.conexao.prepareStatement(sql);
      pstmt.executeUpdate();
      pstmt.close();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }

  public void excluiCompetencia(Competencia cmpt) throws SQLException {
    try {
      sql = "delete from competencias where id=" + cmpt.getId();
      pstmt = this.conexao.prepareStatement(sql);
      pstmt.executeUpdate();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }
}
