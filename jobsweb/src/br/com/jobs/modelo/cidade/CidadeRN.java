package br.com.jobs.modelo.cidade;

import java.util.List;

import br.com.jobs.modelo.estado.Estado;
import br.com.jobs.persistencia.DAOFactory;

public class CidadeRN {
	
	private CidadeDAO cidadeDAO;
	
	public CidadeRN() {
		this.cidadeDAO = DAOFactory.criarCidadeDAO();
	}
	
	public List<Cidade> listarTodasCidades() {
		return this.cidadeDAO.listarTodas();
	}
	
	public List<Cidade> listarCidadesPorEstado(Estado estado){
		return this.cidadeDAO.listarTodas(estado);
	}

}
