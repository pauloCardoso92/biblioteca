package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.biblioteca.dominio.entidade.Endereco;
import br.com.biblioteca.dominio.entidade.Pessoa;
import br.com.biblioteca.factory.conexao.ConnectionFactoryDAO;

public class EnderecoDAO {
	
private GenericDAO<Endereco> dao = new GenericDAO<>();
	
	public void save(Endereco entity) throws Exception {
		dao.save(entity);
	}
	
	public void delete(Endereco entity) throws Exception {
		dao.delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Endereco> getById(Class<Endereco> classe, Integer idEntity) throws Exception{
		Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(classe)
				.add(Restrictions.eq("pessoa.idPessoa", idEntity));
		List<Endereco> registros = criteria.list();
		session.close();
		return registros;
	}
	
	public void save(Endereco entity, int idEntity) throws Exception {
		dao.getEntityManager().getTransaction().begin();
		Pessoa p = (Pessoa) dao.getEntityManager().find(Pessoa.class, idEntity);
		entity.setPessoa(p);
		dao.getEntityManager().persist(entity);
		dao.getEntityManager().getTransaction().commit();
		dao.getEntityManager().close();
	}

}
