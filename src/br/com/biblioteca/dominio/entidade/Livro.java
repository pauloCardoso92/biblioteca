package br.com.biblioteca.dominio.entidade;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity(name="livro")
public class Livro {

	@Column(name = "id_livro", length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idLivro;

	@ManyToOne
	@JoinColumn(name = "id_editora", nullable = false)
	@ForeignKey(name = "fk_livro_editora")
	private Editora editora;

	@ManyToOne
	@JoinColumn(name = "id_categoria", nullable = false)
	@ForeignKey(name = "fk_livro_categoria")
	private Categoria categoria;

	@Column(length = 40, nullable = false)
	private String nome;

	@Column(name = "ano_lancamento", nullable = true)
	private int anoLancamento = GregorianCalendar.getInstance().get(Calendar.YEAR);
	
	@Column(length = 255, nullable = true)
	private String observacao;
	
	@Column(length = 1, nullable = false)
	private String situacao = "A";
	
	@Column(name = "quantidade_paginas", length = 4, nullable = true)
	private int qntdPaginas;
	
	public Integer getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
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
	
	public int getQntdPaginas() {
		return qntdPaginas;
	}

	public void setQntdPaginas(int qntdPaginas) {
		this.qntdPaginas = qntdPaginas;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", editora=" + editora
				+ ", categoria=" + categoria + ", nome=" + nome
				+ ", anoLancamento=" + anoLancamento + ", observacao="
				+ observacao + ", situacao=" + situacao + ", qntdPaginas="
				+ qntdPaginas + "]";
	}

}