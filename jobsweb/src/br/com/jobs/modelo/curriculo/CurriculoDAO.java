package br.com.jobs.modelo.curriculo;

import java.util.List;

public interface CurriculoDAO {
	
	public void salvar(Curriculo curriculo);

	public void atualizar(Curriculo curriculo);
	
	public void excluir(Curriculo curriculo);

	public Curriculo carregar(Integer curriculo_id);

	public List<Curriculo> listarTodos();

}
