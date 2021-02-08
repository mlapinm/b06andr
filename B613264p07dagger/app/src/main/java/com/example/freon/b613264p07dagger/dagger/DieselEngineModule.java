package com.example.freon.b613264p07dagger.dagger;

import com.example.freon.b613264p07dagger.car.DieselEngine;
import com.example.freon.b613264p07dagger.car.Engine;

import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {
    private int horsePower;

    public DieselEngineModule(int horsePower) {
        this.horsePower = horsePower;
    }

    @Provides
    Engine provideEngine(){
        return new DieselEngine(horsePower);
    }
}
