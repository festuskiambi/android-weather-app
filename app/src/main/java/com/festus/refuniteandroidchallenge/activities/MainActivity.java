package com.festus.refuniteandroidchallenge.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.festus.refuniteandroidchallenge.R;
import com.festus.refuniteandroidchallenge.util.ReadStringFfromUrl;
import com.festus.refuniteandroidchallenge.models.Location;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private static final int CODE_OK = 0;
    private static final int CODE_ERROR = 1;
    private static final String TAG = "PlacesFromJson";
    private static final String COORD_N = "1.9577";
    private static final String COORD_S = "-10";
    private static final String COORD_W = "-20";
    private static final String COORD_E = "37.2972";
    private ReadStringFfromUrl readingFromUrl = new ReadStringFfromUrl();
    private Location cities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       callService();


    }

    final Handler handler = new Handler() {
        public void handleMessage(Message msg) {

            if (msg.what == CODE_ERROR) {
                Toast.makeText(MainActivity.this, "Service error.", Toast.LENGTH_SHORT).show();
            }
            else if (cities != null && cities.getGeonames() != null) {
                Log.i(TAG, "locations found: " + cities.getGeonames().size());
                //buildList();
            }
        }
    };

    private void callService() {

        // Create the thread that calls the webservice.
        Thread loader = new Thread() {
            public void run() {

                // init stuff.
                Looper.prepare();
                cities = new Location();
                boolean error = false;

                // build the webservice URL from parameters.
                String locationsUrl = "http://api.geonames.org/citiesJSON?lang=en&username=festuskiambi";
                locationsUrl += "&north="+COORD_N;
                locationsUrl += "&south="+COORD_S;
                locationsUrl += "&east="+COORD_E;
                locationsUrl += "&west="+COORD_W;

                String wsResponse = "";

                try {
                    // call the service via HTTP.
                    wsResponse = readingFromUrl.doGetRequest(locationsUrl);

                    // deserialize the JSON response to the cities objects.
                    cities = new Gson().fromJson(wsResponse, Location.class);
                }
                catch (IOException e) {
                    // IO exception
                    Log.e(TAG, e.getMessage(), e);
                    error = true;
                }
                catch (IllegalStateException ise) {
                    // Illegal state: maybe the service returned an empty string.
                    Log.e(TAG, ise.getMessage(), ise);
                    error = true;
                }
                catch (JsonSyntaxException jse) {
                    // JSON syntax is wrong. This could be quite bad.
                    Log.e(TAG, jse.getMessage(), jse);
                    error = true;
                }

                if (error) {
                    // error: notify the error to the handler.
                    handler.sendEmptyMessage(CODE_ERROR);
                }
                else {
                    // everything ok: tell the handler to show cities list.
                    handler.sendEmptyMessage(CODE_OK);
                }
            }
        };

        // start the thread.
        loader.start();
    }

}
