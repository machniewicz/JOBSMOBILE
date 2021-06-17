package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.salario.Salario;

@FacesConverter(value = "toSalarioConverter", forClass = Salario.class)
public class SalarioConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Salario) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Salario) {
	        	Salario entity= (Salario) value;
	            if (entity != null && entity instanceof Salario && entity.getSalario_id() != null) {
	                uiComponent.getAttributes().put( entity.getSalario_id().toString(), entity);
	                return entity.getSalario_id().toString();
	            }
	        }
	        return "";
	    }

}
