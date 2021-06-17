package br.com.jobs.modelo.email;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;


public class EmailRN {
	private EmailDAO emailDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();

	public EmailRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
		this.emailDAO = DAOFactory.criarEmailDAO();
	}

	public Email carregar(Integer email) {
		return this.emailDAO.carregar(email);
	}
	
	public List<Email> listarTodos(){
			return this.emailDAO.listarTodos();
	} 
	
	public Integer ListarQuantidade(){
		return this.emailDAO.listarTodos().size();
	}

	public void salvar(Email email) {
		Integer codigo = email.getEmail_id();
		if (codigo == null || codigo == 0) {
			try {
				Integer quantidade = ListarQuantidade();
				if(quantidade >= 1){
					FacesUtil.exibirMensagemErro(bundle.getString("msg_email_configuracao_mais"));
				}
				else{
					this.emailDAO.salvar(email);
					FacesUtil.exibirMensagemSucesso(bundle.getString("msg_email_incluir_sucesso"));
				}
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_email_incluir_falha"));
			}

		} else {
			try {
				this.emailDAO.atualizar(email);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_email_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_email_atualizar_falha"));
			}
		}
	}

	public void excluir(Email email) {
		try {
			this.emailDAO.excluir(email);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_email_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_email_excluir_falha"));
		}
	}


}
