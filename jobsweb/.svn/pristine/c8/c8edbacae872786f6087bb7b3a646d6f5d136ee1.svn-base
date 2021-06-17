package br.com.jobs.modelo.software;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class SoftwareRN {

	private SoftwareDAO softwareDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public SoftwareRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.softwareDAO = DAOFactory.criarSoftwareDAO();
	}

	public Software carregar(Integer codigo) {
		return this.softwareDAO.carregar(codigo);
	}

	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.softwareDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_software_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_software_status_ativo_0");
		}
		return descStatusTmp;
	}

	public void salvar(Software software) {

		Integer codigo = software.getSoftware_id();

		if (codigo == null || codigo == 0) {
			try {
				this.softwareDAO.salvar(software);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_software_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_software_incluir_falha"));
			}

		} else {
			try {
				this.softwareDAO.atualizar(software);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_software_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_software_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Software software) {
		try {
			this.softwareDAO.excluir(software);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_software_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_software_excluir_falha"));
		}

	}

	public List<Software> listarTodosSoftwares() {
		return this.softwareDAO.listar();
	}
	
	public List<Software> listarTodosSoftwaresAtivos() {
		return this.softwareDAO.listarTodosAtivos();
	}

	
	public void ativarSoftware(Software software) {
		if (software.getSoftware_status().equals(true)) {
			software.setSoftware_status(false);
		} else {
			software.setSoftware_status(true);
		}
	}

}