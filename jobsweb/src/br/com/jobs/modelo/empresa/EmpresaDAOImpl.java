package br.com.jobs.modelo.empresa;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class EmpresaDAOImpl implements	EmpresaDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Empresa empresa) {
		this.session.save(empresa);
	}

	public void atualizar(Empresa empresa) {
		this.session.update(empresa);
	}

	public void excluir(Empresa empresa) {
		this.session.delete(empresa);
	}

	public Empresa carregar(Integer codigo) {
		return (Empresa) this.session.get(Empresa.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> listar() {
		return this.session.createCriteria(Empresa.class).list();
	}

	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_empresa"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> listarEmpresasAtivasValida() {
		Criteria criteria = this.session.createCriteria(Empresa.class);
		criteria.add(Restrictions.eq("empresa_status", true));
		criteria.addOrder(Order.asc("empresa_razao"));
		return criteria.list();
	}

}
