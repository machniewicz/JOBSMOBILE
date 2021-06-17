package br.com.jobs.modelo.vendedor;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class VendedorDAOImpl implements VendedorDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Vendedor vendedor) {
		this.session.save(vendedor);
	}

	public void atualizar(Vendedor vendedor) {
		this.session.update(vendedor);
	}

	public void excluir(Vendedor vendedor) {
		this.session.delete(vendedor);
	}

	public Vendedor carregar(Integer codigo) {
		return (Vendedor) this.session.get(Vendedor.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Vendedor> listar() {
		return this.session.createCriteria(Vendedor.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendedor> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Vendedor.class);
		criteria.add(Restrictions.eq("vendedor_status", true));
		criteria.addOrder(Order.asc("vendedor_id"));
		return criteria.list();
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_vendedor"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

}
