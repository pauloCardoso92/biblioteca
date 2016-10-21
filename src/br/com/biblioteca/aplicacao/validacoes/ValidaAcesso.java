package br.com.biblioteca.aplicacao.validacoes;

import br.com.biblioteca.dominio.entidade.Usuario;
import br.com.biblioteca.infraestrutura.DAO.ValidaAcessoDAO;

public class ValidaAcesso {
	
    public String geraMd5(String senha){
        /*String sen = "";  
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  
        sen = hash.toString(16);              
        return sen.toUpperCase();*/  
    	return senha;
    }

    public boolean validaLoginSenha(String usuario, String senha){
    	Usuario usuario2 = new ValidaAcessoDAO().validaAcesso(usuario, senha);
    	if(usuario2 != null)
    		return true;
    	return false;
    }
    
}
