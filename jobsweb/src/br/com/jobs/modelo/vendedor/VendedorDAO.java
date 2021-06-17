package br.com.jobs.modelo.vendedor;

import java.util.List;

public interface VendedorDAO{ 
	
	public void salvar(Vendedor vendedor);

	public void atualizar(Vendedor vendedor);

	public void excluir(Vendedor vendedor);

	public Vendedor carregar(Integer codigo);

	public List<Vendedor> listar();
	
	public List<Vendedor> listarTodosAtivos();
	
	public Boolean carregaStatus(Integer codigo);
	
}
