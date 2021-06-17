package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.faturamento.Faturamento;

@FacesConverter(value = "toFaturamentoConverter", forClass = Faturamento.class)
public class FaturamentoConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Faturamento) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Faturamento) {
	        	Faturamento entity= (Faturamento) value;
	            if (entity != null && entity instanceof Faturamento && entity.getFaturamento_id() != null) {
	                uiComponent.getAttributes().put( entity.getFaturamento_id().toString(), entity);
	                return entity.getFaturamento_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
