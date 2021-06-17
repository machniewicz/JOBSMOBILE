package br.com.jobs.modelo.perfil;

import java.util.List;

import org.hibernate.Session;

public class PerfilDAOImpl implements PerfilDAO {

	private Session	session;

	public void setSession(Session session) {
		this.session = session;
	}

	public void salvar(Perfil perfil) {
		this.session.save(perfil);
	}

	public void atualizar(Perfil perfil) {

		this.session.update(perfil);
	}

	public void excluir(Perfil perfil) {
		this.session.delete(perfil);
	}

	public Perfil carregar(Integer codigo) {
		//TODO o hibernate nao conseguira fazer a carga caso seja passado o Usuario
		// no parametro, tem que ser diretamente a chave (integer)
		return (Perfil) this.session.get(Perfil.class, codigo);
	}

	
	@SuppressWarnings("unchecked")
	public List<Perfil> listar() {
		return this.session.createCriteria(Perfil.class).list();
	}

}
