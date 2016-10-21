package br.com.biblioteca.dominio.entidade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "sis_log")
public class Log {
	
	@Column(name = "id_log", length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idLog;

	@Column(name = "id_usuario", length = 20, nullable = false)
	private Integer idUsuario;
	
	@Column(name = "tipo_comando", length = 11, nullable = false)
	private String tipoComando;
	
	@Column(name = "registro_antigo", length = 1000, nullable = true)
	private String registroAntigo;
	
	@Column(name = "registro_atual", length = 1000, nullable = true)
	private String registroAtual;
	
	@Column(name = "data_execucao", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataExecucao;

	public Integer getIdLog() {
		return idLog;
	}

	public void setIdLog(Integer idLog) {
		this.idLog = idLog;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoComando() {
		return tipoComando;
	}

	public void setTipoComando(String tipoComando) {
		this.tipoComando = tipoComando;
	}

	public String getRegistroAntigo() {
		return registroAntigo;
	}

	public void setRegistroAntigo(String registroAntigo) {
		this.registroAntigo = registroAntigo;
	}

	public String getRegistroAtual() {
		return registroAtual;
	}

	public void setRegistroAtual(String registroAtual) {
		this.registroAtual = registroAtual;
	}

	public Date getDataExecucao() {
		return dataExecucao;
	}

	public void setDataExecucao(Date dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	@Override
	public String toString() {
		return "Log [idLog=" + idLog + ", idUsuario=" + idUsuario
				+ ", tipoComando=" + tipoComando + ", registroAntigo="
				+ registroAntigo + ", registroAtual=" + registroAtual
				+ ", dataExecucao=" + dataExecucao + "]";
	}

}