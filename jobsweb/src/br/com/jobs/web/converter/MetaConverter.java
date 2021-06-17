package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.meta.Meta;

@FacesConverter(value = "toMetaConverter", forClass = Meta.class)
public class MetaConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Meta) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Meta) {
	            Meta entity= (Meta) value;
	            if (entity != null && entity instanceof Meta && entity.getMeta_id() != null) {
	                uiComponent.getAttributes().put( entity.getMeta_id().toString(), entity);
	                return entity.getMeta_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
