package br.com.biblioteca.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

@Entity(name="endereco")
public class Endereco {

	@Column(name = "id_endereco", length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id()
	private Integer idEndereco;
	
	@Column(name = "tipo_endereco", length = 15, nullable = false)
	private String tipoEndereco = "residencial";
	
	@Column(length = 30, nullable = true)
	private String logradouro = "cidade";
	
	@Column(length = 50, nullable = true)
	private String bairro;
	
	@Column(length = 50, nullable = true)
	private String complemento;
	
	@Column(length = 50, nullable = true)
	private String municipio = "Bras�lia";
	
	@Column(length = 2, nullable = false)
	private String uf = "DF";
	
	@Column(length = 10, nullable = false)
	private String cep = "71885-241";
	
	@Column(length = 50, nullable = false)
	private String cidade = "Aguas Lindas";
	
	@Column(length = 50, nullable = false)
	private String endereco = "CSC 25 CONJUNTO 18";
	
	@Column(length = 15, nullable = false)
	private int numero = 21;
	
	@ManyToOne()
	@JoinColumn(name = "id_pessoa", nullable = false)
	@ForeignKey(name = "fk_endereco_pessoa")
	private Pessoa pessoa;

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTipoEndereco() {
		return tipoEndereco;
	}

	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", logradouro="
				+ logradouro + ", bairro=" + bairro + ", complemento="
				+ complemento + ", municipio=" + municipio + ", uf=" + uf
				+ ", cep=" + cep + ", cidade=" + cidade + ", endereco="
				+ endereco + ", tipoEndereco=" + tipoEndereco + ", numero="
				+ numero + ", pessoa=" + pessoa + "]";
	}

}
