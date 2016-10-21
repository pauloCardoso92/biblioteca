package br.com.biblioteca.aplicacao.sessao;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.biblioteca.aplicacao.service.UsuarioService;
import br.com.biblioteca.dominio.entidade.Usuario;

/**
 * Classe responsavel por tratar os dados da sessao
 * 
 * @author	Paulo Cardoso
 * @date	16/07/2014 
 */
public abstract class DadosSessao {
	
	private static UsuarioService usuarioService = new UsuarioService();
	
	/**
	 * Metodo responsavel por verificar se o usuario logado � administrador
	 *    
	 * @return	  True caso o usuario logado seja administrador
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	public static boolean isUsuarioAdmin() {
		boolean isUsuarioAdmin = false;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
			if ("ROLE_ADM".equals(grantedAuthority.getAuthority())) {
				isUsuarioAdmin = true;
				break;
			}
		}return isUsuarioAdmin;
	}

	/**
	 * Metodo responsavel por verificar se o usuario logado � comum
	 *    
	 * @return	  True caso o usuario logado seja comum
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	public static boolean isUsuarioComum() {
		boolean isUsuarioComum = false;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
			if ("ROLE_FUNC".equals(grantedAuthority.getAuthority())) {
				isUsuarioComum = true;
				break;
			}
		}return isUsuarioComum;
	}
	
	/**
	 * Metodo responsavel por retornar o usuario logado
	 *    
	 * @return	  Usuario logado
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	public static Usuario retornaUsuarioLogado(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			String nomeUsuario = ((UserDetails) principal).getUsername();
			return usuarioService.getByName(nomeUsuario);
		}
		
		return null;
	}

	
}
