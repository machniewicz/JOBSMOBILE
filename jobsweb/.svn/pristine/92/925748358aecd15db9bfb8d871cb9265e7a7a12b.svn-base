package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.vaga.Vaga;
import br.com.jobs.modelo.vaga.VagaRN;

@ManagedBean(name = "vagaMB")
@SessionScoped
public class VagaMB {

	private Vaga vaga;
	private Integer pagina;
	private VagaRN vagaRN;
	private List<Vaga> lista;

	/*
	 * Construtor
	 */
	public VagaMB(){
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
	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	public List<Vaga> getVagas(){
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
	public String novaVaga() {
		this.vaga = new Vaga();
		return "incluir_vaga";
	}

	public String editarVaga(){
		this.vaga.getVaga_descricao();
		return "editar_vaga";
	}

	public String listarVaga() {
		this.setPagina(3);
		return "listar_vaga";
	}

	public String gerenciarVaga() {
		this.setPagina(2);
		return "gerenciar_vaga";
	}
	
	public String detalharVaga() {
		return "detalhar_vaga";
	}
	
	public String administrarVaga(){
		this.setPagina(1);
		return "administrar_vaga";
	}
	
	public String voltarVaga() {
		int pagina = this.getPagina();
		String voltar = null;
		switch (pagina) {
		case 1:
			voltar = this.administrarVaga();
			break;
		case 2:
			voltar = this.gerenciarVaga();
			break;
		case 3:
			voltar = this.listarVaga();
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
	
	public void salvarVaga() {
		vagaRN = new VagaRN();
		vagaRN.salvar(vaga);
		this.novaVaga();
	}

	public String ativarVaga(){
		if(this.vaga.getVaga_status().equals(false)){
			this.vaga.setVaga_status(true);
		}
		else{
			this.vaga.setVaga_status(false);
		}
		return null;
	}
	
	public List<Vaga> listarTodasVagas() {
		vagaRN = new VagaRN();
		lista = vagaRN.listarTodosVaga();
		return lista;
	}
	
	public List<Vaga> listarTodasVagasAtivas() {
		vagaRN = new VagaRN();
		lista = vagaRN.listarTodosVagaAtivos();
		return lista;
	}
	
	public String carregaStatusVaga(){
		vagaRN = new VagaRN();
		return vagaRN.carregarStatus(vaga.getVaga_id());
	}
	
	public String excluirVaga(){
		vagaRN = new VagaRN();
		vaga = vagaRN.carregar(vaga.getVaga_id());
		vagaRN.excluir(vaga);
		return this.administrarVaga();
	}
	
	public String atualizarVaga(){
		vagaRN = new VagaRN();
		vagaRN.salvar(vaga);
		return this.administrarVaga();
	}
}
