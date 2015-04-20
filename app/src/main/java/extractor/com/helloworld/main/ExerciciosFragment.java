package extractor.com.helloworld.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import extractor.com.helloworld.R;

public class ExerciciosFragment extends Fragment {

    private ArrayList<Exercicio> exercicios;
    private Context context;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.exercicios = new ExercicioDAO().getExercicios();
        this.context = activity.getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exercicios, container, false);

        ListView listExercicos = (ListView) view.findViewById(R.id.listview);

        ExercicioAdapter exercicioAdapter = new ExercicioAdapter(exercicios, context);
        listExercicos.setAdapter(exercicioAdapter);

        listExercicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(context, exercicios.get(position).getClasse());
                startActivity(i);
            }
        });

        return view;
    }
}
