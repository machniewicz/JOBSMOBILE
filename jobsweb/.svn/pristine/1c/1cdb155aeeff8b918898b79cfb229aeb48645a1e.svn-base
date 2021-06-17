package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.software.Software;
import br.com.jobs.modelo.software.SoftwareRN;

@ManagedBean(name = "softwareMB")
@SessionScoped
public class SoftwareMB {

	private Software software;
	private Integer pagina;
	private SoftwareRN softwareRN;
	private List<Software> lista;

	/*
	 * Construtor
	 */
	public SoftwareMB(){
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
	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}
	
	public List<Software> getSoftwares(){
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
	public String novoSoftware() {
		this.software = new Software();
		return "incluir_software";
	}

	public String editarSoftware() {
		this.software.getSoftware_descricao();
		return "editar_software";
	}

	public String ListarSoftware() {
		this.setPagina(3);
		return "listar_software";
	}

	public String gerenciarSoftware() {
		this.setPagina(2);
		return "gerenciar_software";
	}
	
	public String detalharSoftware() {
		return "detalhar_software";
	}
	
	public String administrarSoftware(){
		this.setPagina(1);
		return "administrar_software";
	}
	
	public String voltarSoftware() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarSoftware();
			break;
		case 2:
			voltar = this.gerenciarSoftware();
			break;
		case 3:
			voltar = this.ListarSoftware();
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
	
	public void salvarSoftware() {
		softwareRN = new SoftwareRN();
		softwareRN.salvar(software);
		this.novoSoftware();
	}

	public String ativarSoftware(){
		if(this.software.getSoftware_status().equals(false)){
			this.software.setSoftware_status(true);
		}
		else{
			this.software.setSoftware_status(false);
		}
		return null;
	}
	
	public List<Software> listarTodosSoftwares() {
		softwareRN = new SoftwareRN();
		lista = softwareRN.listarTodosSoftwares();
		return lista;
	}
	
	public List<Software> listarTodosSoftwaresAtivos() {
		softwareRN = new SoftwareRN();
		lista = softwareRN.listarTodosSoftwaresAtivos();
		return lista;
	}
	
	public String carregaStatusSoftware(){
		softwareRN = new SoftwareRN();
		return softwareRN.carregarStatus(software.getSoftware_id());
	}
	
	public String excluirSoftware(){
		softwareRN = new SoftwareRN();
		software = softwareRN.carregar(software.getSoftware_id());
		softwareRN.excluir(software);
		return this.administrarSoftware();
	}
	
	public String atualizarSoftware(){
		softwareRN = new SoftwareRN();
		softwareRN.salvar(software);
		return this.gerenciarSoftware();
	}
}
