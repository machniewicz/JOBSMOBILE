package br.com.jobs.modelo.ajudadecusto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.jobs.combinacao.ajudadecusto.Combinacao_AjudaDeCusto;


@Entity
@Table (name="AjudaDeCusto")
public class AjudaDeCusto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="ajudadecusto_id", insertable = true, updatable = false)
	private Integer ajudadecusto_id;
	
	@Column (name="ajudadecusto_status")
	private Boolean ajudadecusto_status;
	
	@Column (name="ajudadecusto_descricao", length=60)
	private String ajudadecusto_descricao;

	@ManyToOne(targetEntity = Combinacao_AjudaDeCusto.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="combinacao_ajudadecusto_id")
	private Combinacao_AjudaDeCusto combinacao_ajudadecusto;

	public Integer getAjudadecusto_id() {
		return ajudadecusto_id;
	}

	public void setAjudadecusto_id(Integer ajudadecusto_id) {
		this.ajudadecusto_id = ajudadecusto_id;
	}

	public Boolean getAjudadecusto_status() {
		return ajudadecusto_status;
	}

	public void setAjudadecusto_status(Boolean ajudadecusto_status) {
		this.ajudadecusto_status = ajudadecusto_status;
	}

	public String getAjudadecusto_descricao() {
		return ajudadecusto_descricao;
	}

	public void setAjudadecusto_descricao(String ajudadecusto_descricao) {
		this.ajudadecusto_descricao = ajudadecusto_descricao;
	}

	public Combinacao_AjudaDeCusto getCombinacao_ajudadecusto() {
		return combinacao_ajudadecusto;
	}

	public void setCombinacao_ajudadecusto(Combinacao_AjudaDeCusto combinacao_ajudadecusto) {
		this.combinacao_ajudadecusto = combinacao_ajudadecusto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ajudadecusto_descricao == null) ? 0 : ajudadecusto_descricao.hashCode());
		result = prime * result + ((ajudadecusto_id == null) ? 0 : ajudadecusto_id.hashCode());
		result = prime * result + ((ajudadecusto_status == null) ? 0 : ajudadecusto_status.hashCode());
		result = prime * result + ((combinacao_ajudadecusto == null) ? 0 : combinacao_ajudadecusto.hashCode());
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
		AjudaDeCusto other = (AjudaDeCusto) obj;
		if (ajudadecusto_descricao == null) {
			if (other.ajudadecusto_descricao != null)
				return false;
		} else if (!ajudadecusto_descricao.equals(other.ajudadecusto_descricao))
			return false;
		if (ajudadecusto_id == null) {
			if (other.ajudadecusto_id != null)
				return false;
		} else if (!ajudadecusto_id.equals(other.ajudadecusto_id))
			return false;
		if (ajudadecusto_status == null) {
			if (other.ajudadecusto_status != null)
				return false;
		} else if (!ajudadecusto_status.equals(other.ajudadecusto_status))
			return false;
		if (combinacao_ajudadecusto == null) {
			if (other.combinacao_ajudadecusto != null)
				return false;
		} else if (!combinacao_ajudadecusto.equals(other.combinacao_ajudadecusto))
			return false;
		return true;
	}


}
