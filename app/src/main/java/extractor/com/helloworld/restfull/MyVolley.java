package extractor.com.helloworld.restfull;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyVolley {

    private static RequestQueue requestQueue;

    public MyVolley(){}

    public static void init(Context context){
        requestQueue = Volley.newRequestQueue(context);
        requestQueue.getCache().clear();
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
