package com.example.freon.b613264p07dagger.car;

import android.util.Log;

import javax.inject.Inject;

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
