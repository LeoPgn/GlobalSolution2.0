package br.com.fiap.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.fiap.beans.PessoaJuridica;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.dao.PessoaJuridicaDAO;



public class PessoaJuridicaSelecionar {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();

		PessoaJuridicaDAO pessoaJuridicadao = new PessoaJuridicaDAO(con);

		// Listar
		ArrayList<PessoaJuridica> lista = pessoaJuridicadao.retornarDados();

		if (lista != null) {
			for (PessoaJuridica pj : lista) {
				System.out.println("Nome: " + pj.getNomeFantasia());
				System.out.println("Cpf: " + pj.getCnpj() + "\n");
			}
		}

		Conexao.fecharConexao(con);

	}

}
