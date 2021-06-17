package br.com.jobs.modelo.estado;

import java.util.List;

import br.com.jobs.persistencia.DAOFactory;

public class EstadoRN {
	
	private EstadoDAO estadoDAO;
	
	public EstadoRN() {
		this.estadoDAO = DAOFactory.criarEstadoDAO();
	}
	
	public List<Estado> listarTodosEstados() {
		return this.estadoDAO.listarTodos();
	}

}
