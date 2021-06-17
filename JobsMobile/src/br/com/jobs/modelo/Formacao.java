package br.com.jobs.modelo;

import java.io.Serializable;


public class Formacao implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer formacao_id;
	private String formacao_descricao;

	public Integer getFormacao_id() {
		return formacao_id;
	}

	public void setFormacao_id(Integer formacao_id) {
		this.formacao_id = formacao_id;
	}

	public String getFormacao_descricao() {
		return formacao_descricao;
	}

	public void setFormacao_descricao(String formacao_descricao) {
		this.formacao_descricao = formacao_descricao;
	}

	public String toString() {  
		return (this.getFormacao_descricao());  
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((formacao_descricao == null) ? 0 : formacao_descricao
						.hashCode());
		result = prime * result
				+ ((formacao_id == null) ? 0 : formacao_id.hashCode());
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
		Formacao other = (Formacao) obj;
		if (formacao_descricao == null) {
			if (other.formacao_descricao != null)
				return false;
		} else if (!formacao_descricao.equals(other.formacao_descricao))
			return false;
		if (formacao_id == null) {
			if (other.formacao_id != null)
				return false;
		} else if (!formacao_id.equals(other.formacao_id))
			return false;
		return true;
	}
	
	
}
