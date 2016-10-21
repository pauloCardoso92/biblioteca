package br.com.biblioteca.factory.conexao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class ConnectionFactoryDAO {

	private static EntityManagerFactory emf;

	private static void createEntityManager(){
		if(ConnectionFactoryDAO.emf == null){
			ConnectionFactoryDAO.emf = Persistence.createEntityManagerFactory("biblioteca");
		}
	}
	
	public static EntityManager getEntityManager(){
		createEntityManager();
		return ConnectionFactoryDAO.emf.createEntityManager();
	}
	
}