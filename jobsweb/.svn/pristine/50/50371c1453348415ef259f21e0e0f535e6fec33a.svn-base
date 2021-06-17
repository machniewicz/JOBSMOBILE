package br.com.jobs.modelo.experiencia;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Experiencia")
public class Experiencia implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="experiencia_id", insertable = true, updatable = false)
	private Integer experiencia_id;
	
	@Column (name="experiencia_empresa", length=100)
	private String experiencia_empresa;
	
	@Column (name="experiencia_dt_inicio")
	private Date experiencia_dt_inicio;
	
	@Column (name="experiencia_dt_fim")
	private Date experiencia_dt_fim;
	
	@Column (name="experiencia_funcao")
	private String experiencia_funcao;
	
	@Column (name="experiencia_descricao", length=1600)
	private String experiencia_descricao;
	
	@Column (name="experiencia_saida")
	private String experiencia_saida;
	
	@Column (name="experiencia_atual")
	private Boolean experiencia_atual;

	public Integer getExperiencia_id() {
		return experiencia_id;
	}

	public void setExperiencia_id(Integer experiencia_id) {
		this.experiencia_id = experiencia_id;
	}

	public String getExperiencia_empresa() {
		return experiencia_empresa;
	}

	public void setExperiencia_empresa(String experiencia_empresa) {
		this.experiencia_empresa = experiencia_empresa;
	}

	public Date getExperiencia_dt_inicio() {
		return experiencia_dt_inicio;
	}

	public void setExperiencia_dt_inicio(Date experiencia_dt_inicio) {
		this.experiencia_dt_inicio = experiencia_dt_inicio;
	}

	public Date getExperiencia_dt_fim() {
		return experiencia_dt_fim;
	}

	public void setExperiencia_dt_fim(Date experiencia_dt_fim) {
		this.experiencia_dt_fim = experiencia_dt_fim;
	}

	public String getExperiencia_funcao() {
		return experiencia_funcao;
	}

	public void setExperiencia_funcao(String experiencia_funcao) {
		this.experiencia_funcao = experiencia_funcao;
	}

	public String getExperiencia_descricao() {
		return experiencia_descricao;
	}

	public void setExperiencia_descricao(String experiencia_descricao) {
		this.experiencia_descricao = experiencia_descricao;
	}

	public String getExperiencia_saida() {
		return experiencia_saida;
	}

	public void setExperiencia_saida(String experiencia_saida) {
		this.experiencia_saida = experiencia_saida;
	}

	public Boolean getExperiencia_atual() {
		return experiencia_atual;
	}

	public void setExperiencia_atual(Boolean experiencia_atual) {
		this.experiencia_atual = experiencia_atual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((experiencia_atual == null) ? 0 : experiencia_atual
						.hashCode());
		result = prime
				* result
				+ ((experiencia_descricao == null) ? 0 : experiencia_descricao
						.hashCode());
		result = prime
				* result
				+ ((experiencia_dt_fim == null) ? 0 : experiencia_dt_fim
						.hashCode());
		result = prime
				* result
				+ ((experiencia_dt_inicio == null) ? 0 : experiencia_dt_inicio
						.hashCode());
		result = prime
				* result
				+ ((experiencia_empresa == null) ? 0 : experiencia_empresa
						.hashCode());
		result = prime
				* result
				+ ((experiencia_funcao == null) ? 0 : experiencia_funcao
						.hashCode());
		result = prime * result
				+ ((experiencia_id == null) ? 0 : experiencia_id.hashCode());
		result = prime
				* result
				+ ((experiencia_saida == null) ? 0 : experiencia_saida
						.hashCode());
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
		Experiencia other = (Experiencia) obj;
		if (experiencia_atual == null) {
			if (other.experiencia_atual != null)
				return false;
		} else if (!experiencia_atual.equals(other.experiencia_atual))
			return false;
		if (experiencia_descricao == null) {
			if (other.experiencia_descricao != null)
				return false;
		} else if (!experiencia_descricao.equals(other.experiencia_descricao))
			return false;
		if (experiencia_dt_fim == null) {
			if (other.experiencia_dt_fim != null)
				return false;
		} else if (!experiencia_dt_fim.equals(other.experiencia_dt_fim))
			return false;
		if (experiencia_dt_inicio == null) {
			if (other.experiencia_dt_inicio != null)
				return false;
		} else if (!experiencia_dt_inicio.equals(other.experiencia_dt_inicio))
			return false;
		if (experiencia_empresa == null) {
			if (other.experiencia_empresa != null)
				return false;
		} else if (!experiencia_empresa.equals(other.experiencia_empresa))
			return false;
		if (experiencia_funcao == null) {
			if (other.experiencia_funcao != null)
				return false;
		} else if (!experiencia_funcao.equals(other.experiencia_funcao))
			return false;
		if (experiencia_id == null) {
			if (other.experiencia_id != null)
				return false;
		} else if (!experiencia_id.equals(other.experiencia_id))
			return false;
		if (experiencia_saida == null) {
			if (other.experiencia_saida != null)
				return false;
		} else if (!experiencia_saida.equals(other.experiencia_saida))
			return false;
		return true;
	}
	
	
}
