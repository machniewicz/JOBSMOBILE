package br.com.jobs.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;


@Component("dataSource")
public class Conexao extends DriverManagerDataSource {
	/*
	 *Conexao com Postgres 9 */ 
	 
	public Conexao(){
		/* Conexao rede TESTE   
		this.setDriverClassName("org.postgresql.Driver");
		this.setUrl("jdbc:postgresql://192.168.0.96:5432/JobsMobileTeste");
		this.setUsername("postgres");
		this.setPassword("@gfen1br");
		*/ 
		
		/* Conexao rede    
		this.setDriverClassName("org.postgresql.Driver");
		this.setUrl("jdbc:postgresql://192.168.0.96:5432/JobsMobile");
		this.setUsername("postgres");
		this.setPassword("@gfen1br");
		*/
		
		/* Conex�o Local */  
			this.setDriverClassName("org.postgresql.Driver");
		  	this.setUrl("jdbc:postgresql://localhost:5432/jobsmobile");
		 	this.setUsername("postgres");
		 	this.setPassword("N@lson1br");
		 	
		
		/* Conex�o Cloud                
			this.setDriverClassName("org.postgresql.Driver");
		  	this.setUrl("jdbc:postgresql://localhost:5432/usoluc_jobsmobile");
		 	this.setUsername("usoluc");
		 	this.setPassword("uSL4usol1br");
		  */
		
		/* Conex�o Cloud Teste             
			this.setDriverClassName("org.postgresql.Driver");
		  	this.setUrl("jdbc:postgresql://localhost:5432/usoluc_jobsmobile_teste");
		 	this.setUsername("usoluc_jobs");
		 	this.setPassword("@jobs1br");
		*/
	}
	
	/*
	 * Conexão com SQL Server 2008  
	 
	public Conexao(){
		this.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		this.setUrl("jdbc:sqlserver://srv-sql:1433;databaseName=JobsMobile;instanceName=NMCZ;");
		this.setUsername("java");
		this.setPassword("N@lson1br");
	}
	*/
	
}
