package br.com.jobs.modelo.usuario;

import java.beans.Transient;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.jobs.modelo.empresa.Empresa;
import br.com.jobs.modelo.perfil.Perfil;


@Entity
@Table (name="Usuario")
public class Usuario implements Serializable,UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "usuario_id", insertable = true, updatable = false)
	private Integer usuario_id;
	
	@Column (name="usuario_descricao", length=200)
	private String usuario_descricao;
	
	@Column (name="usuario_login", length=50)
	private String usuario_login;
	
	@Column(name="usuario_senha", length=20)
	private String usuario_senha;
	
	@Column(name="usuario_status")
	private Boolean usuario_status;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "perfil_id"))
	private List<Perfil> perfis = new ArrayList<Perfil>();

	@Column (name = "usuario_email", length=40)
	private String usuario_email;
	
	@Column (name = "usuario_dt_inclusao")
	private Date usuario_dt_inclusao;
	
	@OneToOne  
    @JoinColumn(name="empresa_id")   
	private Empresa empresa;
	
	/*
	 * Gets e Sets classe Usuario.	
	 */
	

	public Integer getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}
	public String getUsuario_descricao() {
		return usuario_descricao;
	}
	public void setUsuario_descricao(String usuario_descricao) {
		this.usuario_descricao = usuario_descricao;
	}
	public String getUsuario_login() {
		return usuario_login;
	}
	public void setUsuario_login(String usuario_login) {
		this.usuario_login = usuario_login;
	}
	public String getUsuario_senha() {
		return usuario_senha;
	}
	public void setUsuario_senha(String usuario_senha) {
		this.usuario_senha = usuario_senha;
	}
	public Boolean getUsuario_status() {
		return usuario_status;
	}
	public void setUsuario_status(Boolean usuario_status) {
		this.usuario_status = usuario_status;
	}
	public List<Perfil> getPerfis() {
		return perfis;
	}
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	public String getUsuario_email() {
		return usuario_email;
	}
	public void setUsuario_email(String usuario_email) {
		this.usuario_email = usuario_email;
	}
	public Date getUsuario_dt_inclusao() {
		return usuario_dt_inclusao;
	}
	public void setUsuario_dt_inclusao(Date usuario_dt_inclusao) {
		this.usuario_dt_inclusao = usuario_dt_inclusao;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	
	@Transient
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> lista = new ArrayList<GrantedAuthority>();
		for(Perfil perfil : getPerfis()) {
			lista.add(new GrantedAuthorityImpl(perfil.getAuthority()));
		}
		return lista;
	}
	
	@Transient
	public String getPassword() {
		return this.usuario_senha;
	}
	@Transient
	public String getUsername() {
		return this.usuario_login;
	}
	@Transient
	public boolean isAccountNonExpired() {
		return this.usuario_status;
	}
	@Transient
	public boolean isAccountNonLocked() {
		return this.usuario_status;
	}
	@Transient
	public boolean isCredentialsNonExpired() {
		return this.usuario_status;
	}
	@Transient
	public boolean isEnabled() {
		return this.usuario_status;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((perfis == null) ? 0 : perfis.hashCode());
		result = prime
				* result
				+ ((usuario_descricao == null) ? 0 : usuario_descricao
						.hashCode());
		result = prime
				* result
				+ ((usuario_dt_inclusao == null) ? 0 : usuario_dt_inclusao
						.hashCode());
		result = prime * result
				+ ((usuario_email == null) ? 0 : usuario_email.hashCode());
		result = prime * result
				+ ((usuario_id == null) ? 0 : usuario_id.hashCode());
		result = prime * result
				+ ((usuario_login == null) ? 0 : usuario_login.hashCode());
		result = prime * result
				+ ((usuario_senha == null) ? 0 : usuario_senha.hashCode());
		result = prime * result
				+ ((usuario_status == null) ? 0 : usuario_status.hashCode());
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
		Usuario other = (Usuario) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (perfis == null) {
			if (other.perfis != null)
				return false;
		} else if (!perfis.equals(other.perfis))
			return false;
		if (usuario_descricao == null) {
			if (other.usuario_descricao != null)
				return false;
		} else if (!usuario_descricao.equals(other.usuario_descricao))
			return false;
		if (usuario_dt_inclusao == null) {
			if (other.usuario_dt_inclusao != null)
				return false;
		} else if (!usuario_dt_inclusao.equals(other.usuario_dt_inclusao))
			return false;
		if (usuario_email == null) {
			if (other.usuario_email != null)
				return false;
		} else if (!usuario_email.equals(other.usuario_email))
			return false;
		if (usuario_id == null) {
			if (other.usuario_id != null)
				return false;
		} else if (!usuario_id.equals(other.usuario_id))
			return false;
		if (usuario_login == null) {
			if (other.usuario_login != null)
				return false;
		} else if (!usuario_login.equals(other.usuario_login))
			return false;
		if (usuario_senha == null) {
			if (other.usuario_senha != null)
				return false;
		} else if (!usuario_senha.equals(other.usuario_senha))
			return false;
		if (usuario_status == null) {
			if (other.usuario_status != null)
				return false;
		} else if (!usuario_status.equals(other.usuario_status))
			return false;
		return true;
	}
		
}
