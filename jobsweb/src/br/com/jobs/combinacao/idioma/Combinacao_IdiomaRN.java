package br.com.jobs.combinacao.idioma;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class Combinacao_IdiomaRN {

	private Combinacao_IdiomaDAO combinacaoIdiomaDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public Combinacao_IdiomaRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.combinacaoIdiomaDAO = DAOFactory.criarCombinacaoIdiomaDAO();
	}

	public Combinacao_Idioma carregar(Integer codigo) {
		return this.combinacaoIdiomaDAO.carregar(codigo);
	}

	
	public void salvar(Combinacao_Idioma combinacaoIdioma) {

		Integer codigo = combinacaoIdioma.getCombinacao_idioma_id();

		if (codigo == null || codigo == 0) {
			try {
				this.combinacaoIdiomaDAO.salvar(combinacaoIdioma);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_combinacao_idioma_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_combinacao_idioma_incluir_falha"));
			}

		} else {
			try {
				this.combinacaoIdiomaDAO.atualizar(combinacaoIdioma);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_combinacao_idioma_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_combinacao_idioma_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Combinacao_Idioma combinacaoIdioma) {
		try {
			this.combinacaoIdiomaDAO.excluir(combinacaoIdioma);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_combinacao_idoma_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_combinacao_idioma_excluir_falha"));
		}

	}

	public List<Combinacao_Idioma> listarTodos() {
		return this.combinacaoIdiomaDAO.listarTodos();
	}
	
	public List<Combinacao_Idioma> listarTodosAtivos() {
		return this.combinacaoIdiomaDAO.listarTodosAtivos();
	}
	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.combinacaoIdiomaDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_combinacao_idioma_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_combinacao_idioma_status_ativo_0");
		}
		return descStatusTmp;
	}
	
	
}