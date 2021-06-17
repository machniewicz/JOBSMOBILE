package br.com.jobs.modelo;

import java.io.Serializable;


public class Provedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String PROVEDOR = "provedor";
	public static final String PROVEDOR_CODIGO = "provedor_codigo";
	public static final String PROVEDOR_DESCRICAO = "provedor_descricao";
	public static final String PROVEDOR_SMTP = "provedor_smtp";
	public static final String PROVEDOR_PORTA = "provedor_porta";
	
	private Integer provedor_codigo;
	private String provedor_descricao;
	private String provedor_smtp;
	private String provedor_porta;
	
	public Integer getProvedor_codigo() {
		return provedor_codigo;
	}
	public void setProvedor_codigo(Integer provedor_codigo) {
		this.provedor_codigo = provedor_codigo;
	}
	public String getProvedor_descricao() {
		return provedor_descricao;
	}
	public void setProvedor_descricao(String provedor_descricao) {
		this.provedor_descricao = provedor_descricao;
	}
	public String getProvedor_porta() {
		return provedor_porta;
	}
	public void setProvedor_porta(String provedor_porta) {
		this.provedor_porta = provedor_porta;
	}
	
	public String getProvedor_smtp() {
		return provedor_smtp;
	}
	public void setProvedor_smtp(String provedor_smtp) {
		this.provedor_smtp = provedor_smtp;
	}
	
	public String toString() {  
		return (this.getProvedor_descricao() + " - " + this.getProvedor_smtp());  
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((provedor_codigo == null) ? 0 : provedor_codigo.hashCode());
		result = prime
				* result
				+ ((provedor_descricao == null) ? 0 : provedor_descricao
						.hashCode());
		result = prime * result
				+ ((provedor_porta == null) ? 0 : provedor_porta.hashCode());
		result = prime * result
				+ ((provedor_smtp == null) ? 0 : provedor_smtp.hashCode());
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
		Provedor other = (Provedor) obj;
		if (provedor_codigo == null) {
			if (other.provedor_codigo != null)
				return false;
		} else if (!provedor_codigo.equals(other.provedor_codigo))
			return false;
		if (provedor_descricao == null) {
			if (other.provedor_descricao != null)
				return false;
		} else if (!provedor_descricao.equals(other.provedor_descricao))
			return false;
		if (provedor_porta == null) {
			if (other.provedor_porta != null)
				return false;
		} else if (!provedor_porta.equals(other.provedor_porta))
			return false;
		if (provedor_smtp == null) {
			if (other.provedor_smtp != null)
				return false;
		} else if (!provedor_smtp.equals(other.provedor_smtp))
			return false;
		return true;
	}
	
	
	
}
