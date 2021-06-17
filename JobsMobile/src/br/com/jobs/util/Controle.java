package br.com.jobs.util;

import java.util.ResourceBundle;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Controle {

	private static String msgInternet;
	private static ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");
	private static Boolean internetAcesso;
	
	/*
	 * Verifica Conexão com Internet
	 */
	public static String VerificaConexao(final Context contexto) {
		ConnectivityManager cm = (ConnectivityManager) contexto.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if ((netInfo != null) && (netInfo.isConnectedOrConnecting())
				&& (netInfo.isAvailable())) {
			msgInternet =  bundle.getString("msg_internet_true");
			setInternetAcesso(true);
			return msgInternet;
		} else {
			msgInternet =  bundle.getString("msg_internet_false");
			setInternetAcesso(false);
			return msgInternet;
		}
	}

	/*
	 * Exibe Mensagem para Fechar APP
	 */
	public static void Mensangens(final Activity ac) {
		AlertDialog.Builder builder = new AlertDialog.Builder(ac);
		builder.setTitle(bundle.getString("lbl_alert_dialog_titulo"))
				.setMessage(bundle.getString("lbl_alert_dialog_mensagem"))
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton(bundle.getString("lbl_alert_dialog_sim"),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								ac.finish();
								Toast.makeText(ac, bundle.getString("lbl_alert_dialog_toast"),
										Toast.LENGTH_SHORT).show();
							}
						}).setNegativeButton(bundle.getString("lbl_alert_dialog_nao"), null).show();
	}
	/*
	 * Exibe Mensagem de informação para acesso a Internet
	 */
	public static void MensangensInternet(final Activity ac) {
		AlertDialog.Builder builder = new AlertDialog.Builder(ac);
		builder.setTitle(bundle.getString("lbl_alert_dialog_titulo_internet"))
				.setMessage(bundle.getString("lbl_alert_dialog_mensagem_internet"))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(bundle.getString("lbl_alert_dialog_ok"),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,	int which) {
								Mensangens(ac);
							}
						}).show();
	}

	/*
	 * Exibe Mensagem de informação do Webservice
	 */
	public static void MensangensWS(final Activity ac) {
		AlertDialog.Builder builder = new AlertDialog.Builder(ac);
		builder.setTitle(bundle.getString("lbl_alert_dialog_titulo_ws"))
				.setMessage(bundle.getString("lbl_alert_dialog_mensagem_ws"))
				.setIcon(android.R.drawable.ic_dialog_info)
				.setPositiveButton(bundle.getString("lbl_alert_dialog_ok"),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,	int which) {
								
								//Mensangens(ac);
							}
						}).show();
	}

	/*
	 * Fecha activity atual - Voltar
	 */

	public static void Voltar(final Activity ac) {
		ac.finish();
	}

	/*
	 * Exibe Toast
	 */
	public static void ExibeToast(String msg, Context contexto) {
		Toast.makeText(contexto, msg, Toast.LENGTH_SHORT).show();
	}
	
	/*
	 * Seta atributo para True ou False para verificação posteriormente
	 */
	public static Boolean getInternetAcesso() {
		return internetAcesso;
	}

	public static void setInternetAcesso(Boolean internetAcesso) {
		Controle.internetAcesso = internetAcesso;
	}
	
}
