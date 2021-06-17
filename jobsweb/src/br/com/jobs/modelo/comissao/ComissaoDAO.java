package br.com.jobs.modelo.comissao;

import java.util.List;

public interface ComissaoDAO {
	
	public void salvar(Comissao comissao);

	public void atualizar(Comissao comissao);

	public void excluir(Comissao comissao);

	public Comissao carregar(Integer codigo);

	public List<Comissao> listar();
	
	public List<Comissao> listarTodosAtivos();
	
	public Boolean carregaStatus(Integer codigo);


}
