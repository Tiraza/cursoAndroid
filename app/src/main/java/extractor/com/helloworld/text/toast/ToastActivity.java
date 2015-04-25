package extractor.com.helloworld.text.toast;

import android.app.Activity;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.johnpersano.supertoasts.SuperActivityToast;
import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.OnClickWrapper;

import extractor.com.helloworld.R;


public class ToastActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Toast");
    }

    public void onClickBtnToast (View v){
        Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show();
    }

    public void onClickBtnSuperToast (View v){
        final Toast toast = Toast.makeText(this, "Há, outro toast", Toast.LENGTH_SHORT);
        OnClickWrapper onClickWrapper = new OnClickWrapper("superactivitytoast", new SuperToast.OnClickListener() {
            @Override
            public void onClick(View view, Parcelable token) {
                toast.show();
            }

        });

        SuperActivityToast superActivityToast = new SuperActivityToast(this, SuperToast.Type.BUTTON);
        superActivityToast.setDuration(SuperToast.Duration.EXTRA_LONG);
        superActivityToast.setText("Some action performed.");
        superActivityToast.setButtonIcon(SuperToast.Icon.Dark.UNDO, "UNDO");
        superActivityToast.setOnClickWrapper(onClickWrapper);
        superActivityToast.show();
    }
}
