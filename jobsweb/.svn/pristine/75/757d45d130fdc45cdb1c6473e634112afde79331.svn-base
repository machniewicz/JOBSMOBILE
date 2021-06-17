package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.beneficio.Beneficio;

@FacesConverter(value = "toBeneficioConverter", forClass = Beneficio.class)
public class BeneficioConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Beneficio) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Beneficio) {
	            Beneficio entity= (Beneficio) value;
	            if (entity != null && entity instanceof Beneficio && entity.getBeneficio_id() != null) {
	                uiComponent.getAttributes().put( entity.getBeneficio_id().toString(), entity);
	                return entity.getBeneficio_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
