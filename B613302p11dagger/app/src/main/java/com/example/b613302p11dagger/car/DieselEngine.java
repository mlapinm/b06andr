package com.example.b613302p11dagger.car;

import android.util.Log;

import javax.inject.Inject;

public class DieselEngine implements Engine {
    public static final String TAG = "Car";

    private int horsePower;

    @Inject
    public DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.d(TAG, "Diesel Engine started " + horsePower);

    }
}
