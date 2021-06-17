package br.com.jobs.modelo.vaga;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class VagaDAOImpl implements VagaDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Vaga vaga) {
		this.session.save(vaga);
	}

	public void atualizar(Vaga vaga) {
		this.session.update(vaga);
	}

	public void excluir(Vaga vaga) {
		this.session.delete(vaga);
	}

	public Vaga carregar(Integer codigo) {
		return (Vaga) this.session.get(Vaga.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Vaga> listar() {
		return this.session.createCriteria(Vaga.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vaga> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Vaga.class);
		criteria.add(Restrictions.eq("vaga_status", true));
		criteria.addOrder(Order.asc("vaga_descricao"));
		return criteria.list();
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_vaga"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

}
