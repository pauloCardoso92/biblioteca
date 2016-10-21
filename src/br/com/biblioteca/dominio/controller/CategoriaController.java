package br.com.biblioteca.dominio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.biblioteca.aplicacao.service.CategoriaService;
import br.com.biblioteca.dominio.entidade.Categoria;

@ManagedBean
@RequestScoped
public class CategoriaController implements InterfaceController<Categoria>{

	private Categoria categoria;
	private CategoriaService service = new CategoriaService();

	public CategoriaController() {
		factoryCategoria();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	private void factoryCategoria() {
		this.categoria = new Categoria();
	}

	@Override
	public boolean persist() throws Exception{
		if(service.persist(this.categoria)){
			factoryCategoria();
			return true;
		}return false;
	}

	@Override
	public boolean update() throws Exception{
		if(service.update(this.categoria)){
			factoryCategoria();
			return true;
		}return false;
	}

	@Override
	public boolean delete() throws Exception{
		if(service.delete(this.categoria)){
			factoryCategoria();
			return true;
		}return false;
	}

	@Override
	public List<Categoria> getAll() throws Exception{
		return service.getAll();
	}
	
}