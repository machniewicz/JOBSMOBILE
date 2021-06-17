package br.com.jobs.modelo.nivel;

import java.util.List;

public interface NivelDAO{ 
	
	public void salvar(Nivel nivel);

	public void atualizar(Nivel nivel);

	public void excluir(Nivel nivel);

	public Nivel carregar(Integer codigo);

	public List<Nivel> listar();
	
	public List<Nivel> listarTodosAtivos();
	
	public Boolean carregaStatus(Integer codigo);
	
	
}
