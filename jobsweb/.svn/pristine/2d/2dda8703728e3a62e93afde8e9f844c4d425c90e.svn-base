package br.com.jobs.modelo.salario;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Salario")
public class Salario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column (name="salario_id", insertable = true, updatable = false)
	private Integer salario_id;
	
	@Column (name="salario_descricao", length=50)
	private String salario_descricao;
	
	@Column (name="salario_status")
	private Boolean salario_status;

	public Integer getSalario_id() {
		return salario_id;
	}

	public void setSalario_id(Integer salario_id) {
		this.salario_id = salario_id;
	}

	public String getSalario_descricao() {
		return salario_descricao;
	}

	public void setSalario_descricao(String salario_descricao) {
		this.salario_descricao = salario_descricao;
	}

	public Boolean getSalario_status() {
		return salario_status;
	}

	public void setSalario_status(Boolean salario_status) {
		this.salario_status = salario_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((salario_descricao == null) ? 0 : salario_descricao
						.hashCode());
		result = prime * result
				+ ((salario_id == null) ? 0 : salario_id.hashCode());
		result = prime * result
				+ ((salario_status == null) ? 0 : salario_status.hashCode());
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
		Salario other = (Salario) obj;
		if (salario_descricao == null) {
			if (other.salario_descricao != null)
				return false;
		} else if (!salario_descricao.equals(other.salario_descricao))
			return false;
		if (salario_id == null) {
			if (other.salario_id != null)
				return false;
		} else if (!salario_id.equals(other.salario_id))
			return false;
		if (salario_status == null) {
			if (other.salario_status != null)
				return false;
		} else if (!salario_status.equals(other.salario_status))
			return false;
		return true;
	}
	
		
}
