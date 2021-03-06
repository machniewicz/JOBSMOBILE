package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.formacao.Formacao;
import br.com.jobs.modelo.formacao.FormacaoRN;

@ManagedBean(name = "formacaoMB")
@SessionScoped
public class FormacaoMB {

	private Formacao formacao;
	private Integer pagina;
	private FormacaoRN formacaoRN;
	private List<Formacao> formacoes;

	/*
	 * Construtor
	 */
	public FormacaoMB(){
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
	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	
	public List<Formacao> getFormacoes(){
		return formacoes;
	}
	
	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	/*
	 * Navegação entre Páginas
	 * 
	 * Rules Navigation no faces-config.xml
	 */
	public String novaFormacao() {
		this.formacao = new Formacao();
		return "incluir_formacao";
	}

	public String editarFormacao() {
		this.formacao.getFormacao_descricao();
		return "editar_formacao";
	}

	public String listarFormacao() {
		this.setPagina(3);
		return "listar_formacao";
	}

	public String gerenciarFormacao() {
		this.setPagina(2);
		return "gerenciar_formacao";
	}
	
	public String detalharFormacao() {
		return "detalhar_formacao";
	}
	
	public String administrarFormacao(){
		this.setPagina(1);
		return "administrar_formacao";
	}
	
	public String voltarFormacao() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarFormacao();
			break;
		case 2:
			voltar = this.gerenciarFormacao();
			break;
		case 3:
			voltar = this.listarFormacao();
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
	
	public void salvarFormacao() {
		formacaoRN = new FormacaoRN();
		formacaoRN.salvar(formacao);
		this.novaFormacao();
	}

	public String ativarFormacao(){
		if(this.formacao.getFormacao_status().equals(false)){
			this.formacao.setFormacao_status(true);
		}
		else{
			this.formacao.setFormacao_status(false);
		}
		return null;
	}
	
	@
	public List<Formacao> listarTodasFormacaoes() {
		formacaoRN = new FormacaoRN();
		formacoes = formacaoRN.listarTodos();
		return formacoes;
	}
	
	public List<Formacao> listarTodasFormacoesAtivas() {
		formacaoRN = new FormacaoRN();
		formacoes = formacaoRN.listarTodosAtivos();
		return formacoes;
	}
	
	public String carregaStatusFormacao(){
		formacaoRN = new FormacaoRN();
		return formacaoRN.carregarStatus(formacao.getFormacao_id());
	}
	
	public String excluirFormacao(){
		formacaoRN = new FormacaoRN();
		formacao = formacaoRN.carregar(formacao.getFormacao_id());
		formacaoRN.excluir(formacao);
		return this.administrarFormacao();
	}
	
	public String atualizarFormacao(){
		formacaoRN = new FormacaoRN();
		formacaoRN.salvar(formacao);
		return this.gerenciarFormacao();
	}
}
