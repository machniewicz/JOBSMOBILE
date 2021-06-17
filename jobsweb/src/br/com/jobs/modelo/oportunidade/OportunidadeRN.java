package br.com.jobs.modelo.oportunidade;

import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.jobs.modelo.empresa.Empresa;
import br.com.jobs.modelo.usuario.Usuario;
import br.com.jobs.modelo.usuario.UsuarioRN;
import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;


public class OportunidadeRN {

	private OportunidadeDAO	oportunidadeDAO;
	private ResourceBundle bundle = null;
	private Usuario usuarioLogado = null;
	private FacesUtil faces = new FacesUtil();
	
	public OportunidadeRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
		this.oportunidadeDAO = DAOFactory.criarOportunidadeDAO();
	}

	public List<Oportunidade> listar(Usuario usuario) {
		return this.oportunidadeDAO.listar(usuario);
	}

	public List<Oportunidade> listarTodos() {
		return this.oportunidadeDAO.listarTodos();
		
	}
	
	public Integer quantidadeAtivo(Empresa empresa){
		return this.oportunidadeDAO.quantidadeAtivo(empresa);
	}
	
	public void salvar(Oportunidade oportunidade) {
		Integer codigo = oportunidade.getOportunidade_id();
		if(codigo == null || codigo == 0){
			try {
				this.populaOportunidade(oportunidade);
				this.oportunidadeDAO.salvar(oportunidade);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_oportunidade_incluir_sucesso"));
				
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_oportunidade_incluir_falha"));
			}
			
		}
		else {
			try{
			this.oportunidadeDAO.atualizar(oportunidade);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_oportunidade_atualizar_sucesso"));
			} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_oportunidade_atualizar_falha"));
			}
		}
		
	}
	
	public void excluir(Oportunidade oportunidade) {
		try {
			this.oportunidadeDAO.excluir(oportunidade);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_oportunidade_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_oportunidade_excluir_falha"));
		}
	}
	
	public Oportunidade carregar(Integer oportunidade) {
		return this.oportunidadeDAO.carregar(oportunidade);
	}

	public Usuario buscarUsuario (){
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		if (this.usuarioLogado == null || !login.equals(this.usuarioLogado.getUsuario_login())) {

			if (login != null) {
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuarioLogado = usuarioRN.buscarPorLogin(login);
			}
		}
		return usuarioLogado;
	}
	
	public Date getPegaDataAtual() {
		Date data = new Date(System.currentTimeMillis());
		return data;
	}
	
	public void ativarOportunidade(Oportunidade oportunidade){
		if(oportunidade.getOportunidade_status().equals(true)){
			oportunidade.setOportunidade_status(false);
		}
		else{
			oportunidade.setOportunidade_status(true);
		}
	}
	
	public byte booleanToByte(boolean bool) {  
	    return (byte) (bool ? 1 : 0);  
	}
	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp; 
		String descStatusTmp = null;
		statusTmp = new Boolean(this.oportunidadeDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue()== true){
			 descStatusTmp =  bundle.getString("lbl_oportunidade_status_ativo_1");
		}
		else if (statusTmp.booleanValue() == false) {
			descStatusTmp =  bundle.getString("lbl_oportunidade_status_ativo_0");
		}
		return descStatusTmp;	
	}

	private void populaOportunidade(Oportunidade oportunidade){
		Date dataOportunidade = this.getPegaDataAtual();
		this.buscarUsuario();
		oportunidade.setEmpresa(usuarioLogado.getEmpresa());
		oportunidade.setOportunidade_data(dataOportunidade);
		oportunidade.setUsuario(usuarioLogado);
		
	}

}
