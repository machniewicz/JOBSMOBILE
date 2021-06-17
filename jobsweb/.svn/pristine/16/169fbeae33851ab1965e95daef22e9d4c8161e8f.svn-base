package br.com.jobs.modelo.meta;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class MetaDAOImpl implements MetaDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Meta meta) {
		this.session.save(meta);
	}

	public void atualizar(Meta meta) {
		this.session.update(meta);
	}

	public void excluir(Meta meta) {
		this.session.delete(meta);
	}

	public Meta carregar(Integer codigo) {
		return (Meta) this.session.get(Meta.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Meta> listar() {
		return this.session.createCriteria(Meta.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Meta> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Meta.class);
		criteria.add(Restrictions.eq("meta_status", true));
		criteria.addOrder(Order.asc("meta_id"));
		return criteria.list();
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_meta"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

}
