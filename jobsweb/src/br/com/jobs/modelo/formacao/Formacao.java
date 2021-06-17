package br.com.jobs.modelo.formacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Formacao")
public class Formacao implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column (name="formacao_id", insertable = true, updatable = false)
	private Integer formacao_id;
	
	@Column (name="formacao_descricao", length=50)
	private String formacao_descricao;
	
	@Column (name="formacao_status")
	private Boolean formacao_status;

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

	public Boolean getFormacao_status() {
		return formacao_status;
	}

	public void setFormacao_status(Boolean formacao_status) {
		this.formacao_status = formacao_status;
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
		result = prime * result
				+ ((formacao_status == null) ? 0 : formacao_status.hashCode());
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
		if (formacao_status == null) {
			if (other.formacao_status != null)
				return false;
		} else if (!formacao_status.equals(other.formacao_status))
			return false;
		return true;
	}

		
}
