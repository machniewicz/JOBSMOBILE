package br.com.jobs.web.controle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.empresa.Empresa;
import br.com.jobs.modelo.empresa.EmpresaRN;
import br.com.jobs.web.util.FacesUtil;

@ManagedBean(name="empresaMB")
@SessionScoped

public class EmpresaMB {

	private Empresa empresa;
	private EmpresaRN empresaRN;
	private Integer pagina;
	private List<Empresa> lista;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil(); 
		
	/*
	 * Construtor da Classe
	 */
	public EmpresaMB(){
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
	
	}
		
	/**
	 * Inicia processo
	 */
	@PostConstruct
	public void init() {
			
	}
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
	public String novaEmpresa() {
		this.empresa  = new Empresa();
		return "incluir_empresa";
	}

	public String listarEmpresa() {
		this.setPagina(3);
		return "listar_empresa";
	}

	public String gerenciarEmpresa() {
		this.setPagina(2);
		return "gerenciar_empresa";
	}
	
	public String editarEmpresa() {
		return "editar_empresa";
	}
	
	public String detalharEmpresa() {
		return "detalhar_empresa";
	}
	
	public String administrarEmpresa(){
		this.setPagina(1);
		return "administrar_empresa";
	}
	
	public String voltarEmpresa() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarEmpresa();
			break;
		case 2:
			voltar = this.gerenciarEmpresa();
			break;
		case 3:
			voltar = this.listarEmpresa();
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

	public void salvarEmpresa() {
		empresaRN = new EmpresaRN();
		empresaRN.salvar(empresa);
		this.novaEmpresa();
	}

	public List<Empresa> listarTodasEmpresas() {
		empresaRN = new EmpresaRN();
		lista = empresaRN.listarTodasEmpresas();
		return lista;
	}
	
	public List<Empresa> listarTodasEmpresasAtivas() {
		empresaRN = new EmpresaRN();
		lista = empresaRN.listarTodasEmpresasAtivas();
		return lista;
	}
	
	public List<Empresa> gerenciaTodasEmpresas() {
		empresaRN = new EmpresaRN();
		lista = empresaRN.listarTodasEmpresas();
		return lista;
	}
	
	public List<Empresa> administrarTodasEmpresas() {
		empresaRN = new EmpresaRN();
		lista = empresaRN.listarTodasEmpresas();
		return lista;
	}
	
	public String atualizarEmpresa(){
		empresaRN = new EmpresaRN();
		empresaRN.salvar(empresa);
		return this.administrarEmpresa();
	}
	
	public String excluirEmpresa(){
		empresaRN = new EmpresaRN();
		empresa = empresaRN.carregar(empresa.getEmpresa_id());
		empresaRN.excluir(empresa);
		return this.administrarEmpresa();
	}
	
	public String dataAtual() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(new Date());
	}

	public String getDataHoje(){
		DateFormat dfmt = new SimpleDateFormat("EEEE, d 'de' MMMM 'de' yyyy");
		Date hoje = Calendar.getInstance(Locale.getDefault()).getTime();
		return dfmt.format(hoje);	 
	}

	public void ativarEmpresa(){
		empresaRN = new EmpresaRN();
		empresaRN.ativarEmpresa(empresa);
	}
		
	public String carregaStatusEmpresa(){
		empresaRN = new EmpresaRN();
		return empresaRN.carregarStatus(empresa.getEmpresa_id());
	}
	  
}