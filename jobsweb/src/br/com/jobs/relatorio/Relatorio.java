package br.com.jobs.relatorio;

import java.util.List;

import br.com.jobs.modelo.usuario.Usuario;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class Relatorio 
{
	private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jasper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public Relatorio() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = "br/com/jobs/relatorio/jasper/";
		System.out.println("caminho para gravação do arquivo "+ this.getPathToReportPackage());
	}
	
	
	//Imprime/gera uma lista de Clientes
	public void imprimir(List<Usuario> clientes) throws Exception	
	{
		JasperReport report = JasperCompileManager.compileReport(this.getPathToReportPackage() + "rel_usuarios.jrxml");
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clientes));
 
		JasperExportManager.exportReportToPdfFile(print, "/home/nilson/Downloads/Relatorio_de_usuarios.pdf");		
	}
 
	public String getPathToReportPackage() {
		return this.pathToReportPackage;
	}
	
	public String getPath() {
		return this.path;
	}
}