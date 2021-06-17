package br.com.jobs.modelo.oportunidade;

import java.util.List;

import br.com.jobs.modelo.empresa.Empresa;
import br.com.jobs.modelo.usuario.Usuario;
import br.com.jobs.web.util.Filtro;

public interface OportunidadeDAO {
	
	public void salvar(Oportunidade oportunidade);

	public void atualizar(Oportunidade oportunidade);
	
	public void excluir(Oportunidade oportunidade);

	public Oportunidade carregar(Integer oportunidade_id);

	public List<Oportunidade> listar(Usuario usuario);
	
	public Integer quantidadeAtivo(Empresa empresa);
	
	public List<Oportunidade> listarTodos();
	
	public Boolean carregaStatus(Integer codigo);
	
	public List<Oportunidade> filtrarOportunidade(Filtro filtro);
	

}
