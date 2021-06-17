package br.com.jobs.modelo.situacao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Situacao")
public class Situacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="situacao_id", insertable = true, updatable = false)
	private Integer situacao_id;
	
	@Column (name="situacao_status")
	private Boolean situacao_status;
	
	@Column (name="situacao_descricao", length=50)
	private String situacao_descricao;

	public Integer getSituacao_id() {
		return situacao_id;
	}

	public void setSituacao_id(Integer situacao_id) {
		this.situacao_id = situacao_id;
	}

	public Boolean getSituacao_status() {
		return situacao_status;
	}

	public void setSituacao_status(Boolean situacao_status) {
		this.situacao_status = situacao_status;
	}

	public String getSituacao_descricao() {
		return situacao_descricao;
	}

	public void setSituacao_descricao(String situacao_descricao) {
		this.situacao_descricao = situacao_descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((situacao_descricao == null) ? 0 : situacao_descricao
						.hashCode());
		result = prime * result
				+ ((situacao_id == null) ? 0 : situacao_id.hashCode());
		result = prime * result
				+ ((situacao_status == null) ? 0 : situacao_status.hashCode());
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
		Situacao other = (Situacao) obj;
		if (situacao_descricao == null) {
			if (other.situacao_descricao != null)
				return false;
		} else if (!situacao_descricao.equals(other.situacao_descricao))
			return false;
		if (situacao_id == null) {
			if (other.situacao_id != null)
				return false;
		} else if (!situacao_id.equals(other.situacao_id))
			return false;
		if (situacao_status == null) {
			if (other.situacao_status != null)
				return false;
		} else if (!situacao_status.equals(other.situacao_status))
			return false;
		return true;
	}

	
}
