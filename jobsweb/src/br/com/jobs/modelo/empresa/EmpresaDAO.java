package br.com.jobs.modelo.empresa;

import java.util.List;

public interface EmpresaDAO{ 
	
	public void salvar(Empresa empresa);

	public void atualizar(Empresa empresa);

	public void excluir(Empresa empresa);

	public Empresa carregar(Integer codigo);

	public List<Empresa> listar();
	
	public List<Empresa> listarEmpresasAtivasValida();

	public Boolean carregaStatus(Integer codigo);
	
}
