package com.example.b613262p07dagger.dagger;


import com.example.b613262p07dagger.car.Engine;
import com.example.b613262p07dagger.car.PetrolEngine;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract Engine bindEngine(PetrolEngine engine);
}
