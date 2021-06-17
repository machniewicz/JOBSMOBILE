package br.com.jobs.modelo.idioma;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class IdiomaRN {

	private IdiomaDAO idiomaDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public IdiomaRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.idiomaDAO = DAOFactory.criarIdiomaDAO();
	}

	public Idioma carregar(Integer codigo) {
		return this.idiomaDAO.carregar(codigo);
	}

	
	public void salvar(Idioma idioma) {

		Integer codigo = idioma.getIdioma_id();

		if (codigo == null || codigo == 0) {
			try {
				this.idiomaDAO.salvar(idioma);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_idioma_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_idioma_incluir_falha"));
			}

		} else {
			try {
				this.idiomaDAO.atualizar(idioma);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_idioma_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_idioma_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Idioma idioma) {
		try {
			this.idiomaDAO.excluir(idioma);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_idoma_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_idioma_excluir_falha"));
		}

	}

	public List<Idioma> listarTodosIdiomas() {
		return this.idiomaDAO.listar();
	}

	public List<Idioma> listarTodosIdiomasAtivos() {
		return this.idiomaDAO.listarTodosAtivos();
	}

	
	public void ativarIdioma(Idioma idioma) {
		if (idioma.getIdioma_status().equals(true)) {
			idioma.setIdioma_status(false);
		} else {
			idioma.setIdioma_status(true);
		}
	}
	
	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.idiomaDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_idioma_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_idioma_status_ativo_0");
		}
		return descStatusTmp;
	}

}