package br.com.biblioteca.dominio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.biblioteca.aplicacao.service.ContatoService;
import br.com.biblioteca.dominio.entidade.Contato;
import br.com.biblioteca.dominio.entidade.Pessoa;

@ManagedBean
@ViewScoped
public class ContatoController implements InterfaceController<Contato>{

	private Contato contato;
	private Pessoa pessoa;
	private ContatoService service = new ContatoService();
	
	public ContatoController(){
		factoryContato();
		this.pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public void factoryContato(){
		this.contato = new Contato();
	}

	public void addContatoLista(){
		service.addContatoLista(this.contato);
	}
	
	public void removeContatoLista(){
		service.removeContatoLista(this.contato);
	}
	
	public boolean cadastrarContato(Contato contato){		
		return true;
	}
	
	@Override
	public List<Contato> getAll() throws Exception {
		return service.getAll();
	}
	
	@Override
	public boolean update() throws Exception {
		return false;
	}
	
	public void persistAoCadastrarCliente() throws Exception {
		persistAoCadastrar("pessoaCliente");
	}
	
	public void persistAoCadastrarColaborador() throws Exception {
		persistAoCadastrar("pessoaColaborador");
	}
	
	// METODO PERSISTE NO ATO DO CADASTRO DO CLIENTE
	private void persistAoCadastrar(String idMap) throws Exception {
		service.persistAoCadastrar(idMap);
	}
	
	public void pesquisaContatosPorIdPessoa() throws Exception{
		service.getByIdPessoa(this.contato.getPessoa().getIdPessoa());
	}

	@Override
	public boolean delete() throws Exception {
		if(service.delete(this.contato)){
			setPessoa(this.contato.getPessoa());
			factoryContato();
			this.contato.setPessoa(getPessoa());
			return true;
		}return false;
	}

	// METODO PERSISTE NA ALTERAÇÃO DO CLIENTE
	@Override
	public boolean persist() throws Exception {
		if(service.persist(this.contato, getPessoa())){
			setPessoa(this.contato.getPessoa()); 
			factoryContato();
			this.contato.setPessoa(pessoa);
			return true;
		}return false;
	}

}