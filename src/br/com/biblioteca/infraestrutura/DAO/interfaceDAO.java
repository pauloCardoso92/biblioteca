package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

public interface interfaceDAO<T> {

	public abstract void save(T entity) throws Exception;
	
	public abstract List<T> getAll(Class<T> classe) throws Exception;

	public abstract List<T> getByName(Class<T> classe, String textoPesquisa, String coluna) throws Exception;
	
	public abstract List<T> getByNameLike(Class<T> classe, String textoPesquisa) throws Exception;
	
	public abstract Object getById(Class<T> classe, int idEntity) throws Exception;
	
	public abstract void update(T entity) throws Exception;
	
	public abstract void delete(T entity) throws Exception;
	
}