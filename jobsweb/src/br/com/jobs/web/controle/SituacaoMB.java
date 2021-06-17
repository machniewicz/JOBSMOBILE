package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.situacao.Situacao;
import br.com.jobs.modelo.situacao.SituacaoRN;

@ManagedBean(name = "situacaoMB")
@SessionScoped
public class SituacaoMB {

	private Situacao situacao;
	private Integer pagina;
	private SituacaoRN situacaoRN;
	private List<Situacao> situacoes;

	/*
	 * Construtor
	 */
	public SituacaoMB(){
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
	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public List<Situacao> getSituacoes(){
		return situacoes;
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
	public String novoSituacao() {
		this.situacao = new Situacao();
		return "incluir_situacao";
	}

	public String editarSituacao() {
		return "editar_situacao";
	}

	public String listarSituacao() {
		this.setPagina(3);
		return "listar_situacao";
	}

	public String gerenciarSituacao() {
		this.setPagina(2);
		return "gerenciar_situacao";
	}
	
	public String detalharSituacao() {
		return "detalhar_situacao";
	}
	
	public String administrarSituacao(){
		this.setPagina(1);
		return "administrar_situacao";
	}
	
	public String voltarSituacao() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarSituacao();
			break;
		case 2:
			voltar = this.gerenciarSituacao();
			break;
		case 3:
			voltar = this.listarSituacao();
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
	
	public void salvarSituacao() {
		situacaoRN = new SituacaoRN();
		situacaoRN.salvar(situacao);
		this.novoSituacao();
	}

	public String ativarSituacao(){
		if(this.situacao.getSituacao_status().equals(false)){
			this.situacao.setSituacao_status(true);
		}
		else{
			this.situacao.setSituacao_status(false);
		}
		return null;
	}
	
	public List<Situacao> listarTodosSituacoes() {
		situacaoRN = new SituacaoRN();
		situacoes = situacaoRN.listarTodos();
		return situacoes;
	}
	
	public List<Situacao> listarTodosSituacoesAtivas() {
		situacaoRN = new SituacaoRN();
		situacoes = situacaoRN.listarTodosAtivos();
		return situacoes;
	}
	
	public String carregaStatusSituacao(){
		situacaoRN = new SituacaoRN();
		return situacaoRN.carregarStatus(situacao.getSituacao_id());
	}
	
	public String excluirSituacao(){
		situacaoRN = new SituacaoRN();
		situacao = situacaoRN.carregar(situacao.getSituacao_id());
		situacaoRN.excluir(situacao);
		return this.administrarSituacao();
	}
	
	public String atualizarSituacao(){
		situacaoRN = new SituacaoRN();
		situacaoRN.salvar(situacao);
		return this.administrarSituacao();
				
	}
}
