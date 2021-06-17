package br.com.jobs.mobile;

import br.com.jobs.mobile.modelo.Curriculo;
import br.com.jobs.mobile.modelo.Enviado;
import br.com.jobs.mobile.modelo.Preferencia;

public class Controle {

	private String saida;
	
	public String listaPreferencia(String login, String senha){
		MontaXML info = new MontaXML();
		saida = info.sincronizarDados(login, senha);
		return saida;
	}
	
	public String listaEstado(){
		MontaXML info = new MontaXML();
		saida = info.listarEstadoXML();
		return saida;
	}
	
	public String listaFormacao(){
		MontaXML info = new MontaXML();
		saida = info.listarFormacaoXML();
		return saida;
	}
	
	public String listaSalario(){
		MontaXML info = new MontaXML();
		saida = info.listarSalarioXML();
		return saida;
	}
	
	public String listaCategoria(){
		MontaXML info = new MontaXML();
		saida = info.listarCategoriaXML();
		return saida;
	}
	
	public String listaVaga(){
		MontaXML info = new MontaXML();
		saida = info.listarVagaXML();
		return saida;
	}
	
	public String listaResumo(){
		MontaXML info = new MontaXML();
		saida = info.listarResumoXML();
		return saida;
	}
	
	public String listaOportunidade(Integer estadoID, Integer categoriaID, Integer vagaID, Integer flag){
		MontaXML info = new MontaXML();
		saida = info.listarOportunidadeXML(estadoID, categoriaID,vagaID, flag);
		return saida;
		
	}
	
	public String listaConfiguracaoEmail(){
		MontaXML info = new MontaXML();
		saida = info.listarConfigEmailXML();
		return saida;
	}
	
	public void atualizarEstatitisca(Enviado enviado, Preferencia preferencia){
		MontaXML info = new MontaXML();
		info.incluirEstatistica(enviado, preferencia);
	}
	
	public void atualizarPrecadastro(Preferencia preferencia){
		MontaXML info = new MontaXML();
		info.incluirPreCadastro(preferencia);
	} 
	
	public void atualizarCurriculo(Preferencia preferencia, Curriculo curriculo){
		MontaXML info = new MontaXML();
		info.incluirCurriculo(preferencia, curriculo);
	} 
	
	public String listaNotificacao(){
		MontaXML info = new MontaXML();
		saida = info.listaNotificacaoXML();
		return saida;
	}
	
}
