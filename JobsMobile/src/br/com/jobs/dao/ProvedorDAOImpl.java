package br.com.jobs.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.jobs.bancodados.BancoDados;
import br.com.jobs.modelo.Provedor;

public class ProvedorDAOImpl implements ProvedorDAO {

	private SQLiteDatabase bd;
	
	public ProvedorDAOImpl(Context context){
		BancoDados auxBd = new BancoDados(context);
		bd = auxBd.getWritableDatabase();
	}
	
	@Override
	public void salvar(Provedor provedor) {
		ContentValues valores = new ContentValues();
		valores.put(Provedor.PROVEDOR_DESCRICAO, provedor.getProvedor_descricao());
		valores.put(Provedor.PROVEDOR_SMTP, provedor.getProvedor_smtp());
		valores.put(Provedor.PROVEDOR_PORTA, provedor.getProvedor_porta());
		bd.insert(Provedor.PROVEDOR, null, valores);
		bd.close();
	}

	@Override
	public void atualizar(Provedor provedor) {
		ContentValues valores = new ContentValues();
		valores.put(Provedor.PROVEDOR_DESCRICAO, provedor.getProvedor_descricao());
		valores.put(Provedor.PROVEDOR_PORTA, provedor.getProvedor_porta());
		bd.update(Provedor.PROVEDOR, valores, Provedor.PROVEDOR_CODIGO +" = ?", new String[]{""+provedor.getProvedor_codigo()});
		bd.close();
	}

	@Override
	public void excluir(Provedor provedor) {
		bd.delete(Provedor.PROVEDOR, Provedor.PROVEDOR_CODIGO +" = "+provedor.getProvedor_codigo(), null);
		bd.close();
	}

	@Override
	public List<Provedor> carregaProvedor() {
		List<Provedor> list = new ArrayList<Provedor>();
		String[] colunas = new String[]{Provedor.PROVEDOR_CODIGO, Provedor.PROVEDOR_DESCRICAO, Provedor.PROVEDOR_SMTP, Provedor.PROVEDOR_PORTA};
		Cursor cursor = bd.query(Provedor.PROVEDOR, colunas, null, null, null, null, Provedor.PROVEDOR_CODIGO +" ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			do{
				Provedor p = new Provedor();
				p.setProvedor_codigo(cursor.getInt(0));
				p.setProvedor_descricao(cursor.getString(1));
				p.setProvedor_smtp(cursor.getString(2));
				p.setProvedor_porta(cursor.getString(3));
				list.add(p);
				
			}while(cursor.moveToNext());
		}
		cursor.close();
		return(list);
	}

	@Override
	public Provedor detalhesProvedor(Integer codigoProvedor) {
		Provedor p = new Provedor();
		String[] colunas = new String[]{Provedor.PROVEDOR_CODIGO, Provedor.PROVEDOR_DESCRICAO, Provedor.PROVEDOR_SMTP, Provedor.PROVEDOR_PORTA};
		Cursor cursor = bd.query(Provedor.PROVEDOR, colunas, Provedor.PROVEDOR_CODIGO + "=" + codigoProvedor.toString(), null, null, null, Provedor.PROVEDOR_CODIGO +" ASC");
		if(cursor != null && cursor.moveToFirst()){
			p.setProvedor_codigo(cursor.getInt(0));
			p.setProvedor_descricao(cursor.getString(1));
			p.setProvedor_smtp(cursor.getString(2));
			p.setProvedor_porta(cursor.getString(3));
		}else{
			p.setProvedor_codigo(0);
		}
		cursor.close();
		return p;
	}

	public void inserirDados(){
		ContentValues valoresGmail = new ContentValues();
		valoresGmail.put(Provedor.PROVEDOR_DESCRICAO, "GMail");
		valoresGmail.put(Provedor.PROVEDOR_SMTP, "smtp.gmail.com");
		valoresGmail.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresGmail);
		
		
		ContentValues valoresYahoo = new ContentValues();
		valoresYahoo.put(Provedor.PROVEDOR_DESCRICAO, "Yahoo");
		valoresYahoo.put(Provedor.PROVEDOR_SMTP, "smtp.mail.yahoo.com");
		valoresYahoo.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresYahoo);
		
		
		ContentValues valoresBol = new ContentValues();
		valoresBol.put(Provedor.PROVEDOR_DESCRICAO, "BOL");
		valoresBol.put(Provedor.PROVEDOR_SMTP, "smtps.bol.com.br");
		valoresBol.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresBol);
		
		
		ContentValues valoresHotmail = new ContentValues();
		valoresHotmail.put(Provedor.PROVEDOR_DESCRICAO, "Hotmail");
		valoresHotmail.put(Provedor.PROVEDOR_SMTP, "smtp.live.com");
		valoresHotmail.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresHotmail);
		
		
		ContentValues valoresIG = new ContentValues();
		valoresIG.put(Provedor.PROVEDOR_DESCRICAO, "IG");
		valoresIG.put(Provedor.PROVEDOR_SMTP, "smtp.ig.com.br");
		valoresIG.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresIG);
		
		
		ContentValues valoresGlobo = new ContentValues();
		valoresGlobo.put(Provedor.PROVEDOR_DESCRICAO, "Globo");
		valoresGlobo.put(Provedor.PROVEDOR_SMTP, "smtp.globo.com");
		valoresGlobo.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresGlobo);
		
		
		ContentValues valoresOI = new ContentValues();
		valoresOI.put(Provedor.PROVEDOR_DESCRICAO, "OI");
		valoresOI.put(Provedor.PROVEDOR_SMTP, "smtp.oi.com.br");
		valoresOI.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresOI);
		
		
		ContentValues valoresClick21 = new ContentValues();
		valoresClick21.put(Provedor.PROVEDOR_DESCRICAO, "Click21");
		valoresClick21.put(Provedor.PROVEDOR_SMTP, "smtp.click21.com.br");
		valoresClick21.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresClick21);
		
		
		ContentValues valoresUOL = new ContentValues();
		valoresUOL.put(Provedor.PROVEDOR_DESCRICAO, "Uol");
		valoresUOL.put(Provedor.PROVEDOR_SMTP, "smtps.uol.com.br");
		valoresUOL.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresUOL);
		
		
		ContentValues valoresBRTurbo = new ContentValues();
		valoresBRTurbo.put(Provedor.PROVEDOR_DESCRICAO, "BRTurbo");
		valoresBRTurbo.put(Provedor.PROVEDOR_SMTP, "smtp.brturbo.com.br");
		valoresBRTurbo.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresBRTurbo);
		
		
		ContentValues valoresCultura = new ContentValues();
		valoresCultura.put(Provedor.PROVEDOR_DESCRICAO, "Cultura");
		valoresCultura.put(Provedor.PROVEDOR_SMTP, "smtp.cultura.com.br");
		valoresCultura.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresCultura);
		
		
		ContentValues valoresR7 = new ContentValues();
		valoresR7.put(Provedor.PROVEDOR_DESCRICAO, "R7");
		valoresR7.put(Provedor.PROVEDOR_SMTP, "smtp.r7.com");
		valoresR7.put(Provedor.PROVEDOR_PORTA, "587");
		bd.insert(Provedor.PROVEDOR, null, valoresR7);
		
		bd.close();
		
	}
}
