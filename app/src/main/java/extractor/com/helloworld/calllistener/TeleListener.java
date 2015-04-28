package extractor.com.helloworld.calllistener;

import android.telephony.PhoneStateListener;

public class TeleListener extends PhoneStateListener{

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        switch (state){

        }
    }
}
