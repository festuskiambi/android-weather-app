package com.festus.refuniteandroidchallenge.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.festus.refuniteandroidchallenge.R;
import com.festus.refuniteandroidchallenge.adapters.AllCitiesRecyclerViewadapter;
import com.festus.refuniteandroidchallenge.models.LocalWeatherObservation;
import com.festus.refuniteandroidchallenge.models.MyLocationWether;
import com.festus.refuniteandroidchallenge.models.Weather;
import com.festus.refuniteandroidchallenge.models.WeatherObservation;
import com.festus.refuniteandroidchallenge.util.ReadStringFfromUrl;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyLocationFragment extends Fragment {
    private static final String COORD_LAT = "10.62933";
    private static final String COORD_LON = "-2.71712";

    private ReadStringFfromUrl readingFromUrl = new ReadStringFfromUrl();
    private MyLocationWether city;

    private static final int CODE_OK = 0;
    private static final int CODE_ERROR = 1;
    private static final String TAG = "mylocationFromJson";

    public MyLocationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_location, container, false);
        callService();
        return view;
    }
    final Handler handler = new Handler() {
        public void handleMessage(Message msg) {

            if (msg.what == CODE_ERROR) {
                Log.i(TAG, "result: " +"Service error.");
                Toast.makeText(getActivity(), "Service error.", Toast.LENGTH_SHORT).show();
            }
            else if (city!= null && city.getWeatherObservation() != null) {
                Log.i(TAG, "result: it ran");

            }
        }
    };
    private void callService() {

        // Create the thread that calls the webservice.
        Thread loader = new Thread() {
            public void run() {

                // init stuff.
                Looper.prepare();
                city = new MyLocationWether();
                boolean error = false;

                // build the webservice URL from parameters.
                String locationsUrl= "http://api.geonames.org/findNearByWeatherJSON?lat=43&lng=-2&username=festuskiambi";
                /*locationsUrl += "&north="+COORD_LAT;
                locationsUrl += "&south="+COORD_LON;*/

                String wsResponse = "";

                try {
                    // call the service via HTTP.
                    wsResponse = readingFromUrl.doGetRequest(locationsUrl);

                    // deserialize the JSON response to the cities objects.


                    city = new Gson().fromJson(wsResponse, MyLocationWether.class);
                    try {
                        JSONObject json = new JSONObject(wsResponse);
                        JSONObject weatherObservations = json.getJSONObject("weatherObservation");
                        String test = weatherObservations.getString("stationName");
                        Log.i(TAG, test);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
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



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
