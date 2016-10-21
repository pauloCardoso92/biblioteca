package br.com.biblioteca.aplicacao.service;

import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.aplicacao.util.Mensagem;
import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Editora;
import br.com.biblioteca.infraestrutura.DAO.EditoraDAO;

public class EditoraService implements InterfaceService<Editora>{
	
	private EditoraDAO editoraDAO = new EditoraDAO();
	private ValidaCampos validaCampos = ValidaCampos.getInstance();
	private List<Editora> editoras = new ArrayList<Editora>();
	private Mensagem mensagem = Mensagem.getInstance();

	@Override
	public boolean persist(Editora entity) {
		if(!validaCampos.isCampoPreenchido(entity.getNome())){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}try {
			editoraDAO.save(entity);
			this.editoras.add(entity);
			mensagem.exibeMensagemINFOCadastroComSucesso();
			return true;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean update(Editora entity) {
		if(!validaCampos.isCampoPreenchido(entity.getNome())){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}try {
			editoraDAO.update(entity);
			this.editoras.removeAll(this.editoras);
			mensagem.exibeMensagemINFOAlteradoComSucesso();
			return true;
		}catch(Exception ex){
			mensagem.exibeMensagemERRORAlterarDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean delete(Editora entity) {
		try {
			editoraDAO.delete(entity);
			this.editoras.remove(entity);
			mensagem.exibeMensagemINFOExcluidoComSucesso();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORRemoverDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public List<Editora> getAll() {
		if(this.editoras.isEmpty())
			this.editoras = buscaTodosBD();
		return this.editoras;
	}
	
	private List<Editora> buscaTodosBD(){
		try {
			return editoraDAO.getAll();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}

}
