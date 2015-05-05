package extractor.com.helloworld.restfull;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

/**
 * Volley
 */
public class CustomRequest extends Request{

    private Response.Listener listener;

    public CustomRequest(int method,
                         String url,
                         Response.Listener responseListener,
                         Response.ErrorListener errorlistener) {

        super(method, url, errorlistener);
        this.listener = responseListener;
    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        try {
            if(response.data.length > 10000){ // Bytes
                setShouldCache(false);
            }

            String jsonString = new String(response.data, "UTF-8");
            JSONObject jsonObject = new JSONObject(jsonString);
            return Response.success(jsonObject, HttpHeaderParser.parseCacheHeaders(response));

        } catch (JSONException e) {
            return Response.error(new ParseError(e));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(Object response) {
        listener.onResponse(response);
    }

    @Override
    public int compareTo(Object another) {
        return 0;
    }
}
