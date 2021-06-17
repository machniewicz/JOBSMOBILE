package br.com.jobs.relatorio;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@ManagedBean(name = "relatorioMB")
@SessionScoped
public class Report {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void pdfReport(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename=\"filePDF.pdf\"");
		
		HashMap params = new HashMap();
		
		try{
			FileInputStream stream = null;
			ServletContext servletContext = (ServletContext) facesContext.getExternalContext().getContext();
			String pathJasper = servletContext.getRealPath("/");
			stream = new FileInputStream(pathJasper + "/WEB-INF/relatorios/cv_default.jasper");
			JasperPrint impressoraJasper = JasperFillManager.fillReport(stream, params);
			ServletOutputStream streamDeSaida = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(impressoraJasper, streamDeSaida);

		}catch (JRException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
		facesContext.responseComplete();
	}

}
