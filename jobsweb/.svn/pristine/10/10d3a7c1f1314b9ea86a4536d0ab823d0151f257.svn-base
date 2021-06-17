package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.combinacao.software.Combinacao_Software;

@FacesConverter(value = "toCombinacaoSoftwareConverter", forClass = Combinacao_Software.class)
public class CombinacaoSoftwareConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Combinacao_Software) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Combinacao_Software) {
	            Combinacao_Software entity= (Combinacao_Software) value;
	            if (entity != null && entity instanceof Combinacao_Software && entity.getCombinacao_software_id() != null) {
	                uiComponent.getAttributes().put( entity.getCombinacao_software_id().toString(), entity);
	                return entity.getCombinacao_software_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
