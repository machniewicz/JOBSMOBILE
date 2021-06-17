package br.com.jobs.modelo.ajudadecusto;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AjudaDeCustoDAOImpl implements AjudaDeCustoDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(AjudaDeCusto ajuda) {
		this.session.save(ajuda);
	}

	public void atualizar(AjudaDeCusto ajuda) {
		this.session.update(ajuda);
	}

	public void excluir(AjudaDeCusto ajuda) {
		this.session.delete(ajuda);
	}

	public AjudaDeCusto carregar(Integer codigo) {
		return (AjudaDeCusto) this.session.get(AjudaDeCusto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<AjudaDeCusto> listar() {
		return this.session.createCriteria(AjudaDeCusto.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AjudaDeCusto> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(AjudaDeCusto.class);
		criteria.add(Restrictions.eq("ajudadecusto_status", true));
		criteria.addOrder(Order.asc("ajudadecusto_descricao"));
		return criteria.list();
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_ajudadecusto"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

}
