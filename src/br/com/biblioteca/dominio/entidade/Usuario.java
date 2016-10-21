package br.com.biblioteca.dominio.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.biblioteca.aplicacao.validacoes.ValidaAcesso;

@Entity(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario", length = 11)
	private Integer idUsuario;

	@Column(length = 15, nullable = false, unique = true)
	private String login;

	@Column(length = 32, nullable = false)
	private String senha;

	@Column(name = "nivel_acesso", length = 32, nullable = false)
	private String nivelAcesso = "ROLE_FUNC";

	@Column(length = 1, nullable = false)
	private String situacao = "A";

	@Column(name = "data_cadastro", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();

	@Column(length = 30, nullable = false)
	private String email;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsario) {
		this.idUsuario = idUsario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if(senha != null && !senha.trim().equals(""))
			this.senha = new ValidaAcesso().geraMd5(senha);
	}

	public String getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(String nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", login=" + login
				+ ", senha=" + senha + ", nivelAcesso=" + nivelAcesso
				+ ", situacao=" + situacao + ", dataCadastro=" + dataCadastro
				+ ", email=" + email + "]";
	}

}