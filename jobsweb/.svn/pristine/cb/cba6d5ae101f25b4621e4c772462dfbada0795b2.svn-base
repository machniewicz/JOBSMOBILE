package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.nivel.Nivel;
import br.com.jobs.modelo.nivel.NivelRN;

@ManagedBean(name = "nivelMB")
@SessionScoped
public class NivelMB {

	private Nivel nivel;
	private Integer pagina;
	private NivelRN nivelRN;
	private List<Nivel> lista;

	/*
	 * Construtor
	 */
	public NivelMB(){
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
	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public List<Nivel> getNiveis(){
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
	public String novoNivel() {
		this.nivel = new Nivel();
		return "incluir_nivel";
	}

	public String editarNivel() {
		this.nivel.getNivel_descricao();
		return "editar_nivel";
	}

	public String listarNivel() {
		this.setPagina(3);
		return "listar_nivel";
	}

	public String gerenciarNivel() {
		this.setPagina(2);
		return "gerenciar_nivel";
	}
	
	public String detalharNivel() {
		return "detalhar_nivel";
	}
	
	public String administrarNivel(){
		this.setPagina(1);
		return "administrar_nivel";
	}
	
	public String voltarNivel() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarNivel();
			break;
		case 2:
			voltar = this.gerenciarNivel();
			break;
		case 3:
			voltar = this.listarNivel();
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
	
	public void salvarNivel() {
		nivelRN = new NivelRN();
		nivelRN.salvar(nivel);
		this.novoNivel();
	}

	public String ativarNivel(){
		if(this.nivel.getNivel_status().equals(false)){
			this.nivel.setNivel_status(true);
		}
		else{
			this.nivel.setNivel_status(false);
		}
		return null;
	}
	
	public List<Nivel> listarTodosNiveis() {
		nivelRN = new NivelRN();
		lista = nivelRN.listarTodosNiveis();
		return lista;
	}
	
	public List<Nivel> listarTodosNiveisAtivos() {
		nivelRN = new NivelRN();
		lista = nivelRN.listarTodosNiveisAtivos();
		return lista;
	}
	
	public String carregaStatusNivel(){
		nivelRN = new NivelRN();
		return nivelRN.carregarStatus(nivel.getNivel_id());
	}
	
	public String excluirNivel(){
		nivelRN = new NivelRN();
		nivel = nivelRN.carregar(nivel.getNivel_id());
		nivelRN.excluir(nivel);
		return this.administrarNivel();
	}
	
	public String atualizarNivel(){
		nivelRN = new NivelRN();
		nivelRN.salvar(nivel);
		return this.administrarNivel();
	}
}
