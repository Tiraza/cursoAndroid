package extractor.com.helloworld.GPS;

import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;

import extractor.com.helloworld.R;

public class GpsActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener{

    GoogleApiClient mGoogleApiClient;
    private TextView txtLocation;
    private TextView txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtLocation = (TextView) findViewById(R.id.txtLocation);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
        txtLocation.setText("Got connected....");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mGoogleApiClient.disconnect();
        txtLocation.setText("Got disconnected....");
    }

    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    public void onClickGetLocation(View v){
        displayCurrentLocation();
    }

    public void onClickDisconnect(View v){
        mGoogleApiClient.disconnect();
        txtLocation.setText("Got disconnected....");
    }

    public void onClickConnect(View v){
        mGoogleApiClient.connect();
        txtLocation.setText("Got connected....");
    }

    private void displayCurrentLocation() {
    }


}
