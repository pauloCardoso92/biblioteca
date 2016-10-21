package br.com.biblioteca.dominio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.biblioteca.aplicacao.util.Mensagem;
import br.com.biblioteca.dominio.entidade.Endereco;
import br.com.biblioteca.dominio.entidade.Pessoa;
import br.com.biblioteca.infraestrutura.DAO.EnderecoDAO;

@ManagedBean
@ViewScoped
public class EnderecoController implements InterfaceController<Endereco>{

	private Endereco endereco;
	private Pessoa pessoa;
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	private ArrayList<Endereco> enderecos;
	private Mensagem mensagem = Mensagem.getInstance();
	
	public EnderecoController(){
		factoryEndereco();
		if(this.enderecos == null){
			this.enderecos = new ArrayList<Endereco>();
		}
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public void factoryEndereco(){
		this.endereco = new Endereco();
	}
	
	public void addEnderecoLista(){
		Endereco endereco = new Endereco();
		endereco.setBairro(this.endereco.getBairro());
		endereco.setCep(this.endereco.getCep());
		endereco.setCidade(this.endereco.getCidade());
		endereco.setComplemento(this.endereco.getComplemento());
		endereco.setEndereco(this.endereco.getEndereco());
		endereco.setLogradouro(this.endereco.getLogradouro());
		endereco.setMunicipio(this.endereco.getMunicipio());
		endereco.setNumero(this.endereco.getNumero());
		endereco.setTipoEndereco(this.endereco.getTipoEndereco());
		endereco.setUf(this.endereco.getUf());
		this.enderecos.add(endereco);
	}
	
	public void removeEnderecoLista(){
		this.enderecos.remove(endereco);
	}
	
	@Override
	public List<Endereco> getAll() throws Exception {
		return this.enderecos;
	}

	public void persistAoCadastrarCliente() throws Exception {
		persistAoCadastrar("pessoaCliente");
	}
	
	public void persistAoCadastrarColaborador() throws Exception {
		persistAoCadastrar("pessoaColaborador");
	}
	
	private void persistAoCadastrar(String idMap) throws Exception {
		try{
			for(Endereco e : this.enderecos){
				if(e != null){
					Pessoa pessoa = (Pessoa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(idMap);
					enderecoDAO.save(e, pessoa.getIdPessoa());
				}
			}
		} catch(Exception ex){
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public boolean persist() throws Exception {
		try{
			enderecoDAO.save(this.endereco, this.endereco.getPessoa().getIdPessoa());
			this.enderecos.add(endereco);
			setPessoa(this.endereco.getPessoa()); 
			factoryEndereco();
			this.endereco.setPessoa(getPessoa());
			return true;
		} catch(Exception ex){
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}return false;
	}
	
	@Override
	public boolean update() throws Exception {
		return false;
	}

	@Override
	public boolean delete() throws Exception {
		try{
			enderecoDAO.delete(this.endereco);
			this.enderecos.remove(this.endereco);
			setPessoa(this.endereco.getPessoa());
			factoryEndereco();
			this.endereco.setPessoa(getPessoa());
			return true;
		} catch(Exception ex){
			mensagem.exibeMensagemERRORRemoverDados(ex);
			ex.printStackTrace();
		}return false;
	}
	
	public void pesquisaEnderecosPorIdPessoa() throws Exception{
		this.enderecos = ((ArrayList<Endereco>) enderecoDAO.getById(Endereco.class, this.endereco.getPessoa().getIdPessoa()));
	}
}
