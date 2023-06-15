package br.com.fiap.teste;

import java.sql.Connection;
import br.com.fiap.conexao.Conexao;
import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.PessoaJuridicaDAO;

public class ClienteInserir {

	public static void main(String[] args) {
		
		Connection con = Conexao.abrirConexao();
		
		Cliente cliente = new Cliente();
		PessoaJuridicaDAO clientedao = new PessoaJuridicaDAO(con);
		
		cliente.setNome("Matheus Leite Oliveira Scalfo");
		cliente.setEmail("matheus.l.oliveira28@hotmail.com");
		cliente.setSenha("!Milk28*");
		cliente.setCpf("475532658");
		cliente.setCnpj("0");
		cliente.setDataNascimento("28/01/2000");
		cliente.setTelefone("1195828040");
		cliente.setCep("04904904");
		
		System.out.println(clientedao.inserir(cliente));
		
		Conexao.fecharConexao(con);
	}
}