package br.com.jobs.modelo.salario;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class SalarioDAOImpl implements SalarioDAO{

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	@Override
	public void salvar(Salario salario) {
		this.session.save(salario);
	}

	@Override
	public void atualizar(Salario salario) {
		this.session.update(salario);		
	}

	@Override
	public void excluir(Salario salario) {
		this.session.delete(salario);
		
	}

	@Override
	public Salario carregar(Integer salario_id) {
		return (Salario) this.session.get(Salario.class, salario_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Salario> listarTodos() {
		return this.session.createCriteria(Salario.class).list();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Salario> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Salario.class);
		criteria.add(Restrictions.eq("salario_status", true));
		criteria.addOrder(Order.asc("salario_id"));
		return criteria.list();
		}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_salario"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
		}

}
