package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.beans.PessoaJuridica;
import br.com.fiap.bo.Excecao;
import br.com.fiap.bo.PessoaJuridicaBO;
import br.com.fiap.conexao.Conexao;

public class PessoaJuridicaInserirBO {

	public static void main(String[] args) throws Excecao {
		
		Connection con = Conexao.abrirConexao();

		PessoaJuridica pessoaJuridica = new PessoaJuridica();

		PessoaJuridicaBO pessoaJuridicabo = new PessoaJuridicaBO();

		// Testando o método inserir
		pessoaJuridica.setNomeFantasia("stella");
		pessoaJuridica.setEmail("jhonn@gmail");
		pessoaJuridica.setSenha("lalalala");
		pessoaJuridica.setRazaoSocial("12345678970");
		pessoaJuridica.setCnpj("12345678910234");
		pessoaJuridica.setCep("02535001");
		
		pessoaJuridicabo.inserirBO(pessoaJuridica);

		Conexao.fecharConexao(con);
	}
}