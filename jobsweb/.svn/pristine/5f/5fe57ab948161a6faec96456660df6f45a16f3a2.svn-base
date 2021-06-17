package br.com.jobs.combinacao.idioma;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class Combinacao_IdiomaDAOImpl implements Combinacao_IdiomaDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Combinacao_Idioma combinacaoIdioma) {
		this.session.save(combinacaoIdioma);
	}

	public void atualizar(Combinacao_Idioma combinacaoIdioma) {
		this.session.update(combinacaoIdioma);
	}

	public void excluir(Combinacao_Idioma combinacaoIdioma) {
		this.session.delete(combinacaoIdioma);
	}

	public Combinacao_Idioma carregar(Integer codigo) {
		return (Combinacao_Idioma) this.session.get(Combinacao_Idioma.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Combinacao_Idioma> listarTodos() {
		return this.session.createCriteria(Combinacao_Idioma.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Combinacao_Idioma> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Combinacao_Idioma.class);
		criteria.add(Restrictions.eq("combinacao_idioma_status", true));
		criteria.addOrder(Order.asc("idioma"));
		return criteria.list();
	}

	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_combinacao_idioma"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}
	
}
