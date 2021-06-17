package br.com.jobs.modelo.estado;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.pais.Pais;


@Entity
@Table (name="Estado")
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="estado_id", insertable = true, updatable = false)
	private Integer estado_id;
	
	@Column (name="estado_descricao", length=50)
	private String estado_descricao;
	
	@Column (name="estado_sigla", length=5)
	private String estado_sigla;
	
	@OneToOne  
    @JoinColumn(name="pais_id")   
	private Pais pais;

	public Integer getEstado_id() {
		return estado_id;
	}

	public void setEstado_id(Integer estado_id) {
		this.estado_id = estado_id;
	}

	public String getEstado_descricao() {
		return estado_descricao;
	}

	public void setEstado_descricao(String estado_descricao) {
		this.estado_descricao = estado_descricao;
	}

	public String getEstado_sigla() {
		return estado_sigla;
	}

	public void setEstado_sigla(String estado_sigla) {
		this.estado_sigla = estado_sigla;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((estado_descricao == null) ? 0 : estado_descricao.hashCode());
		result = prime * result
				+ ((estado_id == null) ? 0 : estado_id.hashCode());
		result = prime * result
				+ ((estado_sigla == null) ? 0 : estado_sigla.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
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
		Estado other = (Estado) obj;
		if (estado_descricao == null) {
			if (other.estado_descricao != null)
				return false;
		} else if (!estado_descricao.equals(other.estado_descricao))
			return false;
		if (estado_id == null) {
			if (other.estado_id != null)
				return false;
		} else if (!estado_id.equals(other.estado_id))
			return false;
		if (estado_sigla == null) {
			if (other.estado_sigla != null)
				return false;
		} else if (!estado_sigla.equals(other.estado_sigla))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		return true;
	}
	
	
}
