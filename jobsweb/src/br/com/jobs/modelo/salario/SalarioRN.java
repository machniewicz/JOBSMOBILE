package br.com.jobs.modelo.salario;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;


public class SalarioRN {
	private SalarioDAO salarioDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();

	public SalarioRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
		this.salarioDAO = DAOFactory.criarSalarioDAO();
	}

	public Salario carregar(Integer salario) {
		return this.salarioDAO.carregar(salario);
	}
	
	public List<Salario> listarTodos(){
			return this.salarioDAO.listarTodos();
	} 

	public List<Salario> listarTodosAtivos(){
		return this.salarioDAO.listarTodosAtivos();
	} 
	
	public void salvar(Salario salario) {
		Integer codigo = salario.getSalario_id();
		if (codigo == null || codigo == 0) {
			try {
				this.populaSalario(salario);
				this.salarioDAO.salvar(salario);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_salario_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_salario_incluir_falha"));
			}

		} else {
			try {
				this.salarioDAO.atualizar(salario);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_salario_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_salario_atualizar_falha"));
			}
		}
	}

	public void excluir(Salario salario) {
		try {
			this.salarioDAO.excluir(salario);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_salario_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_salario_excluir_falha"));
		}
	}

	public void populaSalario(Salario salario) {
		salario.setSalario_status(true);
	}
	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp; 
		String descStatusTmp = null;
		statusTmp = new Boolean(this.salarioDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true){
			descStatusTmp =  bundle.getString("lbl_salario_status_ativo_1");
		}
		else if (statusTmp.booleanValue() == false) {
			descStatusTmp =  bundle.getString("lbl_salario_status_ativo_0");
		}
		return descStatusTmp;	
	}
	
}
