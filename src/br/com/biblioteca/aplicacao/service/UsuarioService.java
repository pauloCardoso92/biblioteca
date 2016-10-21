package br.com.biblioteca.aplicacao.service;

import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.aplicacao.util.Mensagem;
import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Usuario;
import br.com.biblioteca.infraestrutura.DAO.UsuarioDAO;

public class UsuarioService implements InterfaceService<Usuario>{
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private ValidaCampos validaCampos = ValidaCampos.getInstance();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private Mensagem mensagem = Mensagem.getInstance();

	@Override
	public boolean persist(Usuario entity) {
		if(!validaCampos.isCampoPreenchido(entity.getLogin(), entity.getSenha())){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}try {
			usuarioDAO.save(entity);
			this.usuarios.add(entity);
			mensagem.exibeMensagemINFOCadastroComSucesso();
			return true;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean update(Usuario entity) {
		if(!validaCampos.isCampoPreenchido(entity.getLogin(), entity.getSenha())){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}try {
			usuarioDAO.update(entity);
			this.usuarios.removeAll(this.usuarios);
			mensagem.exibeMensagemINFOAlteradoComSucesso();
			return true;
		}catch(Exception ex){
			mensagem.exibeMensagemERRORAlterarDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean delete(Usuario entity) {
		try {
			usuarioDAO.delete(entity);
			this.usuarios.remove(entity);
			mensagem.exibeMensagemINFOExcluidoComSucesso();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORRemoverDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public List<Usuario> getAll() {
		if(this.usuarios.isEmpty())
			this.usuarios = buscaTodosBD();
		return this.usuarios;
	}
	
	private List<Usuario> buscaTodosBD(){
		try {
			return usuarioDAO.getAll();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}
	
	/**
	 * Metodo responsavel por buscar o Usuario por nome atraves da classe UsuarioDAO
	 *   
	 * @return	  Usuario caso seja encontrado
	 * @param     nome nome do usuario a ser pesquisado
	 * @exception Exception: Caso ocorra algum erro ao buscar os dados
	 * 
	 * @author	Paulo Cardoso
	 * @date	17/07/2014
	 */
	public Usuario getByName(String nome) {
		try {
			return (Usuario) usuarioDAO.getByName(nome);
		} catch (Exception ex) {
			ex.printStackTrace();
		}return null;
	}

}
