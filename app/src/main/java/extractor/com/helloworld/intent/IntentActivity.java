package extractor.com.helloworld.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import extractor.com.helloworld.R;

public class IntentActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        setTitle("Intent");
    }

    public void onClickBtnStartBrowser(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(i);
    }

    public void onClickBtnStartPhone(View v){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:06282066521"));
        startActivity(i);
    }
}
