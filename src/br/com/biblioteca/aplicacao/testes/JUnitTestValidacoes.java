package br.com.biblioteca.aplicacao.testes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Cliente;
import br.com.biblioteca.dominio.entidade.Pessoa;

public class JUnitTestValidacoes {

	private ValidaCampos validaCampos;
	private Cliente cliente;

	@Before
	public void inicializa() {
		this.validaCampos = ValidaCampos.getInstance();
		this.cliente = new Cliente();
		this.cliente.setPessoa(new Pessoa());
	}

	@Test
	public void testCampoPreenchido(){
		assertEquals(false, validaCampos.isCampoPreenchido(this.cliente.getPessoa().getNome(), cliente.getPessoa().getSexo()));
	}
	
	@Test
	public void testCampoPreenchidoComEspaco(){
		this.cliente.getPessoa().setNome("    ");
		assertEquals(false, validaCampos.isCampoPreenchido(this.cliente.getPessoa().getNome()));
	}
	
	@Test
	public void testDataPreenchida(){
		assertEquals(false, this.validaCampos.isDataPreenchida(cliente.getPessoa().getDataNascimento()));
	}
	
/*	@Test
	public void testValidaPrimeiroDigitoCPF(){
		assertEquals(0, validaCampos.calcularDigitoCPF("037.000.001-00", 9, 10));
	}
	
	@Test
	public void testValidaSegundoDigitoCPF(){
		assertEquals(0, validaCampos.calcularDigitoCPF("037.000.001-00", 10, 11));
	}*/
	
	@Test
	public void testValidaCPF(){
		assertEquals(false, validaCampos.isCPFValido("037.000.001-00"));
	}
	
	@Test
	public void testValidaCPF02(){
		assertEquals(true, validaCampos.isCPFValido("630.165.746-24"));
	}
	
}