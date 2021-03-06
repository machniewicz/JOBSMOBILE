package br.com.jobs.modelo.beneficio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Beneficio")
public class Beneficio implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="beneficio_id", insertable = true, updatable = false)
	private Integer beneficio_id;
	
	@Column (name="beneficio_descricao", length=50)
	private String beneficio_descricao;
	
	@Column (name="beneficio_status")
	private Boolean beneficio_status;
	
	//@ManyToOne(targetEntity = Oportunidade.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//@JoinColumn(name="oportunidade_id")
	//private Oportunidade oportunidade;

	public Integer getBeneficio_id() {
		return beneficio_id;
	}

	public void setBeneficio_id(Integer beneficio_id) {
		this.beneficio_id = beneficio_id;
	}

	public String getBeneficio_descricao() {
		return beneficio_descricao;
	}

	public void setBeneficio_descricao(String beneficio_descricao) {
		this.beneficio_descricao = beneficio_descricao;
	}

	public Boolean getBeneficio_status() {
		return beneficio_status;
	}

	public void setBeneficio_status(Boolean beneficio_status) {
		this.beneficio_status = beneficio_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beneficio_descricao == null) ? 0 : beneficio_descricao.hashCode());
		result = prime * result + ((beneficio_id == null) ? 0 : beneficio_id.hashCode());
		result = prime * result + ((beneficio_status == null) ? 0 : beneficio_status.hashCode());
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
		Beneficio other = (Beneficio) obj;
		if (beneficio_descricao == null) {
			if (other.beneficio_descricao != null)
				return false;
		} else if (!beneficio_descricao.equals(other.beneficio_descricao))
			return false;
		if (beneficio_id == null) {
			if (other.beneficio_id != null)
				return false;
		} else if (!beneficio_id.equals(other.beneficio_id))
			return false;
		if (beneficio_status == null) {
			if (other.beneficio_status != null)
				return false;
		} else if (!beneficio_status.equals(other.beneficio_status))
			return false;
		return true;
	}

	//public Oportunidade getOportunidade() {
	//	return oportunidade;
	//}

	//public void setOportunidade(Oportunidade oportunidade) {
//		this.oportunidade = oportunidade;
//	}


	
}
