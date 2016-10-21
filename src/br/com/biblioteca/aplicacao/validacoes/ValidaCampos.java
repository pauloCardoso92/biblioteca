package br.com.biblioteca.aplicacao.validacoes;

import java.util.Date;

public class ValidaCampos {
	
	private static ValidaCampos validaCampos;
	
	private ValidaCampos(){
	}
	
	/**
	 * Metodo Singleton responsavel por retornar uma unica instancia da classe ValidaCampos
	 *    
	 * @return Instancia da classe ValidaCampos
	 * 
	 * @author	Paulo Cardoso
	 * @date	24/07/2014 
	 */
	public static ValidaCampos getInstance(){
		if(validaCampos == null){
			return new ValidaCampos();
		}return validaCampos;
	}
	
	public boolean isCampoPreenchido(String... campos){
		for(String c : campos){
			if(c == null || c.trim().equals(""))
				return false;
		}return true;
	}
	
	public boolean isDataPreenchida(Date... datas){
		for(Date d : datas){
			if(d == null){
				return false;
			}
		}return true;
	}
	
	public boolean isCPFValido(String cpf){
		cpf = cpf.trim().replaceAll("\\.", "").replaceAll("-", "");
		int primeiroDigito = calcularDigitoCPF(cpf, 9,10);
		int segundoDigito = calcularDigitoCPF(cpf,10,11);
		if(isDigitosIguaisCPF(cpf) == true){
			return false; // 48 equivale a 0 na tabela ASCII
		}if((cpf.charAt(9) - 48) == primeiroDigito && (cpf.charAt(10) - 48) == segundoDigito){
			return true;
		}return false;
	}
	
	private int calcularDigitoCPF(String cpf, int lenght, int multiplicador){
		int soma = 0, digito = 0;
		for(int i=0; i<lenght; i++){
			soma += (cpf.charAt(i) - 48) * multiplicador;
			multiplicador--;
		}if(soma % 11 < 2){
			digito = 0;
		}else{
			digito = 11 - (soma % 11);
		}return digito;
	}
	
	private boolean isDigitosIguaisCPF(String cpf){
		int primeiroDigito = Integer.parseInt(String.valueOf(cpf.charAt(0)));
		for(int i=0; i<cpf.length(); i++){
			if(cpf.charAt(i) - 48 != primeiroDigito){
				return false;
			}
		}return true;
	}

}
