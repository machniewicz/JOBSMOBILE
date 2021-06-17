package br.com.jobs.modelo.beneficio;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class BeneficioRN {

	private BeneficioDAO beneficioDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public BeneficioRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.beneficioDAO = DAOFactory.criarBeneficioDAO();
	}

	public Beneficio carregar(Integer codigo) {
		return this.beneficioDAO.carregar(codigo);
	}

	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.beneficioDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_beneficio_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_beneficio_status_ativo_0");
		}
		return descStatusTmp;
	}

	public void salvar(Beneficio beneficio) {

		Integer codigo = beneficio.getBeneficio_id();

		if (codigo == null || codigo == 0) {
			try {
				this.beneficioDAO.salvar(beneficio);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_beneficio_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_beneficio_incluir_falha"));
			}

		} else {
			try {
				this.beneficioDAO.atualizar(beneficio);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_beneficio_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_beneficio_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Beneficio beneficio) {
		try {
			this.beneficioDAO.excluir(beneficio);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_beneficio_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_beneficio_excluir_falha"));
		}

	}

	public List<Beneficio> listarTodosBeneficios() {
		return this.beneficioDAO.listar();
	}
	
	public List<Beneficio> listarTodosBeneficiosAtivos() {
		return this.beneficioDAO.listarTodosAtivos();
	}

	
	public void ativarBeneficio(Beneficio beneficio) {
		if (beneficio.getBeneficio_status().equals(true)) {
			beneficio.setBeneficio_status(false);
		} else {
			beneficio.setBeneficio_status(true);
		}
	}
	
}