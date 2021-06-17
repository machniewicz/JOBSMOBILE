package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.idioma.Idioma;

@FacesConverter(value = "toIdiomaConverter", forClass = Idioma.class)
public class IdiomaConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Idioma) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Idioma) {
	            Idioma entity= (Idioma) value;
	            if (entity != null && entity instanceof Idioma && entity.getIdioma_id() != null) {
	                uiComponent.getAttributes().put( entity.getIdioma_id().toString(), entity);
	                return entity.getIdioma_id().toString();
	            }
	        }
	        return "";
	    }

}
