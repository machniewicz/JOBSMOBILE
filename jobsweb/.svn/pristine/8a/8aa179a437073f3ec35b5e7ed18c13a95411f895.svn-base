package br.com.jobs.web.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.cidade.Cidade;
import br.com.jobs.modelo.cidade.CidadeRN;
import br.com.jobs.modelo.estado.Estado;
import br.com.jobs.modelo.estado.EstadoRN;

@ManagedBean(name = "estadoMB")
@SessionScoped
public class EstadoMB {

	private Estado estado;
	private EstadoRN estadoRN;
	private CidadeRN cidadeRN;
	private List<Estado> lista;
	private List<Cidade> listaCidade;

	/*
	 * Construtor
	 */
	public EstadoMB() {
		super();
	}
	
	public List<Estado> listarTodosEstados() {
		estadoRN = new EstadoRN();
		lista = estadoRN.listarTodosEstados();
		return lista;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
		
	public List<Cidade> listarTodasPorEstado() {
		cidadeRN = new CidadeRN();
		estado  = this.getEstado();
		listaCidade = cidadeRN.listarCidadesPorEstado(estado);
		return listaCidade;
	}
}
