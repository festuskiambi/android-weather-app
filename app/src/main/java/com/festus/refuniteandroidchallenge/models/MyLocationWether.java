
package com.festus.refuniteandroidchallenge.models;

import java.util.HashMap;
import java.util.Map;



public class MyLocationWether {


    private LocalWeatherObservation localweatherObservation;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The weatherObservation
     */

    public LocalWeatherObservation getWeatherObservation() {
        return localweatherObservation;
    }

    /**
     * 
     * @param localweatherObservation
     *     The weatherObservation
     */

    public void setWeatherObservation(LocalWeatherObservation localweatherObservation) {
        this.localweatherObservation = localweatherObservation;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
