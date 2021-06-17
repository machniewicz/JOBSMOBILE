package br.com.jobs.modelo.categoria;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class CategoriaDAOImpl implements CategoriaDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Categoria categoria) {
		this.session.save(categoria);
	}

	@Override
	public void atualizar(Categoria categoria) {
		this.session.update(categoria);
	}

	@Override
	public void excluir(Categoria categoria) {
		this.session.delete(categoria);
	}

	@Override
	public Categoria carregar(Integer categoriaCodigo) {
		return (Categoria) this.session.get(Categoria.class, categoriaCodigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listarTodos() {
		return this.session.createCriteria(Categoria.class).list();
	}

	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_categoria"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
		}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listarTodosAtivos() {
		Criteria criteria = this.session.createCriteria(Categoria.class);
		criteria.add(Restrictions.eq("categoria_status", true));
		criteria.addOrder(Order.asc("categoria_descricao"));
		return criteria.list();
	}
	
}


