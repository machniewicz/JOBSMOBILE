package br.com.jobs.modelo.usuario;

import java.util.List;

import br.com.jobs.modelo.empresa.Empresa;

public interface UsuarioDAO{ 
	
	public void salvar(Usuario usuario);

	public void atualizar(Usuario usuario);

	public void excluir(Usuario usuario);

	public Usuario carregar(Integer codigo);

	public Usuario buscarPorLogin(String login);
	
	public Boolean buscarUsuario(String login);

	public List<Usuario> listar();
	
	public List<Usuario> listarPorEmpresa(Empresa empresa);
	
	public String carregaPerfil(Integer codigo);
	
	public Boolean carregaStatus(Integer codigo);
	
	public List<Usuario> recuperaSenha(String parametro, Integer flag);
	
	public void alterarSenha(Usuario usuario);

}
