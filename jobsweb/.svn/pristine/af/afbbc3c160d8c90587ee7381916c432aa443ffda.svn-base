package br.com.jobs.web.controle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.jobs.modelo.usuario.Usuario;
import br.com.jobs.modelo.usuario.UsuarioRN;

@ManagedBean(name = "contextoMB")
@SessionScoped
public class ContextoMB {

	private Usuario usuarioLogado = null;

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		if (this.usuarioLogado == null || !login.equals(this.usuarioLogado.getUsuario_login())) {

			if (login != null) {
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuarioLogado = usuarioRN.buscarPorLogin(login);
			}
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;
	}
	
	public String getDataHoje(){
		DateFormat dfmt = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
		Date hoje = Calendar.getInstance(Locale.getDefault()).getTime();
		return dfmt.format(hoje);	 
	}
	
	public String voltarPrincipal() {
		return "voltar_inicio";
	}
}
