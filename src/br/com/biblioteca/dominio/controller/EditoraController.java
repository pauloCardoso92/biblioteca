package br.com.biblioteca.dominio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.biblioteca.aplicacao.service.EditoraService;
import br.com.biblioteca.dominio.entidade.Editora;

@ManagedBean
@RequestScoped
public class EditoraController implements InterfaceController<Editora>{

	private Editora editora;
	private EditoraService service = new EditoraService();

	public EditoraController() {
		factoryEditora();
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	private void factoryEditora() {
		this.editora = new Editora();
	}
	
	@Override
	public boolean persist(){
		if(service.persist(this.editora)){
			factoryEditora();
			return true;
		}return false;
	}

	@Override
	public boolean update() {
		if(service.update(this.editora)){
			factoryEditora();
			return true;
		}return false;
	}

	@Override
	public boolean delete() {
		if(service.delete(this.editora)){
			factoryEditora();
			return true;
		}return false;
	}
	
	@Override
	public List<Editora> getAll() {
		return service.getAll();
	}
	
}