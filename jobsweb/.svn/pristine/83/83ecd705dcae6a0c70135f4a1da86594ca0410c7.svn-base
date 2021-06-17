package br.com.jobs.modelo.funcao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.categoria.Categoria;

@Entity
//@SequenceGenerator(name = "funcao_id_seq", sequenceName = "funcao_id_seq", allocationSize = 1, initialValue = 1) 
@Table (name="Funcao")

public class Funcao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	//@Column (name="funcao_id", insertable = false, updatable = false, columnDefinition="serial")
	@Column (name="funcao_id", insertable = true, updatable = false)
	private Integer funcao_id;
	
	@Column (name="funcao_descricao", length=60)
	private String funcao_descricao;
	
	@Column (name="funcao_status")
	private Boolean funcao_status;
	
	@OneToOne  
    @JoinColumn(name="categoria_id")   
	private Categoria categoria;

	public Integer getFuncao_id() {
		return funcao_id;
	}

	public void setFuncao_id(Integer funcao_id) {
		this.funcao_id = funcao_id;
	}

	public String getFuncao_descricao() {
		return funcao_descricao;
	}

	public void setFuncao_descricao(String funcao_descricao) {
		this.funcao_descricao = funcao_descricao;
	}

	public Boolean getFuncao_status() {
		return funcao_status;
	}

	public void setFuncao_status(Boolean funcao_status) {
		this.funcao_status = funcao_status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime
				* result
				+ ((funcao_descricao == null) ? 0 : funcao_descricao.hashCode());
		result = prime * result
				+ ((funcao_id == null) ? 0 : funcao_id.hashCode());
		result = prime * result
				+ ((funcao_status == null) ? 0 : funcao_status.hashCode());
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
		Funcao other = (Funcao) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (funcao_descricao == null) {
			if (other.funcao_descricao != null)
				return false;
		} else if (!funcao_descricao.equals(other.funcao_descricao))
			return false;
		if (funcao_id == null) {
			if (other.funcao_id != null)
				return false;
		} else if (!funcao_id.equals(other.funcao_id))
			return false;
		if (funcao_status == null) {
			if (other.funcao_status != null)
				return false;
		} else if (!funcao_status.equals(other.funcao_status))
			return false;
		return true;
	}
	
	
}
