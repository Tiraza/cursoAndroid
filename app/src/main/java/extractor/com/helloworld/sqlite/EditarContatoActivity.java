package extractor.com.helloworld.sqlite;

import android.content.Intent;
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

public class EditarContatoActivity extends ActionBarActivity {

    int OK = 1;
    private Integer CONTATO_ID;
    private ContatoDAO contatoDAO;

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtTelefone;
    private EditText edtRua;
    private EditText edtCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contato);
        setTitle("Editar Contato");

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        edtRua = (EditText) findViewById(R.id.edtRua);
        edtCidade = (EditText) findViewById(R.id.edtCidade);

        Intent i = getIntent();
        CONTATO_ID = i.getExtras().getInt("CONTATO_ID");

        contatoDAO = new ContatoDAO(this);
        Contato contato = contatoDAO.getContatoPorID(CONTATO_ID);

        edtNome.setText(contato.getNome());
        edtEmail.setText(contato.getEmail());
        edtTelefone.setText(contato.getTelefone());
        edtRua.setText(contato.getRua());
        edtCidade.setText(contato.getCidade());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_editar_contato, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_excluir) {
            contatoDAO.deleteContato(CONTATO_ID);
            Toast.makeText(this, "Contato Excluido com Sucesso!", Toast.LENGTH_SHORT).show();
            setResult(OK);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickBtnEditar(View v){
        Contato contato = new Contato();
        contato.setId(CONTATO_ID);
        contato.setNome(edtNome.getText().toString());
        contato.setEmail(edtEmail.getText().toString());
        contato.setTelefone(edtTelefone.getText().toString());
        contato.setRua(edtRua.getText().toString());
        contato.setCidade(edtCidade.getText().toString());

        contatoDAO.updateContato(contato);
        Toast.makeText(this, "Contato Alterado com Sucesso!", Toast.LENGTH_SHORT).show();
        setResult(OK);
        finish();
    }
}
