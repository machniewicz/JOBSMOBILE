package br.com.jobs.web.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.jobs.web.controle.ContextoMB;

public class ContextoUtil {

	public static ContextoMB getContextoBean() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		HttpSession session = (HttpSession) external.getSession(true);

		ContextoMB contextoBean = (ContextoMB) session.getAttribute("contextoBean");
		
		return contextoBean;
	}
}
