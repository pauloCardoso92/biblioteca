package br.com.biblioteca.aplicacao.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.biblioteca.aplicacao.validacoes.ValidaAcesso;
import br.com.biblioteca.dominio.entidade.Usuario;
import br.com.biblioteca.infraestrutura.DAO.ValidaAcessoDAO;

public class JUnitTestLogin {
	
	private ValidaAcessoDAO acessoDAO;
	private ValidaAcesso acesso;
	private Usuario usuario;
	
	@Before
	public void inicializa(){
		this.acessoDAO = new ValidaAcessoDAO();
		this.usuario = new Usuario();
		this.acesso = new ValidaAcesso();
	}

	@Test
	public void retornaUsuarioBanco(){
		this.usuario = acessoDAO.validaAcesso("admin", acesso.geraMd5("admin"));
		Assert.assertNotNull(usuario);
		System.out.println(usuario.toString());
	}

	@Test
	public void retornaAcessoTrue(){
		boolean resultado = acesso.validaLoginSenha("admin", acesso.geraMd5("admin"));
		Assert.assertEquals(true, resultado);
	}

	@Test
	public void retornaAcessoFalse(){
		boolean resultado = acesso.validaLoginSenha("admi", acesso.geraMd5("admin"));
		Assert.assertEquals(false, resultado);
	}
	
	@Test
	public void retornaAcessoFalse02(){
		boolean resultado = acesso.validaLoginSenha("ADMIN", acesso.geraMd5("admin"));
		Assert.assertEquals(false, resultado);
	}
	
}