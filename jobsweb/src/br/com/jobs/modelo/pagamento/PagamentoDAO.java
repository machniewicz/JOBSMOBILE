package br.com.jobs.modelo.pagamento;

import java.util.List;

public interface PagamentoDAO{ 
	
	public void salvar(Pagamento pagamento);

	public void atualizar(Pagamento pagamento);

	public void excluir(Pagamento pagamento);

	public Pagamento carregar(Integer codigo);

	public List<Pagamento> listar();
		
}
