package br.com.jobs.modelo.usuario;

import java.text.MessageFormat;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.jobs.modelo.empresa.Empresa;

public class UsuarioDAOImpl implements	UsuarioDAO {

	private Session	session;
	private ResourceBundle bundleQuery = ResourceBundle.getBundle("br.com.jobs.query.queryJobs");
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Usuario usuario) {
		this.session.save(usuario);
	}

	public void atualizar(Usuario usuario) {
		if (usuario.getPerfis() == null || usuario.getPerfis().size() == 0) {
			Usuario usuarioPermissao = this.carregar(usuario.getUsuario_id());
			usuario.setPerfis(usuarioPermissao.getPerfis());
			this.session.evict(usuarioPermissao);
		}
		this.session.update(usuario);
	}

	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
	}

	public Usuario carregar(Integer codigo) {
		//TODO o hibernate nao conseguira fazer a carga caso seja passado o Usuario
		// no parametro, tem que ser diretamente a chave (integer)
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	public Usuario buscarPorLogin(String login) {
		Criteria criteria = this.session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("usuario_login", login));
		return (Usuario) criteria.uniqueResult() ;
	}
	
	@Override
	public Boolean buscarUsuario(String login) {
		Boolean retorno = false;
		Criteria criteria = this.session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("usuario_login", login));
		if(criteria.list().size() > 0){
			retorno = true;
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}

	@Override
	public String carregaPerfil(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_perfil_usuario"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
	return (String) consulta.uniqueResult();
	}

	@Override
	public Boolean carregaStatus(Integer codigo) {
		String hql = MessageFormat.format(bundleQuery.getString("query_carregar_status_usuario"), ":codigo");
		Query consulta = this.session.createSQLQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Boolean) consulta.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> recuperaSenha(String parametro, Integer flag) {
		String hql_query = null;
		if(flag == 0){
			hql_query = "query_recuperar_senha_usuario_email";
		}else if (flag == 1){
			hql_query = "query_recuperar_senha_usuario_login";
		}
		String hql = MessageFormat.format(bundleQuery.getString(hql_query),":parametro");
		Query consulta = this.session.createQuery(hql);
		consulta.setString("parametro", parametro);
		return consulta.list();
		
	}

	@Override
	public void alterarSenha(Usuario usuario) {
			this.session.update(usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarPorEmpresa(Empresa empresa) {
		Criteria criteria = this.session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("empresa", empresa));
		criteria.addOrder(Order.desc("usuario_status"));
		criteria.addOrder(Order.asc("usuario_login"));
		return criteria.list();
	}

}
