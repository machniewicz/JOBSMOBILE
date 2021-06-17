package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.combinacao.ajudadecusto.Combinacao_AjudaDeCusto;

@FacesConverter(value = "toCombinacaoAjudaDeCustoConverter", forClass = Combinacao_AjudaDeCusto.class)
public class CombinacaoAjudaDeCustoConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Combinacao_AjudaDeCusto) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Combinacao_AjudaDeCusto) {
	        	Combinacao_AjudaDeCusto entity= (Combinacao_AjudaDeCusto) value;
	            if (entity != null && entity instanceof Combinacao_AjudaDeCusto && entity.getCombinacao_ajudadecusto_id() != null) {
	                uiComponent.getAttributes().put( entity.getCombinacao_ajudadecusto_id().toString(), entity);
	                return entity.getCombinacao_ajudadecusto_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
