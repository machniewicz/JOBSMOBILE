package br.com.jobs.modelo.pagamento;

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

import br.com.jobs.modelo.vendedor.Vendedor;

@Entity
@Table (name="Pagamento")
public class Pagamento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="pagamento_id", insertable = true, updatable = false)
	private Integer pagamento_id;
	
	@Column (name="pagamento_periodo", length=30)
	private String pagamento_periodo;
	
	@Column (name="pagamento_dt_inicio")
	private Date pagamento_dt_inicio;
	
	@Column (name="pagamento_dt_fim")
	private Date pagamento_dt_fim;
	
	@Column (name="pagamento_dt_gerado")
	private Date pagamento_dt_gerado;
	
	@Column (name="pagamento_valor")
	private double pagamento_valor;
	
	@Column (name="pagamento_situacao", length=30)
	private String pagamento_situacao;
	
	@OneToOne
	@JoinColumn (name="vendedor_id")
	private Vendedor vendedor;
	
	
	public Integer getPagamento_id() {
		return pagamento_id;
	}
	public void setPagamento_id(Integer pagamento_id) {
		this.pagamento_id = pagamento_id;
	}
	public String getPagamento_periodo() {
		return pagamento_periodo;
	}
	public void setPagamento_periodo(String pagamento_periodo) {
		this.pagamento_periodo = pagamento_periodo;
	}
	public Date getPagamento_dt_inicio() {
		return pagamento_dt_inicio;
	}
	public void setPagamento_dt_inicio(Date pagamento_dt_inicio) {
		this.pagamento_dt_inicio = pagamento_dt_inicio;
	}
	public Date getPagamento_dt_fim() {
		return pagamento_dt_fim;
	}
	public void setPagamento_dt_fim(Date pagamento_dt_fim) {
		this.pagamento_dt_fim = pagamento_dt_fim;
	}
	public Date getPagamento_dt_gerado() {
		return pagamento_dt_gerado;
	}
	public void setPagamento_dt_gerado(Date pagamento_dt_gerado) {
		this.pagamento_dt_gerado = pagamento_dt_gerado;
	}
	public double getPagamento_valor() {
		return pagamento_valor;
	}
	public void setPagamento_valor(double pagamento_valor) {
		this.pagamento_valor = pagamento_valor;
	}
	public String getPagamento_situacao() {
		return pagamento_situacao;
	}
	public void setPagamento_situacao(String pagamento_situacao) {
		this.pagamento_situacao = pagamento_situacao;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pagamento_dt_fim == null) ? 0 : pagamento_dt_fim.hashCode());
		result = prime * result + ((pagamento_dt_gerado == null) ? 0 : pagamento_dt_gerado.hashCode());
		result = prime * result + ((pagamento_dt_inicio == null) ? 0 : pagamento_dt_inicio.hashCode());
		result = prime * result + ((pagamento_id == null) ? 0 : pagamento_id.hashCode());
		result = prime * result + ((pagamento_periodo == null) ? 0 : pagamento_periodo.hashCode());
		result = prime * result + ((pagamento_situacao == null) ? 0 : pagamento_situacao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(pagamento_valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((vendedor == null) ? 0 : vendedor.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (pagamento_dt_fim == null) {
			if (other.pagamento_dt_fim != null)
				return false;
		} else if (!pagamento_dt_fim.equals(other.pagamento_dt_fim))
			return false;
		if (pagamento_dt_gerado == null) {
			if (other.pagamento_dt_gerado != null)
				return false;
		} else if (!pagamento_dt_gerado.equals(other.pagamento_dt_gerado))
			return false;
		if (pagamento_dt_inicio == null) {
			if (other.pagamento_dt_inicio != null)
				return false;
		} else if (!pagamento_dt_inicio.equals(other.pagamento_dt_inicio))
			return false;
		if (pagamento_id == null) {
			if (other.pagamento_id != null)
				return false;
		} else if (!pagamento_id.equals(other.pagamento_id))
			return false;
		if (pagamento_periodo == null) {
			if (other.pagamento_periodo != null)
				return false;
		} else if (!pagamento_periodo.equals(other.pagamento_periodo))
			return false;
		if (pagamento_situacao == null) {
			if (other.pagamento_situacao != null)
				return false;
		} else if (!pagamento_situacao.equals(other.pagamento_situacao))
			return false;
		if (Double.doubleToLongBits(pagamento_valor) != Double.doubleToLongBits(other.pagamento_valor))
			return false;
		if (vendedor == null) {
			if (other.vendedor != null)
				return false;
		} else if (!vendedor.equals(other.vendedor))
			return false;
		return true;
	}
	
	}
