package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.ajudadecusto.AjudaDeCusto;

@FacesConverter(value = "toAjudaDeCustoConverter", forClass = AjudaDeCusto.class)
public class AjudaDeCustoConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (AjudaDeCusto) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof AjudaDeCusto) {
	            AjudaDeCusto entity= (AjudaDeCusto) value;
	            if (entity != null && entity instanceof AjudaDeCusto && entity.getAjudadecusto_id() != null) {
	                uiComponent.getAttributes().put( entity.getAjudadecusto_id().toString(), entity);
	                return entity.getAjudadecusto_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
