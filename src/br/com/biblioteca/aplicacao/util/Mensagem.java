package br.com.biblioteca.aplicacao.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Mensagem {
	
	private static Mensagem mensagem;
	
	private Mensagem(){
		
	}
	
	/**
	 * Metodo Singleton responsavel por retornar uma unica instancia da classe Mensagem
	 *    
	 * @return Instancia da classe Mensagem
	 * 
	 * @author	Paulo Cardoso
	 * @date	24/07/2014 
	 */
	public static Mensagem getInstance(){
		if(mensagem == null){
			return new Mensagem();
		}return mensagem;
	}

	public void exibeMensagemINFOExcluidoComSucesso(){ 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Registro excluído com sucesso!"));
	}
	
	public void exibeMensagemINFOAlteradoComSucesso(){ 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Dados alterados com sucesso!"));
	}
	
	public void exibeMensagemINFOCadastroComSucesso(){ 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Dados cadastrados com sucesso!"));
	}
	
	public void exibeMensagemERRORCamposObrigatorios(){ 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Preencha todos os campos obrigatórios!"));
	}
	
	public void exibeMensagemERRORAlterarDados(Exception ex){ 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Ocorreu um erro ao alterar os dados! Detail.: "+ex.getMessage()));
	}
	
	public void exibeMensagemERRORPersistirDados(Exception ex){ 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Ocorreu um erro ao persistir os dados! Detail.: "+ex.getMessage()));
	}
	
	public void exibeMensagemERRORObterDados(Exception ex){ 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Ocorreu um erro ao obter os dados! Detail.: "+ex.getMessage()));
	}
	
	public void exibeMensagemERRORRemoverDados(Exception ex){ 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Ocorreu um erro ao remover os dados! Detail.: "+ex.getMessage()));
	}

	public void exibeMensagemERROR(String mensagem){ 
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, null, mensagem));
	}
	
	public void exibeMensagemINFO(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, mensagem));
	}
	
	public void exibeMensagemRelatorioVazio(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Dados não encontrados!"));
	}
		
}