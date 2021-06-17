package br.com.jobs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.MailcapCommandMap;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import br.com.jobs.dao.CurriculoDAOImpl;
import br.com.jobs.dao.HistoricoDAOImpl;
import br.com.jobs.dao.PreferenciaDAOImpl;
import br.com.jobs.modelo.Beneficio;
import br.com.jobs.modelo.ConfigEmail;
import br.com.jobs.modelo.Curriculo;
import br.com.jobs.modelo.Enviado;
import br.com.jobs.modelo.Historico;
import br.com.jobs.modelo.Idioma;
import br.com.jobs.modelo.Oportunidade;
import br.com.jobs.modelo.Preferencia;
import br.com.jobs.modelo.Software;
import br.com.jobs.util.Controle;
import br.com.jobs.ws.Webservice;
import br.com.jobs.xml.XMLParser;

public class DetalharOportunidadeActivity extends Activity {
	
	private Oportunidade oportunidade;
	private Preferencia preferencia;
	private Curriculo curriculo;
	private Historico historico;
	private Enviado enviado;
	
	private PreferenciaDAOImpl preferenciaDAO;
	private CurriculoDAOImpl curriculoDAO;
	private HistoricoDAOImpl historicoDAO;
	
	private TextView txtRodape;
	private TextView txtCodigo;
	private TextView txtFuncao;
	private TextView txtCategoria;
	private TextView txtCidade_Estado;
	private TextView txtTelefone;
	private TextView txtContato;
	private TextView txtSite;
	private TextView txtDescricao;
	private TextView txtVaga;
	private TextView txtSalario;
	private TextView txtFormacao;
	
	private ListView lvBeneficio;
	private ListView lvIdioma; 
	private ListView lvSoftware;
	
	private ImageView imgVagaDetalhes;
	private Drawable img;
	
	private Integer layoutIdioma;
	private Integer layoutSoftware;
	private Integer layoutBeneficio;
	private int labelIdioma = R.id.lbl_descricao_idioma;
	private int labelSoftware = R.id.lbl_descricao_software;
	private int labelBeneficio = R.id.lbl_descricao_beneficio;
	
	private List<Idioma> idiomas = null;
	private List<Beneficio> beneficios = null;
	private List<Software> softwares = null;
	
	private ArrayAdapter<String> adapterIdioma;
	private ListAdapter adapterBeneficio;
	private ArrayAdapter<String> adapterSoftware;
	
	private List<String> lstIdioma = null;
	private List<String> lstSoftware = null;
	private List<String> lstBeneficio = null;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");
	
	private Dialog pdialog = null;
	Session session = null;
	private EnviarEmailTask taskEmail = null;
	private EstatisticaTask taskEstatistica = null;
	private ConfigEmail configEmail;
	private Webservice ws;
	private String xmlEmail;
	private Thread thread;
	
	private Integer totalHeight = 0;
	static final String KEY_EMAIL = "email_item";
	static final String KEY_EMAIL_CODIGO = "email_codigo";
	static final String KEY_EMAIL_SMTP = "email_smtp";
	static final String KEY_EMAIL_EMAIL = "email_email";
	static final String KEY_EMAIL_SENHA = "email_senha";
	static final String KEY_EMAIL_PORTA = "email_porta";
	static final String KEY_EMAIL_AUTH = "email_auth";
	static final String KEY_EMAIL_TLS = "email_tls";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_oportunidade_detalhe);
		txtRodape = (TextView) findViewById(R.id.tvRodape);
		txtCodigo = (TextView) findViewById(R.id.txtCodigo);
		txtFuncao = (TextView) findViewById(R.id.txtFuncao);
		txtCategoria = (TextView) findViewById(R.id.txtCategoria);
		txtCidade_Estado = (TextView) findViewById(R.id.txtCidade_Estado);
		txtTelefone = (TextView) findViewById(R.id.txtTelefone);
		txtContato = (TextView) findViewById(R.id.txtContato);
		txtDescricao = (TextView) findViewById(R.id.txtDescricao);
		txtSite = (TextView) findViewById(R.id.txtSite);
		txtVaga = (TextView) findViewById(R.id.txtVaga);
		txtSalario = (TextView) findViewById(R.id.txtSalario);
		txtFormacao = (TextView) findViewById(R.id.txtFormacao);
		imgVagaDetalhes = (ImageView) findViewById(R.id.imageVaga);
		oportunidade = (Oportunidade) getIntent().getSerializableExtra("objOportunidade");
		txtRodape.setText(R.string.activity_oportunidade_detalhes);
		lvBeneficio = (ListView) findViewById(R.id.listBeneficio);
		lvIdioma = (ListView) findViewById(R.id.listIdioma);
		lvSoftware = (ListView) findViewById(R.id.listSoftware);
		ws = new Webservice();
		this.carregaDetalhesTela(oportunidade);
		
	}

	/*
	 * Seta as Texts da Activity e popula Objetos
	 */
	public void carregaDetalhesTela(Oportunidade oportunidade){
		
		Resources res = getResources();
		
		txtCodigo.setText(oportunidade.getOportunidade_id().toString());
		txtFuncao.setText(oportunidade.getOportunidade_funcao());
		txtCategoria.setText(oportunidade.getOportunidade_categoria());
		txtCidade_Estado.setText(oportunidade.getOportunidade_cidade() + " - " + oportunidade.getOportunidade_estado());

		if(oportunidade.getOportunidade_divulgar().equals("null")|| oportunidade.getOportunidade_divulgar().equals("f")){
			txtTelefone.setText(bundle.getString("lbl_oportunidade_telefone_divulgado"));
			txtContato.setText(bundle.getString("lbl_oportunidade_email_divulgado"));
			txtSite.setText(bundle.getString("lbl_oportunidade_site_divulgado"));
		}
		else{
			txtTelefone.setText(oportunidade.getOportunidade_fone());
			txtContato.setText(oportunidade.getOportunidade_contato());
			txtSite.setText(oportunidade.getOportunidade_site());
		}
		 
		switch (oportunidade.getOportunidade_vaga_codigo()){
		case 1:
			img = res.getDrawable(R.drawable.vaga_1);
			break;
		case 2:
			img = res.getDrawable(R.drawable.vaga_2);
			break;
		case 3:
			img = res.getDrawable(R.drawable.vaga_3);
			break;
		case 4:
			img = res.getDrawable(R.drawable.vaga_4);
			break;
		default:
			img = res.getDrawable(R.drawable.vaga_1);
			break;
		}
		imgVagaDetalhes.setImageDrawable(img);
		txtVaga.setText(oportunidade.getOportunidade_vaga_descricao());
		txtSalario.setText(oportunidade.getOportunidade_salario());
		txtFormacao.setText(oportunidade.getOportunidade_formacao());
		txtDescricao.setText(oportunidade.getOportunidade_descricao());
		
		/*
		 * Monta lista de Idiomas e passa para AdapterIdioma 
		 */
		layoutIdioma = R.layout.lista_idioma_customizado;
		lstIdioma = new ArrayList<String>();
		if (oportunidade.getIdiomas().size() == 0){
			oportunidade.setIdiomas(this.listaIdiomaVazio());
		}
		for (int i=0;i<oportunidade.getIdiomas().size();i++){
			lstIdioma.add(oportunidade.getIdiomas().get(i).getIdioma_descricao());
		}
		adapterIdioma = new ArrayAdapter<String>(this, layoutIdioma, labelIdioma, lstIdioma);
		lvIdioma.setAdapter(adapterIdioma);
		
		/*
		 * Dimensiona ListView Idioma conforme quantidade de items
		 */
	    totalHeight = 0;
        for (int i = 0; i < adapterIdioma.getCount(); i++) {
            View listItemIdioma = adapterIdioma.getView(i, null, lvIdioma);
            listItemIdioma.measure(0, 0);
            totalHeight += listItemIdioma.getMeasuredHeight();
        }

        ViewGroup.LayoutParams paramsIdi = lvIdioma.getLayoutParams();
        paramsIdi.height = totalHeight + (lvIdioma.getDividerHeight() * (adapterIdioma.getCount() - 1));
        lvIdioma.setLayoutParams(paramsIdi);
        lvIdioma.requestLayout();


		/*
		 * Monta lista de Softwares e passa para AdapterSoftwares 
		 */
		layoutSoftware = R.layout.lista_software_customizado;
		lstSoftware = new ArrayList<String>();
		if (oportunidade.getSoftwares().size() == 0){
			oportunidade.setSoftwares(this.listaSoftwareVazio());
		}
		for (int s=0;s<oportunidade.getSoftwares().size();s++){
			lstSoftware.add(oportunidade.getSoftwares().get(s).getSoftware_descricao());
		}
		adapterSoftware = new ArrayAdapter<String>(this, layoutSoftware, labelSoftware, lstSoftware);
		lvSoftware.setAdapter(adapterSoftware);
		
		/*
		 * Dimensiona ListView Software conforme quantidade de items
		 */
	    totalHeight = 0;
        for (int i = 0; i < adapterSoftware.getCount(); i++) {
            View listItemSoftware = adapterSoftware.getView(i, null, lvSoftware);
            listItemSoftware.measure(0, 0);
            totalHeight += listItemSoftware.getMeasuredHeight();
        }

        ViewGroup.LayoutParams paramsSof = lvSoftware.getLayoutParams();
        paramsSof.height = totalHeight + (lvSoftware.getDividerHeight() * (adapterSoftware.getCount() - 1));
        lvSoftware.setLayoutParams(paramsSof);
        lvSoftware.requestLayout();

		
		/*
		 * Monta lista de Beneficio e passa para AdapterBeneficio 
		 */
		layoutBeneficio = R.layout.lista_beneficio_customizado;
		lstBeneficio = new ArrayList<String>();
		
		if (oportunidade.getBeneficios().size() == 0){
			oportunidade.setBeneficios(this.listaBeneficioVazio());
		}
		for (int b=0;b<oportunidade.getBeneficios().size();b++){
			lstBeneficio.add(oportunidade.getBeneficios().get(b).getBeneficio_descricao());
		}

		
		adapterBeneficio = new ArrayAdapter<String>(this, layoutBeneficio, labelBeneficio, lstBeneficio);
		lvBeneficio.setAdapter(adapterBeneficio);

		/*
		 * Dimensiona ListView Beneficio conforme quantidade de items
		 */
	    totalHeight = 0;
        for (int i = 0; i < adapterBeneficio.getCount(); i++) {
            View listItemBeneficio = adapterBeneficio.getView(i, null, lvBeneficio);
            listItemBeneficio.measure(0, 0);
            totalHeight += listItemBeneficio.getMeasuredHeight();
        }

        ViewGroup.LayoutParams paramsBen = lvBeneficio.getLayoutParams();
        paramsBen.height = totalHeight + (lvBeneficio.getDividerHeight() * (adapterBeneficio.getCount() - 1));
        lvBeneficio.setLayoutParams(paramsBen);
        lvBeneficio.requestLayout();

		
		preferencia = new Preferencia();
		preferenciaDAO = new PreferenciaDAOImpl(this);
		this.preferencia = preferenciaDAO.detalhesPreferencia();
	
		curriculo = new Curriculo();
		curriculoDAO = new CurriculoDAOImpl(this);
		this.curriculo = curriculoDAO.detalhesCurriculo();

		carregar_xmlEmail();
			
	}	

	public void onClickEmail(View v){
		MensangensEnviarEmail(this);
	}
	public void onClickSair(View v){
		Controle.Mensangens(this);
	}
	
	public void onClickVoltar(View v){
		Controle.Voltar(this);
	}
	
	/*
	 * Metodo para estatística
	 */
	public void atualizarEstatistica(){
		taskEstatistica = new EstatisticaTask();
		taskEstatistica.execute();
	}
		
	/*
	 * Metodo para enviar e-mail com anexo
	 */
	public void enviarEmail() {
		Properties props = new Properties();
		props.put("mail.smtp.host", configEmail.getEmail_smtp());
		props.put("mail.smtp.socketFactory.port", "587");
		props.put("mail.smtp.socketFactory.fallback", "false");  
		//props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", configEmail.getEmail_auth());
		props.put("mail.smtp.starttls.enable", configEmail.getEmail_tls()); 
		props.put("mail.smtp.port", configEmail.getEmail_porta());

		session = Session.getDefaultInstance(props);

		/*
		session = Session.getDefaultInstance(props,	new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(preferencia.getPreferencia_email(), preferencia.getPreferencia_senha());
			}
		});*/
		session.setDebug(true);
		if(configEmail.getEmail_id() > 0 && preferencia.getPreferencia_codigo() > 0 && curriculo.getCurriculo_codigo() > 0){
			pdialog = ProgressDialog.show(this, bundle.getString("lbl_enviar_email_titulo"), bundle.getString("lbl_enviar_email_mensagem"), true);
			taskEmail = new EnviarEmailTask();
			taskEmail.execute();
		}
		else{
			Controle.ExibeToast(bundle.getString("lbl_enviar_email_falha"),this);
		}
		
	}
	
	class EnviarEmailTask extends AsyncTask<String, Void, String> {

		String retorno;
		
		protected void onPreExecute() {
			
		};
		
		@Override
		protected String doInBackground(String... params) {
			
			try{
				/*
				 * Enviar e-mail para oportunidade
				 */
				
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(preferencia.getPreferencia_email(), preferencia.getPreferencia_nome()));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(oportunidade.getOportunidade_contato()));
				message.setSubject(bundle.getString("lbl_enviar_email_assunto")+" - ["+oportunidade.getOportunidade_funcao()+"] - " + preferencia.getPreferencia_nome());
				MimeBodyPart textPart = new MimeBodyPart();
				textPart.setContent(htmlMessage(), "text/html; charset=utf-8");
				
				Multipart mps = new MimeMultipart();
				
				MimeBodyPart anexo = new MimeBodyPart();
				anexo.setDataHandler(new DataHandler(new ByteArrayDataSource(curriculo.getCurriculo_arquivo(), "application/octet-stream")));  
				anexo.setFileName(curriculo.getCurriculo_descricao());
				
				MailcapCommandMap mailmap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
				mailmap.addMailcap("multipart/mixed;;x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
				
				mps.addBodyPart(textPart);
				
				mps.addBodyPart(anexo);
				
				message.setContent(mps);
			
				Transport tr = session.getTransport("smtp");
				tr.connect(configEmail.getEmail_email(), configEmail.getEmail_senha());
				tr.sendMessage(message, message.getAllRecipients()); 
				tr.close();
								
				/*
				 * enviar copia de e-mail para usuario do APP
				 */
				
				Message messageCopy = new MimeMessage(session);
				messageCopy.setFrom(new InternetAddress(configEmail.getEmail_email(), bundle.getString("lbl_enviar_email_msg_copia_jobs")+"["+ oportunidade.getOportunidade_id() +"] - "+ oportunidade.getOportunidade_funcao()));
				messageCopy.setRecipients(Message.RecipientType.TO, InternetAddress.parse(preferencia.getPreferencia_email()));
				messageCopy.setSubject(bundle.getString("lbl_enviar_email_assunto"));
				MimeBodyPart textPartCopy = new MimeBodyPart();
				// Define corpo do e-mai
				textPartCopy.setContent(htmlMessageCopia(), "text/html; charset=utf-8");
				
				Multipart mpsCopy = new MimeMultipart();
				
				MailcapCommandMap mailmapCopy = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
				mailmapCopy.addMailcap("multipart/mixed;;x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
				
				mpsCopy.addBodyPart(textPartCopy);
				
				messageCopy.setContent(mpsCopy);
				
				Transport trCopy = session.getTransport("smtp");
				trCopy.connect(configEmail.getEmail_email(),configEmail.getEmail_senha()); 
				trCopy.sendMessage(messageCopy, messageCopy.getAllRecipients());   
				trCopy.close();
			
				retorno = "1";
				
			} catch(MessagingException e) {
				e.printStackTrace();
				retorno = "2";
			} catch(Exception e) {
				e.printStackTrace();
				retorno = "2";
			}
			return retorno;
		}
		
		@Override
		protected void onPostExecute(String result) {
			String resposta;
			if (result.equals("1")){
				resposta = bundle.getString("lbl_enviar_email_sucesso");
				gravarHistorico();
				popularEnviado(preferencia, oportunidade);
				
			}
			else{
				resposta = bundle.getString("lbl_enviar_email_falha_2");
			}
			pdialog.dismiss();
			Controle.ExibeToast(resposta, getApplicationContext());
		}
					
	}
	
	// Atualiza estatistica via WS
		class EstatisticaTask extends AsyncTask<String, Void, String> {
			String retorno;
			protected void onPreExecute() {};
			
			@Override
			protected String doInBackground(String... params) {
			try {
					ws.gravarInformacoesEstatistica(enviado, preferencia);
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
	 * Metodo para criar HTML para E-mail
	 */
	private String htmlMessage() {
		String htmlMessage = null;
		htmlMessage = "<html>" + "<head>" + "<title>"
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<div align=center style='background-color:#FF8C00; width:100%; height:20px; font-size: medium; font-family: Arial;'>"
				+ "<b>"
				+ "</b>"
				+ "</div><div style='background-color:#E8E8E8; width:100%; height:300px;'>"
				+ bundle.getString("lbl_enviar_email_msg_prezado")
				+ "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ bundle.getString("lbl_enviar_email_msg_corpo")
				+ "<b>&nbsp;&nbsp;"+oportunidade.getOportunidade_id() +" - " + oportunidade.getOportunidade_funcao() + "</b>"
				+ "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+bundle.getString("lbl_enviar_email_msg_anexo")
				+ "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ bundle.getString("lbl_enviar_email_msg_agradecimento")
				+ "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+bundle.getString("lbl_enviar_email_msg_atenciosamente")
				+ "<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ preferencia.getPreferencia_nome()
				+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ preferencia.getPreferencia_email()
				+ "</b>"
				+ "</br>"
				+ "</div><div align=center style='background-color:#FF8C00; width:100%; height:20px; font-size:xx-small; font-family: Arial;'>"
				+ "<b>" +bundle.getString("lbl_enviar_email_titulo") +"</b>"
				+ "</div></body></html>";
		return htmlMessage;
	}
	
	private String htmlMessageCopia() {
		String htmlMessage = null;
		htmlMessage = "<html>" + "<head>" + "<title>"
				+ "</title>"
				+ "</head>"
				+ "<body>"
				+ "<div align=center style='background-color:#FF8C00; width:100%; height:20px; font-size: medium; font-family: Arial;'>"
				+ "<b>"
				+ "</b>"
				+ "</div><div style='background-color:#E8E8E8; width:100%; height:300px;'>"
				+ bundle.getString("lbl_enviar_email_msg_copia_prezado")
				+ "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ bundle.getString("lbl_enviar_email_msg_copia_corpo")
				+ "<b>&nbsp;&nbsp;"+ oportunidade.getOportunidade_contato() + "</b>"
				+ "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+bundle.getString("lbl_enviar_email_msg_copia_oportunidade")
				+"<b>&nbsp;&nbsp;"+oportunidade.getOportunidade_id() +" - " + oportunidade.getOportunidade_funcao() + "</b>"
				+ "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ bundle.getString("lbl_enviar_email_msg_copia_agradecimento")
				+ "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+bundle.getString("lbl_enviar_email_msg_copia_atenciosamente")
				+ "<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ bundle.getString("lbl_enviar_email_msg_copia_jobs")
				+ "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
				+ "</b>"
				+ "</br>"
				+ "</div><div align=center style='background-color:#FF8C00; width:100%; height:20px; font-size:xx-small; font-family: Arial;'>"
				+ "<b>" +bundle.getString("lbl_enviar_email_titulo") +"</b>"
				+ "</div></body></html>";
		return htmlMessage;
	}
	
	
	public void MensangensEnviarEmail(final Activity ac) {
		AlertDialog.Builder builder = new AlertDialog.Builder(ac);
		builder.setTitle(bundle.getString("lbl_enviar_email_titulo_enviar"))
				.setMessage(bundle.getString("lbl_enviar_email_msg_enviar"))
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton(bundle.getString("lbl_enviar_email_sim"),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								enviarEmail();
							}
						})
				.setNegativeButton(bundle.getString("lbl_enviar_email_nao"),null).show();
	}
	
	@SuppressLint("SimpleDateFormat")
	public void gravarHistorico(){
		historicoDAO = new HistoricoDAOImpl(this);
		historico = new Historico();
		historico.setHistorico_codigo_oportunidade(oportunidade.getOportunidade_id());
		historico.setHistorico_descricao_oportunidade(oportunidade.getOportunidade_funcao());
		historico.setHistorico_descricao_cidade_estado(oportunidade.getOportunidade_cidade()+" - "+oportunidade.getOportunidade_estado());
		historico.setHistorico_descricao_categoria(oportunidade.getOportunidade_categoria());
		historico.setHistorico_contato(oportunidade.getOportunidade_contato());
		// Pega data atual
		Date dataHoje = new Date();
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		String data = formataData.format(dataHoje);
		historico.setHistorico_data_envio(data);
		historicoDAO.salvar(historico);
	}
	
	public void popularEnviado(Preferencia preferencia, Oportunidade oportunidade){
		enviado = new Enviado();
		enviado.setEnviado_nome(preferencia.getPreferencia_nome());
		enviado.setEnviado_email(preferencia.getPreferencia_email());
		enviado.setEnviado_oportunidade_id(oportunidade.getOportunidade_id());
		this.atualizarEstatistica();
	}

	public void carregar_xmlEmail() {
	
		thread = new Thread() {
			@Override
			public void run() {
				try {
					xmlEmail = ws.consultarInformacoesEmail();
					android.os.Message msg = new android.os.Message();
					msg.obj = xmlEmail;
					handlerEmail.sendMessage(msg);
					Log.i("XML", xmlEmail);
				} catch (Exception e) {
					System.out.println("Erro!!: " + e.getMessage());
				}
			}
		};
		thread.start();
	}

	public void montarXMLEmail(String xml) {
		XMLParser parser = new XMLParser();
		
		Document doc = parser.getDomElement(xmlEmail);
		NodeList nl = doc.getElementsByTagName(KEY_EMAIL);
		for (int i = 0; i < nl.getLength(); i++) {
			configEmail = new ConfigEmail();
			Element e = (Element) nl.item(i);
			configEmail.setEmail_id(Integer.parseInt(parser.getValue(e, KEY_EMAIL_CODIGO)));
			configEmail.setEmail_smtp(parser.getValue(e, KEY_EMAIL_SMTP));
			configEmail.setEmail_email(parser.getValue(e, KEY_EMAIL_EMAIL));
			configEmail.setEmail_senha(parser.getValue(e, KEY_EMAIL_SENHA));
			configEmail.setEmail_porta(parser.getValue(e, KEY_EMAIL_PORTA));
			configEmail.setEmail_auth(parser.getValue(e, KEY_EMAIL_AUTH));
			configEmail.setEmail_tls(parser.getValue(e, KEY_EMAIL_TLS));
		}
		
	}	
	
	@SuppressLint("HandlerLeak")
	private Handler handlerEmail = new Handler() {
		public void handleMessage(android.os.Message msg) {
			montarXMLEmail(xmlEmail);
		}
	};

	@Override
	protected void onDestroy() {
		super.onDestroy();
		if (taskEmail != null ){
			taskEmail.cancel(true);
		}
		if (taskEstatistica !=null){
			taskEstatistica.cancel(true);
		}
	}
	
	public List<Idioma> listaIdiomaVazio(){
		Idioma idioma = new Idioma();
		idiomas = new ArrayList<Idioma>();
		idioma.setIdioma_descricao(bundle.getString("lbl_oportunidade_nenhum_idioma"));
		idiomas.add(idioma);
		return idiomas;
	}
	
	public List<Software> listaSoftwareVazio(){
		Software software = new Software();
		softwares = new ArrayList<Software>();
		software.setSoftware_descricao(bundle.getString("lbl_oportunidade_nenhum_software"));
		softwares.add(software);
		return softwares;
	}
	
	public List<Beneficio> listaBeneficioVazio(){
		Beneficio beneficio = new Beneficio();
		beneficios = new ArrayList<Beneficio>();
		beneficio.setBeneficio_descricao(bundle.getString("lbl_oportunidade_nenhum_beneficio"));
		beneficios.add(beneficio);
		return beneficios;
	}
}
