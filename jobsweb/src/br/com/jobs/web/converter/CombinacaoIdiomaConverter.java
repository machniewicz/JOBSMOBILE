package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.combinacao.idioma.Combinacao_Idioma;

@FacesConverter(value = "toCombinacaoIdiomaConverter", forClass = Combinacao_Idioma.class)
public class CombinacaoIdiomaConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Combinacao_Idioma) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Combinacao_Idioma) {
	            Combinacao_Idioma entity= (Combinacao_Idioma) value;
	            if (entity != null && entity instanceof Combinacao_Idioma && entity.getCombinacao_idioma_id() != null) {
	                uiComponent.getAttributes().put( entity.getCombinacao_idioma_id().toString(), entity);
	                return entity.getCombinacao_idioma_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
