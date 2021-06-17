package br.com.jobs.modelo.estatistica;

import java.util.List;

public interface EstatisticaDAO {

	public void salvar(Estatistica estatistica);

	public void atualizar(Estatistica estatistica);
	
	public void excluir(Estatistica estatistica);

	public Estatistica carregar(Integer estatistica_id);
	
	public List<Estatistica> listarTodos();
}
