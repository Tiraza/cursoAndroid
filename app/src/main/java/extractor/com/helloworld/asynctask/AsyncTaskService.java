package extractor.com.helloworld.asynctask;

import android.os.AsyncTask;

public class AsyncTaskService extends AsyncTask<String, String, String>{
    public AsyncTaskResponse delegate = null;
    private String response;
    private Integer time;

    public AsyncTaskService(String tempo) {
        this.time = Integer.parseInt(tempo);
    }

    @Override
    protected String doInBackground(String... params) {
        publishProgress("Sleeping...");
        try {
            Thread.sleep(time);
            response = "Slept for " + time + " miliseconds";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        delegate.processUpdate(values[0]);
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
        delegate.processFinish(response);
    }
}
