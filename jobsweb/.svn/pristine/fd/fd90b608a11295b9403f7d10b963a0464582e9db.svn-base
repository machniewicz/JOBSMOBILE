package br.com.jobs.modelo.curso;

import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.jobs.modelo.cadastro.Cadastro;

public class CursoDAOImpl implements CursoDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Curso curso) {
		this.session.save(curso);
	}

	@Override
	public void atualizar(Curso curso) {
		this.session.update(curso);
	}

	@Override
	public void excluir(Curso curso) {
		this.session.delete(curso);
	}

	@Override
	public Curso carregar(Integer curso_id) {
		return (Curso) this.session.get(Curso.class, curso_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarTodos() {
		return this.session.createCriteria(Curso.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listarTodosPorCadastro(Cadastro cadastro) {
		Criteria criteria = this.session.createCriteria(Curso.class);
		//criteria.addOrder(Order.asc("oportunidade_data"));
		criteria.add(Restrictions.eq("cadastro", cadastro));
		return criteria.list();
	}

	
}
