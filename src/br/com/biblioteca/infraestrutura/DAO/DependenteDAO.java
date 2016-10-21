package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

import br.com.biblioteca.dominio.entidade.Cliente;
import br.com.biblioteca.dominio.entidade.Dependente;

public class DependenteDAO {
	
	private GenericDAO<Dependente> dao = new GenericDAO<>();

	public void update(Dependente entity) throws Exception {
		dao.update(entity);
	}
	
	public void delete(Dependente entity) throws Exception {
		dao.delete(entity);
	}
	
	public List<Dependente> getAll() throws Exception {
		return dao.getAll(Dependente.class);
	}
	
	public void save(Dependente entity, Cliente cliente) throws Exception { // TRAZER O CLIENTE PARA O CONTEXTO DE PERSISTENCIA
		dao.getEntityManager().getTransaction().begin();
		Cliente c = dao.getEntityManager().find(Cliente.class, cliente.getIdCliente());
		entity.setCliente(c);
		dao.getEntityManager().persist(entity);
		dao.getEntityManager().getTransaction().commit();
	}

}
