package br.com.jobs.modelo.pais;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pais")
public class Pais implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="pais_id", insertable = true, updatable = false)
	private Integer pais_id;
	
	@Column (name = "pais_nome", length=100)
	private String pais_nome;
	
	@Column (name = "pais_sigla", length=5)
	private String pais_sigla;

	public Integer getPais_id() {
		return pais_id;
	}

	public void setPais_id(Integer pais_id) {
		this.pais_id = pais_id;
	}

	public String getPais_nome() {
		return pais_nome;
	}

	public void setPais_nome(String pais_nome) {
		this.pais_nome = pais_nome;
	}

	public String getPais_sigla() {
		return pais_sigla;
	}

	public void setPais_sigla(String pais_sigla) {
		this.pais_sigla = pais_sigla;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pais_id == null) ? 0 : pais_id.hashCode());
		result = prime * result
				+ ((pais_nome == null) ? 0 : pais_nome.hashCode());
		result = prime * result
				+ ((pais_sigla == null) ? 0 : pais_sigla.hashCode());
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
		Pais other = (Pais) obj;
		if (pais_id == null) {
			if (other.pais_id != null)
				return false;
		} else if (!pais_id.equals(other.pais_id))
			return false;
		if (pais_nome == null) {
			if (other.pais_nome != null)
				return false;
		} else if (!pais_nome.equals(other.pais_nome))
			return false;
		if (pais_sigla == null) {
			if (other.pais_sigla != null)
				return false;
		} else if (!pais_sigla.equals(other.pais_sigla))
			return false;
		return true;
	}
	
	

}
