package br.com.biblioteca.relatorio.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Cliente;
import br.com.biblioteca.dominio.entidade.Pessoa;
import br.com.biblioteca.factory.relatorio.RelatorioClientes;
import br.com.biblioteca.factory.relatorio.RelatorioFactory;

@ManagedBean
@RequestScoped
public class RelatorioClienteController implements InterfaceParametros{

	private RelatorioFactory relatorioFactory = RelatorioFactory.getInstance();
	private String ordenacao;
	public Cliente cliente;

	public RelatorioClienteController(){
		if(cliente == null){
			cliente = new Cliente();
			cliente.setPessoa(new Pessoa());
			cliente.getPessoa().setSexo("");
		}if(ordenacao == null){
			ordenacao = new String();
		}
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getOrdenacao() {
		return ordenacao;
	}

	public void setOrdenacao(String ordenacao) {
		this.ordenacao = ordenacao;
	}

	public void gerarRelatorioPDF() throws IOException{
		relatorioFactory.gerarRelatorioPDF("relatorioCliente", gerarDadosRelatorio());
	}
	
	public void gerarRelatorioDOCX() throws IOException{
		relatorioFactory.gerarRelatorioDOCX("relatorioCliente", gerarDadosRelatorio());
	}
	
	public void gerarRelatorioXLS() throws IOException{
		relatorioFactory.gerarRelatorioXLS("relatorioCliente", gerarDadosRelatorio());
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private HashMap geraParametros(){
		ValidaCampos validaCampos = ValidaCampos.getInstance();
		HashMap parametros = new HashMap<>();
		if(cliente != null && cliente.getPessoa() != null){
			if(validaCampos.isCampoPreenchido(cliente.getPessoa().getNome())){
				parametros.put(NOME, cliente.getPessoa().getNome());
			}
			if(validaCampos.isCampoPreenchido(cliente.getPessoa().getSexo())){
				parametros.put(SEXO, cliente.getPessoa().getSexo());
			}
			if(validaCampos.isCampoPreenchido(cliente.getPessoa().getSituacao())){
				parametros.put(SITUACAO, cliente.getPessoa().getSituacao());
			}
			if(validaCampos.isCampoPreenchido(ordenacao)){
				parametros.put(ORDENACAO, ordenacao);
			}
		}return parametros;
	}
	
	private List<Cliente> gerarDadosRelatorio(){
		RelatorioClientes relatorioClientes = RelatorioClientes.getInstance();
		return relatorioClientes.getResultSet(geraParametros());
	}
	
}
