package br.com.jobs.mobile.modelo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;


public class Curriculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer curriculo_codigo;
	private Date curriculo_data_inclusao;
	private byte[] 	curriculo_arquivo;
	private String curriculo_descricao;
	
	public Integer getCurriculo_codigo() {
		return curriculo_codigo;
	}
	public void setCurriculo_codigo(Integer curriculo_codigo) {
		this.curriculo_codigo = curriculo_codigo;
	}
	public Date getCurriculo_data_inclusao() {
		return curriculo_data_inclusao;
	}
	public void setCurriculo_data_inclusao(Date curriculo_data_inclusao) {
		this.curriculo_data_inclusao = curriculo_data_inclusao;
	}
	public byte[] getCurriculo_arquivo() {
		return curriculo_arquivo;
	}
	public void setCurriculo_arquivo(byte[] curriculo_arquivo) {
		this.curriculo_arquivo = curriculo_arquivo;
	}
	
	public String getCurriculo_descricao() {
		return curriculo_descricao;
	}
	public void setCurriculo_descricao(String curriculo_descricao) {
		this.curriculo_descricao = curriculo_descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(curriculo_arquivo);
		result = prime
				* result
				+ ((curriculo_codigo == null) ? 0 : curriculo_codigo.hashCode());
		result = prime
				* result
				+ ((curriculo_data_inclusao == null) ? 0
						: curriculo_data_inclusao.hashCode());
		result = prime
				* result
				+ ((curriculo_descricao == null) ? 0 : curriculo_descricao
						.hashCode());
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
		Curriculo other = (Curriculo) obj;
		if (!Arrays.equals(curriculo_arquivo, other.curriculo_arquivo))
			return false;
		if (curriculo_codigo == null) {
			if (other.curriculo_codigo != null)
				return false;
		} else if (!curriculo_codigo.equals(other.curriculo_codigo))
			return false;
		if (curriculo_data_inclusao == null) {
			if (other.curriculo_data_inclusao != null)
				return false;
		} else if (!curriculo_data_inclusao
				.equals(other.curriculo_data_inclusao))
			return false;
		if (curriculo_descricao == null) {
			if (other.curriculo_descricao != null)
				return false;
		} else if (!curriculo_descricao.equals(other.curriculo_descricao))
			return false;
		return true;
	}
	

}
