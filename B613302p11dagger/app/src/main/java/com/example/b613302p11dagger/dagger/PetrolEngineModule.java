package com.example.b613302p11dagger.dagger;

import com.example.b613302p11dagger.car.Engine;
import com.example.b613302p11dagger.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}
