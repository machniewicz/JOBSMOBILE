package br.com.jobs.util;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.jobs.R;
import br.com.jobs.modelo.Opcao;


public class FileArrayAdapter extends ArrayAdapter<Opcao>{

	private Context c;
	private int id;
	private List<Opcao>items;
	
	public FileArrayAdapter(Context context, int textViewResourceId,
			List<Opcao> objects) {
		super(context, textViewResourceId, objects);
		c = context;
		id = textViewResourceId;
		items = objects;
	}
	public Opcao getItem(int i)
	 {
		 return items.get(i);
	 }
	 @Override
       public View getView(int position, View convertView, ViewGroup parent) {
               View v = convertView;
               if (v == null) {
                   LayoutInflater vi = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                   v = vi.inflate(id, null);
               }
               final Opcao o = items.get(position);
               if (o != null) {
                       TextView t1 = (TextView) v.findViewById(R.id.txtDescricaoPasta);
                       TextView t2 = (TextView) v.findViewById(R.id.txtPastaDados);
                       ImageView img = (ImageView) v.findViewById(R.id.imgPastaDoc);
                       if(t1!=null)
                       	t1.setText(o.getName());
                       	img.setImageDrawable(o.getImage());
                       if(t2!=null)
                       	t2.setText(o.getData());
                       
               }
               return v;
       }

}
