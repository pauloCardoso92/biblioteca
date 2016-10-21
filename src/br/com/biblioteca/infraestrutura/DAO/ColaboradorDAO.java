package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

import br.com.biblioteca.dominio.entidade.Colaborador;

public class ColaboradorDAO {
	
	private GenericDAO<Colaborador> dao = new GenericDAO<>();
	
	public void save(Colaborador entity) throws Exception {
		dao.save(entity);
	}
	
	public void update(Colaborador entity) throws Exception {
		dao.update(entity);
	}
	
	public void delete(Colaborador entity) throws Exception {
		dao.delete(entity);
	}
	
	public List<Colaborador> getByNameLike(String textoPesquisa) throws Exception {
		return dao.getByNameLike(Colaborador.class, textoPesquisa);
	}
	
	public List<Colaborador> getAll() throws Exception {
		return dao.getAll(Colaborador.class);
	}


}
