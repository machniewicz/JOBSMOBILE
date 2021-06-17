package br.com.jobs.web.controle;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.enviado.Enviado;
import br.com.jobs.modelo.enviado.EnviadoGrafico;
import br.com.jobs.modelo.enviado.EnviadoRN;
import br.com.jobs.modelo.oportunidade.Oportunidade;

@ManagedBean (name="enviadoMB")
@SessionScoped
public class EnviadoMB implements Serializable{

	private static final long serialVersionUID = 1L;
	private Oportunidade oportunidade;
	private OportunidadeMB oportunidadeMB;
	private CadastroMB cadastroMB;
	private EnviadoRN enviadoRN;
	private Enviado enviado;
	private Cadastro cadastro;
	private Integer pagina;
	private List<Enviado> lista = null;
	private List<EnviadoGrafico> listaGrafico = null;
	private LineChartModel modelGrafico;
	
	/*
	 * Construtor da Classe
	 */
	public EnviadoMB(){
		super();
		oportunidadeMB = new OportunidadeMB();
		cadastroMB = new CadastroMB();
	}
	
	/**
	 * Inicia processo
	 */
	@PostConstruct
	public void init() {
		//gerarGrafico();
	}
	
	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Enviado getEnviado() {
		return enviado;
	}

	public void setEnviado(Enviado enviado) {
		this.enviado = enviado;
	}
	
	public Oportunidade getOportunidade() {
		return oportunidade;
	}

	public void setOportunidade(Oportunidade oportunidade) {
		this.oportunidade = oportunidade;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
		
	/*
	 * Navega��o entre P�ginas
	 * 
	 * Rules Navigation no faces-config.xml
	 */
	
	public String listarEnviado() {
		this.setPagina(1);
		return "listar_enviado";
	}
	
	public String listarEnviadoAdministrador() {
		this.setPagina(2);
		return "listar_enviado";
	}
	
	public String listarCandidatura() {
		this.setPagina(3);
		return "candidatura_cadastro";
	}
	
	public String detalharEnviado() {
		return "detalhar_enviado";
	}
	
	public String voltarEnviado() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = oportunidadeMB.administrarOportunidade();
			break;
		case 2:
			voltar = oportunidadeMB.administrarOportunidadeTodos();
			break;
		case 3:
			voltar = cadastroMB.inicialCadastro();
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
	
	public List<Enviado> listarTodosEnviados() {
		enviadoRN = new EnviadoRN();
		oportunidade = this.getOportunidade();
		lista = enviadoRN.listar(oportunidade);
		return lista;
	}

	public List<Enviado> listarCadastroEnviados() {
		enviadoRN = new EnviadoRN();
		cadastro = this.getCadastro();
		lista = enviadoRN.listarEnviado(cadastro);
		return lista;
	}

	public LineChartModel getModelGrafico() {
		return modelGrafico;
	}

	public List<EnviadoGrafico> listarDadosGrafico(Integer codigo){
		enviadoRN = new EnviadoRN();
		listaGrafico = enviadoRN.listarGrafico(codigo);
		return listaGrafico;
	}
	
		
	public void gerarGrafico(){
		modelGrafico = new LineChartModel();
		List<EnviadoGrafico> listaGraficoTmp = null;
		LineChartSeries cvDia = new LineChartSeries();
		cvDia.setLabel("TESTE");
		listaGraficoTmp = listarDadosGrafico(18);
		//cvDia.set("2014-01-01",2);
		//cvDia.set("2014-01-02",3);
		//cvDia.set("2014-01-03",2);
		//cvDia.set("2014-01-04",3);
		for(int i=0;i<=listaGraficoTmp.size()-1;i++){
			cvDia.set(listaGraficoTmp.get(i).getEnviado_grafico_data(), listaGraficoTmp.get(i).getEnviado_grafico_quantidade());
			System.out.println("****************Data+++++++++++++++++++++++++++:"+listaGraficoTmp.get(i).getEnviado_grafico_data());
			System.out.println("****************Quantidade+++++++++++++++++++++:"+listaGraficoTmp.get(i).getEnviado_grafico_quantidade());
		}
		modelGrafico.addSeries(cvDia);
		
		modelGrafico.setTitle("Curr�culos x Dia");
        modelGrafico.setZoom(false);
        modelGrafico.getAxis(AxisType.Y).setLabel("Quantidade Dias");
        DateAxis axis = new DateAxis("Datas");
        axis.setTickAngle(-50);
        axis.setMax("2014-01-31");
        axis.setTickFormat("%b %#d, %y");
         
        modelGrafico.getAxes().put(AxisType.X, axis);
	}

}
