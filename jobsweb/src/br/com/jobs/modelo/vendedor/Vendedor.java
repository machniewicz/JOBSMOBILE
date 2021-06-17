package br.com.jobs.modelo.vendedor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.jobs.combinacao.ajudadecusto.Combinacao_AjudaDeCusto;
import br.com.jobs.modelo.cidade.Cidade;
import br.com.jobs.modelo.estado.Estado;
import br.com.jobs.modelo.meta.Meta;

@Entity
@Table (name="Vendedor")
public class Vendedor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="vendedor_id", insertable = true, updatable = false)
	private Integer vendedor_id;
	
	@Column (name="vendedor_status")
	private Boolean vendedor_status;
	
	@Column (name="vendedor_nome", length=100)
	private String vendedor_nome;
	
	@Column (name="vendedor_telefone", length=20)
	private String vendedor_telefone;
	
	@Column (name="vendedor_celular", length=20)
	private String vendedor_celular;
	
	@Column (name="vendedor_email", length=100)
	private String vendedor_email;
	
	@OneToOne
	@JoinColumn (name="estado_id")
	private Estado estado;
	
	@OneToOne
	@JoinColumn (name="cidade_id")
	private Cidade cidade;
	
	@OneToOne
	@JoinColumn (name="meta_id")
	private Meta meta;

	@OneToMany(targetEntity = Combinacao_AjudaDeCusto.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Combinacao_AjudaDeCusto> combinacoes_ajudadecusto = new ArrayList<Combinacao_AjudaDeCusto>();

	public Integer getVendedor_id() {
		return vendedor_id;
	}

	public void setVendedor_id(Integer vendedor_id) {
		this.vendedor_id = vendedor_id;
	}

	public Boolean getVendedor_status() {
		return vendedor_status;
	}

	public void setVendedor_status(Boolean vendedor_status) {
		this.vendedor_status = vendedor_status;
	}

	public String getVendedor_nome() {
		return vendedor_nome;
	}

	public void setVendedor_nome(String vendedor_nome) {
		this.vendedor_nome = vendedor_nome;
	}

	public String getVendedor_telefone() {
		return vendedor_telefone;
	}

	public void setVendedor_telefone(String vendedor_telefone) {
		this.vendedor_telefone = vendedor_telefone;
	}

	public String getVendedor_celular() {
		return vendedor_celular;
	}

	public void setVendedor_celular(String vendedor_celular) {
		this.vendedor_celular = vendedor_celular;
	}

	public String getVendedor_email() {
		return vendedor_email;
	}

	public void setVendedor_email(String vendedor_email) {
		this.vendedor_email = vendedor_email;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<Combinacao_AjudaDeCusto> getCombinacoes_ajudadecusto() {
		return combinacoes_ajudadecusto;
	}

	public void setCombinacoes_ajudadecusto(List<Combinacao_AjudaDeCusto> combinacoes_ajudadecusto) {
		this.combinacoes_ajudadecusto = combinacoes_ajudadecusto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((combinacoes_ajudadecusto == null) ? 0 : combinacoes_ajudadecusto.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((meta == null) ? 0 : meta.hashCode());
		result = prime * result + ((vendedor_celular == null) ? 0 : vendedor_celular.hashCode());
		result = prime * result + ((vendedor_email == null) ? 0 : vendedor_email.hashCode());
		result = prime * result + ((vendedor_id == null) ? 0 : vendedor_id.hashCode());
		result = prime * result + ((vendedor_nome == null) ? 0 : vendedor_nome.hashCode());
		result = prime * result + ((vendedor_status == null) ? 0 : vendedor_status.hashCode());
		result = prime * result + ((vendedor_telefone == null) ? 0 : vendedor_telefone.hashCode());
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
		Vendedor other = (Vendedor) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (combinacoes_ajudadecusto == null) {
			if (other.combinacoes_ajudadecusto != null)
				return false;
		} else if (!combinacoes_ajudadecusto.equals(other.combinacoes_ajudadecusto))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (meta == null) {
			if (other.meta != null)
				return false;
		} else if (!meta.equals(other.meta))
			return false;
		if (vendedor_celular == null) {
			if (other.vendedor_celular != null)
				return false;
		} else if (!vendedor_celular.equals(other.vendedor_celular))
			return false;
		if (vendedor_email == null) {
			if (other.vendedor_email != null)
				return false;
		} else if (!vendedor_email.equals(other.vendedor_email))
			return false;
		if (vendedor_id == null) {
			if (other.vendedor_id != null)
				return false;
		} else if (!vendedor_id.equals(other.vendedor_id))
			return false;
		if (vendedor_nome == null) {
			if (other.vendedor_nome != null)
				return false;
		} else if (!vendedor_nome.equals(other.vendedor_nome))
			return false;
		if (vendedor_status == null) {
			if (other.vendedor_status != null)
				return false;
		} else if (!vendedor_status.equals(other.vendedor_status))
			return false;
		if (vendedor_telefone == null) {
			if (other.vendedor_telefone != null)
				return false;
		} else if (!vendedor_telefone.equals(other.vendedor_telefone))
			return false;
		return true;
	}

	
}
