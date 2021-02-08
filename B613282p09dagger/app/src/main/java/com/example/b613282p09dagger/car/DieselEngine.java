package com.example.b613282p09dagger.car;

import android.util.Log;

public class DieselEngine implements Engine {
    public static final String TAG = "Car";

    private int horsePower;

    public DieselEngine(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void start() {
        Log.d(TAG, "Diesel Engine started " + horsePower);

    }
}
