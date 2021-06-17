package br.com.jobs.modelo.nivel;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class NivelRN {

	private NivelDAO nivelDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public NivelRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.nivelDAO = DAOFactory.criarNivelDAO();
	}

	public Nivel carregar(Integer codigo) {
		return this.nivelDAO.carregar(codigo);
	}

	
	public void salvar(Nivel nivel) {

		Integer codigo = nivel.getNivel_id();

		if (codigo == null || codigo == 0) {
			try {
				this.nivelDAO.salvar(nivel);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_nivel_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_nivel_incluir_falha"));
			}

		} else {
			try {
				this.nivelDAO.atualizar(nivel);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_nivel_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_nivel_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Nivel nivel) {
		try {
			this.nivelDAO.excluir(nivel);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_nivel_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_nivel_excluir_falha"));
		}

	}

	public List<Nivel> listarTodosNiveis() {
		return this.nivelDAO.listar();
	}

	public List<Nivel> listarTodosNiveisAtivos() {
		return this.nivelDAO.listarTodosAtivos();
	}

	
	public void ativarIdioma(Nivel nivel) {
		if (nivel.getNivel_status().equals(true)) {
			nivel.setNivel_status(false);
		} else {
			nivel.setNivel_status(true);
		}
	}
	
	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.nivelDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_nivel_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_nivel_status_ativo_0");
		}
		return descStatusTmp;
	}

}