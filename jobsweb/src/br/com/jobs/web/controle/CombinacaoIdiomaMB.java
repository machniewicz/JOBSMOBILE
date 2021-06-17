package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.combinacao.idioma.Combinacao_Idioma;
import br.com.jobs.combinacao.idioma.Combinacao_IdiomaRN;

@ManagedBean(name = "combinacaoIdiomaMB")
@SessionScoped
public class CombinacaoIdiomaMB {

	private Combinacao_Idioma combinacaoIdioma;
	private Integer pagina;
	private Combinacao_IdiomaRN combinacaoIdiomaRN;
	private List<Combinacao_Idioma> lista;

	/*
	 * Construtor
	 */
	public CombinacaoIdiomaMB(){
		super();
		combinacaoIdioma = new Combinacao_Idioma();
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
	public Combinacao_Idioma getCombinacao_Idioma() {
		return combinacaoIdioma;
	}

	public void setCombinacao_Idioma(Combinacao_Idioma combinacaoIdioma) {
		this.combinacaoIdioma = combinacaoIdioma;
	}
	
	public List<Combinacao_Idioma> getCombinacao_Idiomas(){
		return lista;
	}
	
	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	/*
	 * Navega��o entre P�ginas
	 * 
	 * Rules Navigation no faces-config.xml
	 */
	public String novoCombinacaoIdioma() {
		this.combinacaoIdioma = new Combinacao_Idioma();
		return "incluir_combinacao_idioma";
	}

	public String editarCombinacaoIdioma() {
		return "editar_combinacao_idioma";
	}

	public String ListarCombinacaoIdioma() {
		this.setPagina(3);
		return "listar_combinacao_idioma";
	}

	public String gerenciarCombinacaoIdioma() {
		this.setPagina(2);
		return "gerenciar_combinacao_idioma";
	}
	
	public String detalharCombinacaoIdioma() {
		return "detalhar_combinacao_idioma";
	}
	
	public String administrarCombinacaoIdioma(){
		this.setPagina(1);
		return "administrar_combinacao_idioma";
	}
	
	public String voltarCombinacaoIdioma() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarCombinacaoIdioma();
			break;
		case 2:
			voltar = this.gerenciarCombinacaoIdioma();
			break;
		case 3:
			voltar = this.ListarCombinacaoIdioma();
			break;
		default:
			break;
		}
		return voltar;
	}

	/*
	 * Metodos acesso banco de dados
	 * 
	 * OBS.: No XHTML deve usar ACTION quando o metodo retornar uma STRING ou navegar para outras p�ginas
	 *       usar ACTIONLISTNER quando n�o retornar nada ou n�o navegar entre p�ginas.              
	 */
	public void novaCombinacaoIdioma(){
		combinacaoIdioma = new Combinacao_Idioma();
	}
	
	public void salvarCombinacaoIdioma() {
		combinacaoIdiomaRN = new Combinacao_IdiomaRN();
		combinacaoIdiomaRN.salvar(combinacaoIdioma);
		this.novoCombinacaoIdioma();
	}

	public List<Combinacao_Idioma> listarTodosCombinacaoIdiomas() {
		combinacaoIdiomaRN = new Combinacao_IdiomaRN();
		lista = combinacaoIdiomaRN.listarTodos();
		return lista;
	}
	
	public List<Combinacao_Idioma> listarTodosCombinacoesIdiomasAtivos() {
		combinacaoIdiomaRN = new Combinacao_IdiomaRN();
		lista = combinacaoIdiomaRN.listarTodosAtivos();
		return lista;
	}
	
	public String carregaStatusIdioma(){
		combinacaoIdiomaRN = new Combinacao_IdiomaRN();
		return combinacaoIdiomaRN.carregarStatus(combinacaoIdioma.getCombinacao_idioma_id());
	}
	
	public String excluirCombinacaoIdioma(){
		combinacaoIdiomaRN = new Combinacao_IdiomaRN();
		combinacaoIdioma = combinacaoIdiomaRN.carregar(combinacaoIdioma.getCombinacao_idioma_id());
		combinacaoIdiomaRN.excluir(combinacaoIdioma);
		return this.administrarCombinacaoIdioma();
	}
	
	public String atualizarCombinacaoIdioma(){
		combinacaoIdiomaRN = new Combinacao_IdiomaRN();
		combinacaoIdiomaRN.salvar(combinacaoIdioma);
		return this.administrarCombinacaoIdioma();
	}
}
