package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.perfil.Perfil;

@FacesConverter(value = "toPerfilConverter", forClass = Perfil.class)
public class PerfilConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Perfil) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Perfil) {
	            Perfil entity= (Perfil) value;
	            if (entity != null && entity instanceof Perfil && entity.getPerfil_id() != null) {
	                uiComponent.getAttributes().put( entity.getPerfil_id().toString(), entity);
	                return entity.getPerfil_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
