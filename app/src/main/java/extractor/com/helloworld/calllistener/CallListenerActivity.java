package extractor.com.helloworld.calllistener;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import extractor.com.helloworld.R;

public class CallListenerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_listener);
        setTitle("Call Listener");

        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(new TeleListener(), PhoneStateListener.LISTEN_CALL_STATE);
    }

    public class TeleListener extends PhoneStateListener {

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch (state){
                case TelephonyManager.CALL_STATE_IDLE:
                    Toast.makeText(getApplicationContext(), "CALL STATE IDLE", Toast.LENGTH_SHORT).show();
                    break;

                case TelephonyManager.CALL_STATE_OFFHOOK:
                    Toast.makeText(getApplicationContext(), "CALL STATE OFFHOOK", Toast.LENGTH_SHORT).show();
                    break;

                case TelephonyManager.CALL_STATE_RINGING:
                    Toast.makeText(getApplicationContext(), incomingNumber, Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "CALL STATE RINGING", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
