package br.com.jobs.modelo.meta;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class MetaRN {

	private MetaDAO metaDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public MetaRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.metaDAO = DAOFactory.criarMetaDAO();
	}

	public Meta carregar(Integer codigo) {
		return this.metaDAO.carregar(codigo);
	}

	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.metaDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_meta_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_meta_status_ativo_0");
		}
		return descStatusTmp;
	}

	public void salvar(Meta meta) {

		Integer codigo = meta.getMeta_id();

		if (codigo == null || codigo == 0) {
			try {
				this.metaDAO.salvar(meta);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_meta_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_meta_incluir_falha"));
			}

		} else {
			try {
				this.metaDAO.atualizar(meta);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_meta_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_meta_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Meta meta) {
		try {
			this.metaDAO.excluir(meta);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_meta_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_meta_excluir_falha"));
		}

	}

	public List<Meta> listarTodosMetas() {
		return this.metaDAO.listar();
	}
	
	public List<Meta> listarTodosMetasAtivos() {
		return this.metaDAO.listarTodosAtivos();
	}

	
	public void ativarMeta(Meta meta) {
		if (meta.getMeta_status().equals(true)) {
			meta.setMeta_status(false);
		} else {
			meta.setMeta_status(true);
		}
	}
	
}