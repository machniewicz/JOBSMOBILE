package br.com.jobs.modelo.idioma;

import java.util.List;

public interface IdiomaDAO{ 
	
	public void salvar(Idioma idioma);

	public void atualizar(Idioma idioma);

	public void excluir(Idioma idioma);

	public Idioma carregar(Integer codigo);

	public List<Idioma> listar();
	
	public List<Idioma> listarTodosAtivos();
	
	public Boolean carregaStatus(Integer codigo);
	
	
}
