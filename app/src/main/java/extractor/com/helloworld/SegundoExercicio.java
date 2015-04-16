package extractor.com.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SegundoExercicio extends ActionBarActivity {

    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_exercicio);

        Date date = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String nowDate = dateFormat.format(date);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String nowTime = timeFormat.format(date);

        TextView dateView = (TextView) findViewById(R.id.dates);
        dateView.setText(nowDate);

        TextView timeView = (TextView) findViewById(R.id.times);
        timeView.setText(nowTime);

        txtName = (TextView) findViewById(R.id.name);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_segundo_exercicio, menu);
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

    public void onClickBtnDone(View v){
        Toast.makeText(this, txtName.getText(), Toast.LENGTH_SHORT).show();
    }
}
