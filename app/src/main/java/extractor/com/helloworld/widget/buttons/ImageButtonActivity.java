package extractor.com.helloworld.widget.buttons;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import extractor.com.helloworld.R;

public class ImageButtonActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_button);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Buttons");

    }

}
