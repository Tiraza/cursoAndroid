package extractor.com.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.johnpersano.supertoasts.SuperToast;

public class LinearLayoutActivity extends ActionBarActivity {

    private Button btnStart;
    private Button btnPause;
    private Button btnStop;
    private TextView txtStatus;

    private Boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnPause = (Button) findViewById(R.id.btnPause);
        btnStop = (Button) findViewById(R.id.btnStop);
        txtStatus = (TextView) findViewById(R.id.txtStatus);

        btnPause.setEnabled(false);
        btnStop.setEnabled(false);

        txtStatus.setText(R.string.stoped);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_primeiro_exercicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            SuperToast superToast = new SuperToast(this);
            superToast.setDuration(SuperToast.Duration.VERY_SHORT);
            superToast.setText("Action Settings");
            superToast.setIcon(SuperToast.Icon.Dark.INFO, SuperToast.IconPosition.LEFT);
            superToast.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickBtnStart (View v){
        btnStart.setEnabled(false);
        btnPause.setEnabled(true);
        btnStop.setEnabled(true);
        txtStatus.setText(R.string.started);
    }

    public void onClickBtnPause (View v){
        if(!isPaused){
            btnPause.setText(R.string.continues);
            txtStatus.setText(R.string.paused);
            isPaused = true;
        } else {
            btnPause.setText(R.string.pause);
            txtStatus.setText(R.string.started);
            isPaused = false;
        }
    }

    public void onClickBtnStop (View v){
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        btnPause.setEnabled(false);
        btnPause.setText(R.string.pause);
        txtStatus.setText(R.string.stoped);
    }
}
