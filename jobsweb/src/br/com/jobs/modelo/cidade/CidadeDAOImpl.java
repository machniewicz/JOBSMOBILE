package br.com.jobs.modelo.cidade;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.jobs.modelo.estado.Estado;

public class CidadeDAOImpl implements CidadeDAO{

	private Session	session;
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> listarTodas() {
		return this.session.createCriteria(Cidade.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> listarTodas(Estado estado) {
		Criteria criteria = this.session.createCriteria(Cidade.class);
		criteria.add(Restrictions.eq("estado", estado));
		criteria.addOrder(Order.asc("cidade_descricao"));
		return criteria.list();
	}

}
