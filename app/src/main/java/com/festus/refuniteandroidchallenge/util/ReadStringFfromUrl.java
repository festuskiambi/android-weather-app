package com.festus.refuniteandroidchallenge.util;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by festus on 10/27/16.
 */

public class ReadStringFfromUrl {
 public String reguest;

    OkHttpClient client = new OkHttpClient();

    // code request code here
    public String doGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();


    }
}
