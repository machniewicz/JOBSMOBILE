package br.com.jobs.modelo.escolaridade;

import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.jobs.modelo.cadastro.Cadastro;

public class EscolaridadeDAOImpl implements EscolaridadeDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Escolaridade escolaridade) {
		this.session.save(escolaridade);
	}

	@Override
	public void atualizar(Escolaridade escolaridade) {
		this.session.update(escolaridade);
	}

	@Override
	public void excluir(Escolaridade escolaridade) {
		this.session.delete(escolaridade);
	}

	@Override
	public Escolaridade carregar(Integer escolaridade_id) {
		return (Escolaridade) this.session.get(Escolaridade.class, escolaridade_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Escolaridade> listarTodos() {
		return this.session.createCriteria(Escolaridade.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Escolaridade> listarTodosPorCadastro(Cadastro cadastro) {
		Criteria criteria = this.session.createCriteria(Escolaridade.class);
		//criteria.addOrder(Order.asc("oportunidade_data"));
		criteria.add(Restrictions.eq("cadastro", cadastro));
		return criteria.list();
	}

	
}
