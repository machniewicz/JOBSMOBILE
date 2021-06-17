package br.com.jobs.modelo.funcao;

import java.util.List;

import br.com.jobs.modelo.categoria.Categoria;

public interface FuncaoDAO{ 
	
	public void salvar(Funcao funcao);

	public void atualizar(Funcao funcao);

	public void excluir(Funcao funcao);

	public Funcao carregar(Integer codigo);

	public List<Funcao> listar();
	
	public List<Funcao> listarTodosAtivos();
	
	public List<Funcao> listarTodosPorCategoria(Categoria categoria);
	
	public Boolean carregaStatus(Integer codigo);
	
}
