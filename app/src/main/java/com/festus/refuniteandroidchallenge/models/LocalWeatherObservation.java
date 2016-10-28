
package com.festus.refuniteandroidchallenge.models;

import java.util.HashMap;
import java.util.Map;




public class LocalWeatherObservation {

    private Integer elevation;

    private Double lng;

    private String observation;

    private String iCAO;

    private String clouds;

    private String dewPoint;

    private String cloudsCode;

    private String datetime;

    private String countryCode;

    private String temperature;

    private Integer humidity;

    private String stationName;

    private String weatherCondition;

    private Integer hectoPascAltimeter;

    private String windSpeed;

    private Double lat;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The elevation
     */

    public Integer getElevation() {
        return elevation;
    }

    /**
     * 
     * @param elevation
     *     The elevation
     */

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    /**
     * 
     * @return
     *     The lng
     */

    public Double getLng() {
        return lng;
    }

    /**
     * 
     * @param lng
     *     The lng
     */

    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * 
     * @return
     *     The observation
     */

    public String getObservation() {
        return observation;
    }

    /**
     * 
     * @param observation
     *     The observation
     */

    public void setObservation(String observation) {
        this.observation = observation;
    }

    /**
     * 
     * @return
     *     The iCAO
     */

    public String getICAO() {
        return iCAO;
    }

    /**
     * 
     * @param iCAO
     *     The ICAO
     */

    public void setICAO(String iCAO) {
        this.iCAO = iCAO;
    }

    /**
     * 
     * @return
     *     The clouds
     */

    public String getClouds() {
        return clouds;
    }

    /**
     * 
     * @param clouds
     *     The clouds
     */

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    /**
     * 
     * @return
     *     The dewPoint
     */

    public String getDewPoint() {
        return dewPoint;
    }

    /**
     * 
     * @param dewPoint
     *     The dewPoint
     */

    public void setDewPoint(String dewPoint) {
        this.dewPoint = dewPoint;
    }

    /**
     * 
     * @return
     *     The cloudsCode
     */

    public String getCloudsCode() {
        return cloudsCode;
    }

    /**
     * 
     * @param cloudsCode
     *     The cloudsCode
     */

    public void setCloudsCode(String cloudsCode) {
        this.cloudsCode = cloudsCode;
    }

    /**
     * 
     * @return
     *     The datetime
     */

    public String getDatetime() {
        return datetime;
    }

    /**
     * 
     * @param datetime
     *     The datetime
     */

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    /**
     * 
     * @return
     *     The countryCode
     */

    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @param countryCode
     *     The countryCode
     */

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * 
     * @return
     *     The temperature
     */

    public String getTemperature() {
        return temperature;
    }

    /**
     * 
     * @param temperature
     *     The temperature
     */

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    /**
     * 
     * @return
     *     The humidity
     */

    public Integer getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The stationName
     */

    public String getStationName() {
        return stationName;
    }

    /**
     * 
     * @param stationName
     *     The stationName
     */

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * 
     * @return
     *     The weatherCondition
     */

    public String getWeatherCondition() {
        return weatherCondition;
    }

    /**
     * 
     * @param weatherCondition
     *     The weatherCondition
     */

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    /**
     * 
     * @return
     *     The hectoPascAltimeter
     */

    public Integer getHectoPascAltimeter() {
        return hectoPascAltimeter;
    }

    /**
     * 
     * @param hectoPascAltimeter
     *     The hectoPascAltimeter
     */

    public void setHectoPascAltimeter(Integer hectoPascAltimeter) {
        this.hectoPascAltimeter = hectoPascAltimeter;
    }

    /**
     * 
     * @return
     *     The windSpeed
     */

    public String getWindSpeed() {
        return windSpeed;
    }

    /**
     * 
     * @param windSpeed
     *     The windSpeed
     */

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * 
     * @return
     *     The lat
     */

    public Double getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */

    public void setLat(Double lat) {
        this.lat = lat;
    }


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
