package br.com.jobs.modelo.vaga;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class VagaRN {

	private VagaDAO vagaDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public VagaRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.vagaDAO = DAOFactory.criarVagaDAO();
	}

	public Vaga carregar(Integer codigo) {
		return this.vagaDAO.carregar(codigo);
	}

	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.vagaDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_vaga_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_vaga_status_ativo_0");
		}
		return descStatusTmp;
	}

	@SuppressWarnings("static-access")
	public void salvar(Vaga vaga) {

		Integer codigo = vaga.getVaga_id();

		if (codigo == null || codigo == 0) {
			try {
				this.vagaDAO.salvar(vaga);
				faces.exibirMensagemSucesso(bundle.getString("msg_vaga_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_vaga_incluir_falha"));
			}

		} else {
			try {
				this.vagaDAO.atualizar(vaga);
				faces.exibirMensagemSucesso(bundle
						.getString("msg_vaga_atualizar_sucesso"));
			} catch (Exception e) {
				faces.exibirMensagemErro(bundle
						.getString("msg_vaga_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Vaga vaga) {
		try {
			this.vagaDAO.excluir(vaga);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_vaga_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_vaga_excluir_falha"));
		}

	}

	public List<Vaga> listarTodosVaga() {
		return this.vagaDAO.listar();
	}
	
	public List<Vaga> listarTodosVagaAtivos() {
		return this.vagaDAO.listarTodosAtivos();
	}

	
	public void ativarVaga(Vaga vaga) {
		if (vaga.getVaga_status().equals(true)) {
			vaga.setVaga_status(false);
		} else {
			vaga.setVaga_status(true);
		}
	}

}