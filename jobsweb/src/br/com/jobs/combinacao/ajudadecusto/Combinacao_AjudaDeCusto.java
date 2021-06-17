package br.com.jobs.combinacao.ajudadecusto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.ajudadecusto.AjudaDeCusto;

@Entity
@Table (name="Combinacao_Ajudadecusto")
public class Combinacao_AjudaDeCusto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="combinacao_ajudadecusto_id", insertable = true, updatable = false)
	private Integer combinacao_ajudadecusto_id;
	
	@OneToOne  
    @JoinColumn(name="ajudadecusto_id")
	private AjudaDeCusto ajudadecusto;
	
	@Column (name="combinacao_ajudadecusto_valor")
	private Double combinacao_ajudadecusto_valor;

	public Integer getCombinacao_ajudadecusto_id() {
		return combinacao_ajudadecusto_id;
	}

	public void setCombinacao_ajudadecusto_id(Integer combinacao_ajudadecusto_id) {
		this.combinacao_ajudadecusto_id = combinacao_ajudadecusto_id;
	}

	public AjudaDeCusto getAjudadecusto() {
		return ajudadecusto;
	}

	public void setAjudadecusto(AjudaDeCusto ajudadecusto) {
		this.ajudadecusto = ajudadecusto;
	}

	public double getCombinacao_ajudadecusto_valor() {
		return combinacao_ajudadecusto_valor;
	}

	public void setCombinacao_ajudadecusto_valor(double combinacao_ajudadecusto_valor) {
		this.combinacao_ajudadecusto_valor = combinacao_ajudadecusto_valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ajudadecusto == null) ? 0 : ajudadecusto.hashCode());
		result = prime * result + ((combinacao_ajudadecusto_id == null) ? 0 : combinacao_ajudadecusto_id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(combinacao_ajudadecusto_valor);
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
		Combinacao_AjudaDeCusto other = (Combinacao_AjudaDeCusto) obj;
		if (ajudadecusto == null) {
			if (other.ajudadecusto != null)
				return false;
		} else if (!ajudadecusto.equals(other.ajudadecusto))
			return false;
		if (combinacao_ajudadecusto_id == null) {
			if (other.combinacao_ajudadecusto_id != null)
				return false;
		} else if (!combinacao_ajudadecusto_id.equals(other.combinacao_ajudadecusto_id))
			return false;
		if (Double.doubleToLongBits(combinacao_ajudadecusto_valor) != Double
				.doubleToLongBits(other.combinacao_ajudadecusto_valor))
			return false;
		return true;
	}
	
	

}
