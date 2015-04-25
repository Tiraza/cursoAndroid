package extractor.com.helloworld.sqlite;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import extractor.com.helloworld.R;
import extractor.com.helloworld.sqlite.contato.Contato;
import extractor.com.helloworld.sqlite.contato.ContatoDAO;

public class NovoContatoActivity extends ActionBarActivity {

    int OK = 1;
    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTelefone;
    private EditText edtRua;
    private EditText edtCidade;

    private ContatoDAO contatoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_contato);

        setTitle("Novo Contato");

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        edtRua = (EditText) findViewById(R.id.edtRua);
        edtCidade = (EditText) findViewById(R.id.edtCidade);

        contatoDAO = new ContatoDAO(this);
    }

    public void onClickBtnSalvar(View v){
        Contato contato = new Contato();
        contato.setNome(edtNome.getText().toString());
        contato.setEmail(edtEmail.getText().toString());
        contato.setTelefone(edtTelefone.getText().toString());
        contato.setRua(edtRua.getText().toString());
        contato.setCidade(edtCidade.getText().toString());

        contatoDAO.inserirContato(contato);
        Toast.makeText(this, "Contato Inserido com Sucesso!", Toast.LENGTH_SHORT).show();
        setResult(OK);
        finish();
    }
}
