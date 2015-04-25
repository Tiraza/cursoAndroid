package extractor.com.helloworld.sqlite.adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import extractor.com.helloworld.R;
import extractor.com.helloworld.sqlite.contato.Contato;

public class ContatoAdapter extends BaseAdapter {

    private ArrayList<Contato> contatos;
    private Context context;

    public ContatoAdapter(ArrayList<Contato> exercicios, Context context) {
        this.contatos = exercicios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contatos.size();
    }

    @Override
    public Contato getItem(int position) {
        return contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return  contatos.get(position).getId();
    }

    public Integer getId(int position){
        return  contatos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.listview_item, parent, false);

        TextView txtNome = (TextView) rootView.findViewById(R.id.txtNome);
        txtNome.setText(position + " - " + getItem(position).getNome());

        return rootView;
    }
}
