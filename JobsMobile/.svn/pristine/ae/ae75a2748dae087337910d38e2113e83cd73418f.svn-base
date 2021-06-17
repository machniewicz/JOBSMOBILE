package br.com.jobs.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.jobs.bancodados.BancoDados;
import br.com.jobs.modelo.Preferencia;

public class PreferenciaDAOImpl implements PreferenciaDAO {

	private SQLiteDatabase bd;
	
	public PreferenciaDAOImpl(Context context){
		BancoDados auxBd = new BancoDados(context);
		bd = auxBd.getWritableDatabase();
	}
	
	@Override
	public void salvar(Preferencia preferencia) {
		ContentValues valores = new ContentValues();
		valores.put(Preferencia.PREFERENCIA_NOME, preferencia.getPreferencia_nome());
		valores.put(Preferencia.PREFERENCIA_EMAIL, preferencia.getPreferencia_email());
		valores.put(Preferencia.PREFERENCIA_CPF, preferencia.getPreferencia_cpf());
		valores.put(Preferencia.PREFERENCIA_SENHA, preferencia.getPreferencia_senha());
		valores.put(Preferencia.PREFERENCIA_ESTADO, preferencia.getPreferencia_estado_id());
		valores.put(Preferencia.PREFERENCIA_CATEGORIA, preferencia.getPreferencia_categoria_id());
		valores.put(Preferencia.PREFERENCIA_EXPERIENCIA, preferencia.getPreferencia_experiencia());
		valores.put(Preferencia.PREFERENCIA_FORMACAO, preferencia.getPreferencia_formacao_id());
		valores.put(Preferencia.PREFERENCIA_SALARIO, preferencia.getPreferencia_salario_id());
		bd.insert(Preferencia.PREFERENCIA, null, valores);
		
	}

	@Override
	public void atualizar(Preferencia preferencia) {
		ContentValues valores = new ContentValues();
		valores.put(Preferencia.PREFERENCIA_NOME, preferencia.getPreferencia_nome());
		valores.put(Preferencia.PREFERENCIA_EMAIL, preferencia.getPreferencia_email());
		valores.put(Preferencia.PREFERENCIA_CPF, preferencia.getPreferencia_cpf());
		valores.put(Preferencia.PREFERENCIA_SENHA, preferencia.getPreferencia_senha());
		valores.put(Preferencia.PREFERENCIA_ESTADO, preferencia.getPreferencia_estado_id());
		valores.put(Preferencia.PREFERENCIA_CATEGORIA, preferencia.getPreferencia_categoria_id());
		valores.put(Preferencia.PREFERENCIA_EXPERIENCIA, preferencia.getPreferencia_experiencia());
		valores.put(Preferencia.PREFERENCIA_FORMACAO, preferencia.getPreferencia_formacao_id());
		valores.put(Preferencia.PREFERENCIA_SALARIO, preferencia.getPreferencia_salario_id());
		bd.update(Preferencia.PREFERENCIA, valores, Preferencia.PREFERENCIA_CODIGO +" = ?", new String[]{""+preferencia.getPreferencia_codigo()});
		
	}

	@Override
	public void excluir(Preferencia preferencia) {
		bd.delete(Preferencia.PREFERENCIA, Preferencia.PREFERENCIA_CODIGO +" = "+preferencia.getPreferencia_codigo(), null);
		
	}

	@Override
	public List<Preferencia> carregaPreferencia() {
		List<Preferencia> list = new ArrayList<Preferencia>();
		String[] colunas = new String[]{Preferencia.PREFERENCIA_CODIGO, Preferencia.PREFERENCIA_NOME, Preferencia.PREFERENCIA_EMAIL, Preferencia.PREFERENCIA_CPF, Preferencia.PREFERENCIA_SENHA, Preferencia.PREFERENCIA_ESTADO,Preferencia.PREFERENCIA_CATEGORIA,Preferencia.PREFERENCIA_EXPERIENCIA,Preferencia.PREFERENCIA_FORMACAO,Preferencia.PREFERENCIA_SALARIO};
		Cursor cursor = bd.query(Preferencia.PREFERENCIA, colunas, null, null, null, null, Preferencia.PREFERENCIA_NOME +" ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			do{
				Preferencia p = new Preferencia();
				p.setPreferencia_codigo(cursor.getInt(0));
				p.setPreferencia_nome(cursor.getString(1));
				p.setPreferencia_email(cursor.getString(2));
				p.setPreferencia_cpf(cursor.getString(3));
				p.setPreferencia_senha(cursor.getString(4));
				p.setPreferencia_estado_id(cursor.getInt(5));
				p.setPreferencia_categoria_id(cursor.getInt(6));
				p.setPreferencia_experiencia(cursor.getInt(7));
				p.setPreferencia_formacao_id(cursor.getInt(8));
				p.setPreferencia_salario_id(cursor.getInt(9));
				list.add(p);
				
			}while(cursor.moveToNext());
		}
		cursor.close();
		return(list);
	}

	@Override
	public Preferencia detalhesPreferencia() {
		Preferencia p = new Preferencia();
		String[] colunas = new String[]{Preferencia.PREFERENCIA_CODIGO, Preferencia.PREFERENCIA_NOME, Preferencia.PREFERENCIA_EMAIL, Preferencia.PREFERENCIA_CPF, Preferencia.PREFERENCIA_SENHA, Preferencia.PREFERENCIA_ESTADO,Preferencia.PREFERENCIA_CATEGORIA,Preferencia.PREFERENCIA_EXPERIENCIA,Preferencia.PREFERENCIA_FORMACAO,Preferencia.PREFERENCIA_SALARIO};
		Cursor cursor = bd.query(Preferencia.PREFERENCIA, colunas, null, null, null, null, Preferencia.PREFERENCIA_NOME +" ASC");
		if(cursor != null && cursor.moveToFirst()){
			p.setPreferencia_codigo(cursor.getInt(0));
			p.setPreferencia_nome(cursor.getString(1));
			p.setPreferencia_email(cursor.getString(2));
			p.setPreferencia_cpf(cursor.getString(3));
			p.setPreferencia_senha(cursor.getString(4));
			p.setPreferencia_estado_id(cursor.getInt(5));
			p.setPreferencia_categoria_id(cursor.getInt(6));
			p.setPreferencia_experiencia(cursor.getInt(7));
			p.setPreferencia_formacao_id(cursor.getInt(8));
			p.setPreferencia_salario_id(cursor.getInt(9));
	}else{
			p.setPreferencia_codigo(0);
		}
		cursor.close();
		return p;
	}
	
	public void finalizaBanco(){
		bd.close();
	}

}
