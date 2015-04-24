package extractor.com.helloworld.asynctask;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import extractor.com.helloworld.R;

public class AsyncTaskActivity extends ActionBarActivity implements AsyncTaskResponse{

    private TextView txtTask;
    private EditText edtTempo;
    private Button btnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        setTitle("Async Task");

        edtTempo = (EditText) findViewById(R.id.edtTempo);
        txtTask = (TextView) findViewById(R.id.txtTask);
        btnRun = (Button) findViewById(R.id.btnRun);
    }

    public void onClickBtnRunTask(View v){
        String tempo = edtTempo.getText().toString();
        AsyncTaskService service = new AsyncTaskService(tempo);
        service.delegate = this;
        service.execute();

        btnRun.setEnabled(false);
        edtTempo.setEnabled(false);
    }

    @Override
    public void processFinish(String result) {
        txtTask.setText(result);

        btnRun.setEnabled(true);
        edtTempo.setEnabled(true);
    }

    @Override
    public void processUpdate(String update) {
        txtTask.setText(update);
    }
}
