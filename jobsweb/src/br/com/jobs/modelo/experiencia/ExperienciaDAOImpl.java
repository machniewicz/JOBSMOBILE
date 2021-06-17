package br.com.jobs.modelo.experiencia;

import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.jobs.modelo.cadastro.Cadastro;

public class ExperienciaDAOImpl implements ExperienciaDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Experiencia experiencia) {
		this.session.save(experiencia);
	}

	@Override
	public void atualizar(Experiencia experiencia) {
		this.session.update(experiencia);
	}

	@Override
	public void excluir(Experiencia experiencia) {
		this.session.delete(experiencia);
	}

	@Override
	public Experiencia carregar(Integer experiencia_id) {
		return (Experiencia) this.session.get(Experiencia.class, experiencia_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Experiencia> listarTodos() {
		return this.session.createCriteria(Experiencia.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Experiencia> listarTodosPorCadastro(Cadastro cadastro) {
		Criteria criteria = this.session.createCriteria(Experiencia.class);
		//criteria.addOrder(Order.asc("oportunidade_data"));
		criteria.add(Restrictions.eq("cadastro", cadastro));
		return criteria.list();
	}

	
}
