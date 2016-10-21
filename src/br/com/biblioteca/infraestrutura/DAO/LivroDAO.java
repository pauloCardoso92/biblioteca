package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

import br.com.biblioteca.dominio.entidade.Livro;

public class LivroDAO {

	private GenericDAO<Livro> dao = new GenericDAO<>();
	
	public void save(Livro entity) throws Exception {
		dao.save(entity);
	}
	
	public void update(Livro entity) throws Exception {
		dao.update(entity);
	}
	
	public void delete(Livro entity) throws Exception {
		dao.delete(entity);
	}
	
	public List<Livro> getAll() throws Exception {
		return dao.getAll(Livro.class);
	}
	
	public List<Livro> getByNameLike(String textoPesquisa) throws Exception {
		return dao.getByNameLike(Livro.class, textoPesquisa);
	}
	
}
