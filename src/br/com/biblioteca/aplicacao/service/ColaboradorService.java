package br.com.biblioteca.aplicacao.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import br.com.biblioteca.aplicacao.util.ManipulaArquivo;
import br.com.biblioteca.aplicacao.util.Mensagem;
import br.com.biblioteca.aplicacao.validacoes.ValidaArquivo;
import br.com.biblioteca.aplicacao.validacoes.ValidaCampos;
import br.com.biblioteca.dominio.entidade.Colaborador;
import br.com.biblioteca.infraestrutura.DAO.ColaboradorDAO;

public class ColaboradorService implements InterfaceService<Colaborador>{
	
	private ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
	private ValidaCampos validaCampos = ValidaCampos.getInstance();
	private List<Colaborador> colaboradores = new ArrayList<Colaborador>();
	private Mensagem mensagem = Mensagem.getInstance();
	private ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
	private ValidaArquivo validaArquivo = new ValidaArquivo();

	public boolean persist(Colaborador entity, UploadedFile uploadedFile) {
		if(validaCampos(entity) == false){
			return false;
		}try{
			if(uploadedFile != null){
				if(validaArquivo.isArquivoValido(uploadedFile) == true){
					manipulaArquivo.fileUpload(uploadedFile, ".jpg", "D:/Workspace/Biblioteca_arquivos/colaborador_fotos/");
					entity.setFoto(this.manipulaArquivo.getNome());
					manipulaArquivo.gravar();
				}else
					return false;
			}
			colaboradorDAO.save(entity); 
			colaboradores.add(entity);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoaColaborador", entity.getPessoa());
			mensagem.exibeMensagemINFOCadastroComSucesso();
			return true;
		}catch(Exception ex){
			mensagem.exibeMensagemERRORPersistirDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean update(Colaborador entity) {
		if(validaCampos(entity) == false){
			return false;
		}try {
			colaboradorDAO.update(entity);
			colaboradores.removeAll(colaboradores);
			mensagem.exibeMensagemINFOAlteradoComSucesso();
			return true;
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORAlterarDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public boolean delete(Colaborador entity) {
		try{
			colaboradorDAO.delete(entity);
			colaboradores.remove(entity);
			mensagem.exibeMensagemINFOExcluidoComSucesso();
			return true;
		} catch(Exception ex){
			mensagem.exibeMensagemERRORRemoverDados(ex);
			ex.printStackTrace();
		}return false;
	}

	@Override
	public List<Colaborador> getAll() {
		if(this.colaboradores.isEmpty())
			this.colaboradores = buscaTodosBD();
		return this.colaboradores;
	}
	
	private boolean validaCampos(Colaborador entity){
		if(!validaCampos.isCampoPreenchido(entity.getPessoa().getNome(),  entity.getPessoa().getCpfCnpj()) || entity.getMatricula() == null){
			mensagem.exibeMensagemERRORCamposObrigatorios();
			return false;
		}if(validaCampos.isCampoPreenchido(entity.getPessoa().getCpfCnpj()) && !validaCampos.isCPFValido(entity.getPessoa().getCpfCnpj())){
			mensagem.exibeMensagemERROR("CPF inválido!");
			return false;
		}return true;
	}
	
	public List<Colaborador> getByNameLike(String textoPesquisa){
		try {
			return colaboradorDAO.getByNameLike(textoPesquisa);
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}

	private List<Colaborador> buscaTodosBD(){
		try {
			return colaboradorDAO.getAll();
		} catch (Exception ex) {
			mensagem.exibeMensagemERRORObterDados(ex);
			ex.printStackTrace();
		}return null;
	}

	@Override
	public boolean persist(Colaborador entity) {
		return false;
	}
	
}