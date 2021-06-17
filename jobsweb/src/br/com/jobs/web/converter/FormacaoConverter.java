package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.formacao.Formacao;

@FacesConverter(value = "toFormacaoConverter", forClass = Formacao.class)
public class FormacaoConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Formacao) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Formacao) {
	        	Formacao entity= (Formacao) value;
	            if (entity != null && entity instanceof Formacao && entity.getFormacao_id() != null) {
	                uiComponent.getAttributes().put( entity.getFormacao_id().toString(), entity);
	                return entity.getFormacao_id().toString();
	            }
	        }
	        return "";
	    }

}
