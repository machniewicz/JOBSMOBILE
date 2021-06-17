package br.com.jobs.modelo.faturamento;

import java.util.List;

public interface FaturamentoDAO {
	
	public void salvar(Faturamento faturamento);

	public void atualizar(Faturamento faturamento);

	public void excluir(Faturamento faturamento);

	public Faturamento carregar(Integer codigo);

	public List<Faturamento> listar();
	
}
