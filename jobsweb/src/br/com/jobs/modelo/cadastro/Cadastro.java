package br.com.jobs.modelo.cadastro;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.jobs.combinacao.idioma.Combinacao_Idioma;
import br.com.jobs.combinacao.software.Combinacao_Software;
import br.com.jobs.modelo.categoria.Categoria;
import br.com.jobs.modelo.cidade.Cidade;
import br.com.jobs.modelo.curso.Curso;
import br.com.jobs.modelo.escolaridade.Escolaridade;
import br.com.jobs.modelo.estado.Estado;
import br.com.jobs.modelo.experiencia.Experiencia;
import br.com.jobs.modelo.formacao.Formacao;
import br.com.jobs.modelo.perfil.Perfil;
import br.com.jobs.modelo.salario.Salario;

@Entity
@Table (name="Cadastro")
public class Cadastro implements Serializable, UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE) 
	@Column (name="cadastro_id", insertable = true, updatable = false)
	private Integer cadastro_id;
	
	@Column (name="cadastro_status")
	private Boolean cadastro_status;
	
	@Column (name="cadastro_nome", length=100)
	private String cadastro_nome;
	
	@Column (name="cadastro_email", length=80)
	private String cadastro_email;
	
	@Column (name="cadastro_cpf", length=15)
	private String cadastro_cpf;
	
	@Column (name="cadastro_senha", length=15)
	private String cadastro_senha;
	
	@Column (name="cadastro_experiencia")
	private Integer cadastro_experiencia;
	
	@Column (name="cadastro_endereco_cep", length=20)
	private String cadastro_endereco_cep;
	
	@Column (name="cadastro_endereco_rua", length=200)
	private String cadastro_endereco_rua;
	
	@Column (name="cadastro_endereco_numero", length=10)
	private String cadastro_endereco_numero;
	
	@Column (name="cadastro_endereco_bairro", length=50)
	private String cadastro_endereco_bairro;
	
	@Column (name="cadastro_endereco_complemento", length=500)
	private String cadastro_endereco_complemento;
	
	@Column (name="cadastro_data")
	private Date cadastro_data;

	@Column (name="cadastro_complemento_dt_nascimento")
	private Date cadastro_complemento_dt_nascimento;
	
	@Column (name="cadastro_complemento_telefone", length=20)
	private String cadastro_complemento_telefone;
	
	@Column (name="cadastro_complemento_celular", length=20)
	private String cadastro_complemento_celular;
	
	@Column (name="cadastro_complemento_sexo")
	private Integer cadastro_complemento_sexo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "cadastro_perfil", joinColumns = @JoinColumn(name = "cadastro_id"), inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private List<Perfil> perfis = new ArrayList<Perfil>();
	
	@OneToMany(targetEntity = Combinacao_Idioma.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Combinacao_Idioma> combinacoes_idiomas = new ArrayList<Combinacao_Idioma>();
	
	@OneToMany(targetEntity = Combinacao_Software.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Combinacao_Software> combinacoes_softwares = new ArrayList<Combinacao_Software>();
	
	@OneToMany(targetEntity = Escolaridade.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Escolaridade> escolaridades = new ArrayList<Escolaridade>();
	
	@OneToMany(targetEntity = Curso.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Curso> cursos = new ArrayList<Curso>();
	
	@OneToMany(targetEntity = Experiencia.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Experiencia> experiencias = new ArrayList<Experiencia>();

	@OneToOne  
    @JoinColumn(name="estado_id")   
	private Estado estado;
	
	@OneToOne  
    @JoinColumn(name="categoria_id")   
	private Categoria categoria;
	
	@OneToOne  
    @JoinColumn(name="salario_id")
	private Salario salario;
	
	@OneToOne  
    @JoinColumn(name="formacao_id")
	private Formacao formacao;
	
	@OneToOne  
    @JoinColumn(name="cidade_id")
	private Cidade cidade;
		
	/*
	 * Gets e Sets da Classe Cadastro	
	 */
	public Integer getCadastro_id() {
		return cadastro_id;
	}
	public void setCadastro_id(Integer cadastro_id) {
		this.cadastro_id = cadastro_id;
	}
	public Boolean getCadastro_status() {
		return cadastro_status;
	}
	public void setCadastro_status(Boolean cadastro_status) {
		this.cadastro_status = cadastro_status;
	}
	public String getCadastro_nome() {
		return cadastro_nome;
	}
	public void setCadastro_nome(String cadastro_nome) {
		this.cadastro_nome = cadastro_nome;
	}
	public String getCadastro_email() {
		return cadastro_email;
	}
	public void setCadastro_email(String cadastro_email) {
		this.cadastro_email = cadastro_email;
	}
	public String getCadastro_cpf() {
		return cadastro_cpf;
	}
	public void setCadastro_cpf(String cadastro_cpf) {
		this.cadastro_cpf = cadastro_cpf;
	}
	public String getCadastro_senha() {
		return cadastro_senha;
	}
	public void setCadastro_senha(String cadastro_senha) {
		this.cadastro_senha = cadastro_senha;
	}
	public Integer getCadastro_experiencia() {
		return cadastro_experiencia;
	}
	public void setCadastro_experiencia(Integer cadastro_experiencia) {
		this.cadastro_experiencia = cadastro_experiencia;
	}
	public String getCadastro_endereco_cep() {
		return cadastro_endereco_cep;
	}
	public void setCadastro_endereco_cep(String cadastro_endereco_cep) {
		this.cadastro_endereco_cep = cadastro_endereco_cep;
	}
	public String getCadastro_endereco_rua() {
		return cadastro_endereco_rua;
	}
	public void setCadastro_endereco_rua(String cadastro_endereco_rua) {
		this.cadastro_endereco_rua = cadastro_endereco_rua;
	}
	public String getCadastro_endereco_numero() {
		return cadastro_endereco_numero;
	}
	public void setCadastro_endereco_numero(String cadastro_endereco_numero) {
		this.cadastro_endereco_numero = cadastro_endereco_numero;
	}
	public String getCadastro_endereco_bairro() {
		return cadastro_endereco_bairro;
	}
	public void setCadastro_endereco_bairro(String cadastro_endereco_bairro) {
		this.cadastro_endereco_bairro = cadastro_endereco_bairro;
	}
	public String getCadastro_endereco_complemento() {
		return cadastro_endereco_complemento;
	}
	public void setCadastro_endereco_complemento(
			String cadastro_endereco_complemento) {
		this.cadastro_endereco_complemento = cadastro_endereco_complemento;
	}
	public Date getCadastro_data() {
		return cadastro_data;
	}
	public void setCadastro_data(Date cadastro_data) {
		this.cadastro_data = cadastro_data;
	}
	public Date getCadastro_complemento_dt_nascimento() {
		return cadastro_complemento_dt_nascimento;
	}
	public void setCadastro_complemento_dt_nascimento(
			Date cadastro_complemento_dt_nascimento) {
		this.cadastro_complemento_dt_nascimento = cadastro_complemento_dt_nascimento;
	}
	public String getCadastro_complemento_telefone() {
		return cadastro_complemento_telefone;
	}
	public void setCadastro_complemento_telefone(
			String cadastro_complemento_telefone) {
		this.cadastro_complemento_telefone = cadastro_complemento_telefone;
	}
	public String getCadastro_complemento_celular() {
		return cadastro_complemento_celular;
	}
	public void setCadastro_complemento_celular(String cadastro_complemento_celular) {
		this.cadastro_complemento_celular = cadastro_complemento_celular;
	}
	public Integer getCadastro_complemento_sexo() {
		return cadastro_complemento_sexo;
	}
	public void setCadastro_complemento_sexo(Integer cadastro_complemento_sexo) {
		this.cadastro_complemento_sexo = cadastro_complemento_sexo;
	}
	public List<Perfil> getPerfis() {
		return perfis;
	}
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	public List<Escolaridade> getEscolaridades() {
		return escolaridades;
	}
	public void setEscolaridades(List<Escolaridade> escolaridades) {
		this.escolaridades = escolaridades;
	}
	public List<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	public List<Experiencia> getExperiencias() {
		return experiencias;
	}
	public void setExperiencias(List<Experiencia> experiencias) {
		this.experiencias = experiencias;
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Salario getSalario() {
		return salario;
	}
	public void setSalario(Salario salario) {
		this.salario = salario;
	}
	public Formacao getFormacao() {
		return formacao;
	}
	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	/*
	 * 	(non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetails#getPassword()
	 */
	@Transient
	public String getPassword() {
		return this.cadastro_senha;
	}
	@Transient
	public String getUsername() {
		return this.cadastro_cpf;
	}
	@Transient
	public boolean isAccountNonExpired() {
		return this.cadastro_status;
	}
	@Transient
	public boolean isAccountNonLocked() {
		return this.cadastro_status;
	}
	@Transient
	public boolean isCredentialsNonExpired() {
		return this.cadastro_status;
	}
	@Transient
	public boolean isEnabled() {
		return this.cadastro_status;
	}

	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> lista = new ArrayList<GrantedAuthority>();
		for(Perfil perfil : getPerfis()) {
			lista.add(new GrantedAuthorityImpl(perfil.getAuthority()));
		}
		return lista;
	}

	
	/*
	 * HashCode e Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((cadastro_complemento_celular == null) ? 0
						: cadastro_complemento_celular.hashCode());
		result = prime
				* result
				+ ((cadastro_complemento_dt_nascimento == null) ? 0
						: cadastro_complemento_dt_nascimento.hashCode());
		result = prime
				* result
				+ ((cadastro_complemento_sexo == null) ? 0
						: cadastro_complemento_sexo.hashCode());
		result = prime
				* result
				+ ((cadastro_complemento_telefone == null) ? 0
						: cadastro_complemento_telefone.hashCode());
		result = prime * result
				+ ((cadastro_cpf == null) ? 0 : cadastro_cpf.hashCode());
		result = prime * result
				+ ((cadastro_data == null) ? 0 : cadastro_data.hashCode());
		result = prime * result
				+ ((cadastro_email == null) ? 0 : cadastro_email.hashCode());
		result = prime
				* result
				+ ((cadastro_endereco_bairro == null) ? 0
						: cadastro_endereco_bairro.hashCode());
		result = prime
				* result
				+ ((cadastro_endereco_cep == null) ? 0 : cadastro_endereco_cep
						.hashCode());
		result = prime
				* result
				+ ((cadastro_endereco_complemento == null) ? 0
						: cadastro_endereco_complemento.hashCode());
		result = prime
				* result
				+ ((cadastro_endereco_numero == null) ? 0
						: cadastro_endereco_numero.hashCode());
		result = prime
				* result
				+ ((cadastro_endereco_rua == null) ? 0 : cadastro_endereco_rua
						.hashCode());
		result = prime
				* result
				+ ((cadastro_experiencia == null) ? 0 : cadastro_experiencia
						.hashCode());
		result = prime * result
				+ ((cadastro_id == null) ? 0 : cadastro_id.hashCode());
		result = prime * result
				+ ((cadastro_nome == null) ? 0 : cadastro_nome.hashCode());
		result = prime * result
				+ ((cadastro_senha == null) ? 0 : cadastro_senha.hashCode());
		result = prime * result
				+ ((cadastro_status == null) ? 0 : cadastro_status.hashCode());
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
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		result = prime * result
				+ ((escolaridades == null) ? 0 : escolaridades.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((experiencias == null) ? 0 : experiencias.hashCode());
		result = prime * result
				+ ((formacao == null) ? 0 : formacao.hashCode());
		result = prime * result + ((perfis == null) ? 0 : perfis.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
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
		Cadastro other = (Cadastro) obj;
		if (cadastro_complemento_celular == null) {
			if (other.cadastro_complemento_celular != null)
				return false;
		} else if (!cadastro_complemento_celular
				.equals(other.cadastro_complemento_celular))
			return false;
		if (cadastro_complemento_dt_nascimento == null) {
			if (other.cadastro_complemento_dt_nascimento != null)
				return false;
		} else if (!cadastro_complemento_dt_nascimento
				.equals(other.cadastro_complemento_dt_nascimento))
			return false;
		if (cadastro_complemento_sexo == null) {
			if (other.cadastro_complemento_sexo != null)
				return false;
		} else if (!cadastro_complemento_sexo
				.equals(other.cadastro_complemento_sexo))
			return false;
		if (cadastro_complemento_telefone == null) {
			if (other.cadastro_complemento_telefone != null)
				return false;
		} else if (!cadastro_complemento_telefone
				.equals(other.cadastro_complemento_telefone))
			return false;
		if (cadastro_cpf == null) {
			if (other.cadastro_cpf != null)
				return false;
		} else if (!cadastro_cpf.equals(other.cadastro_cpf))
			return false;
		if (cadastro_data == null) {
			if (other.cadastro_data != null)
				return false;
		} else if (!cadastro_data.equals(other.cadastro_data))
			return false;
		if (cadastro_email == null) {
			if (other.cadastro_email != null)
				return false;
		} else if (!cadastro_email.equals(other.cadastro_email))
			return false;
		if (cadastro_endereco_bairro == null) {
			if (other.cadastro_endereco_bairro != null)
				return false;
		} else if (!cadastro_endereco_bairro
				.equals(other.cadastro_endereco_bairro))
			return false;
		if (cadastro_endereco_cep == null) {
			if (other.cadastro_endereco_cep != null)
				return false;
		} else if (!cadastro_endereco_cep.equals(other.cadastro_endereco_cep))
			return false;
		if (cadastro_endereco_complemento == null) {
			if (other.cadastro_endereco_complemento != null)
				return false;
		} else if (!cadastro_endereco_complemento
				.equals(other.cadastro_endereco_complemento))
			return false;
		if (cadastro_endereco_numero == null) {
			if (other.cadastro_endereco_numero != null)
				return false;
		} else if (!cadastro_endereco_numero
				.equals(other.cadastro_endereco_numero))
			return false;
		if (cadastro_endereco_rua == null) {
			if (other.cadastro_endereco_rua != null)
				return false;
		} else if (!cadastro_endereco_rua.equals(other.cadastro_endereco_rua))
			return false;
		if (cadastro_experiencia == null) {
			if (other.cadastro_experiencia != null)
				return false;
		} else if (!cadastro_experiencia.equals(other.cadastro_experiencia))
			return false;
		if (cadastro_id == null) {
			if (other.cadastro_id != null)
				return false;
		} else if (!cadastro_id.equals(other.cadastro_id))
			return false;
		if (cadastro_nome == null) {
			if (other.cadastro_nome != null)
				return false;
		} else if (!cadastro_nome.equals(other.cadastro_nome))
			return false;
		if (cadastro_senha == null) {
			if (other.cadastro_senha != null)
				return false;
		} else if (!cadastro_senha.equals(other.cadastro_senha))
			return false;
		if (cadastro_status == null) {
			if (other.cadastro_status != null)
				return false;
		} else if (!cadastro_status.equals(other.cadastro_status))
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
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
			return false;
		if (escolaridades == null) {
			if (other.escolaridades != null)
				return false;
		} else if (!escolaridades.equals(other.escolaridades))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (experiencias == null) {
			if (other.experiencias != null)
				return false;
		} else if (!experiencias.equals(other.experiencias))
			return false;
		if (formacao == null) {
			if (other.formacao != null)
				return false;
		} else if (!formacao.equals(other.formacao))
			return false;
		if (perfis == null) {
			if (other.perfis != null)
				return false;
		} else if (!perfis.equals(other.perfis))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}
	
		
}
