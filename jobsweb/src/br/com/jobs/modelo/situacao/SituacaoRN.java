package br.com.jobs.modelo.situacao;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;


public class SituacaoRN {
	private SituacaoDAO situacaoDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();

	public SituacaoRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
		this.situacaoDAO = DAOFactory.criarSituacaoDAO();
	}

	public Situacao carregar(Integer situacao) {
		return this.situacaoDAO.carregar(situacao);
	}
	
	public List<Situacao> listarTodos(){
			return this.situacaoDAO.listarTodos();
	} 

	public List<Situacao> listarTodosAtivos(){
		return this.situacaoDAO.listarTodosAtivos();
	} 
	
	public void salvar(Situacao situacao) {
		Integer codigo = situacao.getSituacao_id();
		if (codigo == null || codigo == 0) {
			try {
				this.populaSituacao(situacao);
				this.situacaoDAO.salvar(situacao);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_situacao_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_situacao_incluir_falha"));
			}

		} else {
			try {
				this.situacaoDAO.atualizar(situacao);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_situacao_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_situacao_atualizar_falha"));
			}
		}
	}

	public void excluir(Situacao situacao) {
		try {
			this.situacaoDAO.excluir(situacao);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_situacao_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_situacao_excluir_falha"));
		}
	}

	public void populaSituacao(Situacao situacao) {
		situacao.setSituacao_status(true);
	}
	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp; 
		String descStatusTmp = null;
		statusTmp = new Boolean(this.situacaoDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true){
			descStatusTmp =  bundle.getString("lbl_situacao_status_ativo_1");
		}
		else if (statusTmp.booleanValue() == false) {
			descStatusTmp =  bundle.getString("lbl_situacao_status_ativo_0");
		}
		return descStatusTmp;	
	}
	
}
