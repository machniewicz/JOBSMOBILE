package br.com.jobs.modelo.formacao;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class FormacaoDAOImpl implements FormacaoDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Formacao formacao) {
		this.session.save(formacao);
	}

	@Override
	public void atualizar(Formacao formacao) {
		this.session.update(formacao);
	}

	@Override
	public void excluir(Formacao formacao) {
		this.session.delete(formacao);
	}

	@Override
	public Formacao carregar(Integer formacao_id) {
		return (Formacao) this.session.get(Formacao.class, formacao_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formacao> listarTodos() {
		return this.session.createCriteria(Formacao.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formacao> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Formacao.class);
		criteria.add(Restrictions.eq("formacao_status", true));
		criteria.addOrder(Order.asc("formacao_id"));
		return criteria.list();
		}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_formacao"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
		}
}
