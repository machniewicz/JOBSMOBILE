package br.com.jobs.modelo.estatistica;

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

import br.com.jobs.modelo.categoria.Categoria;
import br.com.jobs.modelo.oportunidade.Oportunidade;

@Entity
@Table (name="Estatistica")
public class Estatistica implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column (name="estatistica_id", insertable = true, updatable = false)
	private Integer estatistica_id;
	
	@OneToOne  
    @JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@OneToOne  
    @JoinColumn(name="oportunidade_id")
	private Oportunidade oportunidade;
	
	@Column (name="estatistica_data")
	private Date estatistica_data;

	/*
	 * Get e Set
	 */
	
	public Integer getEstatistica_id() {
		return estatistica_id;
	}

	public void setEstatistica_id(Integer estatistica_id) {
		this.estatistica_id = estatistica_id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Oportunidade getOportunidade() {
		return oportunidade;
	}

	public void setOportunidade(Oportunidade oportunidade) {
		this.oportunidade = oportunidade;
	}

	public Date getEstatistica_data() {
		return estatistica_data;
	}

	public void setEstatistica_data(Date estatistica_data) {
		this.estatistica_data = estatistica_data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime
				* result
				+ ((estatistica_data == null) ? 0 : estatistica_data.hashCode());
		result = prime * result
				+ ((estatistica_id == null) ? 0 : estatistica_id.hashCode());
		result = prime * result
				+ ((oportunidade == null) ? 0 : oportunidade.hashCode());
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
		Estatistica other = (Estatistica) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (estatistica_data == null) {
			if (other.estatistica_data != null)
				return false;
		} else if (!estatistica_data.equals(other.estatistica_data))
			return false;
		if (estatistica_id == null) {
			if (other.estatistica_id != null)
				return false;
		} else if (!estatistica_id.equals(other.estatistica_id))
			return false;
		if (oportunidade == null) {
			if (other.oportunidade != null)
				return false;
		} else if (!oportunidade.equals(other.oportunidade))
			return false;
		return true;
	}
	
	
	
}
