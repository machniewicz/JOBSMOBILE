package br.com.jobs.modelo.financeiro;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class FinanceiroRN {

	private FinanceiroDAO financeiroDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public FinanceiroRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.financeiroDAO = DAOFactory.criarFinanceiroDAO();
	}

	public Financeiro carregar(Integer codigo) {
		return this.financeiroDAO.carregar(codigo);
	}

	public void salvar(Financeiro financeiro) {

		Integer codigo = financeiro.getFinanceiro_id();

		if (codigo == null || codigo == 0) {
			try {
				this.financeiroDAO.salvar(financeiro);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_financeiro_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_financeiro_incluir_falha"));
			}

		} else {
			try {
				this.financeiroDAO.atualizar(financeiro);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_financeiro_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_financeiro_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Financeiro financeiro) {
		try {
			this.financeiroDAO.excluir(financeiro);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_financeiro_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_financeiro_excluir_falha"));
		}

	}

	public List<Financeiro> listarTodosFinanceiros() {
		return this.financeiroDAO.listar();
	}
	
}