package br.com.jobs.modelo.perfil;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

import br.com.jobs.modelo.usuario.Usuario;

@Entity
@Table (name="Perfil")
public class Perfil implements Serializable, GrantedAuthority{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column (name="perfil_id")
	private Integer perfil_id;
	
	@Column (name="perfil_descricao", length=20)
	private String perfil_descricao;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "usuario_perfil", joinColumns = @JoinColumn(name = "perfil_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	/*
	 * Gets e Sets da classe Perfil
	 */
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Integer getPerfil_id() {
		return perfil_id;
	}
	public void setPerfil_id(Integer perfil_id) {
		this.perfil_id = perfil_id;
	}
	public String getPerfil_descricao() {
		return perfil_descricao;
	}
	public void setPerfil_descricao(String perfil_descricao) {
		this.perfil_descricao = perfil_descricao;
	}
	
	@Transient
	public String getAuthority() {
		return this.perfil_descricao;
	}

	@Transient
	public int compareTo(Object o) {
		return this.compareTo(o);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((perfil_descricao == null) ? 0 : perfil_descricao.hashCode());
		result = prime * result
				+ ((perfil_id == null) ? 0 : perfil_id.hashCode());
		result = prime * result
				+ ((usuarios == null) ? 0 : usuarios.hashCode());
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
		Perfil other = (Perfil) obj;
		if (perfil_descricao == null) {
			if (other.perfil_descricao != null)
				return false;
		} else if (!perfil_descricao.equals(other.perfil_descricao))
			return false;
		if (perfil_id == null) {
			if (other.perfil_id != null)
				return false;
		} else if (!perfil_id.equals(other.perfil_id))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		return true;
	}
	
}
