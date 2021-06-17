package br.com.jobs.modelo;

import java.io.Serializable;

public class Software implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer software_id;
	private Integer oportunidade_id;
	private String software_descricao;
	
	//Aqui esta a mágica, sem este método você terá uma exceção  
	public String toString() {  
		return (this.getSoftware_descricao());  
	}

	public Integer getSoftware_id() {
		return software_id;
	}

	public void setSoftware_id(Integer software_id) {
		this.software_id = software_id;
	}

	public Integer getOportunidade_id() {
		return oportunidade_id;
	}

	public void setOportunidade_id(Integer oportunidade_id) {
		this.oportunidade_id = oportunidade_id;
	}

	public String getSoftware_descricao() {
		return software_descricao;
	}

	public void setSoftware_descricao(String software_descricao) {
		this.software_descricao = software_descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((oportunidade_id == null) ? 0 : oportunidade_id.hashCode());
		result = prime
				* result
				+ ((software_descricao == null) ? 0 : software_descricao
						.hashCode());
		result = prime * result
				+ ((software_id == null) ? 0 : software_id.hashCode());
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
		Software other = (Software) obj;
		if (oportunidade_id == null) {
			if (other.oportunidade_id != null)
				return false;
		} else if (!oportunidade_id.equals(other.oportunidade_id))
			return false;
		if (software_descricao == null) {
			if (other.software_descricao != null)
				return false;
		} else if (!software_descricao.equals(other.software_descricao))
			return false;
		if (software_id == null) {
			if (other.software_id != null)
				return false;
		} else if (!software_id.equals(other.software_id))
			return false;
		return true;
	}  

	
}
