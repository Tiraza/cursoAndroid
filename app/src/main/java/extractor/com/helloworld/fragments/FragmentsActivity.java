package extractor.com.helloworld.fragments;



import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import extractor.com.helloworld.R;

public class FragmentsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Configuration config = getResources().getConfiguration();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Fragments");


        if(config.orientation == Configuration.ORIENTATION_LANDSCAPE){
            LMFragment lmFragment = new LMFragment();
            fragmentTransaction.replace(android.R.id.content, lmFragment);
        } else {
            PMFragment pmFragment = new PMFragment();
            fragmentTransaction.replace(android.R.id.content, pmFragment);
        }

        fragmentTransaction.commit();
    }

}
