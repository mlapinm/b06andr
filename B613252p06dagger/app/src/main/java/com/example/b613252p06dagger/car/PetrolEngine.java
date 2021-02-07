package com.example.b613252p06dagger.car;

import android.util.Log;

import javax.inject.Inject;

public class PetrolEngine implements Engine {
    public static final String TAG = "Car";

    @Inject
    public PetrolEngine() {
    }

    @Override
    public void start() {
        Log.d(TAG, "Petrol Engine started");

    }
}
