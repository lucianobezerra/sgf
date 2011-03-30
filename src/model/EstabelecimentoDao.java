package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import util.Funcoes;
import util.Validacao;

/**
 * @author luciano
 */
public class EstabelecimentoDao {

  public Connection conexao;
  PreparedStatement stmt = null;
  Statement stmt2 = null;
  String sql = null;
  ResultSet result = null;

  public EstabelecimentoDao() throws SQLException {
    this.conexao = Conexao.getConexao();
  }

  private boolean cpfCnpjValido(String cpf_cnpj, String tipo) {
    if (tipo.equals("F")) {
      if (Validacao.isValidCPF(cpf_cnpj)) {
        return true;
      }
      return false;
    }

    if (tipo.equals("J")) {
      if (Validacao.isValidCNPJ(cpf_cnpj)) {
        return true;
      }
      return false;
    }
    return false;
  }

  public void addEstabelecimento(Estabelecimento ups) throws SQLException {
    String cpf_cnpj = Estabelecimento.getCpf_cnpj();
    String tipo = Estabelecimento.getTipo();
    if (cpfCnpjValido(cpf_cnpj, tipo)) {
      try {
        sql = "INSERT INTO estabelecimentos (cnes, nome, nome_completo, tipo, cpf_cnpj, operador_id, data_cadastro, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = (PreparedStatement) this.conexao.prepareStatement(sql);
        stmt.setString(1, Estabelecimento.getCnes());
        stmt.setString(2, Estabelecimento.getNome());
        stmt.setString(3, Estabelecimento.getNome_completo());
        stmt.setString(4, tipo);
        stmt.setString(5, Estabelecimento.getCpf_cnpj());
        stmt.setInt(6, Estabelecimento.getOperador_id());
        stmt.setDate(7, (Date) Estabelecimento.getData_cadastro());
        stmt.setBoolean(8, Estabelecimento.isAtivo());
        stmt.execute();
        stmt.close();
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    } else {
      JOptionPane.showMessageDialog(null, "Cpf ou CNPJ Inválido!", "Atenção", 0);
    }
  }

  public static boolean existemRegistros(String texto) throws SQLException {
    boolean existe = false;
    String consulta = "select count(id) as qtde from estabelecimentos where upper(nome) like upper('%" + texto + "%')";
    Connection conn = Conexao.getConexao();
    Statement ponte = conn.createStatement();
    ResultSet retorno = ponte.executeQuery(consulta);
    while (retorno.next()) {
      int qtde = retorno.getInt("qtde");
      if (qtde > 0) {
        existe = true;
      } else {
        existe = false;
      }
    }
    return existe;
  }

  public ResultSet listaPorNome(String nome) throws SQLException {
    Statement ponte = null;
    ResultSet ups = null;
    if (existemRegistros(nome)) {
      sql = "select * from estabelecimentos where nome like '%" + nome + "' order by nome";
      try {
        ponte = conexao.createStatement();
        ponte.executeQuery(sql);
        ups = ponte.getResultSet();
      } catch (SQLException ex) {
        Funcoes.erro(ex.getLocalizedMessage());
      }
    }
    return ups;
  }

  public void alteraEstabelecimento(Estabelecimento ups) throws SQLException {
    String cpf_cnpj = Estabelecimento.getCpf_cnpj();
    String tipo = Estabelecimento.getTipo().substring(0, 1);
    if (cpfCnpjValido(cpf_cnpj, tipo)) {
      try {
        String cnes = Estabelecimento.getCnes();
        String razao = Estabelecimento.getNome();
        String fanta = Estabelecimento.getNome_completo();
        sql = "update estabelecimentos set cnes='" + cnes + "', nome='" + razao + "', nome_completo='"
                + fanta + "', tipo='" + tipo + "', cpf_cnpj='" + Estabelecimento.getCpf_cnpj() + "' where id=" + Estabelecimento.getId();
        stmt = (PreparedStatement) this.conexao.prepareStatement(sql);
        stmt.executeUpdate();
        stmt.close();
      } catch (SQLException erro) {
        Funcoes.erro(erro.getLocalizedMessage());
      }
    } else {
      Funcoes.informacao("Cpf ou CNPJ Inválido!");
    }
  }

  public void excluiEstabelecimento(Estabelecimento ups) throws SQLException {
    sql = "delete from estabelecimentos where id=" + Estabelecimento.getId();
    stmt = this.conexao.prepareStatement(sql);
    stmt.executeUpdate();
  }
}
