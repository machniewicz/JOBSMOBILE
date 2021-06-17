package br.com.jobs.modelo.enviado;

import java.util.List;

import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.oportunidade.Oportunidade;

public interface EnviadoDAO {

	public void salvar(Enviado enviado);

	public void atualizar(Enviado enviado);
	
	public void excluir(Enviado enviado);
	
	public Enviado carregar(Integer enviado_id);
	
	public List<Enviado> listar(Oportunidade oportunidade);
	
	public List <Enviado> listarEnviado(Cadastro cadastro);
	
	public List<EnviadoGrafico> listaDadosGrafico(Integer oportunidade_id);
	
}
