package br.com.jobs.relatorio;

import br.com.jobs.web.controle.UsuarioMB;

 
public class TestMain 
{
	public static void main(String[] args)
	{
		try{
			UsuarioMB us = new UsuarioMB();			
			Relatorio relatorio = new Relatorio();
			relatorio.imprimir(us.listarTodosUsuarios());
		}
		catch(Exception e){
			System.out.println(e.getMessage()+ "erro");
		}
		
	}
}
