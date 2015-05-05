package extractor.com.helloworld.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import extractor.com.helloworld.R;

public class ExercicioAdapter extends BaseAdapter {

    private ArrayList<Exercicio> exercicios;
    private Context context;

    public ExercicioAdapter(ArrayList<Exercicio> exercicios, Context context) {
        this.exercicios = exercicios;
        this.context = context;
    }

    @Override
    public int getCount() {
        return exercicios.size();
    }

    @Override
    public Exercicio getItem(int position) {
        return exercicios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rootView = inflater.inflate(R.layout.listview_item, parent, false);

        if(position % 2 == 0){
            LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.layout_linha);
            layout.setBackgroundColor(context.getResources().getColor(R.color.abc_primary_text_disable_only_material_dark));
        }

        TextView txtNome = (TextView) rootView.findViewById(R.id.txtNome);
        txtNome.setText(position + " - " + getItem(position).getNome());

        return rootView;
    }
}
