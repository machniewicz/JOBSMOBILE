package br.com.jobs.web.seguranca;

import java.util.ResourceBundle;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;

import br.com.jobs.web.util.FacesUtil;

/**
 * PhaseListener utilizado para capturar exceções de autenticação
 *
 */
@SuppressWarnings({"serial"})
public class LoginErrorPhaseListener implements PhaseListener {

	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil(); 
	
	@Override
	public void afterPhase(PhaseEvent arg0) {
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public void beforePhase(PhaseEvent arg0) {
	
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
		
		Exception dadosIncorretosException = (Exception) FacesUtil.getSessionMap().get(WebAttributes.AUTHENTICATION_EXCEPTION);
		if(dadosIncorretosException instanceof BadCredentialsException) {
			FacesUtil.getSessionMap().put(WebAttributes.AUTHENTICATION_EXCEPTION, null);
			FacesUtil.exibirMensagemErro(bundle.getString("msg_login_usuario"));
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

}
