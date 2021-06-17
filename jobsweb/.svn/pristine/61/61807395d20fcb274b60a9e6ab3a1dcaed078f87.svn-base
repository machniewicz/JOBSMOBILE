package br.com.jobs.modelo.estado;

import java.util.List;

import org.hibernate.Session;

public class EstadoDAOImpl implements EstadoDAO{

	private Session	session;
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> listarTodos() {
		return this.session.createCriteria(Estado.class).list();
	
	}

}
