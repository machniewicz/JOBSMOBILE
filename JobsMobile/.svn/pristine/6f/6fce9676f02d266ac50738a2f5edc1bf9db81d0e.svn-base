package br.com.jobs.broadcast;

import java.util.ResourceBundle;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import br.com.jobs.PrincipalActivity;
import br.com.jobs.R;
import br.com.jobs.ws.Webservice;
import br.com.jobs.xml.XMLParser;

public class ServicoNotificacao extends Service{

	private String xmlNotificacao;
	private String [] notifica = new String[26];
	
	static final String KEY_NOTIFICACAO = "notificacao_item";
	static final String KEY_NOTIFICACAO_QUANTIDADE = "notificacao_quantidade";
	static final String KEY_NOTIFICACAO_SIGLA = "notificacao_estado";
	
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");
	private NotificacaoTask taskNotificacao = null;

	private Webservice ws;
	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		ws = new Webservice();
		Log.i("Broadcast","dentro de onCreate Service");
		super.onCreate();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		carregar_xmlNotificacao();
	}
	
	@Override
	public void onDestroy() {
		if (taskNotificacao != null ){
			taskNotificacao.cancel(true);
		}
		super.onDestroy();
		
	}
	
	public void carregar_xmlNotificacao(){
		taskNotificacao = new NotificacaoTask();
		taskNotificacao.execute();
	}

	@SuppressLint("HandlerLeak")
	private Handler handlerNotificacao = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			montarXMLNotificacao(xmlNotificacao);
			
		}
	};
	
	public void montarXMLNotificacao(String xml) {
		XMLParser parser = new XMLParser();
		Document doc = parser.getDomElement(xmlNotificacao);
		NodeList nl = doc.getElementsByTagName(KEY_NOTIFICACAO);
		for (int i = 0; i < nl.getLength(); i++) {
			Element e = (Element) nl.item(i);
			notifica[i] = parser.getValue(e, KEY_NOTIFICACAO_QUANTIDADE)+" "+ bundle.getString("lbl_notifica_mensagem") + parser.getValue(e, KEY_NOTIFICACAO_SIGLA);
		}
	}
	
	// Monta XML para exibir a Notificação de vagas
	class NotificacaoTask extends AsyncTask<String, Void, String> {

		String retorno;
		
		protected void onPreExecute() {
			
		};
		
		@Override
		protected String doInBackground(String... params) {
		try {
				xmlNotificacao = ws.consultarInformacoesNotificacao();
				if(!xmlNotificacao.equals("vazio")){
					Log.i("XMLNotificacao", xmlNotificacao);
					Message msg = new Message();
					msg.obj = xmlNotificacao;
					handlerNotificacao.sendMessage(msg);
					criarNotificacao();
					retorno = "1";
				}
			} catch (Exception e) {
				retorno = "2";
			}
		return retorno;
		}
		
		@Override
		protected void onPostExecute(String result) {
			
		}
	}

		
/*	@SuppressWarnings("deprecation")
	protected void criarNotificacao() {
	
		String mensagemBarraStatus = "Novas Oportunidades Jobs Mobile";
		String titulo = "Informação Jobs Mobile";
//		String mensagem = "Visualizar imagem do Download";
			
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		Notification notificacao = new Notification(R.drawable.jobs_medium_2, mensagemBarraStatus, java.lang.System.currentTimeMillis());
		Intent inPrincipal = new Intent(this,PrincipalActivity.class);
		//Intent intentMensagem = new Intent(this, activity);
		PendingIntent p = PendingIntent.getActivity(this, 0, inPrincipal, 0);
		notificacao.setLatestEventInfo(this, titulo, this.notificacao, p);
		notificacao.vibrate = new long[]{100,250,100,500};
		nm.notify(R.string.app_name, notificacao);
//		startActivity(inPrincipal);
//		nm.cancelAll();
	}
*/
	protected void criarNotificacao() {
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this,PrincipalActivity.class), 0);
		NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
		builder.setTicker(bundle.getString("lbl_notifica_ticker"));
		builder.setContentTitle(bundle.getString("lbl_notifica_titulo"));
		builder.setSmallIcon(R.drawable.jobs_medium_2);
		builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher));
		builder.setContentIntent(p);

		NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
		for (int i = 0; i < notifica.length; i++) {
			style.addLine(notifica[i]);
		}
		builder.setStyle(style);
		Notification n = builder.build();
		n.vibrate = new long[] { 150, 300, 150, 500 };
		n.flags = Notification.FLAG_AUTO_CANCEL;
		nm.notify(R.drawable.jobs_medium_2, n);

		try {
			Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
			Ringtone toque = RingtoneManager.getRingtone(this, som);
			toque.play();
		} catch (Exception e) {
			Log.e("Erro", "Falha ao tocar o som da notificação!");
		}
	}

}
	


