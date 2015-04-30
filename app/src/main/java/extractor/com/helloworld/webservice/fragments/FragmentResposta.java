package extractor.com.helloworld.webservice.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import extractor.com.helloworld.R;

public class FragmentResposta extends Fragment{

    private static String resposta = "";
    private static TextView txtResposta;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultado, null);
        txtResposta = (TextView) view.findViewById(R.id.txtResposta);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        txtResposta.setText(resposta);
    }

    public static void addResposta(String respostaAux) {
        resposta = respostaAux;
        txtResposta.setText(resposta);
    }
}
