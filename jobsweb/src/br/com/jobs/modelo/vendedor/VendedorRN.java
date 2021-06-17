package br.com.jobs.modelo.vendedor;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class VendedorRN {

	private VendedorDAO vendedorDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	

	public VendedorRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.vendedorDAO = DAOFactory.criarVendedorDAO();
	}

	public Vendedor carregar(Integer codigo) {
		return this.vendedorDAO.carregar(codigo);
	}

	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.vendedorDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_vendedor_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_vendedor_status_ativo_0");
		}
		return descStatusTmp;
	}

	public void salvar(Vendedor vendedor) {

		Integer codigo = vendedor.getVendedor_id();

		if (codigo == null || codigo == 0) {
			try {
				this.vendedorDAO.salvar(vendedor);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_vendedor_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_vendedor_incluir_falha"));
			}

		} else {
			try {
				this.vendedorDAO.atualizar(vendedor);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_vendedor_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_vendedor_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Vendedor vendedor) {
		try {
			this.vendedorDAO.excluir(vendedor);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_vendedor_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_vendedor_excluir_falha"));
		}

	}

	public List<Vendedor> listarTodosVendedores() {
		return this.vendedorDAO.listar();
	}
	
	public List<Vendedor> listarTodosVendedoresAtivos() {
		return this.vendedorDAO.listarTodosAtivos();
	}

	
	public void ativarVendedor(Vendedor vendedor) {
		if (vendedor.getVendedor_status().equals(true)) {
			vendedor.setVendedor_status(false);
		} else {
			vendedor.setVendedor_status(true);
		}
	}
	
}