package br.com.jobs.modelo.cadastro;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.jobs.modelo.enviado.Enviado;
import br.com.jobs.web.util.Filtro;


public class CadastroDAOImpl implements CadastroDAO{

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Cadastro cadastro) {
		this.session.save(cadastro);
	}

	@Override
	public void atualizar(Cadastro cadastro) {
		this.session.update(cadastro);
	}

	@Override
	public void excluir(Cadastro cadastro) {
		this.session.delete(cadastro);
	}

	@Override
	public Cadastro carregar(Integer cadastro_id) {
		return (Cadastro) this.session.get(Cadastro.class, cadastro_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cadastro> listarTodos() {
		Criteria criteria = this.session.createCriteria(Cadastro.class);
		criteria.addOrder(Order.desc("cadastro_data"));
		criteria.addOrder(Order.desc("cadastro_status"));
		return criteria.list();
	}

	@Override
	public Cadastro buscarPorLogin(String login) {
		Criteria criteria = this.session.createCriteria(Cadastro.class);
		criteria.add(Restrictions.eq("cadastro_cpf", login));
		return (Cadastro) criteria.uniqueResult() ;
	}

	@Override
	public String carregaPerfil(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_perfil_cadastro"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
	return (String) consulta.uniqueResult();
	}

	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_cadastro"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}
	
	@Override
	public Integer carregaSexo(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_sexo_cadastro"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		if (consulta.uniqueResult()==null){
			return 3;
		}
		else{
			return (Integer) consulta.uniqueResult();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cadastro> recuperaSenha(String parametro, Integer flag) {
		String hql_query = null;
		if(flag == 0){
			hql_query = "query_recuperar_senha_cadastro_email";
		}else if (flag == 1){
			hql_query = "query_recuperar_senha_cadastro_login";
		}
		String hql = MessageFormat.format(bundleQuery.getString(hql_query),":parametro");
		Query consulta = this.session.createQuery(hql);
		consulta.setString("parametro", parametro);
		return consulta.list();
	}

	@Override
	public void alterarSenha(Cadastro cadastro) {
		this.session.update(cadastro);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cadastro> filtrarCadastro(Filtro filtro){
		
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
		criteria.addOrder(Order.desc("cadastro_data"));
		criteria.addOrder(Order.desc("cadastro_status"));
		System.out.println("*****Qtde de Cadastros:*****"+ criteria.list().size()+"************Qtde de Filtos:************"+aux);
		return criteria.list();
		}
	}

	@Override
	public Integer quantidadeCadastro(String login) {
		Criteria criteria = this.session.createCriteria(Cadastro.class);
		criteria.add(Restrictions.eq("cadastro_cpf", login));
		return (Integer) criteria.list().size();
	}
	
	
	/*
	 * Lista todas as oportunidades que o Candidato se cadastrou
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Enviado> listarCandidatura(Cadastro cadastro) {
		Criteria criteria = this.session.createCriteria(Enviado.class);
		criteria.add(Restrictions.eq("cadastro", cadastro));
		return criteria.list();			
	}


}
