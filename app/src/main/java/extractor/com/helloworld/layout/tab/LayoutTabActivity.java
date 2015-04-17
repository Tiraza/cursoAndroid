package extractor.com.helloworld.layout.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import extractor.com.helloworld.R;

public class LayoutTabActivity extends ActionBarActivity {

    List<Fragment> fraglist = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_tab);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Tab Layout");
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int i = 1; i <= 5; i++) {
            ActionBar.Tab tab = bar.newTab();
            tab.setText("Tab " + i);
            tab.setTabListener(new ActionBar.TabListener() {
                Fragment fragment = null;
                LayoutTabFragment ltFragment = null;
                @Override
                public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                    if(fraglist.size() > tab.getPosition()){
                        fragment = fraglist.get(tab.getPosition());
                    }

                    if(fragment == null){
                        ltFragment = new LayoutTabFragment();
                        Bundle data = new Bundle();
                        data.putInt("idx", tab.getPosition());
                        ltFragment.setArguments(data);
                        fraglist.add(ltFragment);
                    } else {
                        ltFragment = (LayoutTabFragment) fragment;
                    }

                    fragmentTransaction.replace(android.R.id.content, ltFragment);
                }

                @Override
                public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
                    if(fraglist.size() > tab.getPosition()){
                        fragmentTransaction.remove(fraglist.get(tab.getPosition()));
                    }
                }

                @Override
                public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

                }
            });
            bar.addTab(tab);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout_tab, menu);
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
}
