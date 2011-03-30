package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Funcoes;

/**
 * @author luciano
 */
public class OperadorDao {

  public Connection conexao;
  PreparedStatement stmt = null;
  Statement stmt2 = null;
  String sql = null;

  public OperadorDao() throws SQLException {
    this.conexao = Conexao.getConexao();
  }

  public void addOperador(Operador operador) throws SQLException {
    try {
      sql = "insert into operadores (nome, nome_completo, email, senha, nivel, ativo) values (?, ?, ?, ?, ?, ?)";
      stmt = (PreparedStatement) this.conexao.prepareStatement(sql);
      stmt.setString(1, operador.getLogin());
      stmt.setString(2, operador.getNome());
      stmt.setString(3, operador.getEmail());
      stmt.setString(4, operador.getSenha());
      stmt.setInt(5, operador.getNivel());
      stmt.setBoolean(6, operador.isAtivo());
      stmt.execute();
      stmt.close();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }

  public List consultaOperador(Operador operador) throws SQLException {
    sql = "select * from operadores where nome = '" + operador.getLogin() + "' and ativo = true";
    List<Operador> listaOperador = new ArrayList<Operador>();
    stmt2 = (Statement) this.conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet result = stmt2.executeQuery(sql);
    while (result.next()) {
      Operador oper = new Operador();
      oper.setId(result.getInt("id"));
      oper.setLogin(result.getString("nome"));
      oper.setNome(result.getString("nome_completo"));
      oper.setEmail(result.getString("email"));
      oper.setSenha(result.getString("senha"));
      oper.setNivel(result.getInt("nivel"));
      oper.setAtivo(result.getBoolean("ativo"));
      listaOperador.add(oper);
    }
    result.close();
    return listaOperador;
  }

  public void alterOperador(Operador operador) throws SQLException {
    try {
      sql = "update operadores set nome = '" + operador.getLogin() + "', nome_completo = '" + operador.getNome() + "', email = '"
              + operador.getEmail() + "', senha = '" + operador.getSenha() + "', nivel = " + operador.getNivel()
              + ", ativo = " + operador.isAtivo() + " where id=" + operador.getId();
      stmt = this.conexao.prepareStatement(sql);
      stmt.executeUpdate();
    } catch (SQLException erro) {
      Funcoes.erro(erro.getLocalizedMessage());
    }
  }

  public void excluiOperador(Operador operador) throws SQLException {
    sql = "delete from operadores where id=" + operador.getId();
    stmt = this.conexao.prepareStatement(sql);
    stmt.executeUpdate();
  }
}
