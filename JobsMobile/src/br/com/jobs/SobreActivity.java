
package br.com.jobs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import br.com.jobs.util.Controle;

public class SobreActivity extends Activity {

	private TextView txtRodape;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_sobre);
		 txtRodape = (TextView) findViewById(R.id.tvRodape);
		 txtRodape.setText(R.string.activity_sobre);
	}

	public void onClickVoltar(View v){
		Controle.Voltar(this);
	}
	
}
