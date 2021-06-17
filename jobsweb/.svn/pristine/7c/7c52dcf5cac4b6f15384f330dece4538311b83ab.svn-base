package br.com.jobs.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.jobs.modelo.vendedor.Vendedor;

@FacesConverter(value = "toVendedorConverter", forClass = Vendedor.class)
public class VendedorConverter implements Converter {

	 @Override
	    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
	        if (value != null && !value.isEmpty()) {
	            return (Vendedor) uiComponent.getAttributes().get(value);
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
	        if (value instanceof Vendedor) {
	        	Vendedor entity= (Vendedor) value;
	            if (entity != null && entity instanceof Vendedor && entity.getVendedor_id() != null) {
	                uiComponent.getAttributes().put( entity.getVendedor_id().toString(), entity);
	                return entity.getVendedor_id().toString();
	            }
	        }
	        return "";
	    }

}
