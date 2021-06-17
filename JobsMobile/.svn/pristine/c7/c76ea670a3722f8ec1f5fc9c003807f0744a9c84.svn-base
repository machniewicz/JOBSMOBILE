package br.com.jobs.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.jobs.bancodados.BancoDados;
import br.com.jobs.modelo.Curriculo;

public class CurriculoDAOImpl implements CurriculoDAO {

	private SQLiteDatabase bd;
	
	public CurriculoDAOImpl(Context context){
		BancoDados auxBd = new BancoDados(context);
		bd = auxBd.getWritableDatabase();
	}
	
	@Override
	public void salvar(Curriculo curriculo) {
		ContentValues valores = new ContentValues();
		valores.put(Curriculo.CURRICULO_ARQUIVO, curriculo.getCurriculo_arquivo());
		valores.put(Curriculo.CURRICULO_DT_INCLUSAO, curriculo.getCurriculo_data_inclusao());
		valores.put(Curriculo.CURRICULO_DESCRICAO,curriculo.getCurriculo_descricao());
		bd.insert(Curriculo.CURRICULO, null, valores);
	}

	@Override
	public void atualizar(Curriculo curriculo) {
		ContentValues valores = new ContentValues();
		valores.put(Curriculo.CURRICULO_ARQUIVO, curriculo.getCurriculo_arquivo());
		valores.put(Curriculo.CURRICULO_DT_INCLUSAO, curriculo.getCurriculo_data_inclusao());
		valores.put(Curriculo.CURRICULO_DESCRICAO,curriculo.getCurriculo_descricao());
		bd.update(Curriculo.CURRICULO, valores, Curriculo.CURRICULO_CODIGO +" = ?", new String[]{""+curriculo.getCurriculo_codigo()});
	}

	@Override
	public void excluir(Curriculo curriculo) {
		bd.delete(Curriculo.CURRICULO, Curriculo.CURRICULO_CODIGO +" = "+curriculo.getCurriculo_codigo(), null);
	}

	@Override
	public List<Curriculo> carregaCurriculo() {
		List<Curriculo> list = new ArrayList<Curriculo>();
		String[] colunas = new String[]{Curriculo.CURRICULO_CODIGO, Curriculo.CURRICULO_ARQUIVO, Curriculo.CURRICULO_DESCRICAO, Curriculo.CURRICULO_DT_INCLUSAO};
		Cursor cursor = bd.query(Curriculo.CURRICULO, colunas, null, null, null, null, Curriculo.CURRICULO_CODIGO +" ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			do{
				Curriculo c = new Curriculo();
				
				c.setCurriculo_codigo(cursor.getInt(0));;
				c.setCurriculo_arquivo(cursor.getBlob(1));
				c.setCurriculo_descricao(cursor.getString(2));
				c.setCurriculo_data_inclusao(cursor.getString(3));
				list.add(c);
				
			}while(cursor.moveToNext());
		}
		cursor.close();
		return(list);
	}

	@SuppressLint("SimpleDateFormat")
	public Date converteData(String data) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dataTmp = null;
		try {
			dataTmp = new Date(format.parse(data).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		return dataTmp;
	}

	@Override
	public Curriculo detalhesCurriculo() {
		Curriculo c = new Curriculo();
		String[] colunas = new String[]{Curriculo.CURRICULO_CODIGO, Curriculo.CURRICULO_ARQUIVO, Curriculo.CURRICULO_DESCRICAO, Curriculo.CURRICULO_DT_INCLUSAO};
		Cursor cursor = bd.query(Curriculo.CURRICULO, colunas, null, null, null, null, Curriculo.CURRICULO_CODIGO +" ASC");
		if(cursor != null && cursor.moveToFirst()){
			c.setCurriculo_codigo(cursor.getInt(0));;
			c.setCurriculo_arquivo(cursor.getBlob(1));
			c.setCurriculo_descricao(cursor.getString(2));
			c.setCurriculo_data_inclusao(cursor.getString(3));
		
		}else{
			c.setCurriculo_codigo(0);
		}
		cursor.close();
		return c;
	}

	public void finalizaBanco(){
		bd.close();
	}
	
}
