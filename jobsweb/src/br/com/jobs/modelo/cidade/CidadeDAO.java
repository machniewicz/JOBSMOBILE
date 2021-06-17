package br.com.jobs.modelo.cidade;

import java.util.List;

import br.com.jobs.modelo.estado.Estado;

public interface CidadeDAO {
	
	public List<Cidade> listarTodas();
	public List<Cidade> listarTodas(Estado estado);
}
