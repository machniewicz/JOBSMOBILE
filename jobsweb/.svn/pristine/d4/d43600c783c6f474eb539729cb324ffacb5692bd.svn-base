package br.com.jobs.modelo.estatistica;

import java.util.List;

import org.hibernate.Session;

public class EstatisticaDAOImpl implements EstatisticaDAO {

	private Session	session;
    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Estatistica estatistica) {
		session.save(estatistica);
	}

	@Override
	public void atualizar(Estatistica estatistica) {
		session.update(estatistica);
	}

	@Override
	public void excluir(Estatistica estatistica) {
		session.delete(estatistica);
	}

	@Override
	public Estatistica carregar(Integer estatistica_id) {
		return (Estatistica) this.session.get(Estatistica.class, estatistica_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estatistica> listarTodos() {
		return this.session.createCriteria(Estatistica.class).list();	
	}

}
