package br.com.jobs.combinacao.software;

import java.util.List;

public interface Combinacao_SoftwareDAO{ 
	
	public void salvar(Combinacao_Software combinacaoSoftware);

	public void atualizar(Combinacao_Software combinacaoSoftware);

	public void excluir(Combinacao_Software combinacaoSoftware);

	public Combinacao_Software carregar(Integer codigo);
	
	public List<Combinacao_Software> listarTodos();

	public List<Combinacao_Software> listarTodosAtivos();
	
	public Boolean carregaStatus(Integer codigo);
	
}
