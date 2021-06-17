package br.com.jobs.combinacao.software;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.nivel.Nivel;
import br.com.jobs.modelo.software.Software;

@Entity
@Table (name="Combinacao_Software")
public class Combinacao_Software implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="combinacao_software_id", insertable = true, updatable = false)
	private Integer combinacao_software_id;
		
	@OneToOne  
    @JoinColumn(name="software_id")
	private Software software;
	
	@OneToOne  
    @JoinColumn(name="nivel_id")
	private Nivel nivel;

	public Integer getCombinacao_software_id() {
		return combinacao_software_id;
	}

	public void setCombinacao_software_id(Integer combinacao_software_id) {
		this.combinacao_software_id = combinacao_software_id;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((combinacao_software_id == null) ? 0
						: combinacao_software_id.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result
				+ ((software == null) ? 0 : software.hashCode());
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
		Combinacao_Software other = (Combinacao_Software) obj;
		if (combinacao_software_id == null) {
			if (other.combinacao_software_id != null)
				return false;
		} else if (!combinacao_software_id.equals(other.combinacao_software_id))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (software == null) {
			if (other.software != null)
				return false;
		} else if (!software.equals(other.software))
			return false;
		return true;
	}

	
}
