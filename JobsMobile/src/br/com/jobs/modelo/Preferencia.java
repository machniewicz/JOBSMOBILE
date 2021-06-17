package br.com.jobs.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;


public class Preferencia implements Serializable, KvmSerializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String PREFERENCIA = "preferencia";
	public static final String PREFERENCIA_CODIGO = "preferencia_codigo";
	public static final String PREFERENCIA_NOME = "preferencia_nome";
	public static final String PREFERENCIA_EMAIL = "preferencia_email";
	public static final String PREFERENCIA_CPF = "preferencia_cpf";
	public static final String PREFERENCIA_SENHA = "preferencia_senha";
	public static final String PREFERENCIA_EXPERIENCIA = "preferencia_experiencia";
	public static final String PREFERENCIA_ESTADO = "estado_id";
	public static final String PREFERENCIA_CATEGORIA = "categoria_id";
	public static final String PREFERENCIA_SALARIO = "salario_id";
	public static final String PREFERENCIA_FORMACAO = "formacao_id";
	public static final String PREFERENCIA_DATA = "preferencia_data";
				
	private Integer preferencia_codigo;
	private String preferencia_nome;
	private String preferencia_email;
	private String preferencia_cpf;
	private String preferencia_senha;
	private Integer preferencia_experiencia;
	private Integer preferencia_estado_id;
	private Integer preferencia_categoria_id;
	private Integer preferencia_salario_id;
	private Integer preferencia_formacao_id;
	private Date preferencia_data;

	
	public Integer getPreferencia_codigo() {
		return preferencia_codigo;
	}

	public void setPreferencia_codigo(Integer preferencia_codigo) {
		this.preferencia_codigo = preferencia_codigo;
	}

	public String getPreferencia_nome() {
		return preferencia_nome;
	}

	public void setPreferencia_nome(String preferencia_nome) {
		this.preferencia_nome = preferencia_nome;
	}

	public String getPreferencia_email() {
		return preferencia_email;
	}

	public void setPreferencia_email(String preferencia_email) {
		this.preferencia_email = preferencia_email;
	}

	public String getPreferencia_cpf() {
		return preferencia_cpf;
	}

	public void setPreferencia_cpf(String preferencia_cpf) {
		this.preferencia_cpf = preferencia_cpf;
	}

	public String getPreferencia_senha() {
		return preferencia_senha;
	}

	public void setPreferencia_senha(String preferencia_senha) {
		this.preferencia_senha = preferencia_senha;
	}

	public Integer getPreferencia_experiencia() {
		return preferencia_experiencia;
	}

	public void setPreferencia_experiencia(Integer preferencia_experiencia) {
		this.preferencia_experiencia = preferencia_experiencia;
	}

	public Integer getPreferencia_estado_id() {
		return preferencia_estado_id;
	}

	public void setPreferencia_estado_id(Integer preferencia_estado_id) {
		this.preferencia_estado_id = preferencia_estado_id;
	}

	public Integer getPreferencia_categoria_id() {
		return preferencia_categoria_id;
	}

	public void setPreferencia_categoria_id(Integer preferencia_categoria_id) {
		this.preferencia_categoria_id = preferencia_categoria_id;
	}

	public Integer getPreferencia_salario_id() {
		return preferencia_salario_id;
	}

	public void setPreferencia_salario_id(Integer preferencia_salario_id) {
		this.preferencia_salario_id = preferencia_salario_id;
	}

	public Integer getPreferencia_formacao_id() {
		return preferencia_formacao_id;
	}

	public void setPreferencia_formacao_id(Integer preferencia_formacao_id) {
		this.preferencia_formacao_id = preferencia_formacao_id;
	}

	public Date getPreferencia_data() {
		return preferencia_data;
	}

	public void setPreferencia_data(Date preferencia_data) {
		this.preferencia_data = preferencia_data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((preferencia_categoria_id == null) ? 0
						: preferencia_categoria_id.hashCode());
		result = prime
				* result
				+ ((preferencia_codigo == null) ? 0 : preferencia_codigo
						.hashCode());
		result = prime * result
				+ ((preferencia_cpf == null) ? 0 : preferencia_cpf.hashCode());
		result = prime
				* result
				+ ((preferencia_data == null) ? 0 : preferencia_data.hashCode());
		result = prime
				* result
				+ ((preferencia_email == null) ? 0 : preferencia_email
						.hashCode());
		result = prime
				* result
				+ ((preferencia_estado_id == null) ? 0 : preferencia_estado_id
						.hashCode());
		result = prime
				* result
				+ ((preferencia_experiencia == null) ? 0
						: preferencia_experiencia.hashCode());
		result = prime
				* result
				+ ((preferencia_formacao_id == null) ? 0
						: preferencia_formacao_id.hashCode());
		result = prime
				* result
				+ ((preferencia_nome == null) ? 0 : preferencia_nome.hashCode());
		result = prime
				* result
				+ ((preferencia_salario_id == null) ? 0
						: preferencia_salario_id.hashCode());
		result = prime
				* result
				+ ((preferencia_senha == null) ? 0 : preferencia_senha
						.hashCode());
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
		Preferencia other = (Preferencia) obj;
		if (preferencia_categoria_id == null) {
			if (other.preferencia_categoria_id != null)
				return false;
		} else if (!preferencia_categoria_id
				.equals(other.preferencia_categoria_id))
			return false;
		if (preferencia_codigo == null) {
			if (other.preferencia_codigo != null)
				return false;
		} else if (!preferencia_codigo.equals(other.preferencia_codigo))
			return false;
		if (preferencia_cpf == null) {
			if (other.preferencia_cpf != null)
				return false;
		} else if (!preferencia_cpf.equals(other.preferencia_cpf))
			return false;
		if (preferencia_data == null) {
			if (other.preferencia_data != null)
				return false;
		} else if (!preferencia_data.equals(other.preferencia_data))
			return false;
		if (preferencia_email == null) {
			if (other.preferencia_email != null)
				return false;
		} else if (!preferencia_email.equals(other.preferencia_email))
			return false;
		if (preferencia_estado_id == null) {
			if (other.preferencia_estado_id != null)
				return false;
		} else if (!preferencia_estado_id.equals(other.preferencia_estado_id))
			return false;
		if (preferencia_experiencia == null) {
			if (other.preferencia_experiencia != null)
				return false;
		} else if (!preferencia_experiencia
				.equals(other.preferencia_experiencia))
			return false;
		if (preferencia_formacao_id == null) {
			if (other.preferencia_formacao_id != null)
				return false;
		} else if (!preferencia_formacao_id
				.equals(other.preferencia_formacao_id))
			return false;
		if (preferencia_nome == null) {
			if (other.preferencia_nome != null)
				return false;
		} else if (!preferencia_nome.equals(other.preferencia_nome))
			return false;
		if (preferencia_salario_id == null) {
			if (other.preferencia_salario_id != null)
				return false;
		} else if (!preferencia_salario_id.equals(other.preferencia_salario_id))
			return false;
		if (preferencia_senha == null) {
			if (other.preferencia_senha != null)
				return false;
		} else if (!preferencia_senha.equals(other.preferencia_senha))
			return false;
		return true;
	}

	@Override
	public Object getProperty(int index) {

		switch(index){
		case 0:
			return preferencia_codigo;
		case 1:
			return preferencia_nome;
		case 2:
			return preferencia_email;
		case 3:
			return preferencia_cpf;
		case 4:
			return preferencia_senha;
		case 5:
			return preferencia_experiencia;
		case 6:
			return preferencia_estado_id;
		case 7:
			return preferencia_categoria_id;
		case 8:
			return preferencia_salario_id;
		case 9:
			return preferencia_formacao_id;
		}
		return null;
	
	}

	@Override
	public int getPropertyCount() {
		return 10;
	}

	
	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
		case 0:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "preferencia_codigo";
			break;
		case 1:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "preferencia_nome";
			break;
		case 2:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "preferencia_email";
			break;
		case 3:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "preferencia_cpf";
			break;
		case 4:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "preferencia_senha";
			break;
		case 5:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "preferencia_experiencia";
			break;
		case 6:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "preferencia_estado_id";
			break;
		case 7:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "preferencia_categoria_id";
			break;
		case 8:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "preferencia_salario_id";
			break;
		case 9:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "preferencia_formacao_id";
			break;
		default:
			break;
		}
	}

	@Override
	public void setProperty(int index, Object value) {
		switch (index) {
		case 0:
			preferencia_codigo = Integer.parseInt(value.toString());
			break;
		case 1:
			preferencia_nome = value.toString();
			break;
		case 2:
			preferencia_email = value.toString();
			break;
		case 3:
			preferencia_cpf = value.toString();
			break;
		case 4:
			preferencia_senha = value.toString();
			break;
		case 5:
			preferencia_experiencia = Integer.parseInt(value.toString());
			break;
		case 6:
			preferencia_estado_id = Integer.parseInt(value.toString());
			break;
		case 7:
			preferencia_categoria_id = Integer.parseInt(value.toString());
			break;
		case 8:
			preferencia_salario_id = Integer.parseInt(value.toString());
			break;
		case 9:
			preferencia_formacao_id = Integer.parseInt(value.toString());
			break;
		default:
			break;
		}

	}
			
}
