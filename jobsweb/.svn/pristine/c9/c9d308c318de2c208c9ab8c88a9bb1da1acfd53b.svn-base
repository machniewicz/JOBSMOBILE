package br.com.jobs.modelo.comissao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Comissao")
public class Comissao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="comissao_id", insertable = true, updatable = false)
	private Integer comissao_id;
	
	@Column (name="comissao_valor")
	private double comissao_valor;
	
	@Column (name="comissao_status")
	private Boolean comissao_status;

	public Integer getComissao_id() {
		return comissao_id;
	}

	public void setComissao_id(Integer comissao_id) {
		this.comissao_id = comissao_id;
	}

	public double getComissao_valor() {
		return comissao_valor;
	}

	public void setComissao_valor(double comissao_valor) {
		this.comissao_valor = comissao_valor;
	}

	public Boolean getComissao_status() {
		return comissao_status;
	}

	public void setComissao_status(Boolean comissao_status) {
		this.comissao_status = comissao_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comissao_id == null) ? 0 : comissao_id.hashCode());
		result = prime * result + ((comissao_status == null) ? 0 : comissao_status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(comissao_valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Comissao other = (Comissao) obj;
		if (comissao_id == null) {
			if (other.comissao_id != null)
				return false;
		} else if (!comissao_id.equals(other.comissao_id))
			return false;
		if (comissao_status == null) {
			if (other.comissao_status != null)
				return false;
		} else if (!comissao_status.equals(other.comissao_status))
			return false;
		if (Double.doubleToLongBits(comissao_valor) != Double.doubleToLongBits(other.comissao_valor))
			return false;
		return true;
	}


}
