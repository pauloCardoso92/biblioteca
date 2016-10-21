package br.com.biblioteca.infraestrutura.DAO;

import br.com.biblioteca.dominio.entidade.Log;

/**
 * Classe responsavel pelas chamadas a classe GenericDAO para realizar
 * operacoes no Banco de Dados.
 * 
 * @author	Paulo Cardoso
 * @date	17/07/2014 
 */
public class LogDAO {
	
	private GenericDAO<Log> dao = new GenericDAO<>();
	
	/**
	 * Metodo responsavel por persistir o Log atravez da classe GenericDAO
	 *
	 * @param     log Dados do Log a serem persistidos
	 * @exception Exception: Caso ocorra algum erro ao persistir o log
	 * 
	 * @author	Paulo Cardoso
	 * @date	17/07/2014
	 */
	public void save(Log log) throws Exception{
		dao.save(log);
	}

}
