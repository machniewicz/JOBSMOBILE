package br.com.jobs;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.http.util.ByteArrayBuffer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.jobs.dao.CurriculoDAOImpl;
import br.com.jobs.modelo.Curriculo;
import br.com.jobs.modelo.Preferencia;
import br.com.jobs.util.Controle;
import br.com.jobs.ws.Webservice;

public class CurriculoActivity extends Activity {

	private TextView txtRodape;
	private TextView txtAnexoStatus;
	private TextView txtArquivoDescricao;
	private TextView txtArquivoLabel;
	private EditText dataCurriculo;
	private ImageView imgAnexoStatus;
	
	private String caminhoArquivo;
	private String descricaoArquivo;

	private CurriculoDAOImpl curriculoDB;
	private Curriculo c;
	private Curriculo curriculo = null;
	private Preferencia preferencia;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");
	
	private CurriculoTask taskCurriculo = null;

	private Webservice ws;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_curriculo);
		txtRodape = (TextView) findViewById(R.id.tvRodape);
		txtAnexoStatus = (TextView) findViewById(R.id.txtAnexoStatus);
		dataCurriculo = (EditText) findViewById(R.id.txtCurriculoData);
		imgAnexoStatus = (ImageView) findViewById(R.id.ivAnexarStatus);
		txtArquivoLabel = (TextView) findViewById(R.id.txtArquivoLabel);
		txtArquivoDescricao = (TextView) findViewById(R.id.txtArquivoDescricao);
		txtRodape.setText(R.string.activity_curriculo);
		curriculoDB = new CurriculoDAOImpl(this);
		ws = new Webservice();
		c = new Curriculo();
		c = curriculoDB.detalhesCurriculo();
		preferencia = (Preferencia) getIntent().getSerializableExtra("objPreferencia");
		if (c.getCurriculo_codigo() > 0) {
			carregaCurriculoAtual(c);
		} else {
			dataCurriculo.setText(this.dataAtual());
		}
	}

	public void onClickVoltar(View v) {
		Controle.Voltar(this);
	}
	
	public void onClickInformacaoAnexo(View v) {
		Intent inInfo = new Intent(this, InfoActivity.class);
		startActivity(inInfo);
	}

	public void onClickAnexar(View v) {
		Intent inAnexar = new Intent(this,BuscarArquivoActivity.class);
		inAnexar.putExtra("objPreferencia", preferencia);
		startActivity(inAnexar);
		Controle.Voltar(this);
	}

	public void onClickConfirmarCurriculo(View v) throws IOException {
		caminhoArquivo = (String) getIntent().getSerializableExtra("caminhoArquivo");
		descricaoArquivo = (String) getIntent().getSerializableExtra("descricaoArquivo");
		if (dataCurriculo.length() > 0 && caminhoArquivo.length() > 0 && descricaoArquivo.length() > 0){
			//Curriculo curriculo = null;
			if (this.c != null){
				curriculo = this.c;
			}else{ 
				curriculo = new Curriculo();
			}
			curriculo.setCurriculo_data_inclusao(dataCurriculo.getText().toString());
			curriculo.setCurriculo_descricao(descricaoArquivo);
			curriculo.setCurriculo_arquivo(arquivo(caminhoArquivo));
			
			CurriculoDAOImpl db = new CurriculoDAOImpl(this);
			
			if(curriculo.getCurriculo_codigo() > 0){
				db.atualizar(curriculo);
				Controle.ExibeToast(bundle.getString("msg_preferencia_alterar"), this);
			}else{
				db.salvar(curriculo);
				Controle.ExibeToast(bundle.getString("msg_preferencia_incluir"), this);
			}
			//preferencia = (Preferencia) getIntent().getSerializableExtra("objPreferencia");
			this.atualizarCurriculo();
			this.finish();
		}
		else{
			Controle.ExibeToast(bundle.getString("lbl_alert_dialog_mensagem_em_branco"), this);
		}
	}

	public void onClickExcluirCurriculo(View v) {
		Curriculo curriculo = this.c;
		if (curriculo.getCurriculo_codigo() <= 0){
		 Controle.ExibeToast(bundle.getString("msg_preferencia_excluir_falha"), this);
		 }
		 else{
			 MensangensExcluir(this, curriculo);
		 }
	}

	@SuppressLint("SimpleDateFormat")
	public String dataAtual() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(new Date());
	}

	public void verificaCurriculo(Curriculo c) {
		if (c.getCurriculo_codigo() > 0) {
			carregaCurriculoAtual(c);
		} else {
			dataCurriculo.setText(this.dataAtual());
		}
	}
	
	public void carregaCurriculoAtual(Curriculo c) {
		Resources res = getResources();
		this.txtAnexoStatus.setText(bundle.getString("msg_curriculo_status"));
		this.txtArquivoLabel.setText(bundle.getString("lbl_curriculo_label"));
		this.imgAnexoStatus.setImageDrawable(res.getDrawable(R.drawable.anexo_up));
		this.dataCurriculo.setText(c.getCurriculo_data_inclusao());
		this.txtArquivoDescricao.setText(c.getCurriculo_descricao());
	}

	public void MensangensExcluir(final Activity ac, final Curriculo curr) {
		AlertDialog.Builder builder = new AlertDialog.Builder(ac);
		builder.setTitle(bundle.getString("lbl_alert_dialog_titulo_excluir"))
				.setMessage(
						bundle.getString("lbl_alert_dialog_mensagem_excluir"))
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton(bundle.getString("lbl_alert_dialog_sim"),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								CurriculoDAOImpl db = new CurriculoDAOImpl(ac);
								db.excluir(curr);
								ac.finish();
								Controle.ExibeToast(bundle.getString("msg_preferencia_excluir"), ac);
							}
						})
				.setNegativeButton(bundle.getString("lbl_alert_dialog_nao"),null).show();
	}
	
	
	
	@SuppressWarnings("resource")
	public byte[] arquivo(String caminho) throws IOException{
		
		File file = new File(caminho);
		BufferedInputStream bufferedInputStream;
		int current = 0;
		bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 128);
		// Cria um novo byteArray e realiza a leitura dos bytes do
		// BufferedInputStream, para a criacao do mesmo, que sera salvo no banco
		ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(128);
		while ((current = bufferedInputStream.read()) != -1) {
			byteArrayBuffer.append((byte) current);
			}
		return byteArrayBuffer.toByteArray();
		
	}
	
	public void atualizarCurriculo(){
		taskCurriculo = new CurriculoTask();
		taskCurriculo.execute();
	}
	
	/*
	 * Curriculo via WS
	 */
			class CurriculoTask extends AsyncTask<String, Void, String> {
				String retorno;
				protected void onPreExecute() {};
				
				@Override
				protected String doInBackground(String... params) {
				try {
						ws.gravarInformacoesCurriculo(preferencia, curriculo);
						retorno = "1";
						Log.i("Preferencia", preferencia.getPreferencia_cpf());
						//Log.i("Preferencia", "999>"+curriculo.getCurriculo_arquivo());
					} catch (Exception e) {
						retorno = "2";
					}
				return retorno;
				}
				@Override
				protected void onPostExecute(String result) {
					if (result.equals("2")){
						Controle.ExibeToast(bundle.getString("lbl_alert_dialog_mensagem_ws"), getApplicationContext());
					}
				}
			}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		curriculoDB.finalizaBanco();
	}
}

