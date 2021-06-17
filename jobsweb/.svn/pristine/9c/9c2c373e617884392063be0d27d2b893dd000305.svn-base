package br.com.jobs.modelo.beneficio;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class BeneficioDAOImpl implements BeneficioDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Beneficio beneficio) {
		this.session.save(beneficio);
	}

	public void atualizar(Beneficio beneficio) {
		this.session.update(beneficio);
	}

	public void excluir(Beneficio beneficio) {
		this.session.delete(beneficio);
	}

	public Beneficio carregar(Integer codigo) {
		return (Beneficio) this.session.get(Beneficio.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Beneficio> listar() {
		return this.session.createCriteria(Beneficio.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Beneficio> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Beneficio.class);
		criteria.add(Restrictions.eq("beneficio_status", true));
		criteria.addOrder(Order.asc("beneficio_descricao"));
		return criteria.list();
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_beneficio"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

}
