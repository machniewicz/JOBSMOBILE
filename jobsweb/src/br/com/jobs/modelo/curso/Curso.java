package br.com.jobs.modelo.curso;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.situacao.Situacao;

@Entity
@Table (name="Curso")
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="curso_id", insertable = true, updatable = false)
	private Integer curso_id;
	
	@Column (name="curso_instituicao", length=100)
	private String curso_instituicao;
	
	@Column (name="curso_descricao", length=100)
	private String curso_descricao;
	
	@Column (name="curso_carga_horaria")
	private Integer curso_carga_horaria;
	
	@Column (name="curso_ano")
	private Integer curso_ano;
	
	@OneToOne
	@JoinColumn (name="situacao_id")
	private Situacao situacao;

	@ManyToOne
	@JoinColumn(name="cadastro_id")
	private Cadastro cadastro;
	
	public Integer getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(Integer curso_id) {
		this.curso_id = curso_id;
	}

	public String getCurso_instituicao() {
		return curso_instituicao;
	}

	public void setCurso_instituicao(String curso_instituicao) {
		this.curso_instituicao = curso_instituicao;
	}

	public String getCurso_descricao() {
		return curso_descricao;
	}

	public void setCurso_descricao(String curso_descricao) {
		this.curso_descricao = curso_descricao;
	}
	
	public Integer getCurso_carga_horaria() {
		return curso_carga_horaria;
	}

	public void setCurso_carga_horaria(Integer curso_carga_horaria) {
		this.curso_carga_horaria = curso_carga_horaria;
	}

	public Integer getCurso_ano() {
		return curso_ano;
	}

	public void setCurso_ano(Integer curso_ano) {
		this.curso_ano = curso_ano;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cadastro == null) ? 0 : cadastro.hashCode());
		result = prime * result
				+ ((curso_ano == null) ? 0 : curso_ano.hashCode());
		result = prime
				* result
				+ ((curso_carga_horaria == null) ? 0 : curso_carga_horaria
						.hashCode());
		result = prime * result
				+ ((curso_descricao == null) ? 0 : curso_descricao.hashCode());
		result = prime * result
				+ ((curso_id == null) ? 0 : curso_id.hashCode());
		result = prime
				* result
				+ ((curso_instituicao == null) ? 0 : curso_instituicao
						.hashCode());
		result = prime * result
				+ ((situacao == null) ? 0 : situacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (cadastro == null) {
			if (other.cadastro != null)
				return false;
		} else if (!cadastro.equals(other.cadastro))
			return false;
		if (curso_ano == null) {
			if (other.curso_ano != null)
				return false;
		} else if (!curso_ano.equals(other.curso_ano))
			return false;
		if (curso_carga_horaria == null) {
			if (other.curso_carga_horaria != null)
				return false;
		} else if (!curso_carga_horaria.equals(other.curso_carga_horaria))
			return false;
		if (curso_descricao == null) {
			if (other.curso_descricao != null)
				return false;
		} else if (!curso_descricao.equals(other.curso_descricao))
			return false;
		if (curso_id == null) {
			if (other.curso_id != null)
				return false;
		} else if (!curso_id.equals(other.curso_id))
			return false;
		if (curso_instituicao == null) {
			if (other.curso_instituicao != null)
				return false;
		} else if (!curso_instituicao.equals(other.curso_instituicao))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		return true;
	}	

}
