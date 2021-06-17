package br.com.jobs.modelo.oportunidade;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.empresa.Empresa;
import br.com.jobs.modelo.usuario.Usuario;
import br.com.jobs.web.util.Filtro;

public class OportunidadeDAOImpl implements OportunidadeDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public Session getSession() {
		return session;
	}
	 	 
	@Override
	public void salvar(Oportunidade oportunidade) {
		this.session.clear();
		this.session.save(oportunidade);			
	}

	@Override
	public void excluir(Oportunidade oportunidade) {
		this.session.delete(oportunidade);
	}

	@Override
	public Oportunidade carregar(Integer oportunidade_id) {
		return (Oportunidade) this.session.get(Oportunidade.class, oportunidade_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Oportunidade> listar(Usuario usuario) {
		Criteria criteria = this.session.createCriteria(Oportunidade.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.addOrder(Order.desc("oportunidade_status"));
		criteria.addOrder(Order.desc("oportunidade_data"));
		return criteria.list();
	}

	@Override
	public void atualizar(Oportunidade oportunidade) {
		this.session.clear();
		this.session.update(oportunidade);
	}
	
	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_oportunidade"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Oportunidade> listarTodos() {
		Criteria criteria = this.session.createCriteria(Oportunidade.class);
		criteria.add(Restrictions.eq("oportunidade_status", true));
		criteria.addOrder(Order.desc("oportunidade_data"));
		criteria.addOrder(Order.asc("usuario"));
		return criteria.list();
	}

	@Override
	public Integer quantidadeAtivo(Empresa empresa) {
		Criteria criteria = this.session.createCriteria(Oportunidade.class);
		criteria.add(Restrictions.eq("empresa", empresa));
		criteria.add(Restrictions.eq("oportunidade_status", true));
		return criteria.list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Oportunidade> filtrarOportunidade(Filtro filtro) {
		if(filtro.getCategoria()==null && filtro.getFuncao()==null && filtro.getEstado()==null && filtro.getCidade()==null && filtro.getSalario()==null
				&& filtro.getFormacao()==null && (filtro.getExperiencia()==null || filtro.getExperiencia()<=0)){
			return null;
		}
		else{
		int aux = 0;
		Criteria criteria = this.session.createCriteria(Cadastro.class);
		if(filtro.getCategoria()!= null){
			criteria.add(Restrictions.eq("categoria", filtro.getCategoria()));
			aux = aux +1;
		}if(filtro.getFuncao()!=null){
			criteria.add(Restrictions.eq("funcao", filtro.getFuncao()));
			aux = aux +1;
		}if(filtro.getEstado()!=null){
			criteria.add(Restrictions.eq("estado", filtro.getEstado()));
			aux = aux +1;
		}if(filtro.getCidade()!=null){
			criteria.add(Restrictions.eq("cidade", filtro.getCidade()));
			aux = aux +1;
		}if(filtro.getSalario()!=null){
			aux = aux +1;
			criteria.add(Restrictions.eq("salario", filtro.getSalario()));	
		}if(filtro.getFormacao()!=null){
			aux = aux +1;
			criteria.add(Restrictions.eq("formacao", filtro.getFormacao()));	
		}
		if(filtro.getExperiencia()>0){
			aux = aux +1;
			criteria.add(Restrictions.ge("cadastro_experiencia", filtro.getExperiencia()));	
		}
		if(filtro.getIdioma()!=null){
			aux = aux +1;
			criteria.add(Restrictions.eq("combinacoes_idiomas_combinacao_idioma_id", filtro.getIdioma().getIdioma_id()));	
		}
		if(filtro.getNivel()!=null){
			aux = aux +1;
			criteria.add(Restrictions.eq("cadastro_combinacao_idioma", filtro.getNivel()));	
		}
		criteria.addOrder(Order.desc("oportunidade_data"));
		criteria.addOrder(Order.desc("oportunidade_status"));
		System.out.println("*****Qtde de Oportunidades:*****"+ criteria.list().size()+"************Qtde de Filtos:************"+aux);
		return criteria.list();
		}
	}

	


}
