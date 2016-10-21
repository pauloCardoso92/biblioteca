package br.com.biblioteca.dominio.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ForeignKey;

@Entity(name = "dependente")
public class Dependente {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_dependente", length = 11)
	private Integer idDependente;
	
	@ManyToOne()
	@JoinColumn(name = "id_cliente", nullable = false)
	@ForeignKey(name = "fk_dependente_cliente")
	private Cliente cliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa", nullable = false)
	@ForeignKey(name = "fk_dependente_pessoa")
	private Pessoa pessoa;

	public Integer getIdDependente() {
		return idDependente;
	}

	public void setIdDependente(Integer idDependente) {
		this.idDependente = idDependente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Dependente [idDependente=" + idDependente + ", cliente="
				+ cliente + ", pessoa=" + pessoa + "]";
	}

}