package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.salario.Salario;
import br.com.jobs.modelo.salario.SalarioRN;

@ManagedBean(name = "salarioMB")
@SessionScoped
public class SalarioMB {

	private Salario salario;
	private Integer pagina;
	private SalarioRN salarioRN;
	private List<Salario> salarios;

	/*
	 * Construtor
	 */
	public SalarioMB(){
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
	public Salario getSalario() {
		return salario;
	}

	public void setSalario(Salario salario) {
		this.salario = salario;
	}
	
	public List<Salario> getSalarios(){
		return salarios;
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
	public String novoSalario() {
		this.salario = new Salario();
		return "incluir_salario";
	}

	public String editarSalario() {
		this.salario.getSalario_descricao();
		return "editar_salario";
	}

	public String listarSalario() {
		this.setPagina(3);
		return "listar_salario";
	}

	public String gerenciarSalario() {
		this.setPagina(2);
		return "gerenciar_salario";
	}
	
	public String detalharSalario() {
		return "detalhar_salario";
	}
	
	public String administrarSalario(){
		this.setPagina(1);
		return "administrar_salario";
	}
	
	public String voltarSalario() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarSalario();
			break;
		case 2:
			voltar = this.gerenciarSalario();
			break;
		case 3:
			voltar = this.listarSalario();
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
	
	public void salvarSalario() {
		salarioRN = new SalarioRN();
		salarioRN.salvar(salario);
		this.novoSalario();
	}

	public String ativarSalario(){
		if(this.salario.getSalario_status().equals(false)){
			this.salario.setSalario_status(true);
		}
		else{
			this.salario.setSalario_status(false);
		}
		return null;
	}
	
	public List<Salario> listarTodosSalarios() {
		salarioRN = new SalarioRN();
		salarios = salarioRN.listarTodos();
		return salarios;
	}
	
	public List<Salario> listarTodosSalariosAtivas() {
		salarioRN = new SalarioRN();
		salarios = salarioRN.listarTodosAtivos();
		return salarios;
	}
	
	public String carregaStatusSalario(){
		salarioRN = new SalarioRN();
		return salarioRN.carregarStatus(salario.getSalario_id());
	}
	
	public String excluirSalario(){
		salarioRN = new SalarioRN();
		salario = salarioRN.carregar(salario.getSalario_id());
		salarioRN.excluir(salario);
		return this.administrarSalario();
	}
	
	public String atualizarSalario(){
		salarioRN = new SalarioRN();
		salarioRN.salvar(salario);
		return this.gerenciarSalario();
				
	}
}
