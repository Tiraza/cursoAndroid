package extractor.com.helloworld;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class EmailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }

    public void onClickBtnSendEmail(View v){
        Log.i("Send EMAIL: ", "");

        String[] TO = {"teste@gmail.com"};
        String[] CC = {"admin@gmail.com"};

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");

        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Assunto do Email");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Corpo do Email");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(this, "No email client installed", Toast.LENGTH_SHORT).show();
        }
    }

}
