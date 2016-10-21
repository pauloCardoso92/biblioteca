package br.com.biblioteca.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ForeignKey;

@Entity(name = "emprestimo_livro")
public class EmprestimoLivro {

	@Column(name = "id_emprestimo_livro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idEmprestimoLivro;
	
	@OneToOne
	@JoinColumn(name = "id_livro")
	@ForeignKey(name = "fk_emprestimo_livro_livro")
	private Livro livro;
	
	@ManyToOne
	@JoinColumn(name = "id_emprestimo")
	@ForeignKey(name = "fk_emprestimo_livro_emprestimo")
	private Emprestimo emprestimo;

	public Integer getIdEmprestimoLivro() {
		return idEmprestimoLivro;
	}

	public void setIdEmprestimoLivro(Integer idEmprestimoLivro) {
		this.idEmprestimoLivro = idEmprestimoLivro;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	@Override
	public String toString() {
		return "EmprestimoLivro [idEmprestimoLivro=" + idEmprestimoLivro
				+ ", livro=" + livro + ", emprestimo=" + emprestimo + "]";
	}

}
