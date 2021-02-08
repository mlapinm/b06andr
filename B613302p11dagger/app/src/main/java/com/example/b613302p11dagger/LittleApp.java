package com.example.b613302p11dagger;

import android.app.Application;

import com.example.b613302p11dagger.dagger.AppComponent;
import com.example.b613302p11dagger.dagger.DaggerAppComponent;
//import com.example.b613302p11dagger.dagger.DaggerAppComponent;


public class LittleApp extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
