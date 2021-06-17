package br.com.jobs;

import java.util.ArrayList;
import java.util.ResourceBundle;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import br.com.jobs.modelo.Categoria;
import br.com.jobs.modelo.Estado;
import br.com.jobs.modelo.Vaga;
import br.com.jobs.util.Controle;
import br.com.jobs.ws.Webservice;
import br.com.jobs.xml.XMLParser;

public class BuscarActivity extends Activity {
	
	private Spinner spnEstado;
	private Spinner spnCategoria;
	private Spinner spnVaga;
	private Integer layout;
	private Integer flagActivity = 1;
	private TextView txtRodape;
	
	private ArrayAdapter<Estado> adapterEstado;
	private ArrayList<Estado> estados;
	
	private ArrayAdapter<Vaga> adapterVaga;
	private ArrayList<Vaga> vagas;
	
	private ArrayAdapter<Categoria> adapterCategoria;
	private ArrayList<Categoria> categorias;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");
		
	private Webservice ws;
	private String xmlEstado;
	private String xmlCategoria;
	private String xmlVaga;
	
	//private Thread thread;
	private EstadoTask taskEstado = null;
	private CategoriaTask taskCategoria = null;
	private VagaTask taskVaga = null;
	
	private ProgressDialog pdEstado;
	private ProgressDialog pdCategoria;
	private ProgressDialog pdVaga;
	
	static final String KEY_ESTADO = "estado_item";
	static final String KEY_ESTADO_CODIGO = "estado_codigo";
	static final String KEY_ESTADO_DESCRICAO = "estado_descricao";
	static final String KEY_ESTADO_SIGLA = "estado_sigla";

	static final String KEY_CATEGORIA = "categoria_item";
	static final String KEY_CATEGORIA_CODIGO = "categoria_codigo";
	static final String KEY_CATEGORIA_DESCRICAO = "categoria_descricao";
	static final String KEY_CATEGORIA_STATUS = "categoria_status";
	
	static final String KEY_VAGA = "vaga_item";
	static final String KEY_VAGA_CODIGO = "vaga_codigo";
	static final String KEY_VAGA_DESCRICAO = "vaga_descricao";
	static final String KEY_VAGA_STATUS = "vaga_status";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buscar);
		spnEstado = (Spinner) findViewById(R.id.spnEstado);
		spnCategoria = (Spinner) findViewById(R.id.spnCategoria);
		spnVaga = (Spinner) findViewById(R.id.spnVaga);
		txtRodape = (TextView) findViewById(R.id.tvRodape);
		txtRodape.setText(R.string.activity_buscar);
		layout = R.layout.spinner_customizado;
		ws = new Webservice();
		carregar_xmlEstado();
		carregar_xmlCategoria();
		carregar_xmlVaga();
	}

public void carregar_xmlEstado(){
	pdEstado = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_dialog_titulo_estado"), true, false);
	taskEstado = new EstadoTask();
	taskEstado.execute();
}

public void carregar_xmlCategoria(){
	pdCategoria = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_dialog_titulo_categoria"), true, false);
	taskCategoria = new CategoriaTask();
	taskCategoria.execute();
}	

public void carregar_xmlVaga(){
	pdVaga = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_dialog_titulo_vaga"), true, false);
	taskVaga = new VagaTask();
	taskVaga.execute();
}	

	public void montarXMLEstado(String xml) {
		estados = new ArrayList<Estado>();
		Estado estadoOne = new Estado();
		estadoOne.setEstado_id(0);
		estadoOne.setEstado_descricao(bundle.getString("lbl_buscar_estado_one"));
		estadoOne.setEstado_sigla("");
		estados.add(estadoOne);
		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xmlEstado);
		NodeList nl = doc.getElementsByTagName(KEY_ESTADO);
		for (int i = 0; i < nl.getLength(); i++) {
			Estado estado = new Estado();
			Element e = (Element) nl.item(i);
			estado.setEstado_id(Integer.parseInt(parser.getValue(e, KEY_ESTADO_CODIGO)));
			estado.setEstado_descricao(parser.getValue(e, KEY_ESTADO_DESCRICAO));
			estado.setEstado_sigla(parser.getValue(e,KEY_ESTADO_SIGLA));
			estados.add(estado);
		}
		adapterEstado = new ArrayAdapter<Estado>(this, layout, estados);
		adapterEstado.setDropDownViewResource(layout);
		spnEstado.setAdapter(adapterEstado);
		pdEstado.dismiss();
	}


	public void montarXMLCategoria(String xml) {
		categorias = new ArrayList<Categoria>();
		Categoria categoriaOne = new Categoria();
		categoriaOne.setCategoria_id(0);
		categoriaOne.setCategoria_descricao(bundle.getString("lbl_buscar_categoria_one"));
		categoriaOne.setCategoria_status(true);
		categorias.add(categoriaOne);
		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xmlCategoria);
		NodeList nl = doc.getElementsByTagName(KEY_CATEGORIA);
		for (int i = 0; i < nl.getLength(); i++) {
			Categoria categoria = new Categoria();
			Element e = (Element) nl.item(i);
			categoria.setCategoria_id(Integer.parseInt(parser.getValue(e, KEY_CATEGORIA_CODIGO)));
			categoria.setCategoria_descricao(parser.getValue(e,	KEY_CATEGORIA_DESCRICAO));
			categoria.setCategoria_status(Boolean.parseBoolean(parser.getValue(e, KEY_CATEGORIA_STATUS)));
			categorias.add(categoria);
		}
		adapterCategoria = new ArrayAdapter<Categoria>(this, layout, categorias);
		adapterCategoria.setDropDownViewResource(layout);
		spnCategoria.setAdapter(adapterCategoria);
		pdCategoria.dismiss();
	}
	
	public void montarXMLVaga(String xml) {
		vagas = new ArrayList<Vaga>();
		Vaga vagaOne = new Vaga();
		vagaOne.setVaga_id(0);
		vagaOne.setVaga_descricao(bundle.getString("lbl_buscar_vaga_one"));
		vagaOne.setVaga_status(true);
		vagas.add(vagaOne);
		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xmlVaga);
		NodeList nl = doc.getElementsByTagName(KEY_VAGA);
		for (int i = 0; i < nl.getLength(); i++) {
			Vaga vaga = new Vaga();
			Element e = (Element) nl.item(i);
			vaga.setVaga_id(Integer.parseInt(parser.getValue(e, KEY_VAGA_CODIGO)));
			vaga.setVaga_descricao(parser.getValue(e,	KEY_VAGA_DESCRICAO));
			vaga.setVaga_status(Boolean.parseBoolean(parser.getValue(e, KEY_VAGA_STATUS)));
			vagas.add(vaga);
		}
		adapterVaga = new ArrayAdapter<Vaga>(this, layout, vagas);
		adapterVaga.setDropDownViewResource(layout);
		spnVaga.setAdapter(adapterVaga);
		pdVaga.dismiss();
	}
	
	@SuppressLint("HandlerLeak")
	private Handler handlerEstado = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLEstado(xmlEstado);
			Log.i("XML", xmlEstado);
		}
	};
	
	@SuppressLint("HandlerLeak")
	private Handler handlerCategoria = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLCategoria(xmlCategoria);
			Log.i("XML", xmlCategoria);
		}
	};
	
	@SuppressLint("HandlerLeak")
	private Handler handlerVaga = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLVaga(xmlVaga);
			Log.i("XML", xmlVaga);
		}
	};


	public void onClickSair(View v){
		Controle.Mensangens(this);
	}
	
	public void onClickVoltar(View v){
		Controle.Voltar(this);
	}
	public void onClickBuscar(View v) {
		Estado estado = (Estado) spnEstado.getSelectedItem();
		Categoria categoria = (Categoria) spnCategoria.getSelectedItem();
		Vaga vaga = (Vaga) spnVaga.getSelectedItem();
		Intent inOportunidade = new Intent(this,OportunidadeActivity.class);
		inOportunidade.putExtra("objEstado",estado);
		inOportunidade.putExtra("objCategoria", categoria);
		inOportunidade.putExtra("objVaga", vaga);
		inOportunidade.putExtra("flagActivity", flagActivity);
		startActivity(inOportunidade);
       }

	// Monta Spinner com dados do Estado vindo do WS
	class EstadoTask extends AsyncTask<String, Void, String> {

		String retorno;
		
		protected void onPreExecute() {
			
		};
		
		@Override
		protected String doInBackground(String... params) {
		try {
				xmlEstado = ws.consultarInformacoesEstado();
				Message msg = new Message();
				msg.obj = xmlEstado;
				handlerEstado.sendMessage(msg);
				Log.i("XML", xmlEstado);
				retorno = "1";
			} catch (Exception e) {
				retorno = "2";
			}
		return retorno;
		}
		
		@Override
		protected void onPostExecute(String result) {
			pdEstado.dismiss();
			if (result.equals("2")){
				Controle.ExibeToast(bundle.getString("lbl_alert_dialog_mensagem_ws"), getApplicationContext());
			}
		}
	}

	// Monta Spinner com dados do Categoria vindo do WS
	class CategoriaTask extends AsyncTask<String, Void, String> {

		String retorno;
	
		protected void onPreExecute() {
			
		};
		
		@Override
		protected String doInBackground(String... params) {
		try {
				xmlCategoria = ws.consultarInformacoesCategoria();
				Message msg = new Message();
				msg.obj = xmlCategoria;
				handlerCategoria.sendMessage(msg);
				Log.i("XML", xmlCategoria);
				retorno = "1";
			} catch (Exception e) {
				retorno = "2";
			}
		return retorno;
		}
		
		@Override
		protected void onPostExecute(String result) {
			pdEstado.dismiss();
			if (result.equals("2")){
				Controle.ExibeToast(bundle.getString("lbl_alert_dialog_mensagem_ws"), getApplicationContext());
			}
		}
	}
	
	// Monta Spinner com dados do Vaga vindo do WS
	class VagaTask extends AsyncTask<String, Void, String> {

		String retorno;
		
		protected void onPreExecute() {
			
		};
		
		@Override
		protected String doInBackground(String... params) {
		try {
				xmlVaga = ws.consultarInformacoesVaga();
				Message msg = new Message();
				msg.obj = xmlVaga;
				handlerVaga.sendMessage(msg);
				Log.i("XML", xmlVaga);
				retorno = "1";
			} catch (Exception e) {
				retorno = "2";
			}
		return retorno;
		}
		
		@Override
		protected void onPostExecute(String result) {
			pdVaga.dismiss();
			if (result.equals("2")){
				Controle.ExibeToast(bundle.getString("lbl_alert_dialog_mensagem_ws"), getApplicationContext());
			}
		}
	}


}
