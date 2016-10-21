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

@Entity(name="colaborador")
public class Colaborador {

	@Column(name = "id_colaborador", length = 11)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer idColaborador;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa", nullable = false)
	@ForeignKey(name = "fk_colaborador_pessoa")
	private Pessoa pessoa;
	
	@Column(name = "cargo_funcao", length = 40, nullable = false)
	private String cargoFuncao = "Analista de Sistemas";
	
	@Column(nullable = true)
	private Double salario;

	@Column(name = "tipo_contrato", length = 20, nullable = false)
	private String tipoContrato;
	
	@Column(name = "guid_foto", length = 100, nullable = true)
	private String foto;
	
	@Column(length = 10, nullable = false)
	private Integer matricula = 1258001740;

	public Integer getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getCargoFuncao() {
		return cargoFuncao;
	}

	public void setCargoFuncao(String cargoFuncao) {
		this.cargoFuncao = cargoFuncao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Colaborador [idColaborador=" + idColaborador + ", pessoa="
				+ pessoa + ", cargoFuncao=" + cargoFuncao + ", salario="
				+ salario + ", tipoContrato=" + tipoContrato + ", foto=" + foto
				+ ", matricula=" + matricula + "]";
	}

}