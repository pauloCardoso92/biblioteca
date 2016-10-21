package br.com.biblioteca.aplicacao.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.biblioteca.aplicacao.util.Mensagem;
import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Contato;
import br.com.biblioteca.dominio.entidade.Pessoa;
import br.com.biblioteca.infraestrutura.DAO.ContatoDAO;

public class ContatoService implements InterfaceService<Contato>{
	
	private ContatoDAO dao = new ContatoDAO();
	private List<Contato> contatos = new ArrayList<Contato>();
	private Mensagem mensagem = Mensagem.getInstance();
	private ValidaCampos validaCampos = ValidaCampos.getInstance();

	public boolean persist(Contato entity, Pessoa pessoa) {
		try{
			dao.save(entity, entity.getPessoa().getIdPessoa());
			this.contatos.add(entity);
			return true;
		} catch(Exception ex){
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean update(Contato entity) {
		return false;
	}
	
	public void addContatoLista(Contato contato){
		Contato c = new Contato(); 
		c.setTipoContato(contato.getTipoContato());
		c.setNumero(contato.getNumero());
		c.setEmail(contato.getEmail());
		this.contatos.add(c); // SE ADICIONAR O contato DIRETO, A REFERENCIA SERÁ A MESMA POIS O OBJETO ESTARA SENDO SOBRESCRITO, POR ISSO A CADA REQUISIÇÃO DO METODO SERA CRIADO UM NOVO OBJETO E ENTAO ADICIONAR
	}
	
	public void removeContatoLista(Contato contato){
		this.contatos.remove(contato);
	}

	@Override
	public boolean delete(Contato entity) {
		try{
			dao.delete(entity);
			this.contatos.remove(entity);
			return true;
		} catch(Exception ex){
			mensagem.exibeMensagemERRORRemoverDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public List<Contato> getAll() {
		return this.contatos;
	}
	
	public void persistAoCadastrar(String idMap) throws Exception {
		try{
			for(Contato c : this.contatos){
				if(c != null){
					Pessoa pessoa = (Pessoa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(idMap);
					dao.save(c, pessoa.getIdPessoa());
				}
			}
		}catch(Exception ex){
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}
	}
	
	public List<Contato> getByIdPessoa(int idPessoa) throws Exception{
		this.contatos = (ArrayList<Contato>) dao.getById(Contato.class, idPessoa);
		return this.contatos;
	}
	
	@SuppressWarnings("unused")
	private boolean validaCampos(Contato entity){
		if(!validaCampos.isCampoPreenchido(entity.getPessoa().getNome(),  entity.getPessoa().getCpfCnpj())){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}if(validaCampos.isCampoPreenchido(entity.getPessoa().getCpfCnpj()) && !validaCampos.isCPFValido(entity.getPessoa().getCpfCnpj())){
			mensagem.exibeMensagemERROR("CPF inválido!");
			return false;
		}return true;
	}
	
	public List<Contato> getByName(String textoPesquisa){
		try {
			return dao.getByNameLike(textoPesquisa);
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}

	@SuppressWarnings("unused")
	private List<Contato> buscaTodosBD(){
		try {
			return dao.getAll();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}

	@Override
	public boolean persist(Contato entity) {
		return false;
	}
	
}