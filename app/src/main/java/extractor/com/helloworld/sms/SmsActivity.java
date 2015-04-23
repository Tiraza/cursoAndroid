package extractor.com.helloworld.sms;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import extractor.com.helloworld.R;

public class SmsActivity extends ActionBarActivity {

    private EditText edtPhone;
    private EditText edtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Send SMS");

        edtPhone = (EditText) findViewById(R.id.edtPhone);
        edtMessage = (EditText) findViewById(R.id.edtMessage);
    }

    public void onClickSendSMS(View v){
        Log.i("Send SMS: ", "");

        String phoneNumber = edtPhone.getText().toString();
        String message = edtMessage.getText().toString();

        if(!phoneNumber.equals("") && phoneNumber != null && !message.equals("") && message != null){
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, message, null, null);
                Toast.makeText(this, "Send SMS Sucess!", Toast.LENGTH_SHORT).show();
            } catch (Exception e){
                Toast.makeText(this, "Send SMS Fails!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickSendSMSIntent(View v){
        Log.i("Send SMS: ", "");

        String phoneNumber = edtPhone.getText().toString();
        String message = edtMessage.getText().toString();

        if(!phoneNumber.equals("") && phoneNumber != null && !message.equals("") && message != null){
            try {
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setData(Uri.parse("smsto:"));
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", phoneNumber);
                smsIntent.putExtra("sms_body", message);

                startActivity(smsIntent);
                finish();
                Toast.makeText(this, "Send SMS Sucess!", Toast.LENGTH_SHORT).show();
            } catch (ActivityNotFoundException ex){
                Toast.makeText(this, "Send SMS Fails!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }
    }
}
