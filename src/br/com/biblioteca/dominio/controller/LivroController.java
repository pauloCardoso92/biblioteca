package br.com.biblioteca.dominio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.biblioteca.aplicacao.service.LivroService;
import br.com.biblioteca.dominio.entidade.Categoria;
import br.com.biblioteca.dominio.entidade.Editora;
import br.com.biblioteca.dominio.entidade.Livro;

@ManagedBean
@RequestScoped
public class LivroController implements InterfaceController<Livro>{

	private Livro livro;
	private LivroService service = new LivroService();


	public LivroController() {
		factoryLivro();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	private void factoryLivro() {
		this.livro = new Livro();
		this.livro.setEditora(new Editora());
		this.livro.setCategoria(new Categoria());
	}
	
	public List<Editora> getEditora(){
		return service.getEditora();
	}
	
	public List<Categoria> getCategoria(){
		return service.getCategoria();
	}
	
	@Override
	public boolean persist(){
		if(service.persist(this.livro)){
			factoryLivro();
			return true;
		}return false;
	}

	@Override
	public boolean update() {
		if(service.update(this.livro)){
			factoryLivro();
			return true;
		}return false;
	}

	@Override
	public boolean delete() {
		if(service.delete(this.livro)){
			factoryLivro();
			return true;
		}return false;
	}
	
	@Override
	public List<Livro> getAll() {
		return service.getAll();
	}

	public List<Livro> pesquisarPorNome(){
		return service.getByNameLike(this.livro.getNome());
	}
	
}