package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.fiap.beans.PessoaJuridica;



public class PessoaJuridicaDAO {

	private Connection con;

	public final Connection getCon() {
		return con;
	}

	public final void setCon(Connection con) {
		this.con = con;
	}

	public PessoaJuridicaDAO(Connection con) {
		setCon(con);
	}

	// Método Inserir 
	public String inserir(PessoaJuridica pessoaJuridica) {
		String sql = "insert into pessoaJuridica( email, senha, cep, cnpj, razaoSocial, nomeFantasia) values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoaJuridica.getNomeFantasia());
			ps.setString(2, pessoaJuridica.getEmail());
			ps.setString(3, pessoaJuridica.getRazaoSocial());
			ps.setString(4, pessoaJuridica.getCnpj());
			ps.setString(5, pessoaJuridica.getSenha());
			//ps.setString(7, cliente.getTelefone());
			ps.setString(6, pessoaJuridica.getCep());
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

	public String deletar(PessoaJuridica pessoaJuridica) {
		String sql = "delete from pessoaJuridica where razao_social = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoaJuridica.getRazaoSocial());
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
	public ArrayList<PessoaJuridica> retornarDados() {
		String sql = "select * from pessoaJuridica";
		ArrayList<PessoaJuridica> retornarCliente = new ArrayList<PessoaJuridica>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					PessoaJuridica pessoaJuridica = new PessoaJuridica();
					pessoaJuridica.setRazaoSocial(rs.getString(2));
					pessoaJuridica.setCnpj(rs.getString(4));
					retornarCliente.add(pessoaJuridica);
				}
				return retornarCliente;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	// Método Alterar 
	public String alterar(PessoaJuridica pessoaJuridica) {
		String sql = "update pessoaJuridica set senha = ? where razao_social = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, pessoaJuridica.getSenha());
			ps.setString(2, pessoaJuridica.getRazaoSocial());
			
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