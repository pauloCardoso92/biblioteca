package br.com.biblioteca.dominio.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ForeignKey;

@Entity(name="cliente")
public class Cliente {

	@Column(name = "id_cliente", length = 11)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer idCliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa", nullable = false)
	@ForeignKey(name = "fk_cliente_pessoa")
	private Pessoa pessoa;
	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", pessoa=" + pessoa + "]";
	}

}