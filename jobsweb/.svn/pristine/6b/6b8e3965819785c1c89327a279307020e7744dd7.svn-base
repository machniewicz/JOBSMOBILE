package br.com.jobs.modelo.empresa;

import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class EmpresaRN {

	private EmpresaDAO empresaDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public EmpresaRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.empresaDAO = DAOFactory.criarEmpresaDAO();
	}

	public Empresa carregar(Integer codigo) {
	
		return this.empresaDAO.carregar(codigo);
	}

	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.empresaDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_empresa_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_empresa_status_ativo_0");
		}
		return descStatusTmp;
	}

	public void salvar(Empresa empresa) {

		Integer codigo = empresa.getEmpresa_id();

		if (codigo == null || codigo == 0) {
			try {
				this.populaEmpresa(empresa);
				this.empresaDAO.salvar(empresa);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_empresa_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_empresa_incluir_falha"));
			}

		} else {
			try {
				this.empresaDAO.atualizar(empresa);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_empresa_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_empresa_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Empresa empresa) {
		try {
			this.empresaDAO.excluir(empresa);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_empresa_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_empresa_excluir_falha"));
		}

	}

	public List<Empresa> listarTodasEmpresas() {
		return this.empresaDAO.listar();
	}
	
	public List<Empresa> listarTodasEmpresasAtivas() {
		return this.empresaDAO.listarEmpresasAtivasValida();
	}

	public void populaEmpresa(Empresa empresa) {
		Date dataInclusaoEmpresa;
		empresa.setEmpresa_status(true);
		dataInclusaoEmpresa = this.getPegaDataAtual();
		empresa.setEmpresa_dt_inclusao(dataInclusaoEmpresa);
	}

	public Date getPegaDataAtual() {
		Date data = new Date(System.currentTimeMillis());
		return data;
	}

	public void ativarEmpresa(Empresa empresa) {
		if (empresa.getEmpresa_status().equals(true)) {
			empresa.setEmpresa_status(false);
		} else {
			empresa.setEmpresa_status(true);
		}
	}

}