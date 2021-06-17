package br.com.jobs.modelo.curso;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;


public class CursoRN {
	private CursoDAO cursoDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();

	public CursoRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
		this.cursoDAO = DAOFactory.criarCursoDAO();
	}

	public Curso carregar(Integer curso) {
		return this.cursoDAO.carregar(curso);
	}
	
	public List<Curso> listarTodos(){
			return this.cursoDAO.listarTodos();
	} 

	public void salvar(Curso curso) {
		Integer codigo = curso.getCurso_id();
		if (codigo == null || codigo == 0) {
			try {
				this.cursoDAO.salvar(curso);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_curso_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_curso_incluir_falha"));
			}

		} else {
			try {
				this.cursoDAO.atualizar(curso);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_curso_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_curso_atualizar_falha"));
			}
		}
	}

	public void excluir(Curso curso) {
		try {
			this.cursoDAO.excluir(curso);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_curso_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_curso_excluir_falha"));
		}
	}

	
		
}
