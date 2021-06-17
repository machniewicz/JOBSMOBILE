package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.nivel.Nivel;

@FacesConverter(value = "toNivelConverter", forClass = Nivel.class)
public class NivelConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Nivel) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Nivel) {
	        	Nivel entity= (Nivel) value;
	            if (entity != null && entity instanceof Nivel && entity.getNivel_id() != null) {
	                uiComponent.getAttributes().put( entity.getNivel_id().toString(), entity);
	                return entity.getNivel_id().toString();
	            }
	        }
	        return "";
	    }

}
