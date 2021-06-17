package br.com.jobs.modelo.meta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.comissao.Comissao;

@Entity
@Table(name="Meta")
public class Meta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="meta_id", insertable = true, updatable = false)
	private Integer meta_id;
	
	@Column (name="meta_quantidade")
	private Integer meta_quantidade;
	
	@OneToOne
	@JoinColumn (name="comissao_id")
	private Comissao comissao;
	
	@Column (name="meta_status")
	private Boolean meta_status;

	public Integer getMeta_id() {
		return meta_id;
	}

	public void setMeta_id(Integer meta_id) {
		this.meta_id = meta_id;
	}

	public Integer getMeta_quantidade() {
		return meta_quantidade;
	}

	public void setMeta_quantidade(Integer meta_quantidade) {
		this.meta_quantidade = meta_quantidade;
	}

	public Comissao getComissao() {
		return comissao;
	}

	public void setComissao(Comissao comissao) {
		this.comissao = comissao;
	}

	public Boolean getMeta_status() {
		return meta_status;
	}

	public void setMeta_status(Boolean meta_status) {
		this.meta_status = meta_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comissao == null) ? 0 : comissao.hashCode());
		result = prime * result + ((meta_id == null) ? 0 : meta_id.hashCode());
		result = prime * result + ((meta_quantidade == null) ? 0 : meta_quantidade.hashCode());
		result = prime * result + ((meta_status == null) ? 0 : meta_status.hashCode());
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
		Meta other = (Meta) obj;
		if (comissao == null) {
			if (other.comissao != null)
				return false;
		} else if (!comissao.equals(other.comissao))
			return false;
		if (meta_id == null) {
			if (other.meta_id != null)
				return false;
		} else if (!meta_id.equals(other.meta_id))
			return false;
		if (meta_quantidade == null) {
			if (other.meta_quantidade != null)
				return false;
		} else if (!meta_quantidade.equals(other.meta_quantidade))
			return false;
		if (meta_status == null) {
			if (other.meta_status != null)
				return false;
		} else if (!meta_status.equals(other.meta_status))
			return false;
		return true;
	}

	
}
