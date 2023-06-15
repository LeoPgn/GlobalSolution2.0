package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.PessoaFisica;

public class PessoaFisicaDAO {

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public PessoaFisicaDAO(Connection con) {
		setCon(con);
	}

	// Método Inserir
	public String inserir(PessoaFisica pessoaFisica) {
		String sql = "insert into cliente(cliente_nome, email, senha, cpf, data_nasc, cep, ddd, celular, telefone) values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, pessoaFisica.getNome());
			ps.setString(2, pessoaFisica.getEmail());
			ps.setString(3, pessoaFisica.getSenha());
			ps.setString(4, pessoaFisica.getCpf());
			ps.setString(5, pessoaFisica.getDataNasc());
			ps.setString(6, pessoaFisica.getCep());
			ps.setInt(7, pessoaFisica.getDdd());
			ps.setString(8, pessoaFisica.getCelular());
			ps.setString(9, pessoaFisica.getTelefone());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Método Deletar
	public String deletar(PessoaFisica pessoaFisica) {
		String sql = "delete from cliente where cpf = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);

			ps.setString(1, pessoaFisica.getCpf());

			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Método Selecionar
	public ArrayList<PessoaFisica> retornarDados() {
		String sql = "select * from cliente";
		ArrayList<PessoaFisica> retornarPessoaFisica = new ArrayList<PessoaFisica>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					PessoaFisica pessoaFisica = new PessoaFisica();
					pessoaFisica.setNome(rs.getString(2));
					pessoaFisica.setEmail(rs.getString(3));
					pessoaFisica.setCpf(rs.getString(5));
					pessoaFisica.setCep(rs.getString(8));
					pessoaFisica.setDdd(rs.getInt(9));
					pessoaFisica.setCelular(rs.getString(10));
					pessoaFisica.setTelefone(rs.getString(11));
					
					
					retornarPessoaFisica.add(pessoaFisica);
				}
				return retornarPessoaFisica;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}

	// Método Alterar
	public String alterar(PessoaFisica pessoaFisica) {
		String sql = "update cliente set senha = ? where cpf = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoaFisica.getSenha());
			ps.setString(2, pessoaFisica.getCpf());

			if (ps.executeUpdate() > 0) {
				return "Alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}