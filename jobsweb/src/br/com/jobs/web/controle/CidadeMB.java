package br.com.jobs.web.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import br.com.jobs.modelo.cidade.Cidade;
import br.com.jobs.modelo.cidade.CidadeRN;
import br.com.jobs.modelo.estado.Estado;

@ManagedBean(name = "cidadeMB")
@SessionScoped
public class CidadeMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cidade cidade;
	private CidadeRN cidadeRN;
	private List<Cidade> cidades;
	private Estado estado;
	/*
	 * Construtor
	 */
	public CidadeMB() {
		super();
	}
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Cidade> listarTodasCidades() {
		cidadeRN = new CidadeRN();
		cidades = cidadeRN.listarTodasCidades();
		return cidades;
	}
	
	public List<Cidade> listarTodasPorEstado(ValueChangeEvent evento) {
		cidadeRN = new CidadeRN();
		estado = (Estado) evento.getNewValue();
		cidades = cidadeRN.listarCidadesPorEstado(estado);
		return cidades;
	}
		
	public List<Cidade> listarPorEstado(Estado estado) {
		cidadeRN = new CidadeRN();
		cidades = cidadeRN.listarCidadesPorEstado(estado);
		return cidades;
	}


}
