package br.com.jobs.modelo.curriculo;

import java.io.Serializable;
import java.util.Arrays;
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

@Entity
@Table (name="Curriculo")
public class Curriculo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column (name="curriculo_id", insertable = true, updatable = false)
	private Integer curriculo_id;
	
	@Column (name="curriculo_data")
	private Date curriculo_data;
	
	@Column (name="curriculo_arquivo")
	private byte[] 	curriculo_arquivo;
	
	@Column (name="curriculo_descricao", length=80)
	private String curriculo_descricao;
	
	@OneToOne  
    @JoinColumn(name="cadastro_id")
	private Cadastro cadastro;

	public Integer getCurriculo_id() {
		return curriculo_id;
	}

	public void setCurriculo_id(Integer curriculo_id) {
		this.curriculo_id = curriculo_id;
	}

	public Date getCurriculo_data() {
		return curriculo_data;
	}

	public void setCurriculo_data(Date curriculo_data) {
		this.curriculo_data = curriculo_data;
	}

	public byte[] getCurriculo_arquivo() {
		return curriculo_arquivo;
	}

	public void setCurriculo_arquivo(byte[] curriculo_arquivo) {
		this.curriculo_arquivo = curriculo_arquivo;
	}

	public String getCurriculo_descricao() {
		return curriculo_descricao;
	}

	public void setCurriculo_descricao(String curriculo_descricao) {
		this.curriculo_descricao = curriculo_descricao;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cadastro == null) ? 0 : cadastro.hashCode());
		result = prime * result + Arrays.hashCode(curriculo_arquivo);
		result = prime * result
				+ ((curriculo_data == null) ? 0 : curriculo_data.hashCode());
		result = prime
				* result
				+ ((curriculo_descricao == null) ? 0 : curriculo_descricao
						.hashCode());
		result = prime * result
				+ ((curriculo_id == null) ? 0 : curriculo_id.hashCode());
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
		Curriculo other = (Curriculo) obj;
		if (cadastro == null) {
			if (other.cadastro != null)
				return false;
		} else if (!cadastro.equals(other.cadastro))
			return false;
		if (!Arrays.equals(curriculo_arquivo, other.curriculo_arquivo))
			return false;
		if (curriculo_data == null) {
			if (other.curriculo_data != null)
				return false;
		} else if (!curriculo_data.equals(other.curriculo_data))
			return false;
		if (curriculo_descricao == null) {
			if (other.curriculo_descricao != null)
				return false;
		} else if (!curriculo_descricao.equals(other.curriculo_descricao))
			return false;
		if (curriculo_id == null) {
			if (other.curriculo_id != null)
				return false;
		} else if (!curriculo_id.equals(other.curriculo_id))
			return false;
		return true;
	}
	
	
}
