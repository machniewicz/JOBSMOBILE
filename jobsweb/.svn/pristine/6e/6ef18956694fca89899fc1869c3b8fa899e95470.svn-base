package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.idioma.Idioma;
import br.com.jobs.modelo.idioma.IdiomaRN;

@ManagedBean(name = "idiomaMB")
@SessionScoped
public class IdiomaMB {

	private Idioma idioma;
	private Integer pagina;
	private IdiomaRN idiomaRN;
	private List<Idioma> lista;

	/*
	 * Construtor
	 */
	public IdiomaMB(){
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
	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	
	public List<Idioma> getIdiomas(){
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
	public String novoIdioma() {
		this.idioma = new Idioma();
		return "incluir_idioma";
	}

	public String editarIdioma() {
		this.idioma.getIdioma_descricao();
		return "editar_idioma";
	}

	public String ListarIdioma() {
		this.setPagina(3);
		return "listar_idioma";
	}

	public String gerenciarIdioma() {
		this.setPagina(2);
		return "gerenciar_idioma";
	}
	
	public String detalharIdioma() {
		return "detalhar_idioma";
	}
	
	public String administrarIdioma(){
		this.setPagina(1);
		return "administrar_idioma";
	}
	
	public String voltarIdioma() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarIdioma();
			break;
		case 2:
			voltar = this.gerenciarIdioma();
			break;
		case 3:
			voltar = this.ListarIdioma();
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
	
	public void salvarIdioma() {
		idiomaRN = new IdiomaRN();
		idiomaRN.salvar(idioma);
		this.novoIdioma();
	}

	public String ativarIdioma(){
		if(this.idioma.getIdioma_status().equals(false)){
			this.idioma.setIdioma_status(true);
		}
		else{
			this.idioma.setIdioma_status(false);
		}
		return null;
	}
	
	public List<Idioma> listarTodosIdiomas() {
		idiomaRN = new IdiomaRN();
		lista = idiomaRN.listarTodosIdiomas();
		return lista;
	}
	
	public List<Idioma> listarTodosIdiomasAtivos() {
		idiomaRN = new IdiomaRN();
		lista = idiomaRN.listarTodosIdiomasAtivos();
		return lista;
	}
	
	public String carregaStatusIdioma(){
		idiomaRN = new IdiomaRN();
		return idiomaRN.carregarStatus(idioma.getIdioma_id());
	}
	
	public String excluirIdioma(){
		idiomaRN = new IdiomaRN();
		idioma = idiomaRN.carregar(idioma.getIdioma_id());
		idiomaRN.excluir(idioma);
		return this.administrarIdioma();
	}
	
	public String atualizarIdioma(){
		idiomaRN = new IdiomaRN();
		idiomaRN.salvar(idioma);
		return this.gerenciarIdioma();
	}
}
