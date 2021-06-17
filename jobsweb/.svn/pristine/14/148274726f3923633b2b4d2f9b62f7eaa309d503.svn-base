package br.com.jobs.modelo.idioma;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class IdiomaDAOImpl implements IdiomaDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Idioma idioma) {
		this.session.save(idioma);
	}

	public void atualizar(Idioma idioma) {
		this.session.update(idioma);
	}

	public void excluir(Idioma idioma) {
		this.session.delete(idioma);
	}

	public Idioma carregar(Integer codigo) {
		return (Idioma) this.session.get(Idioma.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Idioma> listar() {
		Criteria criteria = this.session.createCriteria(Idioma.class);
		criteria.addOrder(Order.asc("idioma_descricao"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Idioma> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Idioma.class);
		criteria.add(Restrictions.eq("idioma_status", true));
		criteria.addOrder(Order.asc("idioma_descricao"));
		return criteria.list();
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_idioma"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

}
