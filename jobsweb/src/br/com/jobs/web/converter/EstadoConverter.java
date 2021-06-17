package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import br.com.jobs.modelo.estado.Estado;

@FacesConverter(value = "toEstadoConverter", forClass = Estado.class)
public class EstadoConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Estado) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Estado) {
	            Estado entity= (Estado) value;
	            if (entity != null && entity instanceof Estado && entity.getEstado_id() != null) {
	                uiComponent.getAttributes().put( entity.getEstado_id().toString(), entity);
	                return entity.getEstado_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
