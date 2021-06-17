package br.com.jobs.modelo.categoria;

import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;


public class CategoriaRN {
	private CategoriaDAO categoriaDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();

	public CategoriaRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages",faces.carregaLocale());
		this.categoriaDAO = DAOFactory.criarCategoriaDAO();
	}

	public Categoria carregar(Integer categoria) {
		return this.categoriaDAO.carregar(categoria);
	}
	
	public List<Categoria> listarTodos(){
			return this.categoriaDAO.listarTodos();
	} 

	public List<Categoria> listarTodosAtivos(){
		return this.categoriaDAO.listarTodosAtivos();
	} 
	
	public void salvar(Categoria categoria) {
		Integer codigo = categoria.getCategoria_id();
		if (codigo == null || codigo == 0) {
			try {
				this.populaCategoria(categoria);
				this.categoriaDAO.salvar(categoria);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_categoria_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_categoria_incluir_falha"));
			}

		} else {
			try {
				this.categoriaDAO.atualizar(categoria);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_categoria_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_categoria_atualizar_falha"));
			}
		}
	}

	public void excluir(Categoria categoria) {
		try {
			this.categoriaDAO.excluir(categoria);
			FacesUtil.exibirMensagemSucesso(bundle.getString("msg_categoria_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle.getString("msg_categoria_excluir_falha"));
		}
	}

	public void populaCategoria(Categoria categoria) {
		categoria.setCategoria_status(true);
	}
	
	public String carregarStatus(Integer codigo) {
		Boolean statusTmp; 
		String descStatusTmp = null;
		statusTmp = new Boolean(this.categoriaDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true){
			descStatusTmp =  bundle.getString("lbl_categoria_status_ativo_1");
		}
		else if (statusTmp.booleanValue() == false) {
			descStatusTmp =  bundle.getString("lbl_categoria_status_ativo_0");
		}
		return descStatusTmp;	
	}
	
}
