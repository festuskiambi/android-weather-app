package com.festus.refuniteandroidchallenge.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by festus on 10/27/16.
 */

public class CheckConnectivity {
    public  static boolean checkConnectivity(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null)
            return false;
        NetworkInfo infoMobi = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        NetworkInfo infoWifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo.State connectionMobi = NetworkInfo.State.DISCONNECTED;
        NetworkInfo.State connectionWifi = NetworkInfo.State.DISCONNECTED;
        if (infoMobi != null)
            connectionMobi = infoMobi.getState();
        if (infoWifi != null)
            connectionWifi = infoWifi.getState();
        return (connectionMobi == NetworkInfo.State.CONNECTED) || (connectionWifi == NetworkInfo.State.CONNECTED);
    }
}
