package br.com.biblioteca.dominio.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="pessoa")
public class Pessoa {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id_pessoa", length = 11)
	private Integer idPessoa;
	
	@Column(length = 50, nullable = false)
	private String nome;

	@Column(name = "cpf_cnpj", length = 14, nullable = false)
	private String cpfCnpj;
	
	@Column(length = 15, nullable = true)
	private String rg;
	
	@Column(length = 1, nullable = false)
	private String sexo = "M";
	
	@Column(name = "data_nascimento", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(length = 1, nullable = false)
	private String situacao = "A";
	
	@Column(length = 20, nullable = true)
	private String conta = "admin";
	
	@Column(length = 32, nullable = true)
	private String senha = "21232F297A57A5A743894A0E4A801FC3";
	
	@Column(length = 100, nullable = true)
	private String observacao;
	
	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getSexoPorExtenso(){
		String sexoPorExtenso = this.sexo.equalsIgnoreCase("F") ?  "Feminino" : "Masculino";
		return sexoPorExtenso;
	}
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpfCnpj=" + cpfCnpj + ", rg=" + rg
				+ ", sexo=" + sexo + ", dataNascimento=" + dataNascimento
				+ ", situacao=" + situacao + ", conta="
				+ conta + ", senha=" + senha + ", observacao=" + observacao
				+ "]";
	}

}