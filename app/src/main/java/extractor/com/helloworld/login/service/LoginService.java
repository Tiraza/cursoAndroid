package extractor.com.helloworld.login.service;

import android.os.AsyncTask;

import com.github.kevinsawicki.http.HttpRequest;

public class LoginService extends AsyncTask<Void, Void, Void> {
    public AsyncResponse delegate = null;

    private static final String URL = "";

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
            HttpRequest request = HttpRequest.get(URL).basic(login, senha);
            httpStatus = request.code();
            response = request.body();
        }catch (Exception e){
            return null;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        delegate.processFinish(httpStatus);
    }
}
