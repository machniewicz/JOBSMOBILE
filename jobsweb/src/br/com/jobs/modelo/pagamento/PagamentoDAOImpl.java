package br.com.jobs.modelo.pagamento;

import java.util.List;

import org.hibernate.Session;

public class PagamentoDAOImpl implements PagamentoDAO {

	private Session	session;
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Pagamento pagamento) {
		this.session.save(pagamento);
	}

	public void atualizar(Pagamento pagamento) {
		this.session.update(pagamento);
	}

	public void excluir(Pagamento pagamento) {
		this.session.delete(pagamento);
	}

	public Pagamento carregar(Integer codigo) {
		return (Pagamento) this.session.get(Pagamento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Pagamento> listar() {
		return this.session.createCriteria(Pagamento.class).list();
	}

}
