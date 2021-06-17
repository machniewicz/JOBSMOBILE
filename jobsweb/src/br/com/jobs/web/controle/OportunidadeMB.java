package br.com.jobs.web.controle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.com.jobs.combinacao.idioma.Combinacao_Idioma;
import br.com.jobs.combinacao.software.Combinacao_Software;
import br.com.jobs.modelo.categoria.Categoria;
import br.com.jobs.modelo.oportunidade.Oportunidade;
import br.com.jobs.modelo.oportunidade.OportunidadeRN;
import br.com.jobs.modelo.usuario.Usuario;

@ManagedBean (name="oportunidadeMB")
@SessionScoped
public class OportunidadeMB {
	
	private Oportunidade oportunidade;
	private OportunidadeRN oportunidadeRN;
	private Usuario usuario;
	private Categoria categoria;
	private Combinacao_Idioma combinacao_idioma;
	private Combinacao_Software combinacao_software;
	private Integer pagina;
	private Integer quantidade;
	private List<Oportunidade> lista = null;
	
	@ManagedProperty("#{combinacaoIdiomaMB}")
	private CombinacaoIdiomaMB combinacaoIdiomaBean;
	
	@ManagedProperty("#{combinacaoSoftwareMB}")
	private CombinacaoSoftwareMB combinacaoSoftwareBean;
	
   /*
	* Construtor da Classe
	*/
	public OportunidadeMB(){
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

	public Oportunidade getOportunidade() {
		return oportunidade;
	}

	public void setOportunidade(Oportunidade oportunidade) {
		this.oportunidade = oportunidade;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Combinacao_Software getCombinacao_software() {
		return combinacao_software;
	}

	public void setCombinacao_software(Combinacao_Software combinacao_software) {
		this.combinacao_software = combinacao_software;
	}

	public Combinacao_Idioma getCombinacao_idioma() {
		return combinacao_idioma;
	}

	public void setCombinacao_idioma(Combinacao_Idioma combinacao_idioma) {
		this.combinacao_idioma = combinacao_idioma;
	}

	public OportunidadeRN getOportunidadeRN() {
		return oportunidadeRN;
	}

	public void setOportunidadeRN(OportunidadeRN oportunidadeRN) {
		this.oportunidadeRN = oportunidadeRN;
	}

	public List<Oportunidade> getLista() {
		return lista;
	}

	public void setLista(List<Oportunidade> lista) {
		this.lista = lista;
	}

	public CombinacaoIdiomaMB getCombinacaoIdiomaBean() {
		return combinacaoIdiomaBean;
	}

	public void setCombinacaoIdiomaBean(CombinacaoIdiomaMB combinacaoIdiomaBean) {
		this.combinacaoIdiomaBean = combinacaoIdiomaBean;
	}
	
	public CombinacaoSoftwareMB getCombinacaoSoftwareBean() {
		return combinacaoSoftwareBean;
	}

	public void setCombinacaoSoftwareBean(
			CombinacaoSoftwareMB combinacaoSoftwareBean) {
		this.combinacaoSoftwareBean = combinacaoSoftwareBean;
	}

	/*
	 * Navega��o entre P�ginas
	 * 
	 * Rules Navigation no faces-config.xml
	 */
	public String novaOportunidade() {
		this.oportunidade = new Oportunidade();
		return "incluir_oportunidade";
	}
	
	public String listarOportunidade() {
		this.setPagina(3);
		return "listar_oportunidade";
	}

	public String gerenciarOportunidade() {
		this.setPagina(2);
		return "gerenciar_oportunidade";
	}
	
	public String editarOportunidade() {
		return "editar_oportunidade";
	}
	
	public String detalharOportunidade() {
		this.setPagina(1);
		return "detalhar_oportunidade";
	}
	
	public String administrarOportunidade(){
		this.setPagina(1);
		return "administrar_oportunidade";
	}
	
	public String administrarOportunidadeTodos(){
		this.setPagina(4);
		return "administrar_oportunidade_todos";
	}
	
	public String voltarOportunidade() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarOportunidade();
			break;
		case 2:
			voltar = this.gerenciarOportunidade();
			break;
		case 3:
			voltar = this.listarOportunidade();
			break;
		case 4:
			voltar = this.administrarOportunidadeTodos();
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
	public void salvarOportunidade(){
		oportunidadeRN = new OportunidadeRN();
		oportunidadeRN.salvar(oportunidade);
		this.novaOportunidade();
	}
	
	public String dataAtual() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(new Date());
	}
 
	public List<Oportunidade> listarTodasOportunidades() {
		oportunidadeRN = new OportunidadeRN();
		usuario = oportunidadeRN.buscarUsuario();
		lista = oportunidadeRN.listar(usuario);
		return lista;
	}
	
	public List<Oportunidade> carregarTodasOportunidades() {
		oportunidadeRN = new OportunidadeRN();
		lista = oportunidadeRN.listarTodos();
		return lista;
	}

	
	public List<Oportunidade> gerenciarTodasOportunidades() {
		oportunidadeRN = new OportunidadeRN();
		usuario = this.getUsuario();
		lista = oportunidadeRN.listar(usuario);
		return lista;
	}
	
	public List<Oportunidade> administrarTodasOportunidades() {
		oportunidadeRN = new OportunidadeRN();
		usuario = this.getUsuario();
		lista = oportunidadeRN.listar(usuario);
		return lista;
	}
	
	public List<Oportunidade> administrarTodasOportunidadesEnviado() {
		oportunidadeRN = new OportunidadeRN();
		lista = oportunidadeRN.listarTodos();
		setQuantidade(lista.size());
		return lista;
	}
	
	public String atualizarOportunidade(){
		String retorno = null;
		oportunidadeRN = new OportunidadeRN();
		oportunidadeRN.salvar(oportunidade);
		retorno = this.administrarOportunidade();
		return retorno;
	}
	
	public String excluirOportunidade(){
		oportunidadeRN = new OportunidadeRN();
		oportunidade = oportunidadeRN.carregar(oportunidade.getOportunidade_id());
		oportunidadeRN.excluir(oportunidade);
		return this.administrarOportunidade();
	}
	
	public void ativarOportunidade(){
		oportunidadeRN = new OportunidadeRN();
		oportunidadeRN.ativarOportunidade(oportunidade);
	}
	
	public String carregaStatusOportunidade(){
		oportunidadeRN = new OportunidadeRN();
		return oportunidadeRN.carregarStatus(oportunidade.getOportunidade_id());
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void adicionarCombinacaoIdioma(Combinacao_Idioma combinacaoIdioma){
		oportunidade.getCombinacoes_idiomas().add(combinacaoIdioma);
		combinacaoIdiomaBean.novaCombinacaoIdioma();
	}
	
	public void removerCombinacaoIdioma(Combinacao_Idioma combinacao_idioma){
		oportunidade.getCombinacoes_idiomas().remove(combinacao_idioma);
	}
	
	public void adicionarCombinacaoSoftware(Combinacao_Software combinacaoSoftware){
		oportunidade.getCombinacoes_softwares().add(combinacaoSoftware);
		combinacaoSoftwareBean.novaCombinacaoSoftware();
	}
	
	public void removerCombinacaoSoftware(Combinacao_Software combinacao_software){
		oportunidade.getCombinacoes_softwares().remove(combinacao_software);
	}
		
}

