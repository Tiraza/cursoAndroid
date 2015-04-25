package extractor.com.helloworld.view.grid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import extractor.com.helloworld.R;


public class SingleViewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);

        Intent i = getIntent();
        int position = i.getExtras().getInt("id");

        ImageAdapter imageAdapter = new ImageAdapter(this);
        ImageView imageView = (ImageView) findViewById(R.id.single_view);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);

        TextView txtGridPosition = (TextView) findViewById(R.id.txtGridPosition);
        txtGridPosition.setText("Posição número: " + position);
    }

}
