package br.com.jobs.web.controle;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.jobs.combinacao.idioma.Combinacao_Idioma;
import br.com.jobs.combinacao.software.Combinacao_Software;
import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.cadastro.CadastroRN;
import br.com.jobs.modelo.curso.Curso;
import br.com.jobs.modelo.enviado.Enviado;
import br.com.jobs.modelo.escolaridade.Escolaridade;
import br.com.jobs.modelo.experiencia.Experiencia;
import br.com.jobs.web.util.Filtro;
import br.com.jobs.web.util.pesquisa.ItemFiltro;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name = "cadastroMB")
@SessionScoped
public class CadastroMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cadastro cadastro;
	private Filtro filtro;
	private Integer pagina;
	private CadastroRN cadastroRN;
	private List<Cadastro> cadastros;
	private List<ItemFiltro> filtros;
	private String retorno;
	private String senhaTmp = null;
	private String senhaCompara = null;
	private Escolaridade escolaridade;
	private Curso curso;
	private Experiencia experiencia;
	private List<Enviado> listaEnviado = null;
	
	@ManagedProperty("#{cursoMB}")
	private CursoMB cursoBean;
	
	@ManagedProperty("#{escolaridadeMB}")
	private EscolaridadeMB escolaridadeBean;
	
	@ManagedProperty("#{experienciaMB}")
	private ExperienciaMB experienciaBean;
	
	@ManagedProperty("#{combinacaoIdiomaMB}")
	private CombinacaoIdiomaMB combinacaoIdiomaBean;
	
	@ManagedProperty("#{combinacaoSoftwareMB}")
	private CombinacaoSoftwareMB combinacaoSoftwareBean;
		
	/*
	 * Construtor
	 */
	public CadastroMB(){
		cadastro = this.getCadastroLogado();
	}
	
	/**
	 * Inicia processo
	 */
	@PostConstruct
	public void init(){}
	
	/*
	 * Get e Set 
	 */
	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	
	public Filtro getFiltro() {
		return filtro;
	}

	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}

	public List<Cadastro> getCadastros() {
		return cadastros;
	}

	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}
	
	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public List<ItemFiltro> getFiltros() {
		return filtros;
	}

	public void setFiltros(List<ItemFiltro> filtros) {
		this.filtros = filtros;
	}
	
	public String getSenhaTmp() {
		return senhaTmp;
	}

	public void setSenhaTmp(String senhaTmp) {
		this.senhaTmp = senhaTmp;
	}

	public String getSenhaCompara() {
		return senhaCompara;
	}

	public void setSenhaCompara(String senhaCompara) {
		this.senhaCompara = senhaCompara;
	}  
	
	public Escolaridade getEscolaridade(){
		return escolaridade;
	}
	
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	
	public EscolaridadeMB getEscolaridadeBean() {
		return escolaridadeBean;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Experiencia getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(Experiencia experiencia) {
		this.experiencia = experiencia;
	}

	/*
	 * Injetando Outros ManagerBean no CadastroMB
	 */
	
	public void setExperienciaBean(ExperienciaMB experienciaBean) {
		this.experienciaBean = experienciaBean;
	}

	public void setCursoBean(CursoMB cursoBean) {
		this.cursoBean = cursoBean;
	}

	public void setEscolaridadeBean(EscolaridadeMB escolaridadeBean) {
		this.escolaridadeBean = escolaridadeBean;
	}
	
	public void setCombinacaoIdiomaBean(CombinacaoIdiomaMB combinacaoIdiomaBean) {
		this.combinacaoIdiomaBean = combinacaoIdiomaBean;
	}

	public void setCombinacaoSoftwareBean(CombinacaoSoftwareMB combinacaoSoftwareBean) {
		this.combinacaoSoftwareBean = combinacaoSoftwareBean;
	}

	/*
	 * Navegação entre P�ginas
	 * 
	 * Rules Navigation no faces-config.xml
	 */
	public String novoCadastro() {
		this.cadastro = new Cadastro();
		return "incluir_cadastro";
	}

	public String novoCadastroCurriculo() {
		this.cadastro = new Cadastro();
		return "novo_cadastro_curriculo";
	}

	public String editarCadastro() {
		return "editar_cadastro";
	}
	
	public String inicialCadastro() {
		return "inicial_cadastro";
	}

	public String listarCadastro() {
		this.setPagina(3);
		return "listar_cadastro";
	}

	public String gerenciarCadastro() {
		this.setPagina(2);
		return "gerenciar_cadastro";
	}
	
	public String detalharCadastro() {
		return "detalhar_cadastro";
	}
		
	public String buscarCadastro() {
		this.setPagina(4);
		this.filtro = new Filtro();
		return "buscar_cadastro";
	}
		
	public String administrarCadastro(){
		this.setPagina(1);
		return "administrar_cadastro";
	}
	
	public String voltarCadastro() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarCadastro();
			this.limparFiltro();
			break;
		case 2:
			voltar = this.gerenciarCadastro();
			break;
		case 3:
			voltar = this.listarCadastro();
			break;
		case 4:
			voltar = this.buscarCadastro();
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
	
	public void salvarCadastro() {
		cadastroRN = new CadastroRN();
		if (!this.getSenhaTmp().isEmpty()){
			cadastro.setCadastro_senha(senhaTmp);
		}
		cadastroRN.salvar(cadastro);

	}
	
	public void salvarCadastroNovo() {
		cadastroRN = new CadastroRN();
		int respostaSenha = cadastroRN.compararSenhaVerificaVazio(cadastro, senhaTmp, senhaCompara);
		int respostaCpf = cadastroRN.buscarCadastro(cadastro.getCadastro_cpf());
		if (respostaSenha == 1 && respostaCpf == 0){
			cadastroRN.salvar(cadastro);
			this.novoCadastro();
		}
	}

	public List<Cadastro> listarTodosCadastros() {
		cadastroRN = new CadastroRN();
		cadastros = cadastroRN.listarTodosCadastros();
		return cadastros;
	}
	
	public List<Cadastro> filtrarCadastros() {
		cadastroRN = new CadastroRN();
		cadastros = cadastroRN.filtrarCadastros(filtro);
		filtros = cadastroRN.listaFitros(filtro);
		retorno = cadastroRN.registroEncontrados(cadastros);	
	return cadastros;
	}
	
	public String carregaStatusCadastro(){
		cadastroRN = new CadastroRN();
		return cadastroRN.carregarStatus(cadastro.getCadastro_id());
	}
	
	public String carregaSexoCadastro(){
		cadastroRN = new CadastroRN();
		return cadastroRN.carregarSexo(cadastro.getCadastro_id());
	}
	
	public void limparFiltro(){
		filtro = new Filtro();
		cadastros.clear();
		filtros.clear();
		retorno = cadastroRN.registroEncontrados(cadastros);
	}
	
	public List<Cadastro> removerFiltro(ItemFiltro item){
		filtros.remove(item);
		switch (item.getItem_filtro_identificador()) 
		{ 
		case 1: 
			filtro.setCategoria(null);
			break;
		case 2: 
			filtro.setFuncao(null);
			break;
		case 3: 
			filtro.setEstado(null);
			break;
		case 4: 
			filtro.setCidade(null);
			break;
		case 5: 
			filtro.setSalario(null);
			break;
		case 6: 
			filtro.setFormacao(null);
			break;
		case 7: 
			filtro.setIdioma(null);
			break;
		case 8: 
			filtro.setExperiencia(null);
			break;
		default:
			break;
		}
		return this.filtrarCadastros();
	}
	
	public String excluirCadastro(){
		cadastroRN = new CadastroRN();
		cadastro = cadastroRN.carregar(cadastro.getCadastro_id());
		cadastroRN.excluir(cadastro);
		return this.administrarCadastro();
	}
	
	public String atualizarCadastro(){
		cadastroRN = new CadastroRN();
		cadastroRN.salvar(cadastro);
		return this.administrarCadastro();
	}
	
	public Cadastro getCadastroLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		if (this.cadastro== null || !login.equals(this.cadastro.getCadastro_cpf())) {

			if (login != null) {
				cadastroRN = new CadastroRN();
				this.cadastro = cadastroRN.buscarPorLogin(login);
			}
		}
		return cadastro;
	}
	
	public String dataAtual() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(new Date());
	}
	
	public void adicionarEscolaridade(Escolaridade escolaridade){
		cadastro.getEscolaridades().add(escolaridade);
		escolaridadeBean.novaEscolaridade();
	}
	
	public void removerEscolaridade(Escolaridade escolaridade){
		cadastro.getEscolaridades().remove(escolaridade);
	}
	
	public void adicionarCurso(Curso curso){
		cadastro.getCursos().add(curso);
		cursoBean.novoCurso();
		//FacesUtil.exibirMensagemSucesso("Curso incluido com sucesso!");
	}
	
	public void removerCurso(Curso curso){
		cadastro.getCursos().remove(curso);
	}
	
	public void adicionarExperiencia(Experiencia experiencia){
		cadastro.getExperiencias().add(experiencia);
		experienciaBean.novaExperiencia();
	}
	
	public void removerExperiencia(Experiencia experiencia){
		cadastro.getExperiencias().remove(experiencia);
	}
	
	public void adicionarCombinacaoIdioma(Combinacao_Idioma idioma){
		cadastro.getCombinacoes_idiomas().add(idioma);
		combinacaoIdiomaBean.novaCombinacaoIdioma();
	}
	
	public void removerCombinacaoIdioma(Combinacao_Idioma idioma){
		cadastro.getCombinacoes_idiomas().remove(idioma);
	}
	
	public void adicionarCombinacaoSoftware(Combinacao_Software software){
		cadastro.getCombinacoes_softwares().add(software);
		combinacaoSoftwareBean.novaCombinacaoSoftware();
	}
	
	public void removerCombinacaoSoftware(Combinacao_Software software){
		cadastro.getCombinacoes_softwares().remove(software);
	}
/*
	
	//Metodo para criar um dialog usando API Java. Necessario de configura��es dentro do faces-config para funcionamento.
	
	public void abrirDialogo(){
		Map<String,Object> opcoes = new HashMap<String, Object>();
		opcoes.put("modal",true);
		opcoes.put("resizable", false);
		opcoes.put("contentHeight", 400);
		RequestContext.getCurrentInstance().openDialog("detalhar_escolaridade",opcoes, null);

	}
*/
	public String empregoAtual(){
		cadastroRN = new CadastroRN();
		return cadastroRN.empregoAtual(experiencia); 
	}
	
	public void gerarRelatorioCurriculo() throws JRException{
		System.out.println("Gerando relatório..."); 
		// lista com os nossos clientes 
		// compilacao do JRXML 
		JasperReport report = JasperCompileManager .compileReport("../src/br/com/jobs/jasper/cv_default.jrxml");  
		// preenchimento do relatorio, note que o metodo recebe 3 parametros: 
		// 1 - o relatorio // 
		// 2 - um Map, com parametros que sao passados ao relatorio
		// no momento do preenchimento. No nosso caso eh null, pois nao 
		// estamos usando nenhum parametro // 
		// 3 - o data source. Note que nao devemos passar a lista diretamente, 
		// e sim "transformar" em um data source utilizando a classe JRBeanCollectionDataSource 
		
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(cadastros));  
		 // exportacao do relatorio para outro formato, no caso PDF 
		
		 JasperExportManager.exportReportToPdfFile(print, "../src/br/com/jobs/jasper/cv_default.pdf");  
		 System.out.println("Relatório gerado."); 	
	}
	
	public List<Enviado> listarCandidatura(){
		cadastroRN = new CadastroRN();
		cadastro = this.getCadastro();
		listaEnviado = cadastroRN.listarCandidatura(cadastro);
		return listaEnviado;
		
	}
	
}
