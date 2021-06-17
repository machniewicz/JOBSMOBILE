package br.com.jobs.modelo.ajudadecusto;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class AjudaDeCustoRN {

	private AjudaDeCustoDAO ajudadecustoDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public AjudaDeCustoRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.ajudadecustoDAO = DAOFactory.criarAjudaDeCustoDAO();
	}

	public AjudaDeCusto carregar(Integer codigo) {
		return this.ajudadecustoDAO.carregar(codigo);
	}

	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.ajudadecustoDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_ajudadecusto_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_ajudadecusto_status_ativo_0");
		}
		return descStatusTmp;
	}

	public void salvar(AjudaDeCusto ajuda) {

		Integer codigo = ajuda.getAjudadecusto_id();

		if (codigo == null || codigo == 0) {
			try {
				this.ajudadecustoDAO.salvar(ajuda);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_ajudadecusto_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_ajudadecusto_incluir_falha"));
			}

		} else {
			try {
				this.ajudadecustoDAO.atualizar(ajuda);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_ajudadecusto_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_ajudadecusto_atualizar_falha"));
			}
		}
	}
	
	public void excluir(AjudaDeCusto ajuda) {
		try {
			this.ajudadecustoDAO.excluir(ajuda);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_ajudadecusto_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_ajudadecusto_excluir_falha"));
		}

	}

	public List<AjudaDeCusto> listarTodasAjudasDeCusto() {
		return this.ajudadecustoDAO.listar();
	}
	
	public List<AjudaDeCusto> listarTodasAjudasDeCustoAtivos() {
		return this.ajudadecustoDAO.listarTodosAtivos();
	}

	
	public void ativarAjudaDeCusto(AjudaDeCusto ajuda) {
		if (ajuda.getAjudadecusto_status().equals(true)) {
			ajuda.setAjudadecusto_status(false);
		} else {
			ajuda.setAjudadecusto_status(true);
		}
	}

}
