package br.com.jobs.modelo.funcao;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.modelo.categoria.Categoria;
import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class FuncaoRN {

	private FuncaoDAO funcaoDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public FuncaoRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.funcaoDAO = DAOFactory.criarFuncaoDAO();
	}

	public Funcao carregar(Integer codigo) {
		return this.funcaoDAO.carregar(codigo);
	}

	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.funcaoDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_funcao_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_funcao_status_ativo_0");
		}
		return descStatusTmp;
	}

	public void salvar(Funcao funcao) {

		Integer codigo = funcao.getFuncao_id();

		if (codigo == null || codigo == 0) {
			try {
				this.funcaoDAO.salvar(funcao);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_funcao_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_funcao_incluir_falha"));
			}

		} else {
			try {
				this.funcaoDAO.atualizar(funcao);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_funcao_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_funcao_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Funcao funcao) {
		try {
			this.funcaoDAO.excluir(funcao);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_funcao_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_funcao_excluir_falha"));
		}

	}

	public List<Funcao> listarTodasFuncoes() {
		return this.funcaoDAO.listar();
	}
	
	public List<Funcao> listarTodasFuncoesAtivos() {
		return this.funcaoDAO.listarTodosAtivos();
	}

	public List<Funcao> listarFuncaoPorCategoria(Categoria categoria){
		return this.funcaoDAO.listarTodosPorCategoria(categoria);
	}
	
	public void ativarFuncao(Funcao funcao) {
		if (funcao.getFuncao_status().equals(true)) {
			funcao.setFuncao_status(false);
		} else {
			funcao.setFuncao_status(true);
		}
	}

}