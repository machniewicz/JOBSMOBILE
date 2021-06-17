package br.com.jobs.mobile.modelo;

import java.io.Serializable;
import java.util.Date;


public class Enviado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer enviado_id;
	private String enviado_nome;
	private String enviado_email;
	private String enviado_cpf;
	private Integer enviado_oportunidade_id;
	private Date enviado_data;
	
	public Integer getEnviado_id() {
		return enviado_id;
	}
	
	public void setEnviado_id(Integer enviado_id) {
		this.enviado_id = enviado_id;
	}
	
	public String getEnviado_nome() {
		return enviado_nome;
	}
	
	public void setEnviado_nome(String enviado_nome) {
		this.enviado_nome = enviado_nome;
	}
	
	public String getEnviado_email() {
		return enviado_email;
	}
	
	public void setEnviado_email(String enviado_email) {
		this.enviado_email = enviado_email;
	}
	
	public String getEnviado_cpf() {
		return enviado_cpf;
	}
	
	public void setEnviado_cpf(String enviado_cpf) {
		this.enviado_cpf = enviado_cpf;
	}
	
	public Integer getEnviado_oportunidade_id() {
		return enviado_oportunidade_id;
	}
	
	public void setEnviado_oportunidade_id(Integer enviado_oportunidade_id) {
		this.enviado_oportunidade_id = enviado_oportunidade_id;
	}
	
	public Date getEnviado_data() {
		return enviado_data;
	}
	public void setEnviado_data(Date enviado_data) {
		this.enviado_data = enviado_data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enviado_cpf == null) ? 0 : enviado_cpf.hashCode());
		result = prime * result
				+ ((enviado_data == null) ? 0 : enviado_data.hashCode());
		result = prime * result
				+ ((enviado_email == null) ? 0 : enviado_email.hashCode());
		result = prime * result
				+ ((enviado_id == null) ? 0 : enviado_id.hashCode());
		result = prime * result
				+ ((enviado_nome == null) ? 0 : enviado_nome.hashCode());
		result = prime
				* result
				+ ((enviado_oportunidade_id == null) ? 0
						: enviado_oportunidade_id.hashCode());
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
		Enviado other = (Enviado) obj;
		if (enviado_cpf == null) {
			if (other.enviado_cpf != null)
				return false;
		} else if (!enviado_cpf.equals(other.enviado_cpf))
			return false;
		if (enviado_data == null) {
			if (other.enviado_data != null)
				return false;
		} else if (!enviado_data.equals(other.enviado_data))
			return false;
		if (enviado_email == null) {
			if (other.enviado_email != null)
				return false;
		} else if (!enviado_email.equals(other.enviado_email))
			return false;
		if (enviado_id == null) {
			if (other.enviado_id != null)
				return false;
		} else if (!enviado_id.equals(other.enviado_id))
			return false;
		if (enviado_nome == null) {
			if (other.enviado_nome != null)
				return false;
		} else if (!enviado_nome.equals(other.enviado_nome))
			return false;
		if (enviado_oportunidade_id == null) {
			if (other.enviado_oportunidade_id != null)
				return false;
		} else if (!enviado_oportunidade_id
				.equals(other.enviado_oportunidade_id))
			return false;
		return true;
	}

}
