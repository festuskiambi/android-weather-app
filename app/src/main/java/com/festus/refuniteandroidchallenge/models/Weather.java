
package com.festus.refuniteandroidchallenge.models;

import java.util.ArrayList;
import java.util.List;

import com.festus.refuniteandroidchallenge.models.WeatherObservation;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Weather {

    @SerializedName("weatherObservations")
    @Expose
    private List<WeatherObservation> weatherObservations = new ArrayList<WeatherObservation>();

    /**
     * 
     * @return
     *     The weatherObservations
     */
    public List<WeatherObservation> getWeatherObservations() {
        return weatherObservations;
    }

    /**
     * 
     * @param weatherObservations
     *     The weatherObservations
     */
    public void setWeatherObservations(List<WeatherObservation> weatherObservations) {
        this.weatherObservations = weatherObservations;
    }

}
