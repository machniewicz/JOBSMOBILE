package br.com.jobs.combinacao.idioma;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.idioma.Idioma;
import br.com.jobs.modelo.nivel.Nivel;

@Entity
@Table (name="Combinacao_Idioma")
public class Combinacao_Idioma implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="combinacao_idioma_id", insertable = true, updatable = false)
	private Integer combinacao_idioma_id;
	
	@OneToOne  
    @JoinColumn(name="idioma_id")
	private Idioma idioma;
	
	@OneToOne  
	@JoinColumn(name="nivel_id")
	private Nivel nivel;

	public Integer getCombinacao_idioma_id() {
		return combinacao_idioma_id;
	}

	public void setCombinacao_idioma_id(Integer combinacao_idioma_id) {
		this.combinacao_idioma_id = combinacao_idioma_id;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((combinacao_idioma_id == null) ? 0 : combinacao_idioma_id
						.hashCode());
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
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
		Combinacao_Idioma other = (Combinacao_Idioma) obj;
		if (combinacao_idioma_id == null) {
			if (other.combinacao_idioma_id != null)
				return false;
		} else if (!combinacao_idioma_id.equals(other.combinacao_idioma_id))
			return false;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		return true;
	}
	
	 
}
