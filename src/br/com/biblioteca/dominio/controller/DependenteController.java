package br.com.biblioteca.dominio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.biblioteca.aplicacao.service.DependenteService;
import br.com.biblioteca.dominio.entidade.Cliente;
import br.com.biblioteca.dominio.entidade.Dependente;
import br.com.biblioteca.dominio.entidade.Pessoa;

@ManagedBean
@ViewScoped
public class DependenteController implements InterfaceController<Dependente>{

	private Dependente dependente;
	private DependenteService service = new DependenteService();

	public DependenteController() {
		factoryDependente();
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}
	
	public void atualizaFormularioAoPesquisarCliente(){  
		RequestContext.getCurrentInstance().update("cliente");
		// METODO VAI ATUALIZAR O INPUTTEXT COM O NOME DO CLIENTE NOS FORMULARIOS DE CADASTRAR E ALTERAR
	}
	
	public void factoryDependente(){
		Cliente c = new Cliente();
		this.dependente = new Dependente();
		this.dependente.setCliente(c);
		this.dependente.setPessoa(new Pessoa());
		c.setPessoa(new Pessoa());
	}

	@Override
	public boolean persist(){
		if(service.persist(this.dependente)){
			factoryDependente();
			return true;
		}return false;
	}

	@Override
	public boolean update() {
		if(service.update(this.dependente)){
			factoryDependente();
			return true;
		}return false;
	}

	@Override
	public boolean delete() {
		if(service.delete(this.dependente)){
			factoryDependente();
			return true;
		}return false;
	}

	@Override
	public List<Dependente> getAll() {
		return service.getAll();
	}
	
	public List<Cliente> pesquisarPorNome(){
		return service.getByName(this.dependente.getCliente().getPessoa().getNome());
	}
	
}