package br.com.jobs.modelo.financeiro;

import java.util.List;

import org.hibernate.Session;

public class FinanceiroDAOImpl implements FinanceiroDAO {

	private Session	session;
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Financeiro financeiro) {
		this.session.save(financeiro);
	}

	public void atualizar(Financeiro financeiro) {
		this.session.update(financeiro);
	}

	public void excluir(Financeiro financeiro) {
		this.session.delete(financeiro);
	}

	public Financeiro carregar(Integer codigo) {
		return (Financeiro) this.session.get(Financeiro.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Financeiro> listar() {
		return this.session.createCriteria(Financeiro.class).list();
	}

}
