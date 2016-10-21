package br.com.biblioteca.infraestrutura.DAO;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.biblioteca.dominio.entidade.Usuario;
import br.com.biblioteca.factory.conexao.ConnectionFactoryDAO;

public class ValidaAcessoDAO {

	public Usuario validaAcesso(String usuario, String senha){
		Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
		Criteria c = session.createCriteria(Usuario.class)
			.add(Restrictions.eq("login", usuario))
			.add(Restrictions.eq("senha", senha));
		return (Usuario)c.uniqueResult();
	}
	
}
