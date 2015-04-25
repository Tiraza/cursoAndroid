package extractor.com.helloworld.widget.spinners;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import extractor.com.helloworld.R;

public class SpinnerActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    String[] versions = {"Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread",
            "Honeycomb", "Ice Cream Sandwich", "Jellybean", "Kitkat", "Lollipop"};

    private TextView txtVersions;
    private Spinner spVersions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Spinner");

        txtVersions = (TextView) findViewById(R.id.txtVersions);
        spVersions = (Spinner) findViewById(R.id.spVersions);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, versions);
        spVersions.setAdapter(adapter);
        spVersions.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spVersions.setSelection(position);
        String version = (String) spVersions.getSelectedItem();
        txtVersions.setText("Versão selecionada: " + version);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
