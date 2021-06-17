package br.com.jobs.modelo.usuario;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.jobs.mail.MailSender;
import br.com.jobs.modelo.empresa.Empresa;
import br.com.jobs.modelo.perfil.Perfil;
import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;

public class UsuarioRN {

	private UsuarioDAO usuarioDAO;
	private ResourceBundle bundle = null;
	private Usuario usuarioLogado = null;
	private Empresa empresaLogada = null;
	private FacesUtil faces = new FacesUtil();
	private Usuario usuario = new Usuario();
	private MailSender mail = new MailSender();
	private List<Usuario> lista = null;

	public UsuarioRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}
	
	public Empresa getEmpresaLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		if (this.usuarioLogado == null || !login.equals(this.usuarioLogado.getUsuario_login())) {

			if (login != null) {
				this.usuarioLogado = this.buscarPorLogin(login);
			}
		}
		return usuarioLogado.getEmpresa();
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	public void setEmpresaLogada(Empresa empresaLogada) {
		this.empresaLogada = empresaLogada;
	}

	/*
	 * Metodo retorna um ArrayList POSIÇÃO[0] = ROLE_USUARIO POSIÇÃO[1] = PERFIL
	 */
	public ArrayList<String> carregarPerfil(Integer codigo) {
		ArrayList<String> listaPerfil = new ArrayList<String>();
		String roleTmp = null, perfilTmp = null;
		roleTmp = this.usuarioDAO.carregaPerfil(codigo);
		if (roleTmp.equals("ROLE_CLIENTE")) {
			perfilTmp = bundle.getString("lbl_usuario_perfil_cliente");
		} else if (roleTmp.equals("ROLE_ADMINISTRADOR")) {
			perfilTmp = bundle.getString("lbl_usuario_perfil_administrador");
		}
		else if (roleTmp.equals("ROLE_EMPRESA")){
			perfilTmp = bundle.getString("lbl_usuario_perfil_empresa");
		}
		listaPerfil.add(roleTmp);
		listaPerfil.add(perfilTmp);
		return listaPerfil;
	}

	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.usuarioDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_usuario_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_usuario_status_ativo_0");
		}
		return descStatusTmp;
	}
	
	public void salvar(Usuario usuario, Integer idPerfil, Integer opcao) {

		Integer codigo = usuario.getUsuario_id();

		if (codigo == null || codigo == 0) {
			try {
				switch (opcao) {
				case 1:
					this.populaUsuario(usuario, idPerfil);
					break;
				case 2:
					this.populaUsuarioEmpresa(usuario);
					break;
				default:
					break;
				}
				/*
				 * O método bucarUsuario retorna FALSE por padrão. Se encontrar o Login retorna TRUE e exibe mensagem de LOGIN JÁ EXISTENTE
				 */
				if (this.usuarioDAO.buscarUsuario(usuario.getUsuario_login())) {
					FacesUtil.exibirMensagemErro(bundle.getString("msg_usuario_incluir_falha_login"));
				} 
				else{
					this.usuarioDAO.salvar(usuario);
					FacesUtil.exibirMensagemSucesso(bundle.getString("msg_usuario_incluir_sucesso"));
				}
				
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_usuario_incluir_falha"));
			}

		} else {
			try {
				this.usuarioDAO.atualizar(usuario);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_usuario_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_usuario_atualizar_falha"));
			}
		}
	}

	public void alterarSenha(Usuario usuario, String novaSenha, String comparaSenha){
		if(!novaSenha.isEmpty() && !comparaSenha.isEmpty()){
			if(novaSenha.equals(comparaSenha)){
				usuario.setUsuario_senha(novaSenha);
				this.usuarioDAO.alterarSenha(usuario);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_trocar_senha_sucesso"));
			}
			else{
				FacesUtil.exibirMensagemErro(bundle.getString("msg_trocar_senha_incompativel"));
			}
		}
		else{
			FacesUtil.exibirMensagemErro(bundle.getString("msg_trocar_senha_vazia"));
		}
				
	}
	
	public void excluir(Usuario usuario) {
		try {
			this.usuarioDAO.excluir(usuario);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_usuario_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_usuario_excluir_falha"));
		}

	}

	public List<Usuario> listarPorEmpresa(Empresa empresa) {
		return this.usuarioDAO.listarPorEmpresa(empresa);
	}
	
	public List<Usuario> listarTodosUsuarios() {
		return this.usuarioDAO.listar();
	}

	public void populaUsuario(Usuario usuario, Integer perfilId) {
		Date dataInclusaoUsuario;
		ArrayList<Perfil> lista = new ArrayList<Perfil>();
		Perfil perfil = new Perfil();
		perfil.setPerfil_id(perfilId);
		lista.add(perfil);
		usuario.setPerfis(lista);
		usuario.setUsuario_status(true);
		dataInclusaoUsuario = this.getPegaDataAtual();
		usuario.setUsuario_dt_inclusao(dataInclusaoUsuario);
	}
	
	public void populaUsuarioEmpresa(Usuario usuario) {
		Date dataInclusaoUsuario;
		ArrayList<Perfil> lista = new ArrayList<Perfil>();
		Perfil perfil = new Perfil();
		String login_completo;
		perfil.setPerfil_id(2);
		lista.add(perfil);
		usuario.setPerfis(lista);
		usuario.setUsuario_status(true);
		dataInclusaoUsuario = this.getPegaDataAtual();
		usuario.setUsuario_dt_inclusao(dataInclusaoUsuario);
		empresaLogada = this.getEmpresaLogado();
		usuario.setEmpresa(empresaLogada);
		login_completo = usuario.getEmpresa().getEmpresa_alias() + "_" + usuario.getUsuario_login();
		usuario.setUsuario_login(login_completo);
	}


	public Date getPegaDataAtual() {
		Date data = new Date(System.currentTimeMillis());
		return data;
	}

	public void ativarUsuario(Usuario usuario) {
		if (usuario.getUsuario_status().equals(true)) {
			usuario.setUsuario_status(false);
		} else {
			usuario.setUsuario_status(true);
		}
	}

	public void recuperarSenha(String parametro, Integer opcao) {
		if(opcao.equals(null)){
			FacesUtil.exibirMensagemErro(bundle.getString("msg_usuario_recuperar_vazio"));
		}
		else{
				lista = this.usuarioDAO.recuperaSenha(parametro, opcao);
				if (lista.size()== 0){
					FacesUtil.exibirMensagemErro(bundle.getString("msg_usuario_recuperar_falha_0"));
				}else if (lista.size()>=2){
					FacesUtil.exibirMensagemErro(bundle.getString("msg_usuario_recuperar_falha_2"));
				}
				else{
					usuario = lista.get(0);
					mail.EnviarMail(usuario);
				}
		}
	}
}