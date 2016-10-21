package br.com.biblioteca.aplicacao.testes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class TestLogin {

	// Fun��o para criar hash da senha informada
	public static String md5(String senha) {
		String sen = "";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
		sen = hash.toString(16);
		return sen.toUpperCase();
	}

	public static void main(String[] args) {

		String senha = JOptionPane.showInputDialog("Digite uma senha:");
		String saida = "Entrada: " + senha + "\nSenha com MD5: " + md5(senha);

		JOptionPane.showConfirmDialog(null, saida, "Resultado",
				JOptionPane.CLOSED_OPTION);
	}
}
