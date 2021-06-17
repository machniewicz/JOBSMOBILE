package br.com.jobs.modelo.empresa;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.jobs.modelo.cidade.Cidade;
import br.com.jobs.modelo.estado.Estado;

@Entity
@Table (name="Empresa")
public class Empresa  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empresa_id", insertable = true, updatable = false)
	private Integer empresa_id;
	
	@Column (name="empresa_razao", length=100)
	private String empresa_razao;
	
	@Column (name="empresa_cnpj", length=50)
	private String empresa_cnpj;
	
	@Column (name="empresa_alias", length=10)
	private String empresa_alias;
	
	@Column(name="empresa_endereco", length=200)
	private String empresa_endereco;
	
	@Column(name="empresa_bairro", length=50)
	private String empresa_bairro;
	
	@OneToOne
	@JoinColumn (name="cidade_id")
	private Cidade cidade;
	
	@OneToOne
	@JoinColumn (name="estado_id")
	private Estado estado;
	
	@Column(name="empresa_cep")
	private String empresa_cep;
	
	@Column(name="empresa_status")
	private Boolean empresa_status;
	
	@Column(name="empresa_divulgar")
	private Boolean empresa_divulgar;
	
	@Column(name="empresa_recebe_curriculo")
	private Boolean empresa_recebe_curriculo;

	@Column(name="empresa_banco_curriculo")
	private Boolean empresa_banco_curriculo;
	
	@Column(name="empresa_gratuito")
	private Boolean empresa_gratuito;

	@Column (name = "empresa_email", length=40)
	private String empresa_email;
	
	@Column (name = "empresa_telefone", length=20)
	private String empresa_telefone;
	
	@Column (name = "empresa_dt_inclusao")
	private Date empresa_dt_inclusao;
	
	@Column (name = "empresa_site")
	private String empresa_site;
	
	@Column (name = "empresa_dt_validade_inicio")
	private Date empresa_dt_validade_inicio;
	
	@Column (name = "empresa_dt_validade_fim")
	private Date empresa_dt_validade_fim;
	
	@Column (name = "empresa_quantidade")
	private Integer empresa_quantidade;
	
	@Column (name = "empresa_valor")
	private Double empresa_valor;

	public Integer getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(Integer empresa_id) {
		this.empresa_id = empresa_id;
	}

	public String getEmpresa_razao() {
		return empresa_razao;
	}

	public void setEmpresa_razao(String empresa_razao) {
		this.empresa_razao = empresa_razao;
	}

	public String getEmpresa_cnpj() {
		return empresa_cnpj;
	}

	public void setEmpresa_cnpj(String empresa_cnpj) {
		this.empresa_cnpj = empresa_cnpj;
	}

	public String getEmpresa_alias() {
		return empresa_alias;
	}

	public void setEmpresa_alias(String empresa_alias) {
		this.empresa_alias = empresa_alias;
	}

	public String getEmpresa_endereco() {
		return empresa_endereco;
	}

	public void setEmpresa_endereco(String empresa_endereco) {
		this.empresa_endereco = empresa_endereco;
	}

	public String getEmpresa_bairro() {
		return empresa_bairro;
	}

	public void setEmpresa_bairro(String empresa_bairro) {
		this.empresa_bairro = empresa_bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getEmpresa_cep() {
		return empresa_cep;
	}

	public void setEmpresa_cep(String empresa_cep) {
		this.empresa_cep = empresa_cep;
	}

	public Boolean getEmpresa_status() {
		return empresa_status;
	}

	public void setEmpresa_status(Boolean empresa_status) {
		this.empresa_status = empresa_status;
	}

	public Boolean getEmpresa_divulgar() {
		return empresa_divulgar;
	}

	public void setEmpresa_divulgar(Boolean empresa_divulgar) {
		this.empresa_divulgar = empresa_divulgar;
	}

	public Boolean getEmpresa_recebe_curriculo() {
		return empresa_recebe_curriculo;
	}

	public void setEmpresa_recebe_curriculo(Boolean empresa_recebe_curriculo) {
		this.empresa_recebe_curriculo = empresa_recebe_curriculo;
	}

	public Boolean getEmpresa_banco_curriculo() {
		return empresa_banco_curriculo;
	}

	public void setEmpresa_banco_curriculo(Boolean empresa_banco_curriculo) {
		this.empresa_banco_curriculo = empresa_banco_curriculo;
	}

	public Boolean getEmpresa_gratuito() {
		return empresa_gratuito;
	}

	public void setEmpresa_gratuito(Boolean empresa_gratuito) {
		this.empresa_gratuito = empresa_gratuito;
	}

	public String getEmpresa_email() {
		return empresa_email;
	}

	public void setEmpresa_email(String empresa_email) {
		this.empresa_email = empresa_email;
	}

	public String getEmpresa_telefone() {
		return empresa_telefone;
	}

	public void setEmpresa_telefone(String empresa_telefone) {
		this.empresa_telefone = empresa_telefone;
	}

	public Date getEmpresa_dt_inclusao() {
		return empresa_dt_inclusao;
	}

	public void setEmpresa_dt_inclusao(Date empresa_dt_inclusao) {
		this.empresa_dt_inclusao = empresa_dt_inclusao;
	}

	public String getEmpresa_site() {
		return empresa_site;
	}

	public void setEmpresa_site(String empresa_site) {
		this.empresa_site = empresa_site;
	}

	public Date getEmpresa_dt_validade_inicio() {
		return empresa_dt_validade_inicio;
	}

	public void setEmpresa_dt_validade_inicio(Date empresa_dt_validade_inicio) {
		this.empresa_dt_validade_inicio = empresa_dt_validade_inicio;
	}

	public Date getEmpresa_dt_validade_fim() {
		return empresa_dt_validade_fim;
	}

	public void setEmpresa_dt_validade_fim(Date empresa_dt_validade_fim) {
		this.empresa_dt_validade_fim = empresa_dt_validade_fim;
	}

	public Integer getEmpresa_quantidade() {
		return empresa_quantidade;
	}

	public void setEmpresa_quantidade(Integer empresa_quantidade) {
		this.empresa_quantidade = empresa_quantidade;
	}

	public Double getEmpresa_valor() {
		return empresa_valor;
	}

	public void setEmpresa_valor(Double empresa_valor) {
		this.empresa_valor = empresa_valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result
				+ ((empresa_alias == null) ? 0 : empresa_alias.hashCode());
		result = prime * result
				+ ((empresa_bairro == null) ? 0 : empresa_bairro.hashCode());
		result = prime
				* result
				+ ((empresa_banco_curriculo == null) ? 0
						: empresa_banco_curriculo.hashCode());
		result = prime * result
				+ ((empresa_cep == null) ? 0 : empresa_cep.hashCode());
		result = prime * result
				+ ((empresa_cnpj == null) ? 0 : empresa_cnpj.hashCode());
		result = prime
				* result
				+ ((empresa_divulgar == null) ? 0 : empresa_divulgar.hashCode());
		result = prime
				* result
				+ ((empresa_dt_inclusao == null) ? 0 : empresa_dt_inclusao
						.hashCode());
		result = prime
				* result
				+ ((empresa_dt_validade_fim == null) ? 0
						: empresa_dt_validade_fim.hashCode());
		result = prime
				* result
				+ ((empresa_dt_validade_inicio == null) ? 0
						: empresa_dt_validade_inicio.hashCode());
		result = prime * result
				+ ((empresa_email == null) ? 0 : empresa_email.hashCode());
		result = prime
				* result
				+ ((empresa_endereco == null) ? 0 : empresa_endereco.hashCode());
		result = prime
				* result
				+ ((empresa_gratuito == null) ? 0 : empresa_gratuito.hashCode());
		result = prime * result
				+ ((empresa_id == null) ? 0 : empresa_id.hashCode());
		result = prime
				* result
				+ ((empresa_quantidade == null) ? 0 : empresa_quantidade
						.hashCode());
		result = prime * result
				+ ((empresa_razao == null) ? 0 : empresa_razao.hashCode());
		result = prime
				* result
				+ ((empresa_recebe_curriculo == null) ? 0
						: empresa_recebe_curriculo.hashCode());
		result = prime * result
				+ ((empresa_site == null) ? 0 : empresa_site.hashCode());
		result = prime * result
				+ ((empresa_status == null) ? 0 : empresa_status.hashCode());
		result = prime
				* result
				+ ((empresa_telefone == null) ? 0 : empresa_telefone.hashCode());
		result = prime * result
				+ ((empresa_valor == null) ? 0 : empresa_valor.hashCode());
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
		Empresa other = (Empresa) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (empresa_alias == null) {
			if (other.empresa_alias != null)
				return false;
		} else if (!empresa_alias.equals(other.empresa_alias))
			return false;
		if (empresa_bairro == null) {
			if (other.empresa_bairro != null)
				return false;
		} else if (!empresa_bairro.equals(other.empresa_bairro))
			return false;
		if (empresa_banco_curriculo == null) {
			if (other.empresa_banco_curriculo != null)
				return false;
		} else if (!empresa_banco_curriculo
				.equals(other.empresa_banco_curriculo))
			return false;
		if (empresa_cep == null) {
			if (other.empresa_cep != null)
				return false;
		} else if (!empresa_cep.equals(other.empresa_cep))
			return false;
		if (empresa_cnpj == null) {
			if (other.empresa_cnpj != null)
				return false;
		} else if (!empresa_cnpj.equals(other.empresa_cnpj))
			return false;
		if (empresa_divulgar == null) {
			if (other.empresa_divulgar != null)
				return false;
		} else if (!empresa_divulgar.equals(other.empresa_divulgar))
			return false;
		if (empresa_dt_inclusao == null) {
			if (other.empresa_dt_inclusao != null)
				return false;
		} else if (!empresa_dt_inclusao.equals(other.empresa_dt_inclusao))
			return false;
		if (empresa_dt_validade_fim == null) {
			if (other.empresa_dt_validade_fim != null)
				return false;
		} else if (!empresa_dt_validade_fim
				.equals(other.empresa_dt_validade_fim))
			return false;
		if (empresa_dt_validade_inicio == null) {
			if (other.empresa_dt_validade_inicio != null)
				return false;
		} else if (!empresa_dt_validade_inicio
				.equals(other.empresa_dt_validade_inicio))
			return false;
		if (empresa_email == null) {
			if (other.empresa_email != null)
				return false;
		} else if (!empresa_email.equals(other.empresa_email))
			return false;
		if (empresa_endereco == null) {
			if (other.empresa_endereco != null)
				return false;
		} else if (!empresa_endereco.equals(other.empresa_endereco))
			return false;
		if (empresa_gratuito == null) {
			if (other.empresa_gratuito != null)
				return false;
		} else if (!empresa_gratuito.equals(other.empresa_gratuito))
			return false;
		if (empresa_id == null) {
			if (other.empresa_id != null)
				return false;
		} else if (!empresa_id.equals(other.empresa_id))
			return false;
		if (empresa_quantidade == null) {
			if (other.empresa_quantidade != null)
				return false;
		} else if (!empresa_quantidade.equals(other.empresa_quantidade))
			return false;
		if (empresa_razao == null) {
			if (other.empresa_razao != null)
				return false;
		} else if (!empresa_razao.equals(other.empresa_razao))
			return false;
		if (empresa_recebe_curriculo == null) {
			if (other.empresa_recebe_curriculo != null)
				return false;
		} else if (!empresa_recebe_curriculo
				.equals(other.empresa_recebe_curriculo))
			return false;
		if (empresa_site == null) {
			if (other.empresa_site != null)
				return false;
		} else if (!empresa_site.equals(other.empresa_site))
			return false;
		if (empresa_status == null) {
			if (other.empresa_status != null)
				return false;
		} else if (!empresa_status.equals(other.empresa_status))
			return false;
		if (empresa_telefone == null) {
			if (other.empresa_telefone != null)
				return false;
		} else if (!empresa_telefone.equals(other.empresa_telefone))
			return false;
		if (empresa_valor == null) {
			if (other.empresa_valor != null)
				return false;
		} else if (!empresa_valor.equals(other.empresa_valor))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}

			
}
