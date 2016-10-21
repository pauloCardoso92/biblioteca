package br.com.biblioteca.aplicacao.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DataUtil {

	public static String dataAtualFormatadaLog(){
		String dataAtual = dataHoraAtualFormatada().replaceAll("/", "_").substring(0, 10);
		return dataAtual;
	}
	
	public static String dataHoraAtualFormatada(){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return sdf.format(d);
	}
	
}