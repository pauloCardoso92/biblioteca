package br.com.biblioteca.dominio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.biblioteca.aplicacao.service.UsuarioService;
import br.com.biblioteca.dominio.entidade.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioController implements InterfaceController<Usuario>{

	private Usuario usuario;
	private UsuarioService service = new UsuarioService();

	public UsuarioController() {
		factoryUsuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	private void factoryUsuario() {
		this.usuario = new Usuario();
	}
	
	@Override
	public boolean persist(){
		if(service.persist(this.usuario)){
			factoryUsuario();
			return true;
		}return false;
	}

	@Override
	public boolean update() {
		if(service.update(this.usuario)){
			factoryUsuario();
			return true;
		}return false;
	}

	@Override
	public boolean delete() {
		if(service.delete(this.usuario)){
			factoryUsuario();
			return true;
		}return false;
	}
	
	@Override
	public List<Usuario> getAll() {
		return service.getAll();
	}
	
}