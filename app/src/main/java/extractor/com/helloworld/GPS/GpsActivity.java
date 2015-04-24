package extractor.com.helloworld.GPS;

import android.content.Context;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import extractor.com.helloworld.R;

public class GpsActivity extends FragmentActivity implements
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    GoogleApiClient mGoogleApiClient;
    private TextView txtLocation;
    private TextView txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        setTitle("GPS");

        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtLocation = (TextView) findViewById(R.id.txtLocation);

        mGoogleApiClient = new GoogleApiClient.Builder(this, this, this).addApi(LocationServices.API).build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mGoogleApiClient != null){
            mGoogleApiClient.connect();
            txtLocation.setText("Got connected....");
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mGoogleApiClient != null){
            mGoogleApiClient.disconnect();
            txtLocation.setText("Got disconnected....");
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Toast.makeText(this, "Connection suspended. Please re-connect.", Toast.LENGTH_SHORT).show();
        txtLocation.setText("Connection suspended. Please re-connect.");
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Toast.makeText(this, "Connection failed", Toast.LENGTH_SHORT).show();
        txtLocation.setText("Connection failed");
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
        Location currenLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        StringBuilder stringLocation = new StringBuilder();
        stringLocation.append("Current location: ");
        stringLocation.append("Latitude: ").append(Double.toString(currenLocation.getLatitude()));
        stringLocation.append("Longitude: ").append(Double.toString(currenLocation.getLongitude()));
        txtAddress.setText(stringLocation.toString());

        (new GetAddressTask(this)).execute(currenLocation);
    }


    private class GetAddressTask extends AsyncTask<Location, Void, String>{

        Context context;

        private GetAddressTask(Context context) {
            super();
            this.context = context;
        }

        @Override
        protected void onPostExecute(String address) {
            txtAddress.setText(address);
        }

        @Override
        protected String doInBackground(Location... params) {
            Geocoder geocoder = new Geocoder(context, Locale.getDefault());
            Location loc = params[0];
            List<Address> addresses = null;

            try {
                addresses = geocoder.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
            } catch (IOException e){
                Log.e("GPS: ", "IO Exception");
                return "IO Exception trying to get address";
            } catch (IllegalArgumentException e){
                String errorString = "Illegal Arguments: "
                        + Double.toString(loc.getLatitude()) + ", " + Double.toString(loc.getLongitude());

                Log.e("GPS: ", errorString);
                return errorString;
            }

            if(addresses != null && addresses.size() > 0){
                Address address = addresses.get(0);

                String addressText = String.format(
                        address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
                        address.getLocality(),
                        address.getCountryName());

                return addressText;
            } else {
                return "No address found";
            }
        }
    }

}
