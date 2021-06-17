package br.com.jobs.modelo.financeiro;

import java.util.List;

public interface FinanceiroDAO {
	
	public void salvar(Financeiro financeiro);

	public void atualizar(Financeiro financeiro);

	public void excluir(Financeiro financeiro);

	public Financeiro carregar(Integer codigo);

	public List<Financeiro> listar();
	
}
