package br.com.jobs.modelo;

import java.io.Serializable;

public class Beneficio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer beneficio_id;
	private Integer oportunidade_id;
	private String beneficio_descricao;

	//Aqui esta a mágica, sem este método você terá uma exceção  
	public String toString() {  
		return (this.getBeneficio_descricao());  
	}

	public Integer getBeneficio_id() {
		return beneficio_id;
	}

	public void setBeneficio_id(Integer beneficio_id) {
		this.beneficio_id = beneficio_id;
	}

	public Integer getOportunidade_id() {
		return oportunidade_id;
	}

	public void setOportunidade_id(Integer oportunidade_id) {
		this.oportunidade_id = oportunidade_id;
	}

	public String getBeneficio_descricao() {
		return beneficio_descricao;
	}

	public void setBeneficio_descricao(String beneficio_descricao) {
		this.beneficio_descricao = beneficio_descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((beneficio_descricao == null) ? 0 : beneficio_descricao
						.hashCode());
		result = prime * result
				+ ((beneficio_id == null) ? 0 : beneficio_id.hashCode());
		result = prime * result
				+ ((oportunidade_id == null) ? 0 : oportunidade_id.hashCode());
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
		Beneficio other = (Beneficio) obj;
		if (beneficio_descricao == null) {
			if (other.beneficio_descricao != null)
				return false;
		} else if (!beneficio_descricao.equals(other.beneficio_descricao))
			return false;
		if (beneficio_id == null) {
			if (other.beneficio_id != null)
				return false;
		} else if (!beneficio_id.equals(other.beneficio_id))
			return false;
		if (oportunidade_id == null) {
			if (other.oportunidade_id != null)
				return false;
		} else if (!oportunidade_id.equals(other.oportunidade_id))
			return false;
		return true;
	}
	
	
}
