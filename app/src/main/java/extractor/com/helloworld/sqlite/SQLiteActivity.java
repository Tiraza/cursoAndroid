package extractor.com.helloworld.sqlite;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import extractor.com.helloworld.R;
import extractor.com.helloworld.sqlite.adapter.ContatoAdapter;
import extractor.com.helloworld.sqlite.contato.Contato;
import extractor.com.helloworld.sqlite.contato.ContatoDAO;

public class SQLiteActivity extends ActionBarActivity {

    int OK = 1;

    private ListView listContatos;
    private ContatoDAO contatoDAO;
    private ContatoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        setTitle("Contatos");

        contatoDAO = new ContatoDAO(this);
        listContatos = (ListView) findViewById(R.id.listContatos);

        carregarListView();

        listContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), EditarContatoActivity.class);
                i.putExtra("CONTATO_ID", adapter.getId(position));
                startActivityForResult(i, 0);
            }
        });

        registerForContextMenu(listContatos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sqlite, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_novo) {
            Intent i = new Intent(this, NovoContatoActivity.class);
            startActivityForResult(i, 0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(resultCode == OK){
           carregarListView();
       }
    }

    private void carregarListView(){
        ArrayList<Contato> contatos = contatoDAO.getContatos();
        adapter = new ContatoAdapter(contatos, this);
        listContatos.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        ListView lv = (ListView) v;
        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) menuInfo;
        Contato contato = (Contato) lv.getItemAtPosition(acmi.position);

        menu.setHeaderTitle(contato.getNome());
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.add(0, contato.getId(), 0, "Editar");
        menu.add(0, contato.getId(), 0, "Deletar");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Integer id = item.getItemId();

        if(item.getTitle() == "Editar"){
            Intent i = new Intent(getApplicationContext(), EditarContatoActivity.class);
            i.putExtra("CONTATO_ID", id);
            startActivityForResult(i, 0);
        } else if(item.getTitle() == "Deletar"){
            contatoDAO.deleteContato(id);
            Toast.makeText(this, "Contato Excluido com Sucesso!", Toast.LENGTH_SHORT).show();
            carregarListView();
        }  else {
            return false;
        }
        return true;
    }
}
