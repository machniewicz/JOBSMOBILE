package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.pagamento.Pagamento;

@FacesConverter(value = "toPagamentoConverter", forClass = Pagamento.class)
public class PagamentoConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Pagamento) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Pagamento) {
	        	Pagamento entity= (Pagamento) value;
	            if (entity != null && entity instanceof Pagamento && entity.getPagamento_id() != null) {
	                uiComponent.getAttributes().put( entity.getPagamento_id().toString(), entity);
	                return entity.getPagamento_id().toString();
	            }
	        }
	        return "";
	    }

}
