package br.com.jobs.modelo.idioma;

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

import br.com.jobs.combinacao.idioma.Combinacao_Idioma;

@Entity
@Table (name="Idioma")
public class Idioma implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column (name="idioma_id", insertable = true, updatable = false)
	private Integer idioma_id;
	
	@Column (name="idioma_descricao", length=50)
	private String idioma_descricao;
	
	@Column (name="idioma_status")
	private Boolean idioma_status;
	
	@ManyToOne(targetEntity = Combinacao_Idioma.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="combinacao_idioma_id")
	private Combinacao_Idioma combinacao_idioma;
	

	public Integer getIdioma_id() {
		return idioma_id;
	}

	public void setIdioma_id(Integer idioma_id) {
		this.idioma_id = idioma_id;
	}

	public String getIdioma_descricao() {
		return idioma_descricao;
	}

	public void setIdioma_descricao(String idioma_descricao) {
		this.idioma_descricao = idioma_descricao;
	}

	public Boolean getIdioma_status() {
		return idioma_status;
	}

	public void setIdioma_status(Boolean idioma_status) {
		this.idioma_status = idioma_status;
	}

	public Combinacao_Idioma getCombinacao_idioma() {
		return combinacao_idioma;
	}

	public void setCombinacao_idioma(Combinacao_Idioma combinacao_idioma) {
		this.combinacao_idioma = combinacao_idioma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((combinacao_idioma == null) ? 0 : combinacao_idioma
						.hashCode());
		result = prime
				* result
				+ ((idioma_descricao == null) ? 0 : idioma_descricao.hashCode());
		result = prime * result
				+ ((idioma_id == null) ? 0 : idioma_id.hashCode());
		result = prime * result
				+ ((idioma_status == null) ? 0 : idioma_status.hashCode());
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
		Idioma other = (Idioma) obj;
		if (combinacao_idioma == null) {
			if (other.combinacao_idioma != null)
				return false;
		} else if (!combinacao_idioma.equals(other.combinacao_idioma))
			return false;
		if (idioma_descricao == null) {
			if (other.idioma_descricao != null)
				return false;
		} else if (!idioma_descricao.equals(other.idioma_descricao))
			return false;
		if (idioma_id == null) {
			if (other.idioma_id != null)
				return false;
		} else if (!idioma_id.equals(other.idioma_id))
			return false;
		if (idioma_status == null) {
			if (other.idioma_status != null)
				return false;
		} else if (!idioma_status.equals(other.idioma_status))
			return false;
		return true;
	}


			
}
