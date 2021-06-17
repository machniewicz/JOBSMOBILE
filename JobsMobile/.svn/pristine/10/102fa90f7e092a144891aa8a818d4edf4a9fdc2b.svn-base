
package br.com.jobs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import br.com.jobs.util.Controle;

public class EscolhaActivity extends Activity {

	private TextView txtInternet;
	private Boolean acessoInternet;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_escolha_curriculo);
		 txtInternet = (TextView) findViewById(R.id.tvRodape);
		 txtInternet.setText(Controle.VerificaConexao(this));
		 acessoInternet = Controle.getInternetAcesso();
		
	}

	public void onClickSincronizacao(View v) {
		if(acessoInternet){
			Intent inSincronizar = new Intent(this,SincronizarActivity.class);
			startActivity(inSincronizar);
		}
		else{
			Controle.MensangensInternet(this);
		}
	}

	public void onClickCadastroDados(View v){
		if(acessoInternet){
			Intent inConfiguracoes = new Intent(this, ConfiguracoesActivity.class);
			startActivity(inConfiguracoes);
		}
		else{
			Controle.MensangensInternet(this);
		}
		
		
	}
	
	public void onClickVoltar(View v){
		Controle.Voltar(this);
	}
		
}
