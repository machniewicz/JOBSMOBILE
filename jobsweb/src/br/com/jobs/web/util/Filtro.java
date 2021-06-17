package br.com.jobs.web.util;

import java.io.Serializable;

import br.com.jobs.combinacao.idioma.Combinacao_Idioma;
import br.com.jobs.combinacao.software.Combinacao_Software;
import br.com.jobs.modelo.categoria.Categoria;
import br.com.jobs.modelo.cidade.Cidade;
import br.com.jobs.modelo.estado.Estado;
import br.com.jobs.modelo.formacao.Formacao;
import br.com.jobs.modelo.funcao.Funcao;
import br.com.jobs.modelo.idioma.Idioma;
import br.com.jobs.modelo.nivel.Nivel;
import br.com.jobs.modelo.salario.Salario;

public class Filtro implements Serializable {

	/**
	 * Categoria categoria, Funcao funcao,
			Estado estado, Cidade cidade, Salario salario, Formacao formacao,
			Integer experiencia, Idioma idioma); 
	 */
	private static final long serialVersionUID = 1L;
	
	private Categoria categoria;
	private Cidade cidade;
	private Estado estado;
	private Formacao formacao;
	private Funcao funcao;
	private Idioma idioma;
	private Nivel nivel;
	private Salario salario;
	private Integer experiencia;
	private Combinacao_Idioma combinacao_idioma;
	private Combinacao_Software combincao_software;
	
		
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Formacao getFormacao() {
		return formacao;
	}
	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public Salario getSalario() {
		return salario;
	}
	public void setSalario(Salario salario) {
		this.salario = salario;
	}
	public Integer getExperiencia() {
		return experiencia;
	}
	public void setExperiencia(Integer experiencia) {
		this.experiencia = experiencia;
	}
	public Combinacao_Idioma getCombinacao_idioma() {
		return combinacao_idioma;
	}
	public void setCombinacao_idioma(Combinacao_Idioma combinacao_idioma) {
		this.combinacao_idioma = combinacao_idioma;
	}
	public Combinacao_Software getCombincao_software() {
		return combincao_software;
	}
	public void setCombincao_software(Combinacao_Software combincao_software) {
		this.combincao_software = combincao_software;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime
				* result
				+ ((combinacao_idioma == null) ? 0 : combinacao_idioma
						.hashCode());
		result = prime
				* result
				+ ((combincao_software == null) ? 0 : combincao_software
						.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((experiencia == null) ? 0 : experiencia.hashCode());
		result = prime * result
				+ ((formacao == null) ? 0 : formacao.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + ((idioma == null) ? 0 : idioma.hashCode());
		result = prime * result + ((nivel == null) ? 0 : nivel.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
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
		Filtro other = (Filtro) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (combinacao_idioma == null) {
			if (other.combinacao_idioma != null)
				return false;
		} else if (!combinacao_idioma.equals(other.combinacao_idioma))
			return false;
		if (combincao_software == null) {
			if (other.combincao_software != null)
				return false;
		} else if (!combincao_software.equals(other.combincao_software))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (experiencia == null) {
			if (other.experiencia != null)
				return false;
		} else if (!experiencia.equals(other.experiencia))
			return false;
		if (formacao == null) {
			if (other.formacao != null)
				return false;
		} else if (!formacao.equals(other.formacao))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (idioma == null) {
			if (other.idioma != null)
				return false;
		} else if (!idioma.equals(other.idioma))
			return false;
		if (nivel == null) {
			if (other.nivel != null)
				return false;
		} else if (!nivel.equals(other.nivel))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		return true;
	}
	
	

}
