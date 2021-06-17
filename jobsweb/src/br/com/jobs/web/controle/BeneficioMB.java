package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.beneficio.Beneficio;
import br.com.jobs.modelo.beneficio.BeneficioRN;

@ManagedBean(name = "beneficioMB")
@SessionScoped
public class BeneficioMB {

	private Beneficio beneficio;
	private Integer pagina;
	private BeneficioRN beneficioRN;
	private List<Beneficio> lista;

	/*
	 * Construtor
	 */
	public BeneficioMB(){
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
	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}
	
	public List<Beneficio> getBeneficios(){
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
	public String novoBeneficio() {
		this.beneficio = new Beneficio();
		return "incluir_beneficio";
	}

	public String editarBeneficio() {
		this.beneficio.getBeneficio_descricao();
		return "editar_beneficio";
	}

	public String ListarBeneficio() {
		this.setPagina(3);
		return "listar_beneficio";
	}

	public String gerenciarBeneficio() {
		this.setPagina(2);
		return "gerenciar_beneficio";
	}
	
	public String detalharBeneficio() {
		return "detalhar_beneficio";
	}
	
	public String administrarBeneficio(){
		this.setPagina(1);
		return "administrar_beneficio";
	}
	
	public String voltarBeneficio() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarBeneficio();
			break;
		case 2:
			voltar = this.gerenciarBeneficio();
			break;
		case 3:
			voltar = this.ListarBeneficio();
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
	
	public void salvarBeneficio() {
		beneficioRN = new BeneficioRN();
		beneficioRN.salvar(beneficio);
		this.novoBeneficio();
	}

	public String ativarBeneficio(){
		if(this.beneficio.getBeneficio_status().equals(false)){
			this.beneficio.setBeneficio_status(true);
		}
		else{
			this.beneficio.setBeneficio_status(false);
		}
		return null;
	}
	
	public List<Beneficio> listarTodosBeneficios() {
		beneficioRN = new BeneficioRN();
		lista = beneficioRN.listarTodosBeneficios();
		return lista;
	}
	
	public List<Beneficio> listarTodosBeneficiosAtivos() {
		beneficioRN = new BeneficioRN();
		lista = beneficioRN.listarTodosBeneficiosAtivos();
		return lista;
	}
	
	public String carregaStatusBeneficio(){
		beneficioRN = new BeneficioRN();
		return beneficioRN.carregarStatus(beneficio.getBeneficio_id());
	}
	
	public String excluirBeneficio(){
		beneficioRN = new BeneficioRN();
		beneficio = beneficioRN.carregar(beneficio.getBeneficio_id());
		beneficioRN.excluir(beneficio);
		return this.administrarBeneficio();
	}
	
	public String atualizarBeneficio(){
		beneficioRN = new BeneficioRN();
		beneficioRN.salvar(beneficio);
		return this.administrarBeneficio();
	}
}
