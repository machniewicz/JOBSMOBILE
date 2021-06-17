package br.com.jobs.modelo.enviado;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.oportunidade.Oportunidade;

public class EnviadoDaoImpl implements EnviadoDAO{

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Enviado enviado) {
		session.save(enviado);
		
	}

	@Override
	public void atualizar(Enviado enviado) {
		session.update(enviado);
	}

	@Override
	public void excluir(Enviado enviado) {
		session.delete(enviado);
		
	}

	@Override
	public Enviado carregar(Integer enviado_id) {
		return (Enviado) this.session.get(Enviado.class, enviado_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enviado> listar(Oportunidade oportunidade) {
		Criteria criteria = this.session.createCriteria(Enviado.class);
		criteria.add(Restrictions.eq("oportunidade", oportunidade));
		return criteria.list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EnviadoGrafico> listaDadosGrafico(Integer oportunidade_id) {
		String hql = MessageFormat.format(bundleQuery.getString("query_grafico_enviado"), ":codigoOportunidade");
		//String hql = "select count(*) as quantidade, e.enviado_data as data from enviado e where oportunidade_id = 18 group by e.enviado_data";
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigoOportunidade", oportunidade_id);
		System.out.println("Quantidade de registros:"+consulta.list().size());
		return consulta.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Enviado> listarEnviado(Cadastro cadastro) {
		Criteria criteria = this.session.createCriteria(Enviado.class);
		criteria.add(Restrictions.eq("cadastro", cadastro));
		return criteria.list();

	}

}
