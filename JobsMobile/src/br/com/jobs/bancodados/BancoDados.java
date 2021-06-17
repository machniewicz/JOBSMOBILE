package br.com.jobs.bancodados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import br.com.jobs.modelo.Curriculo;
import br.com.jobs.modelo.Historico;
import br.com.jobs.modelo.Preferencia;

public class BancoDados extends SQLiteOpenHelper {
	private static final String NOME_BD = "jobsmobile.db";
	private static final int VERSAO_BD = 6;
	
	
	public BancoDados(Context ctx){
		super(ctx, NOME_BD, null, VERSAO_BD);
	}
	
	@Override
	public void onCreate(SQLiteDatabase bd) {
		
		StringBuilder sqlPreferencia = new StringBuilder();
		sqlPreferencia.append("CREATE TABLE IF NOT EXISTS ");
		sqlPreferencia.append(Preferencia.PREFERENCIA + "(");
		sqlPreferencia.append(Preferencia.PREFERENCIA_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sqlPreferencia.append(Preferencia.PREFERENCIA_NOME + " TEXT NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_EMAIL + " TEXT NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_CPF + " TEXT NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_SENHA + " TEXT NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_ESTADO + " INTEGER NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_CATEGORIA + " INTEGER NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_FORMACAO + " INTEGER NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_SALARIO + " INTEGER NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_EXPERIENCIA + " TEXT NOT NULL);");
		bd.execSQL(sqlPreferencia.toString());
		
		StringBuilder sqlCurriculo = new StringBuilder();
		sqlCurriculo.append("CREATE TABLE IF NOT EXISTS ");
		sqlCurriculo.append(Curriculo.CURRICULO + "(");
		sqlCurriculo.append(Curriculo.CURRICULO_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sqlCurriculo.append(Curriculo.CURRICULO_ARQUIVO + " BLOB,");
		sqlCurriculo.append(Curriculo.CURRICULO_DESCRICAO + " TEXT NOT NULL,");
		sqlCurriculo.append(Curriculo.CURRICULO_DT_INCLUSAO + " TEXT NOT NULL);");
		bd.execSQL(sqlCurriculo.toString());
		
		StringBuilder sqlHistorico = new StringBuilder();
		sqlHistorico.append("CREATE TABLE IF NOT EXISTS ");
		sqlHistorico.append(Historico.HISTORICO + "(");
		sqlHistorico.append(Historico.HISTORICO_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sqlHistorico.append(Historico.HISTORICO_CODIGO_OPORTUNIDADE + " INTEGER NOT NULL,");
		sqlHistorico.append(Historico.HISTORICO_DESCRICAO_OPORTUNIDADE + " TEXT NOT NULL,");
		sqlHistorico.append(Historico.HISTORICO_DESCRICAO_CATEGORIA+ " TEXT NOT NULL,");
		sqlHistorico.append(Historico.HISTORICO_DESCRICAO_CIDADE_ESTADO + " TEXT NOT NULL,");
		sqlHistorico.append(Historico.HISTORICO_CONTATO + " TEXT NOT NULL,");
		sqlHistorico.append(Historico.HISTORICO_DATA_ENVIO + " TEXT NOT NULL);");
		bd.execSQL(sqlHistorico.toString());
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
		
		Log.i("Versão Velha", ""+oldVersion);
		Log.i("Versão Nova", ""+newVersion);
				
		/*
		 * Tabela Historico a partir da versão 2 - BD
		 */
		
		StringBuilder sqlHistorico = new StringBuilder();
		sqlHistorico.append("CREATE TABLE IF NOT EXISTS ");
		sqlHistorico.append(Historico.HISTORICO + "(");
		sqlHistorico.append(Historico.HISTORICO_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sqlHistorico.append(Historico.HISTORICO_CODIGO_OPORTUNIDADE + " INTEGER NOT NULL,");
		sqlHistorico.append(Historico.HISTORICO_DESCRICAO_OPORTUNIDADE + " TEXT NOT NULL,");
		sqlHistorico.append(Historico.HISTORICO_DESCRICAO_CATEGORIA+ " TEXT NOT NULL,");
		sqlHistorico.append(Historico.HISTORICO_DESCRICAO_CIDADE_ESTADO + " TEXT NOT NULL,");
		sqlHistorico.append(Historico.HISTORICO_CONTATO + " TEXT NOT NULL,");
		sqlHistorico.append(Historico.HISTORICO_DATA_ENVIO + " TEXT NOT NULL);");
		bd.execSQL(sqlHistorico.toString());
		
		/*
		 * Tabela Provedor a partir da versão 3 - BD
		 */
		//bd.execSQL("update provedor set provedor_porta='587';");
		//bd.execSQL("update provedor set provedor_smtp='smtp.ig.com.br' where provedor_codigo = 5");
		
		/*
		 * Tabela Provedor a partir da versão 4  e 5 - BD
		 */
		
		bd.execSQL("drop table preferencia;");
		//bd.execSQL("drop table provedor;");
		
		StringBuilder sqlPreferencia = new StringBuilder();
		sqlPreferencia.append("CREATE TABLE IF NOT EXISTS ");
		sqlPreferencia.append(Preferencia.PREFERENCIA + "(");
		sqlPreferencia.append(Preferencia.PREFERENCIA_CODIGO + " INTEGER PRIMARY KEY AUTOINCREMENT, ");
		sqlPreferencia.append(Preferencia.PREFERENCIA_NOME + " TEXT NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_EMAIL + " TEXT NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_CPF + " TEXT NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_SENHA + " TEXT NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_ESTADO + " INTEGER NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_CATEGORIA + " INTEGER NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_FORMACAO + " INTEGER NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_SALARIO + " INTEGER NOT NULL,");
		sqlPreferencia.append(Preferencia.PREFERENCIA_EXPERIENCIA + " TEXT NOT NULL);");
		bd.execSQL(sqlPreferencia.toString());

	}
	
	

}
