package br.com.biblioteca.aplicacao.testes;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.biblioteca.dominio.entidade.Colaborador;
import br.com.biblioteca.factory.conexao.ConnectionFactoryDAO;

public class TestFactoryQueryCriteria {
	
	private Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
	
	@SuppressWarnings("unchecked")
	public void buscaCriteriaTodos(){
		Criteria criteria = session.createCriteria(Colaborador.class);
		exibeDados(criteria.list());
	}
	
	@SuppressWarnings("unchecked")
	public void buscaCriteriaRestrictionsIsNotNull(){
		Criteria criteria = session.createCriteria(Colaborador.class)
				.add(Restrictions.isNotNull("foto"));
		exibeDados(criteria.list());
	}
	
	@SuppressWarnings("unchecked")
	public void buscaCriteriaRestrictionsEquals(){
		Criteria criteria = session.createCriteria(Colaborador.class)
				.add(Restrictions.eq("salario", 3000.00));
		exibeDados(criteria.list());
	}
	
	@SuppressWarnings("unchecked")
	public void buscaCriteriaRestrictionsLike(){ // VERIFICAR JOIN
		Criteria criteria = session.createCriteria(Colaborador.class)
				.add(Restrictions.like("nome", "a"));
		exibeDados(criteria.list());
	}
	
	@SuppressWarnings("unchecked")
	public void buscaCriteriaRestrictionsBetwheenLimit(int valor){
		Criteria criteria = session.createCriteria(Colaborador.class)
				.add(Restrictions.between("salario", 3000.00, 5000.00))
				.setMaxResults(5);
		if(valor == 1){
			criteria.createAlias("pessoa", "p");
			criteria.add(Restrictions.like("p.nome", "paulo"));
		}
		exibeDados(criteria.list());
	}
	
	public void buscaCriteriaProjectionMin(){
		Criteria criteria = session.createCriteria(Colaborador.class)
				.setProjection(Projections.min("salario"));
		System.out.println("\n\nMenor Salario = R$"+criteria.uniqueResult());
	}
	
	public void buscaCriteriaProjectionMedia(){
		Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
		Criteria criteria = session.createCriteria(Colaborador.class)
				.setProjection(Projections.avg("salario"));
		System.out.println("\n\nMédia Salarios = R$"+criteria.uniqueResult());
	}
	
	public void exibeDados(List<Colaborador> colaboradores){
		System.out.println("\n\n");
		if(!colaboradores.isEmpty()){
			for(Colaborador d : colaboradores){
				System.out.println(d.toString());
			}
		}else
			System.out.println("Lista Vazia!!!");
	}
	
}