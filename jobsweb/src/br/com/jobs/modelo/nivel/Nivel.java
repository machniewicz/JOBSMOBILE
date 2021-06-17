package br.com.jobs.modelo.nivel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Nivel")
public class Nivel implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column (name="nivel_id", insertable = true, updatable = false)
	private Integer nivel_id;
	
	@Column (name="nivel_descricao", length=50)
	private String nivel_descricao;
	
	@Column (name="nivel_status")
	private Boolean nivel_status;

	public Integer getNivel_id() {
		return nivel_id;
	}

	public void setNivel_id(Integer nivel_id) {
		this.nivel_id = nivel_id;
	}

	public String getNivel_descricao() {
		return nivel_descricao;
	}

	public void setNivel_descricao(String nivel_descricao) {
		this.nivel_descricao = nivel_descricao;
	}

	public Boolean getNivel_status() {
		return nivel_status;
	}

	public void setNivel_status(Boolean nivel_status) {
		this.nivel_status = nivel_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nivel_descricao == null) ? 0 : nivel_descricao.hashCode());
		result = prime * result
				+ ((nivel_id == null) ? 0 : nivel_id.hashCode());
		result = prime * result
				+ ((nivel_status == null) ? 0 : nivel_status.hashCode());
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
		Nivel other = (Nivel) obj;
		if (nivel_descricao == null) {
			if (other.nivel_descricao != null)
				return false;
		} else if (!nivel_descricao.equals(other.nivel_descricao))
			return false;
		if (nivel_id == null) {
			if (other.nivel_id != null)
				return false;
		} else if (!nivel_id.equals(other.nivel_id))
			return false;
		if (nivel_status == null) {
			if (other.nivel_status != null)
				return false;
		} else if (!nivel_status.equals(other.nivel_status))
			return false;
		return true;
	}
	
	
}
