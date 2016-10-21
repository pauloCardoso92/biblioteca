package br.com.biblioteca.factory.relatorio;

import org.hibernate.Session;

import br.com.biblioteca.factory.conexao.ConnectionFactoryDAO;

public class GenericRelatorioFactory {
	
	private Session session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
	private static GenericRelatorioFactory genericRelatorioFactory;
	
	private GenericRelatorioFactory(){
	}
	
	public static GenericRelatorioFactory getInstance(){
		if(genericRelatorioFactory == null){
			genericRelatorioFactory = new GenericRelatorioFactory();
		}return genericRelatorioFactory;
	}
	
	private void verificaEstadoSession() {
		if(!session.isOpen()){
			session = (Session) ConnectionFactoryDAO.getEntityManager().getDelegate();
		}
	}
	
	public void closeSession(){
		if(session.isOpen())
			session.flush();
	}
	
	public Session getSession(){
		verificaEstadoSession();
		return session;
	}
	
}
