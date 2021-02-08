package com.example.b613282p09dagger.dagger;

import com.example.b613282p09dagger.car.Rims;
import com.example.b613282p09dagger.car.Tires;
import com.example.b613282p09dagger.car.Wheels;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelModule {

    @Provides
    static Rims provideRims(){
        return  new Rims();
    }

    @Provides
    static Tires provideTires(){
        Tires tires = new Tires();
        tires.inflate();
        return new Tires();
    }

    @Provides
    static Wheels provideWheels(Rims rims, Tires tires){
        return new Wheels(rims, tires);

    }


}
