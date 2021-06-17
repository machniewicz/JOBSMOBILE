package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.financeiro.Financeiro;

@FacesConverter(value = "toFinanceiroConverter", forClass = Financeiro.class)
public class FinanceiroConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Financeiro) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Financeiro) {
	        	Financeiro entity= (Financeiro) value;
	            if (entity != null && entity instanceof Financeiro && entity.getFinanceiro_id() != null) {
	                uiComponent.getAttributes().put( entity.getFinanceiro_id().toString(), entity);
	                return entity.getFinanceiro_id().toString();
	            }
	        }
	        return "";
	    }

}
