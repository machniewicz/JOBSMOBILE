package br.com.jobs.mobile;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.jobs.mobile.modelo.Curriculo;
import br.com.jobs.mobile.modelo.Enviado;
import br.com.jobs.mobile.modelo.Preferencia;

public class MontaXML {
	Connection connection = null;
	Integer periodo = 5;
	Date dataLimite = null;

	public MontaXML() {
		this.connect();
	}

	void close() {
		try {
			this.connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(MontaXML.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	void connect() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your SQLServer Postgress Drive? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
		}
		this.connection = null;
		try {
		/*
		 * Conexão Localhost 
		 */
	    //this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JobsMobile","postgres", "N@lson1br");
		
		/*
		 * Conexão Server AGF
		 */
//			this.connection = DriverManager.getConnection("jdbc:postgresql://192.168.0.96:5432/JobsMobile","postgres", "@gfen1br");
	    
		/* 
		 * Conexão Server AGF TESTE
		 */
		//this.connection = DriverManager.getConnection("jdbc:postgresql://192.168.0.96:5432/JobsMobileTeste","postgres", "@gfen1br");
		
		/*
		 * Conexão Cloud
		 */
	    this.connection= DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/usoluc_jobsmobile","usoluc", "uSL4usol1br");
	    //this.connection= DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/usoluc_jobsmobile","usoluc_teste", "uSL4usol1br");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		if (this.connection != null) {
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
	/*
	 * Metodo para autenticar usuario e sincronizar dados no JobsMobile
	 */
	
	public String sincronizarDados(String login, String senha){
		String retorno = "";
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_valida = "select count(*) as total from cadastro where cadastro_cpf = '"+login+"' and cadastro_senha = '"+senha+"'";
			ResultSet rs_total = sq_stmt.executeQuery(sql_valida);
			rs_total.next();
			if(rs_total.getInt("total") > 0){
				String sql_str = "select c.cadastro_id as codigo, c.cadastro_cpf as cpf, c.cadastro_data as data_inclusao, c.cadastro_email as email, c.cadastro_experiencia as experiencia, "
						+ "c.cadastro_nome as nome, c.formacao_id as formacao, c.salario_id as salario, c.categoria_id as categoria, c.estado_id as estado, c.cadastro_senha as senha "
						+ "from cadastro c "
						+ "where c.cadastro_cpf = '"+login+"' and c.cadastro_senha = '"+senha+"'";
				ResultSet rs = sq_stmt.executeQuery(sql_str);
				retorno += "<preferencias>";
				while (rs.next()) {
					retorno +="<preferencia_item>";
					retorno += "<preferencia_codigo>" + rs.getString("codigo") + "</preferencia_codigo>";
					retorno += "<preferencia_cpf>" + rs.getString("cpf") + "</preferencia_cpf>";
					retorno += "<preferencia_data>" + rs.getString("data_inclusao") + "</preferencia_data>";
					retorno += "<preferencia_email>" + rs.getString("email") + "</preferencia_email>";
					retorno += "<preferencia_experiencia>" + rs.getString("experiencia") + "</preferencia_experiencia>";
					retorno += "<preferencia_nome>" + rs.getString("nome") + "</preferencia_nome>";
					retorno += "<preferencia_formacao>" + rs.getString("formacao") + "</preferencia_formacao>";
					retorno += "<preferencia_salario>" + rs.getString("salario") + "</preferencia_salario>";
					retorno += "<preferencia_categoria>" + rs.getString("categoria") + "</preferencia_categoria>";
					retorno += "<preferencia_estado>" + rs.getString("estado") + "</preferencia_estado>";
					retorno += "<preferencia_senha>" + rs.getString("senha") + "</preferencia_senha>";
					retorno += "</preferencia_item>";
				}
				retorno += "</preferencias>";
			}
			else{
				retorno = "vazio";
			}

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		System.out.println(retorno);
		return retorno;
		
	}
	
	public int getQuant(ResultSet rs) {
		int contador = 0;
		try {
			while (rs.next()) {
				contador++;
			}
		rs.beforeFirst();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contador;
	}
	
	/*
	 * Metodo para Retornar a quantidade de novas oportunidades cadastradas diariamente
	 */
	public String listaNotificacaoXML(){
		String retorno = "";
		Date dataAtual = this.getDataAtual();
		int contador = 0;
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_str = "select count(*) as total_oportunidade, e.estado_descricao as descricao_estado from oportunidade o, estado e where e.estado_id = o.estado_id and o.oportunidade_data = '"+dataAtual+"' and o.oportunidade_status = true group by e.estado_descricao, e.estado_id order by e.estado_descricao asc";
			ResultSet rs = sq_stmt.executeQuery(sql_str);
			retorno += "<notificacao>";
				while (rs.next()) {
					retorno +="<notificacao_item>";
					retorno += "<notificacao_quantidade>" + rs.getString("total_oportunidade") + "</notificacao_quantidade>";
					retorno += "<notificacao_estado>" + rs.getString("descricao_estado") + "</notificacao_estado>";
					retorno += "</notificacao_item>";
					contador++; 
				}
				retorno += "</notificacao>";
				System.out.println("quantiade de registros: "+contador);
			if(contador == 0){
				retorno = "vazio";
			}
			
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		System.out.println(retorno);
		return retorno;
	}
	
	/*
	 * Incluir registro para alimentar estatistica de envio de curriculos
	 */
	
	public void incluirEstatistica(Enviado enviado, Preferencia preferencia){
		Integer codigo_cadastro;
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_max_id = "select MAX(enviado_id) as codigo_enviado from enviado";
			ResultSet rs = sq_stmt.executeQuery(sql_max_id);
			rs.next();
			Date dataEnviado = this.getDataAtual();
			enviado.setEnviado_id(rs.getInt("codigo_enviado")+1);
			System.out.println(enviado.getEnviado_data());
			enviado.setEnviado_data(dataEnviado);
			codigo_cadastro = this.idCadastro(preferencia);
			String sql_str = "insert into enviado (enviado_id, enviado_data, enviado_email, enviado_nome, oportunidade_id, cadastro_id)"
					+ " values ("+enviado.getEnviado_id()+",'"+enviado.getEnviado_data()+"','"+enviado.getEnviado_email()+"','"+enviado.getEnviado_nome()+"',"+enviado.getEnviado_oportunidade_id()+","+codigo_cadastro+")";
			System.out.println(sql_str);
			sq_stmt.executeUpdate(sql_str);
			
			} catch (SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
		}
	}
	

	/*
	 * Incluir pre-cadastro para filtros na Web
	 */
	
	public void incluirPreCadastro(Preferencia preferencia){
		String sql_str = null;
		String sql_perfil=null;
		try {
			Statement sq_stmt = this.connection.createStatement();
			preferencia.setPreferencia_data(this.getDataAtual());
			//Date dataCadastro = this.getDataAtual();
			String sql_max_total = "select COUNT(cadastro_id) as total from cadastro where cadastro_cpf = '"+preferencia.getPreferencia_cpf()+"'";
			ResultSet rs_total_cadastro = sq_stmt.executeQuery(sql_max_total);
			rs_total_cadastro.next();
			Integer quantidadeCadastro = rs_total_cadastro.getInt("total");
			if(quantidadeCadastro > 0){
				System.out.println("Update Cadastro");
				sql_str = "update cadastro set cadastro_data='"+preferencia.getPreferencia_data()+"',cadastro_email='"+preferencia.getPreferencia_email()+"',cadastro_senha='"+preferencia.getPreferencia_senha()+"',cadastro_experiencia="+preferencia.getPreferencia_experiencia()+",cadastro_nome='"+preferencia.getPreferencia_nome()+"', formacao_id="+preferencia.getPreferencia_formacao_id()+",salario_id="+preferencia.getPreferencia_salario_id()+",categoria_id="+preferencia.getPreferencia_categoria_id()+", estado_id="+preferencia.getPreferencia_estado_id()+", cadastro_status=true where cadastro_cpf = '"+preferencia.getPreferencia_cpf()+"'";
			
			}
			else{
				System.out.println("Insert Cadastro");
				preferencia.setPreferencia_codigo(this.ultimoRegistroCadastro());
				sql_str = "insert into cadastro (cadastro_id, cadastro_cpf, cadastro_data, cadastro_email, cadastro_experiencia, cadastro_nome, formacao_id, salario_id, categoria_id, estado_id, cadastro_senha, cadastro_status)"
						+ " values ("+preferencia.getPreferencia_codigo()+",'"+preferencia.getPreferencia_cpf()+"','"+preferencia.getPreferencia_data()+"','"+preferencia.getPreferencia_email()+"', "+preferencia.getPreferencia_experiencia()+",'"+preferencia.getPreferencia_nome()+"', "+preferencia.getPreferencia_formacao_id()+","+preferencia.getPreferencia_salario_id()+","+preferencia.getPreferencia_categoria_id()+","+preferencia.getPreferencia_estado_id()+",'"+preferencia.getPreferencia_senha()+"',true)";
				sql_perfil = "insert into cadastro_perfil (cadastro_id, perfil_id) values ("+preferencia.getPreferencia_codigo()+",4)";
			}
			System.out.println(sql_str);
			sq_stmt.executeUpdate(sql_str);
			if(quantidadeCadastro == 0){
				sq_stmt.executeUpdate(sql_perfil);
			}
			} catch (SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
		}
	}
	
	
	/*
	 * Incluir Currículo para consultar pela WEB
	 */
	public void incluirCurriculo(Preferencia preferencia, Curriculo curriculo){
		Integer codigo_cadastro = 0;
		String sql_str = null;
		try {
			Statement sq_stmt = this.connection.createStatement();
			//Date dataCadastro = this.getDataAtual();
			String sql_codigo = "select cadastro_id as cadastro_codigo from cadastro where cadastro_cpf = '"+preferencia.getPreferencia_cpf()+"'";
			ResultSet rs_cadastro = sq_stmt.executeQuery(sql_codigo);
			rs_cadastro.next();
			codigo_cadastro = rs_cadastro.getInt("cadastro_codigo");
			curriculo.setCurriculo_data_inclusao(this.getDataAtual());
			if(codigo_cadastro > 0){
				System.out.println("Update");
				sql_str = "update curriculo set curriculo_arquivo='"+curriculo.getCurriculo_arquivo()+"', curriculo_data='"+curriculo.getCurriculo_data_inclusao()+"',curriculo_descricao='"+curriculo.getCurriculo_descricao()+"'  where cadastro_id = "+codigo_cadastro+"";
			}
			else{
				System.out.println("Insert");
				curriculo.setCurriculo_codigo(this.ultimoRegistroCurriculo());
				//codigo_cadastro_proximo = this.ultimoRegistroCadastro();
				sql_str = "insert into curriculo values ("+curriculo.getCurriculo_codigo()+",'"+curriculo.getCurriculo_arquivo()+"','"+curriculo.getCurriculo_data_inclusao()+"','"+curriculo.getCurriculo_descricao()+"',"+codigo_cadastro+")";
			}
			sq_stmt.executeUpdate(sql_str);
			} catch (SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
		}
	}
	
	/*
	 * Retorna ID do Pre-Cadastro
	 */
	public Integer idCadastro(Preferencia preferencia){
		Integer codigo_cadastro = null;
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_id_cadastro = "select cadastro_id as cadastro_codigo from cadastro where cadastro_cpf = '"+preferencia.getPreferencia_cpf()+"'";
			ResultSet rs_cadastro = sq_stmt.executeQuery(sql_id_cadastro);
			rs_cadastro.next();
			codigo_cadastro = (rs_cadastro.getInt("cadastro_codigo"));
		} catch (SQLException e) {
			System.out.println("Fail... Ultimo Registro Cadastro");
			e.printStackTrace();
		}
		return codigo_cadastro;
	}
	/*
	 * Retorna ultimo ID de Pré-Cadastro
	 */
	public Integer ultimoRegistroCadastro(){
		Integer codigo_cadastro_proximo = null;
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_max_id_cadastro = "select MAX(cadastro_id) as codigo_cadastro from cadastro";
			ResultSet rs_cadastro = sq_stmt.executeQuery(sql_max_id_cadastro);
			rs_cadastro.next();
			codigo_cadastro_proximo = (rs_cadastro.getInt("codigo_cadastro")+1);
		} catch (SQLException e) {
			System.out.println("Fail... Ultimo Registro Cadastro");
			e.printStackTrace();
		}
		System.out.println(codigo_cadastro_proximo);
		return codigo_cadastro_proximo;
	}
	
	/*
	 * Retorna ultimo ID de Currículo
	 */
	public Integer ultimoRegistroCurriculo(){
		Integer codigo_curriculo_proximo = null;
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_max_id_curriculo = "select MAX(curriculo_id) as codigo_curriculo from curriculo";
			ResultSet rs_curriculo = sq_stmt.executeQuery(sql_max_id_curriculo);
			rs_curriculo.next();
			codigo_curriculo_proximo = (rs_curriculo.getInt("codigo_curriculo")+1);
		} catch (SQLException e) {
			System.out.println("Fail... Ultimo Registro Curriculo");
			e.printStackTrace();
		}
		return codigo_curriculo_proximo;
	}
	
	
	/*
	 * Metodo para listar Formação
	 */
	public String listarFormacaoXML(){
		String retorno = "";
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_str = "select f.formacao_id as codigo, f.formacao_descricao as descricao from formacao f order by f.formacao_id asc";
			ResultSet rs = sq_stmt.executeQuery(sql_str);
			retorno += "<formacoes>";
			while (rs.next()) {
				retorno +="<formacao_item>";
				retorno += "<formacao_codigo>" + rs.getString("codigo") + "</formacao_codigo>";
				retorno += "<formacao_descricao>" + rs.getString("descricao") + "</formacao_descricao>";
				retorno += "</formacao_item>";
			}
			retorno += "</formacoes>";
			System.out.println(retorno);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return retorno;
	}
	
	/*
	 * Metodo para listar Faixa Salarial
	 */
	public String listarSalarioXML(){
		String retorno = "";
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_str = "select s.salario_id as codigo, s.salario_descricao as descricao from salario s order by s.salario_id asc";
			ResultSet rs = sq_stmt.executeQuery(sql_str);
			retorno += "<salarios>";
			while (rs.next()) {
				retorno +="<salario_item>";
				retorno += "<salario_codigo>" + rs.getString("codigo") + "</salario_codigo>";
				retorno += "<salario_descricao>" + rs.getString("descricao") + "</salario_descricao>";
				retorno += "</salario_item>";
			}
			retorno += "</salarios>";
			System.out.println(retorno);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return retorno;
	}
	
		
	/*
	 * Metodo para listar Estados
	 */
	public String listarEstadoXML(){
		String retorno = "";
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_str = "select e.estado_id as codigo, e.estado_descricao as descricao, e.estado_sigla as uf from estado e order by e.estado_descricao asc";
			ResultSet rs = sq_stmt.executeQuery(sql_str);
			retorno += "<estados>";
			while (rs.next()) {
				retorno +="<estado_item>";
				retorno += "<estado_codigo>" + rs.getString("codigo") + "</estado_codigo>";
				retorno += "<estado_descricao>" + rs.getString("descricao") + "</estado_descricao>";
				retorno += "<estado_sigla>" + rs.getString("uf") + "</estado_sigla>";
				retorno += "</estado_item>";
			}
			retorno += "</estados>";
			System.out.println(retorno);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return retorno;
	}
	
	/*
	 * Metodo para listar Categorias
	 */
	public String listarCategoriaXML(){
		String retorno = "";
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_str = "select c.categoria_id as codigo, c.categoria_descricao as descricao, c.categoria_status as status from categoria c order by c.categoria_descricao asc";
			ResultSet rs = sq_stmt.executeQuery(sql_str);
			retorno += "<categorias>";
			while (rs.next()) {
				retorno +="<categoria_item>";
				retorno += "<categoria_codigo>" + rs.getString("codigo") + "</categoria_codigo>";
				retorno += "<categoria_descricao>" + rs.getString("descricao") + "</categoria_descricao>";
				retorno += "<categoria_status>" + rs.getString("status") + "</categoria_status>";
				retorno += "</categoria_item>";
			}
			retorno += "</categorias>";
			System.out.println(retorno);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return retorno;
	}
	
	/*
	 * Metodo para listar Vaga
	 */
	public String listarVagaXML(){
		String retorno = "";
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_str = "select v.vaga_id as codigo, v.vaga_descricao as descricao, v.vaga_status as status from vaga v order by vaga_id asc";
			ResultSet rs = sq_stmt.executeQuery(sql_str);
			retorno += "<vagas>";
			while (rs.next()) {
				retorno +="<vaga_item>";
				retorno += "<vaga_codigo>" + rs.getString("codigo") + "</vaga_codigo>";
				retorno += "<vaga_descricao>" + rs.getString("descricao") + "</vaga_descricao>";
				retorno += "<vaga_status>" + rs.getString("status") + "</vaga_status>";
				retorno += "</vaga_item>";
			}
			retorno += "</vagas>";
			System.out.println(retorno);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return retorno;
	}
	
	/*
	 * Metodo para listar Config. E-mail
	 */
	public String listarConfigEmailXML(){
		String retorno = "";
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_str = "select e.email_id as codigo, e.email_smtp as smtp, e.email_email as email, e.email_senha as senha, e.email_porta as porta, e.email_auth as autenticacao, e.email_tls as tls from email e order by e.email_id asc";
			ResultSet rs = sq_stmt.executeQuery(sql_str);
			retorno += "<email>";
			while (rs.next()) {
				retorno +="<email_item>";
				retorno += "<email_codigo>" + rs.getString("codigo") + "</email_codigo>";
				retorno += "<email_smtp>" + rs.getString("smtp") + "</email_smtp>";
				retorno += "<email_email>" + rs.getString("email") + "</email_email>";
				retorno += "<email_senha>" + rs.getString("senha") + "</email_senha>";
				retorno += "<email_porta>" + rs.getString("porta") + "</email_porta>";
				retorno += "<email_auth>" + rs.getString("autenticacao") + "</email_auth>";
				retorno += "<email_tls>" + rs.getString("tls") + "</email_tls>";
				retorno += "</email_item>";
			}
			retorno += "</email>";
			System.out.println(retorno);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return retorno;
	}
	
	
	/*
	 * Metodo para Resumo por Estado
	 */
	public String listarResumoXML(){
		String retorno = "";
		dataLimite = this.getPegaDataAtual(periodo);
		try {
			Statement sq_stmt = this.connection.createStatement();
			String sql_str = "select count(*) as total_oportunidade, e.estado_id as codigo_estado, e.estado_descricao as descricao_estado from oportunidade o, estado e where e.estado_id = o.estado_id and o.oportunidade_data > '"+dataLimite+"' and o.oportunidade_status = true group by e.estado_descricao, e.estado_id order by e.estado_descricao asc";
			ResultSet rs = sq_stmt.executeQuery(sql_str);
			retorno += "<resumo>";
			while (rs.next()) {
				retorno +="<resumo_item>";
				retorno +="<resumo_estado_codigo>" +rs.getString("codigo_estado") + "</resumo_estado_codigo>";
				retorno +="<resumo_estado>" +rs.getString("descricao_estado") + "</resumo_estado>";
				retorno +="<resumo_quantidade>" +rs.getString("total_oportunidade") + "</resumo_quantidade>";
				retorno += "</resumo_item>";
			}
			retorno += "</resumo>";
		System.out.println(retorno);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return retorno;
	}

	/*
	 * Define qual filtro a ser aplicado 
	 */
	public String listarOportunidadeXML(Integer estadoCodigo, Integer categoriaCodigo, Integer vagaCodigo, Integer flag){
		String retorno = "";
		String select_tmp = "select o.oportunidade_id as codigo, cd.cidade_descricao as cidade, emp.empresa_email as contato, emp.empresa_site as site, o.oportunidade_data as dt_incluso, o.oportunidade_descricao as descricao, o.oportunidade_fone as telefone, c.categoria_descricao as categoria, e.estado_descricao as estado, f.funcao_descricao as funcao, emp.empresa_divulgar as divulgar, v.vaga_id as vaga_codigo, v.vaga_descricao as vaga_descricao, fo.formacao_descricao as formacao, s.salario_descricao as salario ";
		String from_tmp = "from oportunidade o, estado e, categoria c, cidade cd, empresa emp, funcao f, vaga v, formacao fo, salario s ";
		String where_tmp = "where o.oportunidade_status = true and e.estado_id = o.estado_id and c.categoria_id = o.categoria_id and cd.cidade_id = o.cidade_id and emp.empresa_id = o.empresa_id and o.funcao_id = f.funcao_id and v.vaga_id = o.vaga_id and o.formacao_id = fo.formacao_id and o.salario_id = s.salario_id";
		String order_by_tmp = " order by o.oportunidade_data, o.vaga_id desc";
		String sql_str = "";
		if ((categoriaCodigo != 0) && flag == 1){
			where_tmp += " and o.categoria_id ="+categoriaCodigo; 
			 System.out.println("Filtro por CATEGORIA na activity Buscar");
		}
		if ((estadoCodigo != 0) && flag == 1){
			where_tmp += " and o.estado_id = " +estadoCodigo;
			System.out.println("Filtro por ESTADO na activity Buscar");
		}
		if ((vagaCodigo != 0) && flag == 1){
			where_tmp += " and o.vaga_id ="+vagaCodigo;  
			System.out.println("Filtro por VAGA na activity Buscar");
		}
		if ((estadoCodigo != 0 && categoriaCodigo == 0) && flag == 2){
			dataLimite = this.getPegaDataAtual(periodo);
			where_tmp += " and o.oportunidade_data > '"+dataLimite+"'"; 
			System.out.println("Filtro por Estado na activity Resumo");
		}
		if ((vagaCodigo == 0 && categoriaCodigo == 0 && estadoCodigo == 0) && flag == 1){
				System.out.println("Nenhum filtro aplicado");
		}
		sql_str = select_tmp + from_tmp + where_tmp + order_by_tmp;
		retorno = this.listarOportunidadeXML(sql_str);
		System.out.println(retorno);
		return retorno;
	}
	
	/*
	 * Listar Oportunidade por Estado e/ou Categoria
	 */
	public String listarOportunidadeXML(String sql_str){
		String retorno = "";
		String codigoTmp;
		Statement sq_stmt, sq_stmt_b, sq_stmt_i, sq_stmt_s; 
		ResultSet rs, rs_b, rs_i, rs_s;
		String sql_str_b = "select b.beneficio_descricao as beneficio from oportunidade_beneficio ob, beneficio b where ob.beneficio_id=b.beneficio_id and ob.oportunidade_id =";
		String sql_str_i = "select i.idioma_descricao as idioma, n.nivel_descricao as nivel from oportunidade_combinacao_idioma oci, idioma i, nivel n, combinacao_idioma ci where oci.combinacoes_idiomas_combinacao_idioma_id = ci.combinacao_idioma_id and ci.idioma_id = i.idioma_id and ci.nivel_id = n.nivel_id and oci.oportunidade_oportunidade_id = ";
		String sql_str_s = "select s.software_descricao as software, n.nivel_descricao as nivel from oportunidade_combinacao_software ocs, software s, nivel n, combinacao_software cs where ocs.combinacoes_softwares_combinacao_software_id = cs.combinacao_software_id and cs.software_id = s.software_id and cs.nivel_id = n.nivel_id and ocs.oportunidade_oportunidade_id = ";
		try {
			sq_stmt = this.connection.createStatement();
			sq_stmt_b = this.connection.createStatement();
			sq_stmt_i = this.connection.createStatement();
			sq_stmt_s = this.connection.createStatement();
			rs = sq_stmt.executeQuery(sql_str);
			retorno += "<oportunidades>";
			while (rs.next()) {
				retorno +="<oportunidade_item>";
				retorno += "<oportunidade_codigo>" + rs.getString("codigo") + "</oportunidade_codigo>";
				retorno += "<oportunidade_cidade>" + rs.getString("cidade") + "</oportunidade_cidade>";
				retorno += "<oportunidade_contato>" + rs.getString("contato") + "</oportunidade_contato>";
				retorno += "<oportunidade_site>" + rs.getString("site") + "</oportunidade_site>";
				retorno += "<oportunidade_data>" + rs.getString("dt_incluso") + "</oportunidade_data>";
				retorno += "<oportunidade_descricao>" + rs.getString("descricao") + "</oportunidade_descricao>";
				retorno += "<oportunidade_fone>" + rs.getString("telefone") + "</oportunidade_fone>";
				retorno += "<oportunidade_categoria>" + rs.getString("categoria") + "</oportunidade_categoria>";
				retorno += "<oportunidade_estado>" + rs.getString("estado") + "</oportunidade_estado>";
				retorno += "<oportunidade_funcao>" + rs.getString("funcao") + "</oportunidade_funcao>";
				retorno += "<oportunidade_divulgar>" + rs.getString("divulgar") + "</oportunidade_divulgar>";
				retorno += "<oportunidade_vaga_codigo>" + rs.getString("vaga_codigo") + "</oportunidade_vaga_codigo>";
				retorno += "<oportunidade_vaga_descricao>" + rs.getString("vaga_descricao") + "</oportunidade_vaga_descricao>";
				retorno += "<oportunidade_formacao>" + rs.getString("formacao") + "</oportunidade_formacao>";
				retorno += "<oportunidade_salario>" + rs.getString("salario") + "</oportunidade_salario>";
				retorno += "</oportunidade_item>";
				codigoTmp = rs.getString("codigo");
				rs_b = sq_stmt_b.executeQuery(sql_str_b + codigoTmp);
				
				while (rs_b.next()) {
					retorno +="<oportunidade_beneficio_item>";
					retorno += "<oportunidade_beneficio_descricao>" + rs_b.getString("beneficio") + "</oportunidade_beneficio_descricao>";
					retorno += "</oportunidade_beneficio_item>";
				}
				
				rs_i = sq_stmt_i.executeQuery(sql_str_i + codigoTmp);
				
				while (rs_i.next()) {
					retorno +="<oportunidade_idioma_item>";
					retorno += "<oportunidade_idioma_descricao>" + rs_i.getString("idioma") + "-" + rs_i.getString("nivel") + "</oportunidade_idioma_descricao>";
					retorno += "</oportunidade_idioma_item>";
				}
				
				rs_s = sq_stmt_s.executeQuery(sql_str_s + codigoTmp);
				
				while (rs_s.next()) {
					retorno +="<oportunidade_software_item>";
					retorno += "<oportunidade_software_descricao>" + rs_s.getString("software") + "-" + rs_s.getString("nivel") + "</oportunidade_software_descricao>";
					retorno += "</oportunidade_software_item>";
				}
				
			
			}
			retorno += "</oportunidades>";
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return retorno;
	}
	
	@SuppressWarnings("deprecation")
	public Date getPegaDataAtual(Integer periodoTmp) {
		Date data = new Date(System.currentTimeMillis());
		data.setDate(data.getDate()- periodoTmp);
		return data;
	}
	
	public Date getDataAtual() {
		Date data = new Date(System.currentTimeMillis());
		return data;
	}

}
