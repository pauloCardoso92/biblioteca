package br.com.biblioteca.aplicacao.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.biblioteca.aplicacao.util.Mensagem;
import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Cliente;
import br.com.biblioteca.factory.log.FactoryLog;
import br.com.biblioteca.infraestrutura.DAO.ClienteDAO;

public class ClienteService implements InterfaceService<Cliente>{
	
	private ClienteDAO dao = new ClienteDAO();
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private Mensagem mensagem = Mensagem.getInstance();
	private ValidaCampos validaCampos = ValidaCampos.getInstance();

	@Override
	public boolean persist(Cliente entity) {
		if(validaCampos(entity) == false){
			return false;
		}try{
			dao.save(entity); // PERSISTE O CLIENTE NO BD 
			FactoryLog.gerarLogInclusaoRegistro(entity.toString());
			this.clientes.add(entity);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoaCliente", entity.getPessoa());	// JOGA O CLIENTE NA SESSAO PARA QUE AS CLASSES QUE UTILIZAM POSSA CAPTURAR-LO
			mensagem.exibeMensagemINFOCadastroComSucesso();
			return true;
		}catch(Exception ex){
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean update(Cliente entity) {
		if(validaCampos(entity) == false){
			return false;
		}try {
			//FactoryLog.gerarLogAlteracaoRegistro(buscaClientePorId(entity.getIdCliente()), entity.toString());
			dao.update(entity);
			this.clientes.removeAll(this.clientes);
			mensagem.exibeMensagemINFOAlteradoComSucesso();
			return true;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORAlterarDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean delete(Cliente entity) {
		try{
			dao.delete(entity);
			this.clientes.remove(entity);
			mensagem.exibeMensagemINFOExcluidoComSucesso();
			return true;
		} catch(Exception ex){
			mensagem.exibeMensagemERRORRemoverDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public List<Cliente> getAll() {
		if(this.clientes.isEmpty())
			this.clientes = buscaTodosBD();
		return this.clientes;
	}
	
	private boolean validaCampos(Cliente entity){
		if(!validaCampos.isCampoPreenchido(entity.getPessoa().getNome(),  entity.getPessoa().getCpfCnpj())){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}if(validaCampos.isCampoPreenchido(entity.getPessoa().getCpfCnpj()) && !validaCampos.isCPFValido(entity.getPessoa().getCpfCnpj())){
			mensagem.exibeMensagemERROR("CPF inválido!");
			return false;
		}return true;
	}
	
	public List<Cliente> getByNameLike(String textoPesquisa){
		try {
			return dao.getByNameLike(textoPesquisa);
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}

	private List<Cliente> buscaTodosBD(){
		try {
			return dao.getAll();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}
	
	/**
	 * Metodo responsavel por buscar por id atravez da classe ClienteDAO
	 *   
	 * @return 	  Cliente
	 * @param 	  id id do Cliente
	 * 
	 * @author	Paulo Cardoso
	 * @date	18/07/2014
	 */
	public Cliente buscaClientePorId(Integer id) {
		try {
			return dao.buscaCliente(id);
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}
	
}
