package extractor.com.helloworld.webservice.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Vector;

import extractor.com.helloworld.R;
import extractor.com.helloworld.webservice.BuscaActivity;
import extractor.com.helloworld.webservice.handler.ICepHandler;
import extractor.com.helloworld.webservice.service.CEPService;

public class FragmentLogradouro extends Fragment{

    private EditText edtLogradouro;
    private EditText edtCidade;
    private EditText edtEstado;
    private Button btnBuscar;
    public ICepHandler cepHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_busca_logradouro, null);

        edtLogradouro = (EditText) view.findViewById(R.id.edtLogradouro);
        edtCidade = (EditText) view.findViewById(R.id.edtCidade);
        edtEstado = (EditText) view.findViewById(R.id.edtEstado);
        btnBuscar = (Button) view.findViewById(R.id.btnBuscar);

        cepHandler = new ICepHandler() {
            @Override
            public void RequisicaoIniciada() {
                Log.e("WSDL2CODE:", "Requisição Iniciada");
            }

            @Override
            public void RequisicaoFechada() {
                Log.e("WSDL2CODE:", "Requisição Fechada");
            }

            @Override
            public void RequisicaoFinalizada(String method, Vector<String> result) {
                Log.e("WSDL2CODE:", "Requisição Finalizada");
                Log.e("WSDL2CODE:", method);
                Log.e("WSDL2CODE:", result.toString());
                BuscaActivity.mViewPager.setCurrentItem(2);
                FragmentResposta.addResposta(result.toString());
            }

            @Override
            public void RequisicaoFinalizadaComErro(Exception ex) {
                Log.e("WSDL2CODE:", ex.toString());
            }
        };

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String logradouro = edtLogradouro.getText().toString();
                    String cidade = edtCidade.getText().toString();
                    String estado = edtEstado.getText().toString();
                    CEPService cepService = new CEPService(cepHandler);
                    cepService.obterCEPAuthSync(logradouro, cidade, estado);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        return view;
    }
}
