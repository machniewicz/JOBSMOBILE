package br.com.jobs.modelo.enviado;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.oportunidade.Oportunidade;
import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class EnviadoRN {

	private EnviadoDAO enviadoDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();

	
	public EnviadoRN(){
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
		this.enviadoDAO = DAOFactory.criarEnviadoDAO();
	}

	public List<Enviado> listar(Oportunidade oportunidade) {
		return this.enviadoDAO.listar(oportunidade);
	}
	
	public List<Enviado> listarEnviado(Cadastro cadastro) {
		return this.enviadoDAO.listarEnviado(cadastro);
	}

	public void salvar(Enviado enviado) {
		Integer codigo = enviado.getEnviado_id();
		if(codigo == null || codigo == 0){
			try {
				this.enviadoDAO.salvar(enviado);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_enviado_incluir_sucesso"));
				
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_enviado_incluir_falha"));
			}
		}
		else{
			try {
				this.enviadoDAO.atualizar(enviado);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_enviado_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_enviado_atualizar_falha"));
			}
		}
	}
	
	public void excluir(Enviado enviado) {
		try {
			this.enviadoDAO.excluir(enviado);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_enviado_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_enviado_excluir_falha"));
		}
	}
	
	public Enviado carregar(Integer enviado) {
		return this.enviadoDAO.carregar(enviado);
	}
	
	public List<EnviadoGrafico> listarGrafico(Integer oportunidade) {
		return this.enviadoDAO.listaDadosGrafico(oportunidade);
	}
	
	

}
