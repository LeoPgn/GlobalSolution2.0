package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.PessoaJuridica;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaJuridicaDAO;

public class PessoaJuridicaDeletar {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();

		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		PessoaJuridicaDAO pessoaJuridicadao = new PessoaJuridicaDAO(con);

		// Testando o método deletar
		pessoaJuridica.setRazaoSocial("Regina");
		System.out.println(pessoaJuridicadao.deletar(pessoaJuridica));

		Conexao.fecharConexao(con);

	}

}
