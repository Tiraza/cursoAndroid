package extractor.com.helloworld.view.list;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import extractor.com.helloworld.R;


public class ListViewActivity extends ActionBarActivity {

    String[] countryArray = {"India", "Brazil", "Pakistan", "USA", "UK", "Paraguai", "Bolivia", "WTF"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("List View");

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, countryArray);

        ListView listView = (ListView) findViewById(R.id.country_list);
        listView.setAdapter(adapter);
    }

}
