package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

import br.com.biblioteca.dominio.entidade.Editora;

public class EditoraDAO {

private GenericDAO<Editora> dao = new GenericDAO<>();
	
	public void save(Editora entity) throws Exception {
		dao.save(entity);
	}
	
	public void update(Editora entity) throws Exception {
		dao.update(entity);
	}
	
	public void delete(Editora entity) throws Exception {
		dao.delete(entity);
	}
	
	public List<Editora> getAll() throws Exception {
		return dao.getAll(Editora.class);
	}
	
}
