package br.com.jobs.modelo.financeiro;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Financeiro")
public class Financeiro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="financeiro_id", insertable = true, updatable = false)
	private Integer financeiro_id;
	
	@Column (name="financeiro_situacao")
	private boolean financeiro_situacao;
	
	@Column (name="financeiro_caixa")
	private String financeiro_caixa; // A pagar ou a receber
	
	@Column (name="objeto_id")
	private Integer objeto_id;

	public Integer getFinanceiro_id() {
		return financeiro_id;
	}

	public void setFinanceiro_id(Integer financeiro_id) {
		this.financeiro_id = financeiro_id;
	}

	public boolean isFinanceiro_situacao() {
		return financeiro_situacao;
	}

	public void setFinanceiro_situacao(boolean financeiro_situacao) {
		this.financeiro_situacao = financeiro_situacao;
	}

	public String getFinanceiro_caixa() {
		return financeiro_caixa;
	}

	public void setFinanceiro_caixa(String financeiro_caixa) {
		this.financeiro_caixa = financeiro_caixa;
	}

	public Integer getObjeto_id() {
		return objeto_id;
	}

	public void setObjeto_id(Integer objeto_id) {
		this.objeto_id = objeto_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((financeiro_caixa == null) ? 0 : financeiro_caixa.hashCode());
		result = prime * result + ((financeiro_id == null) ? 0 : financeiro_id.hashCode());
		result = prime * result + (financeiro_situacao ? 1231 : 1237);
		result = prime * result + ((objeto_id == null) ? 0 : objeto_id.hashCode());
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
		Financeiro other = (Financeiro) obj;
		if (financeiro_caixa == null) {
			if (other.financeiro_caixa != null)
				return false;
		} else if (!financeiro_caixa.equals(other.financeiro_caixa))
			return false;
		if (financeiro_id == null) {
			if (other.financeiro_id != null)
				return false;
		} else if (!financeiro_id.equals(other.financeiro_id))
			return false;
		if (financeiro_situacao != other.financeiro_situacao)
			return false;
		if (objeto_id == null) {
			if (other.objeto_id != null)
				return false;
		} else if (!objeto_id.equals(other.objeto_id))
			return false;
		return true;
	}
	
}
