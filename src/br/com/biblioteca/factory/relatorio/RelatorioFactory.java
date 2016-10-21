package br.com.biblioteca.factory.relatorio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import br.com.biblioteca.aplicacao.util.Mensagem;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

/**
 * Classe responsavel por gerar os relatorios em formatos PDF, XLS, DOCX
 * 
 * @author	Paulo Cardoso
 * @date	23/07/2014 
 */
@SuppressWarnings("deprecation")
public class RelatorioFactory {

	private static RelatorioFactory relatorioFactory;
	private Mensagem mensagem = Mensagem.getInstance();
	
	private RelatorioFactory(){
	}
	
	/**
	 * Metodo Singleton responsavel por retornar uma unica instancia da classe RelatorioFactory
	 *    
	 * @return Instancia da classe RelatorioFactory
	 * 
	 * @author	Paulo Cardoso
	 * @date	23/07/2014 
	 */
	public static RelatorioFactory getInstance(){
		if(relatorioFactory == null){
			return new RelatorioFactory();
		}return relatorioFactory;
	}
	
	/**
	 * Metodo responsavel por gerar o relatorio em formato PDF
	 *    
	 * @param nomeArquivoJRXML nome do arquivo jrxml(sem extensao) que contem o layout do relatorio
	 * @param collection colecao dos dados a serem exibidos no relatorio   
	 *    
	 * @author	Paulo Cardoso
	 * @date	23/07/2014 
	 */
	public void gerarRelatorioPDF(String nomeArquivoJRXML, Collection<?> collection) throws IOException {
		JasperReport jasperReport;
		if(nomeArquivoJRXML != null && collection != null){
			if(collection.isEmpty()){
				mensagem.exibeMensagemRelatorioVazio();
			}else{
				try {
					HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
					InputStream in = this.getClass().getClassLoader().getResourceAsStream("br/com/biblioteca/relatorio/jasper/"+nomeArquivoJRXML+".jrxml");
					jasperReport = JasperCompileManager.compileReport(in);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(collection));
					
					OutputStream os = response.getOutputStream();
				    JasperExportManager.exportReportToPdfStream(jasperPrint,os);
					
				    FacesContext.getCurrentInstance().responseComplete();
				} catch (JRException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Metodo responsavel por gerar o relatorio em formato XLS
	 *    
	 * @param nomeArquivoJRXML nome do arquivo jrxml(sem extensao) que contem o layout do relatorio
	 * @param collection colecao dos dados a serem exibidos no relatorio   
	 *    
	 * @author	Paulo Cardoso
	 * @date	23/07/2014 
	 */
	public void gerarRelatorioXLS(String nomeArquivoJRXML, Collection<?> collection) throws IOException {
		JasperReport jasperReport;
		if(nomeArquivoJRXML != null && collection != null){
			if(collection.isEmpty()){
				mensagem.exibeMensagemRelatorioVazio();
			}else{
				try {   
					HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
					InputStream in = this.getClass().getClassLoader().getResourceAsStream("br/com/biblioteca/relatorio/jasper/"+nomeArquivoJRXML+".jrxml");
					response.addHeader("Content-disposition", "attachment; filename=relatorio.xlsx");  
					OutputStream os = response.getOutputStream(); 
					JRXlsxExporter xlsExporter = new JRXlsxExporter();  
					jasperReport = JasperCompileManager.compileReport(in);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(collection));
					xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);  
					xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);  
					xlsExporter.exportReport();  
					FacesContext.getCurrentInstance().responseComplete();  
				} catch (JRException e) {
					e.printStackTrace();
				}
			}
		}
	}  
	
	/**
	 * Metodo responsavel por gerar o relatorio em formato DOCX
	 *    
	 * @param nomeArquivoJRXML nome do arquivo jrxml(sem extensao) que contem o layout do relatorio
	 * @param collection colecao dos dados a serem exibidos no relatorio   
	 *    
	 * @author	Paulo Cardoso
	 * @date	23/07/2014 
	 */
	public void gerarRelatorioDOCX(String nomeArquivoJRXML, Collection<?> collection) throws IOException {
		JasperReport jasperReport;
		if(nomeArquivoJRXML != null && collection != null){
			if(collection.isEmpty()){
				mensagem.exibeMensagemRelatorioVazio();
			}else{
				try {
					HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
					InputStream in = this.getClass().getClassLoader().getResourceAsStream("br/com/biblioteca/relatorio/jasper/"+nomeArquivoJRXML+".jrxml");
					response.addHeader("Content-disposition", "attachment; filename=relatorio.docx");  
					OutputStream os = response.getOutputStream(); 
					JRDocxExporter docxExporter = new JRDocxExporter();  
					jasperReport = JasperCompileManager.compileReport(in);
					JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(collection));
					docxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);  
					docxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);  
					docxExporter.exportReport();  
					FacesContext.getCurrentInstance().responseComplete();  
				} catch (JRException e) {
					e.printStackTrace();
				}
			}
		}
	}  
	
}
