package br.com.jobs.combinacao.ajudadecusto;

import java.util.List;

import org.hibernate.Session;

public class Combinacao_AjudaDeCustoDAOImpl implements Combinacao_AjudaDeCustoDAO {

	private Session	session;
		    
	public void setSession(Session session) {
		this.session = session;	
	}

	public void salvar(Combinacao_AjudaDeCusto combinacaoAjudadecusto) {
		this.session.save(combinacaoAjudadecusto);
	}

	public void atualizar(Combinacao_AjudaDeCusto combinacaoAjudadecusto) {
		this.session.update(combinacaoAjudadecusto);
	}

	public void excluir(Combinacao_AjudaDeCusto combinacaoAjudadecusto) {
		this.session.delete(combinacaoAjudadecusto);
	}

	public Combinacao_AjudaDeCusto carregar(Integer codigo) {
		return (Combinacao_AjudaDeCusto) this.session.get(Combinacao_AjudaDeCusto.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Combinacao_AjudaDeCusto> listarTodos() {
		return this.session.createCriteria(Combinacao_AjudaDeCusto.class).list();
	}
		

}
