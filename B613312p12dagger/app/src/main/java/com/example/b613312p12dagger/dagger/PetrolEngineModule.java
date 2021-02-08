package com.example.b613312p12dagger.dagger;

import com.example.b613312p12dagger.car.Engine;
import com.example.b613312p12dagger.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}
