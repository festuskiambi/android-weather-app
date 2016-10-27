package com.festus.refuniteandroidchallenge.fragments;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.festus.refuniteandroidchallenge.R;


import com.festus.refuniteandroidchallenge.adapters.AllCitiesRecyclerViewadapter;
import com.festus.refuniteandroidchallenge.models.Geoname;
import com.festus.refuniteandroidchallenge.models.Location;

import com.festus.refuniteandroidchallenge.models.Weather;

import com.festus.refuniteandroidchallenge.models.WeatherObservation;
import com.festus.refuniteandroidchallenge.util.ReadStringFfromUrl;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AllCitiesFragment extends Fragment {
    private static final String COORD_N = "4.62933";
    private static final String COORD_S = "-2.71712";
    private static final String COORD_W = "34.90884";
    private static final String COORD_E = "41.899059";
    private ReadStringFfromUrl readingFromUrl = new ReadStringFfromUrl();
    private Weather cities;
    private static final int CODE_OK = 0;
    private static final int CODE_ERROR = 1;
    private static final String TAG = "PlacesFromJson";


    private static RecyclerView citiyRecyclerView;
    public static WeatherObservation weatherObservation = new WeatherObservation();



    public AllCitiesFragment() {
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
        View view = inflater.inflate(R.layout.fragment_all_cities, container, false);

        /**
         * layout items
         */
        citiyRecyclerView = (RecyclerView)view.findViewById(R.id.all_city_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),1,false);
        citiyRecyclerView.setLayoutManager(linearLayoutManager);


        callService();
        return  view;

    }
    final Handler handler = new Handler() {
        public void handleMessage(Message msg) {

            if (msg.what == CODE_ERROR) {
                Toast.makeText(getActivity(), "Service error.", Toast.LENGTH_SHORT).show();
            }
            else if (cities != null && cities.getWeatherObservations() != null) {
                Log.i(TAG, "locations found: " + cities.getWeatherObservations().size());
                buildList();
            }
        }
    };
    private void callService() {

        // Create the thread that calls the webservice.
        Thread loader = new Thread() {
            public void run() {

                // init stuff.
                Looper.prepare();
                cities = new Weather();
                boolean error = false;

                // build the webservice URL from parameters.
                String locationsUrl= "http://api.geonames.org/weatherJSON?.2&username=festuskiambi";
                locationsUrl += "&north="+COORD_N;
                locationsUrl += "&south="+COORD_S;
                locationsUrl += "&east="+COORD_E;
                locationsUrl += "&west="+COORD_W;
                String wsResponse = "";

                try {
                    // call the service via HTTP.
                    wsResponse = readingFromUrl.doGetRequest(locationsUrl);

                    // deserialize the JSON response to the cities objects.

                    cities = new Gson().fromJson(wsResponse, Weather.class);

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
    private void buildList() {

        // init stuff.
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        Map<String, String> currentChildMap = null;

        String stationName,datetime,temperature,wetherCondition;



        // cycle on the cities and create list entries.
        for (WeatherObservation city : cities.getWeatherObservations()) {
            currentChildMap = new HashMap<String, String>();
            data.add(currentChildMap);

            stationName = city.getStationName();
            datetime = city.getDatetime();
            temperature = city.getTemperature();
            wetherCondition = city.getWeatherConditionCode();

            currentChildMap.put(weatherObservation.getStationName(),stationName);
            currentChildMap.put(weatherObservation.getDatetime(),datetime);
            currentChildMap.put(weatherObservation.getTemperature(),temperature);
            currentChildMap.put(weatherObservation.getWeatherConditionCode(),temperature);

        }
  final AllCitiesRecyclerViewadapter adapter = new AllCitiesRecyclerViewadapter(data);
        citiyRecyclerView.setAdapter(adapter);

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
