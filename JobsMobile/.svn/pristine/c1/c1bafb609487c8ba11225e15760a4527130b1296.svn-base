package br.com.jobs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import br.com.jobs.util.Controle;
import br.com.jobs.ws.Webservice;
import br.com.jobs.xml.XMLParser;

public class ResumoActivity extends ListActivity{

	private Integer layout;
	private Integer flagActivity = 2;
	private TextView txtRodape;
	private int label[] = { R.id.lbl_descricao_estado, R.id.lbl_total_oportunidade };
	private String[] campos = { KEY_RESUMO_ESTADO, KEY_RESUMO_QUANTIDADE };
	private static ArrayList<HashMap<String, String>> lstResumo;
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");

	static final String KEY_RESUMO = "resumo_item";
	static final String KEY_RESUMO_ESTADO_CODIGO = "resumo_estado_codigo";
	static final String KEY_RESUMO_ESTADO = "resumo_estado";
	static final String KEY_RESUMO_QUANTIDADE = "resumo_quantidade";

	private Webservice ws;
	private String xmlResumo;
	private ListAdapter adapter;
	private Thread thread;
	private Integer codigoEstado;

	private ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resumo);
		layout = R.layout.lista_resumo_customizado;
		txtRodape = (TextView) findViewById(R.id.tvRodape);
		txtRodape.setText(R.string.activity_resumo);
		ws = new Webservice();
		carregar_resumo();
	}

	public void onClickVoltar(View v) {
		Controle.Voltar(this);
	}

	public void carregar_resumo() {
		pd = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_dialog_titulo_resumo"), true, false);
		thread = new Thread() {
			@Override
			public void run() {
				try {
					xmlResumo = ws.consultarInformacoesResumo();
					Message msg = new Message();
					msg.obj = xmlResumo;
					handler.sendMessage(msg);
					Log.i("XML", xmlResumo);
				} catch (Exception e) {
					pd.dismiss();
					System.out.println("Erro!!: " + e.getMessage());
				}
			}
		};
		thread.start();
	}

	public void montarXMLResumo(String xml) {
		lstResumo = new ArrayList<HashMap<String, String>>();
		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xml);
		NodeList nl = doc.getElementsByTagName(KEY_RESUMO);
		for (int i = 0; i < nl.getLength(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			Element e = (Element) nl.item(i);
			map.put(KEY_RESUMO_ESTADO_CODIGO, parser.getValue(e, KEY_RESUMO_ESTADO_CODIGO));
			map.put(KEY_RESUMO_ESTADO, parser.getValue(e, KEY_RESUMO_ESTADO));
			map.put(KEY_RESUMO_QUANTIDADE, bundle.getString("lbl_quantidade")+" "+parser.getValue(e, KEY_RESUMO_QUANTIDADE));
			lstResumo.add(map);
		}
		if (lstResumo.size() == 0){
			pd.dismiss();
			Intent inVazio = new Intent(this,VazioActivity.class);
			startActivity(inVazio);
			Controle.Voltar(this);
		}
		else{
			adapter = new SimpleAdapter(this, lstResumo, layout, campos, label);
			setListAdapter(adapter);
			pd.dismiss();
		}
	}
	
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLResumo(xmlResumo);
			Log.i("XML", xmlResumo);
		}
	};

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		super.onListItemClick(l, v, position, id);
		codigoEstado =  Integer.parseInt(lstResumo.get(position).get(KEY_RESUMO_ESTADO_CODIGO)) ;
		Intent inOportunidade = new Intent(this,OportunidadeActivity.class);
		inOportunidade.putExtra("codigoEstado", codigoEstado);
		inOportunidade.putExtra("flagActivity", flagActivity);
		startActivity(inOportunidade);

	}
}
