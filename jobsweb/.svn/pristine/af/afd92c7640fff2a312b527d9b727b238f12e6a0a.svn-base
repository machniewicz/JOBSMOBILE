package br.com.jobs.combinacao.software;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class Combinacao_SoftwareDAOImpl implements Combinacao_SoftwareDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Combinacao_Software combinacaoSoftware) {
		this.session.save(combinacaoSoftware);
	}

	public void atualizar(Combinacao_Software combinacaoSoftware) {
		this.session.update(combinacaoSoftware);
	}

	public void excluir(Combinacao_Software combinacaoSoftware) {
		this.session.delete(combinacaoSoftware);
	}

	public Combinacao_Software carregar(Integer codigo) {
		return (Combinacao_Software) this.session.get(Combinacao_Software.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Combinacao_Software> listarTodos() {
		return this.session.createCriteria(Combinacao_Software.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Combinacao_Software> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Combinacao_Software.class);
		criteria.add(Restrictions.eq("combinacao_software_status", true));
		criteria.addOrder(Order.asc("software"));
		return criteria.list();
	}

	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_combinacao_software"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}
	
}
