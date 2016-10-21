package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.biblioteca.dominio.entidade.Cliente;
import br.com.biblioteca.factory.conexao.ConnectionFactoryDAO;

public class ClienteDAO {
	
	private GenericDAO<Cliente> dao = new GenericDAO<Cliente>();
	
	public void save(Cliente entity) throws Exception {
		dao.save(entity);
	}

	public void update(Cliente entity) throws Exception {
		dao.update(entity);
	}
	
	public void delete(Cliente entity) throws Exception {
		dao.delete(entity);
	}
	
	public List<Cliente> getAll() throws Exception {
		return dao.getAll(Cliente.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getClienteByName(String textoPesquisa) throws Exception {
		Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(Cliente.class)
				.createAlias("pessoa", "p")
				.add(Restrictions.like("p.nome", "%"+textoPesquisa+"%"));
		List<Cliente> clientes = criteria.list();
		
		return clientes;
	}

	public List<Cliente> getByNameLike(String textoPesquisa) throws Exception{
		return dao.getByNameLike(Cliente.class, textoPesquisa);
	}
	
	/**
	 * Metodo responsavel por buscar por id atraves da classe GenericDAO
	 * Tabelas: categoria
	 *   
	 * @return	  Cliente
	 * @param     id id do Cliente
	 * @exception Exception: Caso ocorra algum erro ao buscar o Cliente
	 * 
	 * @author	Paulo Cardoso
	 * @date	18/07/2014
	 */
	public Cliente buscaCliente(Integer id) throws Exception{
		return (Cliente) dao.getById(Cliente.class, id);
	}
	
}