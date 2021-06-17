package br.com.jobs.modelo.software;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Software")
public class Software implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column (name="software_id", insertable = true, updatable = false)
	private Integer software_id;
	
	@Column (name="software_descricao", length=50)
	private String software_descricao;
	
	@Column (name="software_status")
	private Boolean software_status;
	
	public Integer getSoftware_id() {
		return software_id;
	}

	public void setSoftware_id(Integer software_id) {
		this.software_id = software_id;
	}

	public String getSoftware_descricao() {
		return software_descricao;
	}

	public void setSoftware_descricao(String software_descricao) {
		this.software_descricao = software_descricao;
	}

	public Boolean getSoftware_status() {
		return software_status;
	}

	public void setSoftware_status(Boolean software_status) {
		this.software_status = software_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((software_descricao == null) ? 0 : software_descricao
						.hashCode());
		result = prime * result
				+ ((software_id == null) ? 0 : software_id.hashCode());
		result = prime * result
				+ ((software_status == null) ? 0 : software_status.hashCode());
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
		if (software_status == null) {
			if (other.software_status != null)
				return false;
		} else if (!software_status.equals(other.software_status))
			return false;
		return true;
	}

	
}
