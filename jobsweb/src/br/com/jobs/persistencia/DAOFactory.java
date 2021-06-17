package br.com.jobs.persistencia;

import br.com.jobs.combinacao.ajudadecusto.Combinacao_AjudaDeCustoDAO;
import br.com.jobs.combinacao.ajudadecusto.Combinacao_AjudaDeCustoDAOImpl;
import br.com.jobs.combinacao.idioma.Combinacao_IdiomaDAO;
import br.com.jobs.combinacao.idioma.Combinacao_IdiomaDAOImpl;
import br.com.jobs.combinacao.software.Combinacao_SoftwareDAO;
import br.com.jobs.combinacao.software.Combinacao_SoftwareDAOImpl;
import br.com.jobs.modelo.ajudadecusto.AjudaDeCustoDAO;
import br.com.jobs.modelo.ajudadecusto.AjudaDeCustoDAOImpl;
import br.com.jobs.modelo.beneficio.BeneficioDAO;
import br.com.jobs.modelo.beneficio.BeneficioDAOImpl;
import br.com.jobs.modelo.cadastro.CadastroDAO;
import br.com.jobs.modelo.cadastro.CadastroDAOImpl;
import br.com.jobs.modelo.categoria.CategoriaDAO;
import br.com.jobs.modelo.categoria.CategoriaDAOImpl;
import br.com.jobs.modelo.cidade.CidadeDAO;
import br.com.jobs.modelo.cidade.CidadeDAOImpl;
import br.com.jobs.modelo.comissao.ComissaoDAO;
import br.com.jobs.modelo.comissao.ComissaoDAOImpl;
import br.com.jobs.modelo.curriculo.CurriculoDAO;
import br.com.jobs.modelo.curriculo.CurriculoDAOImpl;
import br.com.jobs.modelo.curso.CursoDAO;
import br.com.jobs.modelo.curso.CursoDAOImpl;
import br.com.jobs.modelo.email.EmailDAO;
import br.com.jobs.modelo.email.EmailDAOImpl;
import br.com.jobs.modelo.empresa.EmpresaDAO;
import br.com.jobs.modelo.empresa.EmpresaDAOImpl;
import br.com.jobs.modelo.enviado.EnviadoDAO;
import br.com.jobs.modelo.enviado.EnviadoDaoImpl;
import br.com.jobs.modelo.escolaridade.EscolaridadeDAO;
import br.com.jobs.modelo.escolaridade.EscolaridadeDAOImpl;
import br.com.jobs.modelo.estado.EstadoDAO;
import br.com.jobs.modelo.estado.EstadoDAOImpl;
import br.com.jobs.modelo.estatistica.EstatisticaDAO;
import br.com.jobs.modelo.estatistica.EstatisticaDAOImpl;
import br.com.jobs.modelo.experiencia.ExperienciaDAO;
import br.com.jobs.modelo.experiencia.ExperienciaDAOImpl;
import br.com.jobs.modelo.faturamento.FaturamentoDAO;
import br.com.jobs.modelo.faturamento.FaturamentoDAOImpl;
import br.com.jobs.modelo.financeiro.FinanceiroDAO;
import br.com.jobs.modelo.financeiro.FinanceiroDAOImpl;
import br.com.jobs.modelo.formacao.FormacaoDAO;
import br.com.jobs.modelo.formacao.FormacaoDAOImpl;
import br.com.jobs.modelo.funcao.FuncaoDAO;
import br.com.jobs.modelo.funcao.FuncaoDAOImpl;
import br.com.jobs.modelo.idioma.IdiomaDAO;
import br.com.jobs.modelo.idioma.IdiomaDAOImpl;
import br.com.jobs.modelo.meta.MetaDAO;
import br.com.jobs.modelo.meta.MetaDAOImpl;
import br.com.jobs.modelo.nivel.NivelDAO;
import br.com.jobs.modelo.nivel.NivelDAOImpl;
import br.com.jobs.modelo.oportunidade.OportunidadeDAO;
import br.com.jobs.modelo.oportunidade.OportunidadeDAOImpl;
import br.com.jobs.modelo.pagamento.PagamentoDAO;
import br.com.jobs.modelo.pagamento.PagamentoDAOImpl;
import br.com.jobs.modelo.perfil.PerfilDAO;
import br.com.jobs.modelo.perfil.PerfilDAOImpl;
import br.com.jobs.modelo.salario.SalarioDAO;
import br.com.jobs.modelo.salario.SalarioDAOImpl;
import br.com.jobs.modelo.situacao.SituacaoDAO;
import br.com.jobs.modelo.situacao.SituacaoDAOImpl;
import br.com.jobs.modelo.software.SoftwareDAO;
import br.com.jobs.modelo.software.SoftwareDAOImpl;
import br.com.jobs.modelo.usuario.UsuarioDAO;
import br.com.jobs.modelo.usuario.UsuarioDAOImpl;
import br.com.jobs.modelo.vaga.VagaDAO;
import br.com.jobs.modelo.vaga.VagaDAOImpl;
import br.com.jobs.modelo.vendedor.VendedorDAO;
import br.com.jobs.modelo.vendedor.VendedorDAOImpl;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOImpl usuarioDAO = new UsuarioDAOImpl();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

	public static CategoriaDAO criarCategoriaDAO() {
		CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl();
		categoriaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return categoriaDAO;
	}

	public static OportunidadeDAO criarOportunidadeDAO(){
		OportunidadeDAOImpl oportunidadeDAO = new OportunidadeDAOImpl();
		oportunidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return oportunidadeDAO;
	}
	
	public static EstadoDAO criarEstadoDAO(){
		EstadoDAOImpl estadoDAO = new EstadoDAOImpl();
		estadoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return estadoDAO;
	}
	
	public static PerfilDAO criarPerfilDAO(){
		PerfilDAOImpl perfilDAO = new PerfilDAOImpl();
		perfilDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return perfilDAO;
	}
	
	public static EmailDAO criarEmailDAO(){
		EmailDAOImpl emailDAO = new EmailDAOImpl();
		emailDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return emailDAO;
	}
	
	public static EnviadoDAO criarEnviadoDAO(){
		EnviadoDaoImpl enviadoDao = new EnviadoDaoImpl();
		enviadoDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return enviadoDao;
	}
	
	public static EstatisticaDAO criarEstatisticaDAO(){
		EstatisticaDAOImpl estatisticaDAO = new EstatisticaDAOImpl();
		estatisticaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return estatisticaDAO;
	}
	
	public static CadastroDAO criarCadastroDAO(){
		CadastroDAOImpl cadastroDAO = new CadastroDAOImpl();
		cadastroDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return cadastroDAO;
	}
	
	public static FormacaoDAO criarFormacaoDAO(){
		FormacaoDAOImpl formacaoDAO = new FormacaoDAOImpl();
		formacaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return formacaoDAO;
	}
	
	public static SalarioDAO criarSalarioDAO(){
		SalarioDAOImpl salarioDAO = new SalarioDAOImpl();
		salarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return salarioDAO;
	}
	
	public static CurriculoDAO criarCurriculoDAO(){
		CurriculoDAOImpl curriculoDAO = new CurriculoDAOImpl();
		curriculoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return curriculoDAO;
	}
	
	public static EmpresaDAO criarEmpresaDAO() {
		EmpresaDAOImpl empresaDAO = new EmpresaDAOImpl();
		empresaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return empresaDAO;
	}
	
	public static CidadeDAO criarCidadeDAO() {
		CidadeDAOImpl cidadeDAO = new CidadeDAOImpl();
		cidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return cidadeDAO;
	}
	
	public static BeneficioDAO criarBeneficioDAO() {
		BeneficioDAOImpl beneficioDAO = new BeneficioDAOImpl();
		beneficioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return beneficioDAO;
	}
	
	public static IdiomaDAO criarIdiomaDAO() {
		IdiomaDAOImpl idiomaDAO = new IdiomaDAOImpl();
		idiomaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return idiomaDAO;
	}
	
	public static SoftwareDAO criarSoftwareDAO() {
		SoftwareDAOImpl softwareDAO = new SoftwareDAOImpl();
		softwareDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return softwareDAO;
	}
	
	public static NivelDAO criarNivelDAO() {
		NivelDAOImpl nivelDAO = new NivelDAOImpl();
		nivelDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return nivelDAO;
	}
	
	public static VagaDAO criarVagaDAO() {
		VagaDAOImpl vagaDAO = new VagaDAOImpl();
		vagaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return vagaDAO;
	}
	
	public static FuncaoDAO criarFuncaoDAO() {
		FuncaoDAOImpl funcaoDAO = new FuncaoDAOImpl();
		funcaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return funcaoDAO;
	}
	
	public static ExperienciaDAO criarExperienciaDAO() {
		ExperienciaDAOImpl experienciaDAO = new ExperienciaDAOImpl();
		experienciaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return experienciaDAO;
	}
	
	public static CursoDAO criarCursoDAO() {
		CursoDAOImpl cursoDAO = new CursoDAOImpl();
		cursoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return cursoDAO;
	}
	
	public static EscolaridadeDAO criarEscolaridadeDAO() {
		EscolaridadeDAOImpl escolaridadeDAO = new EscolaridadeDAOImpl();
		escolaridadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return escolaridadeDAO;
	}
	
	public static SituacaoDAO criarSituacaoDAO() {
		SituacaoDAOImpl situacaoDAO = new SituacaoDAOImpl();
		situacaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return situacaoDAO;
	}
	
	public static Combinacao_IdiomaDAO criarCombinacaoIdiomaDAO() {
		Combinacao_IdiomaDAOImpl combinacaoidiomaDAO = new Combinacao_IdiomaDAOImpl();
		combinacaoidiomaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return combinacaoidiomaDAO;
	}
	
	public static Combinacao_SoftwareDAO criarCombinacaoSoftwareDAO() {
		Combinacao_SoftwareDAOImpl combinacaosoftwareDAO = new Combinacao_SoftwareDAOImpl();
		combinacaosoftwareDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return combinacaosoftwareDAO;
	}
	
	public static AjudaDeCustoDAO criarAjudaDeCustoDAO() {
		AjudaDeCustoDAOImpl ajudadecustoDAO = new AjudaDeCustoDAOImpl();
		ajudadecustoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return ajudadecustoDAO;
	}
	
	public static Combinacao_AjudaDeCustoDAO criarCombinacaoAjudaDeCustoDAO() {
		Combinacao_AjudaDeCustoDAOImpl combinacaoajudadecustoDAO = new Combinacao_AjudaDeCustoDAOImpl();
		combinacaoajudadecustoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return combinacaoajudadecustoDAO;
	}
	
	public static ComissaoDAO criarComissaoDAO() {
		ComissaoDAOImpl comissaoDAO = new ComissaoDAOImpl();
		comissaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return comissaoDAO;
	}
	
	public static FaturamentoDAO criarFaturamentoDAO() {
		FaturamentoDAOImpl faturamentoDAO = new FaturamentoDAOImpl();
		faturamentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return faturamentoDAO;
	}
	
	public static FinanceiroDAO criarFinanceiroDAO() {
		FinanceiroDAOImpl financeiroDAO = new FinanceiroDAOImpl();
		financeiroDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return financeiroDAO;
	}
	
	public static MetaDAO criarMetaDAO() {
		MetaDAOImpl metaDAO = new MetaDAOImpl();
		metaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return metaDAO;
	}
	
	public static PagamentoDAO criarPagamentoDAO() {
		PagamentoDAOImpl pagamentoDAO = new PagamentoDAOImpl();
		pagamentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return pagamentoDAO;
	}

	public static VendedorDAO criarVendedorDAO() {
		VendedorDAOImpl vendedorDAO = new VendedorDAOImpl();
		vendedorDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return vendedorDAO;
	}

	
}
