package extractor.com.helloworld.text.autocomplete;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import extractor.com.helloworld.R;


public class AutoCompleteActivity extends ActionBarActivity {

    private AutoCompleteTextView actText;
    private MultiAutoCompleteTextView mactText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Autocomplete");

        actText = (AutoCompleteTextView) findViewById(R.id.actText);
        mactText = (MultiAutoCompleteTextView) findViewById(R.id.mactText);

        String[] coutries = getResources().getStringArray(R.array.list_of_countries);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, coutries);

        actText.setAdapter(adapter);
        mactText.setAdapter(adapter);

        mactText.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }
}
