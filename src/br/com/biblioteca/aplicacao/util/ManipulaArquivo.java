package br.com.biblioteca.aplicacao.util;

import java.io.File;
import java.io.FileOutputStream;

import org.primefaces.model.UploadedFile;

public class ManipulaArquivo {
	private String caminho;
	private byte[] arquivo;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void fileUpload(UploadedFile foto, String type, String diretorio) {
		try {
			this.nome = new java.util.Date().getTime() + type;
			this.caminho = diretorio + getNome();
			this.arquivo = foto.getContents();

			File file = new File(diretorio);
			file.mkdirs();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void gravar() {
		try {
			FileOutputStream fileOutputStream;
			fileOutputStream = new FileOutputStream(this.caminho);
			fileOutputStream.write(this.arquivo);
			fileOutputStream.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}