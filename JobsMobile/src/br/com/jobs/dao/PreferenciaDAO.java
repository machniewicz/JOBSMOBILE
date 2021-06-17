package br.com.jobs.dao;

import java.util.List;

import br.com.jobs.modelo.Preferencia;

public interface PreferenciaDAO {
	
	public void salvar(Preferencia preferencia);

	public void atualizar(Preferencia preferencia);
	
	public void excluir(Preferencia preferencia);

	public List<Preferencia> carregaPreferencia();
	
	public Preferencia detalhesPreferencia();
	

}
