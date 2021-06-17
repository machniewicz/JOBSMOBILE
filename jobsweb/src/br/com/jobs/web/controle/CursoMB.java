package br.com.jobs.web.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.curso.Curso;

@ManagedBean(name = "cursoMB")
@SessionScoped
public class CursoMB {

	private Curso curso;
	private List<Curso> cursos;

	/*
	 * Construtor
	 */
	public CursoMB(){
		super();
		curso = new Curso();
	}
	
	/**
	 * Inicia processo
	 */
	@PostConstruct
	public void init(){
	
	}
	
	/*
	 * Get e Set 
	 */
		
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public void novoCurso(){
		curso = new Curso();
	}
}
