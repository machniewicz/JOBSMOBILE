package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.combinacao.software.Combinacao_Software;
import br.com.jobs.combinacao.software.Combinacao_SoftwareRN;

@ManagedBean(name = "combinacaoSoftwareMB")
@SessionScoped
public class CombinacaoSoftwareMB {

	private Combinacao_Software combinacaoSoftware;
	private Integer pagina;
	private Combinacao_SoftwareRN combinacaoSoftwareRN;
	private List<Combinacao_Software> lista;

	/*
	 * Construtor
	 */
	public CombinacaoSoftwareMB(){
		super();
		combinacaoSoftware = new Combinacao_Software();
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
	public Combinacao_Software getCombinacao_Software() {
		return combinacaoSoftware;
	}

	public void setCombinacao_Software(Combinacao_Software combinacaoSoftware) {
		this.combinacaoSoftware = combinacaoSoftware;
	}
	
	public List<Combinacao_Software> getCombinacao_Softwares(){
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
	public void novaCombinacaoSoftware(){
		combinacaoSoftware = new Combinacao_Software();
	}
	
	public String novoCombinacaoSoftware() {
		this.combinacaoSoftware = new Combinacao_Software();
		return "incluir_combinacao_software";
	}

	public String editarCombinacaoSoftware() {
		return "editar_combinacao_software";
	}

	public String ListarCombinacaoSoftware() {
		this.setPagina(3);
		return "listar_combinacao_software";
	}

	public String gerenciarCombinacaoSoftware() {
		this.setPagina(2);
		return "gerenciar_combinacao_software";
	}
	
	public String detalharCombinacaoSoftware() {
		return "detalhar_combinacao_software";
	}
	
	public String administrarCombinacaoSoftware(){
		this.setPagina(1);
		return "administrar_combinacao_software";
	}
	
	public String voltarCombinacaoSoftware() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarCombinacaoSoftware();
			break;
		case 2:
			voltar = this.gerenciarCombinacaoSoftware();
			break;
		case 3:
			voltar = this.ListarCombinacaoSoftware();
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
	
	public void salvarCombinacaoSoftware() {
		combinacaoSoftwareRN = new Combinacao_SoftwareRN();
		combinacaoSoftwareRN.salvar(combinacaoSoftware);
		this.novoCombinacaoSoftware();
	}

	public List<Combinacao_Software> listarTodosCombinacaoSoftwares() {
		combinacaoSoftwareRN = new Combinacao_SoftwareRN();
		lista = combinacaoSoftwareRN.listarTodos();
		return lista;
	}
	
	public List<Combinacao_Software> listarTodosCombinacoesSoftwaresAtivos() {
		combinacaoSoftwareRN = new Combinacao_SoftwareRN();
		lista = combinacaoSoftwareRN.listarTodosAtivos();
		return lista;
	}
	
	public String carregaStatusSoftware(){
		combinacaoSoftwareRN = new Combinacao_SoftwareRN();
		return combinacaoSoftwareRN.carregarStatus(combinacaoSoftware.getCombinacao_software_id());
	}
	
	public String excluirCombinacaoSoftware(){
		combinacaoSoftwareRN = new Combinacao_SoftwareRN();
		combinacaoSoftware = combinacaoSoftwareRN.carregar(combinacaoSoftware.getCombinacao_software_id());
		combinacaoSoftwareRN.excluir(combinacaoSoftware);
		return this.administrarCombinacaoSoftware();
	}
	
	public String atualizarCombinacaoSoftware(){
		combinacaoSoftwareRN = new Combinacao_SoftwareRN();
		combinacaoSoftwareRN.salvar(combinacaoSoftware);
		return this.administrarCombinacaoSoftware();
	}

}
