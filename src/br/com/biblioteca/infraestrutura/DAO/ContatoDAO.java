package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.biblioteca.dominio.entidade.Contato;
import br.com.biblioteca.dominio.entidade.Pessoa;
import br.com.biblioteca.factory.conexao.ConnectionFactoryDAO;

public class ContatoDAO {
	
	private GenericDAO<Contato> dao = new GenericDAO<>();
	
	public void save(Contato entity) throws Exception {
		dao.save(entity);
	}
	
	public void delete(Contato entity) throws Exception {
		dao.delete(entity);
	}
	
	public List<Contato> getAll() throws Exception {
		return dao.getAll(Contato.class);
	}
	
	public List<Contato> getByNameLike(String textoPesquisa) throws Exception {
		return dao.getByNameLike(Contato.class, textoPesquisa);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contato> getById(Class<Contato> classe, Integer idEntity) throws Exception{
		Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(classe)
				.add(Restrictions.eq("pessoa.idPessoa", idEntity));
		List<Contato> registros = criteria.list();
		session.close();
		return registros;		
	}
	
	public void save(Contato entity, int idEntity) throws Exception {
		dao.getEntityManager().getTransaction().begin();
		Pessoa p = (Pessoa) dao.getEntityManager().find(Pessoa.class, idEntity);
		entity.setPessoa(p);
		dao.getEntityManager().persist(entity);
		dao.getEntityManager().getTransaction().commit();
		dao.getEntityManager().close();
	}
		
}