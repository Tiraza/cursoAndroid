package extractor.com.helloworld.asynctask;

public interface AsyncTaskResponse {
    void processFinish(String result);
    void processUpdate(String update);
}
