package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.situacao.Situacao;

@FacesConverter(value = "toSituacaoConverter", forClass = Situacao.class)
public class SituacaoConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Situacao) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Situacao) {
	        	Situacao entity= (Situacao) value;
	            if (entity != null && entity instanceof Situacao && entity.getSituacao_id() != null) {
	                uiComponent.getAttributes().put( entity.getSituacao_id().toString(), entity);
	                return entity.getSituacao_id().toString();
	            }
	        }
	        return "";
	    }

}
