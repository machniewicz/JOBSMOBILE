package br.com.jobs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import br.com.jobs.modelo.Beneficio;
import br.com.jobs.modelo.Categoria;
import br.com.jobs.modelo.Estado;
import br.com.jobs.modelo.Idioma;
import br.com.jobs.modelo.Oportunidade;
import br.com.jobs.modelo.Software;
import br.com.jobs.modelo.Vaga;
import br.com.jobs.util.Controle;
import br.com.jobs.ws.Webservice;
import br.com.jobs.xml.XMLParser;

public class OportunidadeActivity extends ListActivity{
	
	private Categoria categoria;
	private Estado estado;
	private Vaga vaga;
	private Oportunidade oportunidade;
	
	private Integer layout;
	private Integer telaFlag;
	private Integer codigoEstado;
	private TextView txtRodape;
	private TextView txtQuantidade;
	
	private int label[] = { R.id.lbl_cidade_estado_oportunidade, R.id.lbl_codigo_oportunidade, R.id.lbl_data_oportunidade, R.id.lbl_funcao_oportunidade, R.id.lbl_vaga_perfil};
	private String[] campos = { CAMPO_CIDADE_ESTADO, CAMPO_CODIGO,CAMPO_DATA, CAMPO_FUNCAO, CAMPO_VAGA_DESCRICAO };
	private ArrayList<HashMap<String, String>> lstOportunidade;
	private List<Oportunidade> oportunidades;
	
	private List<Beneficio> beneficios;
	private List<Idioma> idiomas;
	private List<Software> softwares;
	
	private String formato = "yyyy-MM-dd"; 
	private Date dateTmp;
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");
	
	static final String CAMPO_DATA = "campo_data";
	static final String CAMPO_CIDADE_ESTADO = "campo_cidade_estado";
	static final String CAMPO_CODIGO = "campo_codigo";
	static final String CAMPO_FUNCAO = "campo_funcao";
	static final String CAMPO_VAGA_DESCRICAO = "campo_vaga_descricao";
	
	static final String KEY_OPORTUNIDADE = "oportunidade_item";
	static final String KEY_OPORTUNIDADE_CODIGO = "oportunidade_codigo";
	static final String KEY_OPORTUNIDADE_CIDADE = "oportunidade_cidade";
	static final String KEY_OPORTUNIDADE_CONTATO = "oportunidade_contato";
	static final String KEY_OPORTUNIDADE_DATA = "oportunidade_data";
	static final String KEY_OPORTUNIDADE_DESCRICAO = "oportunidade_descricao";
	static final String KEY_OPORTUNIDADE_FONE = "oportunidade_fone";
	static final String KEY_OPORTUNIDADE_CATEGORIA = "oportunidade_categoria";
	static final String KEY_OPORTUNIDADE_ESTADO = "oportunidade_estado";
	static final String KEY_OPORTUNIDADE_FUNCAO = "oportunidade_funcao";
	static final String KEY_OPORTUNIDADE_SITE = "oportunidade_site";
	static final String KEY_OPORTUNIDADE_DIVULGAR = "oportunidade_divulgar";
	
	static final String KEY_OPORTUNIDADE_VAGA_CODIGO = "oportunidade_vaga_codigo";
	static final String KEY_OPORTUNIDADE_VAGA_DESCRICAO = "oportunidade_vaga_descricao";
	
	static final String KEY_OPORTUNIDADE_FORMACAO = "oportunidade_formacao";
	static final String KEY_OPORTUNIDADE_SALARIO = "oportunidade_salario";
	
	static final String KEY_OPORTUNIDADE_BENEFICIO = "oportunidade_beneficio_item";
	static final String KEY_OPORTUNIDADE_BENEFICIO_DESCRICAO = "oportunidade_beneficio_descricao";
	
	static final String KEY_OPORTUNIDADE_IDIOMA = "oportunidade_idioma_item";
	static final String KEY_OPORTUNIDADE_IDIOMA_DESCRICAO = "oportunidade_idioma_descricao";
	
	static final String KEY_OPORTUNIDADE_SOFTWARE = "oportunidade_software_item";
	static final String KEY_OPORTUNIDADE_SOFTWARE_DESCRICAO = "oportunidade_software_descricao";
	
	private Webservice ws;
	private String xmlOportunidade;
	private ListAdapter adapter;
	private Thread thread;

	private ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_oportunidade);
		txtRodape = (TextView) findViewById(R.id.tvRodape);
		txtQuantidade = (TextView) findViewById(R.id.txtQuantidadeOportunidades);
		txtRodape.setText(R.string.activity_oportunidade);
		layout = R.layout.lista_oportunidade_customizado;
		ws = new Webservice();
		/*
		 * Verifica de qual activity está vindo.
		 */
		telaFlag = (Integer) getIntent().getSerializableExtra("flagActivity");
		carregar_oportunidade(telaFlag);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		super.onListItemClick(l, v, position, id);
		oportunidade = new Oportunidade();
		oportunidade = oportunidades.get(position);
		Intent inOportunidadeDetalhe = new Intent(this,DetalharOportunidadeActivity.class);
		inOportunidadeDetalhe.putExtra("objOportunidade", oportunidade);
		startActivity(inOportunidadeDetalhe);
	}
	
	public void onClickVoltar(View v) {
		Controle.Voltar(this);
	}
	
	public void carregar_oportunidade(final Integer telaActivity) {
		pd = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_dialog_titulo_oportunidade"), true,	false);
		thread = new Thread() {
			@Override
			public void run() {
				try {
					if(telaActivity == 1){
						categoria = (Categoria) getIntent().getSerializableExtra("objCategoria");
						estado = (Estado) getIntent().getSerializableExtra("objEstado");
						vaga = (Vaga) getIntent().getSerializableExtra("objVaga");
						xmlOportunidade = ws.consultarInformacoesOportunidade(estado.getEstado_id(), categoria.getCategoria_id(),vaga.getVaga_id() ,telaActivity);
					}else if (telaActivity == 2){
						codigoEstado = (Integer) getIntent().getSerializableExtra("codigoEstado");
						xmlOportunidade = ws.consultarInformacoesOportunidade(codigoEstado, 0, 0,telaActivity);
					}
					Message msg = new Message();
					msg.obj = xmlOportunidade;
					handler.sendMessage(msg);
					Log.i("XML", xmlOportunidade);
				} catch (Exception e) {
					pd.dismiss();
					System.out.println("Erro!!: " + e.getMessage());
				}
			}
		};
		thread.start();
	}

	@SuppressLint("SimpleDateFormat")
	public void montarXMLOportunidade(String xml) {
		lstOportunidade = new ArrayList<HashMap<String, String>>();
		oportunidades = new ArrayList<Oportunidade>();
		
		beneficios = new ArrayList<Beneficio>();
		idiomas = new ArrayList<Idioma>();
		softwares = new ArrayList<Software>();
		
		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xml);
		NodeList nl = doc.getElementsByTagName(KEY_OPORTUNIDADE);
		
		NodeList nb = doc.getElementsByTagName(KEY_OPORTUNIDADE_BENEFICIO);
		NodeList ni = doc.getElementsByTagName(KEY_OPORTUNIDADE_IDIOMA);
		NodeList ns = doc.getElementsByTagName(KEY_OPORTUNIDADE_SOFTWARE);
		
		for (int i = 0; i < nl.getLength(); i++) {
			oportunidade = new Oportunidade();
			Element e = (Element) nl.item(i);
			oportunidade.setOportunidade_id(Integer.parseInt(parser.getValue(e, KEY_OPORTUNIDADE_CODIGO)));
			oportunidade.setOportunidade_cidade(parser.getValue(e, KEY_OPORTUNIDADE_CIDADE));
			oportunidade.setOportunidade_contato(parser.getValue(e, KEY_OPORTUNIDADE_CONTATO));
			try {
				dateTmp = new SimpleDateFormat(formato).parse(parser.getValue(e, KEY_OPORTUNIDADE_DATA));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			oportunidade.setOportunidade_data(dateTmp);
			oportunidade.setOportunidade_descricao(parser.getValue(e, KEY_OPORTUNIDADE_DESCRICAO));
			oportunidade.setOportunidade_fone(parser.getValue(e, KEY_OPORTUNIDADE_FONE));
			oportunidade.setOportunidade_categoria(parser.getValue(e, KEY_OPORTUNIDADE_CATEGORIA));
			oportunidade.setOportunidade_estado(parser.getValue(e, KEY_OPORTUNIDADE_ESTADO));
			oportunidade.setOportunidade_funcao(parser.getValue(e, KEY_OPORTUNIDADE_FUNCAO));
			oportunidade.setOportunidade_site(parser.getValue(e, KEY_OPORTUNIDADE_SITE));
			oportunidade.setOportunidade_divulgar(parser.getValue(e, KEY_OPORTUNIDADE_DIVULGAR));
			oportunidade.setOportunidade_vaga_codigo(Integer.parseInt(parser.getValue(e, KEY_OPORTUNIDADE_VAGA_CODIGO)));
			oportunidade.setOportunidade_vaga_descricao(parser.getValue(e, KEY_OPORTUNIDADE_VAGA_DESCRICAO));
			oportunidade.setOportunidade_formacao(parser.getValue(e, KEY_OPORTUNIDADE_FORMACAO));
			oportunidade.setOportunidade_salario(parser.getValue(e, KEY_OPORTUNIDADE_SALARIO));
			/*
			 * Popula lista de Beneficios
			 */
			for (int ben = 0; ben < nb.getLength(); ben++) {
				Element benef = (Element) nb.item(ben);
				Beneficio beneficio = new Beneficio();
				beneficio.setBeneficio_id(ben + 1);
				beneficio.setOportunidade_id(Integer.parseInt(parser.getValue(e, KEY_OPORTUNIDADE_CODIGO)));
				beneficio.setBeneficio_descricao(parser.getValue(benef, KEY_OPORTUNIDADE_BENEFICIO_DESCRICAO));
				beneficios.add(beneficio);
			}
			/*
			 * Popula lista de Idiomas
			 */
			for (int idi = 0; idi < ni.getLength(); idi++) {
				Element idiom = (Element) ni.item(idi);
				Idioma idioma = new Idioma();
				idioma.setIdioma_id(idi + 1);
				idioma.setOportunidade_id(Integer.parseInt(parser.getValue(e, KEY_OPORTUNIDADE_CODIGO)));
				idioma.setIdioma_descricao(parser.getValue(idiom, KEY_OPORTUNIDADE_IDIOMA_DESCRICAO));
				idiomas.add(idioma);
			}
			/*
			 * Popula lista de Softwares
			 */
			for (int sof = 0; sof < ns.getLength(); sof++) {
				Element softw = (Element) ns.item(sof);
				Software software = new Software();
				software.setSoftware_id(sof + 1);
				software.setOportunidade_id(Integer.parseInt(parser.getValue(e, KEY_OPORTUNIDADE_CODIGO)));
				software.setSoftware_descricao(parser.getValue(softw, KEY_OPORTUNIDADE_SOFTWARE_DESCRICAO));
				softwares.add(software);
			}
			
			HashMap<String, String> map = new HashMap<String, String>();
			map.put(CAMPO_DATA, bundle.getString("lbl_oportunidade_cadastrada_em") +formataData(oportunidade.getOportunidade_data()));
			map.put(CAMPO_CIDADE_ESTADO, oportunidade.getOportunidade_cidade() + " - " + oportunidade.getOportunidade_estado());
			map.put(CAMPO_CODIGO, bundle.getString("lbl_oportunidade_codigo") + oportunidade.getOportunidade_id().toString());
			map.put(CAMPO_FUNCAO, bundle.getString("lbl_oportunidade_funcao") + oportunidade.getOportunidade_funcao());
			map.put(CAMPO_VAGA_DESCRICAO, bundle.getString("lbl_oportunidade_vaga_descricao") + oportunidade.getOportunidade_vaga_descricao());
			lstOportunidade.add(map);
			/*
			 * Adiciona Lista de Oportunidades para consulta posterior
			 */
			oportunidade.setBeneficios(beneficios);
			oportunidade.setIdiomas(idiomas);
			oportunidade.setSoftwares(softwares);
			oportunidades.add(oportunidade);
		}
		if (lstOportunidade.size() == 0){
			pd.dismiss();
			Intent inVazio = new Intent(this,VazioActivity.class);
			startActivity(inVazio);
			Controle.Voltar(this);
		}
		else{
		txtQuantidade.setText(bundle.getString("lbl_quantidade")+" "+lstOportunidade.size() +" "+ bundle.getString("lbl_oportunidade_quantidade"));
		adapter = new SimpleAdapter(this, lstOportunidade, layout, campos, label);
		setListAdapter(adapter);
		pd.dismiss();
		}
	}
	
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLOportunidade(xmlOportunidade);
			Log.i("XML", xmlOportunidade);
		}
	};
	
    @SuppressLint("SimpleDateFormat")
	public String formataData(Date data){   
    		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
    	return formataData.format(data);  
    }  
}
