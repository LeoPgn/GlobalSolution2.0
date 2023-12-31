package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.PessoaJuridica;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaJuridicaDAO;

public class PessoaJuridicaAlterar {
	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();

		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		PessoaJuridicaDAO pessoaJuridicadao = new PessoaJuridicaDAO(con);

		// Testando o m�todo alterar
		pessoaJuridica.setSenha("teste1234");
		pessoaJuridica.setRazaoSocial("camila");
		System.out.println(pessoaJuridicadao.alterar(pessoaJuridica));

		Conexao.fecharConexao(con);
	}
}
