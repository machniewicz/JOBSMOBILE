
package br.com.jobs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import br.com.jobs.util.Controle;

public class VazioActivity extends Activity {

	private TextView txtInternet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_vazio);
		 txtInternet = (TextView) findViewById(R.id.tvRodape);
		 txtInternet.setText(Controle.VerificaConexao(this));		 
	}

	public void onClickVoltarAlerta(View v) {
		Controle.Voltar(this);
	}

	public void onClickVoltar(View v){
		Controle.Voltar(this);
	}
}
