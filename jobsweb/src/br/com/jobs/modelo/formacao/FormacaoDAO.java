package br.com.jobs.modelo.formacao;

import java.util.List;

public interface FormacaoDAO {

		public void salvar(Formacao formacao);

		public void atualizar(Formacao formacao);
		
		public void excluir(Formacao formacao);

		public Formacao carregar(Integer formacao_id);

		public List<Formacao> listarTodos();
		
		public List<Formacao> listarTodosAtivos();
		
		public Boolean carregaStatus(Integer codigo);
		
	}

	

