package extractor.com.helloworld.login.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import extractor.com.helloworld.R;
import extractor.com.helloworld.login.service.AsyncResponse;
import extractor.com.helloworld.login.service.LoginService;

public class LoginActivity extends ActionBarActivity implements AsyncResponse{

    private EditText edtLogin;
    private EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Login");

        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
    }

    private void onClickBtnLogin (View v){
        String login = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();

        LoginService service = new LoginService(login, senha);
        service.execute();
    }

    @Override
    public void processFinish(Integer result) {
        if(result == 200){
            Toast.makeText(this, "Login status: OK", Toast.LENGTH_SHORT).show();
        } else if (result == 400){
            Toast.makeText(this, "Login status: ERROR", Toast.LENGTH_SHORT).show();
        }
    }
}
