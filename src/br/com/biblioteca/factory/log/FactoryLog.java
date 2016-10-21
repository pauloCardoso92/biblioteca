package br.com.biblioteca.factory.log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import br.com.biblioteca.aplicacao.service.LogService;
import br.com.biblioteca.aplicacao.sessao.DadosSessao;
import br.com.biblioteca.aplicacao.util.DataUtil;
import br.com.biblioteca.dominio.entidade.Log;
import br.com.biblioteca.dominio.entidade.Usuario;

/**
 * Classe responsavel por gerar os logs do sistema em arquivo e em Banco de Dados
 * Tabela: sis_log
 * 
 * @author	Paulo Cardoso
 * @date	16/07/2014 
 */
public abstract class FactoryLog {
	
	private static LogService logService = new LogService();  
	
	/**
	 * Metodo responsavel por gravar o log no arquivo
	 * 
	 * @param     Texto a ser gravado no arquivo de log
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	private static void geraLog(String texto) {
		String nomeArquivo = "C:/SYSTEM_"+DataUtil.dataAtualFormatadaLog()+".log";
		try {
			OutputStream os = new FileOutputStream(nomeArquivo, true);
			String text = DataUtil.dataHoraAtualFormatada()+" |INFO| "+texto+"\n";
			os.write(text.getBytes());
			os.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Metodo responsavel por gerar os dados do usuario
	 * 
	 * @return	  Dados do usuario
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	private static String geraDadosUsuario(){
		String dadosUsuario = "\tUsuario: "+recuperaDadosUsuario().getLogin();
		return dadosUsuario;
	}
	
	/**
	 * Metodo responsavel por recuperar a conta do usuario logado
	 * 
	 * @return	  Conta do usuario logado
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	private static Usuario recuperaDadosUsuario(){
		return DadosSessao.retornaUsuarioLogado();
	}
	
	/**
	 * Metodo responsavel por gerar o log de inclusao
	 * 
	 * @param     Dados do registro incluido
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	public static void gerarLogInclusaoRegistro(String dadosRegistro){
		persist(preparaDadosPersistirLog("INSERT", null, dadosRegistro));
		String texto = "Registro Incluido: "+dadosRegistro+""+geraDadosUsuario();
		geraLog(texto);
	}
	
	/**
	 * Metodo responsavel por gerar o log de alteracao
	 * 
	 * @param dadosRegistroAnterior Dados do registro antes das alteracoes
	 * @param dadosRegistroAtual Dados do registro alterado	
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	public static void gerarLogAlteracaoRegistro(String dadosRegistroAnterior, String dadosRegistroAtual){
		persist(preparaDadosPersistirLog("UPDATE", dadosRegistroAnterior, dadosRegistroAtual));
		String texto = "Registro Alterado: Dados Anteriores: "+dadosRegistroAnterior+" Dados Atualizados: "+dadosRegistroAtual+""+geraDadosUsuario();
		geraLog(texto);
	}
	
	/**
	 * Metodo responsavel por gerar o log de exclusao
	 * 
	 * @param     Dados do registro excluido
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	public static void gerarLogExclusaoRegistro(String dadosRegistro){
		persist(preparaDadosPersistirLog("DELETE", dadosRegistro, null));
		String texto = "Registro Excluido: "+dadosRegistro+""+geraDadosUsuario();
		geraLog(texto);
	}
	
	/**
	 * Metodo responsavel por preparar o log para ser persistido
	 * 
	 * @param tipoComando indica o tipo de operacao: I INSERT, U UPDATE, D DELETE
	 * @param registroAntigo dados antigos antes da alteracao
	 * @param registroAtual dados alterados
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	private static Log preparaDadosPersistirLog(String tipoComando, String registroAntigo, String registroAtual){
		Log log = new Log();
		
		log.setDataExecucao(new Date());
		log.setIdUsuario(recuperaDadosUsuario().getIdUsuario());
		log.setTipoComando(tipoComando);
		if(registroAntigo != null)
			log.setRegistroAntigo(registroAntigo);
		if(registroAtual != null)
			log.setRegistroAtual(registroAtual);
		return log;
	}
	
	/**
	 * Metodo responsavel por persistir o log atraves da classe ServiceDAO
	 * 
	 * @param log log a ser persistido
	 * 
	 * @author	Paulo Cardoso
	 * @date	16/07/2014 
	 */
	private static void persist(Log log){
		logService.persist(log);
	}
	

}