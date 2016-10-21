package br.com.biblioteca.infraestrutura.DAO;

import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.dominio.entidade.Usuario;

public class UsuarioDAO {

	private GenericDAO<Usuario> dao = new GenericDAO<>();
	
	public void save(Usuario entity) throws Exception {
		dao.save(entity);
	}
	
	public void update(Usuario entity) throws Exception {
		dao.update(entity);
	}
	
	public void delete(Usuario entity) throws Exception {
		dao.delete(entity);
	}
	
	public List<Usuario> getAll() throws Exception {
		return dao.getAll(Usuario.class);
	}
	
	/**
	 * Metodo responsavel por buscar o Usuario por nome atraves da classe GenericDAO
	 *   
	 * @return	  Usuario caso seja encontrado
	 * @param     nome nome do usuario a ser pesquisado
	 * @exception Exception: Caso ocorra algum erro ao buscar os dados
	 * 
	 * @author	Paulo Cardoso
	 * @date	17/07/2014
	 */
	public Usuario getByName(String nome) throws Exception{
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>) dao.getByName(Usuario.class, nome, "login");
		for(Usuario usuario : usuarios){
			return usuario;
		}return null;
	}
	
}
