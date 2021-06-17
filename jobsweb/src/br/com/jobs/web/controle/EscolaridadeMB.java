package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.escolaridade.Escolaridade;

@ManagedBean(name = "escolaridadeMB")
@SessionScoped
public class EscolaridadeMB {

	private Escolaridade escolaridade;
	private List<Escolaridade> escolaridades;

	/*
	 * Construtor
	 */
	public EscolaridadeMB(){
		super();
		escolaridade = new Escolaridade();
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
		
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}

	public List<Escolaridade> getLista() {
		return escolaridades;
	}

	public void setLista(List<Escolaridade> lista) {
		this.escolaridades = lista;
	}

	/*
	public String excluirEscolaridade(){
		escolaridadeRN = new EscolaridadeRN();
		escolaridade = escolaridadeRN.carregar(escolaridade.getEscolaridade_id());
		escolaridadeRN.excluir(escolaridade);
		return this.administrarEscolaridade();
	}
	*/
	
	public void novaEscolaridade(){
		escolaridade = new Escolaridade();
	}
}
