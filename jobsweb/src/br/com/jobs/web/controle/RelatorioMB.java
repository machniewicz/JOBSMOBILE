package br.com.jobs.web.controle;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean(name = "relatorioMB")
@SessionScoped
public class RelatorioMB {
	
	public void pdfReport(){
		FacesContext facescontext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facescontext.getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\"pdfgeneretefile.pdf\"");
		Map params = new HashMap();
		try {
			InputStream stream = null;
			ServletContext serveltContext = (ServletContext) facescontext.getExternalContext().getContext();
			String pathJasper = serveltContext.getRealPath("/");
			stream = new FileInputStream(pathJasper + "/WEB-INF/relatorios/rel_usuarios.jasper");
			JasperPrint impressoraJasper = JasperFillManager.fillReport(stream, params, conexao());
			ServletOutputStream streamSaida = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(impressoraJasper, streamSaida);
		} catch (Exception e) {
			System.out.println("Exception dentro do ExportPDF");
			// TODO: handle exception
		}
		facescontext.responseComplete();
	}
	
	public Connection conexao(){
		Connection conn = null;
		String url = "jdbc:postgresql://localhost:5432/JobsMobile";
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			try {
				conn = DriverManager.getConnection(url,"postgres","N@lson1br");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Erro SQL Exception");
				e.printStackTrace();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			System.out.println("Instantiation Exception");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			System.out.println("Illegal Access Exception");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class Not Found Exception");
			e.printStackTrace();
		}
		return conn;
				
	}

}
