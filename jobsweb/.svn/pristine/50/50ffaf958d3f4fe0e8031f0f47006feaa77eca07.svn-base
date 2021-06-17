package br.com.jobs.modelo.funcao;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.jobs.modelo.categoria.Categoria;

public class FuncaoDAOImpl implements FuncaoDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Funcao funcao) {
		this.session.save(funcao);
	}

	public void atualizar(Funcao funcao) {
		this.session.update(funcao);
	}

	public void excluir(Funcao funcao) {
		this.session.delete(funcao);
	}

	public Funcao carregar(Integer codigo) {
		return (Funcao) this.session.get(Funcao.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Funcao> listar() {
		return this.session.createCriteria(Funcao.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcao> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Funcao.class);
		criteria.add(Restrictions.eq("funcao_status", true));
		criteria.addOrder(Order.asc("funcao_descricao"));
		return criteria.list();
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_funcao"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Funcao> listarTodosPorCategoria(Categoria categoria) {
		Criteria criteria = this.session.createCriteria(Funcao.class);
		criteria.add(Restrictions.eq("categoria", categoria));
		criteria.add(Restrictions.eq("funcao_status", true));
		criteria.addOrder(Order.asc("funcao_descricao"));
		return criteria.list();
	}

}
