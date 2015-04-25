package extractor.com.helloworld.layout.frame;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import extractor.com.helloworld.R;


public class FrameLayoutActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Frame Layout");
    }

}
