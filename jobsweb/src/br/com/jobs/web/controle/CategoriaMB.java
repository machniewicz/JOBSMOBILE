package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.categoria.Categoria;
import br.com.jobs.modelo.categoria.CategoriaRN;

@ManagedBean(name = "categoriaMB")
@SessionScoped
public class CategoriaMB {

	private Categoria categoria;
	private Integer pagina;
	private CategoriaRN categoriaRN;
	private List<Categoria> lista;

	/*
	 * Construtor
	 */
	public CategoriaMB(){
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
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Categoria> getCategorias(){
		return lista;
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
	public String novaCategoria() {
		this.categoria = new Categoria();
		return "incluir_categoria";
	}

	public String editarCategoria() {
		this.categoria.getCategoria_descricao();
		return "editar_categoria";
	}

	public String ListarCategoria() {
		this.setPagina(3);
		return "listar_categoria";
	}

	public String gerenciarCategoria() {
		this.setPagina(2);
		return "gerenciar_categoria";
	}
	
	public String detalharCategoria() {
		return "detalhar_categoria";
	}
	
	public String administrarCategoria(){
		this.setPagina(1);
		return "administrar_categoria";
	}
	
	public String voltarCategoria() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarCategoria();
			break;
		case 2:
			voltar = this.gerenciarCategoria();
			break;
		case 3:
			voltar = this.ListarCategoria();
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
	
	public void salvarCategoria() {
		categoriaRN = new CategoriaRN();
		categoriaRN.salvar(categoria);
		this.novaCategoria();
	}

	public String ativarCategoria(){
		if(this.categoria.getCategoria_status().equals(false)){
			this.categoria.setCategoria_status(true);
		}
		else{
			this.categoria.setCategoria_status(false);
		}
		return null;
	}
	
	public List<Categoria> listarTodasCategorias() {
		categoriaRN = new CategoriaRN();
		lista = categoriaRN.listarTodos();
		return lista;
	}
	
	public List<Categoria> listarTodasCategoriasAtivas() {
		categoriaRN = new CategoriaRN();
		lista = categoriaRN.listarTodosAtivos();
		return lista;
	}
	
	public String carregaStatusCategoria(){
		categoriaRN = new CategoriaRN();
		return categoriaRN.carregarStatus(categoria.getCategoria_id());
	}
	
	public String excluirCategoria(){
		categoriaRN = new CategoriaRN();
		categoria = categoriaRN.carregar(categoria.getCategoria_id());
		categoriaRN.excluir(categoria);
		return this.administrarCategoria();
	}
	
	public String atualizarCategoria(){
		categoriaRN = new CategoriaRN();
		categoriaRN.salvar(categoria);
		return this.gerenciarCategoria();
	}
}
