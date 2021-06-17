package br.com.jobs.combinacao.software;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class Combinacao_SoftwareRN {

	private Combinacao_SoftwareDAO combinacaoSoftwareDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public Combinacao_SoftwareRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.combinacaoSoftwareDAO = DAOFactory.criarCombinacaoSoftwareDAO();
	}

	public Combinacao_Software carregar(Integer codigo) {
		return this.combinacaoSoftwareDAO.carregar(codigo);
	}

	
	public void salvar(Combinacao_Software combinacaoSoftware) {

		Integer codigo = combinacaoSoftware.getCombinacao_software_id();

		if (codigo == null || codigo == 0) {
			try {
				this.combinacaoSoftwareDAO.salvar(combinacaoSoftware);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_combinacao_software_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_combinacao_software_incluir_falha"));
			}

		} else {
			try {
				this.combinacaoSoftwareDAO.atualizar(combinacaoSoftware);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_combinacao_software_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_combinacao_software_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Combinacao_Software combinacaoSoftware) {
		try {
			this.combinacaoSoftwareDAO.excluir(combinacaoSoftware);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_combinacao_software_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_combinacao_software_excluir_falha"));
		}

	}

	public List<Combinacao_Software> listarTodos() {
		return this.combinacaoSoftwareDAO.listarTodos();
	}
	
	public List<Combinacao_Software> listarTodosAtivos() {
		return this.combinacaoSoftwareDAO.listarTodosAtivos();
	}
	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.combinacaoSoftwareDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_combinacao_software_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_combinacao_software_status_ativo_0");
		}
		return descStatusTmp;
	}
	
}