package br.com.jobs.modelo.oportunidade;

import java.io.Serializable;
import java.sql.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import br.com.jobs.combinacao.idioma.Combinacao_Idioma;
import br.com.jobs.combinacao.software.Combinacao_Software;
import br.com.jobs.modelo.beneficio.Beneficio;
import br.com.jobs.modelo.categoria.Categoria;
import br.com.jobs.modelo.cidade.Cidade;
import br.com.jobs.modelo.empresa.Empresa;
import br.com.jobs.modelo.estado.Estado;
import br.com.jobs.modelo.formacao.Formacao;
import br.com.jobs.modelo.funcao.Funcao;
import br.com.jobs.modelo.salario.Salario;
import br.com.jobs.modelo.usuario.Usuario;
import br.com.jobs.modelo.vaga.Vaga;

@Entity
@Table (name="Oportunidade")
public class Oportunidade implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="oportunidade_id", insertable = true, updatable = false)
	private Integer oportunidade_id;
	
	@Column (name="oportunidade_status")
	private Boolean oportunidade_status;
	
	@OneToOne  
    @JoinColumn(name="categoria_id")   
	private Categoria categoria;
	
	@OneToOne
	@JoinColumn (name="usuario_id")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn (name="empresa_id")
	private Empresa empresa;
	
	@OneToOne
	@JoinColumn (name="estado_id")
	private Estado estado;
	
	@OneToOne
	@JoinColumn (name="cidade_id")
	private Cidade cidade;
	
	@OneToOne
	@JoinColumn (name="formacao_id")
	private Formacao formacao;
	
	@OneToOne
	@JoinColumn (name="salario_id")
	private Salario salario;
	
	@OneToOne
	@JoinColumn (name="vaga_id")
	private Vaga vaga;
	
	@OneToOne  
    @JoinColumn(name="funcao_id")   
	private Funcao funcao;
	
	@OneToMany(targetEntity = Combinacao_Idioma.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Combinacao_Idioma> combinacoes_idiomas = new ArrayList<Combinacao_Idioma>();
	
	@OneToMany(targetEntity = Combinacao_Software.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Combinacao_Software> combinacoes_softwares = new ArrayList<Combinacao_Software>();
	
	@ManyToMany(targetEntity = Beneficio.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "oportunidade_beneficio", joinColumns = @JoinColumn(name = "oportunidade_id"), inverseJoinColumns = @JoinColumn(name = "beneficio_id", unique=false))
	private List<Beneficio> beneficios = new ArrayList<Beneficio>();
	
	@Column (name="oportunidade_descricao", length=1600)
	private String oportunidade_descricao;
	
	@Column (name="oportunidade_contato", length=60)
	private String oportunidade_contato;
	
	@Column (name="oportunidade_fone", length=25)
	private String oportunidade_fone;
	
	@Column (name="oportunidade_data")
	private Date oportunidade_data;
	
	public Integer getOportunidade_id() {
		return oportunidade_id;
	}

	public void setOportunidade_id(Integer oportunidade_id) {
		this.oportunidade_id = oportunidade_id;
	}

	public Boolean getOportunidade_status() {
		return oportunidade_status;
	}

	public void setOportunidade_status(Boolean oportunidade_status) {
		this.oportunidade_status = oportunidade_status;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	public Salario getSalario() {
		return salario;
	}

	public void setSalario(Salario salario) {
		this.salario = salario;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}

	public List<Combinacao_Idioma> getCombinacoes_idiomas() {
		return combinacoes_idiomas;
	}

	public void setCombinacoes_idiomas(List<Combinacao_Idioma> combinacoes_idiomas) {
		this.combinacoes_idiomas = combinacoes_idiomas;
	}
	
	public List<Combinacao_Software> getCombinacoes_softwares() {
		return combinacoes_softwares;
	}

	public void setCombinacoes_softwares(
			List<Combinacao_Software> combinacoes_softwares) {
		this.combinacoes_softwares = combinacoes_softwares;
	}

	public List<Beneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public String getOportunidade_descricao() {
		return oportunidade_descricao;
	}

	public void setOportunidade_descricao(String oportunidade_descricao) {
		this.oportunidade_descricao = oportunidade_descricao;
	}

	public String getOportunidade_contato() {
		return oportunidade_contato;
	}

	public void setOportunidade_contato(String oportunidade_contato) {
		this.oportunidade_contato = oportunidade_contato;
	}

	public String getOportunidade_fone() {
		return oportunidade_fone;
	}

	public void setOportunidade_fone(String oportunidade_fone) {
		this.oportunidade_fone = oportunidade_fone;
	}

	public Date getOportunidade_data() {
		return oportunidade_data;
	}

	public void setOportunidade_data(Date oportunidade_data) {
		this.oportunidade_data = oportunidade_data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((beneficios == null) ? 0 : beneficios.hashCode());
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime
				* result
				+ ((combinacoes_idiomas == null) ? 0 : combinacoes_idiomas
						.hashCode());
		result = prime
				* result
				+ ((combinacoes_softwares == null) ? 0 : combinacoes_softwares
						.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((formacao == null) ? 0 : formacao.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime
				* result
				+ ((oportunidade_contato == null) ? 0 : oportunidade_contato
						.hashCode());
		result = prime
				* result
				+ ((oportunidade_data == null) ? 0 : oportunidade_data
						.hashCode());
		result = prime
				* result
				+ ((oportunidade_descricao == null) ? 0
						: oportunidade_descricao.hashCode());
		result = prime
				* result
				+ ((oportunidade_fone == null) ? 0 : oportunidade_fone
						.hashCode());
		result = prime * result
				+ ((oportunidade_id == null) ? 0 : oportunidade_id.hashCode());
		result = prime
				* result
				+ ((oportunidade_status == null) ? 0 : oportunidade_status
						.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((vaga == null) ? 0 : vaga.hashCode());
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
		Oportunidade other = (Oportunidade) obj;
		if (beneficios == null) {
			if (other.beneficios != null)
				return false;
		} else if (!beneficios.equals(other.beneficios))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (combinacoes_idiomas == null) {
			if (other.combinacoes_idiomas != null)
				return false;
		} else if (!combinacoes_idiomas.equals(other.combinacoes_idiomas))
			return false;
		if (combinacoes_softwares == null) {
			if (other.combinacoes_softwares != null)
				return false;
		} else if (!combinacoes_softwares.equals(other.combinacoes_softwares))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (formacao == null) {
			if (other.formacao != null)
				return false;
		} else if (!formacao.equals(other.formacao))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (oportunidade_contato == null) {
			if (other.oportunidade_contato != null)
				return false;
		} else if (!oportunidade_contato.equals(other.oportunidade_contato))
			return false;
		if (oportunidade_data == null) {
			if (other.oportunidade_data != null)
				return false;
		} else if (!oportunidade_data.equals(other.oportunidade_data))
			return false;
		if (oportunidade_descricao == null) {
			if (other.oportunidade_descricao != null)
				return false;
		} else if (!oportunidade_descricao.equals(other.oportunidade_descricao))
			return false;
		if (oportunidade_fone == null) {
			if (other.oportunidade_fone != null)
				return false;
		} else if (!oportunidade_fone.equals(other.oportunidade_fone))
			return false;
		if (oportunidade_id == null) {
			if (other.oportunidade_id != null)
				return false;
		} else if (!oportunidade_id.equals(other.oportunidade_id))
			return false;
		if (oportunidade_status == null) {
			if (other.oportunidade_status != null)
				return false;
		} else if (!oportunidade_status.equals(other.oportunidade_status))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (vaga == null) {
			if (other.vaga != null)
				return false;
		} else if (!vaga.equals(other.vaga))
			return false;
		return true;
	}

}
