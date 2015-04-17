package extractor.com.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import extractor.com.helloworld.layout.frame.FrameLayoutActivity;
import extractor.com.helloworld.layout.linear.LinearLayoutActivity;
import extractor.com.helloworld.layout.relative.RelativeLayoutActivity;
import extractor.com.helloworld.layout.tab.LayoutTabActivity;
import extractor.com.helloworld.layout.table.TableLayoutActivity;
import extractor.com.helloworld.text.autocomplete.AutoCompleteActivity;
import extractor.com.helloworld.text.toast.ToastActivity;
import extractor.com.helloworld.view.grid.GridViewActivity;
import extractor.com.helloworld.view.list.ListViewActivity;


public class Exercicios extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);

        final Map<Integer, Class> exercicios = new HashMap<Integer, Class>();
        exercicios.put(0, LinearLayoutActivity.class);
        exercicios.put(1, RelativeLayoutActivity.class);
        exercicios.put(2, TableLayoutActivity.class);
        exercicios.put(3, FrameLayoutActivity.class);
        exercicios.put(4, ListViewActivity.class);
        exercicios.put(5, GridViewActivity.class);
        exercicios.put(6, LayoutTabActivity.class);
        exercicios.put(7, ToastActivity.class);
        exercicios.put(8, AutoCompleteActivity.class);

        List<String> nomesExercicios = new ArrayList<>();
        nomesExercicios.add("1 - Linear Layout");
        nomesExercicios.add("2 - Relative Layout");
        nomesExercicios.add("3 - Table Layout");
        nomesExercicios.add("4 - Frame Layout");
        nomesExercicios.add("5 - List View");
        nomesExercicios.add("6 - Grid View");
        nomesExercicios.add("7 - Layout Tab");
        nomesExercicios.add("8 - Toast");
        nomesExercicios.add("9 - Autocomplete");

        ArrayAdapter<String> adapterExercicios = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nomesExercicios.toArray(new String[0]));

        ListView listViewExercicios = (ListView) findViewById(R.id.listview);
        listViewExercicios.setAdapter(adapterExercicios);

        listViewExercicios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), exercicios.get(position));
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_exercicios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
