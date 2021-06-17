
package br.com.jobs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import br.com.jobs.dao.CurriculoDAOImpl;
import br.com.jobs.dao.PreferenciaDAOImpl;
import br.com.jobs.modelo.Curriculo;
import br.com.jobs.modelo.Preferencia;
import br.com.jobs.util.Controle;
import br.com.jobs.util.Mask;
import br.com.jobs.ws.Webservice;
import br.com.jobs.xml.XMLParser;

public class SincronizarActivity extends Activity {

	private TextView txtRodape;
	private EditText sincronizarCpf;	
	private EditText sincronizarSenha;
	
	private PreferenciaDAOImpl Preferenciadb;
	private Preferencia preferencia = null;
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");
	
	private Webservice ws;
	private String xmlPreferencia;
	
	private PreferenciaTask taskPreferencia = null;
	
	private ProgressDialog pdPreferencia;
	
	private String senhaTmp;
	private String loginTmp;
	private String formato = "yyyy-MM-dd"; 
	private Date dateTmp;
		
	static final String KEY_PREFERENCIA = "preferencia_item";
	static final String KEY_PREFERENCIA_CODIGO = "preferencia_codigo";
	static final String KEY_PREFERENCIA_CPF = "preferencia_cpf";
	static final String KEY_PREFERENCIA_DATA = "preferencia_data";
	static final String KEY_PREFERENCIA_EMAIL = "preferencia_email";
	static final String KEY_PREFERENCIA_EXPERIENCIA = "preferencia_experiencia";
	static final String KEY_PREFERENCIA_NOME = "preferencia_nome";
	static final String KEY_PREFERENCIA_FORMACAO = "preferencia_formacao";
	static final String KEY_PREFERENCIA_SALARIO = "preferencia_salario";
	static final String KEY_PREFERENCIA_CATEGORIA = "preferencia_categoria";
	static final String KEY_PREFERENCIA_ESTADO = "preferencia_estado";
	static final String KEY_PREFERENCIA_SENHA = "preferencia_senha";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_sincronizar);
		 txtRodape = (TextView) findViewById(R.id.tvRodape);
		 sincronizarSenha = (EditText) findViewById(R.id.txtSenhaSincronizacao);
		 sincronizarCpf = (EditText) findViewById(R.id.txtCpfSincronizacao);
		 sincronizarCpf.addTextChangedListener(Mask.insert(Mask.CPF_MASK, sincronizarCpf));
		 txtRodape.setText(R.string.activity_sincronizacao); 
		 ws = new Webservice();
	}
	
	/*
	 * Metodos de acesso ao WS
	 */
	public void carregar_xmlPreferencia(){
		pdPreferencia = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_dialog_titulo_preferencia"), true, false);
		taskPreferencia = new PreferenciaTask();
		taskPreferencia.execute();
	}
	
	@SuppressLint("HandlerLeak")
	private Handler handlerPreferencia = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLPreferencia(xmlPreferencia);
			Log.i("XML", xmlPreferencia);
		}
	};
	
	@SuppressLint("SimpleDateFormat")
	public void montarXMLPreferencia(String xml) {
		String experienciaTmp = "", formacaoTmp = "", salarioTmp="", categoriaTmp="", estadoTmp="";
		if(!xml.equalsIgnoreCase("vazio")){
			XMLParser parser = new XMLParser();
			Document doc = parser.getDomElement(xml);
			NodeList nl = doc.getElementsByTagName(KEY_PREFERENCIA);
			for (int i = 0; i < nl.getLength(); i++) {
				preferencia = new Preferencia();
				Element e = (Element) nl.item(i);
				preferencia.setPreferencia_codigo(Integer.parseInt(parser.getValue(e, KEY_PREFERENCIA_CODIGO)));
				preferencia.setPreferencia_cpf(parser.getValue(e, KEY_PREFERENCIA_CPF));
				try {
					dateTmp = new SimpleDateFormat(formato).parse(parser.getValue(e, KEY_PREFERENCIA_DATA));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				preferencia.setPreferencia_data(dateTmp);
				preferencia.setPreferencia_email(parser.getValue(e,KEY_PREFERENCIA_EMAIL));
				preferencia.setPreferencia_nome(parser.getValue(e, KEY_PREFERENCIA_NOME ));
				
				experienciaTmp = parser.getValue(e, KEY_PREFERENCIA_EXPERIENCIA);
				formacaoTmp = parser.getValue(e, KEY_PREFERENCIA_FORMACAO);
				salarioTmp = parser.getValue(e, KEY_PREFERENCIA_SALARIO);
				categoriaTmp = parser.getValue(e, KEY_PREFERENCIA_CATEGORIA);
				estadoTmp = parser.getValue(e, KEY_PREFERENCIA_ESTADO);
				
				if (experienciaTmp.equals("null")){
					preferencia.setPreferencia_experiencia(0);
				}
				else{
					preferencia.setPreferencia_experiencia(Integer.parseInt(experienciaTmp));
				}
				
				if (formacaoTmp.equals("null")){
					preferencia.setPreferencia_formacao_id(0);
				}
				else{
					preferencia.setPreferencia_formacao_id(Integer.parseInt(formacaoTmp));
				}
				
				if (salarioTmp.equals("null")){
					preferencia.setPreferencia_salario_id(0);
				}
				else{
					preferencia.setPreferencia_salario_id(Integer.parseInt(salarioTmp));
				}
				
				if (categoriaTmp.equals("null")){
					preferencia.setPreferencia_categoria_id(0);
				}
				else{
					preferencia.setPreferencia_categoria_id(Integer.parseInt(categoriaTmp));
				}
				
				if (estadoTmp.equals("null")){
					preferencia.setPreferencia_estado_id(0);
				}
				else{
					preferencia.setPreferencia_estado_id(Integer.parseInt(estadoTmp));
				}
				
				preferencia.setPreferencia_senha(parser.getValue(e, KEY_PREFERENCIA_SENHA));
				pdPreferencia.dismiss();
				MensangensGravarPreferencia(this, preferencia);
				
			}
			
		}
		else{
			pdPreferencia.dismiss();
			Controle.ExibeToast(bundle.getString("lbl_preferencia_falha"),this);
			
		}
		
	}
	
	/*
	 * Valida e Carrega Preferencia via WS
	 */
			class PreferenciaTask extends AsyncTask<String, Void, String> {
				String retorno;
				protected void onPreExecute() {};
				
				@Override
				protected String doInBackground(String... params) {
				try {
						xmlPreferencia = ws.consultarInformacoesPreferencia(loginTmp, senhaTmp);
						Message msg = new Message();
						msg.obj = xmlPreferencia;
						handlerPreferencia.sendMessage(msg);
						Log.i("XML", xmlPreferencia);
						retorno = "1";
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

	/*
	 * Metodos para acesso ao BD SQLite
	 */
	public void gravaPreferenciaBD(Preferencia pre){
		Preferenciadb = new PreferenciaDAOImpl(this);
		Preferencia p = new Preferencia();
		p = Preferenciadb.detalhesPreferencia();
		if (p.getPreferencia_codigo() > 0) {
			Preferenciadb.atualizar(pre);
			Controle.ExibeToast(bundle.getString("msg_preferencia_alterar"), this);
		}else{
			Preferenciadb.salvar(pre);
			Controle.ExibeToast(bundle.getString("msg_preferencia_incluir"),this);
		}
			this.finish();
	}
		
	public void MensangensGravarPreferencia(final Activity ac, final Preferencia pre) {
		AlertDialog.Builder builder = new AlertDialog.Builder(ac);
		builder.setTitle(bundle.getString("lbl_preferencia_titulo_gravar"))
				.setMessage(bundle.getString("lbl_preferencia_msg_gravar"))
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton(bundle.getString("lbl_preferencia_sim"),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								PreferenciaDAOImpl db = new PreferenciaDAOImpl(ac);
								Preferencia p = new Preferencia();
								p = db.detalhesPreferencia();
								CurriculoDAOImpl curriculoDB = new CurriculoDAOImpl(ac);
								Curriculo curriculo = new Curriculo();
								curriculo = curriculoDB.detalhesCurriculo();
								if (curriculo.getCurriculo_codigo() > 0) {
									curriculoDB.excluir(curriculo);
								}								
								db.excluir(p);
								gravaPreferenciaBD(pre);
							}
						})
				.setNegativeButton(bundle.getString("lbl_preferencia_sim"),null).show();
	}
			
	/*
	 * Interação com Activity - Tela Sincronizar
	 */	
	public void onClickSincronizar(View v){
		loginTmp = sincronizarCpf.getText().toString();
		senhaTmp = sincronizarSenha.getText().toString();
		if(loginTmp.length() > 0 && senhaTmp.length() > 0){
			carregar_xmlPreferencia();
		//	Log.i("Resposta", ""+resposta);
		//	if(resposta == 1){
		//		MensangensGravarPreferencia(this);
		//	}
		}
		else{
			Controle.ExibeToast(bundle.getString("lbl_alert_dialog_mensagem_em_branco"), this);
		}
	}

	public void onClickVoltar(View v){
		Controle.Voltar(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (taskPreferencia != null ){
			taskPreferencia.cancel(true);
		}
	}
}
