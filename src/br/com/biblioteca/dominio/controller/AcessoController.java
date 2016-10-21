package br.com.biblioteca.dominio.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.biblioteca.aplicacao.sessao.DadosSessao;
import br.com.biblioteca.dominio.entidade.Usuario;

@SessionScoped
@ManagedBean
public class AcessoController {

	private Usuario usuario = new Usuario();
	
	public AcessoController(){
	}
	
	public boolean isUsuarioAdmin() {
		return DadosSessao.isUsuarioAdmin();
	}

	public boolean isUsuarioComum() {
		return DadosSessao.isUsuarioComum();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String retornaUsuarioLogado(){
		String nomeUsuarioLogado = "";
		
		if (DadosSessao.retornaUsuarioLogado() != null) {
			nomeUsuarioLogado = DadosSessao.retornaUsuarioLogado().getLogin();
		}
		
		return nomeUsuarioLogado;
	}

}