package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.biblioteca.factory.conexao.ConnectionFactoryDAO;

public class GenericDAO<T> implements interfaceDAO<T>{
	
	private EntityManager entityManager = ConnectionFactoryDAO.getEntityManager();
	private List<T> registros;
	
	@Override
	public void save(T entity) throws Exception {
		verificaEstadoEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@Override
	public void update(T entity) throws Exception {
		verificaEstadoEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@Override
	public void delete(T entity) throws Exception {
		verificaEstadoEntityManager();
		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.merge(entity)); 
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) throws Exception {
		Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(classe);
		this.registros = criteria.list();
		return registros;
	}
	
	@Override
	public Object getById(Class<T> classe, int idEntity) throws Exception{
		verificaEstadoEntityManager();
		return entityManager.find(classe, idEntity); 		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByName(Class<T> classe, String textoPesquisa, String coluna) throws Exception {
		Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(classe)
				.add(Restrictions.eq(coluna, textoPesquisa));
		this.registros = criteria.list();
		return registros;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getByNameLike(Class<T> classe, String textoPesquisa) throws Exception {
		Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(classe)
				.add(Restrictions.like("nome", textoPesquisa));
		this.registros = criteria.list();
		return registros;
	}

	private void verificaEstadoEntityManager() {
		if(!entityManager.isOpen()){
			this.entityManager = ConnectionFactoryDAO.getEntityManager();
		}
	}
	
	public EntityManager getEntityManager(){
		verificaEstadoEntityManager();
		return entityManager;
	}
	
}
