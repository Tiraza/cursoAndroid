package extractor.com.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import extractor.com.helloworld.extractor.com.helloworld.layoutTab.LayoutTabActivity;


public class Exercicios extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicios);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_exercicios, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickBtnPrimeiroExercicio (View v){
        Intent i = new Intent(this, LinearLayoutActivity.class);
        startActivity(i);
    }

    public void onClickBtnSegundoExercicio (View v){
        Intent i = new Intent(this, RelativeLayoutActivity.class);
        startActivity(i);
    }

    public void onClickBtnTerceiroExercicio (View v){
        Intent i = new Intent(this, TableLayoutActivity.class);
        startActivity(i);
    }

    public void onClickBtnFrameLayout (View v){
        Intent i = new Intent(this, FrameLayoutActivity.class);
        startActivity(i);
    }

    public void onClickBtnListView (View v){
        Intent i = new Intent(this, ListViewActivity.class);
        startActivity(i);
    }

    public void onClickBtnGriView (View v){
        Intent i = new Intent(this, GridViewActivity.class);
        startActivity(i);
    }

    public void onClickBtnTabLayout (View v){
        Intent i = new Intent(this, LayoutTabActivity.class);
        startActivity(i);
    }

    public void onClickBtnToast (View v){
        Intent i = new Intent(this, ToastActivity.class);
        startActivity(i);
    }
}
