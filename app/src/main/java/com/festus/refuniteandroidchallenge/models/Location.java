
package com.festus.refuniteandroidchallenge.models;

import java.util.ArrayList;
import java.util.List;
import com.festus.refuniteandroidchallenge.models.Geoname;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Location {

    @SerializedName("geonames")
    @Expose
    private List<Geoname> geonames = new ArrayList<Geoname>();

    /**
     * 
     * @return
     *     The geonames
     */
    public List<Geoname> getGeonames() {
        return geonames;
    }

    /**
     * 
     * @param geonames
     *     The geonames
     */
    public void setGeonames(List<Geoname> geonames) {
        this.geonames = geonames;
    }

}
