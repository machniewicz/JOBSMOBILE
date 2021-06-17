package br.com.jobs.broadcast;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class IniciarNotificacao extends BroadcastReceiver {

	/*
	 * Intervalo para repetir o alarme
	 * Repete de 4 em 4 horas
	 * H:MM:SS:Milleseconds
	 * 4*60*60*1000
	 */
	private static final int tempoRepetir = 4*60*60*1000;
	
	
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("Broadcast", "Dentro de onReceiver");
		agendar(context);	
	}

	public void agendar(Context contexto){
		Intent it = new Intent("VERIFICA_NOTIFICACAO");
		PendingIntent p = PendingIntent.getService(contexto, 0, it, 0);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		c.set(Calendar.HOUR_OF_DAY, 8);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		//c.add(Calendar.SECOND, segundos);
		AlarmManager alarme = (AlarmManager) contexto.getSystemService(Context.ALARM_SERVICE);
		long tempo = c.getTimeInMillis();
		alarme.setRepeating(AlarmManager.RTC_WAKEUP, tempo, tempoRepetir, p);
		
	} 
}
