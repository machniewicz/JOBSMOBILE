package br.com.jobs.modelo.curso;

import java.util.List;

import br.com.jobs.modelo.cadastro.Cadastro;

public interface CursoDAO {

		public void salvar(Curso curso);

		public void atualizar(Curso curso);
		
		public void excluir(Curso curso);

		public Curso carregar(Integer curso_id);

		public List<Curso> listarTodos();
		
		public List<Curso> listarTodosPorCadastro(Cadastro cadastro);
		
	}

	

