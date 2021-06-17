package br.com.jobs.modelo.faturamento;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class FaturamentoRN {

	private FaturamentoDAO faturamentoDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public FaturamentoRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.faturamentoDAO = DAOFactory.criarFaturamentoDAO();
	}

	public Faturamento carregar(Integer codigo) {
		return this.faturamentoDAO.carregar(codigo);
	}

	public void salvar(Faturamento faturamento) {

		Integer codigo = faturamento.getFaturamento_id();

		if (codigo == null || codigo == 0) {
			try {
				this.faturamentoDAO.salvar(faturamento);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_faturamento_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_faturamento_incluir_falha"));
			}

		} else {
			try {
				this.faturamentoDAO.atualizar(faturamento);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_faturamento_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_faturamento_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Faturamento faturamento) {
		try {
			this.faturamentoDAO.excluir(faturamento);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_faturamento_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_faturamento_excluir_falha"));
		}

	}

	public List<Faturamento> listarTodosFaturamentos() {
		return this.faturamentoDAO.listar();
	}
	
}