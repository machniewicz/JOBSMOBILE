package br.com.jobs.modelo.pagamento;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class PagamentoRN {

	private PagamentoDAO pagamentoDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public PagamentoRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.pagamentoDAO = DAOFactory.criarPagamentoDAO();
	}

	public Pagamento carregar(Integer codigo) {
		return this.pagamentoDAO.carregar(codigo);
	}

	
	public void salvar(Pagamento pagamento) {

		Integer codigo = pagamento.getPagamento_id();

		if (codigo == null || codigo == 0) {
			try {
				this.pagamentoDAO.salvar(pagamento);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_pagamento_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_pagamento_incluir_falha"));
			}

		} else {
			try {
				this.pagamentoDAO.atualizar(pagamento);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_pagamento_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_pagamento_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Pagamento pagamento) {
		try {
			this.pagamentoDAO.excluir(pagamento);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_pagamento_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_pagamento_excluir_falha"));
		}

	}

	public List<Pagamento> listarTodosPagamentos() {
		return this.pagamentoDAO.listar();
	}
	
}