package br.com.jobs.modelo.faturamento;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.empresa.Empresa;

@Entity
@Table (name="Faturamento")
public class Faturamento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="faturamento_id", insertable = true, updatable = false)
	private Integer faturamento_id;
	
	@Column (name="faturamento_periodo", length=20)
	private String faturamento_periodo;
	
	@Column (name="faturamento_dt_inicio")
	private Date faturamento_dt_inicio;
	
	@Column (name="faturamento_dt_fim")
	private Date faturamento_dt_fim;
	
	@Column (name="faturamento_dt_gerado")
	private Date faturamento_dt_gerado;
	
	@Column (name="faturamento_valor")
	private double faturamento_valor;
	
	@Column (name="faturamento_situacao")
	private String faturamento_situacao;
	
	@OneToOne
	@JoinColumn (name="empresa_id")
	private Empresa empresa;

	public Integer getFaturamento_id() {
		return faturamento_id;
	}

	public void setFaturamento_id(Integer faturamento_id) {
		this.faturamento_id = faturamento_id;
	}

	public String getFaturamento_periodo() {
		return faturamento_periodo;
	}

	public void setFaturamento_periodo(String faturamento_periodo) {
		this.faturamento_periodo = faturamento_periodo;
	}

	public Date getFaturamento_dt_inicio() {
		return faturamento_dt_inicio;
	}

	public void setFaturamento_dt_inicio(Date faturamento_dt_inicio) {
		this.faturamento_dt_inicio = faturamento_dt_inicio;
	}

	public Date getFaturamento_dt_fim() {
		return faturamento_dt_fim;
	}

	public void setFaturamento_dt_fim(Date faturamento_dt_fim) {
		this.faturamento_dt_fim = faturamento_dt_fim;
	}

	public Date getFaturamento_dt_gerado() {
		return faturamento_dt_gerado;
	}

	public void setFaturamento_dt_gerado(Date faturamento_dt_gerado) {
		this.faturamento_dt_gerado = faturamento_dt_gerado;
	}

	public double getFaturamento_valor() {
		return faturamento_valor;
	}

	public void setFaturamento_valor(double faturamento_valor) {
		this.faturamento_valor = faturamento_valor;
	}

	public String getFaturamento_situacao() {
		return faturamento_situacao;
	}

	public void setFaturamento_situacao(String faturamento_situacao) {
		this.faturamento_situacao = faturamento_situacao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((faturamento_dt_fim == null) ? 0 : faturamento_dt_fim.hashCode());
		result = prime * result + ((faturamento_dt_gerado == null) ? 0 : faturamento_dt_gerado.hashCode());
		result = prime * result + ((faturamento_dt_inicio == null) ? 0 : faturamento_dt_inicio.hashCode());
		result = prime * result + ((faturamento_id == null) ? 0 : faturamento_id.hashCode());
		result = prime * result + ((faturamento_periodo == null) ? 0 : faturamento_periodo.hashCode());
		result = prime * result + ((faturamento_situacao == null) ? 0 : faturamento_situacao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(faturamento_valor);
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
		Faturamento other = (Faturamento) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (faturamento_dt_fim == null) {
			if (other.faturamento_dt_fim != null)
				return false;
		} else if (!faturamento_dt_fim.equals(other.faturamento_dt_fim))
			return false;
		if (faturamento_dt_gerado == null) {
			if (other.faturamento_dt_gerado != null)
				return false;
		} else if (!faturamento_dt_gerado.equals(other.faturamento_dt_gerado))
			return false;
		if (faturamento_dt_inicio == null) {
			if (other.faturamento_dt_inicio != null)
				return false;
		} else if (!faturamento_dt_inicio.equals(other.faturamento_dt_inicio))
			return false;
		if (faturamento_id == null) {
			if (other.faturamento_id != null)
				return false;
		} else if (!faturamento_id.equals(other.faturamento_id))
			return false;
		if (faturamento_periodo == null) {
			if (other.faturamento_periodo != null)
				return false;
		} else if (!faturamento_periodo.equals(other.faturamento_periodo))
			return false;
		if (faturamento_situacao == null) {
			if (other.faturamento_situacao != null)
				return false;
		} else if (!faturamento_situacao.equals(other.faturamento_situacao))
			return false;
		if (Double.doubleToLongBits(faturamento_valor) != Double.doubleToLongBits(other.faturamento_valor))
			return false;
		return true;
	}

}
