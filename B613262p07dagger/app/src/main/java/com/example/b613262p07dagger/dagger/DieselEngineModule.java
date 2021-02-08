package com.example.b613262p07dagger.dagger;

import com.example.b613262p07dagger.car.DieselEngine;
import com.example.b613262p07dagger.car.Engine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DieselEngineModule {

    @Binds
    abstract Engine bindEngine(DieselEngine engine);
}
