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
import br.com.jobs.modelo.Historico;

public class HistoricoDAOImpl implements HistoricoDAO {

	private SQLiteDatabase bd;
	
	public HistoricoDAOImpl(Context context){
		BancoDados auxBd = new BancoDados(context);
		bd = auxBd.getWritableDatabase();
	}
	
	@Override
	public void salvar(Historico historico) {
		ContentValues valores = new ContentValues();
		valores.put(Historico.HISTORICO_CODIGO_OPORTUNIDADE, historico.getHistorico_codigo_oportunidade());
		valores.put(Historico.HISTORICO_DESCRICAO_OPORTUNIDADE, historico.getHistorico_descricao_oportunidade());
		valores.put(Historico.HISTORICO_DESCRICAO_CIDADE_ESTADO, historico.getHistorico_descricao_cidade_estado());
		valores.put(Historico.HISTORICO_DESCRICAO_CATEGORIA,historico.getHistorico_descricao_categoria());
		valores.put(Historico.HISTORICO_CONTATO, historico.getHistorico_contato());
		valores.put(Historico.HISTORICO_DATA_ENVIO, historico.getHistorico_data_envio());
		bd.insert(Historico.HISTORICO, null, valores);
		
	}

	@Override
	public void atualizar(Historico historico) {
		ContentValues valores = new ContentValues();
		valores.put(Historico.HISTORICO_CODIGO_OPORTUNIDADE, historico.getHistorico_codigo_oportunidade());
		valores.put(Historico.HISTORICO_DESCRICAO_OPORTUNIDADE, historico.getHistorico_descricao_oportunidade());
		valores.put(Historico.HISTORICO_DESCRICAO_CIDADE_ESTADO, historico.getHistorico_descricao_cidade_estado());
		valores.put(Historico.HISTORICO_DESCRICAO_CATEGORIA,historico.getHistorico_descricao_categoria());
		valores.put(Historico.HISTORICO_CONTATO, historico.getHistorico_contato());
		valores.put(Historico.HISTORICO_DATA_ENVIO, historico.getHistorico_data_envio());
		bd.update(Historico.HISTORICO, valores, Historico.HISTORICO_CODIGO +" = ?", new String[]{""+historico.getHistorico_codigo()});
		
	}

	@Override
	public void excluir(Historico historico) {
		bd.delete(Historico.HISTORICO, Historico.HISTORICO_CODIGO +" = "+historico.getHistorico_codigo(), null);
		
	}

	@Override
	public List<Historico> carregaHistorico() {
		List<Historico> list = new ArrayList<Historico>();
		String[] colunas = new String[]{Historico.HISTORICO_CODIGO, Historico.HISTORICO_CODIGO_OPORTUNIDADE, Historico.HISTORICO_DESCRICAO_OPORTUNIDADE, Historico.HISTORICO_DESCRICAO_CIDADE_ESTADO, Historico.HISTORICO_DESCRICAO_CATEGORIA, Historico.HISTORICO_CONTATO, Historico.HISTORICO_DATA_ENVIO};
		Cursor cursor = bd.query(Historico.HISTORICO, colunas, null, null, null, null, Historico.HISTORICO_CODIGO +" ASC");
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			do{
				Historico h = new Historico();
				h.setHistorico_codigo(cursor.getInt(0));
				h.setHistorico_codigo_oportunidade(cursor.getInt(1));
				h.setHistorico_descricao_oportunidade(cursor.getString(2));
				h.setHistorico_descricao_cidade_estado(cursor.getString(3));
				h.setHistorico_descricao_categoria(cursor.getString(4));
				h.setHistorico_contato(cursor.getString(5));
				h.setHistorico_data_envio(cursor.getString(6));
				list.add(h);
				
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
	public Historico detalhesHistorico() {
		Historico h = new Historico();
		String[] colunas = new String[]{Historico.HISTORICO_CODIGO, Historico.HISTORICO_CODIGO_OPORTUNIDADE, Historico.HISTORICO_DESCRICAO_OPORTUNIDADE, Historico.HISTORICO_DESCRICAO_CIDADE_ESTADO, Historico.HISTORICO_DESCRICAO_CATEGORIA, Historico.HISTORICO_CONTATO, Historico.HISTORICO_DATA_ENVIO};
		Cursor cursor = bd.query(Historico.HISTORICO, colunas, null, null, null, null, Historico.HISTORICO_CODIGO +" ASC");
		if(cursor != null && cursor.moveToFirst()){
			h.setHistorico_codigo(cursor.getInt(0));
			h.setHistorico_codigo_oportunidade(cursor.getInt(1));
			h.setHistorico_descricao_oportunidade(cursor.getString(2));
			h.setHistorico_descricao_cidade_estado(cursor.getString(3));
			h.setHistorico_descricao_categoria(cursor.getString(4));
			h.setHistorico_contato(cursor.getString(5));
			h.setHistorico_data_envio(cursor.getString(6));
	
		}
		else{
			h.setHistorico_codigo(0);
		}
		cursor.close();
		return h;
	}

	@Override
	public Historico carregaDetalheHistorico(Integer codigo) {
		Historico h = new Historico();
		String[] colunas = new String[]{Historico.HISTORICO_CODIGO, Historico.HISTORICO_CODIGO_OPORTUNIDADE, Historico.HISTORICO_DESCRICAO_OPORTUNIDADE, Historico.HISTORICO_DESCRICAO_CIDADE_ESTADO, Historico.HISTORICO_DESCRICAO_CATEGORIA, Historico.HISTORICO_CONTATO, Historico.HISTORICO_DATA_ENVIO};
		Cursor cursor = bd.query(Historico.HISTORICO, colunas, Historico.HISTORICO_CODIGO +" = ?", new String[]{""+codigo},null,null,Historico.HISTORICO_CODIGO +" ASC");
		if(cursor != null && cursor.moveToFirst()){
			h.setHistorico_codigo(cursor.getInt(0));
			h.setHistorico_codigo_oportunidade(cursor.getInt(1));
			h.setHistorico_descricao_oportunidade(cursor.getString(2));
			h.setHistorico_descricao_cidade_estado(cursor.getString(3));
			h.setHistorico_descricao_categoria(cursor.getString(4));
			h.setHistorico_contato(cursor.getString(5));
			h.setHistorico_data_envio(cursor.getString(6));	
		}
		else{
			h.setHistorico_codigo(0);
		}
		cursor.close();
		return h;
	}
	
	public void finalizaBanco(){
		bd.close();
	}
}
