package br.com.jobs.modelo.formacao;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;


public class FormacaoRN {
	private FormacaoDAO formacaoDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();

	public FormacaoRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
		this.formacaoDAO = DAOFactory.criarFormacaoDAO();
	}

	public Formacao carregar(Integer formacao) {
		return this.formacaoDAO.carregar(formacao);
	}
	
	public List<Formacao> listarTodos(){
			return this.formacaoDAO.listarTodos();
	} 

	public List<Formacao> listarTodosAtivos(){
		return this.formacaoDAO.listarTodosAtivos();
	} 
	
	public void salvar(Formacao formacao) {
		Integer codigo = formacao.getFormacao_id();
		if (codigo == null || codigo == 0) {
			try {
				this.populaFormacao(formacao);
				this.formacaoDAO.salvar(formacao);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_formacao_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_formacao_incluir_falha"));
			}

		} else {
			try {
				this.formacaoDAO.atualizar(formacao);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_formacao_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_formacao_atualizar_falha"));
			}
		}
	}

	public void excluir(Formacao formacao) {
		try {
			this.formacaoDAO.excluir(formacao);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_formacao_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_formacao_excluir_falha"));
		}
	}

	public void populaFormacao(Formacao formacao) {
		formacao.setFormacao_status(true);
	}
	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp; 
		String descStatusTmp = null;
		statusTmp = new Boolean(this.formacaoDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true){
			descStatusTmp =  bundle.getString("lbl_formacao_status_ativo_1");
		}
		else if (statusTmp.booleanValue() == false) {
			descStatusTmp =  bundle.getString("lbl_formacao_status_ativo_0");
		}
		return descStatusTmp;	
	}
	
}
