package br.com.jobs.modelo;

import java.io.Serializable;

public class Vaga implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer vaga_id;
	private String vaga_descricao;
	private Boolean vaga_status;
	public Integer getVaga_id() {
		return vaga_id;
	}
	public void setVaga_id(Integer vaga_id) {
		this.vaga_id = vaga_id;
	}
	public String getVaga_descricao() {
		return vaga_descricao;
	}
	public void setVaga_descricao(String vaga_descricao) {
		this.vaga_descricao = vaga_descricao;
	}
	public Boolean getVaga_status() {
		return vaga_status;
	}
	public void setVaga_status(Boolean vaga_status) {
		this.vaga_status = vaga_status;
	}
	
	public String toString() {  
		return (this.getVaga_descricao());  
	} 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((vaga_descricao == null) ? 0 : vaga_descricao.hashCode());
		result = prime * result + ((vaga_id == null) ? 0 : vaga_id.hashCode());
		result = prime * result
				+ ((vaga_status == null) ? 0 : vaga_status.hashCode());
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
		Vaga other = (Vaga) obj;
		if (vaga_descricao == null) {
			if (other.vaga_descricao != null)
				return false;
		} else if (!vaga_descricao.equals(other.vaga_descricao))
			return false;
		if (vaga_id == null) {
			if (other.vaga_id != null)
				return false;
		} else if (!vaga_id.equals(other.vaga_id))
			return false;
		if (vaga_status == null) {
			if (other.vaga_status != null)
				return false;
		} else if (!vaga_status.equals(other.vaga_status))
			return false;
		return true;
	}

}
