package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.empresa.Empresa;

@FacesConverter(value = "toEmpresaConverter", forClass = Empresa.class)
public class EmpresaConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Empresa) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Empresa) {
	            Empresa entity= (Empresa) value;
	            if (entity != null && entity instanceof Empresa && entity.getEmpresa_id() != null) {
	                uiComponent.getAttributes().put( entity.getEmpresa_id().toString(), entity);
	                return entity.getEmpresa_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
