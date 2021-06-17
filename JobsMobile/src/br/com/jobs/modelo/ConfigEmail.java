package br.com.jobs.modelo;

import java.io.Serializable;


public class ConfigEmail implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer email_id;
	
	private String email_email;
	
	private String email_senha;
	
	private String email_smtp;
	
	private String email_porta;
	
	private String email_auth;
	
	private String email_tls;

	public Integer getEmail_id() {
		return email_id;
	}

	public void setEmail_id(Integer email_id) {
		this.email_id = email_id;
	}

	public String getEmail_email() {
		return email_email;
	}

	public void setEmail_email(String email_email) {
		this.email_email = email_email;
	}

	public String getEmail_senha() {
		return email_senha;
	}

	public void setEmail_senha(String email_senha) {
		this.email_senha = email_senha;
	}

	public String getEmail_smtp() {
		return email_smtp;
	}

	public void setEmail_smtp(String email_smtp) {
		this.email_smtp = email_smtp;
	}

	public String getEmail_porta() {
		return email_porta;
	}

	public void setEmail_porta(String email_porta) {
		this.email_porta = email_porta;
	}

	public String getEmail_auth() {
		return email_auth;
	}

	public void setEmail_auth(String email_auth) {
		this.email_auth = email_auth;
	}

	public String getEmail_tls() {
		return email_tls;
	}

	public void setEmail_tls(String email_tls) {
		this.email_tls = email_tls;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((email_auth == null) ? 0 : email_auth.hashCode());
		result = prime * result
				+ ((email_email == null) ? 0 : email_email.hashCode());
		result = prime * result
				+ ((email_id == null) ? 0 : email_id.hashCode());
		result = prime * result
				+ ((email_porta == null) ? 0 : email_porta.hashCode());
		result = prime * result
				+ ((email_senha == null) ? 0 : email_senha.hashCode());
		result = prime * result
				+ ((email_smtp == null) ? 0 : email_smtp.hashCode());
		result = prime * result
				+ ((email_tls == null) ? 0 : email_tls.hashCode());
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
		ConfigEmail other = (ConfigEmail) obj;
		if (email_auth == null) {
			if (other.email_auth != null)
				return false;
		} else if (!email_auth.equals(other.email_auth))
			return false;
		if (email_email == null) {
			if (other.email_email != null)
				return false;
		} else if (!email_email.equals(other.email_email))
			return false;
		if (email_id == null) {
			if (other.email_id != null)
				return false;
		} else if (!email_id.equals(other.email_id))
			return false;
		if (email_porta == null) {
			if (other.email_porta != null)
				return false;
		} else if (!email_porta.equals(other.email_porta))
			return false;
		if (email_senha == null) {
			if (other.email_senha != null)
				return false;
		} else if (!email_senha.equals(other.email_senha))
			return false;
		if (email_smtp == null) {
			if (other.email_smtp != null)
				return false;
		} else if (!email_smtp.equals(other.email_smtp))
			return false;
		if (email_tls == null) {
			if (other.email_tls != null)
				return false;
		} else if (!email_tls.equals(other.email_tls))
			return false;
		return true;
	}
		
}
