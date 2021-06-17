package br.com.jobs.modelo.software;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class SoftwareDAOImpl implements SoftwareDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Software software) {
		this.session.save(software);
	}

	public void atualizar(Software software) {
		this.session.update(software);
	}

	public void excluir(Software software) {
		this.session.delete(software);
	}

	public Software carregar(Integer codigo) {
		return (Software) this.session.get(Software.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Software> listar() {
		return this.session.createCriteria(Software.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Software> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Software.class);
		criteria.add(Restrictions.eq("software_status", true));
		criteria.addOrder(Order.asc("software_descricao"));
		return criteria.list();
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_software"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

}
