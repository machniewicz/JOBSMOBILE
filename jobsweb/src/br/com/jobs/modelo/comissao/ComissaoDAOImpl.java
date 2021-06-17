package br.com.jobs.modelo.comissao;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ComissaoDAOImpl implements ComissaoDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Comissao comissao) {
		this.session.save(comissao);
	}

	public void atualizar(Comissao comissao) {
		this.session.update(comissao);
	}

	public void excluir(Comissao comissao) {
		this.session.delete(comissao);
	}

	public Comissao carregar(Integer codigo) {
		return (Comissao) this.session.get(Comissao.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Comissao> listar() {
		return this.session.createCriteria(Comissao.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comissao> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Comissao.class);
		criteria.add(Restrictions.eq("comissao_status", true));
		criteria.addOrder(Order.asc("comissao_id"));
		return criteria.list();
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_comissao"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

}
