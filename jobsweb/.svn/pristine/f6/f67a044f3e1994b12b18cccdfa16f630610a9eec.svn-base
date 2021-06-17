package br.com.jobs.modelo.enviado;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.cadastro.Cadastro;
import br.com.jobs.modelo.oportunidade.Oportunidade;

@Entity
@Table (name="Enviado")
public class Enviado implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column (name="enviado_id", insertable = true, updatable = false)
	private Integer enviado_id;
	
	@Column (name="enviado_nome", length=50)
	private String enviado_nome;
	
	@Column (name="enviado_email", length=50)
	private String enviado_email;
	
	@OneToOne  
    @JoinColumn(name="cadastro_id")
	private Cadastro cadastro;
	
	@OneToOne  
    @JoinColumn(name="oportunidade_id")
	private Oportunidade oportunidade;
	
	@Column (name="enviado_data")
	private Date enviado_data;

	public Integer getEnviado_id() {
		return enviado_id;
	}

	public void setEnviado_id(Integer enviado_id) {
		this.enviado_id = enviado_id;
	}

	public String getEnviado_nome() {
		return enviado_nome;
	}

	public void setEnviado_nome(String enviado_nome) {
		this.enviado_nome = enviado_nome;
	}

	public String getEnviado_email() {
		return enviado_email;
	}

	public void setEnviado_email(String enviado_email) {
		this.enviado_email = enviado_email;
	}
	
	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	
	public Oportunidade getOportunidade() {
		return oportunidade;
	}

	public void setOportunidade(Oportunidade oportunidade) {
		this.oportunidade = oportunidade;
	}

	public Date getEnviado_data() {
		return enviado_data;
	}

	public void setEnviado_data(Date enviado_data) {
		this.enviado_data = enviado_data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((enviado_data == null) ? 0 : enviado_data.hashCode());
		result = prime * result
				+ ((enviado_email == null) ? 0 : enviado_email.hashCode());
		result = prime * result
				+ ((enviado_id == null) ? 0 : enviado_id.hashCode());
		result = prime * result
				+ ((enviado_nome == null) ? 0 : enviado_nome.hashCode());
		result = prime * result
				+ ((oportunidade == null) ? 0 : oportunidade.hashCode());
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
		Enviado other = (Enviado) obj;
		if (enviado_data == null) {
			if (other.enviado_data != null)
				return false;
		} else if (!enviado_data.equals(other.enviado_data))
			return false;
		if (enviado_email == null) {
			if (other.enviado_email != null)
				return false;
		} else if (!enviado_email.equals(other.enviado_email))
			return false;
		if (enviado_id == null) {
			if (other.enviado_id != null)
				return false;
		} else if (!enviado_id.equals(other.enviado_id))
			return false;
		if (enviado_nome == null) {
			if (other.enviado_nome != null)
				return false;
		} else if (!enviado_nome.equals(other.enviado_nome))
			return false;
		if (oportunidade == null) {
			if (other.oportunidade != null)
				return false;
		} else if (!oportunidade.equals(other.oportunidade))
			return false;
		return true;
	}
	
	

}
