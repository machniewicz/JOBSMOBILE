package br.com.jobs.modelo.cidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.estado.Estado;

@Entity
@Table(name="Cidade")
public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="cidade_id", insertable = true, updatable = false)
	private Integer cidade_id;
	
	@Column (name="cidade_descricao", length=200)
	private String cidade_descricao;

	@OneToOne
	@JoinColumn (name="estado_id")
	private Estado estado;

	public Integer getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(Integer cidade_id) {
		this.cidade_id = cidade_id;
	}

	public String getCidade_descricao() {
		return cidade_descricao;
	}

	public void setCidade_descricao(String cidade_descricao) {
		this.cidade_descricao = cidade_descricao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((cidade_descricao == null) ? 0 : cidade_descricao.hashCode());
		result = prime * result
				+ ((cidade_id == null) ? 0 : cidade_id.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		Cidade other = (Cidade) obj;
		if (cidade_descricao == null) {
			if (other.cidade_descricao != null)
				return false;
		} else if (!cidade_descricao.equals(other.cidade_descricao))
			return false;
		if (cidade_id == null) {
			if (other.cidade_id != null)
				return false;
		} else if (!cidade_id.equals(other.cidade_id))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}
	
	
	

}
