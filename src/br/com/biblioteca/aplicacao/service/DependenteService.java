package br.com.biblioteca.aplicacao.service;

import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.aplicacao.util.Mensagem;
import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Cliente;
import br.com.biblioteca.dominio.entidade.Dependente;
import br.com.biblioteca.infraestrutura.DAO.ClienteDAO;
import br.com.biblioteca.infraestrutura.DAO.DependenteDAO;

public class DependenteService implements InterfaceService<Dependente>{
	
	private DependenteDAO dependenteDAO = new DependenteDAO();
	private ValidaCampos validaCampos = ValidaCampos.getInstance();
	private List<Dependente> dependentes = new ArrayList<Dependente>();
	private Mensagem mensagem = Mensagem.getInstance();

	@Override
	public boolean persist(Dependente entity) {
		if(!validaCampos.isCampoPreenchido(entity.getPessoa().getNome(), entity.getCliente().getPessoa().getNome())){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}try {
			dependenteDAO.save(entity, entity.getCliente());
			this.dependentes.add(entity);
			mensagem.exibeMensagemINFOCadastroComSucesso();
			return true;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean update(Dependente entity) {
		if(!validaCampos.isCampoPreenchido(entity.getPessoa().getNome()) || entity.getCliente() == null){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}try {
			dependenteDAO.update(entity);
			this.dependentes.removeAll(this.dependentes);
			mensagem.exibeMensagemINFOAlteradoComSucesso();
			return true;
		}catch(Exception ex){
			mensagem.exibeMensagemERRORAlterarDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean delete(Dependente entity) {
		try {
			dependenteDAO.delete(entity);
			this.dependentes.remove(entity);
			mensagem.exibeMensagemINFOExcluidoComSucesso();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORRemoverDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public List<Dependente> getAll() {
		if(this.dependentes.isEmpty())
			this.dependentes = buscaTodosBD();
		return this.dependentes;
	}
	
	public List<Cliente> getByName(String textoPesquisa){
		try {
			ClienteDAO clienteDAO = new ClienteDAO();
			List<Cliente> clientes = clienteDAO.getClienteByName(textoPesquisa); 
			return clientes;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}

	private List<Dependente> buscaTodosBD(){
		try {
			return dependenteDAO.getAll();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}
	
}
