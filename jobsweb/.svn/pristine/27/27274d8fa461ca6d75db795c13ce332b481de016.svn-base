package br.com.jobs.modelo.enviado;

import java.io.Serializable;
import java.util.Date;

public class EnviadoGrafico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer enviado_grafico_id;
	private Integer enviado_grafico_quantidade;
	private Date enviado_grafico_data;
	public Integer getEnviado_grafico_id() {
		return enviado_grafico_id;
	}
	public void setEnviado_grafico_id(Integer enviado_grafico_id) {
		this.enviado_grafico_id = enviado_grafico_id;
	}
	public Integer getEnviado_grafico_quantidade() {
		return enviado_grafico_quantidade;
	}
	public void setEnviado_grafico_quantidade(Integer enviado_grafico_quantidade) {
		this.enviado_grafico_quantidade = enviado_grafico_quantidade;
	}
	public Date getEnviado_grafico_data() {
		return enviado_grafico_data;
	}
	public void setEnviado_grafico_data(Date enviado_grafico_data) {
		this.enviado_grafico_data = enviado_grafico_data;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((enviado_grafico_data == null) ? 0 : enviado_grafico_data
						.hashCode());
		result = prime
				* result
				+ ((enviado_grafico_id == null) ? 0 : enviado_grafico_id
						.hashCode());
		result = prime
				* result
				+ ((enviado_grafico_quantidade == null) ? 0
						: enviado_grafico_quantidade.hashCode());
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
		EnviadoGrafico other = (EnviadoGrafico) obj;
		if (enviado_grafico_data == null) {
			if (other.enviado_grafico_data != null)
				return false;
		} else if (!enviado_grafico_data.equals(other.enviado_grafico_data))
			return false;
		if (enviado_grafico_id == null) {
			if (other.enviado_grafico_id != null)
				return false;
		} else if (!enviado_grafico_id.equals(other.enviado_grafico_id))
			return false;
		if (enviado_grafico_quantidade == null) {
			if (other.enviado_grafico_quantidade != null)
				return false;
		} else if (!enviado_grafico_quantidade
				.equals(other.enviado_grafico_quantidade))
			return false;
		return true;
	}
	
	

}
