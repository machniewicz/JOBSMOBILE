package br.com.jobs.modelo;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;


public class Enviado implements KvmSerializable{

	private Integer enviado_id;
	private String enviado_nome;
	private String enviado_email;
	private Integer enviado_oportunidade_id;
	
			
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
	
	public Integer getEnviado_oportunidade_id() {
		return enviado_oportunidade_id;
	}
	
	public void setEnviado_oportunidade_id(Integer enviado_oportunidade_id) {
		this.enviado_oportunidade_id = enviado_oportunidade_id;
	}
	
	@Override
	public Object getProperty(int arg0) {
		switch(arg0){
		case 0:
			return enviado_id;
		case 1:
			return enviado_nome;
		case 2:
			return enviado_email;
		case 3:
			return enviado_oportunidade_id;
		}
		
		return null;
	}

	@Override
	public int getPropertyCount() {
		return 4;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
		switch (index) {
		case 0:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "enviado_id";
			break;
		case 1:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "enviado_nome";
			break;
		case 2:
			info.type = PropertyInfo.STRING_CLASS;
			info.name = "enviado_email";
			break;
		case 3:
			info.type = PropertyInfo.INTEGER_CLASS;
			info.name = "enviado_oportunidade_id";
			break;
		default:
			break;
		}
	}

	@Override
	public void setProperty(int index, Object value) {
		switch (index) {
		case 0:
			enviado_id = Integer.parseInt(value.toString());
			break;
		case 1:
			enviado_nome = value.toString();
			break;
		case 2:
			enviado_email = value.toString();
			break;
		case 3:
			enviado_oportunidade_id = Integer.parseInt(value.toString());
			break;
		default:
			break;
		}
		
	}

}
