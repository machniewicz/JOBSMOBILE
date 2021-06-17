package br.com.jobs.modelo.situacao;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class SituacaoDAOImpl implements SituacaoDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Situacao situacao) {
		this.session.save(situacao);
	}

	@Override
	public void atualizar(Situacao situacao) {
		this.session.update(situacao);
	}

	@Override
	public void excluir(Situacao situacao) {
		this.session.delete(situacao);
	}

	@Override
	public Situacao carregar(Integer situacao_id) {
		return (Situacao) this.session.get(Situacao.class, situacao_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Situacao> listarTodos() {
		return this.session.createCriteria(Situacao.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Situacao> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Situacao.class);
		criteria.add(Restrictions.eq("situacao_status", true));
		criteria.addOrder(Order.asc("situacao_id"));
		return criteria.list();
		}

	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_situacao"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
		}
	
}
