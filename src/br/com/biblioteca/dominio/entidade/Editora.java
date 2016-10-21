package br.com.biblioteca.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="editora")
public class Editora {

	@Column(name = "id_editora", length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idEditora;

	@Column(length = 30, nullable = false)
	private String nome;
	
	@Column(length = 255, nullable = true)
	private String observacao;
	
	@Column(length = 1, nullable = false)
	private String situacao = "A";

	public Integer getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(Integer idEditora) {
		this.idEditora = idEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Editora [idEditora=" + idEditora + ", nome=" + nome + "]";
	}

}
