package br.com.biblioteca.aplicacao.service;

import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.aplicacao.util.Mensagem;
import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Categoria;
import br.com.biblioteca.dominio.entidade.Editora;
import br.com.biblioteca.dominio.entidade.Livro;
import br.com.biblioteca.infraestrutura.DAO.CategoriaDAO;
import br.com.biblioteca.infraestrutura.DAO.EditoraDAO;
import br.com.biblioteca.infraestrutura.DAO.LivroDAO;

public class LivroService implements InterfaceService<Livro>{
	
	private LivroDAO livroDAO = new LivroDAO();
	private ValidaCampos validaCampos = ValidaCampos.getInstance();
	private List<Livro> livros = new ArrayList<Livro>();
	private Mensagem mensagem = Mensagem.getInstance();

	@Override
	public boolean persist(Livro entity) {
		if(validaCampos(entity) == false){
			return false;
		}try {
			livroDAO.save(entity);
			this.livros.add(entity);
			mensagem.exibeMensagemINFOCadastroComSucesso();
			return true;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean update(Livro entity) {
		if(validaCampos(entity) == false){
			return false;
		}try {
			livroDAO.update(entity);
			this.livros.removeAll(this.livros);
			mensagem.exibeMensagemINFOAlteradoComSucesso();
			return true;
		}catch(Exception ex){
			mensagem.exibeMensagemERRORAlterarDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean delete(Livro entity) {
		try {
			livroDAO.delete(entity);
			this.livros.remove(entity);
			mensagem.exibeMensagemINFOExcluidoComSucesso();
			return true;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORRemoverDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public List<Livro> getAll() {
		if(this.livros.isEmpty())
			this.livros = buscaTodosBD();
		return this.livros;
	}
	
	public List<Editora> getEditora(){
		try {
			return new EditoraDAO().getAll();
		} catch (Exception ex) {
			ex.printStackTrace();
			mensagem.exibeMensagemERRORObterDados(ex);
		}return null;
	}
	
	public List<Categoria> getCategoria(){
		try {
			return new CategoriaDAO().getAll();
		} catch (Exception ex) {
			ex.printStackTrace();
			mensagem.exibeMensagemERRORObterDados(ex);
		}return null;
	}

	private boolean validaCampos(Livro livro){
		if(!validaCampos.isCampoPreenchido(livro.getNome()) || livro.getCategoria() == null || livro.getEditora() == null){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}return true;
	}

	private List<Livro> buscaTodosBD(){
		try {
			return livroDAO.getAll();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}

	public List<Livro> getByNameLike(String textoPesquisa){
		try {
			return livroDAO.getByNameLike(textoPesquisa);
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}
}
