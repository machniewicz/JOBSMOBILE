
package br.com.jobs;

import java.util.ArrayList;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import br.com.jobs.broadcast.IniciarNotificacao;
import br.com.jobs.dao.ProvedorDAOImpl;
import br.com.jobs.modelo.Provedor;
import br.com.jobs.util.Controle;

public class PrincipalActivity extends Activity {

	private TextView txtInternet;
	private Boolean acessoInternet;
	private ProvedorDAOImpl Provedordb;
	private ArrayList<Provedor> provedores;
	
	/*
	 * Verifica se já esta em execução o serviço VERIFICA_NOTIFICACAO
	 */
			
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 boolean alarmeAtivo = (PendingIntent.getService(this, 0, new Intent("VERIFICA_NOTIFICACAO"), PendingIntent.FLAG_NO_CREATE) == null);
		 setContentView(R.layout.activity_principal);
		 txtInternet = (TextView) findViewById(R.id.tvRodape);
		 txtInternet.setText(Controle.VerificaConexao(this));
		 acessoInternet = Controle.getInternetAcesso();
		 
		 /*
		  * Inicia serviço ao abrir Jobs Mobile
		  */
		 	if(alarmeAtivo){
		 		IniciarNotificacao in = new IniciarNotificacao();
		 		in.agendar(this);
		  	}
		 	else{Log.i("AlarmeAtivo", "Já ativo: "+alarmeAtivo);}
	}

	public void onClickOportunidade(View v) {
		if(acessoInternet){
			Intent inOportunidade = new Intent(this,BuscarActivity.class);
			startActivity(inOportunidade);
		}
		else{
			Controle.MensangensInternet(this);
		}
	}

	public void onClickSobre(View v) {
		Intent inSobre = new Intent(this,SobreActivity.class);
		startActivity(inSobre);
	}
	
	public void onClickHistorico(View v) {
		Intent inHistorico = new Intent(this,HistoricoActivity.class);
		startActivity(inHistorico);
	}
	
	public void onClickEmail(View v){
		Intent inEscolha = new Intent(this, EscolhaActivity.class);
		startActivity(inEscolha);
	}
	
	public void onClickResumo(View v) {
		if(acessoInternet){
			Intent inResumo = new Intent(this,ResumoActivity.class);
			startActivity(inResumo);
		}
		else{
			Controle.MensangensInternet(this);
		}
	}

	public void onClickSair(View v){
		Controle.Mensangens(this);
	}
	
	public void popular_provedores() {
		Provedordb = new ProvedorDAOImpl(this);
		provedores = new ArrayList<Provedor>();
		provedores.clear();
		provedores = (ArrayList<Provedor>) Provedordb.carregaProvedor();
		if(provedores.isEmpty()){
			Provedordb.inserirDados();
		}
		
	}
}
