package br.com.jobs.web.controle;

import java.util.ResourceBundle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.cadastro.CadastroRN;
import br.com.jobs.modelo.perfil.Perfil;
import br.com.jobs.modelo.usuario.Usuario;
import br.com.jobs.modelo.usuario.UsuarioRN;
import br.com.jobs.web.util.FacesUtil;

@ManagedBean(name="loginMB")
@SessionScoped
public class LoginMB {
	
	private Integer opcao;
	private Integer opcaoTipo;
	private String parametro;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	
	private String retornoInfo;
	
	private Integer tipoLogin;
	
	private Usuario usuario;
	private Cadastro cadastro;
	
	private UsuarioRN usuarioRN;
	private CadastroRN cadastroRN;
	
	private Perfil perfil;
	private MenuModel model;
	private Integer idPerfil;
	
	private String sair = "/j_spring_security_logout";;
	
	public LoginMB() {	
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
	}

	// Get e Set para menu
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.setIdPerfil(usuario.getPerfis().get(0).getPerfil_id());
		this.usuario = usuario;
	}
	
	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.setIdPerfil(cadastro.getPerfis().get(0).getPerfil_id());
		this.cadastro = cadastro;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	} 
	
	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	public Integer getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(Integer tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

	public String recuperarSenha() {
		return "recuperar_senha";
	}

	public String voltarLogin() {
		return "voltar";
	}
	
	public String loginEmpresa() {
		this.setTipoLogin(2);
		return "login";
	}
	
	public String loginCandidato() {
		this.setTipoLogin(1);
		return "login";
	}
		
	public String logar() {
		try {
		    RequestDispatcher dispatcher = FacesUtil.getServletRequest().getRequestDispatcher("/j_spring_security_check");
		    dispatcher.forward(FacesUtil.getServletRequest(), FacesUtil.getServletResponse());
		    FacesContext.getCurrentInstance().responseComplete();
		    String login = this.LoginAutenticado();
		    if(login.contains(".")){
		    	this.montaMenuBarCandidato(cadastro);
		    	retornoInfo = "/paginas/templates/infoUsuario.xhtml";
		    }
		    else if (!login.contains(".")){
		    	this.montaMenuBarUsuario(usuario);
		    	retornoInfo = "/paginas/templates/info.xhtml";
		    }
		} catch (Exception ex) {
			FacesUtil.exibirMensagemErro(ex.getMessage());
			return null;
		}
	    return null;
	}
	
	public String logout() {
		FacesUtil.exibirMensagemAlerta(bundle.getString("msg_finaliza_sessao_sucesso"));
		try {
			RequestDispatcher dispatcher = FacesUtil.getServletRequest().getRequestDispatcher("/j_spring_security_logout");
			dispatcher.forward(FacesUtil.getServletRequest(), FacesUtil.getServletResponse());
			FacesContext.getCurrentInstance().responseComplete();
		} catch (Exception ex) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_finaliza_sessao_falha"));
			return null;
		}
		return null;
	}
	
	public void recuperaSenha(){
		if(opcaoTipo==0){
				UsuarioRN usuarioRN = new UsuarioRN();
				usuarioRN.recuperarSenha(this.getParametro(), this.getOpcao());
		}else if (opcaoTipo==1){
			CadastroRN cadastroRN = new CadastroRN();
			cadastroRN.recuperarSenha(this.getParametro(), this.getOpcao());
		}
	}

	public Integer getOpcao() {
		return opcao;
	}

	public void setOpcao(Integer opcao) {
		this.opcao = opcao;
	}

	public Integer getOpcaoTipo() {
		return opcaoTipo;
	}

	public void setOpcaoTipo(Integer opcaoTipo) {
		this.opcaoTipo = opcaoTipo;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	public String getRetornoInfo() {
		return retornoInfo;
	}

	public void setRetornoInfo(String retornoInfo) {
		this.retornoInfo = retornoInfo;
	}

	public String LoginAutenticado(){
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		return external.getRemoteUser();
	}
	
	public Usuario getUsuarioLogado() {
		String login = this.LoginAutenticado();
		if (this.usuario == null || !login.equals(this.usuario.getUsuario_login())) {
			if (login != null) {
				usuarioRN = new UsuarioRN();
				this.usuario = usuarioRN.buscarPorLogin(login);
			}
		}
		return usuario;
	}
	
	public Cadastro getCadastroLogado() {
		String login = this.LoginAutenticado();
		if (this.cadastro == null || !login.equals(this.cadastro.getCadastro_cpf())) {
			if (login != null) {
				cadastroRN = new CadastroRN();
				this.cadastro = cadastroRN.buscarPorLogin(login);
			}
		}
		return cadastro;
	}
	
	public String carregaPerfilUsuario(int elemento){
		usuarioRN = new UsuarioRN();
		return usuarioRN.carregarPerfil(usuario.getUsuario_id()).get(elemento);
	}
	
	public String carregaPerfilCadastro(int elemento){
		cadastroRN = new CadastroRN();
		return cadastroRN.carregarPerfil(cadastro.getCadastro_id()).get(elemento);
	}
	
	/*
	 *  Monta Menu com base no perfil do Cadastro/Convidado logado 
	 */
		
	public MenuModel montaMenuCadastro(Cadastro cadastro) {  
        
		String perfilTmp = null;
		cadastro = this.getCadastroLogado();
		perfilTmp = this.carregaPerfilCadastro(0);
		model = new DefaultMenuModel();  
        DefaultMenuItem item;  
        
        DefaultSubMenu subMenu = new DefaultSubMenu(bundle.getString("lbl_menu_principal"));  

        if (perfilTmp.equals("ROLE_CONVIDADO")){
        	/*
             * Menu Op��es - Cadastro --> Somente ROLE_CONVIDADO
             */

        	item = new DefaultMenuItem(bundle.getString("lbl_menu_alterar_cadastro"));  
            item.setIcon(bundle.getString("icon_cadastro"));  
            item.setCommand("#{cadastroMB.editarCadastro}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_candidatura_cadastro"));  
            item.setIcon(bundle.getString("icon_cadastro"));  
            item.setCommand("#{cadastroMB.editarCadastro}");
            item.setAjax(false);
            subMenu.addElement(item);
       
            item = new DefaultMenuItem(bundle.getString("lbl_menu_sair"));  
            item.setIcon(bundle.getString("icon_sair"));
            item.setUrl(sair);
            item.setAjax(true); 
            subMenu.addElement(item);  
		}        
        model.addElement(subMenu);
        
        return model;
    }

	/*
	 *  Monta Menu com base no perfil do usuario logado 
	 */
		
	public MenuModel montaMenuUsuario(Usuario usuario) {  
        
		String perfilTmp = null;
		usuario = this.getUsuarioLogado();
		perfilTmp = this.carregaPerfilUsuario(0);
		model = new DefaultMenuModel();  
        DefaultMenuItem item;  
        
        DefaultSubMenu subMenu = new DefaultSubMenu(bundle.getString("lbl_menu_principal"));  

        if (perfilTmp.equals("ROLE_ADMINISTRADOR")){
        	/*
             * Menu Op��es - Usu�rios --> Somente ROLE_ADMINISTRADOR
             */
                      
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_usuario"));  
            item.setIcon(bundle.getString("icon_usuario"));  
            item.setCommand("#{usuarioMB.novoUsuario}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_empresa"));  
            item.setIcon(bundle.getString("icon_empresa"));  
            item.setCommand("#{empresaMB.novaEmpresa}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_usuario"));  
            item.setIcon(bundle.getString("icon_usuario"));  
            item.setCommand("#{usuarioMB.administrarUsuario}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_empresa"));  
            item.setIcon(bundle.getString("icon_empresa"));  
            item.setCommand("#{empresaMB.administrarEmpresa}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
            /*
             * Menu Op��es - Categoria --> Somente ROLE_ADMINISTRADOR
             */
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_categoria"));  
            item.setIcon(bundle.getString("icon_categoria")); 
            item.setCommand("#{categoriaMB.novaCategoria}");  
            item.setAjax(false);
            subMenu.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_categoria"));  
            item.setIcon(bundle.getString("icon_categoria"));  
            item.setCommand("#{categoriaMB.administrarCategoria}");  
            item.setAjax(false);
            subMenu.addElement(item);
           
            /*
             * Menu Op��es - Benef�cio --> Somente ROLE_ADMINISTRADOR
             */
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_beneficio"));  
            item.setIcon(bundle.getString("icon_beneficio")); 
            item.setCommand("#{beneficioMB.novoBeneficio}");  
            item.setAjax(false);
            subMenu.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_beneficio"));  
            item.setIcon(bundle.getString("icon_beneficio"));  
            item.setCommand("#{beneficioMB.administrarBeneficio}");  
            item.setAjax(false);
            subMenu.addElement(item);
           
            /*
             * Menu Op��es - Idioma --> Somente ROLE_ADMINISTRADOR
             */
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_idioma"));  
            item.setIcon(bundle.getString("icon_idioma")); 
            item.setCommand("#{idiomaMB.novoIdioma}");  
            item.setAjax(false);
            subMenu.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_idioma"));  
            item.setIcon(bundle.getString("icon_idioma"));  
            item.setCommand("#{idiomaMB.administrarIdioma}");  
            item.setAjax(false);
            subMenu.addElement(item);
           
            /*
             * Menu Op��es - Combinacao_Idioma --> Somente ROLE_ADMINISTRADOR
             */
            
            /*
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_combinacao_idioma"));  
            item.setIcon(bundle.getString("icon_combinacao_idioma")); 
            item.setCommand("#{combinacaoIdiomaMB.novoCombinacaoIdioma}");  
            item.setAjax(false);
            subMenu.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_combinacao_idioma"));  
            item.setIcon(bundle.getString("icon_combinacao_idioma"));  
            item.setCommand("#{combinacaoIdiomaMB.administrarCombinacaoIdioma}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
             */

            /*
             * Menu Op��es - Combinacao_Software --> Somente ROLE_ADMINISTRADOR
             */
            /*
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_combinacao_software"));  
            item.setIcon(bundle.getString("icon_combinacao_software")); 
            item.setCommand("#{combinacaoSoftwareMB.novoCombinacaoSoftware}");  
            item.setAjax(false);
            subMenu.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_combinacao_software"));  
            item.setIcon(bundle.getString("icon_combinacao_software"));  
            item.setCommand("#{combinacaoSoftwareMB.administrarCombinacaoSoftware}");  
            item.setAjax(false);
            subMenu.addElement(item);
             */
            
            /*
             * Menu Op��es - Software --> Somente ROLE_ADMINISTRADOR
             */
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_software"));  
            item.setIcon(bundle.getString("icon_software")); 
            item.setCommand("#{softwareMB.novoSoftware}");  
            item.setAjax(false);
            subMenu.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_software"));  
            item.setIcon(bundle.getString("icon_software"));  
            item.setCommand("#{softwareMB.administrarSoftware}");  
            item.setAjax(false);
            subMenu.addElement(item);
           
            /*
             * Menu Op��es - Perfil Vaga --> Somente ROLE_ADMINISTRADOR
             */
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_vaga"));  
            item.setIcon(bundle.getString("icon_perfil_vaga")); 
            item.setCommand("#{vagaMB.novaVaga}");  
            item.setAjax(false);
            subMenu.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_vaga"));  
            item.setIcon(bundle.getString("icon_perfil_vaga"));  
            item.setCommand("#{vagaMB.administrarVaga}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
            /*
             * Menu Op��es - Nivel --> Somente ROLE_ADMINISTRADOR
             */
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_nivel"));  
            item.setIcon(bundle.getString("icon_nivel")); 
            item.setCommand("#{nivelMB.novoNivel}");  
            item.setAjax(false);
            subMenu.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_nivel"));  
            item.setIcon(bundle.getString("icon_nivel"));  
            item.setCommand("#{nivelMB.administrarNivel}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
            /*
             * Menu Op��es - Fun��o --> Somente ROLE_ADMINISTRADOR
             */
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_funcao"));  
            item.setIcon(bundle.getString("icon_funcao")); 
            item.setCommand("#{funcaoMB.novaFuncao}");  
            item.setAjax(false);
            subMenu.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_funcao"));  
            item.setIcon(bundle.getString("icon_funcao"));  
            item.setCommand("#{funcaoMB.administrarFuncao}");  
            item.setAjax(false);
            subMenu.addElement(item);
           
            /*
             * Menu Op��es - E-Mail --> Somente ROLE_ADMINISTRADOR
             */
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_email"));  
            item.setIcon(bundle.getString("icon_conf_email"));
            item.setCommand("#{emailMB.novoEmail}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_email"));  
            item.setIcon(bundle.getString("icon_conf_email"));
            item.setCommand("#{emailMB.administrarEmail}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
        
            /*
             * Menu Op��es - Listar Estatisticas de todas vagas - Somente ROLE_ADMINISTRADOR
             */
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_oportunidade_todos"));  
            item.setIcon(bundle.getString("icon_oportunidades_todos"));
            item.setCommand("#{oportunidadeMB.administrarOportunidadeTodos}");  
            item.setAjax(false);
            subMenu.addElement(item);
            

        }
        if (perfilTmp.equals("ROLE_EMPRESA") || perfilTmp.equals("ROLE_ADMINISTRADOR")) {
        	
        	/*
        	 * Menu Op��es - Cadastrar Novo Usuario da Empresa --> Somente perfil EMPRESA e ADMINISTRADOR
        	 */
        	item = new DefaultMenuItem(bundle.getString("lbl_menu_empresa_novo_usuario"));  
            item.setIcon(bundle.getString("icon_usuario"));
            item.setCommand("#{usuarioMB.novoUsuarioEmpresa}");  
            item.setAjax(false);  
            subMenu.addElement(item);
            
            /*
        	 * Menu Op��es - Administrar Usuario da Empresa --> Somente perfil EMPRESA e ADMINISTRADOR
        	 */
        	item = new DefaultMenuItem(bundle.getString("lbl_menu_empresa_administrar_usuario"));  
            item.setIcon(bundle.getString("icon_usuario"));
            item.setCommand("#{usuarioMB.administrarUsuarioEmpresa}");  
            item.setAjax(false);  
            subMenu.addElement(item);
        }
        if (perfilTmp.equals("ROLE_CLIENTE") || perfilTmp.equals("ROLE_EMPRESA") || perfilTmp.equals("ROLE_ADMINISTRADOR")) {

    
        	/*
             * Menu Op��es - Buscar Curriculo
             */
            if(usuario.getEmpresa().getEmpresa_banco_curriculo()){           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_buscar_cadastro"));  
            item.setIcon(bundle.getString("icon_cadastro"));
            item.setCommand("#{cadastroMB.buscarCadastro}");  
            item.setAjax(false);  
            subMenu.addElement(item);  
            }
        	
        	/*
             * Menu Op��es - Categorias
             */
                        
            item = new DefaultMenuItem(bundle.getString("lbl_menu_listar_categoria"));  
            item.setIcon(bundle.getString("icon_categoria"));
            item.setCommand("#{categoriaMB.ListarCategoria}");  
            item.setAjax(false);  
            subMenu.addElement(item);  
              
            /*
             * Menu Op��es - Oportunidades
             */
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_oportunidade"));  
            item.setIcon(bundle.getString("icon_oportunidade"));
            item.setCommand("#{oportunidadeMB.novaOportunidade}");  
            item.setAjax(false);
            subMenu.addElement(item);  
                         
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_oportunidade"));  
            item.setIcon(bundle.getString("icon_oportunidade"));
            item.setCommand("#{oportunidadeMB.administrarOportunidade}");  
            item.setAjax(false);
            subMenu.addElement(item);
            
            /*
             * Menu Op��es - Sair/Logout
             */
            item = new DefaultMenuItem(bundle.getString("lbl_menu_sair"));  
            item.setIcon(bundle.getString("icon_sair"));
            item.setUrl(sair);
            item.setAjax(true); 
            subMenu.addElement(item);  
		}        
        model.addElement(subMenu);
        
        return model;
    }

	
	/*
	 *  Monta Menu com base no perfil do usuario logado 
	 */
		
	public MenuModel montaMenuBarUsuario(Usuario usuario) {  
        
		String perfilTmp = null;
		usuario = this.getUsuarioLogado();
		perfilTmp = this.carregaPerfilUsuario(0);
		
		DefaultSubMenu subMenuCadastro = new DefaultSubMenu(bundle.getString("lbl_menu_principal_cadastrar"));
		DefaultSubMenu subMenuAdministra = new DefaultSubMenu(bundle.getString("lbl_menu_principal_administrar"));
		DefaultSubMenu subMenuLista = new DefaultSubMenu(bundle.getString("lbl_menu_principal_listar"));
		DefaultSubMenu subMenuConfigurar = new DefaultSubMenu(bundle.getString("lbl_menu_principal_configurar"));
		DefaultSubMenu subMenuBuscar = new DefaultSubMenu(bundle.getString("lbl_menu_principal_buscar"));
		DefaultSubMenu subMenuSair = new DefaultSubMenu(bundle.getString("lbl_menu_principal_sair"));
		
		model = new DefaultMenuModel();
        DefaultMenuItem item;  
        
        if (perfilTmp.equals("ROLE_ADMINISTRADOR")){
        	/*
             * Menu Cadastro - Usuários --> Somente ROLE_ADMINISTRADOR
             */
                      
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_usuario"));  
            item.setIcon(bundle.getString("icon_usuario"));  
            item.setCommand("#{usuarioMB.novoUsuario}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_empresa"));  
            item.setIcon(bundle.getString("icon_empresa"));  
            item.setCommand("#{empresaMB.novaEmpresa}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_categoria"));  
            item.setIcon(bundle.getString("icon_categoria")); 
            item.setCommand("#{categoriaMB.novaCategoria}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_beneficio"));  
            item.setIcon(bundle.getString("icon_beneficio")); 
            item.setCommand("#{beneficioMB.novoBeneficio}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);
			
			item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_idioma"));  
            item.setIcon(bundle.getString("icon_idioma")); 
            item.setCommand("#{idiomaMB.novoIdioma}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_software"));  
            item.setIcon(bundle.getString("icon_software")); 
            item.setCommand("#{softwareMB.novoSoftware}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_vaga"));  
            item.setIcon(bundle.getString("icon_perfil_vaga")); 
            item.setCommand("#{vagaMB.novaVaga}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_nivel"));  
            item.setIcon(bundle.getString("icon_nivel")); 
            item.setCommand("#{nivelMB.novoNivel}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_funcao"));  
            item.setIcon(bundle.getString("icon_funcao")); 
            item.setCommand("#{funcaoMB.novaFuncao}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);  
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_email"));  
            item.setIcon(bundle.getString("icon_conf_email"));
            item.setCommand("#{emailMB.novoEmail}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);
            		
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_usuario"));  
            item.setIcon(bundle.getString("icon_usuario"));  
            item.setCommand("#{usuarioMB.administrarUsuario}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_empresa"));  
            item.setIcon(bundle.getString("icon_empresa"));  
            item.setCommand("#{empresaMB.administrarEmpresa}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_categoria"));  
            item.setIcon(bundle.getString("icon_categoria"));  
            item.setCommand("#{categoriaMB.administrarCategoria}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_beneficio"));  
            item.setIcon(bundle.getString("icon_beneficio"));  
            item.setCommand("#{beneficioMB.administrarBeneficio}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_idioma"));  
            item.setIcon(bundle.getString("icon_idioma"));  
            item.setCommand("#{idiomaMB.administrarIdioma}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_software"));  
            item.setIcon(bundle.getString("icon_software"));  
            item.setCommand("#{softwareMB.administrarSoftware}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_vaga"));  
            item.setIcon(bundle.getString("icon_perfil_vaga"));  
            item.setCommand("#{vagaMB.administrarVaga}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_nivel"));  
            item.setIcon(bundle.getString("icon_nivel"));  
            item.setCommand("#{nivelMB.administrarNivel}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_funcao"));  
            item.setIcon(bundle.getString("icon_funcao"));  
            item.setCommand("#{funcaoMB.administrarFuncao}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_oportunidade_todos"));  
            item.setIcon(bundle.getString("icon_oportunidades_todos"));
            item.setCommand("#{oportunidadeMB.administrarOportunidadeTodos}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_email"));  
            item.setIcon(bundle.getString("icon_conf_email"));
            item.setCommand("#{emailMB.administrarEmail}");  
            item.setAjax(false);
            subMenuConfigurar.addElement(item);
        }
    
        if (perfilTmp.equals("ROLE_EMPRESA") || perfilTmp.equals("ROLE_ADMINISTRADOR")) {
        	
        	item = new DefaultMenuItem(bundle.getString("lbl_menu_empresa_novo_usuario"));  
            item.setIcon(bundle.getString("icon_usuario"));
            item.setCommand("#{usuarioMB.novoUsuarioEmpresa}");  
            item.setAjax(false);  
            subMenuCadastro.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_empresa_administrar_usuario"));  
            item.setIcon(bundle.getString("icon_usuario"));
            item.setCommand("#{usuarioMB.administrarUsuarioEmpresa}");  
            item.setAjax(false);  
            subMenuAdministra.addElement(item);
        }
        if (perfilTmp.equals("ROLE_CLIENTE") || perfilTmp.equals("ROLE_EMPRESA") || perfilTmp.equals("ROLE_ADMINISTRADOR")) {

            if(usuario.getEmpresa().getEmpresa_banco_curriculo()){           
            item = new DefaultMenuItem(bundle.getString("lbl_menu_buscar_cadastro"));  
            item.setIcon(bundle.getString("icon_cadastro"));
            item.setCommand("#{cadastroMB.buscarCadastro}");  
            item.setAjax(false);  
            subMenuBuscar.addElement(item);  
            }
        	
            item = new DefaultMenuItem(bundle.getString("lbl_menu_listar_categoria"));  
            item.setIcon(bundle.getString("icon_categoria"));
            item.setCommand("#{categoriaMB.ListarCategoria}");  
            item.setAjax(false);  
            subMenuLista.addElement(item);  
              
            item = new DefaultMenuItem(bundle.getString("lbl_menu_incluir_oportunidade"));  
            item.setIcon(bundle.getString("icon_oportunidade"));
            item.setCommand("#{oportunidadeMB.novaOportunidade}");  
            item.setAjax(false);
            subMenuCadastro.addElement(item);  
                         
            item = new DefaultMenuItem(bundle.getString("lbl_menu_administrar_oportunidade"));  
            item.setIcon(bundle.getString("icon_oportunidade"));
            item.setCommand("#{oportunidadeMB.administrarOportunidade}");  
            item.setAjax(false);
            subMenuAdministra.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_sair"));  
            item.setIcon(bundle.getString("icon_sair"));
            item.setUrl(sair);
            item.setAjax(true); 
            subMenuSair.addElement(item);  
		}        

       // if (subMenuCadastro.getElementsCount()>1){model.addElement(subMenuCadastro);}
       // if (subMenuCadastro.getElementsCount()>1){model.addElement(subMenuAdministra);}
       // if (subMenuCadastro.getElementsCount()>1){model.addElement(subMenuLista);}
       // if (subMenuCadastro.getElementsCount()>1){model.addElement(subMenuBuscar);}
       // if (subMenuCadastro.getElementsCount()>1){model.addElement(subMenuConfigurar);}
        model.addElement(subMenuCadastro); 
        model.addElement(subMenuAdministra);
        model.addElement(subMenuLista);
        model.addElement(subMenuBuscar);
        model.addElement(subMenuConfigurar);
        model.addElement(subMenuSair);
        return model;
    }

	/*
	 *  Monta Menu com base no perfil do Candidato/ Convidado logado 
	 */
		
	public MenuModel montaMenuBarCandidato(Cadastro cadastro) {  
        
		String perfilTmp = null;
		cadastro = this.getCadastroLogado();
		perfilTmp = this.carregaPerfilCadastro(0);
				
		DefaultSubMenu subMenuCurriculo = new DefaultSubMenu(bundle.getString("lbl_menu_principal_curriculo"));
		DefaultSubMenu subMenuCandidatura = new DefaultSubMenu(bundle.getString("lbl_menu_principal_candidatura"));
		DefaultSubMenu subMenuSair = new DefaultSubMenu(bundle.getString("lbl_menu_principal_sair"));
		
		model = new DefaultMenuModel();
        DefaultMenuItem item;  
        
        if (perfilTmp.equals("ROLE_CONVIDADO")){
        	/*
             * Menu Opções - Cadastro --> Somente ROLE_CONVIDADO
             */

        	item = new DefaultMenuItem(bundle.getString("lbl_menu_alterar_cadastro"));  
            item.setIcon(bundle.getString("icon_cadastro"));  
            item.setCommand("#{cadastroMB.editarCadastro}");  
            item.setAjax(false);
            subMenuCurriculo.addElement(item);
            
            item = new DefaultMenuItem(bundle.getString("lbl_menu_candidatura_cadastro"));  
            item.setIcon(bundle.getString("icon_cadastro"));  
            item.setCommand("#{enviadoMB.listarCandidatura}");
            item.setAjax(false);
            subMenuCandidatura.addElement(item);
       
            item = new DefaultMenuItem(bundle.getString("lbl_menu_sair"));  
            item.setIcon(bundle.getString("icon_sair"));
            item.setUrl(sair);
            item.setAjax(true); 
            subMenuSair.addElement(item);  
        }       

         model.addElement(subMenuCurriculo);  
         model.addElement(subMenuCandidatura);
         model.addElement(subMenuSair);
        return model;
    }	
	
	public String mascara(){
		String mascara = null;
		Integer tipo = this.getTipoLogin();
		if (tipo==1){
			mascara = bundle.getString("lbl_msk_cpf");
		}
		else if (tipo==2) {
			mascara="";
		}
		return mascara;
	}
	
	public String titulo(){
		String titulo = null;
		Integer tipo = this.getTipoLogin();
		if (tipo==1){
			titulo = bundle.getString("lbl_login_titulo_1");
		}
		else if (tipo==2) {
			titulo = bundle.getString("lbl_login_titulo_2");
		}
		return titulo;
	}
	
	
	

}
