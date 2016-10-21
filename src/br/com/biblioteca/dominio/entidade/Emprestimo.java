package br.com.biblioteca.dominio.entidade;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;

@Entity(name="emprestimo")
public class Emprestimo {

	@Column(name = "id_emprestimo", length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idEmprestimo;

	@ManyToOne()
	@JoinColumn(name = "id_pessoa", nullable = false)
	@ForeignKey(name = "fk_emprestimo_pessoa")
	private Pessoa pessoa;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "emprestimo_livro", joinColumns={@JoinColumn(name = "id_emprestimo")})
	private List<Livro> livro;
	
	@Column(name = "data_emprestimo", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEmprestimo = new Date();
	
	@Column(name = "data_devolucao", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataDevolucao;

	@Column(name = "data_real_devolucao", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataRealDevolucao;
	
	@Column(nullable = false, length = 20)
	private String situacao = "pendente";
	
	@Column(nullable = true, length = 40)
	private String observacao;

	public Integer getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Integer idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Date getDataRealDevolucao() {
		return dataRealDevolucao;
	}

	public void setDataRealDevolucao(Date dataRealDevolucao) {
		this.dataRealDevolucao = dataRealDevolucao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Emprestimo [idEmprestimo=" + idEmprestimo + ", pessoa="
				+ pessoa + ", livro=" + livro + ", dataEmprestimo="
				+ dataEmprestimo + ", dataDevolucao=" + dataDevolucao
				+ ", dataRealDevolucao=" + dataRealDevolucao + ", situacao="
				+ situacao + ", observacao=" + observacao + "]";
	}

}