package br.com.jobs.modelo.faturamento;

import java.util.List;

import org.hibernate.Session;

public class FaturamentoDAOImpl implements FaturamentoDAO {

	private Session	session;
	    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Faturamento faturamento) {
		this.session.save(faturamento);
	}

	public void atualizar(Faturamento faturamento) {
		this.session.update(faturamento);
	}

	public void excluir(Faturamento faturamento) {
		this.session.delete(faturamento);
	}

	public Faturamento carregar(Integer codigo) {
		return (Faturamento) this.session.get(Faturamento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Faturamento> listar() {
		return this.session.createCriteria(Faturamento.class).list();
	}

}
