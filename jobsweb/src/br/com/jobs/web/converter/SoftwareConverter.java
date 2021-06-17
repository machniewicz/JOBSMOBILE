package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.software.Software;

@FacesConverter(value = "toSoftwareConverter", forClass = Software.class)
public class SoftwareConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Software) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Software) {
	        	Software entity= (Software) value;
	            if (entity != null && entity instanceof Software && entity.getSoftware_id() != null) {
	                uiComponent.getAttributes().put( entity.getSoftware_id().toString(), entity);
	                return entity.getSoftware_id().toString();
	            }
	        }
	        return "";
	    }

}
