package br.com.jobs.modelo.vaga;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vaga")
public class Vaga implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="vaga_id", insertable = true, updatable = false)
	private Integer vaga_id;
	
	@Column (name="vaga_descricao", length=50)
	private String vaga_descricao;

	@Column (name="vaga_informacao", length=250)
	private String vaga_informacao;
	
	@Column (name="vaga_status")
	private Boolean vaga_status;

	public Integer getVaga_id() {
		return vaga_id;
	}

	public void setVaga_id(Integer vaga_id) {
		this.vaga_id = vaga_id;
	}

	public String getVaga_descricao() {
		return vaga_descricao;
	}

	public void setVaga_descricao(String vaga_descricao) {
		this.vaga_descricao = vaga_descricao;
	}

	public String getVaga_informacao() {
		return vaga_informacao;
	}

	public void setVaga_informacao(String vaga_informacao) {
		this.vaga_informacao = vaga_informacao;
	}

	public Boolean getVaga_status() {
		return vaga_status;
	}

	public void setVaga_status(Boolean vaga_status) {
		this.vaga_status = vaga_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((vaga_descricao == null) ? 0 : vaga_descricao.hashCode());
		result = prime * result + ((vaga_id == null) ? 0 : vaga_id.hashCode());
		result = prime * result
				+ ((vaga_informacao == null) ? 0 : vaga_informacao.hashCode());
		result = prime * result
				+ ((vaga_status == null) ? 0 : vaga_status.hashCode());
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
		Vaga other = (Vaga) obj;
		if (vaga_descricao == null) {
			if (other.vaga_descricao != null)
				return false;
		} else if (!vaga_descricao.equals(other.vaga_descricao))
			return false;
		if (vaga_id == null) {
			if (other.vaga_id != null)
				return false;
		} else if (!vaga_id.equals(other.vaga_id))
			return false;
		if (vaga_informacao == null) {
			if (other.vaga_informacao != null)
				return false;
		} else if (!vaga_informacao.equals(other.vaga_informacao))
			return false;
		if (vaga_status == null) {
			if (other.vaga_status != null)
				return false;
		} else if (!vaga_status.equals(other.vaga_status))
			return false;
		return true;
	}

	

}
