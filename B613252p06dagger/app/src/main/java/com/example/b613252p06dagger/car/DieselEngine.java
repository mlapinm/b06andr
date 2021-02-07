package com.example.b613252p06dagger.car;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements Engine {
    public static final String TAG = "Car";

    @Inject
    public DieselEngine() {

    }

    @Override
    public void start() {
        Log.d(TAG, "Diesel Engine started");

    }
}
