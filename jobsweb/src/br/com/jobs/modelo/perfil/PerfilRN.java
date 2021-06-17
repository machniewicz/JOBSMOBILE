package br.com.jobs.modelo.perfil;

import java.util.List;

import br.com.jobs.persistencia.DAOFactory;

public class PerfilRN {

	private PerfilDAO perfilDao;
	
	public PerfilRN(){
		this.perfilDao = DAOFactory.criarPerfilDAO();
	}
	
	public List<Perfil> listarTodosPerfis() {
		return this.perfilDao.listar();
	}
}
