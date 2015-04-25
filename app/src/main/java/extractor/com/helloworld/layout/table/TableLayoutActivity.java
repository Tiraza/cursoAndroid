package extractor.com.helloworld.layout.table;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import extractor.com.helloworld.R;


public class TableLayoutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Table Layout");
    }

    public void onClickBtnBack (View v) {
        super.finish();
    }
}
