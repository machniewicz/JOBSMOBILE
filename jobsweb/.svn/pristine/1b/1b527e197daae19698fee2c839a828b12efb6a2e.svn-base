package br.com.jobs.web.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import br.com.jobs.modelo.categoria.Categoria;
import br.com.jobs.modelo.funcao.Funcao;
import br.com.jobs.modelo.funcao.FuncaoRN;

@ManagedBean (name="funcaoMB")
@SessionScoped
public class FuncaoMB implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Funcao funcao;
	private FuncaoRN funcaoRN;
	private Categoria categoria;
	private Integer pagina;
	private List<Funcao> funcoes;
	
	/*
	 * Construtor da Classe
	 */
	public FuncaoMB(){
		super();
	}
	
	/**
	 * Inicia processo
	 */
	@PostConstruct
	public void init() {
			
	}
	
	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<Funcao> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<Funcao> funcoes) {
		this.funcoes = funcoes;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	/*
	 * Navegação entre Páginas
	 * 
	 * Rules Navigation no faces-config.xml
	 */
	
	public String novaFuncao() {
		this.funcao = new Funcao();
		return "incluir_funcao";
	}
	
	public String listarFuncao() {
		this.setPagina(3);
		return "listar_funcao";
	}

	public String gerenciarFuncao() {
		this.setPagina(2);
		return "gerenciar_funcao";
	}
	
	public String editarFuncao() {
		return "editar_funcao";
	}
	
	public String detalharFuncao() {
		return "detalhar_funcao";
	}
	
	public String administrarFuncao(){
		this.setPagina(1);
		return "administrar_funcao";
	}
	
	public String voltarFuncao() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarFuncao();
			break;
		case 2:
			voltar = this.gerenciarFuncao();
			break;
		case 3:
			voltar = this.listarFuncao();
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
	public void salvarFuncao(){
		funcaoRN = new FuncaoRN();
		funcaoRN.salvar(funcao);
		this.novaFuncao();
	}
	
	public List<Funcao> listarTodasFuncoes() {
		funcaoRN = new FuncaoRN();
		funcoes = funcaoRN.listarTodasFuncoes();
		return funcoes;
	}
	
	public List<Funcao> listarTodasPorCategoria(ValueChangeEvent evento) {
		funcaoRN = new FuncaoRN();
		categoria = (Categoria) evento.getNewValue();
		funcoes = funcaoRN.listarFuncaoPorCategoria(categoria);
		return funcoes;
	}

	public List<Funcao> listarTodasAtivasPorCategoria() {
		funcaoRN = new FuncaoRN();
		funcoes = funcaoRN.listarTodasFuncoesAtivos();
		return funcoes;
	}

	public String atualizarFuncao(){
		funcaoRN = new FuncaoRN();
		funcaoRN.salvar(funcao);
		return this.administrarFuncao();
	}
	
	public String excluirFuncao(){
		funcaoRN = new FuncaoRN();
		funcao = funcaoRN.carregar(funcao.getFuncao_id());
		funcaoRN.excluir(funcao);
		return this.administrarFuncao();
	}
	
	public void ativarFuncao(){
		funcaoRN = new FuncaoRN();
		funcaoRN.ativarFuncao(funcao);
	}
	
	public String carregaStatusFuncao(){
		funcaoRN = new FuncaoRN();
		return funcaoRN.carregarStatus(funcao.getFuncao_id());
	}
	
	public List<Funcao> listarPorCategoria(Categoria categoria) {
		funcaoRN = new FuncaoRN();
		funcoes = funcaoRN.listarFuncaoPorCategoria(categoria);
		return funcoes;
	}
}
