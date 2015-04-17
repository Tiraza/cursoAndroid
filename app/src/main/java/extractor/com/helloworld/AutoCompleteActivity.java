package extractor.com.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;


public class AutoCompleteActivity extends ActionBarActivity {

    private AutoCompleteTextView actText;
    private MultiAutoCompleteTextView mactText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        actText = (AutoCompleteTextView) findViewById(R.id.actText);
        mactText = (MultiAutoCompleteTextView) findViewById(R.id.mactText);

        String[] coutries = getResources().getStringArray(R.array.list_of_countries);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, coutries);

        actText.setAdapter(adapter);
        mactText.setAdapter(adapter);

        mactText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_auto_complete, menu);
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
