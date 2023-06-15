package br.com.fiap.teste;

import java.sql.Connection;
import br.com.fiap.beans.PessoaFisica;
import br.com.fiap.bo.PessoaFisicaBO;
import br.com.fiap.bo.Excecao;
import br.com.fiap.conexao.Conexao;

public class PessoaFisicaInserirBO {

	public static void main(String[] args) throws Excecao {

			Connection con = Conexao.abrirConexao();

			PessoaFisica pessoaFisica = new PessoaFisica();
			
			PessoaFisicaBO pessoaFisicabo = new PessoaFisicaBO();

			// Testando o método inserir
			
			pessoaFisica.setNome("Matheus Leite Oliveira Scalfo");
			pessoaFisica.setEmail("matheus.l.oliveira28@hotmail.com");
			pessoaFisica.setSenha("!amogatinhos24!");
			pessoaFisica.setCpf("47553265837");
			pessoaFisica.setDataNasc("28/01/2000");
			pessoaFisica.setCep("04904904");
			pessoaFisica.setDdd(11);
			pessoaFisica.setCelular("958280400");
			pessoaFisica.setTelefone("");
			
			pessoaFisicabo.inserirBO(pessoaFisica);

			
			Conexao.fecharConexao(con);
		}

	}

