package br.com.fiap.teste;

import java.sql.Connection;
import br.com.fiap.beans.PessoaFisica;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaFisicaDAO;

public class PessoaFisicaAlterar {
	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();

		PessoaFisica pessoaFisica = new PessoaFisica();
		PessoaFisicaDAO pessoaFisicadao = new PessoaFisicaDAO(con);

		// Testando o método alterar
		pessoaFisica.setSenha("olar");
		pessoaFisica.setCpf("1234567897");
		
		System.out.println(pessoaFisicadao.alterar(pessoaFisica));

		Conexao.fecharConexao(con);
	}
}