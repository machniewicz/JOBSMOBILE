package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.funcao.Funcao;

@FacesConverter(value = "toFuncaoConverter", forClass = Funcao.class)
public class FuncaoConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Funcao) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Funcao) {
	            Funcao entity= (Funcao) value;
	            if (entity != null && entity instanceof Funcao && entity.getFuncao_id() != null) {
	                uiComponent.getAttributes().put( entity.getFuncao_id().toString(), entity);
	                return entity.getFuncao_id().toString();
	            }
	        }
	        return "";
	    }
}
