package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.email.Email;
import br.com.jobs.modelo.email.EmailRN;

@ManagedBean(name = "emailMB")
@SessionScoped
public class EmailMB {

	private Email email;
	private Integer pagina;
	private EmailRN emailRN;
	private List<Email> lista;
	
	private String senhaTmp = null;

	/*
	 * Construtor
	 */
	public EmailMB(){
		super();
	}
	
	/**
	 * Inicia processo
	 */
	@PostConstruct
	public void init(){
	
	}
	
	/*
	 * Get e Set 
	 */
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}
	
	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	
	public String getSenhaTmp() {
		return senhaTmp;
	}

	public void setSenhaTmp(String senhaTmp) {
		this.senhaTmp = senhaTmp;
	}  
	
	/*
	 * Navegação entre Páginas
	 * 
	 * Rules Navigation no faces-config.xml
	 */
	public String novoEmail() {
		this.email = new Email();
		return "incluir_email";
	}

	public String editarEmail() {
		return "editar_email";
	}

	public String ListarEmail() {
		this.setPagina(3);
		return "listar_email";
	}

	public String gerenciarEmail() {
		this.setPagina(2);
		return "gerenciar_email";
	}
	
	public String detalharEmail() {
		return "detalhar_email";
	}
	
	public String administrarEmail(){
		this.setPagina(1);
		return "administrar_email";
	}
	
	public String voltarEmail() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarEmail();
			break;
		case 2:
			voltar = this.gerenciarEmail();
			break;
		case 3:
			voltar = this.ListarEmail();
			break;
		default:
			break;
		}
		return voltar;
	}

	/*
	 * Metodos acesso banco de dados
	 * 
	 * OBS.: No XHTML deve usar ACTION quando o metodo retornar uma STRING ou navegar para outras páginas
	 *       usar ACTIONLISTNER quando não retornar nada ou não navegar entre páginas.              
	 */
	
	public void salvarEmail() {
		emailRN = new EmailRN();
		emailRN.salvar(email);
		this.novoEmail();
	}

	public List<Email> listarTodos() {
		emailRN = new EmailRN();
		lista = emailRN.listarTodos();
		return lista;
	}
	
	
	public String excluirEmail(){
		emailRN = new EmailRN();
		email = emailRN.carregar(email.getEmail_id());
		emailRN.excluir(email);
		return this.administrarEmail();
	}
	
	public String atualizarEmail(){
		emailRN = new EmailRN();
		if (!this.getSenhaTmp().isEmpty()){
	//		email.setEmail_senha(senhaTmp);
		}
		emailRN.salvar(email);
		return this.gerenciarEmail();
	}
}
