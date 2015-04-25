package extractor.com.helloworld.widget.contextmenu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import extractor.com.helloworld.R;

public class ContextMenuActivity extends ActionBarActivity {

    private Button btnPress;
    private String msg = "Android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Context Menu");

        btnPress = (Button) findViewById(R.id.btnPress);
        registerForContextMenu(btnPress);

        Log.d(msg, "The onCreate() event");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(msg, "The onRestart() event");
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        menu.add(0, v.getId(), 0, "Action 1");
        menu.add(0, v.getId(), 0, "Action 2");
        menu.add(0, v.getId(), 0, "Action 3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getTitle() == "Action 1"){
            Toast.makeText(this, "Action 1 invoked", Toast.LENGTH_SHORT).show();
        } else if(item.getTitle() == "Action 2"){
            Toast.makeText(this, "Action 2 invoked", Toast.LENGTH_SHORT).show();
        } else if(item.getTitle() == "Action 3"){
            Toast.makeText(this, "Action 3 invoked", Toast.LENGTH_SHORT).show();
        } else {
            return false;
        }
        return true;
    }
}
