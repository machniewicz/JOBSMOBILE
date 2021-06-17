package br.com.jobs.web.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.jobs.modelo.perfil.Perfil;
import br.com.jobs.modelo.perfil.PerfilRN;

@ManagedBean(name = "perfilMB")
@SessionScoped

public class PerfilMB {

		private Perfil perfil;
		private PerfilRN perfilRN;
		private List<Perfil> lista;

		/*
		 * Construtor
		 */
		public PerfilMB() {
			super();
		}
		
		public List<Perfil> listarTodosPerfis() {
			perfilRN = new PerfilRN();
			lista = perfilRN.listarTodosPerfis();
			return lista;
		}

		public Perfil getPerfil() {
			return perfil;
		}

		public void setPerfil(Perfil perfil) {
			this.perfil = perfil;
		}

}
