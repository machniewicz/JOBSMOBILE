package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.cidade.Cidade;

@FacesConverter(value = "toCidadeConverter", forClass = Cidade.class)
public class CidadeConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Cidade) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Cidade) {
	            Cidade entity= (Cidade) value;
	            if (entity != null && entity instanceof Cidade && entity.getCidade_id() != null) {
	                uiComponent.getAttributes().put( entity.getCidade_id().toString(), entity);
	                return entity.getCidade_id().toString();
	            }
	        }
	        return "";
	    }
	
}
