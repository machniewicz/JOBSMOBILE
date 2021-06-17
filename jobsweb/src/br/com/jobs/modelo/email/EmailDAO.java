package br.com.jobs.modelo.email;

import java.util.List;


public interface EmailDAO {

	public void salvar(Email email);

	public void atualizar(Email email);
	
	public void excluir(Email email);

	public Email carregar(Integer email_id);
	
	public List<Email> listarTodos();
	
}
