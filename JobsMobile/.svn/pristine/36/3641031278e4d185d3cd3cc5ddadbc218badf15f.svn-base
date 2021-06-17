package br.com.jobs;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import br.com.jobs.modelo.Opcao;
import br.com.jobs.modelo.Preferencia;
import br.com.jobs.util.Controle;
import br.com.jobs.util.FileArrayAdapter;

public class BuscarArquivoActivity extends ListActivity {
	
    private File currentDir;
    private FileArrayAdapter adapter;
    private Drawable imgPasta;
    private Drawable imgDoc;
    private Drawable imgVolta;
    private Integer layout;
	private TextView txtRodape;
	private ResourceBundle bundle = ResourceBundle.getBundle("br.com.jobs.idioma.messages_pt_BR");
	private Intent inCurriculo;
	private Preferencia preferencia;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_arquivo);
		layout = R.layout.lista_file_customizado;
		txtRodape = (TextView) findViewById(R.id.tvRodape);
		txtRodape.setText(R.string.activity_curriculo);
		inCurriculo = new Intent(this,CurriculoActivity.class);
		preferencia = (Preferencia) getIntent().getSerializableExtra("objPreferencia");
		currentDir = new File("/sdcard/");
		fill(currentDir);
    }
    
    public void onClickVoltar(View v) {
		Controle.Voltar(this);
		startActivity(inCurriculo);
	}
        
    @SuppressLint("DefaultLocale")
	private void fill(File f)
    {
    	Resources res = getResources();
    	File[]dirs = f.listFiles();
		this.txtRodape.setText(bundle.getString("lbl_diretorio_anexar")+f.getName());
		 List<Opcao>dir = new ArrayList<Opcao>();
		 List<Opcao>fls = new ArrayList<Opcao>();
		 try{
			 for(File ff: dirs)
			 {
				if(ff.isDirectory()){
					imgPasta = res.getDrawable(R.drawable.imagem_1);
					dir.add(new Opcao(ff.getName(),bundle.getString("lbl_pasta_anexar"),ff.getAbsolutePath(),imgPasta));
				}
				else
				{
					if(ff.getName().toUpperCase().endsWith(".PDF")|| ff.getName().toUpperCase().endsWith(".DOC") 
							|| ff.getName().toUpperCase().endsWith(".DOCX") || ff.getName().toUpperCase().endsWith(".ODT")  ){
					imgDoc = res.getDrawable(R.drawable.imagem_2);
					fls.add(new Opcao(ff.getName(),bundle.getString("lbl_documento_anexar")+ff.length(),ff.getAbsolutePath(),imgDoc));
					}
				}
			 }
		 }catch(Exception e)
		 {
			 
		 }
		 Collections.sort(dir);
		 Collections.sort(fls);
		 dir.addAll(fls);
		 imgVolta = res.getDrawable(R.drawable.imagem_0);
		 if(!f.getName().equalsIgnoreCase(bundle.getString("lbl_diretorio_default")))
			 dir.add(0,new Opcao(bundle.getString("lbl_diretorio_voltar2"),bundle.getString("lbl_diretorio_voltar"),f.getParent(),imgVolta));
		 adapter = new FileArrayAdapter(this,layout,dir);
		 this.setListAdapter(adapter);
    }
    @Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Opcao o = adapter.getItem(position);
		if(o.getData().equalsIgnoreCase(bundle.getString("lbl_pasta_anexar"))||o.getData().equalsIgnoreCase(bundle.getString("lbl_diretorio_voltar"))){
				currentDir = new File(o.getPath());
				fill(currentDir);
		}
		else
		{
			onFileClick(o);
		}
	}
    private void onFileClick(Opcao o)
    {
    	inCurriculo.putExtra("caminhoArquivo",o.getPath());
    	inCurriculo.putExtra("descricaoArquivo",o.getName());
    	inCurriculo.putExtra("objPreferencia", preferencia);
    	startActivity(inCurriculo);
		Controle.Voltar(this);
		Controle.ExibeToast(bundle.getString("lbl_documento_selecionado")+" " + o.getPath(), this);
    }
}