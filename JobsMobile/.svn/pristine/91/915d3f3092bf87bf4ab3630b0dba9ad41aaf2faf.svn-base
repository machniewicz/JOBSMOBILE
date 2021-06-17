package br.com.jobs.modelo;

import java.io.Serializable;


public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer estado_id;
	private String  estado_descricao;
	private String  estado_sigla;
	
	
	public Integer getEstado_id() {
		return estado_id;
	}
	public void setEstado_id(Integer estado_id) {
		this.estado_id = estado_id;
	}
	public String getEstado_descricao() {
		return estado_descricao;
	}
	public void setEstado_descricao(String estado_descricao) {
		this.estado_descricao = estado_descricao;
	}
	public String getEstado_sigla() {
		return estado_sigla;
	}
	public void setEstado_sigla(String estado_sigla) {
		this.estado_sigla = estado_sigla;
	}
	
	//Aqui esta a mágica, sem este método você terá uma exceção  
	public String toString() {  
		return (this.getEstado_sigla()+" - "+this.getEstado_descricao());  
	}  
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((estado_descricao == null) ? 0 : estado_descricao.hashCode());
		result = prime * result
				+ ((estado_id == null) ? 0 : estado_id.hashCode());
		result = prime * result
				+ ((estado_sigla == null) ? 0 : estado_sigla.hashCode());
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
		Estado other = (Estado) obj;
		if (estado_descricao == null) {
			if (other.estado_descricao != null)
				return false;
		} else if (!estado_descricao.equals(other.estado_descricao))
			return false;
		if (estado_id == null) {
			if (other.estado_id != null)
				return false;
		} else if (!estado_id.equals(other.estado_id))
			return false;
		if (estado_sigla == null) {
			if (other.estado_sigla != null)
				return false;
		} else if (!estado_sigla.equals(other.estado_sigla))
			return false;
		return true;
	}
	
	
	
}
