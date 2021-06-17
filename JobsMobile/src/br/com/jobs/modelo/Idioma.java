package br.com.jobs.modelo;

import java.io.Serializable;

public class Idioma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idioma_id;
	private Integer oportunidade_id;
	private String idioma_descricao;
	
	//Aqui esta a mágica, sem este método você terá uma exceção  
	public String toString() {  
		return (this.getIdioma_descricao());  
	}

	public Integer getIdioma_id() {
		return idioma_id;
	}

	public void setIdioma_id(Integer idioma_id) {
		this.idioma_id = idioma_id;
	}

	public Integer getOportunidade_id() {
		return oportunidade_id;
	}

	public void setOportunidade_id(Integer oportunidade_id) {
		this.oportunidade_id = oportunidade_id;
	}

	public String getIdioma_descricao() {
		return idioma_descricao;
	}

	public void setIdioma_descricao(String idioma_descricao) {
		this.idioma_descricao = idioma_descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((idioma_descricao == null) ? 0 : idioma_descricao.hashCode());
		result = prime * result
				+ ((idioma_id == null) ? 0 : idioma_id.hashCode());
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
		Idioma other = (Idioma) obj;
		if (idioma_descricao == null) {
			if (other.idioma_descricao != null)
				return false;
		} else if (!idioma_descricao.equals(other.idioma_descricao))
			return false;
		if (idioma_id == null) {
			if (other.idioma_id != null)
				return false;
		} else if (!idioma_id.equals(other.idioma_id))
			return false;
		if (oportunidade_id == null) {
			if (other.oportunidade_id != null)
				return false;
		} else if (!oportunidade_id.equals(other.oportunidade_id))
			return false;
		return true;
	}
	
	
}
