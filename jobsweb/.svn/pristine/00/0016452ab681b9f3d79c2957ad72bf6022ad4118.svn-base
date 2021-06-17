package br.com.jobs.modelo.nivel;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class NivelDAOImpl implements NivelDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Nivel nivel) {
		this.session.save(nivel);
	}

	public void atualizar(Nivel nivel) {
		this.session.update(nivel);
	}

	public void excluir(Nivel nivel) {
		this.session.delete(nivel);
	}

	public Nivel carregar(Integer codigo) {
		return (Nivel) this.session.get(Nivel.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Nivel> listar() {
		Criteria criteria = this.session.createCriteria(Nivel.class);
		criteria.addOrder(Order.asc("nivel_descricao"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Nivel> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Nivel.class);
		criteria.add(Restrictions.eq("nivel_status", true));
		criteria.addOrder(Order.asc("nivel_descricao"));
		return criteria.list();
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_nivel"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

}
