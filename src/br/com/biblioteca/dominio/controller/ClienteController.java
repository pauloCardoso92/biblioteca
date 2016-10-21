package br.com.biblioteca.dominio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.biblioteca.aplicacao.service.ClienteService;
import br.com.biblioteca.dominio.entidade.Cliente;
import br.com.biblioteca.dominio.entidade.Pessoa;

@ManagedBean
@SessionScoped
public class ClienteController implements InterfaceController<Cliente>{
	
	private Cliente cliente;
	public ClienteService service = new ClienteService();
	
	public ClienteController(){
		factoryCliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void factoryCliente(){
		this.cliente = new Cliente();
		this.cliente.setPessoa(new Pessoa());
	}
	
	public boolean persist() throws Exception {
		if(service.persist(this.cliente)){
			factoryCliente();
			return true;
		}return false;
	}
	
	@Override
	public List<Cliente> getAll() throws Exception {
		return service.getAll();
	}
	
	@Override
	public boolean update() throws Exception {
		if(service.update(this.cliente)){
			factoryCliente();
			return true;
		}return false;
	}
	
	@Override
	public boolean delete() throws Exception {
		if(service.delete(this.cliente)){
			factoryCliente();
			return true;
		}return false;
	}
	
	public List<Cliente> pesquisarPorNome(){
		return service.getByNameLike(this.cliente.getPessoa().getNome());
	}
	
}