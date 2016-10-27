
package com.festus.refuniteandroidchallenge.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class WeatherObservation {

    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("weatherConditionCode")
    @Expose
    private String weatherConditionCode;
    @SerializedName("observation")
    @Expose
    private String observation;
    @SerializedName("ICAO")
    @Expose
    private String iCAO;
    @SerializedName("clouds")
    @Expose
    private String clouds;
    @SerializedName("dewPoint")
    @Expose
    private String dewPoint;
    @SerializedName("cloudsCode")
    @Expose
    private String cloudsCode;
    @SerializedName("datetime")
    @Expose
    private String datetime;
    @SerializedName("seaLevelPressure")
    @Expose
    private Double seaLevelPressure;
    @SerializedName("temperature")
    @Expose
    private String temperature;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("stationName")
    @Expose
    private String stationName;
    @SerializedName("weatherCondition")
    @Expose
    private String weatherCondition;
    @SerializedName("windDirection")
    @Expose
    private Integer windDirection;
    @SerializedName("windSpeed")
    @Expose
    private String windSpeed;
    @SerializedName("lat")
    @Expose
    private Double lat;

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
     *     The weatherConditionCode
     */
    public String getWeatherConditionCode() {
        return weatherConditionCode;
    }

    /**
     * 
     * @param weatherConditionCode
     *     The weatherConditionCode
     */
    public void setWeatherConditionCode(String weatherConditionCode) {
        this.weatherConditionCode = weatherConditionCode;
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
     *     The seaLevelPressure
     */
    public Double getSeaLevelPressure() {
        return seaLevelPressure;
    }

    /**
     * 
     * @param seaLevelPressure
     *     The seaLevelPressure
     */
    public void setSeaLevelPressure(Double seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
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
     *     The windDirection
     */
    public Integer getWindDirection() {
        return windDirection;
    }

    /**
     * 
     * @param windDirection
     *     The windDirection
     */
    public void setWindDirection(Integer windDirection) {
        this.windDirection = windDirection;
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

}
