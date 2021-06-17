package br.com.jobs.combinacao.ajudadecusto;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class Combinacao_AjudaDeCustoRN {
	
	private Combinacao_AjudaDeCustoDAO combinacaoAjudaDeCustoDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public Combinacao_AjudaDeCustoRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.combinacaoAjudaDeCustoDAO = DAOFactory.criarCombinacaoAjudaDeCustoDAO();
	}

	public Combinacao_AjudaDeCusto carregar(Integer codigo) {
		return this.combinacaoAjudaDeCustoDAO.carregar(codigo);
	}

	
	public void salvar(Combinacao_AjudaDeCusto combinacaoAjudadecusto) {

		Integer codigo = combinacaoAjudadecusto.getCombinacao_ajudadecusto_id();

		if (codigo == null || codigo == 0) {
			try {
				this.combinacaoAjudaDeCustoDAO.salvar(combinacaoAjudadecusto);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_combinacao_ajuda_de_custo_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_combinacao_ajuda_de_custo_incluir_falha"));
			}

		} else {
			try {
				this.combinacaoAjudaDeCustoDAO.atualizar(combinacaoAjudadecusto);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_combinacao_ajuda_de_custo_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_combinacao_ajuda_de_custo_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Combinacao_AjudaDeCusto combinacaoAjudadecusto) {
		try {
			this.combinacaoAjudaDeCustoDAO.excluir(combinacaoAjudadecusto);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_combinacao_ajuda_de_custo_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_combinacao_ajuda_de_custo_excluir_falha"));
		}

	}

	public List<Combinacao_AjudaDeCusto> listarTodos() {
		return this.combinacaoAjudaDeCustoDAO.listarTodos();
	}
	

}
