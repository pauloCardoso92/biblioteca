package br.com.biblioteca.infraestrutura.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.biblioteca.dominio.entidade.Emprestimo;
import br.com.biblioteca.dominio.entidade.Pessoa;

public class EmprestimoDAO {
	
	private GenericDAO<Emprestimo> dao = new GenericDAO<>();
	
	public void save(Emprestimo entity) throws Exception {
		dao.save(entity);
	}
	
	public void update(Emprestimo entity) throws Exception {
		dao.update(entity);
	}
	
	public void delete(Emprestimo entity) throws Exception {
		dao.delete(entity);
	}
	
	public List<Emprestimo> getAll() throws Exception {
		return dao.getAll(Emprestimo.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> buscarClienteDependentePorNome(String nome){
		Session session = (Session) dao.getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(Pessoa.class)
				.add(Restrictions.like("nome", "%"+nome+"%"));
		List<Pessoa> pessoas = criteria.list();
		for(Pessoa p : pessoas){
			System.out.println(p.toString());
			System.out.println();
		}
		return criteria.list();
		// SQL NATIVE
		/*Session session = (Session) dao.getEntityManager().getDelegate();
		String sql = "SELECT " +
				"p.id_pessoa," +
				"p.nome," +
				"c.id_cliente," +
				"d.id_dependente " +
			" FROM " +
				" pessoa p" +
				" LEFT JOIN cliente c ON(c.id_pessoa = p.id_pessoa)" +
				" LEFT JOIN dependente d ON(d.id_pessoa = p.id_pessoa)" +
			" WHERE" +
				" c.id_pessoa IS NOT NULL " +
				" OR d.id_pessoa IS NOT NULL "+
				" AND p.nome LIKE :n";
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(sql).setParameter("n", nome);
		ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) sqlQuery.list();
		return pessoas;*/
	}

}
