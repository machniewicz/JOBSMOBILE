package br.com.jobs.modelo.cadastro;

import java.util.List;

import br.com.jobs.modelo.enviado.Enviado;
import br.com.jobs.web.util.Filtro;

public interface CadastroDAO {

	public void salvar(Cadastro cadastro);

	public void atualizar(Cadastro cadastro);

	public void excluir(Cadastro cadastro);

	public Cadastro carregar(Integer cadastro_id);

	public List<Cadastro> listarTodos();

	public Cadastro buscarPorLogin(String login);
	
	public Integer quantidadeCadastro(String login);

	public String carregaPerfil(Integer codigo);

	public Boolean carregaStatus(Integer codigo);
	
	public Integer carregaSexo(Integer codigo);

	public List<Cadastro> recuperaSenha(String parametro, Integer flag);

	public void alterarSenha(Cadastro cadastro);

	public List<Cadastro> filtrarCadastro(Filtro filtro);
	
	public List<Enviado> listarCandidatura(Cadastro cadastro);
	
}
