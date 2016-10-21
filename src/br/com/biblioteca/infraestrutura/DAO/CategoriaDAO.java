package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

import br.com.biblioteca.dominio.entidade.Categoria;

public class CategoriaDAO {

	private GenericDAO<Categoria> dao = new GenericDAO<>();
	
	public void save(Categoria entity) throws Exception {
		dao.save(entity);
	}
	
	public void update(Categoria entity) throws Exception {
		dao.update(entity);
	}
	
	public void delete(Categoria entity) throws Exception {
		dao.delete(entity);
	}
	
	public List<Categoria> getAll() throws Exception {
		return dao.getAll(Categoria.class);
	}
	
	/**
	 * Metodo responsavel por buscar por id atraves da classe GenericDAO
	 * Tabelas: categoria
	 *   
	 * @return	  Categoria
	 * @param     id id da categoria
	 * @exception Exception: Caso ocorra algum erro ao buscar a categoria
	 * 
	 * @author	Paulo Cardoso
	 * @date	17/07/2014
	 */
	public Categoria buscaCategoria(Integer id) throws Exception{
		return (Categoria) dao.getById(Categoria.class, id);
	}
	
}