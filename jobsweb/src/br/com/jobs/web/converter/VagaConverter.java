package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.vaga.Vaga;

@FacesConverter(value = "toVagaConverter", forClass = Vaga.class)
public class VagaConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Vaga) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Vaga) {
	            Vaga entity= (Vaga) value;
	            if (entity != null && entity instanceof Vaga && entity.getVaga_id() != null) {
	                uiComponent.getAttributes().put( entity.getVaga_id().toString(), entity);
	                return entity.getVaga_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
