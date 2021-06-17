package br.com.jobs.modelo.cadastro;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.jobs.mail.MailSender;
import br.com.jobs.modelo.enviado.Enviado;
import br.com.jobs.modelo.experiencia.Experiencia;
import br.com.jobs.modelo.perfil.Perfil;
import br.com.jobs.persistencia.DAOFactory;
import br.com.jobs.web.util.FacesUtil;
import br.com.jobs.web.util.Filtro;
import br.com.jobs.web.util.pesquisa.ItemFiltro;

public class CadastroRN {

	private CadastroDAO cadastroDAO;
	private ResourceBundle bundle = null;
	private FacesUtil faces = new FacesUtil();
	private List<Cadastro> lista = null;
	private List<ItemFiltro> fil;
	private ItemFiltro item;
	private Cadastro cadastro = new Cadastro();
	private MailSender mail = new MailSender();

	public CadastroRN() {
		bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages", faces.carregaLocale());
		this.cadastroDAO = DAOFactory.criarCadastroDAO();
	}

	public Cadastro carregar(Integer codigo) {
		return this.cadastroDAO.carregar(codigo);
	}

	public Cadastro buscarPorLogin(String login) {
		return this.cadastroDAO.buscarPorLogin(login);
	}
	
	public int buscarCadastro(String cpf){
		Integer retorno = cadastroDAO.quantidadeCadastro(cpf);
		if(retorno >= 1){
			FacesUtil.exibirMensagemErro(bundle.getString("msg_cadastro_cadastrado"));
		}
		return retorno;
	}
	
	public List<ItemFiltro> getFil() {
		return fil;
	}

	public void setFil(List<ItemFiltro> fil) {
		this.fil = fil;
	}

	/*
	 * Metodo retorna um ArrayList POSI��O[0] = ROLE_USUARIO POSI��O[1] = PERFIL
	 */
	public ArrayList<String> carregarPerfil(Integer codigo) {
		ArrayList<String> listaPerfil = new ArrayList<String>();
		String roleTmp = null, perfilTmp = null;
		roleTmp = this.cadastroDAO.carregaPerfil(codigo);
		if (roleTmp.equals("ROLE_CONVIDADO")) {
			perfilTmp = bundle.getString("lbl_cadastro_perfil_convidado");
		} 
		listaPerfil.add(roleTmp);
		listaPerfil.add(perfilTmp);
		return listaPerfil;
	}

	public String carregarStatus(Integer codigo) {
		Boolean statusTmp;
		String descStatusTmp = null;
		statusTmp = new Boolean(this.cadastroDAO.carregaStatus(codigo));
		if (statusTmp.booleanValue() == true) {
			descStatusTmp = bundle.getString("lbl_cadastro_status_ativo_1");
		} else if (statusTmp.booleanValue() == false) {
			descStatusTmp = bundle.getString("lbl_cadastro_status_ativo_0");
		}
		return descStatusTmp;
	}
	
	public String carregarSexo(Integer codigo) {
		Integer sexoTmp;
		String descSexoTmp = null;
		sexoTmp = new Integer(this.cadastroDAO.carregaSexo(codigo));
		if (sexoTmp == 1) {
			descSexoTmp = bundle.getString("lbl_cadastro_incluir_complemento_sexo_f");
		} else if (sexoTmp == 0) {
			descSexoTmp = bundle.getString("lbl_cadastro_incluir_complemento_sexo_m");
		}
		else{
			descSexoTmp = "";
		}
		return descSexoTmp;
	}

	
	public void salvar(Cadastro cadastro) {

		Integer codigo = cadastro.getCadastro_id();

		if (codigo == null || codigo == 0) {
			try {
				this.populaCadastro(cadastro);
				this.cadastroDAO.salvar(cadastro);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_cadastro_incluir_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_cadastro_incluir_falha"));
			}

		} else {
			try {
				Date dataAlteracaoCadastro = this.getPegaDataAtual();
				cadastro.setCadastro_data(dataAlteracaoCadastro);
				this.cadastroDAO.atualizar(cadastro);
				FacesUtil.exibirMensagemSucesso(bundle
						.getString("msg_cadastro_atualizar_sucesso"));
			} catch (Exception e) {
				FacesUtil.exibirMensagemErro(bundle
						.getString("msg_cadastro_atualizar_falha"));
			}
		}
	}
	
	public void alterarSenha(Cadastro cadastro, String novaSenha, String comparaSenha){
		if(!novaSenha.isEmpty() && !comparaSenha.isEmpty()){
			if(novaSenha.equals(comparaSenha)){
				cadastro.setCadastro_senha(novaSenha);
				this.cadastroDAO.alterarSenha(cadastro);
				FacesUtil.exibirMensagemSucesso(bundle.getString("msg_trocar_senha_sucesso"));
			}
			else{
				FacesUtil.exibirMensagemErro(bundle.getString("msg_trocar_senha_incompativel"));
			}
		}
		else{
			FacesUtil.exibirMensagemErro(bundle.getString("msg_trocar_senha_vazia"));
		}
				
	}
	
	public void excluir(Cadastro cadastro) {
		try {
			this.cadastroDAO.excluir(cadastro);
			FacesUtil.exibirMensagemSucesso(bundle
					.getString("msg_cadastro_excluir_sucesso"));
		} catch (Exception e) {
			FacesUtil.exibirMensagemErro(bundle
					.getString("msg_cadastro_excluir_falha"));
		}

	}

	public List<Cadastro> listarTodosCadastros() {
		return this.cadastroDAO.listarTodos();
	}
	
	public void recuperarSenha(String parametro, Integer opcao) {
		if(opcao.equals(null)){
			FacesUtil.exibirMensagemErro(bundle.getString("msg_cadastro_recuperar_vazio"));
		}
		else{
				lista = this.cadastroDAO.recuperaSenha(parametro, opcao);
				if (lista.size()== 0){
					FacesUtil.exibirMensagemErro(bundle.getString("msg_cadastro_recuperar_falha_0"));
				}else if (lista.size()>=2){
					FacesUtil.exibirMensagemErro(bundle.getString("msg_cadastro_recuperar_falha_2"));
				}
				else{
					cadastro = lista.get(0);
					mail.EnviarMailCadastro(cadastro);
				}
		}
	}

	public List<Cadastro> filtrarCadastros(Filtro filtro) {
		return this.cadastroDAO.filtrarCadastro(filtro);
	}
	/*
	 * Metodo para popular Filtros
	 * 1 - Indica que filtro Categoria foi aplicado
	 * 2 - Indica que filtro Fun��o foi aplicado
	 * 3 - Indica que filtro Estado foi aplicado
	 * 4 - Indica que filtro Cidade foi aplicado
	 * 5 - Indica que filtro Salario foi aplicado
	 * 6 - Indica que fitro Forma��o foi aplicado
	 * 7 - Indica que fitro Idioma foi aplicado
	 * 8 - Indica que fitro Experi�ncia foi aplicado
	 * 9 - Indica que fitro Nivel foi aplicado
	 */
	public List<ItemFiltro> listaFitros(Filtro filtro){
		fil = new ArrayList<ItemFiltro>();
		if(filtro.getCategoria()!=null){
			item = new ItemFiltro();
			item.setItem_filtro_descricao(bundle.getString("filtro_categoria"));
			item.setItem_filtro_identificador(1);
			fil.add(item);
		}if(filtro.getFuncao()!=null){
			item = new ItemFiltro();
			item.setItem_filtro_descricao(bundle.getString("filtro_funcao"));
			item.setItem_filtro_identificador(2);
			fil.add(item);
		}if(filtro.getEstado()!=null){
			item = new ItemFiltro();
			item.setItem_filtro_descricao(bundle.getString("filtro_estado"));
			item.setItem_filtro_identificador(3);
			fil.add(item);
		}if(filtro.getCidade()!=null){
			item = new ItemFiltro();
			item.setItem_filtro_descricao(bundle.getString("filtro_cidade"));
			item.setItem_filtro_identificador(4);
			fil.add(item);
		}if(filtro.getSalario()!=null){
			item = new ItemFiltro();
			item.setItem_filtro_descricao(bundle.getString("filtro_salario"));
			item.setItem_filtro_identificador(5);
			fil.add(item);
		}if(filtro.getFormacao()!=null){
			item = new ItemFiltro();
			item.setItem_filtro_descricao(bundle.getString("filtro_formacao"));
			item.setItem_filtro_identificador(6);
			fil.add(item);
		}if(filtro.getExperiencia()!=null && filtro.getExperiencia()>0){
			item = new ItemFiltro();
			item.setItem_filtro_descricao(bundle.getString("filtro_experiencia"));
			item.setItem_filtro_identificador(8);
			fil.add(item);
		}
		if(filtro.getIdioma()!=null){
			item = new ItemFiltro();
			item.setItem_filtro_descricao(bundle.getString("filtro_idioma"));
			item.setItem_filtro_identificador(7);
			fil.add(item);
		}
		if(filtro.getNivel()!=null){
			item = new ItemFiltro();
			item.setItem_filtro_descricao(bundle.getString("filtro_nivel"));
			item.setItem_filtro_identificador(9);
			fil.add(item);
		}
		return fil;
	}
		
	public String registroEncontrados(List<Cadastro> cadastros){
		String retorno = "";
		if (cadastros != null){
			retorno = bundle.getString("lbl_filtro_quantidade_registro") + " " + cadastros.size();
		}
		return retorno;
	}
	
	public int compararSenhaVerificaVazio(Cadastro cadastro, String novaSenha, String comparaSenha){
		if (cadastro.getCadastro_nome().isEmpty() || cadastro.getCadastro_cpf().isEmpty() || cadastro.getFormacao()==null || cadastro.getCadastro_email().isEmpty() ) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_cadastro_vazio"));
				return 0; 
		}
		else{

			if (cadastro.getCadastro_nome().length() < 5 || cadastro.getCadastro_cpf().length() < 14) {
				FacesUtil.exibirMensagemErro(bundle.getString("msg_cadastro_tamanho"));
				return 0; 
			}
			else{
				if(!novaSenha.isEmpty() && !comparaSenha.isEmpty()){
					if(novaSenha.equals(comparaSenha)){
						cadastro.setCadastro_senha(novaSenha);
						return 1;
					}
					else{
						FacesUtil.exibirMensagemErro(bundle.getString("msg_trocar_senha_incompativel"));
						return 0;
					}
				}
				else{
					FacesUtil.exibirMensagemErro(bundle.getString("msg_trocar_senha_vazia"));
					return 0;
				}
			}
		}
	}
	

	public void populaCadastro(Cadastro cadastro) {
		Date dataInclusaoCadastro;
		ArrayList<Perfil> lista = new ArrayList<Perfil>();
		Perfil perfil = new Perfil();
		perfil.setPerfil_id(4);
		lista.add(perfil);
		cadastro.setPerfis(lista);
		cadastro.setCadastro_status(true);
		dataInclusaoCadastro = this.getPegaDataAtual();
		cadastro.setCadastro_data(dataInclusaoCadastro);
	}

	public Date getPegaDataAtual() {
		Date data = new Date(System.currentTimeMillis());
		return data;
	}
	
	public String empregoAtual(Experiencia experiencia){
		String retorno;
		if(experiencia.getExperiencia_atual()){
			retorno = bundle.getString("msg_sim");
		}else{
			retorno = bundle.getString("msg_nao");
		}
		return retorno;
	}
	
	public List<Enviado> listarCandidatura(Cadastro cadastro){
		return this.cadastroDAO.listarCandidatura(cadastro);
	}
}