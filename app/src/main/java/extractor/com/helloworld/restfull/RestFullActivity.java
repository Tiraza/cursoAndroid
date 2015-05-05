package extractor.com.helloworld.restfull;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import extractor.com.helloworld.R;

public class RestFullActivity extends ActionBarActivity {

    public Spinner spEstado;
    public AutoCompleteTextView actCidade;
    CidadeEstadoModel cidadeEstadoModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restfull);
        setTitle("RestFull");

        spEstado = (Spinner) findViewById(R.id.spEstado);
        actCidade = (AutoCompleteTextView) findViewById(R.id.actCidade);

        CustomRequest request = new CustomRequest(Request.Method.GET, "http://api.myjson.com/bins/4d80x",
                new Response.Listener() {
                    @Override
                    public void onResponse(Object response) {
                        cidadeEstadoModel = new Gson().fromJson(response.toString(), CidadeEstadoModel.class);
                        CustomArrayAdapter customArrayAdapter =
                                new CustomArrayAdapter(RestFullActivity.this, R.layout.list_item_estado, cidadeEstadoModel.getEstados());
                        spEstado.setAdapter(customArrayAdapter);
                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
        });

        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayAdapter arrayAdapter =
                        new ArrayAdapter(RestFullActivity.this, android.R.layout.simple_list_item_1, cidadeEstadoModel.getEstados().get(position).getCidades());
                actCidade.setAdapter(arrayAdapter);
                actCidade.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                actCidade.setEnabled(false);
            }
        });

        MyVolley.getRequestQueue().add(request);
    }
}
