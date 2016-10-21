package br.com.biblioteca.aplicacao.service;

import java.util.ArrayList;
import java.util.List;

import br.com.biblioteca.aplicacao.util.Mensagem;
import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Categoria;
import br.com.biblioteca.factory.entidade.FactoryBean;
import br.com.biblioteca.factory.log.FactoryLog;
import br.com.biblioteca.infraestrutura.DAO.CategoriaDAO;

public class CategoriaService implements InterfaceService<Categoria> {
	
	/**
	 * Variavel que armazena a categoriaDAO
	 */
	private CategoriaDAO categoriaDAO = new CategoriaDAO();
	private Mensagem mensagem = (Mensagem) FactoryBean.getObject("mensagem");
	private ValidaCampos validaCampos = (ValidaCampos) FactoryBean.getObject("validaCampos");
	private List<Categoria> categorias = new ArrayList<Categoria>();

	/**
	 * Metodo responsavel por persistir a categoria no banco de dados
	 * Tabelas: categoria
	 *   
	 * @return	  True caso a categoria seja persistida com sucesso no Banco de Dados
	 * @param     Categoria que devera ser persistida
	 * @exception Exception: Caso ocorra algum erro ao persistir a categoria
	 * 
	 * @author	Paulo Cardoso
	 * @date	25/03/2014
	 */
	@Override
	public boolean persist(Categoria entity) {
		if(!validaCampos.isCampoPreenchido(entity.getNome())){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}try {
			categoriaDAO.save(entity);
			FactoryLog.gerarLogInclusaoRegistro(entity.toString());
			this.categorias.add(entity);
			mensagem.exibeMensagemINFOCadastroComSucesso();
			return true;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean update(Categoria entity) {
		if(!validaCampos.isCampoPreenchido(entity.getNome())){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}try {
			FactoryLog.gerarLogAlteracaoRegistro(buscaCategoriaPorId(entity.getIdCategoria()).toString(), entity.toString());
			categoriaDAO.update(entity);			
			this.categorias.removeAll(this.categorias);
			mensagem.exibeMensagemINFOAlteradoComSucesso();
			return true;
		}catch(Exception ex){
			mensagem.exibeMensagemERRORAlterarDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean delete(Categoria entity) {
		try {
			categoriaDAO.delete(entity);
			this.categorias.remove(entity);
			FactoryLog.gerarLogExclusaoRegistro(entity.toString());
			mensagem.exibeMensagemINFOExcluidoComSucesso();
			return true;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORRemoverDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public List<Categoria> getAll() {
		if(this.categorias.isEmpty())
			this.categorias =  buscaTodosBD();
		return this.categorias;
	}
	
	public List<Categoria> buscaTodosBD(){
		try {
			return categoriaDAO.getAll();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}
	
	/**
	 * Metodo responsavel por buscar por id atravez da classe CategoriaDAO
	 *   
	 * @return 	  Categoria 
	 * @param 	  id id da categoria
	 * 
	 * @author	Paulo Cardoso
	 * @date	17/07/2014
	 */
	public Categoria buscaCategoriaPorId(Integer id) {
		try {
			return categoriaDAO.buscaCategoria(id);
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}

}
