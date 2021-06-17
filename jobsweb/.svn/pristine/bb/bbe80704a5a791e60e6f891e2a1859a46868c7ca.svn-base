package br.com.jobs.modelo.escolaridade;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;


public class EscolaridadeRN {
	private EscolaridadeDAO escolaridadeDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();

	public EscolaridadeRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
		this.escolaridadeDAO = DAOFactory.criarEscolaridadeDAO();
	}

	public Escolaridade carregar(Integer escolaridade) {
		return this.escolaridadeDAO.carregar(escolaridade);
	}
	
	public List<Escolaridade> listarTodos(){
			return this.escolaridadeDAO.listarTodos();
	} 

	public void salvar(Escolaridade escolaridade) {
		Integer codigo = escolaridade.getEscolaridade_id();
		if (codigo == null || codigo == 0) {
			try {
				this.escolaridadeDAO.salvar(escolaridade);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_escolaridade_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_escolaridade_incluir_falha"));
			}

		} else {
			try {
				this.escolaridadeDAO.atualizar(escolaridade);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_escolaridade_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_escolaridade_atualizar_falha"));
			}
		}
	}

	public void excluir(Escolaridade escolaridade) {
		try {
			this.escolaridadeDAO.excluir(escolaridade);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_escolaridade_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_escolaridade_excluir_falha"));
		}
	}
	
}
