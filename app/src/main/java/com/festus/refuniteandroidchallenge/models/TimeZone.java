
package com.festus.refuniteandroidchallenge.models;

import java.util.HashMap;
import java.util.Map;
public class TimeZone {


    private String sunrise;

    private Double lng;

    private String countryCode;

    private Integer gmtOffset;

    private Integer rawOffset;

    private String sunset;

    private String timezoneId;

    private Integer dstOffset;

    private String countryName;

    private String time;

    private Double lat;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The sunrise
     */

    public String getSunrise() {
        return sunrise;
    }

    /**
     * 
     * @param sunrise
     *     The sunrise
     */

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
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
     *     The gmtOffset
     */

    public Integer getGmtOffset() {
        return gmtOffset;
    }

    /**
     * 
     * @param gmtOffset
     *     The gmtOffset
     */

    public void setGmtOffset(Integer gmtOffset) {
        this.gmtOffset = gmtOffset;
    }

    /**
     * 
     * @return
     *     The rawOffset
     */

    public Integer getRawOffset() {
        return rawOffset;
    }

    /**
     * 
     * @param rawOffset
     *     The rawOffset
     */

    public void setRawOffset(Integer rawOffset) {
        this.rawOffset = rawOffset;
    }

    /**
     * 
     * @return
     *     The sunset
     */

    public String getSunset() {
        return sunset;
    }

    /**
     * 
     * @param sunset
     *     The sunset
     */

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    /**
     * 
     * @return
     *     The timezoneId
     */

    public String getTimezoneId() {
        return timezoneId;
    }

    /**
     * 
     * @param timezoneId
     *     The timezoneId
     */

    public void setTimezoneId(String timezoneId) {
        this.timezoneId = timezoneId;
    }

    /**
     * 
     * @return
     *     The dstOffset
     */

    public Integer getDstOffset() {
        return dstOffset;
    }

    /**
     * 
     * @param dstOffset
     *     The dstOffset
     */

    public void setDstOffset(Integer dstOffset) {
        this.dstOffset = dstOffset;
    }

    /**
     * 
     * @return
     *     The countryName
     */

    public String getCountryName() {
        return countryName;
    }

    /**
     * 
     * @param countryName
     *     The countryName
     */

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * 
     * @return
     *     The time
     */

    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */

    public void setTime(String time) {
        this.time = time;
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
