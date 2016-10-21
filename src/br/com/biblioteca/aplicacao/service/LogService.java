package br.com.biblioteca.aplicacao.service;

import br.com.biblioteca.dominio.entidade.Log;
import br.com.biblioteca.infraestrutura.DAO.LogDAO;

/**
 * Classe responsavel pelas chamadas a classe LogDAO para realizar
 * operacoes no Banco de Dados.
 * 
 * @author	Paulo Cardoso
 * @date	17/07/2014 
 */
public class LogService {
	
	private LogDAO dao = new LogDAO();
	
	/**
	 * Metodo responsavel por persistir o Log atravez da classe LogDAO
	 *   
	 * @return	  True caso seja persistido com sucesso
	 * @param     log Dados do Log a serem persistidos
	 * @exception Exception: Caso ocorra algum erro ao persistir o log
	 * 
	 * @author	Paulo Cardoso
	 * @date	17/07/2014
	 */
	public boolean persist(Log log){
		try {
			dao.save(log);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}return false;
	}

}
