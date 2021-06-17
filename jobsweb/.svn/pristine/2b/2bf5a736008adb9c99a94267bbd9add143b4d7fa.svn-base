package br.com.jobs.modelo.email;

import java.util.List;

import org.hibernate.Session;

public class EmailDAOImpl implements EmailDAO {

	private Session	session;
		    
	public void setSession(Session session) {
		this.session = session;	
	}
	
	@Override
	public void salvar(Email email) {
		this.session.save(email);
		
	}

	@Override
	public void atualizar(Email email) {
		this.session.update(email);
	}

	@Override
	public void excluir(Email email) {
		this.session.delete(email);
		
	}

	@Override
	public Email carregar(Integer email_id) {
		return (Email) this.session.get(Email.class, email_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Email> listarTodos() {
		return this.session.createCriteria(Email.class).list();
	}

}
