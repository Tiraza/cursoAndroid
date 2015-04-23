package extractor.com.helloworld.login.service;

import android.os.AsyncTask;

import com.github.kevinsawicki.http.HttpRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginService extends AsyncTask<Void, Void, Void> {
    public AsyncResponse delegate = null;

    private static final String URL = "http://private-dac29c-docnix.apiary-mock.com/login/docnix?user=user&password=password";

    private final Integer OK = 200;
    private final Integer ERROR = 400;
    private int httpStatus;
    private String response;

    private String login;
    private String senha;

    public LoginService(String login, String senha) {
       this.login = login;
       this.senha = senha;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Map<String, String> data = new HashMap<>();
            data.put("user", login);
            data.put("password", senha);

            HttpRequest request = HttpRequest.post(URL).form(data);
            httpStatus = request.code();
            response = request.body();
        }catch (Exception e){
            httpStatus = ERROR;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        delegate.processFinish(httpStatus);
    }
}
