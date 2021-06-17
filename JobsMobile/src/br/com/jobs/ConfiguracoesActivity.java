package br.com.jobs;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import br.com.jobs.dao.CurriculoDAOImpl;
import br.com.jobs.dao.PreferenciaDAOImpl;
import br.com.jobs.modelo.Categoria;
import br.com.jobs.modelo.Curriculo;
import br.com.jobs.modelo.Estado;
import br.com.jobs.modelo.Formacao;
import br.com.jobs.modelo.Preferencia;
import br.com.jobs.modelo.Salario;
import br.com.jobs.util.Controle;
import br.com.jobs.util.Mask;
import br.com.jobs.ws.Webservice;
import br.com.jobs.xml.XMLParser;

public class ConfiguracoesActivity extends Activity{

	private TextView txtRodape;
	private EditText nomePreferencia;
	private EditText emailPreferencia;
	private EditText cpfPreferencia;
	private EditText senhaPreferencia;
	private TextView txtTempoPreferencia;
	private Spinner spnFormacao;
	private Spinner spnSalario;
	private Spinner spnAtuacao;
	private Spinner spnEstado;
	private SeekBar barTempo;
	private Integer layout;
	
	private PreferenciaDAOImpl Preferenciadb;
	private Preferencia p;
	private Preferencia preferencia = null;
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");
	private static CurriculoDAOImpl curriculoDB;
	private static Curriculo curriculo;
	
	private ArrayAdapter<Estado> adapterEstado;
	private ArrayList<Estado> estados;
	private Integer posicaoEstado = 0;
	
	private ArrayAdapter<Formacao> adapterFormacao;
	private ArrayList<Formacao> formacoes;
	private Integer posicaoFormacao = 0;
	
	private ArrayAdapter<Salario> adapterSalario;
	private ArrayList<Salario> salarios;
	private Integer posicaoSalario = 0;
	
	private ArrayAdapter<Categoria> adapterCategoria;
	private ArrayList<Categoria> categorias;
	private Integer posicaoAtuacao = 0;

	private Webservice ws;
	private String xmlFormacao;
	private String xmlSalario;
	private String xmlAtuacao;
	private String xmlEstado;
	
	private FormacaoTask taskFormacao = null;
	private SalarioTask taskSalario = null;
	private AtuacaoTask taskAtuacao = null;
	private EstadoTask taskEstado = null;
	private PrecadastroTask taskPrecadastro = null;
	
	private ProgressDialog pdFormacao;
	private ProgressDialog pdSalario;
	private ProgressDialog pdAtuacao;
	private ProgressDialog pdEstado;
	
	static final String KEY_FORMACAO = "formacao_item";
	static final String KEY_FORMACAO_CODIGO = "formacao_codigo";
	static final String KEY_FORMACAO_DESCRICAO = "formacao_descricao";
	
	static final String KEY_SALARIO = "salario_item";
	static final String KEY_SALARIO_CODIGO = "salario_codigo";
	static final String KEY_SALARIO_DESCRICAO = "salario_descricao";
	
	static final String KEY_CATEGORIA = "categoria_item";
	static final String KEY_CATEGORIA_CODIGO = "categoria_codigo";
	static final String KEY_CATEGORIA_DESCRICAO = "categoria_descricao";
	static final String KEY_CATEGORIA_STATUS = "categoria_status";
	
	static final String KEY_ESTADO = "estado_item";
	static final String KEY_ESTADO_CODIGO = "estado_codigo";
	static final String KEY_ESTADO_DESCRICAO = "estado_descricao";
	static final String KEY_ESTADO_SIGLA = "estado_sigla";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracoes);
		txtRodape = (TextView) findViewById(R.id.tvRodape);
		spnAtuacao = (Spinner) findViewById(R.id.spnAtuacao);
		spnFormacao = (Spinner) findViewById(R.id.spnFormacao);
		spnSalario = (Spinner) findViewById(R.id.spnFaixaSalarial);
		spnEstado = (Spinner) findViewById(R.id.spnEstado);
		nomePreferencia = (EditText) findViewById(R.id.txtNomePreferencia);
		emailPreferencia = (EditText) findViewById(R.id.txtEmailPreferencia);
		cpfPreferencia = (EditText) findViewById(R.id.txtCPFPreferencia);
		senhaPreferencia = (EditText) findViewById(R.id.txtSenhaPreferencia);
		barTempo = (SeekBar) findViewById(R.id.barTempoAnos);
		txtTempoPreferencia = (TextView) findViewById(R.id.txtTempoExperiencia);
		ws = new Webservice();
		txtRodape.setText(R.string.activity_preferencia);
		cpfPreferencia.addTextChangedListener(Mask.insert(Mask.CPF_MASK, cpfPreferencia));
		layout = R.layout.spinner_customizado;
		barTempo.setOnSeekBarChangeListener(customSeekBarListener);
		Preferenciadb = new PreferenciaDAOImpl(this);
		p = new Preferencia();
		p = Preferenciadb.detalhesPreferencia();
		if (p.getPreferencia_codigo() > 0) {
			carregaPreferenciaAtual(p);
		}
		carregar_xmlEstado();
		carregar_xmlAtuacao();
		carregar_xmlFormacao();
		carregar_xmlSalario();
		
	}

	private SeekBar.OnSeekBarChangeListener customSeekBarListener = new SeekBar.OnSeekBarChangeListener() {
		
		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {}
		
		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {}
		
		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			String lblTemp = null;
			if(progress <= 1){
				lblTemp = MessageFormat.format(bundle.getString("lbl_tempo_experiencia_singular"), progress); 
			}
			else{
				lblTemp = MessageFormat.format(bundle.getString("lbl_tempo_experiencia_plural"), progress);
			}
			txtTempoPreferencia.setText(lblTemp);
		}
	};
	
	/*
	 * Carregar XML - Webservice
	 */
	
	public void carregar_xmlEstado(){
		pdEstado = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_dialog_titulo_estado"), true, false);
		taskEstado = new EstadoTask();
		taskEstado.execute();
	}
	
	public void carregar_xmlAtuacao(){
		pdAtuacao = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_dialog_titulo_atuacao"), true, false);
		taskAtuacao = new AtuacaoTask();
		taskAtuacao.execute();
	}
	
	public void carregar_xmlFormacao(){
		pdFormacao = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_dialog_titulo_formacao"), true, false);
		taskFormacao = new FormacaoTask();
		taskFormacao.execute();
	}
	
	public void carregar_xmlSalario(){
		pdSalario = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_dialog_titulo_salario"), true, false);
		taskSalario = new SalarioTask();
		taskSalario.execute();
	}
	
	/*
	 * Onclik Activity Android
	 */
	
	public void onClickVoltar(View v) {
		Controle.Voltar(this);
	}

	public void onClickCurriculo(View v) {
		if(p.getPreferencia_codigo() > 0){		
			Intent inCurriculo = new Intent(this,CurriculoActivity.class);
			inCurriculo.putExtra("objPreferencia", p);
			startActivity(inCurriculo);
		}
		else{
			Controle.ExibeToast(bundle.getString("msg_preferencia_curriculo_falha"), this);
		}
	}

	public void onClickConfirmar(View v) {
		if (nomePreferencia.length() > 0 && emailPreferencia.length() > 0 && cpfPreferencia.length() > 0 && senhaPreferencia.length() > 0){
			if (this.p != null){
				preferencia = this.p;
			}else{ 
				preferencia = new Preferencia();
				preferencia.setPreferencia_codigo(0);
			}
			Estado estado = (Estado) spnEstado.getSelectedItem();
			Categoria categoria = (Categoria) spnAtuacao.getSelectedItem();
			Formacao formacao = (Formacao) spnFormacao.getSelectedItem();
			Salario salario = (Salario) spnSalario.getSelectedItem();
			preferencia.setPreferencia_nome(nomePreferencia.getText().toString());
			preferencia.setPreferencia_email(emailPreferencia.getText().toString());
			preferencia.setPreferencia_cpf(cpfPreferencia.getText().toString());
			preferencia.setPreferencia_estado_id(estado.getEstado_id());
			preferencia.setPreferencia_categoria_id(categoria.getCategoria_id());
			preferencia.setPreferencia_formacao_id(formacao.getFormacao_id());
			preferencia.setPreferencia_salario_id(salario.getSalario_id());
			preferencia.setPreferencia_experiencia(barTempo.getProgress());
			preferencia.setPreferencia_senha(senhaPreferencia.getText().toString());
			if(preferencia.getPreferencia_codigo() > 0){
				Preferenciadb.atualizar(preferencia);
				Controle.ExibeToast(bundle.getString("msg_preferencia_alterar"), this);
			}else{
				Preferenciadb.salvar(preferencia);
				Controle.ExibeToast(bundle.getString("msg_preferencia_incluir"),this);
			}
			this.atualizarPreCadastro();
			this.finish();
		}
		else{
			Controle.ExibeToast(bundle.getString("lbl_alert_dialog_mensagem_em_branco"), this);
		}
	}

	public void onClickExcluir(View v) {
		Preferencia preferencia = this.p;
		if (preferencia.getPreferencia_codigo() <= 0){
		 Controle.ExibeToast(bundle.getString("msg_preferencia_excluir_falha"), this);
		 }
		 else{
			 MensangensExcluir(this, preferencia);
		 }
	}

	/*
	 * Banco de dados SQLite
	 */
	
	public void verificaPreferencia(Preferencia p) {
		if (p.getPreferencia_codigo() > 0) {
			carregaPreferenciaAtual(p);
		} 
	}
	
	public void carregaPreferenciaAtual(Preferencia p) {
		nomePreferencia.setText(p.getPreferencia_nome());
		emailPreferencia.setText(p.getPreferencia_email());
		cpfPreferencia.setText(p.getPreferencia_cpf());
		senhaPreferencia.setText(p.getPreferencia_senha());
		barTempo.setProgress(p.getPreferencia_experiencia());
		posicaoEstado = p.getPreferencia_estado_id();
		posicaoAtuacao = p.getPreferencia_categoria_id();
		posicaoFormacao = p.getPreferencia_formacao_id();
		posicaoSalario = p.getPreferencia_salario_id();
		
	}
	
	public void MensangensExcluir(final Activity ac, final Preferencia pre) {
		AlertDialog.Builder builder = new AlertDialog.Builder(ac);
		builder.setTitle(bundle.getString("lbl_alert_dialog_titulo_excluir"))
				.setMessage(
						bundle.getString("lbl_alert_dialog_mensagem_excluir"))
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton(bundle.getString("lbl_alert_dialog_sim"),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								PreferenciaDAOImpl db = new PreferenciaDAOImpl(ac);
								curriculoDB = new CurriculoDAOImpl(ac);
								curriculo = new Curriculo();
								curriculo = curriculoDB.detalhesCurriculo();
								if (curriculo.getCurriculo_codigo() > 0) {
									curriculoDB.excluir(curriculo);
								}								
								db.excluir(pre);
								ac.finish();
								Controle.ExibeToast(bundle.getString("msg_preferencia_excluir"), ac);
							}
						})
				.setNegativeButton(bundle.getString("lbl_alert_dialog_nao"),null).show();
	}
	
	
	/*
	 * Tasks 
	 */
	public void atualizarPreCadastro(){
		taskPrecadastro = new PrecadastroTask();
		taskPrecadastro.execute();
	}
	
	/*
	 * Precadastro via WS
	 */
			class PrecadastroTask extends AsyncTask<String, Void, String> {
				String retorno;
				protected void onPreExecute() {};
				
				@Override
				protected String doInBackground(String... params) {
				try {
						ws.gravarInformacoesPrecadastro(p);
						Log.i("Preferencia",p.getPreferencia_cpf());
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

	
	// Monta Spinner com dados da Atuacao vindo do WS
	class AtuacaoTask extends AsyncTask<String, Void, String> {

		String retorno;
		
		protected void onPreExecute() {
			
		};
		
		@Override
		protected String doInBackground(String... params) {
		try {
				xmlAtuacao = ws.consultarInformacoesCategoria();
				Message msg = new Message();
				msg.obj = xmlAtuacao;
				handlerCategoria.sendMessage(msg);
				Log.i("XML", xmlAtuacao);
				retorno = "1";
			} catch (Exception e) {
				retorno = "2";
			}
		return retorno;
		}
		
		@Override
		protected void onPostExecute(String result) {
			pdAtuacao.dismiss();
			if (result.equals("2")){
				Controle.ExibeToast(bundle.getString("lbl_alert_dialog_mensagem_ws"), getApplicationContext());
			}
		}
	}

	// Monta Spinner com dados Estado vindo do WS
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

	// Monta Spinner com dados do Formacao vindo do WS
	class FormacaoTask extends AsyncTask<String, Void, String> {

		String retorno;
	
		protected void onPreExecute() {
			
		};
		
		@Override
		protected String doInBackground(String... params) {
		try {
				xmlFormacao = ws.consultarInformacoesFormacao();
				Message msg = new Message();
				msg.obj = xmlFormacao;
				handlerFormacao.sendMessage(msg);
				Log.i("XML", xmlFormacao);
				retorno = "1";
			} catch (Exception e) {
				retorno = "2";
			}
		return retorno;
		}
		
		@Override
		protected void onPostExecute(String result) {
			pdFormacao.dismiss();
			if (result.equals("2")){
				Controle.ExibeToast(bundle.getString("lbl_alert_dialog_mensagem_ws"), getApplicationContext());
			}
		}
	}

	// Monta Spinner com dados de Faixa Salarial vindo do WS
	class SalarioTask extends AsyncTask<String, Void, String> {

		String retorno;
	
		protected void onPreExecute() {
			
		};
		
		@Override
		protected String doInBackground(String... params) {
		try {
				xmlSalario = ws.consultarInformacoesSalario();
				Message msg = new Message();
				msg.obj = xmlSalario;
				handlerSalario.sendMessage(msg);
				Log.i("XML", xmlSalario);
				retorno = "1";
			} catch (Exception e) {
				retorno = "2";
			}
		return retorno;
		}
		
		@Override
		protected void onPostExecute(String result) {
			pdSalario.dismiss();
			if (result.equals("2")){
				Controle.ExibeToast(bundle.getString("lbl_alert_dialog_mensagem_ws"), getApplicationContext());
			}
		}
	}
	
	/*
	 * Handelers
	 */
	
	@SuppressLint("HandlerLeak")
	private Handler handlerCategoria = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLCategoria(xmlAtuacao, posicaoAtuacao);
			Log.i("XML", xmlAtuacao);
		}
	};
	
	@SuppressLint("HandlerLeak")
	private Handler handlerFormacao = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLFormacao(xmlFormacao, posicaoFormacao);
			Log.i("XML", xmlFormacao);
		}
	};
	
	@SuppressLint("HandlerLeak")
	private Handler handlerSalario = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLSalario(xmlSalario, posicaoSalario );
			Log.i("XML", xmlSalario);
		}
	};

	@SuppressLint("HandlerLeak")
	private Handler handlerEstado = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLEstado(xmlEstado, posicaoEstado);
			Log.i("XML", xmlEstado);
		}
	};

	/*
	 * Monta Spinners
	 */
	
	public void montarXMLCategoria(String xml, Integer posicao) {
		categorias = new ArrayList<Categoria>();
		Categoria categoriaOne = new Categoria();
		categoriaOne.setCategoria_id(0);
		categoriaOne.setCategoria_descricao(bundle.getString("lbl_buscar_atuacao_one_cadastro"));
		categoriaOne.setCategoria_status(true);
		categorias.add(categoriaOne);
		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xml);
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
		spnAtuacao.setAdapter(adapterCategoria);
		if (posicaoAtuacao > 0){
			posicaoAtuacao = this.posicaoSpinner(categorias, posicaoAtuacao);
		}
		spnAtuacao.setSelection(posicaoAtuacao);
		pdAtuacao.dismiss();
	}
	
	public Integer posicaoSpinner(ArrayList<Categoria> cat, Integer idAtuacao){
		int posicao = 0;
		for(int i = 0; i<cat.size();i++){
			if(cat.get(i).getCategoria_id().equals(idAtuacao)){
				posicao = i;
			}
		}
		return posicao;
	}
	
	public void montarXMLFormacao(String xml, Integer posicao) {
		formacoes = new ArrayList<Formacao>();
		Formacao formacaoOne = new Formacao();
		formacaoOne.setFormacao_id(0);
		formacaoOne.setFormacao_descricao(bundle.getString("lbl_buscar_formacao_one_cadastro"));
		formacoes.add(formacaoOne);
		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xml);
		NodeList nl = doc.getElementsByTagName(KEY_FORMACAO);
		for (int i = 0; i < nl.getLength(); i++) {
			Formacao formacao = new Formacao();
			Element e = (Element) nl.item(i);
			formacao.setFormacao_id(Integer.parseInt(parser.getValue(e, KEY_FORMACAO_CODIGO)));
			formacao.setFormacao_descricao(parser.getValue(e, KEY_FORMACAO_DESCRICAO));
			formacoes.add(formacao);
		}
		adapterFormacao = new ArrayAdapter<Formacao>(this, layout, formacoes);
		adapterFormacao.setDropDownViewResource(layout);
		spnFormacao.setAdapter(adapterFormacao);
		spnFormacao.setSelection(posicao);
		pdFormacao.dismiss();
	}
	
	public void montarXMLSalario(String xml, Integer posicao) {
		salarios = new ArrayList<Salario>();
		Salario salarioOne = new Salario();
		salarioOne.setSalario_id(0);
		salarioOne.setSalario_descricao(bundle.getString("lbl_buscar_salario_one_cadastro"));
		salarios.add(salarioOne);
		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xml);
		NodeList nl = doc.getElementsByTagName(KEY_SALARIO);
		for (int i = 0; i < nl.getLength(); i++) {
			Salario salario = new Salario();
			Element e = (Element) nl.item(i);
			salario.setSalario_id(Integer.parseInt(parser.getValue(e, KEY_SALARIO_CODIGO)));
			salario.setSalario_descricao((parser.getValue(e, KEY_SALARIO_DESCRICAO)));
			salarios.add(salario);
		}
		adapterSalario = new ArrayAdapter<Salario>(this, layout, salarios);
		adapterSalario.setDropDownViewResource(layout);
		spnSalario.setAdapter(adapterSalario);
		spnSalario.setSelection(posicao);
		pdSalario.dismiss();
	}

	public void montarXMLEstado(String xml, Integer posicao) {
		estados = new ArrayList<Estado>();
		Estado estadoOne = new Estado();
		estadoOne.setEstado_id(0);
		estadoOne.setEstado_descricao(bundle.getString("lbl_buscar_estado_one_cadastro"));
		estadoOne.setEstado_sigla("");
		estados.add(estadoOne);
		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xml);
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
		spnEstado.setSelection(posicao);
		pdEstado.dismiss();
	}

	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Preferenciadb.finalizaBanco();
		if (taskEstado != null ){
			taskEstado.cancel(true);
		}
		if (taskAtuacao !=null){
			taskAtuacao.cancel(true);
		}
		if (taskFormacao != null ){
			taskFormacao.cancel(true);
		}
		if (taskSalario !=null){
			taskSalario.cancel(true);
		}
		if (taskPrecadastro !=null){
			taskPrecadastro.cancel(true);
		}
	}

}
