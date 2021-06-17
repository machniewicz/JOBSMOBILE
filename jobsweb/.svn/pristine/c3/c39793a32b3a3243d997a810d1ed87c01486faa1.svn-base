package br.com.jobs.modelo.categoria;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Categoria")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column (name="categoria_id", insertable = true, updatable = false)
	private Integer categoria_id;
	
	@Column (name="categoria_descricao", length=80)
	private String categoria_descricao;
	
	@Column (name="categoria_status")
	private Boolean categoria_status;
	
	/*
	 * Get e Set
	 */
	
	public Integer getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}
	public String getCategoria_descricao() {
		return categoria_descricao;
	}
	public void setCategoria_descricao(String categoria_descricao) {
		this.categoria_descricao = categoria_descricao;
	}
	public Boolean getCategoria_status() {
		return categoria_status;
	}
	public void setCategoria_status(Boolean categoria_status) {
		this.categoria_status = categoria_status;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((categoria_descricao == null) ? 0 : categoria_descricao
						.hashCode());
		result = prime * result
				+ ((categoria_id == null) ? 0 : categoria_id.hashCode());
		result = prime
				* result
				+ ((categoria_status == null) ? 0 : categoria_status.hashCode());
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
		Categoria other = (Categoria) obj;
		if (categoria_descricao == null) {
			if (other.categoria_descricao != null)
				return false;
		} else if (!categoria_descricao.equals(other.categoria_descricao))
			return false;
		if (categoria_id == null) {
			if (other.categoria_id != null)
				return false;
		} else if (!categoria_id.equals(other.categoria_id))
			return false;
		if (categoria_status == null) {
			if (other.categoria_status != null)
				return false;
		} else if (!categoria_status.equals(other.categoria_status))
			return false;
		return true;
	}	
}
