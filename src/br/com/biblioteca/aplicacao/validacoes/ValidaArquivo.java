package br.com.biblioteca.aplicacao.validacoes;

import org.primefaces.model.UploadedFile;

import br.com.biblioteca.aplicacao.util.Mensagem;

public class ValidaArquivo {
	
	private Mensagem mensagem = Mensagem.getInstance();
	
	public boolean isArquivoValido(UploadedFile foto){
		if(foto != null){
			try {
				String nomeArquivo = foto.getFileName();
				if(!nomeArquivo.substring(nomeArquivo.lastIndexOf('.'), nomeArquivo.length()).equals(".jpg")){
					mensagem.exibeMensagemERROR("Arquivo com extens�o inv�lida! Selecione um arquivo com extens�o .jpg!");
					return false;
				}if(foto.getSize() > 2097152){ // 2MB
					mensagem.exibeMensagemERROR("Arquivo com tamanho inv�lido! Selecione um arquivo com no m�ximo 2MB!");
					return false;
				}
			} catch (Exception ex) {
				mensagem.exibeMensagemERROR("Ocorreu um erro ao validar o arquivo! Detail.: "+ex.getMessage());
				ex.printStackTrace();
				return false;
			}return true;
		}return false;
	}
}