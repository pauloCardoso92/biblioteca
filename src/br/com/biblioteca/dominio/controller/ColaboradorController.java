package br.com.biblioteca.dominio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

import br.com.biblioteca.aplicacao.service.ColaboradorService;
import br.com.biblioteca.dominio.entidade.Colaborador;
import br.com.biblioteca.dominio.entidade.Pessoa;

@ManagedBean
@ViewScoped
public class ColaboradorController implements InterfaceController<Colaborador>{
	
	private Colaborador colaborador;
	private ColaboradorService service = new ColaboradorService();
	private UploadedFile uploadedFile;
	
	public ColaboradorController(){
		factoryColaborador();
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	public void factoryColaborador(){
		colaborador = new Colaborador();
		colaborador.setPessoa(new Pessoa());
	}
	
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	@Override
	public boolean persist() throws Exception {
		if(service.persist(this.colaborador, getUploadedFile())){
			factoryColaborador();
			return true;
		}return false;
	}
	
	@Override
	public List<Colaborador> getAll() throws Exception {
		return service.getAll();
	}
	
	@Override
	public boolean update() throws Exception {
		if(service.update(this.colaborador)){
			factoryColaborador();
			return true;
		}return false;
	}
	
	@Override
	public boolean delete() throws Exception {
		if(service.delete(this.colaborador)){
			factoryColaborador();
			return true;
		}return false;
	}
	
	public List<Colaborador> pesquisarPorNome(){
		return service.getByNameLike(colaborador.getPessoa().getNome());
	}
	
}