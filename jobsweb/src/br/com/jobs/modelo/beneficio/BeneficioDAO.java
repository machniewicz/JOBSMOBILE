package br.com.jobs.modelo.beneficio;

import java.util.List;

public interface BeneficioDAO{ 
	
	public void salvar(Beneficio beneficio);

	public void atualizar(Beneficio beneficio);

	public void excluir(Beneficio beneficio);

	public Beneficio carregar(Integer codigo);

	public List<Beneficio> listar();
	
	public List<Beneficio> listarTodosAtivos();
	
	public Boolean carregaStatus(Integer codigo);
	
}
