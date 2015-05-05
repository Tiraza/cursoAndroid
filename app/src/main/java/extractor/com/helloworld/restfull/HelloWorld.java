package extractor.com.helloworld.restfull;

import android.app.Application;
import android.content.Context;

public class HelloWorld extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        init();
    }

    public static Context getAppContext() {
        return context;
    }

    private void init() {
        MyVolley.init(this);
    }
}
