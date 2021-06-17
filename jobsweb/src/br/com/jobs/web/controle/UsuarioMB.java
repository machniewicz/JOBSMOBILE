package br.com.jobs.web.controle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.jobs.modelo.empresa.Empresa;
import br.com.jobs.modelo.oportunidade.OportunidadeRN;
import br.com.jobs.modelo.perfil.Perfil;
import br.com.jobs.modelo.perfil.PerfilDAOImpl;
import br.com.jobs.modelo.usuario.Usuario;
import br.com.jobs.modelo.usuario.UsuarioRN;
import br.com.jobs.relatorio.Relatorio;

@ManagedBean(name="usuarioMB")
@SessionScoped

public class UsuarioMB {

	private Usuario usuario;
	private Perfil perfil;
	private Empresa empresa;
	private Integer idPerfil;
	private Integer opcao;
	private UsuarioRN usuarioRN;
	private OportunidadeRN oportunidadeRN;
	private Integer pagina;
	private List<Usuario> lista;
	private String senhaTmp = null;
	private String senhaCompara = null;
		
	/*
	 * Construtor da Classe
	 */
	public UsuarioMB(){
		usuario = this.getUsuarioLogado();
	}
	
	public String usuarioConectado(){
		return usuario.getUsuario_descricao();
	}
	
	public Empresa empresaConectada(){
		return usuario.getEmpresa();
	}
	
	/**
	 * Inicia processo
	 */
	@PostConstruct
	public void init() {
			
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public Empresa getEmpresa(){
		return empresa;
	}
	
	public void setEmpresa(Empresa empresa){
		this.empresa = empresa;
	}
	
	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public void setUsuario(Usuario usuario) {
		this.setIdPerfil(usuario.getPerfis().get(0).getPerfil_id());
		this.usuario = usuario;
	}

	public List<SelectItem> getPerfis() {
		PerfilDAOImpl perfilImpl = new PerfilDAOImpl();
		List<Perfil> perfis = perfilImpl.listar();
		List<SelectItem> itens = new ArrayList<SelectItem>(perfis.size());
		for (Perfil p : perfis) {
			itens.add(new SelectItem(p.getPerfil_id(), p.getPerfil_descricao()));
		}

		return itens;
	}
	
	public Integer getOpcao() {
		return opcao;
	}

	public void setOpcao(Integer opcao) {
		this.opcao = opcao;
	}

	/*
	 * Navegação entre Páginas
	 * 
	 * Rules Navigation no faces-config.xml
	 */
	public String novoUsuario() {
		this.usuario  = new Usuario();
		this.setOpcao(1);
		return "incluir_usuario";
	}
	
	public String listarUsuario() {
		this.setPagina(3);
		return "listar_usuario";
	}

	public String gerenciarUsuario() {
		this.setPagina(2);
		return "gerenciar_usuario";
	}
		
	public String editarUsuario() {
		return "editar_usuario";
	}
	
	public String detalharUsuario() {
		return "detalhar_usuario";
	}
	
	public String novoUsuarioEmpresa(){
		this.usuario  = new Usuario();
		this.setOpcao(2);
		return "incluir_usuario_empresa";
	}
	
	public String administrarUsuarioEmpresa(){
		this.setPagina(5);
		this.setOpcao(2);
		return "administrar_usuario_empresa";
	}
	
	public String editarUsuarioEmpresa(){
		return "editar_usuario_empresa";
	}
	
	public String administrarUsuario(){
		this.setPagina(1);
		this.setOpcao(1);
		return "administrar_usuario";
	}
	
	public String trocarSenha(){
		this.setPagina(4);
		return "trocar_senha";
	}
	
	public String painelInfo(){
		return "painel_info";
	}
	
	public String voltarUsuario() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarUsuario();
			break;
		case 2:
			voltar = this.gerenciarUsuario();
			break;
		case 3:
			voltar = this.listarUsuario();
			break;
		case 4:
			voltar = this.painelInfo();
			break;
		case 5:
			voltar = this.administrarUsuarioEmpresa();
			break;
		default:
			break;
		}
		return voltar;
	}


	/*
	 * Metodos acesso banco de dados
	 * 
	 * OBS.: No XHTML deve usar:
	 *  ACTION quando o metodo retornar uma STRING ou navegar para outras páginas  
	 *  ACTIONLISTNER quando não retornar nada ou não navegar entre páginas.
	 */

	public void salvarUsuario() {
		usuarioRN = new UsuarioRN();
		usuarioRN.salvar(usuario, idPerfil, opcao);
		switch (opcao) {
		case 1:
			this.novoUsuario();
			break;
		case 2:
			this.novoUsuarioEmpresa();
			break;
		default:
			break;
		}
		
	}

	public List<Usuario> listarTodosUsuarios() {
		usuarioRN = new UsuarioRN();
		lista = usuarioRN.listarTodosUsuarios();
		return lista;
	}
	
	public List<Usuario> administrarTodosUsuariosPorEmpresa() {
		usuarioRN = new UsuarioRN();
		empresa = this.getUsuarioLogado().getEmpresa();
		lista = usuarioRN.listarPorEmpresa(empresa);
		return lista;
	}
	
	public List<Usuario> gerenciarTodosUsuarios() {
		usuarioRN = new UsuarioRN();
		lista = usuarioRN.listarTodosUsuarios();
		return lista;
	}
	
	public List<Usuario> administrarTodosUsuarios(){
		usuarioRN = new UsuarioRN();
		lista = usuarioRN.listarTodosUsuarios();
		return lista;
	}
	
	public String atualizarUsuario(){
		usuarioRN = new UsuarioRN();
		String retorno = null;
		if (!this.getSenhaTmp().isEmpty()){
			usuario.setUsuario_senha(senhaTmp);
		}
		usuarioRN.salvar(usuario, idPerfil, opcao);
		switch (opcao) {
		case 1:
			 retorno = this.administrarUsuario();
			 break;
		case 2:
			retorno = this.administrarUsuarioEmpresa();
			break;
		default:
			break;
		}
	return retorno;
	}
	
	public void alterarSenhaUsuario(){
		usuarioRN = new UsuarioRN();
		usuarioRN.alterarSenha(usuario, this.getSenhaTmp(), this.getSenhaCompara());
	}
	
	public String excluirUsuario(){
		usuarioRN = new UsuarioRN();
		usuario = usuarioRN.carregar(usuario.getUsuario_id());
		usuarioRN.excluir(usuario);
		return this.administrarUsuario();
	}
	
	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		if (this.usuario == null || !login.equals(this.usuario.getUsuario_login())) {

			if (login != null) {
				usuarioRN = new UsuarioRN();
				this.usuario = usuarioRN.buscarPorLogin(login);
			}
		}
		return usuario;
	}

	public String dataAtual() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(new Date());
	}

	public String getDataHoje(){
		DateFormat dfmt = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
		Date hoje = Calendar.getInstance(Locale.getDefault()).getTime();
		return dfmt.format(hoje);	 
	}

	public void ativarUsuario(){
		usuarioRN = new UsuarioRN();
		usuarioRN.ativarUsuario(usuario);
	}
	
	public String carregaPerfilUsuario(int elemento){
		usuarioRN = new UsuarioRN();
		return usuarioRN.carregarPerfil(usuario.getUsuario_id()).get(elemento);
	}
	
	public String carregaStatusUsuario(){
		usuarioRN = new UsuarioRN();
		return usuarioRN.carregarStatus(usuario.getUsuario_id());
	}
	
	public String carregaAliasEmpresa(){
		usuarioRN = new UsuarioRN();
		return usuarioRN.getEmpresaLogado().getEmpresa_alias();
	}
	
	/*
	 * Seta quantidade de Oportunidade cadastradas pela empresa logada
	 */
	public Integer quantidadeAtivo(){
		oportunidadeRN = new OportunidadeRN();
		int sobra = (usuario.getEmpresa().getEmpresa_quantidade() - oportunidadeRN.quantidadeAtivo(usuario.getEmpresa()));
		return sobra;
	}
		
	public void imprimirRelatorio(){
		Relatorio relatorio = new Relatorio();
		try {
			relatorio.imprimir(this.listarTodosUsuarios());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Caiu no catch..........................................");
			e.printStackTrace();
		}
	}

	public String getSenhaTmp() {
		return senhaTmp;
	}

	public void setSenhaTmp(String senhaTmp) {
		this.senhaTmp = senhaTmp;
	}

	public String getSenhaCompara() {
		return senhaCompara;
	}

	public void setSenhaCompara(String senhaCompara) {
		this.senhaCompara = senhaCompara;
	}  
	
	
}