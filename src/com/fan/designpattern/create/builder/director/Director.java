package com.fan.designpattern.create.builder.director;

import com.fan.designpattern.create.builder.builders.Builder;
import com.fan.designpattern.create.builder.cars.Type;
import com.fan.designpattern.create.builder.components.Engine;
import com.fan.designpattern.create.builder.components.GPSNavigator;
import com.fan.designpattern.create.builder.components.Transmission;
import com.fan.designpattern.create.builder.components.TripComputer;

/**
 * @Description :
 * @Author : shulin.fan
 * @Date : 2020/7/30
 */
public class Director {
    public void constructSportsCar(Builder builder) {
        builder.setType(Type.SPORTS_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(3.0, 0));
        builder.setTransmission(Transmission.SEMI_AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructCityCar(Builder builder) {
        builder.setType(Type.CITY_CAR);
        builder.setSeats(2);
        builder.setEngine(new Engine(1.2, 0));
        builder.setTransmission(Transmission.AUTOMATIC);
        builder.setTripComputer(new TripComputer());
        builder.setGPSNavigator(new GPSNavigator());
    }

    public void constructSUV(Builder builder) {
        builder.setType(Type.SUV);
        builder.setSeats(4);
        builder.setEngine(new Engine(2.5, 0));
        builder.setTransmission(Transmission.MANUAL);
        builder.setGPSNavigator(new GPSNavigator());
    }
}
