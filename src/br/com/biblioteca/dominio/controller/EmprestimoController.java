package br.com.biblioteca.dominio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;

import br.com.biblioteca.aplicacao.service.EmprestimoService;
import br.com.biblioteca.dominio.entidade.Emprestimo;
import br.com.biblioteca.dominio.entidade.Pessoa;

@ManagedBean
@ViewScoped
public class EmprestimoController {
	
	private Emprestimo emprestimo;
	private EmprestimoService service = new EmprestimoService();
	
	public EmprestimoController(){
		factoryEmprestimo();
	}
	
	public void factoryEmprestimo(){
		emprestimo = new Emprestimo();
		emprestimo.setPessoa(new Pessoa());
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public boolean persist() throws Exception {
		if(service.persist(this.emprestimo)){
			factoryEmprestimo();
			return true;
		}return false;
	}
	
	public List<Emprestimo> getAll() throws Exception {
		return service.getAll();
	}
	
	public boolean update() throws Exception {
		if(service.update(this.emprestimo)){
			factoryEmprestimo();
			return true;
		}return false;
	}
	
	public List<Pessoa> getPessoas(){
		return service.getPessoaClienteDependente(this.emprestimo.getPessoa().getNome());
	}
	
	public void atualizaFormularioAoPesquisar(){
		RequestContext.getCurrentInstance().update("clienteDependente");
		// METODO VAI ATUALIZAR O INPUTTEXT COM O NOME DA PESSOA NO FORMULARIO DE CADASTRO
	}
}