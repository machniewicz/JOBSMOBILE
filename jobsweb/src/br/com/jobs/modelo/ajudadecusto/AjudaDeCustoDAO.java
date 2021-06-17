package br.com.jobs.modelo.ajudadecusto;

import java.util.List;

public interface AjudaDeCustoDAO {

	public void salvar(AjudaDeCusto ajuda);

	public void atualizar(AjudaDeCusto ajuda);

	public void excluir(AjudaDeCusto ajuda);

	public AjudaDeCusto carregar(Integer codigo);

	public List<AjudaDeCusto> listar();
	
	public List<AjudaDeCusto> listarTodosAtivos();
	
	public Boolean carregaStatus(Integer codigo);
}
