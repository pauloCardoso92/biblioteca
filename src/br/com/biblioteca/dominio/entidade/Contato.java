package br.com.biblioteca.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity(name="contato")
public class Contato {

	@Column(name = "id_contato", length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idContato;

	@ManyToOne()
	@JoinColumn(name = "id_pessoa", nullable = false)
	@ForeignKey(name = "fk_contato_pessoa")
	private Pessoa pessoa;

	@Column(name = "tipo_contato", length = 15, nullable = false)
	private String tipoContato;

	@Column(length = 15, nullable = true)
	private String numero;

	@Column(length = 40, nullable = true)
	private String email;

	public Integer getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(String tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contato [idContato=" + idContato + ", pessoa=" + pessoa
				+ ", tipoContato=" + tipoContato + ", numero=" + numero
				+ ", email=" + email + "]";
	}

}