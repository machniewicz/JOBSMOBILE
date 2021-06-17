package br.com.jobs.modelo.comissao;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class ComissaoRN {
	
	private ComissaoDAO comissaoDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public ComissaoRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.comissaoDAO = DAOFactory.criarComissaoDAO();
	}

	public Comissao carregar(Integer codigo) {
		return this.comissaoDAO.carregar(codigo);
	}

	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.comissaoDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_comissao_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_comissao_status_ativo_0");
		}
		return descStatusTmp;
	}

	public void salvar(Comissao comissao) {

		Integer codigo = comissao.getComissao_id();

		if (codigo == null || codigo == 0) {
			try {
				this.comissaoDAO.salvar(comissao);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_comissao_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_comissao_incluir_falha"));
			}

		} else {
			try {
				this.comissaoDAO.atualizar(comissao);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_comissao_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_comissao_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Comissao comissao) {
		try {
			this.comissaoDAO.excluir(comissao);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_comissao_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_comissao_excluir_falha"));
		}

	}

	public List<Comissao> listarTodasComissoes() {
		return this.comissaoDAO.listar();
	}
	
	public List<Comissao> listarTodasComissoesAtivos() {
		return this.comissaoDAO.listarTodosAtivos();
	}

	
	public void ativarComissao(Comissao comissao) {
		if (comissao.getComissao_status().equals(true)) {
			comissao.setComissao_status(false);
		} else {
			comissao.setComissao_status(true);
		}
	}


}
