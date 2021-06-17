package br.com.jobs.modelo.escolaridade;

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
import br.com.jobs.modelo.formacao.Formacao;

@Entity
@Table (name="Escolaridade")
public class Escolaridade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="escolaridade_id", insertable = true, updatable = false)
	private Integer escolaridade_id;
	
	@Column (name="escolaridade_instituicao", length=100)
	private String escolaridade_instituicao;
	
	@Column (name="escolaridade_descricao", length=100)
	private String escolaridade_descricao;
	
	@OneToOne
	@JoinColumn (name="formacao_id")
	private Formacao formacao;
	
	 @ManyToOne
	 @JoinColumn(name="cadastro_id")
	 private Cadastro cadastro;

	public Integer getEscolaridade_id() {
		return escolaridade_id;
	}

	public void setEscolaridade_id(Integer escolaridade_id) {
		this.escolaridade_id = escolaridade_id;
	}

	public String getEscolaridade_instituicao() {
		return escolaridade_instituicao;
	}

	public void setEscolaridade_instituicao(String escolaridade_instituicao) {
		this.escolaridade_instituicao = escolaridade_instituicao;
	}

	public String getEscolaridade_descricao() {
		return escolaridade_descricao;
	}

	public void setEscolaridade_descricao(String escolaridade_descricao) {
		this.escolaridade_descricao = escolaridade_descricao;
	}

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
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
		result = prime
				* result
				+ ((escolaridade_descricao == null) ? 0
						: escolaridade_descricao.hashCode());
		result = prime * result
				+ ((escolaridade_id == null) ? 0 : escolaridade_id.hashCode());
		result = prime
				* result
				+ ((escolaridade_instituicao == null) ? 0
						: escolaridade_instituicao.hashCode());
		result = prime * result
				+ ((formacao == null) ? 0 : formacao.hashCode());
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
		Escolaridade other = (Escolaridade) obj;
		if (cadastro == null) {
			if (other.cadastro != null)
				return false;
		} else if (!cadastro.equals(other.cadastro))
			return false;
		if (escolaridade_descricao == null) {
			if (other.escolaridade_descricao != null)
				return false;
		} else if (!escolaridade_descricao.equals(other.escolaridade_descricao))
			return false;
		if (escolaridade_id == null) {
			if (other.escolaridade_id != null)
				return false;
		} else if (!escolaridade_id.equals(other.escolaridade_id))
			return false;
		if (escolaridade_instituicao == null) {
			if (other.escolaridade_instituicao != null)
				return false;
		} else if (!escolaridade_instituicao
				.equals(other.escolaridade_instituicao))
			return false;
		if (formacao == null) {
			if (other.formacao != null)
				return false;
		} else if (!formacao.equals(other.formacao))
			return false;
		return true;
	}
	
	
	
}
