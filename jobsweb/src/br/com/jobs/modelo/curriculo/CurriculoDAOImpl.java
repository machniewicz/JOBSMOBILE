package br.com.jobs.modelo.curriculo;

import java.util.List;

import org.hibernate.Session;

public class CurriculoDAOImpl implements CurriculoDAO {

	private Session	session;
	//private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Curriculo curriculo) {
		this.session.save(curriculo);
	}

	@Override
	public void atualizar(Curriculo curriculo) {
		this.session.update(curriculo);
	}

	@Override
	public void excluir(Curriculo curriculo) {
		this.session.delete(curriculo);
	}

	@Override
	public Curriculo carregar(Integer curriculo_id) {
		return (Curriculo) this.session.get(Curriculo.class, curriculo_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curriculo> listarTodos() {
		return this.session.createCriteria(Curriculo.class).list();
	}

}
