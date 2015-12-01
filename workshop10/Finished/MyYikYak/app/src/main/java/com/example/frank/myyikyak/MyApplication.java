package com.example.frank.myyikyak;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by franklong on 11/11/15.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);

        //change this to your own Parse IDs
        Parse.initialize(this, "OS0ipQWWKb4KEXCsj0ZYc73lPlB2POUFK5XGndUG",
                "hJNZb6sRCIKC5TX6W2Dt2EZkAleKV6ajTVdpZeH3");

    }
}
