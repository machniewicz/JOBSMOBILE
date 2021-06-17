package br.com.jobs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import br.com.jobs.dao.HistoricoDAOImpl;
import br.com.jobs.modelo.Historico;
import br.com.jobs.util.Controle;

public class HistoricoActivity extends ListActivity{

	private Integer layout;
	private TextView txtRodape;
	private int label[] = { R.id.lbl_historico_registro, R.id.lbl_historico_data, R.id.lbl_historico_codigo_funcao, R.id.lbl_historico_contato};
	private String[] campos = { KEY_HISTORICO_REGISTRO, KEY_HISTORICO_DATA, KEY_HISTORICO_OPORTUNIDADE, KEY_HISTORICO_CONTATO };
	
	private static ArrayList<HashMap<String, String>> lstRegistro;
	private ArrayList<Historico> historicos;
	private ListAdapter adapterHistorico;
	private Historico historico;
	
	private HistoricoDAOImpl historicodb;
	
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");

	static final String KEY_HISTORICO_CODIGO = "historico_codigo";
	static final String KEY_HISTORICO_REGISTRO ="historico_registros";
	static final String KEY_HISTORICO_DATA="historico_data";
	static final String KEY_HISTORICO_OPORTUNIDADE = "historico_oportunidade";
	static final String KEY_HISTORICO_CONTATO = "historico_contato";
	
	private ProgressDialog pd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historico);
		layout = R.layout.lista_historico_customizado;
		txtRodape = (TextView) findViewById(R.id.tvRodape);
		txtRodape.setText(R.string.activity_historico);
		historicodb = new HistoricoDAOImpl(this);
		carregar_historico();
	}

	public void onClickVoltar(View v) {
		Controle.Voltar(this);
	}

	public void carregar_historico() {
		pd = ProgressDialog.show(this, bundle.getString("lbl_dialog_titulo"), bundle.getString("lbl_historico_dialog_titulo"), true, false);
		int registro = 0;
		lstRegistro = new ArrayList<HashMap<String, String>>();
		historicos = new ArrayList<Historico>(); 
		historicos =  (ArrayList<Historico>) historicodb.carregaHistorico();
		for(int i= 0;i < historicos.size();i++){
			HashMap<String, String> map = new HashMap<String, String>();
			registro = i+1;
			map.put(KEY_HISTORICO_CODIGO, historicos.get(i).getHistorico_codigo().toString());
			map.put(KEY_HISTORICO_REGISTRO, bundle.getString("lbl_historico_registros") +registro);
			map.put(KEY_HISTORICO_DATA, bundle.getString("lbl_historico_data_envio")+ historicos.get(i).getHistorico_data_envio());
			map.put(KEY_HISTORICO_OPORTUNIDADE, historicos.get(i).getHistorico_codigo_oportunidade() +" - "+ historicos.get(i).getHistorico_descricao_oportunidade());
			map.put(KEY_HISTORICO_CONTATO, "Enviado para: " + historicos.get(i).getHistorico_contato());
		lstRegistro.add(map);
		}
		if (lstRegistro.size() == 0){
			pd.dismiss();
			Intent inVazio = new Intent(this,VazioActivity.class);
			startActivity(inVazio);
			Controle.Voltar(this);
		}
		else{
		adapterHistorico = new SimpleAdapter(this, lstRegistro, layout, campos, label);
		setListAdapter(adapterHistorico);
		pd.dismiss();
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id){
		super.onListItemClick(l, v, position, id);
		Integer codigoHistorico = Integer.parseInt(lstRegistro.get(position).get(KEY_HISTORICO_CODIGO));
		MensangensExcluirHistorico(this, codigoHistorico);
	}

	public void MensangensExcluirHistorico(final Activity ac, final Integer codigo) {
		AlertDialog.Builder builder = new AlertDialog.Builder(ac);
		builder.setTitle(bundle.getString("lbl_historico_titulo"))
				.setMessage(bundle.getString("lbl_historico_msg"))
				.setIcon(android.R.drawable.ic_dialog_alert)
				.setPositiveButton(bundle.getString("lbl_historico_sim"),
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								historico = new Historico();
								historico = historicodb.carregaDetalheHistorico(codigo);
								historicodb.excluir(historico);
								carregar_historico();
							}
						})
				.setNegativeButton(bundle.getString("lbl_historico_nao"),null).show();
	}	
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		historicodb.finalizaBanco();
	}
}
