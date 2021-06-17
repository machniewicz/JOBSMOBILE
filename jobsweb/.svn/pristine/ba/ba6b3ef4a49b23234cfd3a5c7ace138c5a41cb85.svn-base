package br.com.jobs.services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.usuario.Usuario;

@Service("hibernateUserDetailsService")
public class HibernateUserDetailsService extends HibernateDaoSupport implements UserDetailsService  {
	
	@Autowired
	public HibernateUserDetailsService(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public UserDetails loadUserByUsername(String login) {
		
		if(login.contains(".")){
			DetachedCriteria criteria = DetachedCriteria.forClass(Cadastro.class, "cadastro");
			criteria.add(Restrictions.eq("cadastro.cadastro_cpf", login));
			@SuppressWarnings("rawtypes")
			List resultado = getHibernateTemplate().findByCriteria(criteria);
			if(resultado != null && resultado.size() == 0) {
				throw new UsernameNotFoundException("Usuário não encontrado!");
		    }	
			return (Cadastro)resultado.get(0);
		}
		else if (!login.contains(".")){
		
			DetachedCriteria criteria = DetachedCriteria.forClass(Usuario.class, "usuario");
			criteria.add(Restrictions.eq("usuario.usuario_login", login));
			@SuppressWarnings("rawtypes")
			List resultado = getHibernateTemplate().findByCriteria(criteria);
			if(resultado != null && resultado.size() == 0) {
				throw new UsernameNotFoundException("Usuário não encontrado!");
		    }	
			return (Usuario)resultado.get(0);
		}
		return null;
		
	}
	
	/*
	@Override
	public UserDetails loadUserByUsername(String login) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Cadastro.class, "cadastro");
		criteria.add(Restrictions.eq("cadastro.cadastro_cpf", login));
		@SuppressWarnings("rawtypes")
		List resultado = getHibernateTemplate().findByCriteria(criteria);
		if(resultado != null && resultado.size() == 0) {
			throw new UsernameNotFoundException("Usu�rio n�o encontrado!");
	    }	
		return (Cadastro)resultado.get(0);
	}
	*/
}
