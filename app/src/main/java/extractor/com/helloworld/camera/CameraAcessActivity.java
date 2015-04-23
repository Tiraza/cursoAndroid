package extractor.com.helloworld.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import extractor.com.helloworld.R;

public class CameraAcessActivity extends ActionBarActivity {

    private ImageView imgCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_acess);
        imgCamera = (ImageView) findViewById(R.id.imgCamera);

        final ActionBar bar = getSupportActionBar();
        bar.setTitle("Camera Acess");
    }

    public void onClickImgCamera(View v){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode != 0){
            Bitmap bp = (Bitmap) data.getExtras().get("data");
            imgCamera.setImageBitmap(bp);
        }
    }
}
