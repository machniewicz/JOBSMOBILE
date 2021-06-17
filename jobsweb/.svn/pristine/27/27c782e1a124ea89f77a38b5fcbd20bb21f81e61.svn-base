package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.comissao.Comissao;

@FacesConverter(value = "toComissaoConverter", forClass = Comissao.class)
public class ComissaoConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Comissao) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Comissao) {
	            Comissao entity= (Comissao) value;
	            if (entity != null && entity instanceof Comissao && entity.getComissao_id() != null) {
	                uiComponent.getAttributes().put( entity.getComissao_id().toString(), entity);
	                return entity.getComissao_id().toString();
	            }
	        }
	        return "";
	    }
	
	
}
