package br.com.jobs.web.util.pesquisa;

import java.io.Serializable;

public class ItemFiltro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String item_filtro_descricao;
	private Integer item_filtro_identificador;
	public String getItem_filtro_descricao() {
		return item_filtro_descricao;
	}
	public void setItem_filtro_descricao(String item_filtro_descricao) {
		this.item_filtro_descricao = item_filtro_descricao;
	}
	public Integer getItem_filtro_identificador() {
		return item_filtro_identificador;
	}
	public void setItem_filtro_identificador(Integer item_filtro_identificador) {
		this.item_filtro_identificador = item_filtro_identificador;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((item_filtro_descricao == null) ? 0 : item_filtro_descricao
						.hashCode());
		result = prime
				* result
				+ ((item_filtro_identificador == null) ? 0
						: item_filtro_identificador.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemFiltro other = (ItemFiltro) obj;
		if (item_filtro_descricao == null) {
			if (other.item_filtro_descricao != null)
				return false;
		} else if (!item_filtro_descricao.equals(other.item_filtro_descricao))
			return false;
		if (item_filtro_identificador == null) {
			if (other.item_filtro_identificador != null)
				return false;
		} else if (!item_filtro_identificador
				.equals(other.item_filtro_identificador))
			return false;
		return true;
	}
	
}
