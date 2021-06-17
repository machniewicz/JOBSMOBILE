package br.com.jobs.modelo;

import java.io.Serializable;

public class Salario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer salario_id;
	private String salario_descricao;

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

	public String toString() {  
		return (this.getSalario_descricao());  
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
		return true;
	}

	
}
